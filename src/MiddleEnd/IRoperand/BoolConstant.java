package MiddleEnd.IRoperand;

import MiddleEnd.TypeSystem.BoolType;

public class BoolConstant extends IRConstant {
    public boolean value;

    public BoolConstant(boolean value) {
        super("_bool_const", new BoolType());///?
        this.value = value;
    }
}
