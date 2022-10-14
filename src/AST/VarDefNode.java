package AST;
import Utils.Position;
public class VarDefNode extends ASTNode {
    public TypeNode varType;
    public String identifier;
    public ExprNode initValue;

    public VarDefNode(TypeNode varType_, String identifier_, ExprNode initValue_, Position pos_) {
        super(pos_);
        this.varType = varType_;
        this.identifier = identifier_;
        this.initValue = initValue_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
