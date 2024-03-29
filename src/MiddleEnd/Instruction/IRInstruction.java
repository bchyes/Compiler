package MiddleEnd.Instruction;

import MiddleEnd.BasicClass.User;
import MiddleEnd.IRBasicBlock;
//import MiddleEnd.IRBuilder;
import MiddleEnd.TypeSystem.IRType;

public abstract class IRInstruction extends User {
    public IRBasicBlock parentBlock;

    public IRInstruction(String name_, IRType type_, IRBasicBlock block_) {
        super(name_, type_);
        this.parentBlock = block_;
        if (block_ != null) block_.addInstruction(this);
    }
}
