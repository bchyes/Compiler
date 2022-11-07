package MiddleEnd.IRoperand;

import MiddleEnd.TypeSystem.IntegerType;

public class IntConstant extends IRConstant {
    public int value;

    public IntConstant(int value) {
        super("_int_const", new IntegerType(32));
        this.value = value;
    }
}
