package AST;

import Utils.Position;

public class TypeNode extends ASTNode {
    public String Type;

    public TypeNode(String Type_, Position pos_) {
        super(pos_);
        this.Type = Type_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
