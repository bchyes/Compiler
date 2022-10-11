package AST;

import java.util.ArrayList;

public class FuncDefNode extends ASTNode {
    public TypeNode funcType;
    public String funcName;
    public ArrayList<VarDefNode> parameter;
    public BlockStmtNode funcBody;

    public FuncDefNode(Position pos_, TypeNode funcType_, String funcName_, ArrayList<VarDefNode> parameter_, BlockStmtNode funcBody_) {
        super(pos_);
        this.funcType = funcType_;
        this.funcName = funcName_;
        this.parameter = parameter_;
        this.funcBody = funcBody_;
    }
}