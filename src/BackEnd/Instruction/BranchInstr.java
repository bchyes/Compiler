package BackEnd.Instruction;

import BackEnd.Infrastructure.ASMBlock;
import BackEnd.Operand.Operand;
import BackEnd.Operand.VirtualRegister;

public class BranchInstr extends Instruction {
    public BranchInstr(ASMBlock curBlock, String op) {
        super(curBlock, op);
    }

    @Override
    public void rewriteUse(String origin, VirtualRegister born) {
        if(rs1.getName().equals(origin)){
            rs1 = born;
            use.remove(origin);
            use.add(born.getName());
        }
        if(rs2.getName().equals(origin)){
            rs2 = born;
            use.remove(origin);
            use.add(born.getName());
        }
    }

    @Override
    public void rewriteDef(String origin, VirtualRegister born) {
        throw new RuntimeException("[Debug] Why call rewrite Def");
    }

    @Override
    public Instruction addOperand(Operand... args) {
        assert args.length == 3;
        rd = args[0];
        rs1 = args[1];
        rs2 = args[2];
        this.use.add(rs1.getName());
        this.use.add(rs2.getName());
        return this;
    }

    public String toString() {
        return op + '\t' + rs1.getName() + "," + rs2.getName() + "," + rd.getName();
    }
}
