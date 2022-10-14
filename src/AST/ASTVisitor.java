package AST;

public interface ASTVisitor {
    void visit(ArrayAccessExprNode visitor);

    void visit(ArrayTypeNode visitor);

    void visit(BinaryExprNode visitor);

    void visit(BlockStmtNode visitor);

    void visit(BoolConstantExprNode visitor);

    void visit(BreakStmtNode visitor);

    void visit(ClassDefNode visitor);

    void visit(ContinueStmtNode visitor);

    void visit(ExprStmtNode visitor);

    void visit(ForStmtNode visitor);

    void visit(FuncCallExprNode visitor);

    void visit(FuncDefNode visitor);

    void visit(IdentifierExprNode visitor);

    void visit(IfStmtNode visitor);

    void visit(IntConstantExprNode visitor);

    void visit(LambdaExprNode visitor);

    void visit(MonocularExprNode visitor);

    void visit(NewExprNode visitor);

    void visit(NullConstantExprNode visitor);

    void visit(ObjMemExprNode visitor);

    void visit(ReturnStmtNode visitor);

    void visit(RootNode visitor);

    void visit(StringConstantExprNode visitor);

    void visit(ThisExprNode visitor);

    void visit(TypeNode visitor);

    void visit(VarDefNode visitor);

    void visit(VarDefStmtNode visitor);

    void visit(VoidConstantExprNode visitor);

    void visit(WhileStmtNode visitor);
}
