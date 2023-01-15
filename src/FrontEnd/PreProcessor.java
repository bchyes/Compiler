package FrontEnd;

import AST.*;
import Utils.GlobalScope;
import Utils.Position;
import Utils.SemanticError;

public class PreProcessor implements ASTVisitor {
    public GlobalScope gScope;

    public PreProcessor(GlobalScope gScope_) {
        this.gScope = gScope_;
    }

    public void visit(RootNode node) {
        node.elements.forEach(tmp -> tmp.accept(this));
        if (!this.gScope.contains_Function("main") || !this.gScope.fetch_Function("main").funcType.Type.equals("int")) {
            throw new SemanticError("No main function!", node.getPos());
        }
        if (this.gScope.fetch_Function("main").parameter != null) {
            throw new SemanticError("Main function should not have parameter!", node.getPos());
        }
    }

    public void visit(ClassDefNode node) {
        if (this.gScope.contains_Class(node.className) || this.gScope.contains_Function(node.className)) {
            throw new SemanticError("Duplicate definition!", node.getPos());
        } else {
            GlobalScope forClass = new GlobalScope(gScope);
            for (VarDefStmtNode tmp : node.memberVariable) {
                tmp.elements.forEach(var -> {
                    if (forClass.contains_Variable(var.identifier)) {
                        throw new SemanticError("Duplicate definition of " + var.identifier + " in Class " + node.className, node.getPos());
                    }
                    else {
                        forClass.define_Variable(var.identifier,var.varType);
                    }
                });
            }
            node.memberFunction.forEach(func -> {
                if (func.funcType != null && func.funcName.equals(node.className)) {
                    throw new SemanticError("Invalid Constructor in " + func.funcName + " which has return type", node.getPos());
                }
                if (func.funcType == null && !func.funcName.equals(node.className)) {
                    throw new SemanticError("Invalid Constructor in " + func.funcName + " which name is different from the class name", node.getPos());
                }
                if (forClass.contains_Function(func.funcName)) {
                    throw new SemanticError("Duplicate definition of function " + func.funcName + " in Class " + node.className, node.getPos());
                }
                /*if (func.funcName.equals(node.className)){
                    this.gScope.define_Function(node.className,func);
                }*/ //??
                forClass.define_Function(func.funcName, func);
            });
            /*if (!this.gScope.contains_Function(node.className)){
                this.gScope.define_Function(node.className,new FuncDefNode(new TypeNode(node.className,new Position(-1,-1)),node.className,null,null,new Position(-1,-1)));
            }*/
            this.gScope.define_Class(node.className, forClass);
        }
    }

    public void visit(FuncDefNode node) {
        if (this.gScope.contains_Function(node.funcName) || this.gScope.contains_Class(node.funcName)) {
            throw new SemanticError("Duplicate definition of Function " + node.funcName, node.getPos());
        }
        if (node.funcType == null) {
            throw new SemanticError("Definition of Constructor out of ClassDefinition", node.getPos());
        }
        this.gScope.define_Function(node.funcName, node);
    }

    @Override
    public void visit(ExprStmtNode visitor) {
    }

    @Override
    public void visit(TypeNode visitor) {

    }

    @Override
    public void visit(IfStmtNode visitor) {

    }

    @Override
    public void visit(VarDefNode visitor) {

    }

    @Override
    public void visit(ForStmtNode visitor) {

    }

    @Override
    public void visit(NewExprNode visitor) {

    }

    @Override
    public void visit(ArrayTypeNode visitor) {

    }

    @Override
    public void visit(BlockStmtNode visitor) {

    }

    @Override
    public void visit(BreakStmtNode visitor) {

    }

    @Override
    public void visit(WhileStmtNode visitor) {

    }

    @Override
    public void visit(BinaryExprNode visitor) {

    }

    @Override
    public void visit(LambdaExprNode visitor) {

    }

    @Override
    public void visit(ObjMemExprNode visitor) {

    }

    @Override
    public void visit(ReturnStmtNode visitor) {

    }

    @Override
    public void visit(VarDefStmtNode visitor) {

    }

    @Override
    public void visit(ContinueStmtNode visitor) {

    }

    @Override
    public void visit(FuncCallExprNode visitor) {

    }

    @Override
    public void visit(MonocularExprNode visitor) {

    }

    @Override
    public void visit(IdentifierExprNode visitor) {

    }

    @Override
    public void visit(ArrayAccessExprNode visitor) {

    }

    @Override
    public void visit(IntConstantExprNode visitor) {

    }

    @Override
    public void visit(BoolConstantExprNode visitor) {

    }

    @Override
    public void visit(NullConstantExprNode visitor) {

    }

    @Override
    public void visit(StringConstantExprNode visitor) {

    }

    @Override
    public void visit(VoidConstantExprNode visitor) {

    }

    @Override
    public void visit(ThisExprNode visitor) {

    }
}
