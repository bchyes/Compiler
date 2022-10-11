package AST;

public class ObjMemExprNode extends ExprNode {
    public ExprNode base;
    public String member;

    public ObjMemExprNode(ExprNode base_, String member_, Position pos_) {
        super(pos_);
        this.base = base_;
        this.member = member_;
    }
}
