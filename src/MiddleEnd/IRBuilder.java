package MiddleEnd;

import AST.*;
import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRoperand.*;
import MiddleEnd.Instruction.*;
import MiddleEnd.TypeSystem.*;
import Utils.GlobalScope;

import javax.swing.text.DefaultEditorKit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;


public class IRBuilder implements ASTVisitor {
    public IRModule targetModule;
    public HashMap<String, IRType> typeTable;
    public HashMap<String, IRFunction> funcTable;
    public HashMap<String, StringConstant> stringTable;

    public LinkedList<VarDefNode> GlobalInit;

    public enum Operator {add, sub, mul, sdiv, srem, shl, ashr, and, or, xor, logic_and, logic_or, eq, ne, sgt, sge, slt, sle, assign}

    public GlobalScope gScope;
    public IRScope cScope;

    public StructType curClass;

    public IRBasicBlock curBlock;

    public IRFunction curFunction;

    private final Stack<IRBasicBlock> loopContinue;
    private final Stack<IRBasicBlock> loopBreak;

    public IRBuilder(IRModule module, GlobalScope gScope_) {
        this.gScope = gScope_;
        this.cScope = new IRScope(null, IRScope.scopeType.Global);
        this.targetModule = module;
        this.typeTable = new HashMap<>();
        this.funcTable = new HashMap<>();
        this.stringTable = new HashMap<>();
        this.GlobalInit = new LinkedList<>();
        this.loopContinue = new Stack<>();
        this.loopBreak = new Stack<>();
        gScope.Class_Table.forEach((className, classScope) -> {
            switch (className) {
                case "int" -> typeTable.put("int", new IntegerType(32));
                case "bool" -> typeTable.put("bool", new BoolType());
                case "string" -> typeTable.put("string", new PointerType(new IntegerType(8)));
                default -> {
                    StructType newClass = new StructType(className);
                    typeTable.put(className, new PointerType(newClass));
                    targetModule.addClassType(newClass);
                }
            }
        });
        typeTable.put("void", new VoidType());
        gScope.Function_Table.forEach((funcName, funcNode) -> {
            FunctionType funcType = new FunctionType(getType(funcNode.funcType));
            if (funcNode.parameter != null) {
                funcNode.parameter.forEach(tmp -> {
                    IRType argType = getType(tmp.varType);
                    funcType.addParameters(argType, tmp.identifier);
                });
            }
            IRFunction func_ = new IRFunction("_f_" + funcName, funcType);
            if (funcNode.isBuiltin) func_.isBuiltin = true;
            funcTable.put(funcName, func_);
            targetModule.addFunction(func_);
        });
        gScope.Class_Table.forEach((className, classScope) -> {
            switch (className) {
                case "int", "bool" -> {
                }
                default -> {
                    IRType pendingType = typeTable.get(className).dePointed();
                    assert (pendingType instanceof StructType);//
                    if (!className.equals("string")) {
                        classScope.Variable_Table.forEach((identifier, node) -> {
                            ((StructType) pendingType).addMember(identifier, getType(node));
                        });
                    }
                    classScope.Function_Table.forEach((funcName, funcNode) -> {
                        IRType returnType = (funcNode.funcType == null) ? new VoidType() : getType(funcNode.funcType); //constructor
                        //IRType returnType = getType(funcNode.funcType);
                        FunctionType funcType = new FunctionType(returnType);
                        IRType argType = new PointerType(pendingType);//
                        funcType.addParameters(argType, "_this");//
                        if (funcNode.parameter != null) {
                            for (VarDefNode tmp : funcNode.parameter) {
                                argType = getType(tmp.varType);
                                funcType.addParameters(argType, tmp.identifier);
                            }
                        }
                        IRFunction func_ = new IRFunction("_class_" + className + "_" + funcName, funcType);
                        if (funcNode.isBuiltin) func_.isBuiltin = true;
                        funcTable.put(func_.name, func_);
                        targetModule.addFunction(func_);
                    });

                    if (!className.equals("string") && funcTable.get("_class_" + className + "_" + className) == null) { // construct function
                        FunctionType funcType = new FunctionType(new VoidType());
                        IRType argType = new PointerType(pendingType);
                        funcType.addParameters(argType, "_this");
                        IRFunction func_ = new IRFunction("_class_" + className + "_" + className, funcType);
                        func_.addParameter(new Value("_arg", argType));////????
                        IRBasicBlock onlyBlock = new IRBasicBlock(func_.name, func_);
                        new Ret(new Value("Anonymous", new VoidType()), onlyBlock);
                        funcTable.put(func_.name, func_);
                        targetModule.addFunction(func_);
                    }

                }
            }
        });
    }

    @Override
    public void visit(RootNode node) {
        node.elements.forEach(tmp -> tmp.accept(this));
    }

    @Override
    public void visit(IntConstantExprNode node) {
        //
        node.IRoperand = new IntConstant(node.value);
    }

    @Override
    public void visit(BoolConstantExprNode node) {
        //
        node.IRoperand = new BoolConstant(node.value);
    }

    @Override
    public void visit(StringConstantExprNode node) {
        //
        StringConstant stringLiteral = stringTable.get(node.value);
        if (stringLiteral == null) {
            stringLiteral = new StringConstant(node.value);
            targetModule.addString(stringLiteral);
            stringTable.put(node.value, stringLiteral);
        }
        node.IRoperand = stringLiteral;
    }

    @Override
    public void visit(VoidConstantExprNode node) {

    }

    @Override
    public void visit(NullConstantExprNode node) {
        //
        node.IRoperand = new NullConstant();
    }

    @Override
    public void visit(LambdaExprNode node) {

    }

    @Override
    public void visit(ExprStmtNode node) {
        //
        node.expr.accept(this);
    }

    @Override
    public void visit(BlockStmtNode node) {
        //
        cScope = new IRScope(cScope, IRScope.scopeType.Common);
        if (node.Stmt != null) {
            node.Stmt.forEach(tmp -> tmp.accept(this));
        }
        cScope = cScope.uproot();
    }

    @Override
    public void visit(TypeNode node) {

    }

    @Override
    public void visit(ArrayTypeNode node) {

    }

    @Override
    public void visit(ArrayAccessExprNode node) {
        //
        Value address = getAddress(node);
        assert address != null;
        node.IRoperand = memoryLoad("_array", address, curBlock);
    }

    @Override
    public void visit(VarDefStmtNode node) {
        //
        node.elements.forEach(tmp -> {
            tmp.accept(this);
        });
    }

    @Override
    public void visit(VarDefNode node) {
        //
        IRType valueType = getType(node.varType);
        Value value;
        if (cScope.parent == null) {
            value = new GlobalDef(node.identifier, valueType);
            targetModule.addGlobalDef((GlobalDef) value);
        } else {
            value = stackAlloc(node.identifier, valueType);
        }
        cScope.setVariable(node.identifier, value);
        node.IRoperand = value;
        if (node.initValue != null) {
            if (cScope.parent != null) {///////
                node.initValue.accept(this);
                Value initValue = node.initValue.IRoperand;
                if (initValue instanceof NullConstant) {
                    ((NullConstant) initValue).setType(valueType);
                }//
                if (initValue instanceof StringConstant) {
                    initValue = getStringPtr(initValue);
                }
                this.memoryStore(initValue, value);
            } else GlobalInit.add(node);
        } else {
            if (node.varType instanceof ArrayTypeNode) {
                if (cScope.parent != null) {
                    this.memoryStore(new NullConstant((PointerType) valueType), value);
                } else GlobalInit.add(node);
            }
        }
    }

    @Override
    public void visit(FuncDefNode node) {
        //
        curFunction = curClass == null ? funcTable.get(node.funcName) : funcTable.get("_" + curClass.name + "_" + node.funcName);
        FunctionType funcType = (FunctionType) curFunction.type;
        cScope = new IRScope(cScope, IRScope.scopeType.Func);
        IRBasicBlock tmpEntry = new IRBasicBlock(curFunction.name, curFunction);
        IRBasicBlock tmpExit = new IRBasicBlock(curFunction.name, curFunction);
        Value tmpReturnValue;
        if (!funcType.toString().equals("void")) {//////modify the tostring
            curFunction.returnAddress = stackAlloc("_return", funcType.returnType);
            tmpReturnValue = memoryLoad("_return", curFunction.returnAddress, tmpExit);
        } else tmpReturnValue = new Value("Anonymous", new VoidType());///////
        new Ret(tmpReturnValue, tmpExit);
        curBlock = curFunction.entryBlock();
        for (int i = 0; i < funcType.parameterName.size(); i++) {
            Value tmpArg = new Value("_arg", funcType.parameterType.get(i));
            curFunction.addParameter(tmpArg);
            Alloc realArg = this.stackAlloc(funcType.parameterName.get(i), tmpArg.type);
            this.memoryStore(tmpArg, realArg);//
            cScope.setVariable(funcType.parameterName.get(i), realArg);
        }
        if (node.funcBody.Stmt != null) {
            node.funcBody.Stmt.forEach(stmt -> stmt.accept(this));
        }
        if (curBlock.terminator == null) {//main no return -> return 0
            if (node.funcType != null && (!(funcType.toString().equals("void")))) {
                new Store(new IntConstant(0), curFunction.returnAddress, curBlock);
            }
            new Branch(curBlock, curFunction.exitBlock());
        }
        curBlock = null;
        cScope = cScope.uproot();
    }

    @Override
    public void visit(ClassDefNode node) {
        //
        assert curClass == null;
        curClass = ((StructType) typeTable.get(node.className).dePointed());
        cScope = new IRScope(cScope, IRScope.scopeType.Class);
        curClass.indexTable.forEach((identifier, index) -> {
            cScope.setVariable(identifier, new IntConstant(index));//
        });
        if (node.memberFunction != null) node.memberFunction.forEach(tmp -> tmp.accept(this));
        curClass = null;
        cScope = cScope.uproot();
    }

    @Override
    public void visit(NewExprNode node) {
        //
        Value newOperand;
        if (node.dimension > 0) {
            LinkedList<ExprNode> initList = new LinkedList<>(node.SizeList);
            newOperand = recursiveNew(initList, new PointerType(getType(node.newType), node.dimension));
        } else {
            String className = node.newType.Type;
            StructType classType = (StructType) typeTable.get(className).dePointed();
            newOperand = heapAlloc(new PointerType(classType), new IntConstant(classType.byteSize()));
            Call constructor = new Call(funcTable.get("_" + classType.name + "_" + className), curBlock);
            constructor.addOperand(newOperand);
        }
        node.IRoperand = newOperand;
    }

    @Override
    public void visit(ThisExprNode node) {
        assert curClass != null;
        Value ptr = cScope.fetchValue("_this");
        assert ptr != null;
        node.IRoperand = memoryLoad("_this", ptr, curBlock);
    }

    @Override
    public void visit(FuncCallExprNode node) {
        //
        IRFunction func = null;
        Value thisPtr = null;
        if (node.Func instanceof IdentifierExprNode) {
            String funcName = ((IdentifierExprNode) node.Func).identifier;
            if (curClass != null) func = funcTable.get("_" + curClass.name + "_" + funcName);
            if (func == null) func = funcTable.get(funcName);
            else {
                thisPtr = cScope.fetchValue("_this");
                assert thisPtr != null;
                thisPtr = memoryLoad("_this", thisPtr, curBlock);
            }
        } else {
            assert node.Func instanceof ObjMemExprNode;
            ((ObjMemExprNode) node.Func).base.accept(this);
            thisPtr = ((ObjMemExprNode) node.Func).base.IRoperand;
            if (((ObjMemExprNode) node.Func).base.exprType instanceof ArrayTypeNode) {
                node.IRoperand = arraySize(thisPtr);
                return;
            }
            String className;
            IRType classType = thisPtr.type.dePointed();
            if (classType instanceof StructType) className = ((StructType) classType).name;
            else {
                assert classType instanceof IntegerType;
                className = "class_string";
            }
            func = funcTable.get("_" + className + "_" + ((ObjMemExprNode) node.Func).member);
        }
        assert func != null;
        if (node.List != null) {
            for (int i = 0; i < node.List.size(); i++) {
                ASTNode tmp = node.List.get(i);
                tmp.accept(this);
                Value tmpArg = tmp.IRoperand;
                if (tmpArg instanceof StringConstant) {
                    tmpArg = getStringPtr(tmpArg);
                }
                if (tmpArg instanceof NullConstant) {
                    ((NullConstant) tmpArg).setType(((FunctionType) func.type).parameterType.get(i));
                }
                tmp.IRoperand = tmpArg; //arrayList will also be modified
            }
        }
        Call newOperand = new Call(func, curBlock);
        if (thisPtr != null) {
            newOperand.addOperand(thisPtr);
        }
        if (node.List != null) {
            node.List.forEach(tmp -> newOperand.addOperand(tmp.IRoperand));
        }
        func.isUsed = true;
        node.IRoperand = newOperand;
    }

    @Override
    public void visit(ReturnStmtNode node) {
        //
        if (node.expr != null) {
            Value returnValue;
            node.expr.accept(this);
            returnValue = node.expr.IRoperand;
            if (returnValue instanceof StringConstant) {
                returnValue = getStringPtr(returnValue);
            }
            if (returnValue instanceof NullConstant) {
                ((NullConstant) returnValue).setType(((FunctionType) curFunction.type).returnType);
            }
            this.memoryStore(returnValue, curFunction.returnAddress);
        }
        new Branch(curBlock, curFunction.exitBlock());
        //
    }

    @Override
    public void visit(ObjMemExprNode node) {
        //
        node.base.accept(this);
        Value baseAddress = node.base.IRoperand;
        StructType baseType = (StructType) baseAddress.type.dePointed();
        Gep newOperand = new Gep(new PointerType(baseType.typeTable.get(node.member)), baseAddress, curBlock);
        newOperand.addIndex(new IntConstant(0)).addIndex(new IntConstant(baseType.indexTable.get(node.member)));
        node.IRoperand = memoryLoad(node.member, newOperand, curBlock);
    }

    @Override
    public void visit(BinaryExprNode node) {
        IRBuilder.Operator op = translateOp(node.operator);
        Value newOperand = null;
        if (op == Operator.logic_and || op == Operator.logic_or) {
            node.LOperand.accept(this);
            Value tmpRs1 = node.LOperand.IRoperand;
            switch (op) {
                case logic_and -> {
                    if (tmpRs1 instanceof BoolConstant) {
                        if (!((BoolConstant) tmpRs1).value) newOperand = tmpRs1;
                        else {
                            node.ROperand.accept(this);
                            newOperand = node.ROperand.IRoperand;
                        }
                    } else newOperand = shortCircuit(op, node, tmpRs1);
                }
                case logic_or -> {
                    if (tmpRs1 instanceof BoolConstant) {
                        if (((BoolConstant) tmpRs1).value) newOperand = tmpRs1;
                        else {
                            node.ROperand.accept(this);
                            newOperand = node.ROperand.IRoperand;
                        }
                    } else newOperand = shortCircuit(op, node, tmpRs1);
                }
            }
        } else {
            node.ROperand.accept(this);
            Value tmpRs2 = node.ROperand.IRoperand;
            if (op != Operator.assign) {
                node.LOperand.accept(this);
                Value tmpRs1 = node.LOperand.IRoperand;
                if (tmpRs1 instanceof StringConstant) {
                    tmpRs1 = getStringPtr(tmpRs1);
                }
                if (tmpRs2 instanceof StringConstant) {
                    tmpRs2 = getStringPtr(tmpRs2);
                }
                if (tmpRs1 instanceof IRConstant && tmpRs2 instanceof IRConstant) {
                    newOperand = calculateConstant(op, (IRConstant) tmpRs1, (IRConstant) tmpRs2);
                } else {
                    if (tmpRs1.type.isEqual(new PointerType(new IntegerType(8)))) {////
                        assert tmpRs2.type.isEqual(new PointerType(new IntegerType(8)));
                        newOperand = callStringOperator(op, tmpRs1, tmpRs2);
                    } else {
                        switch (op) {////
                            case add, sub, mul, sdiv, srem, shl, ashr, and, or, xor ->
                                    newOperand = new Binary(op, tmpRs1, tmpRs2, curBlock);
                            case eq, ne, sgt, sge, slt, sle -> {
                                if (tmpRs2 instanceof NullConstant) ((NullConstant) tmpRs2).setType(tmpRs1.type);
                                newOperand = new Icmp(op, tmpRs1, tmpRs2, curBlock);
                                newOperand = new Zext(newOperand, new BoolType(), curBlock);
                            }
                            default -> throw new RuntimeException("wrong op");
                        }

                    }
                }
            } else {
                Value address = getAddress(node.LOperand);
                assert address != null;
                if (tmpRs2 instanceof NullConstant) {
                    ((NullConstant) tmpRs2).setType(address.type.dePointed());
                }
                if (tmpRs2 instanceof StringConstant) {
                    tmpRs2 = getStringPtr(tmpRs2);
                }
                newOperand = tmpRs2;
                this.memoryStore(newOperand, address);
            }
        }
        node.IRoperand = newOperand;
    }

    @Override
    public void visit(MonocularExprNode node) {
        //
        node.operand.accept(this);
        Value originValue = node.operand.IRoperand;
        Value newOperand = originValue;
        switch (node.operator) {
            case LNOT, BITNOT, POS, NEG -> {
                if (originValue instanceof IRConstant) {
                    switch (node.operator) {
                        case LNOT -> newOperand = new BoolConstant(!((BoolConstant) originValue).value);
                        case BITNOT -> newOperand = new IntConstant(~((IntConstant) originValue).value);
                        case POS -> {
                        }
                        case NEG -> newOperand = new IntConstant(-((IntConstant) originValue).value);
                    }
                } else {
                    switch (node.operator) {
                        case LNOT ->
                                newOperand = new Binary(Operator.xor, originValue, new BoolConstant(true), curBlock);
                        case BITNOT ->
                                newOperand = new Binary(Operator.xor, originValue, new IntConstant(-1), curBlock);
                        case POS -> {
                        }
                        case NEG -> newOperand = new Binary(Operator.sub, new IntConstant(0), originValue, curBlock);
                    }
                }
            }
            case PREINC, PREDEC, AFTINC, AFTDEC -> {//
                Value address = getAddress(node.operand);
                Value newValue = null;
                switch (node.operator) {
                    case PREINC ->
                            newValue = newOperand = new Binary(Operator.add, originValue, new IntConstant(1), curBlock);
                    case PREDEC ->
                            newValue = newOperand = new Binary(Operator.add, originValue, new IntConstant(-1), curBlock);
                    case AFTINC -> newValue = new Binary(Operator.add, originValue, new IntConstant(1), curBlock);
                    case AFTDEC -> newValue = new Binary(Operator.add, originValue, new IntConstant(-1), curBlock);
                }
                //
                this.memoryStore(newValue, address);
            }
        }
        node.IRoperand = newOperand;
    }

    @Override
    public void visit(IdentifierExprNode node) {
        //
        node.IRoperand = memoryLoad(node.identifier, getAddress(node), curBlock);
    }

    @Override
    public void visit(IfStmtNode node) {
        //
        node.IRoperand = null;
        cScope = new IRScope(cScope, IRScope.scopeType.Flow); ///
        IRBasicBlock thenBlock = new IRBasicBlock("if_then", curFunction);
        IRBasicBlock termBlock = new IRBasicBlock(curFunction.name, curFunction);//
        node.condition.accept(this);
        if (node.elseStmt != null) {
            IRBasicBlock elseBlock = new IRBasicBlock("if_else", curFunction);
            addControl(curBlock, node.condition.IRoperand, thenBlock, elseBlock);/////
            curBlock = elseBlock;
            node.elseStmt.accept(this);
            new Branch(curBlock, termBlock);//
        } else addControl(curBlock, node.condition.IRoperand, thenBlock, termBlock);
        curBlock = thenBlock;
        node.thenStmt.accept(this);
        new Branch(curBlock, termBlock);
        curBlock = termBlock;
        cScope = cScope.uproot();
    }

    @Override
    public void visit(WhileStmtNode node) {
        //
        node.IRoperand = null;
        cScope = new IRScope(cScope, IRScope.scopeType.Flow);//
        IRBasicBlock condition = new IRBasicBlock("while_condition", curFunction);
        IRBasicBlock loopBody = new IRBasicBlock("while_body", curFunction);
        IRBasicBlock termBlock = new IRBasicBlock(curFunction.name, curFunction);
        this.pushStack(condition, termBlock);
        new Branch(curBlock, condition);
        curBlock = condition;
        node.condition.accept(this);
        addControl(curBlock, node.condition.IRoperand, loopBody, termBlock);
        curBlock = loopBody;
        node.loopBody.accept(this);
        new Branch(curBlock, condition);
        curBlock = termBlock;
        this.popStack();
        cScope = cScope.uproot();
    }

    @Override
    public void visit(ForStmtNode node) {
        //
        node.IRoperand = null;
        cScope = new IRScope(cScope, IRScope.scopeType.Flow);
        if (node.init != null) node.init.accept(this);
        IRBasicBlock condition = new IRBasicBlock("for_condition", curFunction);
        IRBasicBlock iter = new IRBasicBlock("for_iter", curFunction);
        IRBasicBlock loopBody = new IRBasicBlock("for_body", curFunction);
        IRBasicBlock termBody = new IRBasicBlock(curFunction.name, curFunction);
        this.pushStack(iter, termBody);
        new Branch(curBlock, condition);
        curBlock = condition;
        if (node.condition != null) {
            node.condition.accept(this);
            addControl(curBlock, node.condition.IRoperand, loopBody, termBody);
        } else new Branch(curBlock, loopBody);
        curBlock = loopBody;
        if (node.loopBody != null) {
            node.loopBody.accept(this);
        }
        new Branch(curBlock, iter);
        curBlock = iter;
        if (node.incr != null) {
            node.incr.accept(this);
        }
        new Branch(curBlock, condition);
        curBlock = termBody;
        this.popStack();
        cScope = cScope.uproot();
    }

    @Override
    public void visit(ContinueStmtNode node) {
        //
        new Branch(curBlock, loopContinue.peek());
        //
    }

    @Override
    public void visit(BreakStmtNode node) {
        //
        new Branch(curBlock, loopBreak.peek());
        //
    }

    private void pushStack(IRBasicBlock cBlock, IRBasicBlock bBlock) {
        loopContinue.push(cBlock);
        loopBreak.push(bBlock);
    }

    private void popStack() {
        loopContinue.pop();
        loopBreak.pop();
    }

    private Alloc stackAlloc(String name, IRType type) {
        return new Alloc(name, type, curFunction.entryBlock());
    }

    private Value memoryLoad(String identifier, Value address, IRBasicBlock block) {
        return new Load(identifier, address, block);
    }

    private void memoryStore(Value value, Value address) {
        new Store(value, address, curBlock);
    }

    public Value getStringPtr(Value raw) {///
        assert raw instanceof StringConstant;
        Gep ptr = new Gep(new PointerType(new IntegerType(8)), raw, curBlock);
        ptr.addIndex(new IntConstant(0)).addIndex(new IntConstant(0));///
        return ptr;
    }

    public IRType getType(TypeNode node_) {
        IRType returnType = typeTable.get(node_.Type);
        if (node_ instanceof ArrayTypeNode) {
            returnType = new PointerType(returnType, ((ArrayTypeNode) node_).dimension);
        }
        return returnType;
    }

    private void addControl(IRBasicBlock cBlock, Value flag, IRBasicBlock tBlock, IRBasicBlock fBlock) {
        //assert
        Value condition = new Trunc(flag, new IntegerType(1), cBlock);////
        new Branch(cBlock, condition, tBlock, fBlock);
    }

    private Value heapAlloc(IRType targetType, Value byteSize) {
        IRFunction malloc = funcTable.get("_malloc");
        Value returnValue = new Call(malloc, curBlock);
        ((Call) returnValue).addOperand(byteSize);
        malloc.isUsed = true;
        if (!targetType.isEqual(returnValue.type)) returnValue = new Bitcast(returnValue, targetType, curBlock);
        return returnValue;
    }

    private Value recursiveNew(LinkedList<ExprNode> initList, IRType targetType) {
        IRType elementType = targetType.dePointed();
        initList.getFirst().accept(this);
        Value elementNumber = initList.getFirst().IRoperand;
        initList.removeFirst();
        Value elementByteSize = new Binary(Operator.mul, elementNumber, new IntConstant(elementType.byteSize()), curBlock);
        Value totalByteSize = new Binary(Operator.add, elementByteSize, new IntConstant(4), curBlock);
        Value i32Pointer = heapAlloc(new PointerType(new IntegerType(32)), totalByteSize);
        this.memoryStore(elementNumber, i32Pointer);
        Gep biasPointer = new Gep(new PointerType(new IntegerType(32)), i32Pointer, curBlock);
        biasPointer.addIndex(new IntConstant(1));
        Value realPointer = new Bitcast(biasPointer, targetType, curBlock);
        if (initList.size() == 0) return realPointer;
        Value ptrAddress = this.stackAlloc("array_ptr", new IntegerType(32));
        this.memoryStore(new IntConstant(0), ptrAddress);
        IRBasicBlock condition = new IRBasicBlock("array_new_condition", curFunction);
        IRBasicBlock loopBody = new IRBasicBlock("array_new_body", curFunction);
        IRBasicBlock termBlock = new IRBasicBlock(curFunction.name, curFunction);
        new Branch(curBlock, condition);
        curBlock = condition;
        Value ptr = this.memoryLoad("array_ptr", ptrAddress, curBlock);
        Value flag = new Icmp(Operator.ne, ptr, elementNumber, curBlock);
        new Branch(curBlock, flag, loopBody, termBlock);
        curBlock = loopBody;
        Gep elementPtr = new Gep(targetType, realPointer, curBlock);
        elementPtr.addIndex(ptr);
        Value element = recursiveNew(initList, elementType);
        this.memoryStore(element, elementPtr);
        this.memoryStore(new Binary(Operator.add, ptr, new IntConstant(1), curBlock), ptrAddress);
        new Branch(curBlock, condition);
        curBlock = termBlock;
        return realPointer;
    }

    private Value shortCircuit(Operator op, BinaryExprNode node, Value tmpRs1) {////
        Value tmpAddress = this.stackAlloc(op.toString(), new BoolType());
        IRBasicBlock dBlock = new IRBasicBlock("_dBlock", curFunction);
        IRBasicBlock sBlock = new IRBasicBlock("_sBlock", curFunction);
        IRBasicBlock tBlock = new IRBasicBlock("_tBlock", curFunction);
        switch (op) {
            case logic_and -> addControl(curBlock, tmpRs1, sBlock, dBlock);
            case logic_or -> addControl(curBlock, tmpRs1, dBlock, sBlock);
        }
        this.curBlock = dBlock;
        this.memoryStore(tmpRs1, tmpAddress);
        new Branch(curBlock, tBlock);
        this.curBlock = sBlock;
        node.ROperand.accept(this);
        Value tmpRs2 = node.ROperand.IRoperand;
        this.memoryStore(tmpRs2, tmpAddress);
        new Branch(curBlock, tBlock);
        this.curBlock = tBlock;
        return this.memoryLoad("circuit", tmpAddress, curBlock);
    }

    private IRConstant calculateConstant(IRBuilder.Operator op, IRConstant rs1, IRConstant rs2) {
        assert rs1.type.isEqual(rs2.type);
        IRConstant returnValue;
        switch (op) {
            case add, sub, mul, sdiv, srem, shl, ashr, and, or, xor, logic_and, logic_or -> {
                if (rs1 instanceof IntConstant) {
                    int value1 = ((IntConstant) rs1).value;
                    int value2 = ((IntConstant) rs2).value;
                    int result;
                    switch (op) {
                        case add -> result = value1 + value2;
                        case sub -> result = value1 - value2;
                        case mul -> result = value1 * value2;
                        case sdiv -> result = value1 / value2;
                        case srem -> result = value1 % value2;
                        case and -> result = value1 & value2;
                        case or -> result = value1 | value2;
                        case xor -> result = value1 ^ value2;
                        case shl -> result = value1 << value2;
                        case ashr -> result = value1 >> value2;
                        default -> throw new RuntimeException("wrong op");
                    }
                    returnValue = new IntConstant(result);
                } else {
                    boolean value1 = ((BoolConstant) rs1).value;
                    boolean value2 = ((BoolConstant) rs2).value;
                    boolean result;
                    switch (op) {
                        case logic_and -> result = value1 && value2;
                        case logic_or -> result = value1 || value2;
                        default -> throw new RuntimeException("wrong op");
                    }
                    returnValue = new BoolConstant(result);
                }
            }
            case eq, ne, sgt, sge, slt, sle -> {
                boolean result;
                if (rs1 instanceof IntConstant) {
                    int value1 = ((IntConstant) rs1).value;
                    int value2 = ((IntConstant) rs2).value;
                    switch (op) {
                        case eq -> result = value1 == value2;
                        case ne -> result = value1 != value2;
                        case sgt -> result = value1 >= value2;
                        case sge -> result = value1 > value2;
                        case slt -> result = value1 <= value2;
                        case sle -> result = value1 < value2;
                        default -> throw new RuntimeException("wrong op");
                    }
                } else {
                    boolean value1 = ((BoolConstant) rs1).value;
                    boolean value2 = ((BoolConstant) rs2).value;
                    switch (op) {
                        case eq -> result = value1 == value2;
                        case ne -> result = value1 != value2;
                        default -> throw new RuntimeException("wrong op");
                    }
                }
                returnValue = new BoolConstant(result);
            }
            default -> throw new RuntimeException("wrong op");
        }
        return returnValue;
    }

    private Value arraySize(Value address) {////
        Value i32Pointer = new Bitcast(address, new PointerType((new IntegerType(32))), curBlock);
        Gep biasAddress = new Gep(new PointerType(new IntegerType((32))), i32Pointer, curBlock);
        biasAddress.addIndex(new IntConstant(-1));
        return memoryLoad("array_size", biasAddress, curBlock);
    }

    private Value getAddress(ASTNode node) {
        if (node instanceof IdentifierExprNode) {
            String identifier = ((IdentifierExprNode) node).identifier;
            Value returnValue = cScope.fetchValue(identifier);
            if (cScope.isClass(identifier)) {
                assert curClass != null;
                assert curFunction != null;
                Value ptr = cScope.fetchValue("_this");
                assert ptr != null;
                ptr = memoryLoad("_this", ptr, curBlock);
                returnValue = new Gep(new PointerType(curClass.typeTable.get(identifier)), ptr, curBlock);
                ((Gep) returnValue).addIndex(new IntConstant(0)).addIndex(new IntConstant(curClass.indexTable.get(identifier)));
            }
            return returnValue;
        } else if (node instanceof ObjMemExprNode) {
            ((ObjMemExprNode) node).base.accept(this);
            Value baseAddress = ((ObjMemExprNode) node).base.IRoperand;
            StructType baseType = (StructType) baseAddress.type.dePointed();
            Gep returnValue = new Gep(new PointerType(baseType.typeTable.get(((ObjMemExprNode) node).member)), baseAddress, curBlock);
            returnValue.addIndex(new IntConstant(0)).addIndex(new IntConstant(baseType.indexTable.get(((ObjMemExprNode) node).member)));
            return returnValue;
        } else if (node instanceof ArrayAccessExprNode) {
            Value ptrAddress = getAddress(((ArrayAccessExprNode) node).array);
            Value address = memoryLoad("_array", ptrAddress, curBlock);
            ((ArrayAccessExprNode) node).index.accept(this);
            Gep biasAddress = new Gep(address.type, address, curBlock);
            biasAddress.addIndex(((ArrayAccessExprNode) node).index.IRoperand);
            return biasAddress;
        } else if (node instanceof MonocularExprNode) {
            return getAddress(((MonocularExprNode) node).operand);
        } else throw new RuntimeException("wrong node to get address");
    }

    private Value callStringOperator(Operator op, Value str1, Value str2) {
        assert str1.type.isEqual(new PointerType(new IntegerType(8))) && str2.type.isEqual(new PointerType((new IntegerType(8))));
        Call returnValue;
        IRFunction calledFunction;
        switch (op) {
            case add -> returnValue = new Call(calledFunction = funcTable.get("_str_splice"), curBlock);
            case eq -> returnValue = new Call(calledFunction = funcTable.get("_str_eq"), curBlock);
            case ne -> returnValue = new Call(calledFunction = funcTable.get("_str_ne"), curBlock);
            case slt -> returnValue = new Call(calledFunction = funcTable.get("_str_slt"), curBlock);
            case sle -> returnValue = new Call(calledFunction = funcTable.get("_str_sle"), curBlock);
            case sgt -> returnValue = new Call(calledFunction = funcTable.get("_str_sgt"), curBlock);
            case sge -> returnValue = new Call(calledFunction = funcTable.get("_str_sge"), curBlock);
            default -> throw new RuntimeException("wrong op");
        }
        calledFunction.isUsed = true;
        returnValue.addOperand(str1);
        returnValue.addOperand(str2);
        return returnValue;
    }

    private IRBuilder.Operator translateOp(BinaryExprNode.Op origin) {
        switch (origin) {
            case ADD -> {
                return Operator.add;
            }
            case SUB -> {
                return Operator.sub;
            }
            case MUL -> {
                return Operator.mul;
            }
            case DIV -> {
                return Operator.sdiv;
            }
            case MOD -> {
                return Operator.srem;
            }
            case SHL -> {
                return Operator.shl;
            }
            case SHR -> {
                return Operator.ashr;
            }
            case AND -> {
                return Operator.and;
            }
            case XOR -> {
                return Operator.xor;
            }
            case OR -> {
                return Operator.or;
            }
            case LAND -> {
                return Operator.logic_and;
            }
            case LOR -> {
                return Operator.logic_or;
            }
            case GT -> {
                return Operator.sgt;
            }
            case LT -> {
                return Operator.slt;
            }
            case GE -> {
                return Operator.sge;
            }
            case LE -> {
                return Operator.sle;
            }
            case EQ -> {
                return Operator.eq;
            }
            case NE -> {
                return Operator.ne;
            }
            case ASSIGN -> {
                return Operator.assign;
            }
            default -> throw new RuntimeException("[Debug] unknown operator.");
        }
    }

    public void processGlobalInit() {
        if (GlobalInit.size() == 0) return;
        FunctionType tmpType = new FunctionType(new VoidType());
        IRFunction entryFunction = new IRFunction("_GLOBAL_", tmpType);
        IRBasicBlock mainBody = new IRBasicBlock(entryFunction.name, entryFunction);
        this.GlobalInit.forEach(node -> {
            IRType valueTy = getType(node.varType);
            IRFunction nowFunction = new IRFunction("_global_var_init", tmpType);
            Value address = cScope.fetchValue(node.identifier);
            this.curFunction = nowFunction;
            this.curBlock = new IRBasicBlock(node.identifier, curFunction);
            IRBasicBlock tmpExit = new IRBasicBlock(node.identifier, curFunction);
            new Ret(new Value("Anonymous", new VoidType()), tmpExit);
            Value initValue;
            if (node.initValue == null) {//array_type
                initValue = new NullConstant();
            } else {
                node.initValue.accept(this);
                initValue = node.initValue.IRoperand;
            }
            if (initValue instanceof NullConstant) {
                ((NullConstant) initValue).setType(valueTy);
            }
            if (initValue instanceof StringConstant) {
                initValue = getStringPtr(initValue);
            }
            this.memoryStore(initValue, address);
            new Branch(curBlock, tmpExit);
            this.targetModule.addGlobalInit(curFunction);
            new Call(nowFunction, mainBody);
        });
        new Ret(new Value("Anonymous", new VoidType()), mainBody);
        this.targetModule.addGlobalInit(entryFunction);
    }
}

