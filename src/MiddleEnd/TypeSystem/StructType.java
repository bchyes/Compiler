package MiddleEnd.TypeSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class StructType extends IRType {
    public HashMap<String, IRType> typeTable;
    public HashMap<String, Integer> indexTable;
    public ArrayList<IRType> typeList;
    public Integer count;
    public String name;

    public StructType(String name) {
        typeTable = new HashMap<>();
        indexTable = new HashMap<>();
        typeList = new ArrayList<>();
        count = 0;
        this.name = "class_" + name;
    }

    public void addMember(String identifier, IRType type) {
        typeTable.put(identifier, type);
        indexTable.put(identifier, count++);
        typeList.add(type);
    }
}
