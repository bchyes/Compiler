package AST;

import Parser.MxBaseVisitor;
import Parser.MxParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends MxBaseVisitor<ASTNode> {
    /*public ASTNode visitVariabledef(MxParser.VariabledefContext ctx) {
        TypeNode varType = (TypeNode) visit(ctx.vartype());
        ArrayList<VarDefNode> List_ = new ArrayList<VarDefNode>();
        for (MxParser.VariabledefContext element: ctx.vartype())
        return VarDefNode(varType, );
    }*/

    public ASTNode visitFunctiondef(MxParser.FunctiondefContext ctx) {
        TypeNode funcType = (ctx.vartype() == null) ? null : (TypeNode) visit(ctx.vartype());
        String funcName = ctx.ID().getText();
        BlockNode funcBody = (BlockNode) visit(ctx.block());
        if (ctx.parameter() == null) {
            return new FuncDefNode(new Position(ctx), funcType, funcName, null, funcBody);
        } else {
            List<MxParser.VartypeContext> vtl = ctx.parameter().vartype();
            List<TerminalNode> vil = ctx.parameter().ID();
            ArrayList<VarDefNode> parameter = new ArrayList<VarDefNode>();
            for (int i = 0; i < vtl.size(); i++) {
                parameter.add(new VarDefNode((TypeNode) visit(vtl.get(i)), vil.get(i).getText(), null, new Position(vtl.get(i))));
            }
            return new FuncDefNode(new Position(ctx), funcType, funcName, parameter, funcBody);
        }
    }

    public ASTNode visitClassdef(MxParser.ClassdefContext ctx) {
        String className = ctx.ID().getText();
        ArrayList<VarDefNode> vardef = new ArrayList<VarDefNode>();
        ArrayList<FuncDefNode> funcdef = new ArrayList<FuncDefNode>();
        if (ctx.variabledef() != null) {
            ctx.variabledef().forEach(tmp -> vardef.add((VarDefNode) visit(tmp)));
        }
        if (ctx.functiondef() != null) {
            ctx.functiondef().forEach(tmp -> funcdef.add((FuncDefNode) visit(tmp)));
        }
        return new ClassDefNode(className, (ctx.variabledef() == null) ? null : vardef, (ctx.functiondef() == null) ? null : funcdef, new Position(ctx));
    }

    public ASTNode visitProgram(MxParser.ProgramContext ctx) {
        ArrayList<ASTNode> _ele = new ArrayList<>();
        for (MxParser.SubprogramContext elements : ctx.subprogram()) {
            if (elements.functiondef() != null) _ele.add(visit(elements.functiondef()));
            if (elements.variabledef() != null) _ele.add(visit(elements.variabledef()));
            if (elements.classdef() != null) _ele.add(visit(elements.classdef()));
        }
        return new RootNode(_ele, new Position(ctx));
    }
}
