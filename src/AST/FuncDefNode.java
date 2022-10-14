package AST;

import Utils.Position;

import java.util.ArrayList;

public class FuncDefNode extends ASTNode {
    public TypeNode funcType;
    public String funcName;
    public ArrayList<VarDefNode> parameter;
    public BlockStmtNode funcBody;
    public boolean hasReturn;

    public FuncDefNode(TypeNode funcType_, String funcName_, ArrayList<VarDefNode> parameter_, BlockStmtNode funcBody_, Position pos_) {
        super(pos_);
        this.funcType = funcType_;
        this.funcName = funcName_;
        this.parameter = parameter_;
        this.funcBody = funcBody_;
        this.hasReturn = false;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}