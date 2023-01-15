package MiddleEnd.Instruction;

import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.IRType;
import MiddleEnd.TypeSystem.PointerType;

public class GlobalDef extends IRInstruction {
    public GlobalDef(String name, IRType type) {
        super(name + "_glo", new PointerType(type), null);////
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String getName() {
        return "@" + this.name;
    }

    @Override
    public String toString() {
        return this.getName() + " = global " + this.type.dePointed().toString() + " zeroinitializer, align " + this.type.dePointed().byteSize();
    }
}
