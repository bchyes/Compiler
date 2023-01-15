package MiddleEnd.IRoperand;

import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.IntegerType;

public class IntConstant extends IRConstant {
    public int value;

    public IntConstant(int value) {
        super("_int_const", new IntegerType(32));
        this.value = value;
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String getName() {
        return String.valueOf(this.value);
    }
}
