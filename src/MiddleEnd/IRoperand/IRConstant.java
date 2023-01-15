package MiddleEnd.IRoperand;

import MiddleEnd.BasicClass.User;
import MiddleEnd.TypeSystem.IRType;

public abstract class IRConstant extends User {
    public IRConstant(String name_, IRType type_) {
        super(name_, type_);
    }
}
