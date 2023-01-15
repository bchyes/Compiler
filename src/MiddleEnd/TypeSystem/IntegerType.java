package MiddleEnd.TypeSystem;

public class IntegerType extends IRType {
    public int width;

    @Override
    public int byteSize() {
        return width / 8;
    }

    @Override
    public boolean isEqual(IRType other) {
        return (other instanceof IntegerType) && ((IntegerType) other).width == this.width;
    }

    public IntegerType(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "i" + this.width;
    }
}
