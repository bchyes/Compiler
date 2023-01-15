package MiddleEnd.TypeSystem;

public class PointerType extends IRType {
    public IRType baseType;
    public int dimSize;

    public PointerType(IRType base) {
        if (base instanceof PointerType) {
            this.baseType = ((PointerType) base).baseType;
            this.dimSize = ((PointerType) base).dimSize + 1;
        } else {
            this.baseType = base;
            this.dimSize = 1;
        }
    }

    public PointerType(IRType base, int dimSize) {
        if (base instanceof PointerType) {
            this.baseType = ((PointerType) base).baseType;
            this.dimSize = ((PointerType) base).dimSize + dimSize;
        } else {
            this.baseType = base;
            this.dimSize = dimSize;
        }
    }

    @Override
    public int byteSize() {
        return 8;
    }

    @Override
    public boolean isEqual(IRType other) {
        return (other instanceof PointerType) && this.baseType.isEqual(((PointerType) other).baseType) && this.dimSize == ((PointerType) other).dimSize;
    }

    @Override
    public String toString() {
        return this.baseType.toString() + "*".repeat(this.dimSize);
    }
}
