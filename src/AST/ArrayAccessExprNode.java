package AST;

import Utils.Position;

public class ArrayAccessExprNode extends ExprNode {
    public ExprNode array;
    public ExprNode index;

    public ArrayAccessExprNode(ExprNode array_, ExprNode index_, Position pos_) {
        super(pos_);
        this.array = array_;
        this.index = index_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
