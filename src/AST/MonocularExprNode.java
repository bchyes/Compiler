package AST;
import Utils.Position;
public class MonocularExprNode extends ExprNode {
    public enum Op {LNOT, BITNOT, PREINC, PREDEC, AFTINC, AFTDEC, POS, NEG}

    public Op operator;
    public ExprNode operand;

    public MonocularExprNode(Op operator_, ExprNode operand_, Position pos_) {
        super(pos_);
        this.operator = operator_;
        this.operand = operand_;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
