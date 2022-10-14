package AST;

import Utils.Position;

import java.util.ArrayList;

public class LambdaExprNode extends ExprNode {
    public ArrayList<VarDefNode> parameter;
    public ArrayList<ExprNode> list;
    public BlockStmtNode block;
    public TypeNode ReturnType;

    public LambdaExprNode(ArrayList<VarDefNode> parameter_, ArrayList<ExprNode> list_, BlockStmtNode block_, Position pos_) {
        super(pos_);
        this.parameter = parameter_;
        this.list = list_;
        this.block = block_;
        this.ReturnType = null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
