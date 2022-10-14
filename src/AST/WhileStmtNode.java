package AST;
import Utils.Position;
public class WhileStmtNode extends StmtNode {
    public ExprNode condition;
    public StmtNode loopBody;

    public WhileStmtNode(ExprNode condition_, StmtNode loopBody_, Position pos_) {
        super(pos_);
        this.condition = condition_;
        this.loopBody = loopBody_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
