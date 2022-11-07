package MiddleEnd.TypeSystem;

public class ArrayType extends IRType {
    public IRType baseType;
    public int size;

    public ArrayType(IRType baseType, int size) {
        this.baseType = baseType;
        this.size = size;
    }
}
