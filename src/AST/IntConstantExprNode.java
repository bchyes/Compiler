package AST;

public class IntConstantExprNode extends ExprNode {
    public TypeNode expr;

    public IntConstantExprNode(Position pos_) {
        super(pos_);
        this.expr = new TypeNode("int", pos_);
    }
}
