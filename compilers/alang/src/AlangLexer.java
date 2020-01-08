// Generated from Alang.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlangLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BUD", "FUNKCIA", "HOTOVO", "VYPLUJ", "MAKAJ", "JAKAM", "STACI", "PRESKOC", 
			"IF", "ELSE", "FI", "VYPISZNAKY", "CISLO", "ZNAK", "BOOL", "VOID", "EQ", 
			"LT", "GT", "LEQ", "GEQ", "NEQ", "NOT", "AND", "OR", "ADD", "SUB", "DIV", 
			"MOD", "MUL", "ASSIGN", "TRUE", "FALSE", "INT", "DIGIT", "LETTER", "UNDERSCORE", 
			"STRING", "NEWLINE", "LPAR", "RPAR", "LSQUARE", "RSQUARE", "COMMA", "ID", 
			"LINE_COMMENT", "WHITESPACE"
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


	public AlangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Alang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u012e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\6#\u00f4\n#\r#\16#\u00f5\3"+
		"$\3$\3%\3%\3&\3&\3\'\3\'\7\'\u0100\n\'\f\'\16\'\u0103\13\'\3\'\3\'\3("+
		"\3(\3(\5(\u010a\n(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\5.\u0118\n.\3."+
		"\3.\3.\7.\u011d\n.\f.\16.\u0120\13.\3/\3/\7/\u0124\n/\f/\16/\u0127\13"+
		"/\3/\3/\3\60\3\60\3\60\3\60\2\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G\2I\2K\2M%O&Q\'S(U)W*"+
		"Y+[,]-_.\3\2\7\3\2\62;\4\2C\\c|\5\2\f\f\17\17$$\4\2\f\f\17\17\4\2\13\13"+
		"\"\"\2\u0132\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5e\3\2\2\2\7m\3"+
		"\2\2\2\tt\3\2\2\2\13{\3\2\2\2\r\u0081\3\2\2\2\17\u0087\3\2\2\2\21\u008d"+
		"\3\2\2\2\23\u0095\3\2\2\2\25\u0098\3\2\2\2\27\u009d\3\2\2\2\31\u00a0\3"+
		"\2\2\2\33\u00ab\3\2\2\2\35\u00b1\3\2\2\2\37\u00b6\3\2\2\2!\u00bb\3\2\2"+
		"\2#\u00c0\3\2\2\2%\u00c3\3\2\2\2\'\u00c5\3\2\2\2)\u00c7\3\2\2\2+\u00ca"+
		"\3\2\2\2-\u00cd\3\2\2\2/\u00d0\3\2\2\2\61\u00d4\3\2\2\2\63\u00d8\3\2\2"+
		"\2\65\u00db\3\2\2\2\67\u00dd\3\2\2\29\u00df\3\2\2\2;\u00e1\3\2\2\2=\u00e3"+
		"\3\2\2\2?\u00e5\3\2\2\2A\u00e7\3\2\2\2C\u00ec\3\2\2\2E\u00f3\3\2\2\2G"+
		"\u00f7\3\2\2\2I\u00f9\3\2\2\2K\u00fb\3\2\2\2M\u00fd\3\2\2\2O\u0109\3\2"+
		"\2\2Q\u010b\3\2\2\2S\u010d\3\2\2\2U\u010f\3\2\2\2W\u0111\3\2\2\2Y\u0113"+
		"\3\2\2\2[\u0117\3\2\2\2]\u0121\3\2\2\2_\u012a\3\2\2\2ab\7D\2\2bc\7W\2"+
		"\2cd\7F\2\2d\4\3\2\2\2ef\7H\2\2fg\7W\2\2gh\7P\2\2hi\7M\2\2ij\7E\2\2jk"+
		"\7K\2\2kl\7C\2\2l\6\3\2\2\2mn\7J\2\2no\7Q\2\2op\7V\2\2pq\7Q\2\2qr\7X\2"+
		"\2rs\7Q\2\2s\b\3\2\2\2tu\7X\2\2uv\7[\2\2vw\7R\2\2wx\7N\2\2xy\7W\2\2yz"+
		"\7L\2\2z\n\3\2\2\2{|\7O\2\2|}\7C\2\2}~\7M\2\2~\177\7C\2\2\177\u0080\7"+
		"L\2\2\u0080\f\3\2\2\2\u0081\u0082\7L\2\2\u0082\u0083\7C\2\2\u0083\u0084"+
		"\7M\2\2\u0084\u0085\7C\2\2\u0085\u0086\7O\2\2\u0086\16\3\2\2\2\u0087\u0088"+
		"\7U\2\2\u0088\u0089\7V\2\2\u0089\u008a\7C\2\2\u008a\u008b\7E\2\2\u008b"+
		"\u008c\7K\2\2\u008c\20\3\2\2\2\u008d\u008e\7R\2\2\u008e\u008f\7T\2\2\u008f"+
		"\u0090\7G\2\2\u0090\u0091\7U\2\2\u0091\u0092\7M\2\2\u0092\u0093\7Q\2\2"+
		"\u0093\u0094\7E\2\2\u0094\22\3\2\2\2\u0095\u0096\7K\2\2\u0096\u0097\7"+
		"H\2\2\u0097\24\3\2\2\2\u0098\u0099\7G\2\2\u0099\u009a\7N\2\2\u009a\u009b"+
		"\7U\2\2\u009b\u009c\7G\2\2\u009c\26\3\2\2\2\u009d\u009e\7H\2\2\u009e\u009f"+
		"\7K\2\2\u009f\30\3\2\2\2\u00a0\u00a1\7X\2\2\u00a1\u00a2\7[\2\2\u00a2\u00a3"+
		"\7R\2\2\u00a3\u00a4\7K\2\2\u00a4\u00a5\7U\2\2\u00a5\u00a6\7\\\2\2\u00a6"+
		"\u00a7\7P\2\2\u00a7\u00a8\7C\2\2\u00a8\u00a9\7M\2\2\u00a9\u00aa\7[\2\2"+
		"\u00aa\32\3\2\2\2\u00ab\u00ac\7E\2\2\u00ac\u00ad\7K\2\2\u00ad\u00ae\7"+
		"U\2\2\u00ae\u00af\7N\2\2\u00af\u00b0\7Q\2\2\u00b0\34\3\2\2\2\u00b1\u00b2"+
		"\7\\\2\2\u00b2\u00b3\7P\2\2\u00b3\u00b4\7C\2\2\u00b4\u00b5\7M\2\2\u00b5"+
		"\36\3\2\2\2\u00b6\u00b7\7D\2\2\u00b7\u00b8\7Q\2\2\u00b8\u00b9\7Q\2\2\u00b9"+
		"\u00ba\7N\2\2\u00ba \3\2\2\2\u00bb\u00bc\7X\2\2\u00bc\u00bd\7Q\2\2\u00bd"+
		"\u00be\7K\2\2\u00be\u00bf\7F\2\2\u00bf\"\3\2\2\2\u00c0\u00c1\7?\2\2\u00c1"+
		"\u00c2\7?\2\2\u00c2$\3\2\2\2\u00c3\u00c4\7>\2\2\u00c4&\3\2\2\2\u00c5\u00c6"+
		"\7@\2\2\u00c6(\3\2\2\2\u00c7\u00c8\7>\2\2\u00c8\u00c9\7?\2\2\u00c9*\3"+
		"\2\2\2\u00ca\u00cb\7@\2\2\u00cb\u00cc\7?\2\2\u00cc,\3\2\2\2\u00cd\u00ce"+
		"\7#\2\2\u00ce\u00cf\7?\2\2\u00cf.\3\2\2\2\u00d0\u00d1\7P\2\2\u00d1\u00d2"+
		"\7Q\2\2\u00d2\u00d3\7V\2\2\u00d3\60\3\2\2\2\u00d4\u00d5\7C\2\2\u00d5\u00d6"+
		"\7P\2\2\u00d6\u00d7\7F\2\2\u00d7\62\3\2\2\2\u00d8\u00d9\7Q\2\2\u00d9\u00da"+
		"\7T\2\2\u00da\64\3\2\2\2\u00db\u00dc\7-\2\2\u00dc\66\3\2\2\2\u00dd\u00de"+
		"\7/\2\2\u00de8\3\2\2\2\u00df\u00e0\7\61\2\2\u00e0:\3\2\2\2\u00e1\u00e2"+
		"\7\'\2\2\u00e2<\3\2\2\2\u00e3\u00e4\7,\2\2\u00e4>\3\2\2\2\u00e5\u00e6"+
		"\7?\2\2\u00e6@\3\2\2\2\u00e7\u00e8\7V\2\2\u00e8\u00e9\7T\2\2\u00e9\u00ea"+
		"\7W\2\2\u00ea\u00eb\7G\2\2\u00ebB\3\2\2\2\u00ec\u00ed\7H\2\2\u00ed\u00ee"+
		"\7C\2\2\u00ee\u00ef\7N\2\2\u00ef\u00f0\7U\2\2\u00f0\u00f1\7G\2\2\u00f1"+
		"D\3\2\2\2\u00f2\u00f4\5G$\2\u00f3\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6F\3\2\2\2\u00f7\u00f8\t\2\2\2"+
		"\u00f8H\3\2\2\2\u00f9\u00fa\t\3\2\2\u00faJ\3\2\2\2\u00fb\u00fc\7a\2\2"+
		"\u00fcL\3\2\2\2\u00fd\u0101\7$\2\2\u00fe\u0100\n\4\2\2\u00ff\u00fe\3\2"+
		"\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7$\2\2\u0105N\3\2\2\2\u0106"+
		"\u0107\7\17\2\2\u0107\u010a\7\f\2\2\u0108\u010a\t\5\2\2\u0109\u0106\3"+
		"\2\2\2\u0109\u0108\3\2\2\2\u010aP\3\2\2\2\u010b\u010c\7*\2\2\u010cR\3"+
		"\2\2\2\u010d\u010e\7+\2\2\u010eT\3\2\2\2\u010f\u0110\7]\2\2\u0110V\3\2"+
		"\2\2\u0111\u0112\7_\2\2\u0112X\3\2\2\2\u0113\u0114\7.\2\2\u0114Z\3\2\2"+
		"\2\u0115\u0118\5I%\2\u0116\u0118\5K&\2\u0117\u0115\3\2\2\2\u0117\u0116"+
		"\3\2\2\2\u0118\u011e\3\2\2\2\u0119\u011d\5I%\2\u011a\u011d\5G$\2\u011b"+
		"\u011d\5K&\2\u011c\u0119\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011b\3\2\2"+
		"\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\\"+
		"\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0125\7%\2\2\u0122\u0124\n\5\2\2\u0123"+
		"\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129\b/\2\2\u0129"+
		"^\3\2\2\2\u012a\u012b\t\6\2\2\u012b\u012c\3\2\2\2\u012c\u012d\b\60\2\2"+
		"\u012d`\3\2\2\2\n\2\u00f5\u0101\u0109\u0117\u011c\u011e\u0125\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}