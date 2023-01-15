package AST;

import Utils.Position;

public class StringConstantExprNode extends ExprNode {
    public TypeNode expr;
    public String value;

    public StringConstantExprNode(String value, Position pos_) {
        super(pos_);
        this.expr = new TypeNode("string", pos_);
        this.value = value.substring(1, value.length() - 1) //
                .replace("\\\\", "\\")
                .replace("\\n", "\n")
                .replace("\\\"", "\"")
                .replace("\\t", "\t")
                + "\0";
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
