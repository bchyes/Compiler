package MiddleEnd.IRoperand;

import MiddleEnd.TypeSystem.ArrayType;
import MiddleEnd.TypeSystem.IntegerType;
import MiddleEnd.TypeSystem.PointerType;

public class StringConstant extends IRConstant {
    public String value;

    public StringConstant(String value) {
        super("_str", new PointerType(new ArrayType(new IntegerType(8), value.length())));
        this.value = value;
    }
}
