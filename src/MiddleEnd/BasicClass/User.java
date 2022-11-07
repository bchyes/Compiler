package MiddleEnd.BasicClass;

import MiddleEnd.TypeSystem.IRType;

import java.util.ArrayList;

public abstract class User extends Value {
    public ArrayList<Value> operands;

    public User(String name, IRType type) {
        super(name, type);
        this.operands = new ArrayList<>();
    }
}
