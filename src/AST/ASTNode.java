package AST;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.TypeSystem.IRType;
import org.antlr.v4.runtime.ParserRuleContext;
import Utils.Position;

public abstract class ASTNode {
    private Position pos;
    public Value IRoperand;

    public ASTNode(Position pos_) {
        this.pos = pos_;
        this.IRoperand = null;
    }

    public Position getPos() {
        return this.pos;
    }

    abstract public void accept(ASTVisitor visitor);
}

