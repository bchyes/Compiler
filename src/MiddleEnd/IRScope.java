package MiddleEnd;

import MiddleEnd.BasicClass.Value;

import java.util.HashMap;

public class IRScope {
    public enum scopeType {Global, Func, Class, Flow, Common}

    ;
    public IRScope parent;
    public HashMap<String, Value> valueTable;
    public scopeType type;
    //

    public IRScope(IRScope parent_, scopeType type_) {
        this.type = type_;
        this.parent = parent_;
        this.valueTable = new HashMap<>();
        //
    }

    public boolean isClass(String identifier) {
        Value tmp = this.valueTable.get(identifier);
        return tmp == null ? this.parent.isClass(identifier) : (this.type == scopeType.Class);
    }

    public void setVariable(String identifier, Value operand) {
        this.valueTable.put(identifier, operand);
    }

    public Value fetchValue(String identifier) {
        Value tmp = this.valueTable.get(identifier);
        return tmp == null ? this.parent.fetchValue(identifier) : tmp;
    }

    public IRScope uproot() {
        assert this.parent != null;
        //
        return this.parent;
    }
}
