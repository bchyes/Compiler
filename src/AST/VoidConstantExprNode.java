package AST;

import Utils.Position;

public class VoidConstantExprNode extends ExprNode {
    public TypeNode expr;

    public VoidConstantExprNode(Position pos_) {
        super(pos_);
        this.expr = new TypeNode("void", pos_);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
