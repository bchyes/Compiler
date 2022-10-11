package AST;

public class ExprStmtNode extends StmtNode {
    public ExprNode expr;

    public ExprStmtNode(ExprNode expr_, Position pos_) {
        super(pos_);
        this.expr = expr_;
    }
}
