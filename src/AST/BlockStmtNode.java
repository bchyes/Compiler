package AST;
import Utils.Position;
import java.util.ArrayList;

public class BlockStmtNode extends StmtNode {
    public ArrayList<StmtNode> Stmt;

    BlockStmtNode(ArrayList<StmtNode> Stmt_, Position pos_) {
        super(pos_);
        this.Stmt = Stmt_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
