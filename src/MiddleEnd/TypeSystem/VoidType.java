package MiddleEnd.TypeSystem;

public class VoidType extends IRType {
    @Override
    public int byteSize() {
        throw new RuntimeException("byteSize wrong");
    }

    @Override
    public boolean isEqual(IRType other) {
        return (other instanceof VoidType);
    }

    @Override
    public String toString() {
        return "void";
    }
}
