package MiddleEnd.Instruction;

import MiddleEnd.TypeSystem.IRType;
import MiddleEnd.TypeSystem.PointerType;

public class GlobalDef extends IRInstruction {
    public GlobalDef(String name, IRType type) {
        super(name + "_glo", new PointerType(type), null);////
    }
}
