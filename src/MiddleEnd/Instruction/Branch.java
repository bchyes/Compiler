package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.VoidType;

public class Branch extends IRInstruction {
    public Branch(IRBasicBlock block_, IRBasicBlock destBlock_) {
        super("_branch", new VoidType(), block_);
        this.addOperand(destBlock_);
    }

    public Branch(IRBasicBlock block_, Value condition_, IRBasicBlock lBlock_, IRBasicBlock rBlock_) {
        super("_branch", new VoidType(), block_);
        //
        this.addOperand(condition_);
        this.addOperand(lBlock_);
        this.addOperand(rBlock_);
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        if (this.operands.size() == 1) {
            return "br " + this.getOperand(0).getTypeName();
        } else return "br " + this.getOperand(0).getTypeName() + ", "
                + this.getOperand(1).getTypeName() + ", "
                + this.getOperand(2).getTypeName();
    }
}
