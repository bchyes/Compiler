package AST;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class ASTNode {
    private Position pos;

    public ASTNode(Position pos_) {
        this.pos = pos_;
    }

    public Position getPos() {
        return this.pos;
    }

    //abstract public void accept(ASTVisitor visitor);
}

