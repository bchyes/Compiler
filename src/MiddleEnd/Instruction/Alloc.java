package MiddleEnd.Instruction;

import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.IRType;
import MiddleEnd.TypeSystem.PointerType;

public class Alloc extends IRInstruction {
    public Alloc(String name, IRType type, IRBasicBlock block) {
        super(name + ".alloc", new PointerType(type), block);
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        return "%" + this.name + " = alloca " + this.type.dePointed().toString() + ", align " + this.type.dePointed().byteSize();
    }
}
