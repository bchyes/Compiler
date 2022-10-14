package AST;
import Utils.Position;
public class NullConstantExprNode extends ExprNode{
    public TypeNode expr;
     public NullConstantExprNode(Position pos_){
         super(pos_);
         this.expr= new TypeNode("null",pos_);
     }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
