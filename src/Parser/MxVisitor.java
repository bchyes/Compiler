package Parser;
// Generated from D:/java/code/Compiler/src\Mx.g4 by ANTLR 4.10.1

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface MxVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link MxParser#program}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgram(MxParser.ProgramContext ctx);

    /**
     * Visit a parse tree produced by {@link MxParser#subprogram}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSubprogram(MxParser.SubprogramContext ctx);

    /**
     * Visit a parse tree produced by {@link MxParser#functiondef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctiondef(MxParser.FunctiondefContext ctx);

    /**
     * Visit a parse tree produced by {@link MxParser#classdef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitClassdef(MxParser.ClassdefContext ctx);

    /**
     * Visit a parse tree produced by {@link MxParser#variabledef}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVariabledef(MxParser.VariabledefContext ctx);

    /**
     * Visit a parse tree produced by {@link MxParser#block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBlock(MxParser.BlockContext ctx);

    /**
     * Visit a parse tree produced by {@link MxParser#stat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStat(MxParser.StatContext ctx);

    /**
     * Visit a parse tree produced by {@link MxParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression(MxParser.ExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link MxParser#parameterforcall}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParameterforcall(MxParser.ParameterforcallContext ctx);

    /**
     * Visit a parse tree produced by {@link MxParser#parameter}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParameter(MxParser.ParameterContext ctx);

    /**
     * Visit a parse tree produced by {@link MxParser#vartype}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVartype(MxParser.VartypeContext ctx);
}