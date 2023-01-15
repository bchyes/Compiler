package BackEnd.Instruction;

import BackEnd.Infrastructure.ASMBlock;
import BackEnd.Operand.Operand;
import BackEnd.Operand.VirtualRegister;

public class LiInstr extends Instruction {
    public LiInstr(ASMBlock curBlock) {
        super(curBlock, "li");
    }

    @Override
    public void rewriteUse(String origin, VirtualRegister born) {
        throw new RuntimeException("[Debug] Why call this");
    }

    @Override
    public void rewriteDef(String origin, VirtualRegister born) {
        if(rd.getName().equals(origin)){
            rd = born;
            def.remove(origin);
            def.add(born.getName());
        }
    }

    public Instruction addOperand(Operand... args) {
        assert args.length == 2;
        rd = args[0];
        rs1 = args[1];
        rs2 = null;
        this.def.add(rd.getName());
        return this;
    }

    @Override
    public String toString() {
        return op + '\t' + rd.getName() + ',' + rs1.getName();
    }
}
