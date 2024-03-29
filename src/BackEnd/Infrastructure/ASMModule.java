package BackEnd.Infrastructure;

import BackEnd.Operand.GlobalVar;

import java.util.ArrayList;

public class ASMModule {
    public ArrayList<GlobalVar> globalVars;

    public ArrayList<ASMFunction> functions;

    public ASMModule() {
        globalVars = new ArrayList<>();
        functions = new ArrayList<>();
    }

    public void addFunc(ASMFunction func) {
        functions.add(func);
    }

    public void addGlobalVar(GlobalVar var) {
        globalVars.add(var);
    }

    public String printASM() {
        StringBuilder raw = new StringBuilder();
        raw.append('\t').append(".text\n");
        if (functions.size() != 0) functions.forEach(func -> {
            if (func.isBuiltin) return;
            raw.append(func.printASM()).append('\n');
        });
        if (globalVars.size() != 0) globalVars.forEach(tmp -> {
            raw.append(tmp.printASM()).append('\n');
        });
        return raw.toString();
    }
}
