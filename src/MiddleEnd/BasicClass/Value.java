package MiddleEnd.BasicClass;

import BackEnd.Operand.Operand;
import MiddleEnd.TypeSystem.IRType;

import java.util.ArrayList;
import java.util.HashMap;

public class Value {
    public Operand ASMOperand;
    public String name;
    public IRType type;
    public ArrayList<User> useList;
    public static HashMap<String, Integer> renamingMachine = new HashMap<>();

    public Value(String name_, IRType type_) {
        this.name = renaming(name_);
        this.type = type_;
        this.useList = new ArrayList<>();
        this.ASMOperand = null;
    }

    public String renaming(String name_) {
        if (name_.equals("_f_main")) return "main";
        Integer count = renamingMachine.get(name_);
        if (count == null) count = 0;
        else count++;
        renamingMachine.put(name_, count);
        return (count == 0) ? name_ : name_ + count;
    }

    public String getName() {
        return "%" + this.name;
    }

    public String getTypeName() {
        return type.toString() + " " + this.getName();
    }
}
