package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRBuilder;
import MiddleEnd.IRVisitor;

public class Binary extends IRInstruction {
    public IRBuilder.Operator op;

    public Binary(IRBuilder.Operator op_, Value rs1, Value rs2, IRBasicBlock block_) {
        super(op_.toString(), rs1.type, block_);
        assert rs1.type.isEqual(rs2.type);
        this.op = op_;
        this.addOperand(rs1);
        this.addOperand(rs2);
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        return "%" + this.name + " = " + op + " " + this.getOperand(0).getTypeName() + ", " + this.getOperand(1).getName();
    }
}
