package BackEnd.Infrastructure;

import BackEnd.Instruction.*;
import BackEnd.Operand.*;
import MiddleEnd.BasicClass.User;
import MiddleEnd.BasicClass.Value;
import MiddleEnd.IRBasicBlock;
import MiddleEnd.IRFunction;
import MiddleEnd.IRModule;
import MiddleEnd.IRVisitor;
import MiddleEnd.IRoperand.*;
import MiddleEnd.Instruction.*;
import MiddleEnd.TypeSystem.*;

import java.sql.Struct;
import java.util.ArrayList;

public class ASMBuilder implements IRVisitor {
    public ASMModule output;

    public ASMBlock curBlock;

    public ASMFunction curFunction;

    @Override
    public void visit(IRBasicBlock node) {
        curBlock = (ASMBlock) node.ASMOperand;
        node.Instructions.forEach(instr -> {
            instr.accept(this);
        });
        node.terminator.accept(this);
    }

    @Override
    public void visit(IRFunction node) {
        if (node.isBuiltin) return;
        curFunction = (ASMFunction) node.ASMOperand;
        curBlock = curFunction.entryBlock();
        VirtualRegister tmpRa = new VirtualRegister(curFunction.virtualIndex++);
        new MoveInstr(curBlock).addOperand(tmpRa, new VirtualRegister(1, curFunction.virtualIndex++));
        PhysicalRegister.calleeSaved.forEach(index -> {
            VirtualRegister tmpBackup = new VirtualRegister(curFunction.virtualIndex++);
            curFunction.calleeSaved.add(tmpBackup);
            new MoveInstr(curBlock).addOperand(tmpBackup, new VirtualRegister(index, curFunction.virtualIndex++));
        });
        node.blockList.forEach(tmp -> tmp.accept(this));
        curBlock = curFunction.exitBlock();
        for (int i = 0; i < curFunction.calleeSaved.size(); i++) {
            new MoveInstr(curBlock).addOperand(new VirtualRegister(PhysicalRegister.calleeSaved.get(i), curFunction.virtualIndex++), curFunction.calleeSaved.get(i));
        }
        new MoveInstr(curBlock).addOperand(new VirtualRegister(1, curFunction.virtualIndex++), tmpRa);
    }

    @Override
    public void visit(IRModule node) {
        output = new ASMModule();
        node.stringList.forEach(tmp -> {
            tmp.ASMOperand = new GlobalVar(tmp.name, tmp.value);
            output.globalVars.add((GlobalVar) tmp.ASMOperand);
        });
        node.globalDefList.forEach(tmp -> {
            tmp.ASMOperand = new GlobalVar(tmp.name);
            output.globalVars.add((GlobalVar)tmp.ASMOperand);//
        });
        node.functionList.forEach(tmp -> {
            tmp.ASMOperand = new ASMFunction(tmp.name);
            ((ASMFunction) tmp.ASMOperand).isBuiltin = tmp.isBuiltin;
            int parameterSize = ((FunctionType) tmp.type).parameterName.size();
            for (int i = 0; i < parameterSize && i <= 7; i++) {
                ((ASMFunction) tmp.ASMOperand).arguments.add(new VirtualRegister(10 + i, ((ASMFunction) tmp.ASMOperand).virtualIndex++));
            }
            for (int i = 8; i < parameterSize; i++) {
                Immediate offset = ((ASMFunction) tmp.ASMOperand).allocStack().reverse();
                Register arg = new VirtualRegister(offset, 8, ((ASMFunction) tmp.ASMOperand).virtualIndex++);
                arg.inMem = true;
                ((ASMFunction) tmp.ASMOperand).arguments.add(arg);
            }
            for (int i = 0; i < tmp.operands.size(); i++) {
                tmp.getOperand(i).ASMOperand = ((ASMFunction) tmp.ASMOperand).arguments.get(i);
            }
            for (IRBasicBlock bb : tmp.blockList) {
                bb.ASMOperand = new ASMBlock(bb.name, (ASMFunction) tmp.ASMOperand);
            }
            output.functions.add((ASMFunction) tmp.ASMOperand);
        });
        node.globalInitList.forEach(tmp -> {
            tmp.ASMOperand = new ASMFunction(tmp.name);
            for (IRBasicBlock bb : tmp.blockList) {
                bb.ASMOperand = new ASMBlock(bb.name, (ASMFunction) tmp.ASMOperand);
            }
            output.functions.add((ASMFunction) tmp.ASMOperand);
        });
        IRFunction gPtr = null;
        node.globalInitList.forEach(func -> func.accept(this));
        if (node.globalInitList.size() != 0) {
            for (IRFunction func : node.globalInitList) {
                if (func.name.equals("_GLOBAL_")) gPtr = func;
            }
            assert gPtr != null;
            for (IRFunction func : node.functionList) {//!
                if (func.name.equals("main")) {
                    func.entryBlock().Instructions.addFirst(new Call(gPtr, null));
                }
            }
        }
        node.functionList.forEach(func -> func.accept(this));
    }

    @Override
    public void visit(Call node) {
        ASMFunction func = ((ASMFunction) node.operands.get(0).ASMOperand);
        node.operands.forEach(this::recurDown);
        for (int i = 0; i <= 7 && i < node.operands.size() - 1; i++) {
            this.moveForm(func.arguments.get(i), node.getOperand(i + 1).ASMOperand);
        }
        for (int i = 8; i < node.operands.size() - 1; i++) {
            Register tmpArg;
            if (node.getOperand(i + 1).ASMOperand instanceof Immediate) {
                tmpArg = new VirtualRegister(curFunction.virtualIndex);
                new LiInstr(curBlock).addOperand(tmpArg, node.getOperand(i + 1).ASMOperand);
            } else {
                assert node.getOperand(i + 1).ASMOperand instanceof Register;
                tmpArg = (Register) node.getOperand(i + 1).ASMOperand;
            }
            new StoreInstr(curBlock, "sw").addOperand(tmpArg, new VirtualRegister(func.arguments.get(i).offset, 2, curFunction.virtualIndex++));
        }
        new CallInstr(curBlock).addOperand(func);
        if (!(node.type instanceof VoidType)) {
            Register returnValue = new VirtualRegister(curFunction.virtualIndex++);
            new MoveInstr(curBlock).addOperand(returnValue, new VirtualRegister(10, curFunction.virtualIndex++));
            node.ASMOperand = returnValue;
        }
    }

    @Override
    public void visit(BoolConstant node) {
        node.ASMOperand = new Immediate(node.value ? 1 : 0);
    }

    @Override
    public void visit(IntConstant node) {
        node.ASMOperand = new Immediate(node.value);
    }

    @Override
    public void visit(NullConstant node) {
        node.ASMOperand = new Immediate(0);
    }

    @Override
    public void visit(StringConstant node) {
        node.ASMOperand = new GlobalVar(node.name, node.value);
    }

    @Override
    public void visit(GlobalDef node) {
        node.ASMOperand = new GlobalVar(node.name);
    }

    @Override
    public void visit(Alloc node) {
        node.ASMOperand = new VirtualRegister(curFunction.allocStack().reverse(), 8, curFunction.virtualIndex++);
    }

    @Override
    public void visit(Binary node) {
        node.operands.forEach(this::recurDown);
        String op;
        switch (node.op) {
            case sdiv -> op = "div";
            case srem -> op = "rem";
            case shl -> op = "sll";
            case ashr -> op = "sra";
            default -> op = node.op.toString();
        }
        Register newOperand = new VirtualRegister(curFunction.virtualIndex++);
        this.arthForm(newOperand, node.getOperand(0).ASMOperand, node.getOperand(1).ASMOperand, op);
        node.ASMOperand = newOperand;
    }

    @Override
    public void visit(Bitcast node) {
        recurDown(node.getOperand(0));
        node.ASMOperand = node.getOperand(0).ASMOperand;
    }

    public void visit(Temporary node) {
        node.ASMOperand = new VirtualRegister(curFunction.virtualIndex++);
    }

    @Override
    public void visit(Icmp node) {
        Register newOperand = new VirtualRegister(curFunction.virtualIndex++);
        node.operands.forEach(this::recurDown);
        Operand rs1 = node.getOperand(0).ASMOperand;
        Operand rs2 = node.getOperand(1).ASMOperand;
        Immediate tmp;
        if (rs1 instanceof Immediate) {
            tmp = (Immediate) rs1;
            rs1 = new VirtualRegister(curFunction.virtualIndex++);
            new LiInstr(curBlock).addOperand(rs1, tmp);
        }
        if (rs2 instanceof Immediate) {
            tmp = (Immediate) rs2;
            rs2 = new VirtualRegister(curFunction.virtualIndex++);
            new LiInstr(curBlock).addOperand(rs2, tmp);
        }
        String op = "slt";
        switch (node.op) {
            case sgt -> new ArthInstr(op, curBlock).addOperand(newOperand, rs2, rs1);
            case slt -> new ArthInstr(op, curBlock).addOperand(newOperand, rs1, rs2);
            case sge -> {
                new ArthInstr(op, curBlock).addOperand(newOperand, rs1, rs2);
                new ArthInstr("xor", curBlock).addOperand(newOperand, newOperand, new Immediate(1));
            }
            case sle -> {
                new ArthInstr(op, curBlock).addOperand(newOperand, rs2, rs1);
                new ArthInstr("xor", curBlock).addOperand(newOperand, newOperand, new Immediate(1));
            }
            case eq -> {
                new ArthInstr("xor", curBlock).addOperand(newOperand, rs1, rs2);
                new PseudoInstr("seqz", curBlock).addOperand(newOperand, newOperand);
            }
            case ne -> {
                new ArthInstr("xor", curBlock).addOperand(newOperand, rs1, rs2);
                new PseudoInstr("snez", curBlock).addOperand(newOperand, newOperand);
            }
            default -> throw new RuntimeException("wrong op");
        }
        node.ASMOperand = newOperand;
    }

    @Override
    public void visit(Trunc node) {
        recurDown(node.getOperand(0));
        node.ASMOperand = node.getOperand(0).ASMOperand;
    }

    @Override
    public void visit(Zext node) {
        recurDown(node.getOperand(0));
        node.ASMOperand = node.getOperand(0).ASMOperand;
    }

    @Override
    public void visit(Branch node) {
        node.ASMOperand = null;
        node.operands.forEach(this::recurDown);
        if (node.operands.size() == 1) {
            new JumpInstr(curBlock).addOperand(node.getOperand(0).ASMOperand);
            curBlock.successors.add((ASMBlock) node.getOperand(0).ASMOperand);
        } else {
            Operand flag = node.getOperand(0).ASMOperand;
            if (flag instanceof Immediate) {
                Immediate tmpImm = new Immediate(((Immediate) flag).value);
                flag = new VirtualRegister(curFunction.virtualIndex++);
                new LiInstr(curBlock).addOperand(flag, tmpImm);
            }
            new BranchInstr(curBlock, "bne").addOperand(node.getOperand(1).ASMOperand, flag, PhysicalRegister.getPhyReg(0));
            new JumpInstr(curBlock).addOperand(node.getOperand(2).ASMOperand);
            curBlock.successors.add((ASMBlock) node.getOperand(1).ASMOperand);
            curBlock.successors.add((ASMBlock) node.getOperand(2).ASMOperand);
        }
    }

    @Override
    public void visit(Gep node) {
        Operand newOperand;
        node.operands.forEach(this::recurDown);
        Operand basePointer = node.getOperand(0).ASMOperand;
        IRType baseType = node.getOperand(0).type.dePointed();
        if (baseType instanceof ArrayType) { //string
            assert basePointer instanceof GlobalVar;
            newOperand = new VirtualRegister(curFunction.virtualIndex++);
            new LaInstr(curBlock).addOperand(newOperand, basePointer);
        } else if (baseType instanceof StructType) {
            assert node.getOperand(2) instanceof IntConstant;
            assert basePointer instanceof Register;
            basePointer = new VirtualRegister((VirtualRegister) basePointer);//
            int offset = ((StructType) baseType).getOffset(((IntConstant) node.getOperand(2)).value);
            newOperand = basePointer;
            ((Register) newOperand).offset = new Immediate(offset);
        } else {
            assert basePointer instanceof Register;
            basePointer = new VirtualRegister((VirtualRegister) basePointer);
            Value indexValue = node.getOperand(1);
            if (indexValue instanceof IntConstant) {
                int offset = ((IntConstant) indexValue).value * baseType.byteSize();
                newOperand = new VirtualRegister(curFunction.virtualIndex++);
                this.arthForm((Register) newOperand, basePointer, new Immediate(offset), "add");
            } else {
                assert indexValue.ASMOperand instanceof Register;
                newOperand = new VirtualRegister(curFunction.virtualIndex++);
                Register biasReg = new VirtualRegister(curFunction.virtualIndex++);
                this.arthForm(biasReg, indexValue.ASMOperand, new Immediate(baseType.byteSize()), "mul");
                this.arthForm((Register) newOperand, biasReg, basePointer, "add");
                ((Register) newOperand).offset = new Immediate(0);//
            }
        }
        node.ASMOperand = newOperand;
    }

    @Override
    public void visit(Load node) {
        Register newOperand = new VirtualRegister(curFunction.virtualIndex++);
        recurDown(node.getOperand(0));
        Operand pointerOperand = node.getOperand(0).ASMOperand;
        if (pointerOperand instanceof Register) {
            new LoadInstr(curBlock, "lw").addOperand(newOperand, pointerOperand);
        } else {
            assert pointerOperand instanceof GlobalVar;
            Register addressReg = new VirtualRegister(curFunction.virtualIndex++);
            new LaInstr(curBlock).addOperand(addressReg, pointerOperand);
            addressReg.offset = new Immediate(0);
            new LoadInstr(curBlock, "lw").addOperand(newOperand, addressReg);
        }
        node.ASMOperand = newOperand;
    }

    @Override
    public void visit(Ret node) {
        node.ASMOperand = null;
        if (!(node.type instanceof VoidType)) {
            recurDown(node.getOperand(0));
            Operand returnValue = node.getOperand(0).ASMOperand;
            assert returnValue instanceof Register;
            new MoveInstr(curBlock).addOperand(new VirtualRegister(10, curFunction.virtualIndex++), returnValue);
        }
    }

    @Override
    public void visit(Store node) {
        node.ASMOperand = null;
        recurDown(node.getOperand(0));
        recurDown(node.getOperand(1));
        Operand pointerOp = node.getOperand(1).ASMOperand;
        Operand valueOp = node.getOperand(0).ASMOperand;
        Operand value = valueOp;
        if (valueOp instanceof Immediate) {
            value = new VirtualRegister(curFunction.virtualIndex++);
            new LiInstr(curBlock).addOperand(value, valueOp);
        } else {
            assert value instanceof Register;
            if (((Register) value).inMem) {
                Register tmpLoad = new VirtualRegister(curFunction.virtualIndex++);
                new LoadInstr(curBlock, "lw").addOperand(tmpLoad, value);
                value = tmpLoad;
            }
        }
        if (node.getOperand(1).ASMOperand instanceof Register) {
            new StoreInstr(curBlock, "sw").addOperand(value, pointerOp);
        } else {
            assert pointerOp instanceof GlobalVar;
            Register addressReg = new VirtualRegister(curFunction.virtualIndex++);
            new LaInstr(curBlock).addOperand(addressReg, pointerOp);
            addressReg.offset = new Immediate(0);
            new StoreInstr(curBlock, "sw").addOperand(value, addressReg);
        }
    }

    private void recurDown(Value node) { //travel on Operand
        if (node instanceof IRBasicBlock) {
            if (node.ASMOperand == null) {
                ((IRBasicBlock) node).accept(this);
            }
        } else {
            assert node instanceof User;
            if (node.ASMOperand == null) {
                ((User) node).accept(this);
            }
        }
    }

    private void moveForm(Register target, Operand source) {
        if (source instanceof Immediate) {
            new LiInstr(curBlock).addOperand(target, source);
        } else {
            new MoveInstr(curBlock).addOperand(target, source);
        }
    }

    private void arthForm(Register dest, Operand unknown, Operand imm, String op) {
        if (unknown instanceof Immediate) {
            Register immReg = new VirtualRegister(curFunction.virtualIndex++);
            new LiInstr(curBlock).addOperand(immReg, unknown);
            unknown = immReg;
        }
        if (imm instanceof Immediate) {
            if (checkImmInstr(op, ((Immediate) imm).value)) { ///
                new ArthInstr(op, curBlock).addOperand(dest, unknown, imm);
            } else {
                Register immReg = new VirtualRegister(curFunction.virtualIndex++);
                new LiInstr(curBlock).addOperand(immReg, imm);
                new ArthInstr(op, curBlock).addOperand(dest, unknown, immReg);
            }
        } else new ArthInstr(op, curBlock).addOperand(dest, unknown, imm);
    }

    private boolean checkImmInstr(String op, int offset) {
        switch (op) {
            case "sub", "mul", "div", "rem" -> {
                return false;
            }
            default -> {
                return -2048 <= offset & offset < 2048;
            }
        }
    }
}
