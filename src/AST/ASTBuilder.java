package AST;

import Parser.MxBaseVisitor;
import Parser.MxParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends MxBaseVisitor<ASTNode> {
    public ASTNode visitBaseType(MxParser.BaseTypeContext ctx) {
        /*if (ctx.INT() != null) {
            return new TypeNode("int", new Position(ctx));
        } else if (ctx.BOOL() != null) {
            return new TypeNode("bool", new Position(ctx));
        } else if (ctx.STRING() != null) {
            return new TypeNode("string", new Position(ctx));
        } else if (ctx.ID() != null) {
            return new TypeNode("identifier", new Position(ctx));
        } else return null;*/
        return new TypeNode(ctx.getText(), new Position(ctx));
    }

    public ASTNode visitArrayType(MxParser.ArrayTypeContext ctx) {
        return new ArrayTypeNode((TypeNode) visit(ctx.vartype()), new Position(ctx));
    }

    public ASTNode visitFunctype(MxParser.FunctypeContext ctx) {
        if (ctx.VOID() == null) {
            return visit(ctx.vartype());
        } else {
            return new TypeNode("void", new Position(ctx));
        }
    }

    public ASTNode visitIdentifier(MxParser.IdentifierContext ctx) {
        return new IdentifierExprNode(ctx.ID().getText(), new Position(ctx));
    }

    public ASTNode visitConstant(MxParser.ConstantContext ctx) {
        if (ctx.True() != null) {
            return new BoolConstantExprNode(true, new Position(ctx));
        } else if (ctx.False() != null) {
            return new BoolConstantExprNode(false, new Position(ctx));
        } else if (ctx.NULL() != null) {
            return new NullConstantExprNode(new Position(ctx));
        } else if (ctx.INT_C() != null) {
            return new IntConstantExprNode(new Position(ctx));
        } else if (ctx.STRING_C() != null) {
            return new StringConstantExprNode(new Position(ctx));
        } else return null;
    }

    public ASTNode visitCompoundExpr(MxParser.CompoundExprContext ctx) {
        return visit(ctx.expression());
    }

    public ASTNode visitBinaryExpr(MxParser.BinaryExprContext ctx) {
        String op = ctx.op.getText();
        ExprNode ls = (ExprNode) visit(ctx.operand1);
        ExprNode rs = (ExprNode) visit(ctx.operand2);
        BinaryExprNode.Op tmpOp = switch (op) {
            case ">" -> BinaryExprNode.Op.GT;
            case "<" -> BinaryExprNode.Op.LT;
            case ">=" -> BinaryExprNode.Op.GE;
            case "<=" -> BinaryExprNode.Op.LE;
            case "==" -> BinaryExprNode.Op.EQ;
            case "!=" -> BinaryExprNode.Op.NE;
            case ">>" -> BinaryExprNode.Op.SHR;
            case "<<" -> BinaryExprNode.Op.SHL;
            case "*" -> BinaryExprNode.Op.MUL;
            case "/" -> BinaryExprNode.Op.DIV;
            case "+" -> BinaryExprNode.Op.ADD;
            case "-" -> BinaryExprNode.Op.SUB;
            case "%" -> BinaryExprNode.Op.MOD;
            case "&" -> BinaryExprNode.Op.AND;
            case "^" -> BinaryExprNode.Op.XOR;
            case "|" -> BinaryExprNode.Op.OR;
            case "&&" -> BinaryExprNode.Op.LAND;
            case "||" -> BinaryExprNode.Op.LOR;
            case "=" -> BinaryExprNode.Op.ASSIGN;
            default -> throw new RuntimeException("[error in visitBinaryExpr]");
        };
        return new BinaryExprNode(tmpOp, ls, rs, new Position(ctx));
    }

    public ASTNode visitArrayAccess(MxParser.ArrayAccessContext ctx) {
        return new ArrayAccessExprNode((ExprNode) visit(ctx.array), (ExprNode) visit(ctx.index), new Position(ctx));
    }

    public ASTNode visitMonocularOp(MxParser.MonocularOpContext ctx) {
        String Op = ctx.op.getText();
        ExprNode tmpNode = (ExprNode) visit(ctx.operand);
        MonocularExprNode.Op tmpOp = switch (Op) {
            case "++" -> MonocularExprNode.Op.PREINC;
            case "--" -> MonocularExprNode.Op.PREDEC;
            case "!" -> MonocularExprNode.Op.LNOT;
            case "~" -> MonocularExprNode.Op.BITNOT;
            case "-" -> MonocularExprNode.Op.NEG;
            case "+" -> MonocularExprNode.Op.POS;
            default -> throw new RuntimeException("[error in visitMonocularOp]");
        };
        return new MonocularExprNode(tmpOp, tmpNode, new Position(ctx));
    }

    public ASTNode visitAftermonocularOp(MxParser.AftermonocularOpContext ctx) {
        String op = ctx.op.getText();
        if (op.equals("++")) {
            return new MonocularExprNode(MonocularExprNode.Op.AFTINC, (ExprNode) visit(ctx.operand), new Position(ctx));
        } else if (op.equals("--")) {
            return new MonocularExprNode(MonocularExprNode.Op.AFTDEC, (ExprNode) visit(ctx.operand), new Position(ctx));
        } else return null;
    }

    public ASTNode visitAllocExpr(MxParser.AllocExprContext ctx) {
        ArrayList<ExprNode> arraySize = new ArrayList<ExprNode>();
        ctx.expression().forEach(tmp -> arraySize.add((ExprNode) visit(tmp)));
        int dimension = (ctx.getChildCount() - arraySize.size() - 2) / 2;
        return new NewExprNode((TypeNode) visit(ctx.vartype()), dimension, arraySize, new Position(ctx));
    }

    public ASTNode visitObjPortion(MxParser.ObjPortionContext ctx) {
        return new ObjMemExprNode((ExprNode) visit(ctx.expression()), ctx.ID().getText(), new Position(ctx));
    }

    public ASTNode visitFuncCall(MxParser.FuncCallContext ctx) {
        ArrayList<ExprNode> List = new ArrayList<ExprNode>();
        if (ctx.parameterforcall() != null) {
            ctx.parameterforcall().expression().forEach(tmp -> List.add((ExprNode) visit(tmp)));
            return new FuncCallExprNode((ExprNode) visit(ctx.expression()), List, new Position(ctx));
        } else {
            return new FuncCallExprNode((ExprNode) visit(ctx.expression()), null, new Position(ctx));
        }
    }

    public ASTNode visitLambdaExpr(MxParser.LambdaExprContext ctx) {
        ArrayList<VarDefNode> parameter = null;
        if (ctx.lambdaparameter() != null && ctx.lambdaparameter().parameter() != null) {
            parameter = new ArrayList<VarDefNode>();
            List<MxParser.VartypeContext> vtl = ctx.lambdaparameter().parameter().vartype();
            List<TerminalNode> vil = ctx.lambdaparameter().parameter().ID();
            for (int i = 0; i < vtl.size(); i++) {
                parameter.add(new VarDefNode((TypeNode) visit(vtl.get(i)), vil.get(i).getText(), null, new Position(ctx)));
            }
        }
        ArrayList<ExprNode> List = null;
        if (ctx.parameterforcall() != null) {
            List = new ArrayList<ExprNode>();
            for (MxParser.ExpressionContext ele : ctx.parameterforcall().expression()) {
                List.add((ExprNode) visit(ele));
            }
        }
        return new LambdaExprNode(parameter, List, (BlockStmtNode) visit(ctx.block()), new Position(ctx));
    }

    public ASTNode visitIfStmt(MxParser.IfStmtContext ctx) {
        ExprNode cdExpr = (ExprNode) visit(ctx.condition);
        StmtNode thStmt = (StmtNode) visit(ctx.thenStmt);
        StmtNode elStmt = (ctx.elseStmt == null) ? null : (StmtNode) visit(ctx.elseStmt);
        return new IfStmtNode(cdExpr, thStmt, elStmt, new Position(ctx));
    }

    public ASTNode visitWhileStmt(MxParser.WhileStmtContext ctx) {
        ExprNode cdExpr = (ExprNode) visit(ctx.condition);
        StmtNode bodyStmt = (StmtNode) visit(ctx.loopBody);
        return new WhileStmtNode(cdExpr, bodyStmt, new Position(ctx));
    }

    public ASTNode visitForStmt(MxParser.ForStmtContext ctx) {
        StmtNode init = null;
        if (ctx.initDef != null) init = (StmtNode) visit(ctx.initDef);
        else if (ctx.initExpr != null) init = new ExprStmtNode((ExprNode) visit(ctx.initExpr), new Position(ctx));
        StmtNode loopBody = (StmtNode) visit(ctx.loopBody);
        ExprNode condition = (ctx.condition == null) ? null : (ExprNode) visit(ctx.condition);
        ExprNode incr = (ctx.incrExpr == null) ? null : (ExprNode) visit(ctx.incrExpr);
        return new ForStmtNode(init, condition, incr, loopBody, new Position(ctx));
    }

    public ASTNode visitJumpStatement(MxParser.JumpStatementContext ctx) {
        return visit(ctx.jumpStmt());
    }

    public ASTNode visitJumpStmt(MxParser.JumpStmtContext ctx) {
        if (ctx.RETURN() != null) {
            return new ReturnStmtNode((ctx.expression() == null) ? null : (ExprNode) visit(ctx.expression()), new Position(ctx));
        } else if (ctx.BREAK() != null) {
            return new BreakStmtNode(new Position(ctx));
        } else if (ctx.CONTINUE() != null) {
            return new ContinueStmtNode(new Position(ctx));
        } else return null;
    }

    public ASTNode visitExprStmt(MxParser.ExprStmtContext ctx) {
        return new ExprStmtNode((ExprNode) visit(ctx.expression()), new Position(ctx));
    }

    public ASTNode visitVardefStmt(MxParser.VardefStmtContext ctx) {
        return visit(ctx.variabledef());
    }

    public ASTNode visitInnerBlock(MxParser.InnerBlockContext ctx) {
        return visit(ctx.block());
    }

    public ASTNode visitBlock(MxParser.BlockContext ctx) {
        ArrayList<StmtNode> List = null;
        if (ctx.stmt() != null) {
            for (MxParser.StmtContext ele : ctx.stmt()) {
                if (!(ele instanceof MxParser.BlankStmtContext)) {
                    if (List == null) List = new ArrayList<StmtNode>();
                    List.add((StmtNode) visit(ele));
                }
            }
        }
        return new BlockStmtNode(List, new Position(ctx));
    }

    public ASTNode visitVariabledef(MxParser.VariabledefContext ctx) {
        TypeNode varType = (TypeNode) visit(ctx.vartype());
        ArrayList<VarDefNode> List_ = new ArrayList<VarDefNode>();
        for (MxParser.BaseVarDefContext element : ctx.baseVarDef()) {
            String id = element.ID().getText();
            ExprNode initVal = (element.expression() == null) ? null : (ExprNode) visit(element.expression());
            List_.add(new VarDefNode(varType, id, initVal, new Position(ctx)));
        }
        return new VarDefStmtNode(List_, new Position(ctx));
    }

    public ASTNode visitFunctiondef(MxParser.FunctiondefContext ctx) {
        TypeNode funcType = (ctx.functype() == null) ? null : (TypeNode) visit(ctx.functype());
        String funcName = ctx.ID().getText();
        BlockStmtNode funcBody = (BlockStmtNode) visit(ctx.block());
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
