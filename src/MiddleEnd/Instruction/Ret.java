package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.VoidType;

public class Ret extends IRInstruction {
    public Ret(Value returnValue_, IRBasicBlock block_) {
        super("_ret", returnValue_.type, block_);
        this.addOperand(returnValue_);
    }


    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        return "ret " + ((this.type instanceof VoidType) ? this.type.toString() : this.getOperand(0).getTypeName());
    }
}
