package AST;
import Utils.Position;
import java.util.ArrayList;

public class RootNode extends ASTNode {
    public ArrayList<ASTNode> elements;

    public RootNode(ArrayList<ASTNode> _ele, Position pos_) {
        super(pos_);
        this.elements = _ele;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
