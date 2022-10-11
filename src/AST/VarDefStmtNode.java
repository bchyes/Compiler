package AST;

import java.util.ArrayList;

public class VarDefStmtNode extends StmtNode {
    public ArrayList<VarDefNode> elements;

    public VarDefStmtNode(ArrayList<VarDefNode> elements_, Position pos_) {
        super(pos_);
        this.elements=elements_;
    }
}
