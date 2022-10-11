package AST;

import java.util.ArrayList;

public class NewExprNode extends ExprNode {
    public TypeNode newType;
    public int dimension;
    public ArrayList<ExprNode> SizeList;

    public NewExprNode(TypeNode newType_, int dimension_, ArrayList<ExprNode> SizeList_, Position pos_) {
        super(pos_);
        this.newType = newType_;
        this.dimension = dimension_;
        this.SizeList = SizeList_;
    }
}
