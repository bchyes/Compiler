package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRBuilder;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.IRType;

public class Bitcast extends IRInstruction {
    public Bitcast(Value baseValue, IRType targetType, IRBasicBlock block) {
        super(baseValue.name + "_BC", targetType, block);
        this.addOperand(baseValue);
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        return this.getName() + " = bitcast " + this.getOperand(0).getTypeName() + " to " + this.type.toString();
    }
}
