// Generated from Alang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BUD=1, FUNKCIA=2, HOTOVO=3, VYPLUJ=4, MAKAJ=5, JAKAM=6, STACI=7, PRESKOC=8, 
		IF=9, ELSE=10, FI=11, VYPISZNAKY=12, CISLO=13, ZNAK=14, BOOL=15, VOID=16, 
		EQ=17, LT=18, GT=19, LEQ=20, GEQ=21, NEQ=22, NOT=23, AND=24, OR=25, ADD=26, 
		SUB=27, DIV=28, MOD=29, MUL=30, ASSIGN=31, TRUE=32, FALSE=33, INT=34, 
		STRING=35, NEWLINE=36, LPAR=37, RPAR=38, LSQUARE=39, RSQUARE=40, COMMA=41, 
		ID=42, LINE_COMMENT=43, WHITESPACE=44;
	public static final int
		RULE_init = 0, RULE_statements = 1, RULE_statement = 2, RULE_block = 3, 
		RULE_else_block = 4, RULE_arguments = 5, RULE_index_to_array = 6, RULE_index_to_global_array = 7, 
		RULE_global_expression = 8, RULE_expression = 9, RULE_argtype = 10, RULE_var_type = 11, 
		RULE_return_type = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "statements", "statement", "block", "else_block", "arguments", 
			"index_to_array", "index_to_global_array", "global_expression", "expression", 
			"argtype", "var_type", "return_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'BUD'", "'FUNKCIA'", "'HOTOVO'", "'VYPLUJ'", "'MAKAJ'", "'JAKAM'", 
			"'STACI'", "'PRESKOC'", "'IF'", "'ELSE'", "'FI'", "'VYPISZNAKY'", "'CISLO'", 
			"'ZNAK'", "'BOOL'", "'VOID'", "'=='", "'<'", "'>'", "'<='", "'>='", "'!='", 
			"'NOT'", "'AND'", "'OR'", "'+'", "'-'", "'/'", "'%'", "'*'", "'='", "'TRUE'", 
			"'FALSE'", null, null, null, "'('", "')'", "'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BUD", "FUNKCIA", "HOTOVO", "VYPLUJ", "MAKAJ", "JAKAM", "STACI", 
			"PRESKOC", "IF", "ELSE", "FI", "VYPISZNAKY", "CISLO", "ZNAK", "BOOL", 
			"VOID", "EQ", "LT", "GT", "LEQ", "GEQ", "NEQ", "NOT", "AND", "OR", "ADD", 
			"SUB", "DIV", "MOD", "MUL", "ASSIGN", "TRUE", "FALSE", "INT", "STRING", 
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
	public String getGrammarFileName() { return "Alang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AlangParser(TokenStream input) {
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
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
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
		public List<TerminalNode> NEWLINE() { return getTokens(AlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AlangParser.NEWLINE, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitStatements(this);
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
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(28);
				match(NEWLINE);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			statement();
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(36); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(35);
						match(NEWLINE);
						}
						}
						setState(38); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(40);
					statement();
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(46);
				match(NEWLINE);
				}
				}
				setState(51);
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
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncStatContext extends StatementContext {
		public TerminalNode FUNKCIA() { return getToken(AlangParser.FUNKCIA, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(AlangParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(AlangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(AlangParser.RPAR, 0); }
		public TerminalNode HOTOVO() { return getToken(AlangParser.HOTOVO, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(AlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AlangParser.NEWLINE, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public FuncStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitFuncStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDecStatContext extends StatementContext {
		public TerminalNode BUD() { return getToken(AlangParser.BUD, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(AlangParser.ID, 0); }
		public List<Index_to_global_arrayContext> index_to_global_array() {
			return getRuleContexts(Index_to_global_arrayContext.class);
		}
		public Index_to_global_arrayContext index_to_global_array(int i) {
			return getRuleContext(Index_to_global_arrayContext.class,i);
		}
		public VarDecStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitVarDecStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentStatContext extends StatementContext {
		public TerminalNode ID() { return getToken(AlangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(AlangParser.ASSIGN, 0); }
		public Global_expressionContext global_expression() {
			return getRuleContext(Global_expressionContext.class,0);
		}
		public AssignmentStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitAssignmentStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNKCIA:
				_localctx = new FuncStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(FUNKCIA);
				setState(53);
				return_type();
				setState(54);
				match(ID);
				setState(55);
				match(LPAR);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CISLO) | (1L << ZNAK) | (1L << BOOL))) != 0)) {
					{
					setState(56);
					arguments();
					}
				}

				setState(59);
				match(RPAR);
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(60);
					match(NEWLINE);
					}
					}
					setState(63); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << STACI) | (1L << PRESKOC) | (1L << IF) | (1L << VYPISZNAKY) | (1L << ID))) != 0)) {
					{
					{
					setState(65);
					block();
					setState(67); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(66);
						match(NEWLINE);
						}
						}
						setState(69); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(76);
				match(HOTOVO);
				}
				break;
			case BUD:
				_localctx = new VarDecStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(BUD);
				setState(79);
				var_type();
				setState(80);
				match(ID);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(81);
					index_to_global_array();
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ID:
				_localctx = new AssignmentStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(ID);
				setState(88);
				match(ASSIGN);
				setState(89);
				global_expression();
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
		public TerminalNode BUD() { return getToken(AlangParser.BUD, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(AlangParser.ID, 0); }
		public List<Index_to_arrayContext> index_to_array() {
			return getRuleContexts(Index_to_arrayContext.class);
		}
		public Index_to_arrayContext index_to_array(int i) {
			return getRuleContext(Index_to_arrayContext.class,i);
		}
		public BlockVarDecContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockVarDec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockBreakContext extends BlockContext {
		public TerminalNode STACI() { return getToken(AlangParser.STACI, 0); }
		public BlockBreakContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockFuncCallContext extends BlockContext {
		public TerminalNode ID() { return getToken(AlangParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(AlangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(AlangParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AlangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AlangParser.COMMA, i);
		}
		public BlockFuncCallContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockOutputStringContext extends BlockContext {
		public TerminalNode VYPISZNAKY() { return getToken(AlangParser.VYPISZNAKY, 0); }
		public TerminalNode STRING() { return getToken(AlangParser.STRING, 0); }
		public BlockOutputStringContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockOutputString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockIfContext extends BlockContext {
		public TerminalNode IF() { return getToken(AlangParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(AlangParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(AlangParser.RPAR, 0); }
		public TerminalNode FI() { return getToken(AlangParser.FI, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(AlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AlangParser.NEWLINE, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(AlangParser.ELSE, 0); }
		public List<Else_blockContext> else_block() {
			return getRuleContexts(Else_blockContext.class);
		}
		public Else_blockContext else_block(int i) {
			return getRuleContext(Else_blockContext.class,i);
		}
		public BlockIfContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockContinueContext extends BlockContext {
		public TerminalNode PRESKOC() { return getToken(AlangParser.PRESKOC, 0); }
		public BlockContinueContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockContinue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockAsgnContext extends BlockContext {
		public TerminalNode ID() { return getToken(AlangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(AlangParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<Index_to_arrayContext> index_to_array() {
			return getRuleContexts(Index_to_arrayContext.class);
		}
		public Index_to_arrayContext index_to_array(int i) {
			return getRuleContext(Index_to_arrayContext.class,i);
		}
		public BlockAsgnContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockAsgn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockReturnContext extends BlockContext {
		public TerminalNode VYPLUJ() { return getToken(AlangParser.VYPLUJ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockReturnContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockLoopContext extends BlockContext {
		public TerminalNode MAKAJ() { return getToken(AlangParser.MAKAJ, 0); }
		public TerminalNode LPAR() { return getToken(AlangParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(AlangParser.RPAR, 0); }
		public TerminalNode JAKAM() { return getToken(AlangParser.JAKAM, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(AlangParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AlangParser.NEWLINE, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public BlockLoopContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			int _alt;
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new BlockVarDecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(BUD);
				setState(93);
				var_type();
				setState(94);
				match(ID);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(95);
					index_to_array();
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new BlockAsgnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(ID);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(102);
					index_to_array();
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(108);
				match(ASSIGN);
				setState(109);
				expression(0);
				}
				break;
			case 3:
				_localctx = new BlockFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				match(ID);
				setState(111);
				match(LPAR);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << ADD) | (1L << SUB) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << STRING) | (1L << LPAR) | (1L << ID))) != 0)) {
					{
					setState(112);
					expression(0);
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(113);
						match(COMMA);
						setState(114);
						expression(0);
						}
						}
						setState(119);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(122);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new BlockOutputStringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(VYPISZNAKY);
				setState(124);
				match(STRING);
				}
				break;
			case 5:
				_localctx = new BlockReturnContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(125);
				match(VYPLUJ);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << ADD) | (1L << SUB) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << STRING) | (1L << LPAR) | (1L << ID))) != 0)) {
					{
					setState(126);
					expression(0);
					}
				}

				}
				break;
			case 6:
				_localctx = new BlockLoopContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
				match(MAKAJ);
				setState(130);
				match(LPAR);
				setState(131);
				expression(0);
				setState(132);
				match(RPAR);
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(133);
					match(NEWLINE);
					}
					}
					setState(136); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(138);
					block();
					setState(140); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(139);
							match(NEWLINE);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(142); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					setState(146); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << STACI) | (1L << PRESKOC) | (1L << IF) | (1L << VYPISZNAKY) | (1L << ID))) != 0) );
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(148);
					match(NEWLINE);
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(154);
				match(JAKAM);
				}
				break;
			case 7:
				_localctx = new BlockIfContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(156);
				match(IF);
				setState(157);
				match(LPAR);
				setState(158);
				expression(0);
				setState(159);
				match(RPAR);
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(160);
					match(NEWLINE);
					}
					}
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(165);
					block();
					setState(167); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(166);
							match(NEWLINE);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(169); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					setState(173); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << STACI) | (1L << PRESKOC) | (1L << IF) | (1L << VYPISZNAKY) | (1L << ID))) != 0) );
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(175);
					match(ELSE);
					setState(177); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(176);
							match(NEWLINE);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(179); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << STACI) | (1L << PRESKOC) | (1L << IF) | (1L << VYPISZNAKY) | (1L << ID))) != 0)) {
						{
						{
						setState(181);
						else_block();
						setState(183); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(182);
								match(NEWLINE);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(185); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(191);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(194);
					match(NEWLINE);
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(FI);
				}
				break;
			case 8:
				_localctx = new BlockBreakContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(202);
				match(STACI);
				}
				break;
			case 9:
				_localctx = new BlockContinueContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(203);
				match(PRESKOC);
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

	public static class Else_blockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitElse_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_blockContext else_block() throws RecognitionException {
		Else_blockContext _localctx = new Else_blockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_else_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ArgtypeContext> argtype() {
			return getRuleContexts(ArgtypeContext.class);
		}
		public ArgtypeContext argtype(int i) {
			return getRuleContext(ArgtypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(AlangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AlangParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AlangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AlangParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			argtype();
			setState(209);
			match(ID);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(210);
				match(COMMA);
				setState(211);
				argtype();
				setState(212);
				match(ID);
				}
				}
				setState(218);
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

	public static class Index_to_arrayContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(AlangParser.LSQUARE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSQUARE() { return getToken(AlangParser.RSQUARE, 0); }
		public Index_to_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_to_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitIndex_to_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Index_to_arrayContext index_to_array() throws RecognitionException {
		Index_to_arrayContext _localctx = new Index_to_arrayContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_index_to_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(LSQUARE);
			setState(220);
			expression(0);
			setState(221);
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

	public static class Index_to_global_arrayContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(AlangParser.LSQUARE, 0); }
		public TerminalNode INT() { return getToken(AlangParser.INT, 0); }
		public TerminalNode RSQUARE() { return getToken(AlangParser.RSQUARE, 0); }
		public Index_to_global_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_to_global_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitIndex_to_global_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Index_to_global_arrayContext index_to_global_array() throws RecognitionException {
		Index_to_global_arrayContext _localctx = new Index_to_global_arrayContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_index_to_global_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(LSQUARE);
			setState(224);
			match(INT);
			setState(225);
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

	public static class Global_expressionContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AlangParser.INT, 0); }
		public TerminalNode TRUE() { return getToken(AlangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(AlangParser.FALSE, 0); }
		public Global_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitGlobal_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_expressionContext global_expression() throws RecognitionException {
		Global_expressionContext _localctx = new Global_expressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_global_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << INT))) != 0)) ) {
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
	public static class ExpFalseContext extends ExpressionContext {
		public TerminalNode FALSE() { return getToken(AlangParser.FALSE, 0); }
		public ExpFalseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpUnaContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(AlangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(AlangParser.SUB, 0); }
		public TerminalNode NOT() { return getToken(AlangParser.NOT, 0); }
		public ExpUnaContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpUna(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpParContext extends ExpressionContext {
		public TerminalNode LPAR() { return getToken(AlangParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(AlangParser.RPAR, 0); }
		public ExpParContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpPar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpFuncCallContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(AlangParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(AlangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(AlangParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AlangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AlangParser.COMMA, i);
		}
		public ExpFuncCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpCharContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(AlangParser.STRING, 0); }
		public ExpCharContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpChar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpTrueContext extends ExpressionContext {
		public TerminalNode TRUE() { return getToken(AlangParser.TRUE, 0); }
		public ExpTrueContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpTrue(this);
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
		public TerminalNode ADD() { return getToken(AlangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(AlangParser.SUB, 0); }
		public ExpAddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpCompContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(AlangParser.EQ, 0); }
		public TerminalNode LT() { return getToken(AlangParser.LT, 0); }
		public TerminalNode GT() { return getToken(AlangParser.GT, 0); }
		public TerminalNode LEQ() { return getToken(AlangParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(AlangParser.GEQ, 0); }
		public TerminalNode NEQ() { return getToken(AlangParser.NEQ, 0); }
		public ExpCompContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpComp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpDivMulModContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIV() { return getToken(AlangParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(AlangParser.MUL, 0); }
		public TerminalNode MOD() { return getToken(AlangParser.MOD, 0); }
		public ExpDivMulModContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpDivMulMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIdArrayContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(AlangParser.ID, 0); }
		public List<Index_to_arrayContext> index_to_array() {
			return getRuleContexts(Index_to_arrayContext.class);
		}
		public Index_to_arrayContext index_to_array(int i) {
			return getRuleContext(Index_to_arrayContext.class,i);
		}
		public ExpIdArrayContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpIdArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIdContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(AlangParser.ID, 0); }
		public ExpIdContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpAndOrContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(AlangParser.AND, 0); }
		public TerminalNode OR() { return getToken(AlangParser.OR, 0); }
		public ExpAndOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpAndOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpIntContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(AlangParser.INT, 0); }
		public ExpIntContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpInt(this);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				_localctx = new ExpUnaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(230);
				((ExpUnaContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << ADD) | (1L << SUB))) != 0)) ) {
					((ExpUnaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(231);
				expression(13);
				}
				break;
			case 2:
				{
				_localctx = new ExpParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(LPAR);
				setState(233);
				expression(0);
				setState(234);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new ExpIdArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				match(ID);
				setState(238); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(237);
						index_to_array();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(240); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				{
				_localctx = new ExpIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ExpFuncCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243);
				match(ID);
				setState(244);
				match(LPAR);
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << ADD) | (1L << SUB) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << STRING) | (1L << LPAR) | (1L << ID))) != 0)) {
					{
					setState(245);
					expression(0);
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(246);
						match(COMMA);
						setState(247);
						expression(0);
						}
						}
						setState(252);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(255);
				match(RPAR);
				}
				break;
			case 6:
				{
				_localctx = new ExpIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(INT);
				}
				break;
			case 7:
				{
				_localctx = new ExpCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExpTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				match(TRUE);
				}
				break;
			case 9:
				{
				_localctx = new ExpFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(259);
				match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(274);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExpDivMulModContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(262);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(263);
						((ExpDivMulModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIV) | (1L << MOD) | (1L << MUL))) != 0)) ) {
							((ExpDivMulModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(264);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(265);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(266);
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
						setState(267);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpCompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(268);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(269);
						((ExpCompContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << LT) | (1L << GT) | (1L << LEQ) | (1L << GEQ) | (1L << NEQ))) != 0)) ) {
							((ExpCompContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(270);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpAndOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(271);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(272);
						((ExpAndOrContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((ExpAndOrContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(273);
						expression(10);
						}
						break;
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		public TerminalNode CISLO() { return getToken(AlangParser.CISLO, 0); }
		public List<TerminalNode> LSQUARE() { return getTokens(AlangParser.LSQUARE); }
		public TerminalNode LSQUARE(int i) {
			return getToken(AlangParser.LSQUARE, i);
		}
		public List<TerminalNode> RSQUARE() { return getTokens(AlangParser.RSQUARE); }
		public TerminalNode RSQUARE(int i) {
			return getToken(AlangParser.RSQUARE, i);
		}
		public TerminalNode ZNAK() { return getToken(AlangParser.ZNAK, 0); }
		public TerminalNode BOOL() { return getToken(AlangParser.BOOL, 0); }
		public ArgtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argtype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitArgtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgtypeContext argtype() throws RecognitionException {
		ArgtypeContext _localctx = new ArgtypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_argtype);
		int _la;
		try {
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CISLO:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				match(CISLO);
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(280);
					match(LSQUARE);
					setState(281);
					match(RSQUARE);
					}
					}
					setState(286);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ZNAK:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(ZNAK);
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(288);
					match(LSQUARE);
					setState(289);
					match(RSQUARE);
					}
					}
					setState(294);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(295);
				match(BOOL);
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(296);
					match(LSQUARE);
					setState(297);
					match(RSQUARE);
					}
					}
					setState(302);
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

	public static class Var_typeContext extends ParserRuleContext {
		public TerminalNode CISLO() { return getToken(AlangParser.CISLO, 0); }
		public TerminalNode ZNAK() { return getToken(AlangParser.ZNAK, 0); }
		public TerminalNode BOOL() { return getToken(AlangParser.BOOL, 0); }
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitVar_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_var_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CISLO) | (1L << ZNAK) | (1L << BOOL))) != 0)) ) {
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
		public TerminalNode CISLO() { return getToken(AlangParser.CISLO, 0); }
		public TerminalNode ZNAK() { return getToken(AlangParser.ZNAK, 0); }
		public TerminalNode BOOL() { return getToken(AlangParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(AlangParser.VOID, 0); }
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitReturn_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CISLO) | (1L << ZNAK) | (1L << BOOL) | (1L << VOID))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0138\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\7\3 \n\3\f\3\16\3#\13\3\3\3"+
		"\3\3\6\3\'\n\3\r\3\16\3(\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\7\3\62\n\3\f"+
		"\3\16\3\65\13\3\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\4\3\4\6\4@\n\4\r\4\16\4"+
		"A\3\4\3\4\6\4F\n\4\r\4\16\4G\7\4J\n\4\f\4\16\4M\13\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\7\4U\n\4\f\4\16\4X\13\4\3\4\3\4\3\4\5\4]\n\4\3\5\3\5\3\5\3\5\7"+
		"\5c\n\5\f\5\16\5f\13\5\3\5\3\5\7\5j\n\5\f\5\16\5m\13\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\7\5v\n\5\f\5\16\5y\13\5\5\5{\n\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"\u0082\n\5\3\5\3\5\3\5\3\5\3\5\6\5\u0089\n\5\r\5\16\5\u008a\3\5\3\5\6"+
		"\5\u008f\n\5\r\5\16\5\u0090\6\5\u0093\n\5\r\5\16\5\u0094\3\5\7\5\u0098"+
		"\n\5\f\5\16\5\u009b\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5\u00a4\n\5\r\5"+
		"\16\5\u00a5\3\5\3\5\6\5\u00aa\n\5\r\5\16\5\u00ab\6\5\u00ae\n\5\r\5\16"+
		"\5\u00af\3\5\3\5\6\5\u00b4\n\5\r\5\16\5\u00b5\3\5\3\5\6\5\u00ba\n\5\r"+
		"\5\16\5\u00bb\7\5\u00be\n\5\f\5\16\5\u00c1\13\5\5\5\u00c3\n\5\3\5\7\5"+
		"\u00c6\n\5\f\5\16\5\u00c9\13\5\3\5\3\5\3\5\3\5\5\5\u00cf\n\5\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\7\7\u00d9\n\7\f\7\16\7\u00dc\13\7\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\6\13\u00f1\n\13\r\13\16\13\u00f2\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00fb"+
		"\n\13\f\13\16\13\u00fe\13\13\5\13\u0100\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u0107\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u0115\n\13\f\13\16\13\u0118\13\13\3\f\3\f\3\f\7\f\u011d\n\f"+
		"\f\f\16\f\u0120\13\f\3\f\3\f\3\f\7\f\u0125\n\f\f\f\16\f\u0128\13\f\3\f"+
		"\3\f\3\f\7\f\u012d\n\f\f\f\16\f\u0130\13\f\5\f\u0132\n\f\3\r\3\r\3\16"+
		"\3\16\3\16\2\3\24\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\n\3\2\"$\4\2\31"+
		"\31\34\35\3\2\36 \3\2\34\35\3\2\23\30\3\2\32\33\3\2\17\21\3\2\17\22\2"+
		"\u0163\2\34\3\2\2\2\4!\3\2\2\2\6\\\3\2\2\2\b\u00ce\3\2\2\2\n\u00d0\3\2"+
		"\2\2\f\u00d2\3\2\2\2\16\u00dd\3\2\2\2\20\u00e1\3\2\2\2\22\u00e5\3\2\2"+
		"\2\24\u0106\3\2\2\2\26\u0131\3\2\2\2\30\u0133\3\2\2\2\32\u0135\3\2\2\2"+
		"\34\35\5\4\3\2\35\3\3\2\2\2\36 \7&\2\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2"+
		"\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$-\5\6\4\2%\'\7&\2\2&%\3\2\2\2\'("+
		"\3\2\2\2(&\3\2\2\2()\3\2\2\2)*\3\2\2\2*,\5\6\4\2+&\3\2\2\2,/\3\2\2\2-"+
		"+\3\2\2\2-.\3\2\2\2.\63\3\2\2\2/-\3\2\2\2\60\62\7&\2\2\61\60\3\2\2\2\62"+
		"\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\5\3\2\2\2\65\63\3\2\2\2\66"+
		"\67\7\4\2\2\678\5\32\16\289\7,\2\29;\7\'\2\2:<\5\f\7\2;:\3\2\2\2;<\3\2"+
		"\2\2<=\3\2\2\2=?\7(\2\2>@\7&\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2"+
		"\2BK\3\2\2\2CE\5\b\5\2DF\7&\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2"+
		"\2HJ\3\2\2\2IC\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2"+
		"\2NO\7\5\2\2O]\3\2\2\2PQ\7\3\2\2QR\5\30\r\2RV\7,\2\2SU\5\20\t\2TS\3\2"+
		"\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W]\3\2\2\2XV\3\2\2\2YZ\7,\2\2Z[\7!\2"+
		"\2[]\5\22\n\2\\\66\3\2\2\2\\P\3\2\2\2\\Y\3\2\2\2]\7\3\2\2\2^_\7\3\2\2"+
		"_`\5\30\r\2`d\7,\2\2ac\5\16\b\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2"+
		"\2e\u00cf\3\2\2\2fd\3\2\2\2gk\7,\2\2hj\5\16\b\2ih\3\2\2\2jm\3\2\2\2ki"+
		"\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7!\2\2o\u00cf\5\24\13\2pq\7,"+
		"\2\2qz\7\'\2\2rw\5\24\13\2st\7+\2\2tv\5\24\13\2us\3\2\2\2vy\3\2\2\2wu"+
		"\3\2\2\2wx\3\2\2\2x{\3\2\2\2yw\3\2\2\2zr\3\2\2\2z{\3\2\2\2{|\3\2\2\2|"+
		"\u00cf\7(\2\2}~\7\16\2\2~\u00cf\7%\2\2\177\u0081\7\6\2\2\u0080\u0082\5"+
		"\24\13\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u00cf\3\2\2\2\u0083"+
		"\u0084\7\7\2\2\u0084\u0085\7\'\2\2\u0085\u0086\5\24\13\2\u0086\u0088\7"+
		"(\2\2\u0087\u0089\7&\2\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0092\3\2\2\2\u008c\u008e\5\b"+
		"\5\2\u008d\u008f\7&\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u008c\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0099\3\2\2\2\u0096\u0098\7&\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u009d\7\b\2\2\u009d\u00cf\3\2\2\2\u009e\u009f\7\13"+
		"\2\2\u009f\u00a0\7\'\2\2\u00a0\u00a1\5\24\13\2\u00a1\u00a3\7(\2\2\u00a2"+
		"\u00a4\7&\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00ad\3\2\2\2\u00a7\u00a9\5\b\5\2\u00a8"+
		"\u00aa\7&\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a7\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00c2\3\2"+
		"\2\2\u00b1\u00b3\7\f\2\2\u00b2\u00b4\7&\2\2\u00b3\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00bf\3\2"+
		"\2\2\u00b7\u00b9\5\n\6\2\u00b8\u00ba\7&\2\2\u00b9\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2"+
		"\2\2\u00bd\u00b7\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00b1\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c7\3\2\2\2\u00c4\u00c6\7&\2\2\u00c5"+
		"\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\r\2\2\u00cb"+
		"\u00cf\3\2\2\2\u00cc\u00cf\7\t\2\2\u00cd\u00cf\7\n\2\2\u00ce^\3\2\2\2"+
		"\u00ceg\3\2\2\2\u00cep\3\2\2\2\u00ce}\3\2\2\2\u00ce\177\3\2\2\2\u00ce"+
		"\u0083\3\2\2\2\u00ce\u009e\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2"+
		"\2\2\u00cf\t\3\2\2\2\u00d0\u00d1\5\b\5\2\u00d1\13\3\2\2\2\u00d2\u00d3"+
		"\5\26\f\2\u00d3\u00da\7,\2\2\u00d4\u00d5\7+\2\2\u00d5\u00d6\5\26\f\2\u00d6"+
		"\u00d7\7,\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d4\3\2\2\2\u00d9\u00dc\3\2"+
		"\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\r\3\2\2\2\u00dc\u00da"+
		"\3\2\2\2\u00dd\u00de\7)\2\2\u00de\u00df\5\24\13\2\u00df\u00e0\7*\2\2\u00e0"+
		"\17\3\2\2\2\u00e1\u00e2\7)\2\2\u00e2\u00e3\7$\2\2\u00e3\u00e4\7*\2\2\u00e4"+
		"\21\3\2\2\2\u00e5\u00e6\t\2\2\2\u00e6\23\3\2\2\2\u00e7\u00e8\b\13\1\2"+
		"\u00e8\u00e9\t\3\2\2\u00e9\u0107\5\24\13\17\u00ea\u00eb\7\'\2\2\u00eb"+
		"\u00ec\5\24\13\2\u00ec\u00ed\7(\2\2\u00ed\u0107\3\2\2\2\u00ee\u00f0\7"+
		",\2\2\u00ef\u00f1\5\16\b\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u0107\3\2\2\2\u00f4\u0107\7,"+
		"\2\2\u00f5\u00f6\7,\2\2\u00f6\u00ff\7\'\2\2\u00f7\u00fc\5\24\13\2\u00f8"+
		"\u00f9\7+\2\2\u00f9\u00fb\5\24\13\2\u00fa\u00f8\3\2\2\2\u00fb\u00fe\3"+
		"\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00ff\u00f7\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\u0107\7(\2\2\u0102\u0107\7$\2\2\u0103\u0107\7%\2\2\u0104\u0107"+
		"\7\"\2\2\u0105\u0107\7#\2\2\u0106\u00e7\3\2\2\2\u0106\u00ea\3\2\2\2\u0106"+
		"\u00ee\3\2\2\2\u0106\u00f4\3\2\2\2\u0106\u00f5\3\2\2\2\u0106\u0102\3\2"+
		"\2\2\u0106\u0103\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0105\3\2\2\2\u0107"+
		"\u0116\3\2\2\2\u0108\u0109\f\16\2\2\u0109\u010a\t\4\2\2\u010a\u0115\5"+
		"\24\13\17\u010b\u010c\f\r\2\2\u010c\u010d\t\5\2\2\u010d\u0115\5\24\13"+
		"\16\u010e\u010f\f\f\2\2\u010f\u0110\t\6\2\2\u0110\u0115\5\24\13\r\u0111"+
		"\u0112\f\13\2\2\u0112\u0113\t\7\2\2\u0113\u0115\5\24\13\f\u0114\u0108"+
		"\3\2\2\2\u0114\u010b\3\2\2\2\u0114\u010e\3\2\2\2\u0114\u0111\3\2\2\2\u0115"+
		"\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\25\3\2\2"+
		"\2\u0118\u0116\3\2\2\2\u0119\u011e\7\17\2\2\u011a\u011b\7)\2\2\u011b\u011d"+
		"\7*\2\2\u011c\u011a\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0132\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0126\7\20"+
		"\2\2\u0122\u0123\7)\2\2\u0123\u0125\7*\2\2\u0124\u0122\3\2\2\2\u0125\u0128"+
		"\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0132\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0129\u012e\7\21\2\2\u012a\u012b\7)\2\2\u012b\u012d\7*"+
		"\2\2\u012c\u012a\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0119\3\2"+
		"\2\2\u0131\u0121\3\2\2\2\u0131\u0129\3\2\2\2\u0132\27\3\2\2\2\u0133\u0134"+
		"\t\b\2\2\u0134\31\3\2\2\2\u0135\u0136\t\t\2\2\u0136\33\3\2\2\2)!(-\63"+
		";AGKV\\dkwz\u0081\u008a\u0090\u0094\u0099\u00a5\u00ab\u00af\u00b5\u00bb"+
		"\u00bf\u00c2\u00c7\u00ce\u00da\u00f2\u00fc\u00ff\u0106\u0114\u0116\u011e"+
		"\u0126\u012e\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}