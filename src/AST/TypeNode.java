package AST;

public class TypeNode extends ASTNode {
    public String Type;

    public TypeNode(String Type_, Position pos_) {
        super(pos_);
        this.Type = Type_;
    }
}
