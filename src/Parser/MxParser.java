package Parser;
// Generated from D:/java/code/Compiler/src\Mx.g4 by ANTLR 4.10.1

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
    static {
        RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24,
            T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31,
            T__31 = 32, T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36, T__36 = 37, T__37 = 38,
            T__38 = 39, T__39 = 40, T__40 = 41, T__41 = 42, T__42 = 43, T__43 = 44, T__44 = 45,
            T__45 = 46, T__46 = 47, OPEATOR = 48, BOOL = 49, ID = 50, INT = 51, STRING = 52, WS = 53,
            COMMENT = 54;
    public static final int
            RULE_program = 0, RULE_subprogram = 1, RULE_functiondef = 2, RULE_classdef = 3,
            RULE_variabledef = 4, RULE_block = 5, RULE_stat = 6, RULE_expression = 7,
            RULE_parameterforcall = 8, RULE_parameter = 9, RULE_vartype = 10;

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "subprogram", "functiondef", "classdef", "variabledef", "block",
                "stat", "expression", "parameterforcall", "parameter", "vartype"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'('", "')'", "'class'", "'{'", "'}'", "';'", "'['", "']'", "'='",
                "','", "'if'", "'else'", "'return'", "'for'", "'while'", "'break'", "'continue'",
                "'new'", "'null'", "'++'", "'--'", "'-'", "'!'", "'~'", "'+'", "'*'",
                "'/'", "'%'", "'>>'", "'<<'", "'&&'", "'||'", "'&'", "'|'", "'^'", "'>'",
                "'<'", "'>='", "'<='", "'=='", "'!='", "'.'", "'->'", "'void'", "'bool'",
                "'int'", "'string'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                "OPEATOR", "BOOL", "ID", "INT", "STRING", "WS", "COMMENT"
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
    public String getGrammarFileName() {
        return "Mx.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public MxParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class ProgramContext extends ParserRuleContext {
        public List<SubprogramContext> subprogram() {
            return getRuleContexts(SubprogramContext.class);
        }

        public SubprogramContext subprogram(int i) {
            return getRuleContext(SubprogramContext.class, i);
        }

        public ProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_program;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).enterProgram(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).exitProgram(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MxVisitor) return ((MxVisitor<? extends T>) visitor).visitProgram(this);
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
                setState(25);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << ID))) != 0)) {
                    {
                        {
                            setState(22);
                            subprogram();
                        }
                    }
                    setState(27);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SubprogramContext extends ParserRuleContext {
        public FunctiondefContext functiondef() {
            return getRuleContext(FunctiondefContext.class, 0);
        }

        public ClassdefContext classdef() {
            return getRuleContext(ClassdefContext.class, 0);
        }

        public VariabledefContext variabledef() {
            return getRuleContext(VariabledefContext.class, 0);
        }

        public SubprogramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_subprogram;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).enterSubprogram(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).exitSubprogram(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MxVisitor) return ((MxVisitor<? extends T>) visitor).visitSubprogram(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SubprogramContext subprogram() throws RecognitionException {
        SubprogramContext _localctx = new SubprogramContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_subprogram);
        try {
            setState(31);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(28);
                    functiondef();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(29);
                    classdef();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(30);
                    variabledef();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FunctiondefContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(MxParser.ID, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public VartypeContext vartype() {
            return getRuleContext(VartypeContext.class, 0);
        }

        public ParameterContext parameter() {
            return getRuleContext(ParameterContext.class, 0);
        }

        public FunctiondefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functiondef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).enterFunctiondef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).exitFunctiondef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MxVisitor) return ((MxVisitor<? extends T>) visitor).visitFunctiondef(this);
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
                setState(34);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                    case 1: {
                        setState(33);
                        vartype();
                    }
                    break;
                }
                setState(36);
                match(ID);
                setState(37);
                match(T__0);
                setState(39);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << ID))) != 0)) {
                    {
                        setState(38);
                        parameter();
                    }
                }

                setState(41);
                match(T__1);
                setState(42);
                block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ClassdefContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(MxParser.ID, 0);
        }

        public List<VariabledefContext> variabledef() {
            return getRuleContexts(VariabledefContext.class);
        }

        public VariabledefContext variabledef(int i) {
            return getRuleContext(VariabledefContext.class, i);
        }

        public List<FunctiondefContext> functiondef() {
            return getRuleContexts(FunctiondefContext.class);
        }

        public FunctiondefContext functiondef(int i) {
            return getRuleContext(FunctiondefContext.class, i);
        }

        public ClassdefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_classdef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).enterClassdef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).exitClassdef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MxVisitor) return ((MxVisitor<? extends T>) visitor).visitClassdef(this);
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
                setState(44);
                match(T__2);
                setState(45);
                match(ID);
                setState(46);
                match(T__3);
                setState(51);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << ID))) != 0)) {
                    {
                        setState(49);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                            case 1: {
                                setState(47);
                                variabledef();
                            }
                            break;
                            case 2: {
                                setState(48);
                                functiondef();
                            }
                            break;
                        }
                    }
                    setState(53);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(54);
                match(T__4);
                setState(55);
                match(T__5);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VariabledefContext extends ParserRuleContext {
        public VartypeContext vartype() {
            return getRuleContext(VartypeContext.class, 0);
        }

        public List<TerminalNode> ID() {
            return getTokens(MxParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(MxParser.ID, i);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public VariabledefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variabledef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).enterVariabledef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).exitVariabledef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MxVisitor) return ((MxVisitor<? extends T>) visitor).visitVariabledef(this);
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
                setState(57);
                vartype();
                setState(62);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__6) {
                    {
                        {
                            setState(58);
                            match(T__6);
                            setState(59);
                            match(T__7);
                        }
                    }
                    setState(64);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                {
                    setState(65);
                    match(ID);
                    setState(68);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == T__8) {
                        {
                            setState(66);
                            match(T__8);
                            setState(67);
                            expression(0);
                        }
                    }

                }
                setState(78);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__9) {
                    {
                        {
                            setState(70);
                            match(T__9);
                            setState(71);
                            match(ID);
                            setState(74);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T__8) {
                                {
                                    setState(72);
                                    match(T__8);
                                    setState(73);
                                    expression(0);
                                }
                            }

                        }
                    }
                    setState(80);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BlockContext extends ParserRuleContext {
        public List<StatContext> stat() {
            return getRuleContexts(StatContext.class);
        }

        public StatContext stat(int i) {
            return getRuleContext(StatContext.class, i);
        }

        public BlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).enterBlock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).exitBlock(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MxVisitor) return ((MxVisitor<? extends T>) visitor).visitBlock(this);
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
                setState(81);
                match(T__3);
                setState(85);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << BOOL) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
                    {
                        {
                            setState(82);
                            stat();
                        }
                    }
                    setState(87);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(88);
                match(T__4);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StatContext extends ParserRuleContext {
        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public VariabledefContext variabledef() {
            return getRuleContext(VariabledefContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public List<StatContext> stat() {
            return getRuleContexts(StatContext.class);
        }

        public StatContext stat(int i) {
            return getRuleContext(StatContext.class, i);
        }

        public StatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).enterStat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).exitStat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MxVisitor) return ((MxVisitor<? extends T>) visitor).visitStat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StatContext stat() throws RecognitionException {
        StatContext _localctx = new StatContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_stat);
        int _la;
        try {
            setState(135);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(90);
                    block();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(91);
                    variabledef();
                    setState(92);
                    match(T__5);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(94);
                    expression(0);
                    setState(95);
                    match(T__5);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(97);
                    match(T__10);
                    setState(98);
                    match(T__0);
                    setState(99);
                    expression(0);
                    setState(100);
                    match(T__1);
                    setState(101);
                    stat();
                    setState(104);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 11, _ctx)) {
                        case 1: {
                            setState(102);
                            match(T__11);
                            setState(103);
                            stat();
                        }
                        break;
                    }
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(106);
                    match(T__12);
                    setState(108);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
                        {
                            setState(107);
                            expression(0);
                        }
                    }

                    setState(110);
                    match(T__5);
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(111);
                    match(T__13);
                    setState(112);
                    match(T__0);
                    setState(114);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
                        {
                            setState(113);
                            expression(0);
                        }
                    }

                    setState(116);
                    match(T__5);
                    setState(118);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
                        {
                            setState(117);
                            expression(0);
                        }
                    }

                    setState(120);
                    match(T__5);
                    setState(122);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
                        {
                            setState(121);
                            expression(0);
                        }
                    }

                    setState(124);
                    match(T__1);
                    setState(125);
                    stat();
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(126);
                    match(T__14);
                    setState(127);
                    match(T__0);
                    setState(128);
                    expression(0);
                    setState(129);
                    match(T__1);
                    setState(130);
                    stat();
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(132);
                    match(T__15);
                }
                break;
                case 9:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(133);
                    match(T__16);
                }
                break;
                case 10:
                    enterOuterAlt(_localctx, 10);
                {
                    setState(134);
                    match(T__5);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExpressionContext extends ParserRuleContext {
        public VartypeContext vartype() {
            return getRuleContext(VartypeContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode ID() {
            return getToken(MxParser.ID, 0);
        }

        public TerminalNode BOOL() {
            return getToken(MxParser.BOOL, 0);
        }

        public TerminalNode INT() {
            return getToken(MxParser.INT, 0);
        }

        public TerminalNode STRING() {
            return getToken(MxParser.STRING, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public ParameterforcallContext parameterforcall() {
            return getRuleContext(ParameterforcallContext.class, 0);
        }

        public ParameterContext parameter() {
            return getRuleContext(ParameterContext.class, 0);
        }

        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).exitExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MxVisitor) return ((MxVisitor<? extends T>) visitor).visitExpression(this);
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
        int _startState = 14;
        enterRecursionRule(_localctx, 14, RULE_expression, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(178);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__17: {
                        setState(138);
                        match(T__17);
                        setState(139);
                        vartype();
                        setState(147);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 18, _ctx);
                        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                {
                                    {
                                        setState(140);
                                        match(T__6);
                                        setState(142);
                                        _errHandler.sync(this);
                                        _la = _input.LA(1);
                                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
                                            {
                                                setState(141);
                                                expression(0);
                                            }
                                        }

                                        setState(144);
                                        match(T__7);
                                    }
                                }
                            }
                            setState(149);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 18, _ctx);
                        }
                    }
                    break;
                    case ID: {
                        setState(150);
                        match(ID);
                    }
                    break;
                    case T__18:
                    case BOOL:
                    case INT:
                    case STRING: {
                        setState(151);
                        _la = _input.LA(1);
                        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << BOOL) | (1L << INT) | (1L << STRING))) != 0))) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                    break;
                    case T__0: {
                        setState(152);
                        match(T__0);
                        setState(153);
                        expression(0);
                        setState(154);
                        match(T__1);
                    }
                    break;
                    case T__19:
                    case T__20:
                    case T__21:
                    case T__22:
                    case T__23:
                    case T__24: {
                        setState(156);
                        _la = _input.LA(1);
                        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0))) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(157);
                        expression(10);
                    }
                    break;
                    case T__6: {
                        setState(158);
                        match(T__6);
                        setState(160);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T__32) {
                            {
                                setState(159);
                                match(T__32);
                            }
                        }

                        setState(162);
                        match(T__7);
                        setState(168);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == T__0) {
                            {
                                setState(163);
                                match(T__0);
                                setState(165);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << ID))) != 0)) {
                                    {
                                        setState(164);
                                        parameter();
                                    }
                                }

                                setState(167);
                                match(T__1);
                            }
                        }

                        setState(170);
                        match(T__42);
                        setState(171);
                        block();
                        setState(172);
                        match(T__0);
                        setState(174);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
                            {
                                setState(173);
                                parameterforcall();
                            }
                        }

                        setState(176);
                        match(T__1);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(216);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 26, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(214);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 25, _ctx)) {
                                case 1: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(180);
                                    if (!(precpred(_ctx, 12)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 12)");
                                    setState(181);
                                    match(T__8);
                                    setState(182);
                                    expression(13);
                                }
                                break;
                                case 2: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(183);
                                    if (!(precpred(_ctx, 9)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 9)");
                                    setState(184);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0))) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(185);
                                    expression(10);
                                }
                                break;
                                case 3: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(186);
                                    if (!(precpred(_ctx, 8)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                    setState(187);
                                    _la = _input.LA(1);
                                    if (!(_la == T__28 || _la == T__29)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(188);
                                    expression(9);
                                }
                                break;
                                case 4: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(189);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(190);
                                    _la = _input.LA(1);
                                    if (!(_la == T__30 || _la == T__31)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(191);
                                    expression(8);
                                }
                                break;
                                case 5: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(192);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(193);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34))) != 0))) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(194);
                                    expression(7);
                                }
                                break;
                                case 6: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(195);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(196);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40))) != 0))) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(197);
                                    expression(6);
                                }
                                break;
                                case 7: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(198);
                                    if (!(precpred(_ctx, 11)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 11)");
                                    setState(199);
                                    _la = _input.LA(1);
                                    if (!(_la == T__19 || _la == T__20)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                }
                                break;
                                case 8: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(200);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(201);
                                    match(T__6);
                                    setState(202);
                                    expression(0);
                                    setState(203);
                                    match(T__7);
                                }
                                break;
                                case 9: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(205);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(206);
                                    match(T__41);
                                    setState(207);
                                    match(ID);
                                }
                                break;
                                case 10: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(208);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(209);
                                    match(T__0);
                                    setState(211);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL) | (1L << ID) | (1L << INT) | (1L << STRING))) != 0)) {
                                        {
                                            setState(210);
                                            parameterforcall();
                                        }
                                    }

                                    setState(213);
                                    match(T__1);
                                }
                                break;
                            }
                        }
                    }
                    setState(218);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 26, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class ParameterforcallContext extends ParserRuleContext {
        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public ParameterforcallContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterforcall;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).enterParameterforcall(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).exitParameterforcall(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MxVisitor) return ((MxVisitor<? extends T>) visitor).visitParameterforcall(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterforcallContext parameterforcall() throws RecognitionException {
        ParameterforcallContext _localctx = new ParameterforcallContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_parameterforcall);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(219);
                expression(0);
                setState(224);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__9) {
                    {
                        {
                            setState(220);
                            match(T__9);
                            setState(221);
                            expression(0);
                        }
                    }
                    setState(226);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParameterContext extends ParserRuleContext {
        public List<VartypeContext> vartype() {
            return getRuleContexts(VartypeContext.class);
        }

        public VartypeContext vartype(int i) {
            return getRuleContext(VartypeContext.class, i);
        }

        public List<TerminalNode> ID() {
            return getTokens(MxParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(MxParser.ID, i);
        }

        public ParameterContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameter;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).enterParameter(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).exitParameter(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MxVisitor) return ((MxVisitor<? extends T>) visitor).visitParameter(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParameterContext parameter() throws RecognitionException {
        ParameterContext _localctx = new ParameterContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_parameter);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(227);
                vartype();
                setState(228);
                match(ID);
                setState(235);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__9) {
                    {
                        {
                            setState(229);
                            match(T__9);
                            setState(230);
                            vartype();
                            setState(231);
                            match(ID);
                        }
                    }
                    setState(237);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VartypeContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(MxParser.ID, 0);
        }

        public VartypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_vartype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).enterVartype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MxListener) ((MxListener) listener).exitVartype(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof MxVisitor) return ((MxVisitor<? extends T>) visitor).visitVartype(this);
            else return visitor.visitChildren(this);
        }
    }

    public final VartypeContext vartype() throws RecognitionException {
        VartypeContext _localctx = new VartypeContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_vartype);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(238);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << ID))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 7:
                return expression_sempred((ExpressionContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 12);
            case 1:
                return precpred(_ctx, 9);
            case 2:
                return precpred(_ctx, 8);
            case 3:
                return precpred(_ctx, 7);
            case 4:
                return precpred(_ctx, 6);
            case 5:
                return precpred(_ctx, 5);
            case 6:
                return precpred(_ctx, 11);
            case 7:
                return precpred(_ctx, 4);
            case 8:
                return precpred(_ctx, 3);
            case 9:
                return precpred(_ctx, 2);
        }
        return true;
    }

    public static final String _serializedATN =
            "\u0004\u00016\u00f1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
                    "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
                    "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
                    "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0005\u0000\u0018" +
                    "\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001" +
                    "\u0003\u0001 \b\u0001\u0001\u0002\u0003\u0002#\b\u0002\u0001\u0002\u0001" +
                    "\u0002\u0001\u0002\u0003\u0002(\b\u0002\u0001\u0002\u0001\u0002\u0001" +
                    "\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005" +
                    "\u00032\b\u0003\n\u0003\f\u00035\t\u0003\u0001\u0003\u0001\u0003\u0001" +
                    "\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004=\b\u0004\n\u0004" +
                    "\f\u0004@\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004E\b\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004K\b\u0004" +
                    "\u0005\u0004M\b\u0004\n\u0004\f\u0004P\t\u0004\u0001\u0005\u0001\u0005" +
                    "\u0005\u0005T\b\u0005\n\u0005\f\u0005W\t\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0003\u0006i\b\u0006\u0001\u0006\u0001\u0006" +
                    "\u0003\u0006m\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0003\u0006s\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006w\b\u0006\u0001" +
                    "\u0006\u0001\u0006\u0003\u0006{\b\u0006\u0001\u0006\u0001\u0006\u0001" +
                    "\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001" +
                    "\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0088\b\u0006\u0001\u0007\u0001" +
                    "\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u008f\b\u0007\u0001" +
                    "\u0007\u0005\u0007\u0092\b\u0007\n\u0007\f\u0007\u0095\t\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a1\b\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0003\u0007\u00a6\b\u0007\u0001\u0007\u0003\u0007" +
                    "\u00a9\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007" +
                    "\u00af\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00b3\b\u0007\u0001" +
                    "\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001" +
                    "\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001" +
                    "\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001" +
                    "\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001" +
                    "\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001" +
                    "\u0007\u0003\u0007\u00d4\b\u0007\u0001\u0007\u0005\u0007\u00d7\b\u0007" +
                    "\n\u0007\f\u0007\u00da\t\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u00df\b" +
                    "\b\n\b\f\b\u00e2\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005" +
                    "\t\u00ea\b\t\n\t\f\t\u00ed\t\t\u0001\n\u0001\n\u0001\n\u0000\u0001\u000e" +
                    "\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\t\u0003" +
                    "\u0000\u0013\u00131134\u0001\u0000\u0014\u0019\u0002\u0000\u0016\u0016" +
                    "\u0019\u001c\u0001\u0000\u001d\u001e\u0001\u0000\u001f \u0001\u0000!#" +
                    "\u0001\u0000$)\u0001\u0000\u0014\u0015\u0002\u0000,/22\u0117\u0000\u0019" +
                    "\u0001\u0000\u0000\u0000\u0002\u001f\u0001\u0000\u0000\u0000\u0004\"\u0001" +
                    "\u0000\u0000\u0000\u0006,\u0001\u0000\u0000\u0000\b9\u0001\u0000\u0000" +
                    "\u0000\nQ\u0001\u0000\u0000\u0000\f\u0087\u0001\u0000\u0000\u0000\u000e" +
                    "\u00b2\u0001\u0000\u0000\u0000\u0010\u00db\u0001\u0000\u0000\u0000\u0012" +
                    "\u00e3\u0001\u0000\u0000\u0000\u0014\u00ee\u0001\u0000\u0000\u0000\u0016" +
                    "\u0018\u0003\u0002\u0001\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018" +
                    "\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019" +
                    "\u001a\u0001\u0000\u0000\u0000\u001a\u0001\u0001\u0000\u0000\u0000\u001b" +
                    "\u0019\u0001\u0000\u0000\u0000\u001c \u0003\u0004\u0002\u0000\u001d \u0003" +
                    "\u0006\u0003\u0000\u001e \u0003\b\u0004\u0000\u001f\u001c\u0001\u0000" +
                    "\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f\u001e\u0001\u0000" +
                    "\u0000\u0000 \u0003\u0001\u0000\u0000\u0000!#\u0003\u0014\n\u0000\"!\u0001" +
                    "\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000" +
                    "$%\u00052\u0000\u0000%\'\u0005\u0001\u0000\u0000&(\u0003\u0012\t\u0000" +
                    "\'&\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0001\u0000\u0000" +
                    "\u0000)*\u0005\u0002\u0000\u0000*+\u0003\n\u0005\u0000+\u0005\u0001\u0000" +
                    "\u0000\u0000,-\u0005\u0003\u0000\u0000-.\u00052\u0000\u0000.3\u0005\u0004" +
                    "\u0000\u0000/2\u0003\b\u0004\u000002\u0003\u0004\u0002\u00001/\u0001\u0000" +
                    "\u0000\u000010\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001" +
                    "\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u0000" +
                    "53\u0001\u0000\u0000\u000067\u0005\u0005\u0000\u000078\u0005\u0006\u0000" +
                    "\u00008\u0007\u0001\u0000\u0000\u00009>\u0003\u0014\n\u0000:;\u0005\u0007" +
                    "\u0000\u0000;=\u0005\b\u0000\u0000<:\u0001\u0000\u0000\u0000=@\u0001\u0000" +
                    "\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001" +
                    "\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AD\u00052\u0000\u0000BC\u0005" +
                    "\t\u0000\u0000CE\u0003\u000e\u0007\u0000DB\u0001\u0000\u0000\u0000DE\u0001" +
                    "\u0000\u0000\u0000EN\u0001\u0000\u0000\u0000FG\u0005\n\u0000\u0000GJ\u0005" +
                    "2\u0000\u0000HI\u0005\t\u0000\u0000IK\u0003\u000e\u0007\u0000JH\u0001" +
                    "\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000" +
                    "LF\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000" +
                    "\u0000NO\u0001\u0000\u0000\u0000O\t\u0001\u0000\u0000\u0000PN\u0001\u0000" +
                    "\u0000\u0000QU\u0005\u0004\u0000\u0000RT\u0003\f\u0006\u0000SR\u0001\u0000" +
                    "\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001" +
                    "\u0000\u0000\u0000VX\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000" +
                    "XY\u0005\u0005\u0000\u0000Y\u000b\u0001\u0000\u0000\u0000Z\u0088\u0003" +
                    "\n\u0005\u0000[\\\u0003\b\u0004\u0000\\]\u0005\u0006\u0000\u0000]\u0088" +
                    "\u0001\u0000\u0000\u0000^_\u0003\u000e\u0007\u0000_`\u0005\u0006\u0000" +
                    "\u0000`\u0088\u0001\u0000\u0000\u0000ab\u0005\u000b\u0000\u0000bc\u0005" +
                    "\u0001\u0000\u0000cd\u0003\u000e\u0007\u0000de\u0005\u0002\u0000\u0000" +
                    "eh\u0003\f\u0006\u0000fg\u0005\f\u0000\u0000gi\u0003\f\u0006\u0000hf\u0001" +
                    "\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u0088\u0001\u0000\u0000" +
                    "\u0000jl\u0005\r\u0000\u0000km\u0003\u000e\u0007\u0000lk\u0001\u0000\u0000" +
                    "\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u0088\u0005" +
                    "\u0006\u0000\u0000op\u0005\u000e\u0000\u0000pr\u0005\u0001\u0000\u0000" +
                    "qs\u0003\u000e\u0007\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000" +
                    "\u0000st\u0001\u0000\u0000\u0000tv\u0005\u0006\u0000\u0000uw\u0003\u000e" +
                    "\u0007\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001" +
                    "\u0000\u0000\u0000xz\u0005\u0006\u0000\u0000y{\u0003\u000e\u0007\u0000" +
                    "zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000" +
                    "\u0000|}\u0005\u0002\u0000\u0000}\u0088\u0003\f\u0006\u0000~\u007f\u0005" +
                    "\u000f\u0000\u0000\u007f\u0080\u0005\u0001\u0000\u0000\u0080\u0081\u0003" +
                    "\u000e\u0007\u0000\u0081\u0082\u0005\u0002\u0000\u0000\u0082\u0083\u0003" +
                    "\f\u0006\u0000\u0083\u0088\u0001\u0000\u0000\u0000\u0084\u0088\u0005\u0010" +
                    "\u0000\u0000\u0085\u0088\u0005\u0011\u0000\u0000\u0086\u0088\u0005\u0006" +
                    "\u0000\u0000\u0087Z\u0001\u0000\u0000\u0000\u0087[\u0001\u0000\u0000\u0000" +
                    "\u0087^\u0001\u0000\u0000\u0000\u0087a\u0001\u0000\u0000\u0000\u0087j" +
                    "\u0001\u0000\u0000\u0000\u0087o\u0001\u0000\u0000\u0000\u0087~\u0001\u0000" +
                    "\u0000\u0000\u0087\u0084\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000" +
                    "\u0000\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\r\u0001\u0000\u0000" +
                    "\u0000\u0089\u008a\u0006\u0007\uffff\uffff\u0000\u008a\u008b\u0005\u0012" +
                    "\u0000\u0000\u008b\u0093\u0003\u0014\n\u0000\u008c\u008e\u0005\u0007\u0000" +
                    "\u0000\u008d\u008f\u0003\u000e\u0007\u0000\u008e\u008d\u0001\u0000\u0000" +
                    "\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000" +
                    "\u0000\u0090\u0092\u0005\b\u0000\u0000\u0091\u008c\u0001\u0000\u0000\u0000" +
                    "\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000" +
                    "\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u00b3\u0001\u0000\u0000\u0000" +
                    "\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u00b3\u00052\u0000\u0000\u0097" +
                    "\u00b3\u0007\u0000\u0000\u0000\u0098\u0099\u0005\u0001\u0000\u0000\u0099" +
                    "\u009a\u0003\u000e\u0007\u0000\u009a\u009b\u0005\u0002\u0000\u0000\u009b" +
                    "\u00b3\u0001\u0000\u0000\u0000\u009c\u009d\u0007\u0001\u0000\u0000\u009d" +
                    "\u00b3\u0003\u000e\u0007\n\u009e\u00a0\u0005\u0007\u0000\u0000\u009f\u00a1" +
                    "\u0005!\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001" +
                    "\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a8\u0005" +
                    "\b\u0000\u0000\u00a3\u00a5\u0005\u0001\u0000\u0000\u00a4\u00a6\u0003\u0012" +
                    "\t\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000" +
                    "\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a9\u0005\u0002\u0000" +
                    "\u0000\u00a8\u00a3\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000" +
                    "\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005+\u0000\u0000" +
                    "\u00ab\u00ac\u0003\n\u0005\u0000\u00ac\u00ae\u0005\u0001\u0000\u0000\u00ad" +
                    "\u00af\u0003\u0010\b\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00ae\u00af" +
                    "\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1" +
                    "\u0005\u0002\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u0089" +
                    "\u0001\u0000\u0000\u0000\u00b2\u0096\u0001\u0000\u0000\u0000\u00b2\u0097" +
                    "\u0001\u0000\u0000\u0000\u00b2\u0098\u0001\u0000\u0000\u0000\u00b2\u009c" +
                    "\u0001\u0000\u0000\u0000\u00b2\u009e\u0001\u0000\u0000\u0000\u00b3\u00d8" +
                    "\u0001\u0000\u0000\u0000\u00b4\u00b5\n\f\u0000\u0000\u00b5\u00b6\u0005" +
                    "\t\u0000\u0000\u00b6\u00d7\u0003\u000e\u0007\r\u00b7\u00b8\n\t\u0000\u0000" +
                    "\u00b8\u00b9\u0007\u0002\u0000\u0000\u00b9\u00d7\u0003\u000e\u0007\n\u00ba" +
                    "\u00bb\n\b\u0000\u0000\u00bb\u00bc\u0007\u0003\u0000\u0000\u00bc\u00d7" +
                    "\u0003\u000e\u0007\t\u00bd\u00be\n\u0007\u0000\u0000\u00be\u00bf\u0007" +
                    "\u0004\u0000\u0000\u00bf\u00d7\u0003\u000e\u0007\b\u00c0\u00c1\n\u0006" +
                    "\u0000\u0000\u00c1\u00c2\u0007\u0005\u0000\u0000\u00c2\u00d7\u0003\u000e" +
                    "\u0007\u0007\u00c3\u00c4\n\u0005\u0000\u0000\u00c4\u00c5\u0007\u0006\u0000" +
                    "\u0000\u00c5\u00d7\u0003\u000e\u0007\u0006\u00c6\u00c7\n\u000b\u0000\u0000" +
                    "\u00c7\u00d7\u0007\u0007\u0000\u0000\u00c8\u00c9\n\u0004\u0000\u0000\u00c9" +
                    "\u00ca\u0005\u0007\u0000\u0000\u00ca\u00cb\u0003\u000e\u0007\u0000\u00cb" +
                    "\u00cc\u0005\b\u0000\u0000\u00cc\u00d7\u0001\u0000\u0000\u0000\u00cd\u00ce" +
                    "\n\u0003\u0000\u0000\u00ce\u00cf\u0005*\u0000\u0000\u00cf\u00d7\u0005" +
                    "2\u0000\u0000\u00d0\u00d1\n\u0002\u0000\u0000\u00d1\u00d3\u0005\u0001" +
                    "\u0000\u0000\u00d2\u00d4\u0003\u0010\b\u0000\u00d3\u00d2\u0001\u0000\u0000" +
                    "\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000" +
                    "\u0000\u00d5\u00d7\u0005\u0002\u0000\u0000\u00d6\u00b4\u0001\u0000\u0000" +
                    "\u0000\u00d6\u00b7\u0001\u0000\u0000\u0000\u00d6\u00ba\u0001\u0000\u0000" +
                    "\u0000\u00d6\u00bd\u0001\u0000\u0000\u0000\u00d6\u00c0\u0001\u0000\u0000" +
                    "\u0000\u00d6\u00c3\u0001\u0000\u0000\u0000\u00d6\u00c6\u0001\u0000\u0000" +
                    "\u0000\u00d6\u00c8\u0001\u0000\u0000\u0000\u00d6\u00cd\u0001\u0000\u0000" +
                    "\u0000\u00d6\u00d0\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000" +
                    "\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000" +
                    "\u0000\u00d9\u000f\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000" +
                    "\u0000\u00db\u00e0\u0003\u000e\u0007\u0000\u00dc\u00dd\u0005\n\u0000\u0000" +
                    "\u00dd\u00df\u0003\u000e\u0007\u0000\u00de\u00dc\u0001\u0000\u0000\u0000" +
                    "\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000" +
                    "\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u0011\u0001\u0000\u0000\u0000" +
                    "\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e4\u0003\u0014\n\u0000\u00e4" +
                    "\u00eb\u00052\u0000\u0000\u00e5\u00e6\u0005\n\u0000\u0000\u00e6\u00e7" +
                    "\u0003\u0014\n\u0000\u00e7\u00e8\u00052\u0000\u0000\u00e8\u00ea\u0001" +
                    "\u0000\u0000\u0000\u00e9\u00e5\u0001\u0000\u0000\u0000\u00ea\u00ed\u0001" +
                    "\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001" +
                    "\u0000\u0000\u0000\u00ec\u0013\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001" +
                    "\u0000\u0000\u0000\u00ee\u00ef\u0007\b\u0000\u0000\u00ef\u0015\u0001\u0000" +
                    "\u0000\u0000\u001d\u0019\u001f\"\'13>DJNUhlrvz\u0087\u008e\u0093\u00a0" +
                    "\u00a5\u00a8\u00ae\u00b2\u00d3\u00d6\u00d8\u00e0\u00eb";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}