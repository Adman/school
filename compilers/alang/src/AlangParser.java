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
		IF=9, ELSE=10, FI=11, CITAJCISLO=12, CITAJRIADOK=13, VYPISCISLO=14, VYPISCISLOLN=15, 
		VYPISZNAKY=16, VYPISZNAKYLN=17, CISLO=18, ZNAK=19, BOOL=20, VOID=21, EQ=22, 
		LT=23, GT=24, LEQ=25, GEQ=26, NEQ=27, NOT=28, AND=29, OR=30, ADD=31, SUB=32, 
		DIV=33, MOD=34, MUL=35, ASSIGN=36, TRUE=37, FALSE=38, INT=39, STRING=40, 
		NEWLINE=41, LPAR=42, RPAR=43, LSQUARE=44, RSQUARE=45, COMMA=46, ID=47, 
		LINE_COMMENT=48, WHITESPACE=49;
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
			"'STACI'", "'PRESKOC'", "'IF'", "'ELSE'", "'FI'", "'CITAJCISLO'", "'CITAJRIADOK'", 
			"'VYPISCISLO'", "'VYPISCISLOLN'", "'VYPISZNAKY'", "'VYPISZNAKYLN'", "'CISLO'", 
			"'ZNAK'", "'BOOL'", "'VOID'", "'=='", "'<'", "'>'", "'<='", "'>='", "'!='", 
			"'NOT'", "'AND'", "'OR'", "'+'", "'-'", "'/'", "'%'", "'*'", "'='", "'TRUE'", 
			"'FALSE'", null, null, null, "'('", "')'", "'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BUD", "FUNKCIA", "HOTOVO", "VYPLUJ", "MAKAJ", "JAKAM", "STACI", 
			"PRESKOC", "IF", "ELSE", "FI", "CITAJCISLO", "CITAJRIADOK", "VYPISCISLO", 
			"VYPISCISLOLN", "VYPISZNAKY", "VYPISZNAKYLN", "CISLO", "ZNAK", "BOOL", 
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << STACI) | (1L << PRESKOC) | (1L << IF) | (1L << VYPISCISLO) | (1L << VYPISCISLOLN) | (1L << VYPISZNAKY) | (1L << VYPISZNAKYLN) | (1L << ID))) != 0)) {
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
	public static class BlockOutputStringLnContext extends BlockContext {
		public TerminalNode VYPISZNAKYLN() { return getToken(AlangParser.VYPISZNAKYLN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockOutputStringLnContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockOutputStringLn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockOutputStringContext extends BlockContext {
		public TerminalNode VYPISZNAKY() { return getToken(AlangParser.VYPISZNAKY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
	public static class BlockOutputIntLnContext extends BlockContext {
		public TerminalNode VYPISCISLOLN() { return getToken(AlangParser.VYPISCISLOLN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockOutputIntLnContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockOutputIntLn(this);
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
	public static class BlockOutputIntContext extends BlockContext {
		public TerminalNode VYPISCISLO() { return getToken(AlangParser.VYPISCISLO, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockOutputIntContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitBlockOutputInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			int _alt;
			setState(210);
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
				_localctx = new BlockOutputIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(VYPISCISLO);
				setState(124);
				expression(0);
				}
				break;
			case 5:
				_localctx = new BlockOutputIntLnContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(125);
				match(VYPISCISLOLN);
				setState(126);
				expression(0);
				}
				break;
			case 6:
				_localctx = new BlockOutputStringContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
				match(VYPISZNAKY);
				setState(128);
				expression(0);
				}
				break;
			case 7:
				_localctx = new BlockOutputStringLnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(129);
				match(VYPISZNAKYLN);
				setState(130);
				expression(0);
				}
				break;
			case 8:
				_localctx = new BlockReturnContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(131);
				match(VYPLUJ);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << ADD) | (1L << SUB) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << STRING) | (1L << LPAR) | (1L << ID))) != 0)) {
					{
					setState(132);
					expression(0);
					}
				}

				}
				break;
			case 9:
				_localctx = new BlockLoopContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(135);
				match(MAKAJ);
				setState(136);
				match(LPAR);
				setState(137);
				expression(0);
				setState(138);
				match(RPAR);
				setState(140); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(139);
					match(NEWLINE);
					}
					}
					setState(142); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(144);
					block();
					setState(146); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(145);
							match(NEWLINE);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(148); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					setState(152); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << STACI) | (1L << PRESKOC) | (1L << IF) | (1L << VYPISCISLO) | (1L << VYPISCISLOLN) | (1L << VYPISZNAKY) | (1L << VYPISZNAKYLN) | (1L << ID))) != 0) );
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(154);
					match(NEWLINE);
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(160);
				match(JAKAM);
				}
				break;
			case 10:
				_localctx = new BlockIfContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(162);
				match(IF);
				setState(163);
				match(LPAR);
				setState(164);
				expression(0);
				setState(165);
				match(RPAR);
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(166);
					match(NEWLINE);
					}
					}
					setState(169); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(171);
					block();
					setState(173); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(172);
							match(NEWLINE);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(175); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					setState(179); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << STACI) | (1L << PRESKOC) | (1L << IF) | (1L << VYPISCISLO) | (1L << VYPISCISLOLN) | (1L << VYPISZNAKY) | (1L << VYPISZNAKYLN) | (1L << ID))) != 0) );
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(181);
					match(ELSE);
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
						_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BUD) | (1L << VYPLUJ) | (1L << MAKAJ) | (1L << STACI) | (1L << PRESKOC) | (1L << IF) | (1L << VYPISCISLO) | (1L << VYPISCISLOLN) | (1L << VYPISZNAKY) | (1L << VYPISZNAKYLN) | (1L << ID))) != 0)) {
						{
						{
						setState(187);
						else_block();
						setState(189); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(188);
								match(NEWLINE);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(191); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						}
						setState(197);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(200);
					match(NEWLINE);
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(206);
				match(FI);
				}
				break;
			case 11:
				_localctx = new BlockBreakContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(208);
				match(STACI);
				}
				break;
			case 12:
				_localctx = new BlockContinueContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(209);
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
			setState(212);
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
			setState(214);
			argtype();
			setState(215);
			match(ID);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(216);
				match(COMMA);
				setState(217);
				argtype();
				setState(218);
				match(ID);
				}
				}
				setState(224);
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
			setState(225);
			match(LSQUARE);
			setState(226);
			expression(0);
			setState(227);
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
			setState(229);
			match(LSQUARE);
			setState(230);
			match(INT);
			setState(231);
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
		public TerminalNode STRING() { return getToken(AlangParser.STRING, 0); }
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
			setState(233);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << STRING))) != 0)) ) {
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
	public static class ExpStringContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(AlangParser.STRING, 0); }
		public ExpStringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlangVisitor ) return ((AlangVisitor<? extends T>)visitor).visitExpString(this);
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
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				_localctx = new ExpUnaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(236);
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
				setState(237);
				expression(13);
				}
				break;
			case 2:
				{
				_localctx = new ExpParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				match(LPAR);
				setState(239);
				expression(0);
				setState(240);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new ExpIdArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
				match(ID);
				setState(244); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(243);
						index_to_array();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(246); 
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
				setState(248);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ExpFuncCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249);
				match(ID);
				setState(250);
				match(LPAR);
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << ADD) | (1L << SUB) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << STRING) | (1L << LPAR) | (1L << ID))) != 0)) {
					{
					setState(251);
					expression(0);
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(252);
						match(COMMA);
						setState(253);
						expression(0);
						}
						}
						setState(258);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(261);
				match(RPAR);
				}
				break;
			case 6:
				{
				_localctx = new ExpIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				match(INT);
				}
				break;
			case 7:
				{
				_localctx = new ExpStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExpTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				match(TRUE);
				}
				break;
			case 9:
				{
				_localctx = new ExpFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				match(FALSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(280);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExpDivMulModContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(268);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(269);
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
						setState(270);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(271);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(272);
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
						setState(273);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpCompContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(274);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(275);
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
						setState(276);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpAndOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(278);
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
						setState(279);
						expression(10);
						}
						break;
					}
					} 
				}
				setState(284);
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
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CISLO:
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				match(CISLO);
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(286);
					match(LSQUARE);
					setState(287);
					match(RSQUARE);
					}
					}
					setState(292);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ZNAK:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				match(ZNAK);
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(294);
					match(LSQUARE);
					setState(295);
					match(RSQUARE);
					}
					}
					setState(300);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(301);
				match(BOOL);
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LSQUARE) {
					{
					{
					setState(302);
					match(LSQUARE);
					setState(303);
					match(RSQUARE);
					}
					}
					setState(308);
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
			setState(311);
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
			setState(313);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u013e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\7\3 \n\3\f\3\16\3#\13\3\3"+
		"\3\3\3\6\3\'\n\3\r\3\16\3(\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\7\3\62\n\3"+
		"\f\3\16\3\65\13\3\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\4\3\4\6\4@\n\4\r\4\16"+
		"\4A\3\4\3\4\6\4F\n\4\r\4\16\4G\7\4J\n\4\f\4\16\4M\13\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4U\n\4\f\4\16\4X\13\4\3\4\3\4\3\4\5\4]\n\4\3\5\3\5\3\5\3\5"+
		"\7\5c\n\5\f\5\16\5f\13\5\3\5\3\5\7\5j\n\5\f\5\16\5m\13\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\7\5v\n\5\f\5\16\5y\13\5\5\5{\n\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5\u0088\n\5\3\5\3\5\3\5\3\5\3\5\6\5\u008f\n\5"+
		"\r\5\16\5\u0090\3\5\3\5\6\5\u0095\n\5\r\5\16\5\u0096\6\5\u0099\n\5\r\5"+
		"\16\5\u009a\3\5\7\5\u009e\n\5\f\5\16\5\u00a1\13\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\6\5\u00aa\n\5\r\5\16\5\u00ab\3\5\3\5\6\5\u00b0\n\5\r\5\16\5\u00b1"+
		"\6\5\u00b4\n\5\r\5\16\5\u00b5\3\5\3\5\6\5\u00ba\n\5\r\5\16\5\u00bb\3\5"+
		"\3\5\6\5\u00c0\n\5\r\5\16\5\u00c1\7\5\u00c4\n\5\f\5\16\5\u00c7\13\5\5"+
		"\5\u00c9\n\5\3\5\7\5\u00cc\n\5\f\5\16\5\u00cf\13\5\3\5\3\5\3\5\3\5\5\5"+
		"\u00d5\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00df\n\7\f\7\16\7\u00e2"+
		"\13\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\6\13\u00f7\n\13\r\13\16\13\u00f8\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\7\13\u0101\n\13\f\13\16\13\u0104\13\13\5\13\u0106\n\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u010d\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u011b\n\13\f\13\16\13\u011e\13\13"+
		"\3\f\3\f\3\f\7\f\u0123\n\f\f\f\16\f\u0126\13\f\3\f\3\f\3\f\7\f\u012b\n"+
		"\f\f\f\16\f\u012e\13\f\3\f\3\f\3\f\7\f\u0133\n\f\f\f\16\f\u0136\13\f\5"+
		"\f\u0138\n\f\3\r\3\r\3\16\3\16\3\16\2\3\24\17\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\2\n\3\2\'*\4\2\36\36!\"\3\2#%\3\2!\"\3\2\30\35\3\2\37 \3\2\24"+
		"\26\3\2\24\27\2\u016c\2\34\3\2\2\2\4!\3\2\2\2\6\\\3\2\2\2\b\u00d4\3\2"+
		"\2\2\n\u00d6\3\2\2\2\f\u00d8\3\2\2\2\16\u00e3\3\2\2\2\20\u00e7\3\2\2\2"+
		"\22\u00eb\3\2\2\2\24\u010c\3\2\2\2\26\u0137\3\2\2\2\30\u0139\3\2\2\2\32"+
		"\u013b\3\2\2\2\34\35\5\4\3\2\35\3\3\2\2\2\36 \7+\2\2\37\36\3\2\2\2 #\3"+
		"\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$-\5\6\4\2%\'\7+\2\2"+
		"&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)*\3\2\2\2*,\5\6\4\2+&\3\2\2"+
		"\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\63\3\2\2\2/-\3\2\2\2\60\62\7+\2\2\61"+
		"\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\5\3\2\2\2\65"+
		"\63\3\2\2\2\66\67\7\4\2\2\678\5\32\16\289\7\61\2\29;\7,\2\2:<\5\f\7\2"+
		";:\3\2\2\2;<\3\2\2\2<=\3\2\2\2=?\7-\2\2>@\7+\2\2?>\3\2\2\2@A\3\2\2\2A"+
		"?\3\2\2\2AB\3\2\2\2BK\3\2\2\2CE\5\b\5\2DF\7+\2\2ED\3\2\2\2FG\3\2\2\2G"+
		"E\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IC\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2"+
		"LN\3\2\2\2MK\3\2\2\2NO\7\5\2\2O]\3\2\2\2PQ\7\3\2\2QR\5\30\r\2RV\7\61\2"+
		"\2SU\5\20\t\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W]\3\2\2\2XV\3\2"+
		"\2\2YZ\7\61\2\2Z[\7&\2\2[]\5\22\n\2\\\66\3\2\2\2\\P\3\2\2\2\\Y\3\2\2\2"+
		"]\7\3\2\2\2^_\7\3\2\2_`\5\30\r\2`d\7\61\2\2ac\5\16\b\2ba\3\2\2\2cf\3\2"+
		"\2\2db\3\2\2\2de\3\2\2\2e\u00d5\3\2\2\2fd\3\2\2\2gk\7\61\2\2hj\5\16\b"+
		"\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7&\2"+
		"\2o\u00d5\5\24\13\2pq\7\61\2\2qz\7,\2\2rw\5\24\13\2st\7\60\2\2tv\5\24"+
		"\13\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x{\3\2\2\2yw\3\2\2\2zr\3"+
		"\2\2\2z{\3\2\2\2{|\3\2\2\2|\u00d5\7-\2\2}~\7\20\2\2~\u00d5\5\24\13\2\177"+
		"\u0080\7\21\2\2\u0080\u00d5\5\24\13\2\u0081\u0082\7\22\2\2\u0082\u00d5"+
		"\5\24\13\2\u0083\u0084\7\23\2\2\u0084\u00d5\5\24\13\2\u0085\u0087\7\6"+
		"\2\2\u0086\u0088\5\24\13\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u00d5\3\2\2\2\u0089\u008a\7\7\2\2\u008a\u008b\7,\2\2\u008b\u008c\5\24"+
		"\13\2\u008c\u008e\7-\2\2\u008d\u008f\7+\2\2\u008e\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0098\3\2"+
		"\2\2\u0092\u0094\5\b\5\2\u0093\u0095\7+\2\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2"+
		"\2\2\u0098\u0092\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u009f\3\2\2\2\u009c\u009e\7+\2\2\u009d\u009c\3\2"+
		"\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7\b\2\2\u00a3\u00d5\3\2"+
		"\2\2\u00a4\u00a5\7\13\2\2\u00a5\u00a6\7,\2\2\u00a6\u00a7\5\24\13\2\u00a7"+
		"\u00a9\7-\2\2\u00a8\u00aa\7+\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2"+
		"\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00b3\3\2\2\2\u00ad\u00af"+
		"\5\b\5\2\u00ae\u00b0\7+\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00ad\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00c8\3\2\2\2\u00b7\u00b9\7\f\2\2\u00b8\u00ba\7+\2\2\u00b9\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00c5\3\2\2\2\u00bd\u00bf\5\n\6\2\u00be\u00c0\7+\2\2\u00bf\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c4\3\2\2\2\u00c3\u00bd\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2"+
		"\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8"+
		"\u00b7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cd\3\2\2\2\u00ca\u00cc\7+"+
		"\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\7\r"+
		"\2\2\u00d1\u00d5\3\2\2\2\u00d2\u00d5\7\t\2\2\u00d3\u00d5\7\n\2\2\u00d4"+
		"^\3\2\2\2\u00d4g\3\2\2\2\u00d4p\3\2\2\2\u00d4}\3\2\2\2\u00d4\177\3\2\2"+
		"\2\u00d4\u0081\3\2\2\2\u00d4\u0083\3\2\2\2\u00d4\u0085\3\2\2\2\u00d4\u0089"+
		"\3\2\2\2\u00d4\u00a4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5"+
		"\t\3\2\2\2\u00d6\u00d7\5\b\5\2\u00d7\13\3\2\2\2\u00d8\u00d9\5\26\f\2\u00d9"+
		"\u00e0\7\61\2\2\u00da\u00db\7\60\2\2\u00db\u00dc\5\26\f\2\u00dc\u00dd"+
		"\7\61\2\2\u00dd\u00df\3\2\2\2\u00de\u00da\3\2\2\2\u00df\u00e2\3\2\2\2"+
		"\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\r\3\2\2\2\u00e2\u00e0\3"+
		"\2\2\2\u00e3\u00e4\7.\2\2\u00e4\u00e5\5\24\13\2\u00e5\u00e6\7/\2\2\u00e6"+
		"\17\3\2\2\2\u00e7\u00e8\7.\2\2\u00e8\u00e9\7)\2\2\u00e9\u00ea\7/\2\2\u00ea"+
		"\21\3\2\2\2\u00eb\u00ec\t\2\2\2\u00ec\23\3\2\2\2\u00ed\u00ee\b\13\1\2"+
		"\u00ee\u00ef\t\3\2\2\u00ef\u010d\5\24\13\17\u00f0\u00f1\7,\2\2\u00f1\u00f2"+
		"\5\24\13\2\u00f2\u00f3\7-\2\2\u00f3\u010d\3\2\2\2\u00f4\u00f6\7\61\2\2"+
		"\u00f5\u00f7\5\16\b\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u010d\3\2\2\2\u00fa\u010d\7\61\2\2"+
		"\u00fb\u00fc\7\61\2\2\u00fc\u0105\7,\2\2\u00fd\u0102\5\24\13\2\u00fe\u00ff"+
		"\7\60\2\2\u00ff\u0101\5\24\13\2\u0100\u00fe\3\2\2\2\u0101\u0104\3\2\2"+
		"\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102"+
		"\3\2\2\2\u0105\u00fd\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u010d\7-\2\2\u0108\u010d\7)\2\2\u0109\u010d\7*\2\2\u010a\u010d\7\'\2"+
		"\2\u010b\u010d\7(\2\2\u010c\u00ed\3\2\2\2\u010c\u00f0\3\2\2\2\u010c\u00f4"+
		"\3\2\2\2\u010c\u00fa\3\2\2\2\u010c\u00fb\3\2\2\2\u010c\u0108\3\2\2\2\u010c"+
		"\u0109\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010d\u011c\3\2"+
		"\2\2\u010e\u010f\f\16\2\2\u010f\u0110\t\4\2\2\u0110\u011b\5\24\13\17\u0111"+
		"\u0112\f\r\2\2\u0112\u0113\t\5\2\2\u0113\u011b\5\24\13\16\u0114\u0115"+
		"\f\f\2\2\u0115\u0116\t\6\2\2\u0116\u011b\5\24\13\r\u0117\u0118\f\13\2"+
		"\2\u0118\u0119\t\7\2\2\u0119\u011b\5\24\13\f\u011a\u010e\3\2\2\2\u011a"+
		"\u0111\3\2\2\2\u011a\u0114\3\2\2\2\u011a\u0117\3\2\2\2\u011b\u011e\3\2"+
		"\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\25\3\2\2\2\u011e\u011c"+
		"\3\2\2\2\u011f\u0124\7\24\2\2\u0120\u0121\7.\2\2\u0121\u0123\7/\2\2\u0122"+
		"\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125\u0138\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u012c\7\25\2\2\u0128"+
		"\u0129\7.\2\2\u0129\u012b\7/\2\2\u012a\u0128\3\2\2\2\u012b\u012e\3\2\2"+
		"\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u0138\3\2\2\2\u012e\u012c"+
		"\3\2\2\2\u012f\u0134\7\26\2\2\u0130\u0131\7.\2\2\u0131\u0133\7/\2\2\u0132"+
		"\u0130\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2"+
		"\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u011f\3\2\2\2\u0137"+
		"\u0127\3\2\2\2\u0137\u012f\3\2\2\2\u0138\27\3\2\2\2\u0139\u013a\t\b\2"+
		"\2\u013a\31\3\2\2\2\u013b\u013c\t\t\2\2\u013c\33\3\2\2\2)!(-\63;AGKV\\"+
		"dkwz\u0087\u0090\u0096\u009a\u009f\u00ab\u00b1\u00b5\u00bb\u00c1\u00c5"+
		"\u00c8\u00cd\u00d4\u00e0\u00f8\u0102\u0105\u010c\u011a\u011c\u0124\u012c"+
		"\u0134\u0137";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}