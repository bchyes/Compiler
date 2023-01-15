package MiddleEnd.TypeSystem;

public class ArrayType extends IRType {
    public IRType baseType;
    public int size;

    @Override
    public int byteSize() {
        throw new RuntimeException("byteSize wrong");
    }

    @Override
    public boolean isEqual(IRType other) {
        return (other instanceof ArrayType) && this.baseType.isEqual(((ArrayType) other).baseType) && this.size == ((ArrayType) other).size;
    }

    public ArrayType(IRType baseType, int size) {
        this.baseType = baseType;
        this.size = size;
    }

    @Override
    public String toString() {
        return "[" + this.size + " x " + this.baseType.toString() + "]";
    }
}
