package AST;
import Utils.Position;
public class ForStmtNode extends StmtNode {
    public StmtNode init;
    public ExprNode condition;
    public ExprNode incr;
    public StmtNode loopBody;

    public ForStmtNode(StmtNode init_, ExprNode condition_, ExprNode incr_, StmtNode loopBody_, Position pos_) {
        super(pos_);
        this.init = init_;
        this.condition = condition_;
        this.incr = incr_;
        this.loopBody = loopBody_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
