package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRVisitor;

public class Load extends IRInstruction {
    public Load(String name, Value address, IRBasicBlock block) {
        super(name + ".load", address.type.dePointed(), block);
        this.addOperand(address);
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        return this.getName() + " = load " + this.type.toString() + ", " + this.getOperand(0).getTypeName() + ", align " + this.type.byteSize();
    }
}
