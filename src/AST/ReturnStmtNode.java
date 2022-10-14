package AST;
import Utils.Position;
public class ReturnStmtNode extends StmtNode {
    public ExprNode expr;

    public ReturnStmtNode(ExprNode expr_, Position pos_) {
        super(pos_);
        this.expr = expr_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
