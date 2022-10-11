package AST;

import Parser.MxParser;

public class BinaryExprNode extends ExprNode {
    public enum Op {ADD, SUB, MUL, DIV, MOD, SHL, SHR, GT, LT, GE, LE, EQ, NE, AND, XOR, OR, LAND, LOR, ASSIGN}

    public Op operator;
    public ExprNode LOperand, ROperand;

    public BinaryExprNode(Op operator_, ExprNode LOperand_, ExprNode ROperand_, Position pos_) {
        super(pos_);
        this.operator = operator_;
        this.LOperand = LOperand_;
        this.ROperand = ROperand_;
    }
}
