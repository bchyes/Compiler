package MiddleEnd;

import MiddleEnd.BasicClass.Value;
import MiddleEnd.Instruction.Branch;
import MiddleEnd.Instruction.IRInstruction;
import MiddleEnd.Instruction.Ret;
import MiddleEnd.TypeSystem.LabelType;

import java.util.LinkedList;

public class IRBasicBlock extends Value {
    public LinkedList<IRInstruction> Instructions;
    public IRInstruction terminator;//
    public IRFunction parentFunction;

    public IRBasicBlock(String name_, IRFunction parent_) {
        super(name_ + "_bb", new LabelType());/////
        this.parentFunction = parent_;
        parent_.addBlock(this);
        this.Instructions = new LinkedList<>();
        this.terminator = null;
    }

    public void addInstruction(IRInstruction instr_) {
        if (instr_ instanceof Branch || instr_ instanceof Ret) setTerminator(instr_);
        else this.Instructions.add(instr_);
    }

    public void setTerminator(IRInstruction instr_) {
        if (this.terminator == null) this.terminator = instr_;
    }

    public void accept(IRVisitor node) {
        node.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder raw = new StringBuilder();
        raw.append(this.name);
        raw.append(":");
        if (this.useList.size() != 0) {
            raw.append("\t\t\t\t\t ;preds = ");
            useList.forEach(tmp -> raw.append(((Branch) tmp).parentBlock.getName()).append(", "));
            raw.delete(raw.length() - 2, raw.length());
        }
        raw.append("\n");
        Instructions.forEach(tmp -> {
            raw.append("\t").append(tmp.toString()).append("\n");
        });
        raw.append("\t").append(terminator.toString()).append("\n");
        return raw.toString();
    }
}
