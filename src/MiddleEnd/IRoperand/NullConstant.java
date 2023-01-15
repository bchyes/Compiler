package MiddleEnd.IRoperand;

import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.IRType;
import MiddleEnd.TypeSystem.PointerType;
import MiddleEnd.TypeSystem.VoidType;

public class NullConstant extends IRConstant {
    public NullConstant() {
        super("null", new PointerType(new VoidType()));
    }

    public NullConstant(PointerType type) {
        super("null", type);
    }

    public void setType(IRType type_) {
        this.type = type_;
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String getName() {
        return "null";
    }
}
