package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.IRType;

public class Trunc extends IRInstruction {
    public Trunc(Value origin, IRType targetType, IRBasicBlock block) {
        super("trunc_", targetType, block);
        this.addOperand(origin);
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        return this.getName() + " = trunc " + this.getOperand(0).getTypeName() + " to " + this.type.toString();
    }
}
