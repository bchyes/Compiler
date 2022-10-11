package AST;

public class StringConstantExprNode extends ExprNode {
    public TypeNode expr;

    public StringConstantExprNode(Position pos_) {
        super(pos_);
        this.expr = new TypeNode("string", pos_);
    }
}
