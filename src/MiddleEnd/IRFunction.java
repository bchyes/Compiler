package MiddleEnd;

import MiddleEnd.BasicClass.User;
import MiddleEnd.BasicClass.Value;
import MiddleEnd.TypeSystem.FunctionType;
import MiddleEnd.TypeSystem.IRType;

import java.util.ArrayList;

public class IRFunction extends User {
    public ArrayList<IRBasicBlock> blockList;
    public Value returnAddress;

    public boolean isBuiltin;

    public boolean isUsed;

    public IRFunction(String name, IRType type) {
        super(name, type);
        this.blockList = new ArrayList<>();
        this.returnAddress = null;
        this.isBuiltin = false;
        this.isUsed = false;
    }

    public void addBlock(IRBasicBlock basicBlock) {
        blockList.add(basicBlock);
    }

    public void addParameter(Value para) {
        this.addOperand(para);
    }

    public IRBasicBlock entryBlock() {
        return this.blockList.get(0);
    }

    public IRBasicBlock exitBlock() {
        return this.blockList.get(1);
    }

    public void accept(IRVisitor node) {
        node.visit(this);
    }

    public String getName() {
        return "@" + this.name;
    }

    public String toString() {
        StringBuilder raw = new StringBuilder();
        if (!isBuiltin) {
            raw.append("define ").append(this.type.toString()).append(' ').append(this.getName()).append('(');
            if (this.operands.size() != 0) {
                this.operands.forEach(tmp -> {
                    raw.append(tmp.getTypeName()).append(", ");
                    raw.delete(raw.length() - 2, raw.length());
                });
            }
            raw.append(")\t{\n");
            blockList.forEach(tmp -> {
                raw.append(tmp.toString());
            });
            raw.append("}\n");
        } else if (isUsed) {
            raw.append("declare ").append(this.type.toString()).append(' ').append(this.getName()).append('(');
            if (((FunctionType) this.type).parameterType.size() != 0) {
                ((FunctionType) this.type).parameterType.forEach(tmp -> {
                    raw.append(tmp.toString()).append(", ");
                });
                raw.delete(raw.length() - 2, raw.length());
            }
            raw.append(")\n");
        }
        return raw.toString();
    }
}
