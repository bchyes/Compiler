// Generated from D:/java/code/Compiler/src\Mx.g4 by ANTLR 4.10.1
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#subprogram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubprogram(MxParser.SubprogramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functiondef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiondef(MxParser.FunctiondefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdef(MxParser.ClassdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#variabledef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariabledef(MxParser.VariabledefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MxParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code innerBlock}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerBlock(MxParser.InnerBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vardefStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardefStmt(MxParser.VardefStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(MxParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jumpStatement}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blankStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlankStmt(MxParser.BlankStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStmt(MxParser.JumpStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objPortion}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjPortion(MxParser.ObjPortionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aftermonocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAftermonocularOp(MxParser.AftermonocularOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constant}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MxParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compoundExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundExpr(MxParser.CompoundExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpr(MxParser.LambdaExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allocExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllocExpr(MxParser.AllocExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code monocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonocularOp(MxParser.MonocularOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAccess}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(MxParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameterforcall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterforcall(MxParser.ParameterforcallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MxParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#vartype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code baseType}
	 * labeled alternative in {@link MxParser#vartype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(MxParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#baseVarDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseVarDef(MxParser.BaseVarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctype(MxParser.FunctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#lambdaparameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaparameter(MxParser.LambdaparameterContext ctx);
}