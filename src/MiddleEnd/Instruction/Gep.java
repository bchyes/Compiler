package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRVisitor;
import MiddleEnd.TypeSystem.IRType;

public class Gep extends IRInstruction {
    public Gep(IRType targetType, Value calculatePointer, IRBasicBlock block) {
        super("gep", targetType, block);
        this.addOperand(calculatePointer);
    }

    public Gep addIndex(Value value) {
        this.addOperand(value);
        return this;
    }

    @Override
    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder raw = new StringBuilder();
        raw.append(this.getName()).append(" = getelementptr inbounds ").append(getOperand(0).type.dePointed().toString())
                .append(", ").append(getOperand(0).getTypeName());
        assert this.operands.size() > 1;
        for (int i = 1; i < operands.size(); i++) {
            raw.append(", ").append(getOperand(i).getTypeName());
        }
        return raw.toString();
    }
}
