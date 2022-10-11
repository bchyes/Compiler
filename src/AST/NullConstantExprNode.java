package AST;

public class NullConstantExprNode extends ExprNode{
    public TypeNode expr;
     public NullConstantExprNode(Position pos_){
         super(pos_);
         this.expr= new TypeNode("null",pos_);
     }
}
