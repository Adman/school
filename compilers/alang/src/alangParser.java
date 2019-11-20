// Generated from alang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class alangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BUD=1, FUNKCIA=2, HOTOVO=3, VYPLUJ=4, MAKAJ=5, JAKAM=6, IF=7, ELSE=8, 
		FI=9, CITAJCISLO=10, CITAJRIADOK=11, VYPIS=12, VYPISRIADOK=13, CISLO=14, 
		ZNAKY=15, BOOL=16, VOID=17, EQ=18, LT=19, GT=20, LEQ=21, GEQ=22, NEQ=23, 
		NOT=24, AND=25, OR=26, ADD=27, SUB=28, DIV=29, MUL=30, ASSIGN=31, TRUE=32, 
		FALSE=33, INT=34, STRING=35, NEWLINE=36, LPAR=37, RPAR=38, LSQUARE=39, 
		RSQUARE=40, COMMA=41, ID=42, LINE_COMMENT=43, WHITESPACE=44;
	public static final int
		RULE_init = 0, RULE_statements = 1, RULE_statement = 2, RULE_block = 3, 
		RULE_function = 4, RULE_vypluj = 5, RULE_var_declaration = 6, RULE_assignment = 7, 
		RULE_if_block = 8, RULE_loop_block = 9, RULE_func_call = 10, RULE_input_int = 11, 
		RULE_input_row = 12, RULE_output_var = 13, RULE_output_row = 14, RULE_index_to_array = 15, 
		RULE_var_type = 16, RULE_return_type = 17, RULE_condition = 18, RULE_expression = 19, 
		RULE_argtype = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "statements", "statement", "block", "function", "vypluj", "var_declaration", 
			"assignment", "if_block", "loop_block", "func_call", "input_int", "input_row", 
			"output_var", "output_row", "index_to_array", "var_type", "return_type", 
			"condition", "expression", "argtype"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BUD'", "'FUNKCIA'", "'HOTOVO'", "'VYPLUJ'", "'MAKAJ'", "'JAKAM'", 
			"'IF'", "'ELSE'", "'FI'", "'CITAJCISLO'", "'CITAJRIADOK'", "'VYPIS'", 
			"'VYPISRIADOK'", "'CISLO'", "'ZNAKY'", "'BOOL'", "'VOID'", "'=='", "'<'", 
			"'>'", "'<='", "'>='", "'!='", "'NOT'", "'AND'", "'OR'", "'+'", "'-'", 
			"'/'", "'*'", "'='", "'TRUE'", "'FALSE'", null, null, null, "'('", "')'", 
			"'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BUD", "FUNKCIA", "HOTOVO", "VYPLUJ", "MAKAJ", "JAKAM", "IF", "ELSE", 
			"FI", "CITAJCISLO", "CITAJRIADOK", "VYPIS", "VYPISRIADOK", "CISLO", "ZNAKY", 
			"BOOL", "VOID", "EQ", "LT", "GT", "LEQ", "GEQ", "NEQ", "NOT", "AND", 
			"OR", "ADD", "SUB", "DIV", "MUL", "ASSIGN", "TRUE", "FALSE", "INT", "STRING", 
			"NEWLINE", "LPAR", "RPAR", "LSQUARE", "RSQUARE", "COMMA", "ID", "LINE_COMMENT", 
			"WHITESPACE"
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
	public String getGrammarFileName() { return "alang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public alangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class InitContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			statements();
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

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(alangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(alangParser.NEWLINE, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(44);
				match(NEWLINE);
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			statement();
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(52); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(51);
						match(NEWLINE);
						}
						}
						setState(54); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(56);
					statement();
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(62);
				match(NEWLINE);
				}
				}
				setState(67);
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

	public static class StatementContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNKCIA:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				function();
				}
				break;
			case BUD:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				var_declaration();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				assignment();
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

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlockVarDecContext extends BlockContext {
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public BlockVarDecContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitBlockVarDec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockInputRowContext extends BlockContext {
		public Input_rowContext input_row() {
			return getRuleContext(Input_rowContext.class,0);
		}
		public BlockInputRowContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitBlockInputRow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockOutputRowContext extends BlockContext {
		public Output_rowContext output_row() {
			return getRuleContext(Output_rowContext.class,0);
		}
		public BlockOutputRowContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitBlockOutputRow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockOutputVarContext extends BlockContext {
		public Output_varContext output_var() {
			return getRuleContext(Output_varContext.class,0);
		}
		public BlockOutputVarContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitBlockOutputVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockFuncCallContext extends BlockContext {
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public BlockFuncCallContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitBlockFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockIfContext extends BlockContext {
		public If_blockContext if_block() {
			return getRuleContext(If_blockContext.class,0);
		}
		public BlockIfContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitBlockIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockAsgnContext extends BlockContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public BlockAsgnContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitBlockAsgn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockReturnContext extends BlockContext {
		public VyplujContext vypluj() {
			return getRuleContext(VyplujContext.class,0);
		}
		public BlockReturnContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitBlockReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockLoopContext extends BlockContext {
		public Loop_blockContext loop_block() {
			return getRuleContext(Loop_blockContext.class,0);
		}
		public BlockLoopContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitBlockLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockInputIntContext extends BlockContext {
		public Input_intContext input_int() {
			return getRuleContext(Input_intContext.class,0);
		}
		public BlockInputIntContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitBlockInputInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new BlockVarDecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				var_declaration();
				}
				break;
			case 2:
				_localctx = new BlockAsgnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				assignment();
				}
				break;
			case 3:
				_localctx = new BlockIfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				if_block();
				}
				break;
			case 4:
				_localctx = new BlockLoopContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				loop_block();
				}
				break;
			case 5:
				_localctx = new BlockFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
				func_call();
				}
				break;
			case 6:
				_localctx = new BlockInputIntContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(78);
				input_int();
				}
				break;
			case 7:
				_localctx = new BlockInputRowContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(79);
				input_row();
				}
				break;
			case 8:
				_localctx = new BlockOutputVarContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(80);
				output_var();
				}
				break;
			case 9:
				_localctx = new BlockOutputRowContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(81);
				output_row();
				}
				break;
			case 10:
				_localctx = new BlockReturnContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(82);
				vypluj();
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUNKCIA() { return getToken(alangParser.FUNKCIA, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(alangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(alangParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(alangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(alangParser.RPAR, 0); }
		public TerminalNode HOTOVO() { return getToken(alangParser.HOTOVO, 0); }
		public List<ArgtypeContext> argtype() {
			return getRuleContexts(ArgtypeContext.class);
		}
		public ArgtypeContext argtype(int i) {
			return getRuleContext(ArgtypeContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(alangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(alangParser.NEWLINE, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alangParser.COMMA, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(FUNKCIA);
			setState(86);
			return_type();
			setState(87);
			match(ID);
			setState(88);
			match(LPAR);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CISLO) | (1L << ZNAKY) | (1L << BOOL))) != 0)) {
				{
				setState(89);
				argtype();
				setState(90);
				match(ID);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(91);
					match(COMMA);
					setState(92);
					argtype();
					setState(93);
					match(ID);
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(102);
			match(RPAR);
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(103);
				match(NEWLINE);
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << IF) | (1L << CITAJCISLO) | (1L << CITAJRIADOK) | (1L << VYPIS) | (1L << VYPISRIADOK) | (1L << ID))) != 0)) {
				{
				{
				setState(108);
				block();
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(109);
					match(NEWLINE);
					}
					}
					setState(112); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			match(HOTOVO);
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

	public static class VyplujContext extends ParserRuleContext {
		public TerminalNode VYPLUJ() { return getToken(alangParser.VYPLUJ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VyplujContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vypluj; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitVypluj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VyplujContext vypluj() throws RecognitionException {
		VyplujContext _localctx = new VyplujContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_vypluj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(VYPLUJ);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << STRING) | (1L << LPAR) | (1L << ID))) != 0)) {
				{
				setState(122);
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

	public static class Var_declarationContext extends ParserRuleContext {
		public TerminalNode BUD() { return getToken(alangParser.BUD, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(alangParser.ID, 0); }
		public List<Index_to_arrayContext> index_to_array() {
			return getRuleContexts(Index_to_arrayContext.class);
		}
		public Index_to_arrayContext index_to_array(int i) {
			return getRuleContext(Index_to_arrayContext.class,i);
		}
		public Var_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitVar_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declarationContext var_declaration() throws RecognitionException {
		Var_declarationContext _localctx = new Var_declarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(BUD);
			setState(126);
			var_type();
			setState(127);
			match(ID);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LSQUARE) {
				{
				{
				setState(128);
				index_to_array();
				}
				}
				setState(133);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(alangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(alangParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<Index_to_arrayContext> index_to_array() {
			return getRuleContexts(Index_to_arrayContext.class);
		}
		public Index_to_arrayContext index_to_array(int i) {
			return getRuleContext(Index_to_arrayContext.class,i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(ID);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LSQUARE) {
				{
				{
				setState(135);
				index_to_array();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
			match(ASSIGN);
			setState(142);
			expression(0);
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

	public static class If_blockContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(alangParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(alangParser.LPAR, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alangParser.RPAR, 0); }
		public TerminalNode FI() { return getToken(alangParser.FI, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(alangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(alangParser.NEWLINE, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(alangParser.ELSE, 0); }
		public If_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitIf_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_blockContext if_block() throws RecognitionException {
		If_blockContext _localctx = new If_blockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(IF);
			setState(145);
			match(LPAR);
			setState(146);
			condition(0);
			setState(147);
			match(RPAR);
			setState(149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(148);
				match(NEWLINE);
				}
				}
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(153);
				block();
				setState(155); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(154);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(157); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << IF) | (1L << CITAJCISLO) | (1L << CITAJRIADOK) | (1L << VYPIS) | (1L << VYPISRIADOK) | (1L << ID))) != 0) );
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(163);
				match(ELSE);
				setState(165); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(164);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(167); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << IF) | (1L << CITAJCISLO) | (1L << CITAJRIADOK) | (1L << VYPIS) | (1L << VYPISRIADOK) | (1L << ID))) != 0)) {
					{
					{
					setState(169);
					block();
					setState(171); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(170);
							match(NEWLINE);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(173); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(182);
				match(NEWLINE);
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
			match(FI);
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

	public static class Loop_blockContext extends ParserRuleContext {
		public TerminalNode MAKAJ() { return getToken(alangParser.MAKAJ, 0); }
		public TerminalNode LPAR() { return getToken(alangParser.LPAR, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alangParser.RPAR, 0); }
		public TerminalNode JAKAM() { return getToken(alangParser.JAKAM, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(alangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(alangParser.NEWLINE, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public Loop_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitLoop_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_blockContext loop_block() throws RecognitionException {
		Loop_blockContext _localctx = new Loop_blockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_loop_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(MAKAJ);
			setState(191);
			match(LPAR);
			setState(192);
			condition(0);
			setState(193);
			match(RPAR);
			setState(195); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(194);
				match(NEWLINE);
				}
				}
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(205); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(199);
				block();
				setState(201); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(200);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(203); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(207); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << IF) | (1L << CITAJCISLO) | (1L << CITAJRIADOK) | (1L << VYPIS) | (1L << VYPISRIADOK) | (1L << ID))) != 0) );
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(209);
				match(NEWLINE);
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
			match(JAKAM);
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

	public static class Func_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(alangParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(alangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(alangParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alangParser.COMMA, i);
		}
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitFunc_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_func_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(ID);
			setState(218);
			match(LPAR);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << STRING) | (1L << LPAR) | (1L << ID))) != 0)) {
				{
				setState(219);
				expression(0);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(220);
					match(COMMA);
					setState(221);
					expression(0);
					}
					}
					setState(226);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(229);
			match(RPAR);
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

	public static class Input_intContext extends ParserRuleContext {
		public TerminalNode CITAJCISLO() { return getToken(alangParser.CITAJCISLO, 0); }
		public TerminalNode ID() { return getToken(alangParser.ID, 0); }
		public List<Index_to_arrayContext> index_to_array() {
			return getRuleContexts(Index_to_arrayContext.class);
		}
		public Index_to_arrayContext index_to_array(int i) {
			return getRuleContext(Index_to_arrayContext.class,i);
		}
		public Input_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input_int; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitInput_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Input_intContext input_int() throws RecognitionException {
		Input_intContext _localctx = new Input_intContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_input_int);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(CITAJCISLO);
			setState(232);
			match(ID);
			{
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LSQUARE) {
				{
				{
				setState(233);
				index_to_array();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Input_rowContext extends ParserRuleContext {
		public TerminalNode CITAJRIADOK() { return getToken(alangParser.CITAJRIADOK, 0); }
		public TerminalNode ID() { return getToken(alangParser.ID, 0); }
		public List<Index_to_arrayContext> index_to_array() {
			return getRuleContexts(Index_to_arrayContext.class);
		}
		public Index_to_arrayContext index_to_array(int i) {
			return getRuleContext(Index_to_arrayContext.class,i);
		}
		public Input_rowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input_row; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitInput_row(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Input_rowContext input_row() throws RecognitionException {
		Input_rowContext _localctx = new Input_rowContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_input_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(CITAJRIADOK);
			setState(240);
			match(ID);
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LSQUARE) {
				{
				{
				setState(241);
				index_to_array();
				}
				}
				setState(246);
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

	public static class Output_varContext extends ParserRuleContext {
		public TerminalNode VYPIS() { return getToken(alangParser.VYPIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Output_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitOutput_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Output_varContext output_var() throws RecognitionException {
		Output_varContext _localctx = new Output_varContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_output_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(VYPIS);
			setState(248);
			expression(0);
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

	public static class Output_rowContext extends ParserRuleContext {
		public TerminalNode VYPISRIADOK() { return getToken(alangParser.VYPISRIADOK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Output_rowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output_row; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitOutput_row(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Output_rowContext output_row() throws RecognitionException {
		Output_rowContext _localctx = new Output_rowContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_output_row);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(VYPISRIADOK);
			setState(251);
			expression(0);
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

	public static class Index_to_arrayContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(alangParser.LSQUARE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSQUARE() { return getToken(alangParser.RSQUARE, 0); }
		public Index_to_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_to_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitIndex_to_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Index_to_arrayContext index_to_array() throws RecognitionException {
		Index_to_arrayContext _localctx = new Index_to_arrayContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_index_to_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(LSQUARE);
			setState(254);
			expression(0);
			setState(255);
			match(RSQUARE);
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

	public static class Var_typeContext extends ParserRuleContext {
		public TerminalNode CISLO() { return getToken(alangParser.CISLO, 0); }
		public TerminalNode ZNAKY() { return getToken(alangParser.ZNAKY, 0); }
		public TerminalNode BOOL() { return getToken(alangParser.BOOL, 0); }
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitVar_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_var_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CISLO) | (1L << ZNAKY) | (1L << BOOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Return_typeContext extends ParserRuleContext {
		public TerminalNode CISLO() { return getToken(alangParser.CISLO, 0); }
		public TerminalNode ZNAKY() { return getToken(alangParser.ZNAKY, 0); }
		public TerminalNode BOOL() { return getToken(alangParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(alangParser.VOID, 0); }
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitReturn_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CISLO) | (1L << ZNAKY) | (1L << BOOL) | (1L << VOID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CondOrContext extends ConditionContext {
		public Token op;
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode OR() { return getToken(alangParser.OR, 0); }
		public CondOrContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitCondOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondAndContext extends ConditionContext {
		public Token op;
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode AND() { return getToken(alangParser.AND, 0); }
		public CondAndContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitCondAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondParContext extends ConditionContext {
		public TerminalNode LPAR() { return getToken(alangParser.LPAR, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alangParser.RPAR, 0); }
		public CondParContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitCondPar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondNotContext extends ConditionContext {
		public Token op;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(alangParser.NOT, 0); }
		public CondNotContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitCondNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondCompContext extends ConditionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(alangParser.EQ, 0); }
		public TerminalNode LT() { return getToken(alangParser.LT, 0); }
		public TerminalNode GT() { return getToken(alangParser.GT, 0); }
		public TerminalNode LEQ() { return getToken(alangParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(alangParser.GEQ, 0); }
		public TerminalNode NEQ() { return getToken(alangParser.NEQ, 0); }
		public CondCompContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitCondComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new CondNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(262);
				((CondNotContext)_localctx).op = match(NOT);
				setState(263);
				condition(5);
				}
				break;
			case 2:
				{
				_localctx = new CondParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				match(LPAR);
				setState(265);
				condition(0);
				setState(266);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new CondCompContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				expression(0);
				setState(269);
				((CondCompContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << LT) | (1L << GT) | (1L << LEQ) | (1L << GEQ) | (1L << NEQ))) != 0)) ) {
					((CondCompContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(270);
				expression(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(280);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new CondAndContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(274);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(275);
						((CondAndContext)_localctx).op = match(AND);
						setState(276);
						condition(5);
						}
						break;
					case 2:
						{
						_localctx = new CondOrContext(new ConditionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(277);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(278);
						((CondOrContext)_localctx).op = match(OR);
						setState(279);
						condition(4);
						}
						break;
					}
					} 
				}
				setState(284);
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
	public static class ExpDivMulContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIV() { return getToken(alangParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(alangParser.MUL, 0); }
		public ExpDivMulContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitExpDivMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpFalseContext extends ExpressionContext {
		public TerminalNode FALSE() { return getToken(alangParser.FALSE, 0); }
		public ExpFalseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitExpFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpUnaContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(alangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(alangParser.SUB, 0); }
		public ExpUnaContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitExpUna(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpParContext extends ExpressionContext {
		public TerminalNode LPAR() { return getToken(alangParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alangParser.RPAR, 0); }
		public ExpParContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitExpPar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIdArrayContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(alangParser.ID, 0); }
		public List<Index_to_arrayContext> index_to_array() {
			return getRuleContexts(Index_to_arrayContext.class);
		}
		public Index_to_arrayContext index_to_array(int i) {
			return getRuleContext(Index_to_arrayContext.class,i);
		}
		public ExpIdArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitExpIdArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpFuncCallContext extends ExpressionContext {
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public ExpFuncCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitExpFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIdContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(alangParser.ID, 0); }
		public ExpIdContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitExpId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpStringContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(alangParser.STRING, 0); }
		public ExpStringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitExpString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpTrueContext extends ExpressionContext {
		public TerminalNode TRUE() { return getToken(alangParser.TRUE, 0); }
		public ExpTrueContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitExpTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIntContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(alangParser.INT, 0); }
		public ExpIntContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitExpInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpAddSubContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(alangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(alangParser.SUB, 0); }
		public ExpAddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitExpAddSub(this);
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				_localctx = new ExpUnaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(286);
				((ExpUnaContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((ExpUnaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(287);
				expression(11);
				}
				break;
			case 2:
				{
				_localctx = new ExpParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(288);
				match(LPAR);
				setState(289);
				expression(0);
				setState(290);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new ExpIdArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				match(ID);
				setState(294); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(293);
						index_to_array();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(296); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				{
				_localctx = new ExpIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ExpFuncCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(299);
				func_call();
				}
				break;
			case 6:
				{
				_localctx = new ExpIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(300);
				match(INT);
				}
				break;
			case 7:
				{
				_localctx = new ExpStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(301);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExpTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(302);
				match(TRUE);
				}
				break;
			case 9:
				{
				_localctx = new ExpFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(303);
				match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(312);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new ExpDivMulContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(307);
						((ExpDivMulContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DIV || _la==MUL) ) {
							((ExpDivMulContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(308);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new ExpAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(309);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(310);
						((ExpAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(311);
						expression(10);
						}
						break;
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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

	public static class ArgtypeContext extends ParserRuleContext {
		public TerminalNode CISLO() { return getToken(alangParser.CISLO, 0); }
		public List<TerminalNode> LSQUARE() { return getTokens(alangParser.LSQUARE); }
		public TerminalNode LSQUARE(int i) {
			return getToken(alangParser.LSQUARE, i);
		}
		public List<TerminalNode> RSQUARE() { return getTokens(alangParser.RSQUARE); }
		public TerminalNode RSQUARE(int i) {
			return getToken(alangParser.RSQUARE, i);
		}
		public TerminalNode ZNAKY() { return getToken(alangParser.ZNAKY, 0); }
		public TerminalNode BOOL() { return getToken(alangParser.BOOL, 0); }
		public ArgtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argtype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alangVisitor ) return ((alangVisitor<? extends T>)visitor).visitArgtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgtypeContext argtype() throws RecognitionException {
		ArgtypeContext _localctx = new ArgtypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_argtype);
		int _la;
		try {
			setState(341);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CISLO:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				match(CISLO);
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(318);
					match(LSQUARE);
					setState(319);
					match(RSQUARE);
					}
					}
					setState(324);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ZNAKY:
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
				match(ZNAKY);
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(326);
					match(LSQUARE);
					setState(327);
					match(RSQUARE);
					}
					}
					setState(332);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(333);
				match(BOOL);
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(334);
					match(LSQUARE);
					setState(335);
					match(RSQUARE);
					}
					}
					setState(340);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		case 19:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u015a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\7\3\60\n\3\f\3\16"+
		"\3\63\13\3\3\3\3\3\6\3\67\n\3\r\3\16\38\3\3\7\3<\n\3\f\3\16\3?\13\3\3"+
		"\3\7\3B\n\3\f\3\16\3E\13\3\3\4\3\4\3\4\5\4J\n\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5V\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6b\n\6\f\6\16\6e\13\6\5\6g\n\6\3\6\3\6\6\6k\n\6\r\6\16\6l\3\6\3\6\6\6"+
		"q\n\6\r\6\16\6r\7\6u\n\6\f\6\16\6x\13\6\3\6\3\6\3\7\3\7\5\7~\n\7\3\b\3"+
		"\b\3\b\3\b\7\b\u0084\n\b\f\b\16\b\u0087\13\b\3\t\3\t\7\t\u008b\n\t\f\t"+
		"\16\t\u008e\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\6\n\u0098\n\n\r\n\16"+
		"\n\u0099\3\n\3\n\6\n\u009e\n\n\r\n\16\n\u009f\6\n\u00a2\n\n\r\n\16\n\u00a3"+
		"\3\n\3\n\6\n\u00a8\n\n\r\n\16\n\u00a9\3\n\3\n\6\n\u00ae\n\n\r\n\16\n\u00af"+
		"\7\n\u00b2\n\n\f\n\16\n\u00b5\13\n\5\n\u00b7\n\n\3\n\7\n\u00ba\n\n\f\n"+
		"\16\n\u00bd\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\6\13\u00c6\n\13\r\13"+
		"\16\13\u00c7\3\13\3\13\6\13\u00cc\n\13\r\13\16\13\u00cd\6\13\u00d0\n\13"+
		"\r\13\16\13\u00d1\3\13\7\13\u00d5\n\13\f\13\16\13\u00d8\13\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u00e1\n\f\f\f\16\f\u00e4\13\f\5\f\u00e6\n\f\3"+
		"\f\3\f\3\r\3\r\3\r\7\r\u00ed\n\r\f\r\16\r\u00f0\13\r\3\16\3\16\3\16\7"+
		"\16\u00f5\n\16\f\16\16\16\u00f8\13\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\5\24\u0113\n\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\7\24\u011b\n\24\f\24\16\24\u011e\13\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\6\25\u0129\n\25\r\25\16\25\u012a\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\5\25\u0133\n\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u013b\n\25"+
		"\f\25\16\25\u013e\13\25\3\26\3\26\3\26\7\26\u0143\n\26\f\26\16\26\u0146"+
		"\13\26\3\26\3\26\3\26\7\26\u014b\n\26\f\26\16\26\u014e\13\26\3\26\3\26"+
		"\3\26\7\26\u0153\n\26\f\26\16\26\u0156\13\26\5\26\u0158\n\26\3\26\2\4"+
		"&(\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\7\3\2\20\22\3\2"+
		"\20\23\3\2\24\31\3\2\35\36\3\2\37 \2\u017f\2,\3\2\2\2\4\61\3\2\2\2\6I"+
		"\3\2\2\2\bU\3\2\2\2\nW\3\2\2\2\f{\3\2\2\2\16\177\3\2\2\2\20\u0088\3\2"+
		"\2\2\22\u0092\3\2\2\2\24\u00c0\3\2\2\2\26\u00db\3\2\2\2\30\u00e9\3\2\2"+
		"\2\32\u00f1\3\2\2\2\34\u00f9\3\2\2\2\36\u00fc\3\2\2\2 \u00ff\3\2\2\2\""+
		"\u0103\3\2\2\2$\u0105\3\2\2\2&\u0112\3\2\2\2(\u0132\3\2\2\2*\u0157\3\2"+
		"\2\2,-\5\4\3\2-\3\3\2\2\2.\60\7&\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2"+
		"\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64=\5\6\4\2\65\67\7&\2\2"+
		"\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:<\5\6\4\2;"+
		"\66\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>C\3\2\2\2?=\3\2\2\2@B\7&\2\2"+
		"A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\5\3\2\2\2EC\3\2\2\2FJ\5\n\6"+
		"\2GJ\5\16\b\2HJ\5\20\t\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2J\7\3\2\2\2KV\5"+
		"\16\b\2LV\5\20\t\2MV\5\22\n\2NV\5\24\13\2OV\5\26\f\2PV\5\30\r\2QV\5\32"+
		"\16\2RV\5\34\17\2SV\5\36\20\2TV\5\f\7\2UK\3\2\2\2UL\3\2\2\2UM\3\2\2\2"+
		"UN\3\2\2\2UO\3\2\2\2UP\3\2\2\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2"+
		"V\t\3\2\2\2WX\7\4\2\2XY\5$\23\2YZ\7,\2\2Zf\7\'\2\2[\\\5*\26\2\\c\7,\2"+
		"\2]^\7+\2\2^_\5*\26\2_`\7,\2\2`b\3\2\2\2a]\3\2\2\2be\3\2\2\2ca\3\2\2\2"+
		"cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2f[\3\2\2\2fg\3\2\2\2gh\3\2\2\2hj\7(\2\2"+
		"ik\7&\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mv\3\2\2\2np\5\b\5\2"+
		"oq\7&\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tn\3\2\2\2"+
		"ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7\5\2\2z\13\3\2\2"+
		"\2{}\7\6\2\2|~\5(\25\2}|\3\2\2\2}~\3\2\2\2~\r\3\2\2\2\177\u0080\7\3\2"+
		"\2\u0080\u0081\5\"\22\2\u0081\u0085\7,\2\2\u0082\u0084\5 \21\2\u0083\u0082"+
		"\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\17\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008c\7,\2\2\u0089\u008b\5 \21\2"+
		"\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7!\2\2\u0090"+
		"\u0091\5(\25\2\u0091\21\3\2\2\2\u0092\u0093\7\t\2\2\u0093\u0094\7\'\2"+
		"\2\u0094\u0095\5&\24\2\u0095\u0097\7(\2\2\u0096\u0098\7&\2\2\u0097\u0096"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u00a1\3\2\2\2\u009b\u009d\5\b\5\2\u009c\u009e\7&\2\2\u009d\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a2\3\2\2\2\u00a1\u009b\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00b6\3\2\2\2\u00a5\u00a7\7\n\2\2\u00a6"+
		"\u00a8\7&\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2"+
		"\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00b3\3\2\2\2\u00ab\u00ad\5\b\5\2\u00ac"+
		"\u00ae\7&\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b2"+
		"\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b7\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00a5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00bb\3\2\2\2\u00b8\u00ba\7&\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00bf\7\13\2\2\u00bf\23\3\2\2\2\u00c0\u00c1\7\7\2"+
		"\2\u00c1\u00c2\7\'\2\2\u00c2\u00c3\5&\24\2\u00c3\u00c5\7(\2\2\u00c4\u00c6"+
		"\7&\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00cf\3\2\2\2\u00c9\u00cb\5\b\5\2\u00ca\u00cc\7&"+
		"\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00c9\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d6\3\2\2\2\u00d3"+
		"\u00d5\7&\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2"+
		"\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9"+
		"\u00da\7\b\2\2\u00da\25\3\2\2\2\u00db\u00dc\7,\2\2\u00dc\u00e5\7\'\2\2"+
		"\u00dd\u00e2\5(\25\2\u00de\u00df\7+\2\2\u00df\u00e1\5(\25\2\u00e0\u00de"+
		"\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00dd\3\2\2\2\u00e5\u00e6\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7(\2\2\u00e8\27\3\2\2\2\u00e9\u00ea"+
		"\7\f\2\2\u00ea\u00ee\7,\2\2\u00eb\u00ed\5 \21\2\u00ec\u00eb\3\2\2\2\u00ed"+
		"\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\31\3\2\2"+
		"\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7\r\2\2\u00f2\u00f6\7,\2\2\u00f3\u00f5"+
		"\5 \21\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\33\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\7\16\2"+
		"\2\u00fa\u00fb\5(\25\2\u00fb\35\3\2\2\2\u00fc\u00fd\7\17\2\2\u00fd\u00fe"+
		"\5(\25\2\u00fe\37\3\2\2\2\u00ff\u0100\7)\2\2\u0100\u0101\5(\25\2\u0101"+
		"\u0102\7*\2\2\u0102!\3\2\2\2\u0103\u0104\t\2\2\2\u0104#\3\2\2\2\u0105"+
		"\u0106\t\3\2\2\u0106%\3\2\2\2\u0107\u0108\b\24\1\2\u0108\u0109\7\32\2"+
		"\2\u0109\u0113\5&\24\7\u010a\u010b\7\'\2\2\u010b\u010c\5&\24\2\u010c\u010d"+
		"\7(\2\2\u010d\u0113\3\2\2\2\u010e\u010f\5(\25\2\u010f\u0110\t\4\2\2\u0110"+
		"\u0111\5(\25\2\u0111\u0113\3\2\2\2\u0112\u0107\3\2\2\2\u0112\u010a\3\2"+
		"\2\2\u0112\u010e\3\2\2\2\u0113\u011c\3\2\2\2\u0114\u0115\f\6\2\2\u0115"+
		"\u0116\7\33\2\2\u0116\u011b\5&\24\7\u0117\u0118\f\5\2\2\u0118\u0119\7"+
		"\34\2\2\u0119\u011b\5&\24\6\u011a\u0114\3\2\2\2\u011a\u0117\3\2\2\2\u011b"+
		"\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\'\3\2\2\2"+
		"\u011e\u011c\3\2\2\2\u011f\u0120\b\25\1\2\u0120\u0121\t\5\2\2\u0121\u0133"+
		"\5(\25\r\u0122\u0123\7\'\2\2\u0123\u0124\5(\25\2\u0124\u0125\7(\2\2\u0125"+
		"\u0133\3\2\2\2\u0126\u0128\7,\2\2\u0127\u0129\5 \21\2\u0128\u0127\3\2"+
		"\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u0133\3\2\2\2\u012c\u0133\7,\2\2\u012d\u0133\5\26\f\2\u012e\u0133\7$"+
		"\2\2\u012f\u0133\7%\2\2\u0130\u0133\7\"\2\2\u0131\u0133\7#\2\2\u0132\u011f"+
		"\3\2\2\2\u0132\u0122\3\2\2\2\u0132\u0126\3\2\2\2\u0132\u012c\3\2\2\2\u0132"+
		"\u012d\3\2\2\2\u0132\u012e\3\2\2\2\u0132\u012f\3\2\2\2\u0132\u0130\3\2"+
		"\2\2\u0132\u0131\3\2\2\2\u0133\u013c\3\2\2\2\u0134\u0135\f\f\2\2\u0135"+
		"\u0136\t\6\2\2\u0136\u013b\5(\25\r\u0137\u0138\f\13\2\2\u0138\u0139\t"+
		"\5\2\2\u0139\u013b\5(\25\f\u013a\u0134\3\2\2\2\u013a\u0137\3\2\2\2\u013b"+
		"\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d)\3\2\2\2"+
		"\u013e\u013c\3\2\2\2\u013f\u0144\7\20\2\2\u0140\u0141\7)\2\2\u0141\u0143"+
		"\7*\2\2\u0142\u0140\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144"+
		"\u0145\3\2\2\2\u0145\u0158\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u014c\7\21"+
		"\2\2\u0148\u0149\7)\2\2\u0149\u014b\7*\2\2\u014a\u0148\3\2\2\2\u014b\u014e"+
		"\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u0158\3\2\2\2\u014e"+
		"\u014c\3\2\2\2\u014f\u0154\7\22\2\2\u0150\u0151\7)\2\2\u0151\u0153\7*"+
		"\2\2\u0152\u0150\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154"+
		"\u0155\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u013f\3\2"+
		"\2\2\u0157\u0147\3\2\2\2\u0157\u014f\3\2\2\2\u0158+\3\2\2\2+\618=CIUc"+
		"flrv}\u0085\u008c\u0099\u009f\u00a3\u00a9\u00af\u00b3\u00b6\u00bb\u00c7"+
		"\u00cd\u00d1\u00d6\u00e2\u00e5\u00ee\u00f6\u0112\u011a\u011c\u012a\u0132"+
		"\u013a\u013c\u0144\u014c\u0154\u0157";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}