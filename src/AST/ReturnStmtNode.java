package AST;

public class ReturnStmtNode extends StmtNode {
    public ExprNode expr;

    public ReturnStmtNode(ExprNode expr_, Position pos_) {
        super(pos_);
        this.expr = expr_;
    }
}
