package MiddleEnd.TypeSystem;

public class LabelType extends IRType {
    @Override
    public int byteSize() {
        throw new RuntimeException("byteSize wrong");
    }

    @Override
    public boolean isEqual(IRType other) {
        return (other instanceof LabelType);
    }

    @Override
    public String toString() {
        return "label";
    }
}
