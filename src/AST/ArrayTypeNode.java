package AST;

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
}
