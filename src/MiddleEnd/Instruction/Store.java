package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.VoidType;

public class Store extends IRInstruction {
    public Store(Value value, Value address, IRBasicBlock block) {
        super("_store", new VoidType(), block);
        this.addOperand(value);//0 for value
        this.addOperand(address);//1 for address
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        return "store " + this.getOperand(0).getTypeName() + ", " + this.getOperand(1).getTypeName() + ", align " + this.getOperand(0).type.byteSize();
    }
}
