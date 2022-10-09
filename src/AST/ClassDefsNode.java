package AST;

import java.util.ArrayList;

public class ClassDefsNode extends ASTNode {
    public ArrayList<VarDefNode> elements;

    public ClassDefsNode(ArrayList<VarDefNode> elements_, Position pos_) {
        super(pos_);
        this.elements = elements_;
    }

}
