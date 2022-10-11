package AST;

import java.util.ArrayList;

public class LambdaExprNode extends ExprNode {
    public ArrayList<VarDefNode> parameter;
    public ArrayList<ExprNode> list;
    public BlockStmtNode block;

    public LambdaExprNode(ArrayList<VarDefNode> parameter_, ArrayList<ExprNode> list_, BlockStmtNode block_, Position pos_) {
        super(pos_);
        this.parameter = parameter_;
        this.list = list_;
        this.block = block_;
    }
}
