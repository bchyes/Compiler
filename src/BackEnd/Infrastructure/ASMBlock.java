package BackEnd.Infrastructure;

import BackEnd.Instruction.Instruction;
import BackEnd.Operand.Operand;

import java.util.ArrayList;
import java.util.LinkedList;

public class ASMBlock extends Operand {
    public LinkedList<Instruction> instructionList;
    public ArrayList<ASMBlock> successors;

    public ASMBlock(String name, ASMFunction func) {
        super("." + name);
        this.instructionList = new LinkedList<>();
        this.successors = new ArrayList<>();
        func.addBlock(this);
    }

    public void addInstruction(Instruction instr) {
        this.instructionList.add(instr);
    }

    public String printASM() {
        StringBuilder raw = new StringBuilder();
        raw.append(getName()).append(":\n");
        instructionList.forEach(inst -> {
            raw.append('\t').append(inst).append('\n');
        });
        return raw.toString();
    }
}
