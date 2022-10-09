package Parser;
// Generated from D:/java/code/Compiler/src\Mx.g4 by ANTLR 4.10.1

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link MxParser#program}.
     *
     * @param ctx the parse tree
     */
    void enterProgram(MxParser.ProgramContext ctx);

    /**
     * Exit a parse tree produced by {@link MxParser#program}.
     *
     * @param ctx the parse tree
     */
    void exitProgram(MxParser.ProgramContext ctx);

    /**
     * Enter a parse tree produced by {@link MxParser#subprogram}.
     *
     * @param ctx the parse tree
     */
    void enterSubprogram(MxParser.SubprogramContext ctx);

    /**
     * Exit a parse tree produced by {@link MxParser#subprogram}.
     *
     * @param ctx the parse tree
     */
    void exitSubprogram(MxParser.SubprogramContext ctx);

    /**
     * Enter a parse tree produced by {@link MxParser#functiondef}.
     *
     * @param ctx the parse tree
     */
    void enterFunctiondef(MxParser.FunctiondefContext ctx);

    /**
     * Exit a parse tree produced by {@link MxParser#functiondef}.
     *
     * @param ctx the parse tree
     */
    void exitFunctiondef(MxParser.FunctiondefContext ctx);

    /**
     * Enter a parse tree produced by {@link MxParser#classdef}.
     *
     * @param ctx the parse tree
     */
    void enterClassdef(MxParser.ClassdefContext ctx);

    /**
     * Exit a parse tree produced by {@link MxParser#classdef}.
     *
     * @param ctx the parse tree
     */
    void exitClassdef(MxParser.ClassdefContext ctx);

    /**
     * Enter a parse tree produced by {@link MxParser#variabledef}.
     *
     * @param ctx the parse tree
     */
    void enterVariabledef(MxParser.VariabledefContext ctx);

    /**
     * Exit a parse tree produced by {@link MxParser#variabledef}.
     *
     * @param ctx the parse tree
     */
    void exitVariabledef(MxParser.VariabledefContext ctx);

    /**
     * Enter a parse tree produced by {@link MxParser#block}.
     *
     * @param ctx the parse tree
     */
    void enterBlock(MxParser.BlockContext ctx);

    /**
     * Exit a parse tree produced by {@link MxParser#block}.
     *
     * @param ctx the parse tree
     */
    void exitBlock(MxParser.BlockContext ctx);

    /**
     * Enter a parse tree produced by {@link MxParser#stat}.
     *
     * @param ctx the parse tree
     */
    void enterStat(MxParser.StatContext ctx);

    /**
     * Exit a parse tree produced by {@link MxParser#stat}.
     *
     * @param ctx the parse tree
     */
    void exitStat(MxParser.StatContext ctx);

    /**
     * Enter a parse tree produced by {@link MxParser#expression}.
     *
     * @param ctx the parse tree
     */
    void enterExpression(MxParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link MxParser#expression}.
     *
     * @param ctx the parse tree
     */
    void exitExpression(MxParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link MxParser#parameterforcall}.
     *
     * @param ctx the parse tree
     */
    void enterParameterforcall(MxParser.ParameterforcallContext ctx);

    /**
     * Exit a parse tree produced by {@link MxParser#parameterforcall}.
     *
     * @param ctx the parse tree
     */
    void exitParameterforcall(MxParser.ParameterforcallContext ctx);

    /**
     * Enter a parse tree produced by {@link MxParser#parameter}.
     *
     * @param ctx the parse tree
     */
    void enterParameter(MxParser.ParameterContext ctx);

    /**
     * Exit a parse tree produced by {@link MxParser#parameter}.
     *
     * @param ctx the parse tree
     */
    void exitParameter(MxParser.ParameterContext ctx);

    /**
     * Enter a parse tree produced by {@link MxParser#vartype}.
     *
     * @param ctx the parse tree
     */
    void enterVartype(MxParser.VartypeContext ctx);

    /**
     * Exit a parse tree produced by {@link MxParser#vartype}.
     *
     * @param ctx the parse tree
     */
    void exitVartype(MxParser.VartypeContext ctx);
}