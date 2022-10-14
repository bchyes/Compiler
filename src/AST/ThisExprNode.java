package AST;

import Utils.Position;

public class ThisExprNode extends ExprNode {

    public ThisExprNode(Position pos_) {
        super(pos_);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
