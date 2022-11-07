package MiddleEnd.IRoperand;

import MiddleEnd.TypeSystem.PointerType;
import MiddleEnd.TypeSystem.VoidType;

public class NullConstant extends IRConstant {
    public NullConstant() {
        super("null", new PointerType(new VoidType()));
    }
}
