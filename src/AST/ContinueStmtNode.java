package AST;

import Utils.Position;

public class ContinueStmtNode extends StmtNode {
    public ContinueStmtNode(Position pos_) {
        super(pos_);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
