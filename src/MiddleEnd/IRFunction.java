package MiddleEnd;

import MiddleEnd.BasicClass.User;
import MiddleEnd.BasicClass.Value;
import MiddleEnd.TypeSystem.IRType;

import java.util.ArrayList;

public class IRFunction extends User {
    public ArrayList<IRBasicBlock> blockList;
    public Value returnAddress;

    public IRFunction(String name, IRType type) {
        super(name, type);
        this.blockList = new ArrayList<>();
        this.returnAddress = null;
    }
}
