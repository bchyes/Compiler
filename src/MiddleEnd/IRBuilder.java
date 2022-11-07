package MiddleEnd;

import AST.*;
import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRoperand.BoolConstant;
import MiddleEnd.IRoperand.IntConstant;
import MiddleEnd.IRoperand.NullConstant;
import MiddleEnd.IRoperand.StringConstant;
import MiddleEnd.Instruction.Alloc;
import MiddleEnd.Instruction.GlobalDef;
import MiddleEnd.TypeSystem.*;
import Utils.GlobalScope;

import java.util.HashMap;

/*
public class IRBuilder implements ASTVisitor {
    public HashMap<String, IRType> typeTable;
    public HashMap<String, IRFunction> funcTable;
    public HashMap<String, StringConstant> stringTable;

    public GlobalScope gScope;
    public IRScope cScope;

    public IRFunction curFunction;

    public IRBuilder(IRModule module, GlobalScope gScope_) {
        this.gScope = gScope_;
        gScope.Class_Table.forEach((className, classScope) -> {
            switch (className) {
                case "int" -> typeTable.put("int", new IntegerType(8));
                case "bool" -> typeTable.put("bool", new BoolType());
                case "string" -> typeTable.put("string", new PointerType(new IntegerType(8)));
                default -> {
                    StructType newClass = new StructType(className);
                    typeTable.put(className, new PointerType(newClass));
                    //
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
            IRFunction func_ = new IRFunction();
            //
            funcTable.put(funcName, func_);
            //
        });
        gScope.Class_Table.forEach((className, classScope) -> {
            switch (className) {
                case "int", "bool" -> {
                }
                default -> {
                    IRType pendingType = typeTable.get(className).dePointed();
                    if (!className.equals("string")) {
                        classScope.Variable_Table.forEach((identifier, node) -> {
                            ((StructType) pendingType).addMember(identifier, getType(node));
                        });
                    }
                    classScope.Function_Table.forEach((funcName, funcNode) -> {
                        IRType returnType = (funcNode.funcType == null) ? new VoidType() : getType(funcNode.funcType);
                        FunctionType funcType = new FunctionType(returnType);
                        IRType argType = new PointerType(pendingType);//
                        funcType.addParameters(argType, "_this");///////////
                        if (funcNode.parameter != null) {
                            for (VarDefNode tmp : funcNode.parameter) {
                                argType = getType(tmp.varType);
                                funcType.addParameters(argType, tmp.identifier);
                            }
                        }
                        IRFunction func_ = new IRFunction();
                        //
                        //
                        //
                    });
                    */
/*if (!className.equals("string") && funcTable.get()){

                    }*//*

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
        StringConstant stringLiteral = stringTable.get(node.expr.Type);
        if (stringLiteral == null) {
            stringLiteral = new StringConstant(node.expr.Type);
            //
            stringTable.put(node.expr.Type, stringLiteral);
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
            //
        } else {
            value = stackAlloc(node.identifier, valueType);
        }
    }

    public Alloc stackAlloc(String name, IRType type) {
        return new Alloc(name, type, curFunction.entryBlock());
    }

    public IRType getType(TypeNode node_) {
        IRType returnType = typeTable.get(node_.Type);
        if (node_ instanceof ArrayTypeNode) {
            returnType = new PointerType(returnType, ((ArrayTypeNode) node_).dimension);
        }
        return returnType;
    }
}
*/
