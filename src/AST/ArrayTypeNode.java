package AST;

import Utils.Position;

public class ArrayTypeNode extends TypeNode {
    public int dimension;

    public ArrayTypeNode(TypeNode type_, Position pos_) {
        super(type_.Type, pos_);
        if (type_ instanceof ArrayTypeNode) {
            this.dimension = 1 + ((ArrayTypeNode) type_).dimension;
        } else {
            this.dimension = 1;
        }
    }

    public ArrayTypeNode(TypeNode type_, int dimension_, Position pos_) {
        super(type_.Type, pos_);
        this.dimension = dimension_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
