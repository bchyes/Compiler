package AST;
import Utils.Position;
import java.util.ArrayList;

public class ClassDefNode extends ASTNode {
    public String className;
    public ArrayList<VarDefStmtNode> memberVariable;
    public ArrayList<FuncDefNode> memberFunction;

    public ClassDefNode(String className_, ArrayList<VarDefStmtNode> memberVariable_, ArrayList<FuncDefNode> memberFunction_, Position pos_) {
        super(pos_);
        this.className = className_;
        this.memberVariable = memberVariable_;
        this.memberFunction = memberFunction_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
