package MiddleEnd.TypeSystem;

import java.util.ArrayList;

public class FunctionType extends IRType {
    public IRType returnType;
    public ArrayList<IRType> parameterType;
    public ArrayList<String> parameterName;

    public FunctionType(IRType returnType) {
        this.returnType = returnType;
        parameterType = new ArrayList<>();
        parameterName = new ArrayList<>();
    }

    public void addParameters(IRType type, String name) {
        this.parameterType.add(type);
        this.parameterName.add(name);
    }
}
