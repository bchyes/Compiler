package BackEnd.Instruction;

import BackEnd.Infrastructure.ASMBlock;
import BackEnd.Operand.Operand;
import BackEnd.Operand.VirtualRegister;

public class RetInstr extends Instruction {
    public RetInstr(ASMBlock curBlock) {
        super(curBlock, "ret");
        rd = null;
        rs1 = null;
        rs2 = null;
    }

    @Override
    public void rewriteUse(String origin, VirtualRegister born) {
        throw new RuntimeException("[Debug] Why call this");
    }

    @Override
    public void rewriteDef(String origin, VirtualRegister born) {
        throw new RuntimeException("[Debug] Why call this");
    }

    public Instruction addOperand(Operand... args) {
        throw new RuntimeException("Why call this?");
    }

    public String toString() {
        return op;
    }
}
