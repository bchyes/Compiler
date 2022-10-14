package AST;
import Utils.Position;
import Parser.MxParser;

public class BoolConstantExprNode extends ExprNode {
    public boolean value;
    public TypeNode Expr;

    public BoolConstantExprNode(boolean value_, Position pos_) {
        super(pos_);
        this.value = value_;
        this.Expr = new TypeNode("bool", pos_);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
