package MiddleEnd.IRoperand;

import MiddleEnd.BasicClass.User;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.IRType;

public class Temporary extends User {

    public Temporary(IRType _type) {
        super("mem2reg_", _type);
    }

    @Override
    public String toString() {
        throw new RuntimeException("[Debug] Why use toString in Temporary ?");
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

}