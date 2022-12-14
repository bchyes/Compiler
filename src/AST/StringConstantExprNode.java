package AST;
import Utils.Position;
public class StringConstantExprNode extends ExprNode {
    public TypeNode expr;

    public StringConstantExprNode(Position pos_) {
        super(pos_);
        this.expr = new TypeNode("string", pos_);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
