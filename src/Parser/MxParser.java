// Generated from D:/java/code/Compiler/src\Mx.g4 by ANTLR 4.10.1
package Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, BOOL=36, VOID=37, INT=38, STRING=39, 
		IF=40, ELSE=41, FOR=42, WHILE=43, NEW=44, NULL=45, BREAK=46, CONTINUE=47, 
		RETURN=48, OPEATOR=49, True=50, False=51, ID=52, INT_C=53, STRING_C=54, 
		WS=55, COMMENT=56;
	public static final int
		RULE_program = 0, RULE_subprogram = 1, RULE_functiondef = 2, RULE_classdef = 3, 
		RULE_variabledef = 4, RULE_block = 5, RULE_stmt = 6, RULE_jumpStmt = 7, 
		RULE_expression = 8, RULE_allocFormat = 9, RULE_parameterforcall = 10, 
		RULE_parameter = 11, RULE_vartype = 12, RULE_baseVarDef = 13, RULE_functype = 14, 
		RULE_lambdaparameter = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "subprogram", "functiondef", "classdef", "variabledef", "block", 
			"stmt", "jumpStmt", "expression", "allocFormat", "parameterforcall", 
			"parameter", "vartype", "baseVarDef", "functype", "lambdaparameter"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "'class'", "'{'", "'}'", "','", "'.'", "'['", 
			"']'", "'++'", "'--'", "'!'", "'~'", "'*'", "'/'", "'%'", "'+'", "'-'", 
			"'>>'", "'<<'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'&'", 
			"'^'", "'|'", "'&&'", "'||'", "'='", "'this'", "'->'", "'bool'", "'void'", 
			"'int'", "'string'", "'if'", "'else'", "'for'", "'while'", "'new'", "'null'", 
			"'break'", "'continue'", "'return'", null, "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"BOOL", "VOID", "INT", "STRING", "IF", "ELSE", "FOR", "WHILE", "NEW", 
			"NULL", "BREAK", "CONTINUE", "RETURN", "OPEATOR", "True", "False", "ID", 
			"INT_C", "STRING_C", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Mx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<SubprogramContext> subprogram() {
			return getRuleContexts(SubprogramContext.class);
		}
		public SubprogramContext subprogram(int i) {
			return getRuleContext(SubprogramContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << BOOL) | (1L << VOID) | (1L << INT) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				{
				setState(32);
				subprogram();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubprogramContext extends ParserRuleContext {
		public FunctiondefContext functiondef() {
			return getRuleContext(FunctiondefContext.class,0);
		}
		public ClassdefContext classdef() {
			return getRuleContext(ClassdefContext.class,0);
		}
		public VariabledefContext variabledef() {
			return getRuleContext(VariabledefContext.class,0);
		}
		public SubprogramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subprogram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSubprogram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSubprogram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSubprogram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubprogramContext subprogram() throws RecognitionException {
		SubprogramContext _localctx = new SubprogramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_subprogram);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				functiondef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				classdef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				variabledef();
				setState(41);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctiondefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctypeContext functype() {
			return getRuleContext(FunctypeContext.class,0);
		}
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public FunctiondefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiondef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFunctiondef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFunctiondef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFunctiondef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctiondefContext functiondef() throws RecognitionException {
		FunctiondefContext _localctx = new FunctiondefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functiondef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(45);
				functype();
				}
				break;
			}
			setState(48);
			match(ID);
			setState(49);
			match(T__1);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				setState(50);
				parameter();
				}
			}

			setState(53);
			match(T__2);
			setState(54);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassdefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public List<VariabledefContext> variabledef() {
			return getRuleContexts(VariabledefContext.class);
		}
		public VariabledefContext variabledef(int i) {
			return getRuleContext(VariabledefContext.class,i);
		}
		public List<FunctiondefContext> functiondef() {
			return getRuleContexts(FunctiondefContext.class);
		}
		public FunctiondefContext functiondef(int i) {
			return getRuleContext(FunctiondefContext.class,i);
		}
		public ClassdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassdefContext classdef() throws RecognitionException {
		ClassdefContext _localctx = new ClassdefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__3);
			setState(57);
			match(ID);
			setState(58);
			match(T__4);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << VOID) | (1L << INT) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				setState(63);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(59);
					variabledef();
					setState(60);
					match(T__0);
					}
					break;
				case 2:
					{
					setState(62);
					functiondef();
					}
					break;
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			match(T__5);
			setState(69);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariabledefContext extends ParserRuleContext {
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public List<BaseVarDefContext> baseVarDef() {
			return getRuleContexts(BaseVarDefContext.class);
		}
		public BaseVarDefContext baseVarDef(int i) {
			return getRuleContext(BaseVarDefContext.class,i);
		}
		public VariabledefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variabledef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVariabledef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVariabledef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVariabledef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariabledefContext variabledef() throws RecognitionException {
		VariabledefContext _localctx = new VariabledefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variabledef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			vartype(0);
			{
			setState(72);
			baseVarDef();
			}
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(73);
				match(T__6);
				setState(74);
				baseVarDef();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__4);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__4) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__17) | (1L << T__18) | (1L << T__33) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << NEW) | (1L << NULL) | (1L << BREAK) | (1L << CONTINUE) | (1L << RETURN) | (1L << True) | (1L << False) | (1L << ID) | (1L << INT_C) | (1L << STRING_C))) != 0)) {
				{
				{
				setState(81);
				stmt();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }

		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprStmtContext extends StmtContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExprStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStmtContext extends StmtContext {
		public VariabledefContext initDef;
		public ExpressionContext initExpr;
		public ExpressionContext condition;
		public ExpressionContext incrExpr;
		public StmtContext loopBody;
		public TerminalNode FOR() { return getToken(MxParser.FOR, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public VariabledefContext variabledef() {
			return getRuleContext(VariabledefContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlankStmtContext extends StmtContext {
		public BlankStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBlankStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBlankStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBlankStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtContext extends StmtContext {
		public ExpressionContext condition;
		public StmtContext loopBody;
		public TerminalNode WHILE() { return getToken(MxParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStmtContext extends StmtContext {
		public ExpressionContext condition;
		public StmtContext thenStmt;
		public StmtContext elseStmt;
		public TerminalNode IF() { return getToken(MxParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MxParser.ELSE, 0); }
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InnerBlockContext extends StmtContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public InnerBlockContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterInnerBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitInnerBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitInnerBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VardefStmtContext extends StmtContext {
		public VariabledefContext variabledef() {
			return getRuleContext(VariabledefContext.class,0);
		}
		public VardefStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVardefStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVardefStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVardefStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JumpStatementContext extends StmtContext {
		public JumpStmtContext jumpStmt() {
			return getRuleContext(JumpStmtContext.class,0);
		}
		public JumpStatementContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stmt);
		int _la;
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new InnerBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				block();
				}
				break;
			case 2:
				_localctx = new VardefStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				variabledef();
				setState(91);
				match(T__0);
				}
				break;
			case 3:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				expression(0);
				setState(94);
				match(T__0);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				match(IF);
				setState(97);
				match(T__1);
				setState(98);
				((IfStmtContext)_localctx).condition = expression(0);
				setState(99);
				match(T__2);
				setState(100);
				((IfStmtContext)_localctx).thenStmt = stmt();
				setState(103);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(101);
					match(ELSE);
					setState(102);
					((IfStmtContext)_localctx).elseStmt = stmt();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				match(FOR);
				setState(106);
				match(T__1);
				setState(109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(107);
					((ForStmtContext)_localctx).initDef = variabledef();
					}
					break;
				case 2:
					{
					setState(108);
					((ForStmtContext)_localctx).initExpr = expression(0);
					}
					break;
				}
				setState(111);
				match(T__0);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__17) | (1L << T__18) | (1L << T__33) | (1L << NEW) | (1L << NULL) | (1L << True) | (1L << False) | (1L << ID) | (1L << INT_C) | (1L << STRING_C))) != 0)) {
					{
					setState(112);
					((ForStmtContext)_localctx).condition = expression(0);
					}
				}

				setState(115);
				match(T__0);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__17) | (1L << T__18) | (1L << T__33) | (1L << NEW) | (1L << NULL) | (1L << True) | (1L << False) | (1L << ID) | (1L << INT_C) | (1L << STRING_C))) != 0)) {
					{
					setState(116);
					((ForStmtContext)_localctx).incrExpr = expression(0);
					}
				}

				setState(119);
				match(T__2);
				setState(120);
				((ForStmtContext)_localctx).loopBody = stmt();
				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(121);
				match(WHILE);
				setState(122);
				match(T__1);
				setState(123);
				((WhileStmtContext)_localctx).condition = expression(0);
				setState(124);
				match(T__2);
				setState(125);
				((WhileStmtContext)_localctx).loopBody = stmt();
				}
				break;
			case 7:
				_localctx = new JumpStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(127);
				jumpStmt();
				}
				break;
			case 8:
				_localctx = new BlankStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(128);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpStmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(MxParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(MxParser.CONTINUE, 0); }
		public TerminalNode RETURN() { return getToken(MxParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterJumpStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitJumpStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitJumpStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStmtContext jumpStmt() throws RecognitionException {
		JumpStmtContext _localctx = new JumpStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_jumpStmt);
		int _la;
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(BREAK);
				setState(132);
				match(T__0);
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(CONTINUE);
				setState(134);
				match(T__0);
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				match(RETURN);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__17) | (1L << T__18) | (1L << T__33) | (1L << NEW) | (1L << NULL) | (1L << True) | (1L << False) | (1L << ID) | (1L << INT_C) | (1L << STRING_C))) != 0)) {
					{
					setState(136);
					expression(0);
					}
				}

				setState(139);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }

		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ObjPortionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public ObjPortionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterObjPortion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitObjPortion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitObjPortion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public IdentifierContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AftermonocularOpContext extends ExpressionContext {
		public ExpressionContext operand;
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AftermonocularOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAftermonocularOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAftermonocularOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAftermonocularOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantContext extends ExpressionContext {
		public TerminalNode True() { return getToken(MxParser.True, 0); }
		public TerminalNode False() { return getToken(MxParser.False, 0); }
		public TerminalNode INT_C() { return getToken(MxParser.INT_C, 0); }
		public TerminalNode NULL() { return getToken(MxParser.NULL, 0); }
		public TerminalNode STRING_C() { return getToken(MxParser.STRING_C, 0); }
		public ConstantContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompoundExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompoundExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCompoundExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCompoundExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCompoundExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaExprContext extends ExpressionContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaparameterContext lambdaparameter() {
			return getRuleContext(LambdaparameterContext.class,0);
		}
		public ParameterforcallContext parameterforcall() {
			return getRuleContext(ParameterforcallContext.class,0);
		}
		public LambdaExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLambdaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLambdaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLambdaExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AllocExprContext extends ExpressionContext {
		public TerminalNode NEW() { return getToken(MxParser.NEW, 0); }
		public AllocFormatContext allocFormat() {
			return getRuleContext(AllocFormatContext.class,0);
		}
		public AllocExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAllocExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAllocExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAllocExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MonocularOpContext extends ExpressionContext {
		public Token op;
		public ExpressionContext operand;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MonocularOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterMonocularOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitMonocularOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitMonocularOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjPointerContext extends ExpressionContext {
		public ObjPointerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterObjPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitObjPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitObjPointer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExpressionContext {
		public ExpressionContext operand1;
		public Token op;
		public ExpressionContext operand2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParameterforcallContext parameterforcall() {
			return getRuleContext(ParameterforcallContext.class,0);
		}
		public FuncCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAccessContext extends ExpressionContext {
		public ExpressionContext array;
		public ExpressionContext index;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(143);
				match(ID);
				}
				break;
			case NULL:
			case True:
			case False:
			case INT_C:
			case STRING_C:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << True) | (1L << False) | (1L << INT_C) | (1L << STRING_C))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case NEW:
				{
				_localctx = new AllocExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(NEW);
				setState(146);
				allocFormat();
				}
				break;
			case T__1:
				{
				_localctx = new CompoundExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(T__1);
				setState(148);
				expression(0);
				setState(149);
				match(T__2);
				}
				break;
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				{
				_localctx = new MonocularOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				((MonocularOpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
					((MonocularOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(152);
				((MonocularOpContext)_localctx).operand = expression(14);
				}
				break;
			case T__17:
			case T__18:
				{
				_localctx = new MonocularOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				((MonocularOpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__17 || _la==T__18) ) {
					((MonocularOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(154);
				((MonocularOpContext)_localctx).operand = expression(11);
				}
				break;
			case T__33:
				{
				_localctx = new ObjPointerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				match(T__33);
				}
				break;
			case T__8:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				match(T__8);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__27) {
					{
					setState(157);
					match(T__27);
					}
				}

				setState(160);
				match(T__9);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(161);
					lambdaparameter();
					}
				}

				setState(164);
				match(T__34);
				setState(165);
				block();
				setState(166);
				match(T__1);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__17) | (1L << T__18) | (1L << T__33) | (1L << NEW) | (1L << NULL) | (1L << True) | (1L << False) | (1L << ID) | (1L << INT_C) | (1L << STRING_C))) != 0)) {
					{
					setState(167);
					parameterforcall();
					}
				}

				setState(170);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(225);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(174);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(175);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(176);
						((BinaryExprContext)_localctx).operand2 = expression(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(177);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(178);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(179);
						((BinaryExprContext)_localctx).operand2 = expression(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(181);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(182);
						((BinaryExprContext)_localctx).operand2 = expression(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(184);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(185);
						((BinaryExprContext)_localctx).operand2 = expression(10);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(187);
						((BinaryExprContext)_localctx).op = match(T__27);
						setState(188);
						((BinaryExprContext)_localctx).operand2 = expression(9);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(190);
						((BinaryExprContext)_localctx).op = match(T__28);
						setState(191);
						((BinaryExprContext)_localctx).operand2 = expression(8);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(193);
						((BinaryExprContext)_localctx).op = match(T__29);
						setState(194);
						((BinaryExprContext)_localctx).operand2 = expression(7);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(196);
						((BinaryExprContext)_localctx).op = match(T__30);
						setState(197);
						((BinaryExprContext)_localctx).operand2 = expression(6);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(199);
						((BinaryExprContext)_localctx).op = match(T__31);
						setState(200);
						((BinaryExprContext)_localctx).operand2 = expression(5);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).operand1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(202);
						((BinaryExprContext)_localctx).op = match(T__32);
						setState(203);
						((BinaryExprContext)_localctx).operand2 = expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ObjPortionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(205);
						match(T__7);
						setState(210);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__1:
							{
							setState(206);
							match(T__1);
							setState(207);
							match(ID);
							setState(208);
							match(T__2);
							}
							break;
						case ID:
							{
							setState(209);
							match(ID);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					case 12:
						{
						_localctx = new FuncCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(212);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(213);
						match(T__1);
						setState(215);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__17) | (1L << T__18) | (1L << T__33) | (1L << NEW) | (1L << NULL) | (1L << True) | (1L << False) | (1L << ID) | (1L << INT_C) | (1L << STRING_C))) != 0)) {
							{
							setState(214);
							parameterforcall();
							}
						}

						setState(217);
						match(T__2);
						}
						break;
					case 13:
						{
						_localctx = new ArrayAccessContext(new ExpressionContext(_parentctx, _parentState));
						((ArrayAccessContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(218);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(219);
						match(T__8);
						setState(220);
						((ArrayAccessContext)_localctx).index = expression(0);
						setState(221);
						match(T__9);
						}
						break;
					case 14:
						{
						_localctx = new AftermonocularOpContext(new ExpressionContext(_parentctx, _parentState));
						((AftermonocularOpContext)_localctx).operand = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(224);
						((AftermonocularOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
							((AftermonocularOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					}
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AllocFormatContext extends ParserRuleContext {
		public AllocFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allocFormat; }

		public AllocFormatContext() { }
		public void copyFrom(AllocFormatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AllocErrorFormatContext extends AllocFormatContext {
		public TerminalNode BOOL() { return getToken(MxParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(MxParser.INT, 0); }
		public TerminalNode STRING() { return getToken(MxParser.STRING, 0); }
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AllocErrorFormatContext(AllocFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAllocErrorFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAllocErrorFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAllocErrorFormat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AllocArrayFormatContext extends AllocFormatContext {
		public Token base;
		public TerminalNode BOOL() { return getToken(MxParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(MxParser.INT, 0); }
		public TerminalNode STRING() { return getToken(MxParser.STRING, 0); }
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AllocArrayFormatContext(AllocFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAllocArrayFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAllocArrayFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAllocArrayFormat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AllocBaseFormatContext extends AllocFormatContext {
		public Token base;
		public TerminalNode BOOL() { return getToken(MxParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(MxParser.INT, 0); }
		public TerminalNode STRING() { return getToken(MxParser.STRING, 0); }
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public AllocBaseFormatContext(AllocFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAllocBaseFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAllocBaseFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAllocBaseFormat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllocFormatContext allocFormat() throws RecognitionException {
		AllocFormatContext _localctx = new AllocFormatContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_allocFormat);
		int _la;
		try {
			int _alt;
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new AllocErrorFormatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << ID))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(231);
						match(T__8);
						setState(232);
						expression(0);
						setState(233);
						match(T__9);
						}
						}
					}
					setState(239);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				setState(242);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(240);
						match(T__8);
						setState(241);
						match(T__9);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(244);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(250);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(246);
						match(T__8);
						setState(247);
						expression(0);
						setState(248);
						match(T__9);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(252);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				_localctx = new AllocArrayFormatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				((AllocArrayFormatContext)_localctx).base = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << ID))) != 0)) ) {
					((AllocArrayFormatContext)_localctx).base = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(259);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(255);
						match(T__8);
						setState(256);
						expression(0);
						setState(257);
						match(T__9);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(261);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(263);
						match(T__8);
						setState(264);
						match(T__9);
						}
						}
					}
					setState(269);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				}
				break;
			case 3:
				_localctx = new AllocBaseFormatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(270);
				((AllocBaseFormatContext)_localctx).base = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << ID))) != 0)) ) {
					((AllocBaseFormatContext)_localctx).base = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(273);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(271);
					match(T__1);
					setState(272);
					match(T__2);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterforcallContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ParameterforcallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterforcall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterParameterforcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitParameterforcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitParameterforcall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterforcallContext parameterforcall() throws RecognitionException {
		ParameterforcallContext _localctx = new ParameterforcallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameterforcall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			expression(0);
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(278);
				match(T__6);
				setState(279);
				expression(0);
				}
				}
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public List<VartypeContext> vartype() {
			return getRuleContexts(VartypeContext.class);
		}
		public VartypeContext vartype(int i) {
			return getRuleContext(VartypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(MxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MxParser.ID, i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			vartype(0);
			setState(286);
			match(ID);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(287);
				match(T__6);
				setState(288);
				vartype(0);
				setState(289);
				match(ID);
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VartypeContext extends ParserRuleContext {
		public VartypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vartype; }

		public VartypeContext() { }
		public void copyFrom(VartypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeContext extends VartypeContext {
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public ArrayTypeContext(VartypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BaseTypeContext extends VartypeContext {
		public TerminalNode BOOL() { return getToken(MxParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(MxParser.INT, 0); }
		public TerminalNode STRING() { return getToken(MxParser.STRING, 0); }
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public BaseTypeContext(VartypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VartypeContext vartype() throws RecognitionException {
		return vartype(0);
	}

	private VartypeContext vartype(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VartypeContext _localctx = new VartypeContext(_ctx, _parentState);
		VartypeContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_vartype, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new BaseTypeContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(297);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(304);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(new VartypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_vartype);
					setState(299);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(300);
					match(T__8);
					setState(301);
					match(T__9);
					}
					}
				}
				setState(306);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BaseVarDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BaseVarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseVarDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBaseVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBaseVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBaseVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseVarDefContext baseVarDef() throws RecognitionException {
		BaseVarDefContext _localctx = new BaseVarDefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_baseVarDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(ID);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(308);
				match(T__32);
				setState(309);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctypeContext extends ParserRuleContext {
		public VartypeContext vartype() {
			return getRuleContext(VartypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(MxParser.VOID, 0); }
		public FunctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFunctype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFunctype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFunctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctypeContext functype() throws RecognitionException {
		FunctypeContext _localctx = new FunctypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functype);
		try {
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				vartype(0);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaparameterContext extends ParserRuleContext {
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public LambdaparameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaparameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLambdaparameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLambdaparameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLambdaparameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaparameterContext lambdaparameter() throws RecognitionException {
		LambdaparameterContext _localctx = new LambdaparameterContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_lambdaparameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(316);
			match(T__1);
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				setState(317);
				parameter();
				}
			}

			setState(320);
			match(T__2);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 12:
			return vartype_sempred((VartypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 20);
		case 11:
			return precpred(_ctx, 18);
		case 12:
			return precpred(_ctx, 16);
		case 13:
			return precpred(_ctx, 15);
		}
		return true;
	}
	private boolean vartype_sempred(VartypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u0143\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001,\b\u0001"+
		"\u0001\u0002\u0003\u0002/\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u00024\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003@\b\u0003\n\u0003\f\u0003C\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"L\b\u0004\n\u0004\f\u0004O\t\u0004\u0001\u0005\u0001\u0005\u0005\u0005"+
		"S\b\u0005\n\u0005\f\u0005V\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006h\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006n\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"r\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006v\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0082\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u008a"+
		"\b\u0007\u0001\u0007\u0003\u0007\u008d\b\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u009f\b\b\u0001\b\u0001\b\u0003"+
		"\b\u00a3\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a9\b\b\u0001\b"+
		"\u0001\b\u0003\b\u00ad\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u00d3\b\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00d8\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0005\b\u00e2\b\b\n\b\f\b\u00e5\t\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0005\t\u00ec\b\t\n\t\f\t\u00ef\t\t\u0001\t\u0001\t\u0004\t\u00f3"+
		"\b\t\u000b\t\f\t\u00f4\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00fb\b"+
		"\t\u000b\t\f\t\u00fc\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u0104"+
		"\b\t\u000b\t\f\t\u0105\u0001\t\u0001\t\u0005\t\u010a\b\t\n\t\f\t\u010d"+
		"\t\t\u0001\t\u0001\t\u0001\t\u0003\t\u0112\b\t\u0003\t\u0114\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u0119\b\n\n\n\f\n\u011c\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0124"+
		"\b\u000b\n\u000b\f\u000b\u0127\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0005\f\u012f\b\f\n\f\f\f\u0132\t\f\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u0137\b\r\u0001\u000e\u0001\u000e\u0003\u000e\u013b\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u013f\b\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0000\u0002\u0010\u0018\u0010\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\b\u0003"+
		"\u0000--2356\u0001\u0000\u000b\u000e\u0001\u0000\u0012\u0013\u0001\u0000"+
		"\u000f\u0011\u0001\u0000\u0014\u0015\u0001\u0000\u0016\u001b\u0001\u0000"+
		"\u000b\f\u0003\u0000$$&\'44\u0172\u0000#\u0001\u0000\u0000\u0000\u0002"+
		"+\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u00068\u0001"+
		"\u0000\u0000\u0000\bG\u0001\u0000\u0000\u0000\nP\u0001\u0000\u0000\u0000"+
		"\f\u0081\u0001\u0000\u0000\u0000\u000e\u008c\u0001\u0000\u0000\u0000\u0010"+
		"\u00ac\u0001\u0000\u0000\u0000\u0012\u0113\u0001\u0000\u0000\u0000\u0014"+
		"\u0115\u0001\u0000\u0000\u0000\u0016\u011d\u0001\u0000\u0000\u0000\u0018"+
		"\u0128\u0001\u0000\u0000\u0000\u001a\u0133\u0001\u0000\u0000\u0000\u001c"+
		"\u013a\u0001\u0000\u0000\u0000\u001e\u013c\u0001\u0000\u0000\u0000 \""+
		"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000"+
		"\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\u0001\u0001"+
		"\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000&,\u0003\u0004\u0002\u0000"+
		"\',\u0003\u0006\u0003\u0000()\u0003\b\u0004\u0000)*\u0005\u0001\u0000"+
		"\u0000*,\u0001\u0000\u0000\u0000+&\u0001\u0000\u0000\u0000+\'\u0001\u0000"+
		"\u0000\u0000+(\u0001\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000"+
		"-/\u0003\u001c\u000e\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000\u0000"+
		"\u0000/0\u0001\u0000\u0000\u000001\u00054\u0000\u000013\u0005\u0002\u0000"+
		"\u000024\u0003\u0016\u000b\u000032\u0001\u0000\u0000\u000034\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000056\u0005\u0003\u0000\u000067\u0003"+
		"\n\u0005\u00007\u0005\u0001\u0000\u0000\u000089\u0005\u0004\u0000\u0000"+
		"9:\u00054\u0000\u0000:A\u0005\u0005\u0000\u0000;<\u0003\b\u0004\u0000"+
		"<=\u0005\u0001\u0000\u0000=@\u0001\u0000\u0000\u0000>@\u0003\u0004\u0002"+
		"\u0000?;\u0001\u0000\u0000\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000"+
		"\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0001"+
		"\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DE\u0005\u0006\u0000\u0000"+
		"EF\u0005\u0001\u0000\u0000F\u0007\u0001\u0000\u0000\u0000GH\u0003\u0018"+
		"\f\u0000HM\u0003\u001a\r\u0000IJ\u0005\u0007\u0000\u0000JL\u0003\u001a"+
		"\r\u0000KI\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000\u0000MK\u0001\u0000"+
		"\u0000\u0000MN\u0001\u0000\u0000\u0000N\t\u0001\u0000\u0000\u0000OM\u0001"+
		"\u0000\u0000\u0000PT\u0005\u0005\u0000\u0000QS\u0003\f\u0006\u0000RQ\u0001"+
		"\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000"+
		"\u0000WX\u0005\u0006\u0000\u0000X\u000b\u0001\u0000\u0000\u0000Y\u0082"+
		"\u0003\n\u0005\u0000Z[\u0003\b\u0004\u0000[\\\u0005\u0001\u0000\u0000"+
		"\\\u0082\u0001\u0000\u0000\u0000]^\u0003\u0010\b\u0000^_\u0005\u0001\u0000"+
		"\u0000_\u0082\u0001\u0000\u0000\u0000`a\u0005(\u0000\u0000ab\u0005\u0002"+
		"\u0000\u0000bc\u0003\u0010\b\u0000cd\u0005\u0003\u0000\u0000dg\u0003\f"+
		"\u0006\u0000ef\u0005)\u0000\u0000fh\u0003\f\u0006\u0000ge\u0001\u0000"+
		"\u0000\u0000gh\u0001\u0000\u0000\u0000h\u0082\u0001\u0000\u0000\u0000"+
		"ij\u0005*\u0000\u0000jm\u0005\u0002\u0000\u0000kn\u0003\b\u0004\u0000"+
		"ln\u0003\u0010\b\u0000mk\u0001\u0000\u0000\u0000ml\u0001\u0000\u0000\u0000"+
		"mn\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0005\u0001\u0000"+
		"\u0000pr\u0003\u0010\b\u0000qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000rs\u0001\u0000\u0000\u0000su\u0005\u0001\u0000\u0000tv\u0003\u0010"+
		"\b\u0000ut\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000"+
		"\u0000\u0000wx\u0005\u0003\u0000\u0000x\u0082\u0003\f\u0006\u0000yz\u0005"+
		"+\u0000\u0000z{\u0005\u0002\u0000\u0000{|\u0003\u0010\b\u0000|}\u0005"+
		"\u0003\u0000\u0000}~\u0003\f\u0006\u0000~\u0082\u0001\u0000\u0000\u0000"+
		"\u007f\u0082\u0003\u000e\u0007\u0000\u0080\u0082\u0005\u0001\u0000\u0000"+
		"\u0081Y\u0001\u0000\u0000\u0000\u0081Z\u0001\u0000\u0000\u0000\u0081]"+
		"\u0001\u0000\u0000\u0000\u0081`\u0001\u0000\u0000\u0000\u0081i\u0001\u0000"+
		"\u0000\u0000\u0081y\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\r\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0005.\u0000\u0000\u0084\u008d\u0005\u0001\u0000\u0000\u0085"+
		"\u0086\u0005/\u0000\u0000\u0086\u008d\u0005\u0001\u0000\u0000\u0087\u0089"+
		"\u00050\u0000\u0000\u0088\u008a\u0003\u0010\b\u0000\u0089\u0088\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u008d\u0005\u0001\u0000\u0000\u008c\u0083\u0001"+
		"\u0000\u0000\u0000\u008c\u0085\u0001\u0000\u0000\u0000\u008c\u0087\u0001"+
		"\u0000\u0000\u0000\u008d\u000f\u0001\u0000\u0000\u0000\u008e\u008f\u0006"+
		"\b\uffff\uffff\u0000\u008f\u00ad\u00054\u0000\u0000\u0090\u00ad\u0007"+
		"\u0000\u0000\u0000\u0091\u0092\u0005,\u0000\u0000\u0092\u00ad\u0003\u0012"+
		"\t\u0000\u0093\u0094\u0005\u0002\u0000\u0000\u0094\u0095\u0003\u0010\b"+
		"\u0000\u0095\u0096\u0005\u0003\u0000\u0000\u0096\u00ad\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0007\u0001\u0000\u0000\u0098\u00ad\u0003\u0010\b\u000e"+
		"\u0099\u009a\u0007\u0002\u0000\u0000\u009a\u00ad\u0003\u0010\b\u000b\u009b"+
		"\u00ad\u0005\"\u0000\u0000\u009c\u009e\u0005\t\u0000\u0000\u009d\u009f"+
		"\u0005\u001c\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a2"+
		"\u0005\n\u0000\u0000\u00a1\u00a3\u0003\u001e\u000f\u0000\u00a2\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0005#\u0000\u0000\u00a5\u00a6\u0003\n"+
		"\u0005\u0000\u00a6\u00a8\u0005\u0002\u0000\u0000\u00a7\u00a9\u0003\u0014"+
		"\n\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\u0003\u0000"+
		"\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac\u008e\u0001\u0000\u0000"+
		"\u0000\u00ac\u0090\u0001\u0000\u0000\u0000\u00ac\u0091\u0001\u0000\u0000"+
		"\u0000\u00ac\u0093\u0001\u0000\u0000\u0000\u00ac\u0097\u0001\u0000\u0000"+
		"\u0000\u00ac\u0099\u0001\u0000\u0000\u0000\u00ac\u009b\u0001\u0000\u0000"+
		"\u0000\u00ac\u009c\u0001\u0000\u0000\u0000\u00ad\u00e3\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\n\r\u0000\u0000\u00af\u00b0\u0007\u0003\u0000\u0000"+
		"\u00b0\u00e2\u0003\u0010\b\u000e\u00b1\u00b2\n\f\u0000\u0000\u00b2\u00b3"+
		"\u0007\u0002\u0000\u0000\u00b3\u00e2\u0003\u0010\b\r\u00b4\u00b5\n\n\u0000"+
		"\u0000\u00b5\u00b6\u0007\u0004\u0000\u0000\u00b6\u00e2\u0003\u0010\b\u000b"+
		"\u00b7\u00b8\n\t\u0000\u0000\u00b8\u00b9\u0007\u0005\u0000\u0000\u00b9"+
		"\u00e2\u0003\u0010\b\n\u00ba\u00bb\n\b\u0000\u0000\u00bb\u00bc\u0005\u001c"+
		"\u0000\u0000\u00bc\u00e2\u0003\u0010\b\t\u00bd\u00be\n\u0007\u0000\u0000"+
		"\u00be\u00bf\u0005\u001d\u0000\u0000\u00bf\u00e2\u0003\u0010\b\b\u00c0"+
		"\u00c1\n\u0006\u0000\u0000\u00c1\u00c2\u0005\u001e\u0000\u0000\u00c2\u00e2"+
		"\u0003\u0010\b\u0007\u00c3\u00c4\n\u0005\u0000\u0000\u00c4\u00c5\u0005"+
		"\u001f\u0000\u0000\u00c5\u00e2\u0003\u0010\b\u0006\u00c6\u00c7\n\u0004"+
		"\u0000\u0000\u00c7\u00c8\u0005 \u0000\u0000\u00c8\u00e2\u0003\u0010\b"+
		"\u0005\u00c9\u00ca\n\u0003\u0000\u0000\u00ca\u00cb\u0005!\u0000\u0000"+
		"\u00cb\u00e2\u0003\u0010\b\u0003\u00cc\u00cd\n\u0014\u0000\u0000\u00cd"+
		"\u00d2\u0005\b\u0000\u0000\u00ce\u00cf\u0005\u0002\u0000\u0000\u00cf\u00d0"+
		"\u00054\u0000\u0000\u00d0\u00d3\u0005\u0003\u0000\u0000\u00d1\u00d3\u0005"+
		"4\u0000\u0000\u00d2\u00ce\u0001\u0000\u0000\u0000\u00d2\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d3\u00e2\u0001\u0000\u0000\u0000\u00d4\u00d5\n\u0012\u0000"+
		"\u0000\u00d5\u00d7\u0005\u0002\u0000\u0000\u00d6\u00d8\u0003\u0014\n\u0000"+
		"\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00e2\u0005\u0003\u0000\u0000"+
		"\u00da\u00db\n\u0010\u0000\u0000\u00db\u00dc\u0005\t\u0000\u0000\u00dc"+
		"\u00dd\u0003\u0010\b\u0000\u00dd\u00de\u0005\n\u0000\u0000\u00de\u00e2"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\n\u000f\u0000\u0000\u00e0\u00e2\u0007"+
		"\u0006\u0000\u0000\u00e1\u00ae\u0001\u0000\u0000\u0000\u00e1\u00b1\u0001"+
		"\u0000\u0000\u0000\u00e1\u00b4\u0001\u0000\u0000\u0000\u00e1\u00b7\u0001"+
		"\u0000\u0000\u0000\u00e1\u00ba\u0001\u0000\u0000\u0000\u00e1\u00bd\u0001"+
		"\u0000\u0000\u0000\u00e1\u00c0\u0001\u0000\u0000\u0000\u00e1\u00c3\u0001"+
		"\u0000\u0000\u0000\u00e1\u00c6\u0001\u0000\u0000\u0000\u00e1\u00c9\u0001"+
		"\u0000\u0000\u0000\u00e1\u00cc\u0001\u0000\u0000\u0000\u00e1\u00d4\u0001"+
		"\u0000\u0000\u0000\u00e1\u00da\u0001\u0000\u0000\u0000\u00e1\u00df\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u0011\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00ed\u0007"+
		"\u0007\u0000\u0000\u00e7\u00e8\u0005\t\u0000\u0000\u00e8\u00e9\u0003\u0010"+
		"\b\u0000\u00e9\u00ea\u0005\n\u0000\u0000\u00ea\u00ec\u0001\u0000\u0000"+
		"\u0000\u00eb\u00e7\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ee\u00f2\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0005\t\u0000\u0000\u00f1\u00f3\u0005\n\u0000\u0000"+
		"\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000"+
		"\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000"+
		"\u00f5\u00fa\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005\t\u0000\u0000\u00f7"+
		"\u00f8\u0003\u0010\b\u0000\u00f8\u00f9\u0005\n\u0000\u0000\u00f9\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fa\u00f6\u0001\u0000\u0000\u0000\u00fb\u00fc"+
		"\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd"+
		"\u0001\u0000\u0000\u0000\u00fd\u0114\u0001\u0000\u0000\u0000\u00fe\u0103"+
		"\u0007\u0007\u0000\u0000\u00ff\u0100\u0005\t\u0000\u0000\u0100\u0101\u0003"+
		"\u0010\b\u0000\u0101\u0102\u0005\n\u0000\u0000\u0102\u0104\u0001\u0000"+
		"\u0000\u0000\u0103\u00ff\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000"+
		"\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000"+
		"\u0000\u0000\u0106\u010b\u0001\u0000\u0000\u0000\u0107\u0108\u0005\t\u0000"+
		"\u0000\u0108\u010a\u0005\n\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000"+
		"\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u0114\u0001\u0000\u0000\u0000"+
		"\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u0111\u0007\u0007\u0000\u0000"+
		"\u010f\u0110\u0005\u0002\u0000\u0000\u0110\u0112\u0005\u0003\u0000\u0000"+
		"\u0111\u010f\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000"+
		"\u0112\u0114\u0001\u0000\u0000\u0000\u0113\u00e6\u0001\u0000\u0000\u0000"+
		"\u0113\u00fe\u0001\u0000\u0000\u0000\u0113\u010e\u0001\u0000\u0000\u0000"+
		"\u0114\u0013\u0001\u0000\u0000\u0000\u0115\u011a\u0003\u0010\b\u0000\u0116"+
		"\u0117\u0005\u0007\u0000\u0000\u0117\u0119\u0003\u0010\b\u0000\u0118\u0116"+
		"\u0001\u0000\u0000\u0000\u0119\u011c\u0001\u0000\u0000\u0000\u011a\u0118"+
		"\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u0015"+
		"\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011d\u011e"+
		"\u0003\u0018\f\u0000\u011e\u0125\u00054\u0000\u0000\u011f\u0120\u0005"+
		"\u0007\u0000\u0000\u0120\u0121\u0003\u0018\f\u0000\u0121\u0122\u00054"+
		"\u0000\u0000\u0122\u0124\u0001\u0000\u0000\u0000\u0123\u011f\u0001\u0000"+
		"\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000"+
		"\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0017\u0001\u0000"+
		"\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u0129\u0006\f\uffff"+
		"\uffff\u0000\u0129\u012a\u0007\u0007\u0000\u0000\u012a\u0130\u0001\u0000"+
		"\u0000\u0000\u012b\u012c\n\u0001\u0000\u0000\u012c\u012d\u0005\t\u0000"+
		"\u0000\u012d\u012f\u0005\n\u0000\u0000\u012e\u012b\u0001\u0000\u0000\u0000"+
		"\u012f\u0132\u0001\u0000\u0000\u0000\u0130\u012e\u0001\u0000\u0000\u0000"+
		"\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0019\u0001\u0000\u0000\u0000"+
		"\u0132\u0130\u0001\u0000\u0000\u0000\u0133\u0136\u00054\u0000\u0000\u0134"+
		"\u0135\u0005!\u0000\u0000\u0135\u0137\u0003\u0010\b\u0000\u0136\u0134"+
		"\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u001b"+
		"\u0001\u0000\u0000\u0000\u0138\u013b\u0003\u0018\f\u0000\u0139\u013b\u0005"+
		"%\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013a\u0139\u0001\u0000"+
		"\u0000\u0000\u013b\u001d\u0001\u0000\u0000\u0000\u013c\u013e\u0005\u0002"+
		"\u0000\u0000\u013d\u013f\u0003\u0016\u000b\u0000\u013e\u013d\u0001\u0000"+
		"\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u0140\u0001\u0000"+
		"\u0000\u0000\u0140\u0141\u0005\u0003\u0000\u0000\u0141\u001f\u0001\u0000"+
		"\u0000\u0000$#+.3?AMTgmqu\u0081\u0089\u008c\u009e\u00a2\u00a8\u00ac\u00d2"+
		"\u00d7\u00e1\u00e3\u00ed\u00f4\u00fc\u0105\u010b\u0111\u0113\u011a\u0125"+
		"\u0130\u0136\u013a\u013e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}