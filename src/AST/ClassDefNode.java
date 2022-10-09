package AST;

import java.util.ArrayList;

public class ClassDefNode extends ASTNode {
    public String className;
    public ArrayList<VarDefNode> membetVariable;
    public ArrayList<FuncDefNode> memberFunction;

    public ClassDefNode(String className_, ArrayList<VarDefNode> membetVariable_, ArrayList<FuncDefNode> memberFunction_, Position pos_) {
        super(pos_);
        this.className = className_;
        this.membetVariable = membetVariable_;
        this.memberFunction = memberFunction_;
    }
}
