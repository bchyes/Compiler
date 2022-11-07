package MiddleEnd.BasicClass;

import MiddleEnd.TypeSystem.IRType;

import java.util.ArrayList;

public class Value {
    public String name;
    public IRType type;
    public ArrayList<User> useList;

    public Value(String name_, IRType type_) {
        this.name = name_;
        this.type = type_;
        this.useList = new ArrayList<>();
    }
}
