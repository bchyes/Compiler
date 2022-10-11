package AST;

public class IfStmtNode extends StmtNode {
    public ExprNode condition;
    public StmtNode thenStmt, elseStmt;

    public IfStmtNode(ExprNode condition_, StmtNode thenStmt_, StmtNode elseStmt_, Position pos_) {
        super(pos_);
        this.condition = condition_;
        this.thenStmt = thenStmt_;
        this.elseStmt = elseStmt_;
    }
}
