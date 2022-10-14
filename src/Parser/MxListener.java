// Generated from D:/java/code/Compiler/src\Mx.g4 by ANTLR 4.10.1
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#subprogram}.
	 * @param ctx the parse tree
	 */
	void enterSubprogram(MxParser.SubprogramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#subprogram}.
	 * @param ctx the parse tree
	 */
	void exitSubprogram(MxParser.SubprogramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functiondef}.
	 * @param ctx the parse tree
	 */
	void enterFunctiondef(MxParser.FunctiondefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functiondef}.
	 * @param ctx the parse tree
	 */
	void exitFunctiondef(MxParser.FunctiondefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classdef}.
	 * @param ctx the parse tree
	 */
	void enterClassdef(MxParser.ClassdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classdef}.
	 * @param ctx the parse tree
	 */
	void exitClassdef(MxParser.ClassdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#variabledef}.
	 * @param ctx the parse tree
	 */
	void enterVariabledef(MxParser.VariabledefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#variabledef}.
	 * @param ctx the parse tree
	 */
	void exitVariabledef(MxParser.VariabledefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code innerBlock}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterInnerBlock(MxParser.InnerBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code innerBlock}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitInnerBlock(MxParser.InnerBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vardefStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterVardefStmt(MxParser.VardefStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vardefStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitVardefStmt(MxParser.VardefStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(MxParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(MxParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpStatement}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpStatement}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blankStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlankStmt(MxParser.BlankStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blankStmt}
	 * labeled alternative in {@link MxParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlankStmt(MxParser.BlankStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 */
	void enterJumpStmt(MxParser.JumpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#jumpStmt}.
	 * @param ctx the parse tree
	 */
	void exitJumpStmt(MxParser.JumpStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objPortion}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterObjPortion(MxParser.ObjPortionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objPortion}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitObjPortion(MxParser.ObjPortionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aftermonocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAftermonocularOp(MxParser.AftermonocularOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aftermonocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAftermonocularOp(MxParser.AftermonocularOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constant}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MxParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constant}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MxParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compoundExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompoundExpr(MxParser.CompoundExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compoundExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompoundExpr(MxParser.CompoundExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpr(MxParser.LambdaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpr(MxParser.LambdaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allocExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAllocExpr(MxParser.AllocExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allocExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAllocExpr(MxParser.AllocExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code monocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMonocularOp(MxParser.MonocularOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code monocularOp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMonocularOp(MxParser.MonocularOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objPointer}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterObjPointer(MxParser.ObjPointerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objPointer}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitObjPointer(MxParser.ObjPointerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(MxParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAccess}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(MxParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAccess}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(MxParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allocErrorFormat}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void enterAllocErrorFormat(MxParser.AllocErrorFormatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allocErrorFormat}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void exitAllocErrorFormat(MxParser.AllocErrorFormatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allocArrayFormat}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void enterAllocArrayFormat(MxParser.AllocArrayFormatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allocArrayFormat}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void exitAllocArrayFormat(MxParser.AllocArrayFormatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allocBaseFormat}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void enterAllocBaseFormat(MxParser.AllocBaseFormatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allocBaseFormat}
	 * labeled alternative in {@link MxParser#allocFormat}.
	 * @param ctx the parse tree
	 */
	void exitAllocBaseFormat(MxParser.AllocBaseFormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameterforcall}.
	 * @param ctx the parse tree
	 */
	void enterParameterforcall(MxParser.ParameterforcallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameterforcall}.
	 * @param ctx the parse tree
	 */
	void exitParameterforcall(MxParser.ParameterforcallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MxParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MxParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#vartype}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MxParser#vartype}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baseType}
	 * labeled alternative in {@link MxParser#vartype}.
	 * @param ctx the parse tree
	 */
	void enterBaseType(MxParser.BaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseType}
	 * labeled alternative in {@link MxParser#vartype}.
	 * @param ctx the parse tree
	 */
	void exitBaseType(MxParser.BaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#baseVarDef}.
	 * @param ctx the parse tree
	 */
	void enterBaseVarDef(MxParser.BaseVarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#baseVarDef}.
	 * @param ctx the parse tree
	 */
	void exitBaseVarDef(MxParser.BaseVarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functype}.
	 * @param ctx the parse tree
	 */
	void enterFunctype(MxParser.FunctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functype}.
	 * @param ctx the parse tree
	 */
	void exitFunctype(MxParser.FunctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#lambdaparameter}.
	 * @param ctx the parse tree
	 */
	void enterLambdaparameter(MxParser.LambdaparameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#lambdaparameter}.
	 * @param ctx the parse tree
	 */
	void exitLambdaparameter(MxParser.LambdaparameterContext ctx);
}