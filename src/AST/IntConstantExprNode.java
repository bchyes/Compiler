package AST;

import Utils.Position;

public class IntConstantExprNode extends ExprNode {
    public TypeNode expr;
    public int value;

    public IntConstantExprNode(int value_, Position pos_) {
        super(pos_);
        this.expr = new TypeNode("int", pos_);
        this.value = value_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
