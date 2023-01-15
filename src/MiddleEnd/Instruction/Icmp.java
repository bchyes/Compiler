package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRBuilder;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.IntegerType;

public class Icmp extends IRInstruction {
    public IRBuilder.Operator op;

    public Icmp(IRBuilder.Operator op, Value rs1, Value rs2, IRBasicBlock block) {
        super(op.toString(), new IntegerType(1), block);
        assert rs1.type.isEqual(rs2.type);
        this.op = op;
        this.addOperand(rs1);
        this.addOperand(rs2);
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        return this.getName() + " = icmp " + op + " " + this.getOperand(0).getTypeName() + ", " + this.getOperand(1).getName();
    }
}
