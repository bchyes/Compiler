package BackEnd.Instruction;

import BackEnd.Infrastructure.ASMBlock;
import BackEnd.Operand.Operand;
import BackEnd.Operand.Register;
import BackEnd.Operand.VirtualRegister;

public class LoadInstr extends Instruction {
    public LoadInstr(ASMBlock curBlock, String op) {
        super(curBlock, op);
    }

    @Override
    public void rewriteUse(String origin, VirtualRegister born) {
        if(rs1.getName().equals(origin)){
            rs1 = born;
            use.remove(origin);
            use.add(born.getName());
        }
    }

    @Override
    public void rewriteDef(String origin, VirtualRegister born) {
        if(rd.getName().equals(origin)){
            rd = born;
            def.remove(origin);
            def.add(born.getName());
        }
    }

    @Override
    public Instruction addOperand(Operand... args) {
        assert args.length == 2;
        rd = args[0];
        rs1 = args[1];
        rs2 = null;
        this.def.add(rd.getName());
        this.use.add(rs1.getName());
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s, %s(%s)", op, rd.getName(), ((Register) rs1).offset, rs1.getName());
    }
}
