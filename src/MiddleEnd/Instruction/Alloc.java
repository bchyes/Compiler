package MiddleEnd.Instruction;

import MiddleEnd.IRBasicBlock;
import MiddleEnd.TypeSystem.IRType;
import MiddleEnd.TypeSystem.PointerType;

public class Alloc extends IRInstruction {
    public Alloc(String name, IRType type, IRBasicBlock block) {
        super(name + ".alloc", new PointerType(type), block);
    }
}
