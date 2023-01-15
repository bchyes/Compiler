package MiddleEnd.IRoperand;

import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.BoolType;

public class BoolConstant extends IRConstant {
    public boolean value;

    public BoolConstant(boolean value) {
        super("_bool_const", new BoolType());///?
        this.value = value;
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String getName() {
        return value ? String.valueOf(1) : String.valueOf(0);
    }
}
