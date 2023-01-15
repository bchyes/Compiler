package MiddleEnd.Instruction;

import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRBuilder;
import MiddleEnd.IRFunction;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.FunctionType;
import MiddleEnd.TypeSystem.VoidType;

public class Call extends IRInstruction {
    public Call(IRFunction func, IRBasicBlock block) {
        super("_call" + func.name, ((FunctionType) func.type).returnType, block);
        this.addOperand(func);
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder raw = new StringBuilder();
        if (!(this.type instanceof VoidType)) {
            raw.append(this.getName()).append(" = ");
        }
        raw.append("call ").append(this.getOperand(0).getTypeName()).append("(");
        if (operands.size() > 1) {
            for (int i = 1; i < operands.size(); i++) {
                raw.append(this.getOperand(i).getTypeName()).append(", ");
            }
            raw.delete(raw.length() - 2, raw.length());
        }
        raw.append(")");
        return raw.toString();
    }
}
