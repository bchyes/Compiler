package Utils;

import AST.FuncDefNode;

import java.util.HashMap;
import java.util.Map;

public class GlobalScope extends Scope {
    public Map<String, FuncDefNode> Function_Table;
    public Map<String, GlobalScope> Class_Table;

    public GlobalScope(Scope parent_) {
        super(parent_);
        Function_Table = new HashMap<>();
        Class_Table = new HashMap<>();
    }

    public boolean contains_Function(String identifier) {
        return Function_Table.containsKey(identifier);
    }

    public boolean contains_Class(String identifier) {
        return Class_Table.containsKey(identifier);
    }

    public void define_Function(String identifier, FuncDefNode node_) {
        Function_Table.put(identifier, node_);
    }

    public void define_Class(String idntifier, GlobalScope node_) {
        Class_Table.put(idntifier, node_);
    }

    public FuncDefNode fetch_Function(String identifier) {
        if (contains_Function(identifier)) return this.Function_Table.get(identifier);
        else return null;
    }
}
