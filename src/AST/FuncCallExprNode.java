package AST;
import Utils.Position;
import java.util.ArrayList;

public class FuncCallExprNode extends ExprNode {
    public ExprNode Func;
    public ArrayList<ExprNode> List;

    public FuncCallExprNode(ExprNode Func_, ArrayList<ExprNode> List_, Position pos_) {
        super(pos_);
        this.Func = Func_;
        this.List = List_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
