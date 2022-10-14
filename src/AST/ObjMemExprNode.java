package AST;

import Utils.Position;

public class ObjMemExprNode extends ExprNode {
    public ExprNode base;
    public String member;
    public FuncDefNode FuncInfo;
    public boolean forFunc;

    public ObjMemExprNode(ExprNode base_, String member_, Position pos_) {
        super(pos_);
        this.base = base_;
        this.member = member_;
        this.FuncInfo = null;
        this.forFunc = false;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
