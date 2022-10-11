package AST;

import Parser.MxParser;

public class IdentifierExprNode extends ExprNode {
    public String identifier;

    public IdentifierExprNode(String identifier_, Position pos_) {
        super(pos_);
        this.identifier = identifier_;
    }
}
