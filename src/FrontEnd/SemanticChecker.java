package FrontEnd;

import AST.*;
import Utils.GlobalScope;
import Utils.Position;
import Utils.Scope;
import Utils.SemanticError;

import java.util.ArrayList;
import java.util.Stack;

public class SemanticChecker implements ASTVisitor {
    public Scope cScope;
    public GlobalScope gScope;
    //private final TypeNode TypeNull, TypeVoid, TypeInt, TypeBool, TypeString;
    private String nowClass;
    public FuncDefNode FuncSize;
    public Stack<ASTNode> FuncStation;
    public int loops;

    public SemanticChecker(GlobalScope gScope_) {
        this.gScope = gScope_;
        this.cScope = gScope_;
        Position defaultPosition = new Position(-1, -1);
        /*TypeNull = new TypeNode("null", defaultPosition);
        TypeVoid = new TypeNode("void", defaultPosition);
        TypeInt = new TypeNode("int", defaultPosition);
        TypeBool = new TypeNode("bool", defaultPosition);
        TypeString = new TypeNode("string", defaultPosition);*/
        nowClass = null;
        FuncStation = new Stack<>();
        loops = 0;
        FuncSize = new FuncDefNode(new TypeNode("int", defaultPosition), "size", null, null, defaultPosition);
    }

    public void visit(RootNode node) {
        node.elements.forEach(tmp -> {
            if (tmp instanceof ClassDefNode || tmp instanceof VarDefStmtNode)
                tmp.accept(this);
        });
        node.elements.forEach(tmp -> {
            if (tmp instanceof FuncDefNode)
                tmp.accept(this);
        });
    }

    public void visit(VarDefNode node) {
        /*if (cScope.contains_Variable(node.identifier) || gScope.contains_Variable(node.identifier)) {
            throw new SemanticError("Duplicate Variable definition of " + node.identifier, node.getPos());
        }*/
        if (cScope == gScope) {
            if (gScope.contains_Variable(node.identifier)) {
                throw new SemanticError("Duplicate Variable definition of " + node.identifier, node.getPos());
            }
        } else {
            if (cScope.contains_Variable(node.identifier)) {
                throw new SemanticError("Duplicate Variable definition of " + node.identifier, node.getPos());
            }
        }
        if (!gScope.contains_Class(node.varType.Type)) {
            throw new SemanticError("Undefined type " + node.varType.Type, node.getPos());
        }
        if (node.initValue != null) {
            node.initValue.accept(this);
            if (!node.initValue.exprType.Type.equals("null") && !node.initValue.exprType.Type.equals(node.varType.Type)) {
                throw new SemanticError("Mismatched Type in variableDefine of " + node.identifier, node.getPos());
            }
        }
        cScope.define_Variable(node.identifier, node.varType);
    }

    @Override
    public void visit(VarDefStmtNode node) {
        node.elements.forEach(tmp -> tmp.accept(this));
    }

    @Override
    public void visit(ClassDefNode node) {
        cScope = gScope.Class_Table.get(node.className);
        nowClass = node.className;
        //node.memberVariable.forEach(tmp -> tmp.accept(this));
        for (VarDefStmtNode List : node.memberVariable) {
            for (VarDefNode tmp : List.elements) {
                if (!gScope.contains_Class(tmp.varType.Type)) {
                    throw new SemanticError("Undefined class " + tmp.varType.Type + " in " + node.className, node.getPos());
                }
                if (tmp.initValue != null) {
                    tmp.initValue.accept(this);
                    if (!tmp.initValue.exprType.Type.equals("null") && !tmp.initValue.exprType.Type.equals(tmp.varType.Type)) {
                        throw new SemanticError("Mismatched class type in initial assignment", node.getPos());
                    }
                }
            }
        }
        node.memberFunction.forEach(tmp -> tmp.accept(this));
        nowClass = null;
        cScope = cScope.parent;
    }

    @Override
    public void visit(FuncDefNode node) {
        cScope = new Scope(cScope);
        FuncStation.push(node);
        if (node.funcType != null && !node.funcType.Type.equals("void") && !gScope.contains_Class(node.funcType.Type)) {
            throw new SemanticError("Undefined Function Return Type " + node.funcType.Type, node.getPos());
        }
        if (node.parameter != null) {
            node.parameter.forEach(tmp -> tmp.accept(this));
        }
        if (node.funcBody.Stmt != null) {
            node.funcBody.Stmt.forEach(tmp -> tmp.accept(this));
        }
        if (node.funcType != null && !node.funcType.Type.equals("void") && !node.funcName.equals("main") && !node.hasReturn) {
            throw new SemanticError("Function " + node.funcName + " has no return", node.getPos());
        }
        if (node.funcName.equals("main") && !node.hasReturn) {
            if (node.funcBody.Stmt == null) node.funcBody.Stmt = new ArrayList<>();
            node.funcBody.Stmt.add(new ReturnStmtNode(new IntConstantExprNode(0, new Position(-1, -1)), new Position(-1, -1)));
        }
        FuncStation.pop();
        cScope = cScope.parent;
    }

    @Override
    public void visit(LambdaExprNode node) {
        cScope = new Scope(cScope);
        FuncStation.push(node);
        if (node.parameter != null) {
            node.parameter.forEach(tmp -> tmp.accept(this));
        }
        if (node.list != null) {
            node.list.forEach(tmp -> tmp.accept(this));
        }
        if (node.parameter == null || node.list == null) {
            if (!(node.parameter == null && node.list == null)) {
                throw new SemanticError("Wrong parameter in Calling Lambda Function", node.getPos());
            }
        } else {
            if (node.parameter.size() != node.list.size()) {
                throw new SemanticError("Wrong parameter in Calling Lambda Function", node.getPos());
            }
            for (int i = 0; i < node.parameter.size(); i++) {
                if (node.parameter.get(i).varType.Type.equals(node.list.get(i).exprType.Type)) {
                    throw new SemanticError("Wrong parameter in Calling Lambda Function", node.getPos());
                }
            }
        }
        node.block.accept(this);
        /*if (node.ReturnType == null) {
            throw new SemanticError("Lambda should have at least one return", node.getPos());
        }*/
        /*if (node.ReturnType == null)
            node.exprType = new TypeNode("void", new Position(-1, -1));*/
        node.exprType = node.ReturnType;
        node.isAssignable = false;
        FuncStation.pop();
        cScope = cScope.parent;
    }

    @Override
    public void visit(IdentifierExprNode node) {
        TypeNode idType = cScope.fetch_Variable_Type(node.identifier);
        if (idType == null) {
            idType = gScope.fetch_Variable_Type(node.identifier);
            if (idType == null)
                throw new SemanticError("Undefined variable " + node.identifier, node.getPos());
        }
        node.exprType = idType;
        node.isAssignable = true;
    }

    public void visit(NewExprNode node) {
        if (!gScope.contains_Class(node.newType.Type)) {
            throw new SemanticError("Undefined Type of " + node.exprType.Type, node.getPos());
        }
        if (node.SizeList != null) {
            node.SizeList.forEach(tmp -> {
                tmp.accept(this);
                if (!tmp.exprType.Type.equals("int")) {
                    throw new SemanticError("ArraySize should be int type", node.getPos());
                }
            });
        }
        if (node.dimension > 0) {
            node.exprType = new ArrayTypeNode(node.newType, node.dimension, node.getPos());
        } else node.exprType = new TypeNode(node.newType.Type, node.getPos());
        node.isAssignable = false;
    }

    @Override
    public void visit(ObjMemExprNode node) {
        node.base.accept(this);
        if (node.base.exprType instanceof ArrayTypeNode) {
            if (!node.member.equals("size")) {
                throw new SemanticError("Array has only size() built-in function", node.getPos());
            }
            node.FuncInfo = FuncSize;
        } else {
            if (node.forFunc) {
                node.FuncInfo = gScope.Class_Table.get(node.base.exprType.Type).fetch_Function(node.member);
                if (node.FuncInfo == null) {
                    throw new SemanticError("Class " + node.base.exprType.Type + " has no function called " + node.member, node.getPos());
                }
            } else {
                node.exprType = gScope.Class_Table.get(node.base.exprType.Type).Variable_Table.get(node.member);
                if (node.exprType == null) {
                    throw new SemanticError("Class " + node.base.exprType.Type + " has no variable called " + node.member, node.getPos());
                }
                node.isAssignable = true;
            }
        }
    }

    @Override
    public void visit(FuncCallExprNode node) {
        FuncDefNode checkBase = null;
        if (node.Func instanceof ObjMemExprNode) {
            ((ObjMemExprNode) node.Func).forFunc = true;
            node.Func.accept(this);
            checkBase = ((ObjMemExprNode) node.Func).FuncInfo;
        } else {
            if (!(node.Func instanceof IdentifierExprNode)) {
                throw new SemanticError("Error Expression to call function", node.getPos());
            }
            String FuncName = ((IdentifierExprNode) node.Func).identifier;
            if (nowClass == null) {
                checkBase = gScope.fetch_Function(FuncName);
            } else {
                checkBase = gScope.Class_Table.get(nowClass).fetch_Function(FuncName);
                if (checkBase == null) {
                    checkBase = gScope.fetch_Function(FuncName);
                } //? how to call? parameter?
            }
            if (checkBase == null) {
                throw new SemanticError("No function named " + FuncName + " to call", node.getPos());
            }
        }
        if (node.List != null) {
            node.List.forEach(tmp -> tmp.accept(this));
        }
        if (checkBase.parameter == null || node.List == null) {
            if (!(checkBase.parameter == null && node.List == null)) {
                throw new SemanticError("Wrong parameter in function call which called " + checkBase.funcName, node.getPos());
            }
        } else {
            if (checkBase.parameter.size() != node.List.size()) {
                throw new SemanticError("Wrong parameter in function call which called " + checkBase.funcName, node.getPos());
            }
            for (int i = 0; i < checkBase.parameter.size(); i++) {
                if (!checkBase.parameter.get(i).varType.Type.equals(node.List.get(i).exprType.Type) && !node.List.get(i).exprType.Type.equals("null") && !node.List.get(i).exprType.Type.equals("void")) {
                    throw new SemanticError("Wrong parameter in function call which called " + checkBase.funcName, node.getPos());
                }
            }
        }
        node.exprType = checkBase.funcType;
        node.isAssignable = false;
    }

    @Override
    public void visit(ArrayAccessExprNode node) {
        node.array.accept(this);
        if (!(node.array.exprType instanceof ArrayTypeNode)) {
            throw new SemanticError("Try to index not Array Type of "/* + ((IdentifierExprNode) node.array).identifier*/, node.getPos());
        }
        node.index.accept(this);
        if (!node.index.exprType.Type.equals("int")) {
            throw new SemanticError("Array index should be int type", node.getPos());
        }
        if (((ArrayTypeNode) node.array.exprType).dimension == 1) {
            node.exprType = new TypeNode(node.array.exprType.Type, node.getPos());
        } else {
            node.exprType = new ArrayTypeNode(node.array.exprType, ((ArrayTypeNode) node.array.exprType).dimension - 1, node.getPos());
        }
        node.isAssignable = true;
    }

    @Override
    public void visit(MonocularExprNode node) {
        node.operand.accept(this);
        if (node.operator != MonocularExprNode.Op.NEG && node.operator != MonocularExprNode.Op.POS && node.operator != MonocularExprNode.Op.BITNOT && node.operator != MonocularExprNode.Op.LNOT && !node.operand.isAssignable) {
            throw new SemanticError("Right value can't operate", node.getPos());
        }
        switch (node.operator) {
            case PREINC, PREDEC, NEG, POS, AFTINC, AFTDEC, BITNOT -> {
                if (!node.operand.exprType.Type.equals("int")) {
                    throw new SemanticError("Operand should be int", node.getPos());
                }
            }
            case LNOT -> {
                if (!node.operand.exprType.Type.equals("bool")) {
                    throw new SemanticError("Operand should be bool", node.getPos());
                }
            }
        }
        node.exprType = node.operand.exprType;
        node.isAssignable = (node.operator == MonocularExprNode.Op.PREINC || node.operator == MonocularExprNode.Op.PREDEC);
    }

    @Override
    public void visit(BinaryExprNode node) {
        node.LOperand.accept(this);
        node.ROperand.accept(this);
        if (!node.LOperand.exprType.Type.equals(node.ROperand.exprType.Type) && node.operator != BinaryExprNode.Op.ASSIGN && node.operator != BinaryExprNode.Op.EQ && node.operator != BinaryExprNode.Op.NE) {
            throw new SemanticError("Type dismatch in Binary Operation1", node.getPos());
        }
        TypeNode nodeType = node.LOperand.exprType;
        switch (node.operator) {
            case ADD, GT, LT, GE, LE -> {
                if (!nodeType.Type.equals("int") && !nodeType.Type.equals("string")) {
                    throw new SemanticError("This operator1 doesn't match this type", node.getPos());
                }
            }
            case SUB, MUL, DIV, MOD, SHL, SHR, AND, XOR, OR -> {
                if (!nodeType.Type.equals("int")) {
                    throw new SemanticError("This operator2 doesn't match this type", node.getPos());
                }
            }
            case LAND, LOR -> {
                if (!nodeType.Type.equals("bool")) {
                    throw new SemanticError("This operator3 doesn't match this type", node.getPos());
                }
            }
            case ASSIGN -> {
                if (!node.LOperand.isAssignable) {
                    throw new SemanticError("Lvalue should be assignable", node.getPos());
                }
                if (!nodeType.Type.equals(node.ROperand.exprType.Type) && !node.ROperand.exprType.Type.equals("null")) {
                    throw new SemanticError("Type dismatch in Binary Operation2", node.getPos());
                }
                if (node.ROperand.exprType.Type.equals("null")) {
                    /*if (nodeType.Type.equals("void") || nodeType.Type.equals("int") || nodeType.Type.equals("string") || nodeType.toString().equals("bool")) {
                        throw new SemanticError("Null can't be assign to a primitive type", node.getPos());
                    }*/
                    if (!(nodeType instanceof ArrayTypeNode)) {
                        throw new SemanticError("Null can't assign to a primitive type", node.getPos());
                    }
                }
                node.isAssignable = true;
            }
            case EQ, NE -> {
                if (!node.LOperand.exprType.Type.equals(node.ROperand.exprType.Type) && !node.ROperand.exprType.Type.equals("null")) {
                    throw new SemanticError("Type dismatch in Binary Operation3", node.getPos());
                }
            }
        }
        switch (node.operator) {
            case ADD, SUB, MUL, DIV, MOD, SHL, SHR, AND, XOR, OR, ASSIGN -> node.exprType = nodeType;
            case GT, LT, GE, LE, EQ, NE, LAND, LOR -> node.exprType = new TypeNode("bool", new Position(-1, -1));
        }
    }

    public void visit(ThisExprNode node) {
        if (nowClass == null) {
            throw new SemanticError("Pointer can't be used out of the class", node.getPos());
        }
        node.exprType = new TypeNode(nowClass, node.getPos());
        node.isAssignable = false;
    }

    @Override
    public void visit(BlockStmtNode node) {
        cScope = new Scope(cScope);
        if (node.Stmt != null) {
            node.Stmt.forEach(tmp -> tmp.accept(this));
        }
        cScope = cScope.parent;
    }

    @Override
    public void visit(ExprStmtNode node) {
        node.expr.accept(this);
    }

    @Override
    public void visit(BreakStmtNode node) {
        if (loops == 0) {
            throw new SemanticError("Break Statement should be in the loop", node.getPos());
        }
    }

    @Override
    public void visit(ContinueStmtNode node) {
        if (loops == 0) {
            throw new SemanticError("Continue Statement should be in the loop", node.getPos());
        }
    }

    @Override
    public void visit(ReturnStmtNode node) {
        if (FuncStation.empty()) {
            throw new SemanticError("Return Statement should be in the function or lambda", node.getPos());
        }
        if (FuncStation.peek() instanceof FuncDefNode nowFunc) {
            if (node.expr == null) {
                if (nowFunc.funcType != null && !nowFunc.funcType.Type.equals("void")) {
                    throw new SemanticError("Void Type Function shouldn't have the return value", node.getPos());
                }
            } else {
                node.expr.accept(this);
                if (nowFunc.funcType == null || (!nowFunc.funcType.Type.equals(node.expr.exprType.Type) && !node.expr.exprType.Type.equals("null"))) {
                    throw new SemanticError("Constructor and no Void function should have the return value", node.getPos());
                }
            }
            nowFunc.hasReturn = true;
        } else {
            LambdaExprNode nowFunc = (LambdaExprNode) FuncStation.peek();
            if (node.expr == null) {
                node.expr = new VoidConstantExprNode(new Position(-1, -1));
            } else {
                node.expr.accept(this);
            }
            if (nowFunc.ReturnType == null) nowFunc.exprType = node.expr.exprType;
            else if (nowFunc.ReturnType.Type.equals(node.expr.exprType.Type)) {
                throw new SemanticError("Lambda Function should have only one type return", node.getPos());
            }
        }
    }

    @Override
    public void visit(ForStmtNode node) {
        loops++;
        if (node.init != null) {
            if (!(node.init instanceof ExprStmtNode) && !(node.init instanceof VarDefStmtNode)) {//needed?
                throw new SemanticError("Statement Invalid in For loop", node.getPos());
            }
            node.init.accept(this);
        }
        if (node.condition != null) {
            node.condition.accept(this);
            if (!node.condition.exprType.Type.equals("bool")) {
                throw new SemanticError("Condition in For loop must be Boolean Type", node.getPos());
            }
        }
        if (node.incr != null) {
            node.incr.accept(this);
        }
        if (node.loopBody != null) {
            cScope = new Scope(cScope);
            /*if (node.loopBody instanceof BlockStmtNode) {
                ((BlockStmtNode) node.loopBody).Stmt.forEach(tmp -> tmp.accept(this));
            }*/
            node.loopBody.accept(this);
            cScope = cScope.parent;
        }
        loops--;
    }

    @Override
    public void visit(WhileStmtNode node) {
        loops++;
        if (node.condition == null) {
            throw new SemanticError("Condition in While can't be empty", node.getPos());
        }
        node.condition.accept(this);
        if (!node.condition.exprType.Type.equals("bool")) {
            throw new SemanticError("Condition in While must be boolean type", node.getPos());
        }
        if (node.loopBody != null) {
            cScope = new Scope(cScope);
            /*if (node.loopBody instanceof BlockStmtNode) {
                ((BlockStmtNode) node.loopBody).Stmt.forEach(tmp -> tmp.accept(this));
            }*/
            node.loopBody.accept(this);
            cScope = cScope.parent;
        }

    }

    @Override
    public void visit(IfStmtNode node) {
        if (node.condition == null) {
            throw new SemanticError("Condition in If can't be empty", node.getPos());
        }
        node.condition.accept(this);
        if (!node.condition.exprType.Type.equals("bool")) {
            throw new SemanticError("Condition in If must be boolean type", node.getPos());
        }
        if (node.thenStmt != null) {
            cScope = new Scope(cScope);
            node.thenStmt.accept(this);
            cScope = cScope.parent;
        }
        if (node.elseStmt != null) {
            cScope = new Scope(cScope);
            node.elseStmt.accept(this);
            cScope = cScope.parent;
        }
    }

    @Override
    public void visit(ArrayTypeNode node) {

    }

    @Override
    public void visit(BoolConstantExprNode node) {
        node.exprType = node.Expr;
    }

    @Override
    public void visit(NullConstantExprNode node) {
        node.exprType = node.expr;
    }

    @Override
    public void visit(IntConstantExprNode node) {
        node.exprType = node.expr;
    }

    @Override
    public void visit(StringConstantExprNode node) {
        node.exprType = node.expr;
    }

    @Override
    public void visit(VoidConstantExprNode node) {
        node.exprType = node.expr;
    }

    @Override
    public void visit(TypeNode node) {

    }
}
