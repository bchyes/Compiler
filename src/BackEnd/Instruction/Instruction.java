package BackEnd.Instruction;

import BackEnd.Infrastructure.ASMBlock;
import BackEnd.Operand.Operand;
import BackEnd.Operand.VirtualRegister;

import java.util.ArrayList;

public abstract class Instruction {
    public Operand rd, rs1, rs2;
    public String op;

    public ArrayList<String> def;

    public ArrayList<String> use;

    public Instruction(ASMBlock curBlock, String op) {
        if (curBlock != null) {
            curBlock.addInstruction(this);
        }
        this.op = op;
        this.def = new ArrayList<>();
        this.use = new ArrayList<>();
    }

    public abstract void rewriteUse(String origin, VirtualRegister born);

    public abstract void rewriteDef(String origin, VirtualRegister born);

    public abstract Instruction addOperand(Operand... args);
}
