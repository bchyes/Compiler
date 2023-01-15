package MiddleEnd.BasicClass;

import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.IRType;

import java.util.ArrayList;

public abstract class User extends Value {
    public ArrayList<Value> operands;

    public User(String name, IRType type) {
        super(name, type);
        this.operands = new ArrayList<>();
    }

    public void addOperand(Value operand) {
        operand.useList.add(this);
        this.operands.add(operand);
    }

    public Value getOperand(int index) {
        return this.operands.get(index);
    }

    public abstract void accept(IRVisitor node);
}
