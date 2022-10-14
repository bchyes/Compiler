package AST;

import Utils.Position;

public abstract class ExprNode extends ASTNode {
    public TypeNode exprType;
    public boolean isAssignable;

    public ExprNode(Position pos_) {
        super(pos_);
        this.exprType = null;
        this.isAssignable = false;
    }
}
