package AST;
import Utils.Position;
public class BreakStmtNode extends StmtNode {
    public BreakStmtNode(Position pos_) {
        super(pos_);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
