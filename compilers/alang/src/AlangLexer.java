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
		IF=9, ELSE=10, FI=11, CITAJCISLO=12, CITAJRIADOK=13, VYPISCISLO=14, VYPISCISLOLN=15, 
		VYPISZNAKY=16, VYPISZNAKYLN=17, CISLO=18, ZNAK=19, BOOL=20, VOID=21, EQ=22, 
		LT=23, GT=24, LEQ=25, GEQ=26, NEQ=27, NOT=28, AND=29, OR=30, ADD=31, SUB=32, 
		DIV=33, MOD=34, MUL=35, ASSIGN=36, TRUE=37, FALSE=38, INT=39, STRING=40, 
		NEWLINE=41, LPAR=42, RPAR=43, LSQUARE=44, RSQUARE=45, COMMA=46, ID=47, 
		LINE_COMMENT=48, WHITESPACE=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BUD", "FUNKCIA", "HOTOVO", "VYPLUJ", "MAKAJ", "JAKAM", "STACI", "PRESKOC", 
			"IF", "ELSE", "FI", "CITAJCISLO", "CITAJRIADOK", "VYPISCISLO", "VYPISCISLOLN", 
			"VYPISZNAKY", "VYPISZNAKYLN", "CISLO", "ZNAK", "BOOL", "VOID", "EQ", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u0174\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3\'\3(\6(\u013a\n(\r(\16(\u013b\3)\3)\3*\3*\3+\3"+
		"+\3,\3,\7,\u0146\n,\f,\16,\u0149\13,\3,\3,\3-\3-\3-\5-\u0150\n-\3.\3."+
		"\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\5\63\u015e\n\63\3\63\3"+
		"\63\3\63\7\63\u0163\n\63\f\63\16\63\u0166\13\63\3\64\3\64\7\64\u016a\n"+
		"\64\f\64\16\64\u016d\13\64\3\64\3\64\3\65\3\65\3\65\3\65\2\2\66\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q\2S\2U\2W*Y+[,]-_.a/c\60e\61g\62i\63\3\2\7\3\2\62;"+
		"\4\2C\\c|\5\2\f\f\17\17$$\4\2\f\f\17\17\4\2\13\13\"\"\2\u0178\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\3k\3\2\2\2\5o\3\2\2\2\7w\3\2\2\2\t~\3\2\2\2\13\u0085\3\2\2\2"+
		"\r\u008b\3\2\2\2\17\u0091\3\2\2\2\21\u0097\3\2\2\2\23\u009f\3\2\2\2\25"+
		"\u00a2\3\2\2\2\27\u00a7\3\2\2\2\31\u00aa\3\2\2\2\33\u00b5\3\2\2\2\35\u00c1"+
		"\3\2\2\2\37\u00cc\3\2\2\2!\u00d9\3\2\2\2#\u00e4\3\2\2\2%\u00f1\3\2\2\2"+
		"\'\u00f7\3\2\2\2)\u00fc\3\2\2\2+\u0101\3\2\2\2-\u0106\3\2\2\2/\u0109\3"+
		"\2\2\2\61\u010b\3\2\2\2\63\u010d\3\2\2\2\65\u0110\3\2\2\2\67\u0113\3\2"+
		"\2\29\u0116\3\2\2\2;\u011a\3\2\2\2=\u011e\3\2\2\2?\u0121\3\2\2\2A\u0123"+
		"\3\2\2\2C\u0125\3\2\2\2E\u0127\3\2\2\2G\u0129\3\2\2\2I\u012b\3\2\2\2K"+
		"\u012d\3\2\2\2M\u0132\3\2\2\2O\u0139\3\2\2\2Q\u013d\3\2\2\2S\u013f\3\2"+
		"\2\2U\u0141\3\2\2\2W\u0143\3\2\2\2Y\u014f\3\2\2\2[\u0151\3\2\2\2]\u0153"+
		"\3\2\2\2_\u0155\3\2\2\2a\u0157\3\2\2\2c\u0159\3\2\2\2e\u015d\3\2\2\2g"+
		"\u0167\3\2\2\2i\u0170\3\2\2\2kl\7D\2\2lm\7W\2\2mn\7F\2\2n\4\3\2\2\2op"+
		"\7H\2\2pq\7W\2\2qr\7P\2\2rs\7M\2\2st\7E\2\2tu\7K\2\2uv\7C\2\2v\6\3\2\2"+
		"\2wx\7J\2\2xy\7Q\2\2yz\7V\2\2z{\7Q\2\2{|\7X\2\2|}\7Q\2\2}\b\3\2\2\2~\177"+
		"\7X\2\2\177\u0080\7[\2\2\u0080\u0081\7R\2\2\u0081\u0082\7N\2\2\u0082\u0083"+
		"\7W\2\2\u0083\u0084\7L\2\2\u0084\n\3\2\2\2\u0085\u0086\7O\2\2\u0086\u0087"+
		"\7C\2\2\u0087\u0088\7M\2\2\u0088\u0089\7C\2\2\u0089\u008a\7L\2\2\u008a"+
		"\f\3\2\2\2\u008b\u008c\7L\2\2\u008c\u008d\7C\2\2\u008d\u008e\7M\2\2\u008e"+
		"\u008f\7C\2\2\u008f\u0090\7O\2\2\u0090\16\3\2\2\2\u0091\u0092\7U\2\2\u0092"+
		"\u0093\7V\2\2\u0093\u0094\7C\2\2\u0094\u0095\7E\2\2\u0095\u0096\7K\2\2"+
		"\u0096\20\3\2\2\2\u0097\u0098\7R\2\2\u0098\u0099\7T\2\2\u0099\u009a\7"+
		"G\2\2\u009a\u009b\7U\2\2\u009b\u009c\7M\2\2\u009c\u009d\7Q\2\2\u009d\u009e"+
		"\7E\2\2\u009e\22\3\2\2\2\u009f\u00a0\7K\2\2\u00a0\u00a1\7H\2\2\u00a1\24"+
		"\3\2\2\2\u00a2\u00a3\7G\2\2\u00a3\u00a4\7N\2\2\u00a4\u00a5\7U\2\2\u00a5"+
		"\u00a6\7G\2\2\u00a6\26\3\2\2\2\u00a7\u00a8\7H\2\2\u00a8\u00a9\7K\2\2\u00a9"+
		"\30\3\2\2\2\u00aa\u00ab\7E\2\2\u00ab\u00ac\7K\2\2\u00ac\u00ad\7V\2\2\u00ad"+
		"\u00ae\7C\2\2\u00ae\u00af\7L\2\2\u00af\u00b0\7E\2\2\u00b0\u00b1\7K\2\2"+
		"\u00b1\u00b2\7U\2\2\u00b2\u00b3\7N\2\2\u00b3\u00b4\7Q\2\2\u00b4\32\3\2"+
		"\2\2\u00b5\u00b6\7E\2\2\u00b6\u00b7\7K\2\2\u00b7\u00b8\7V\2\2\u00b8\u00b9"+
		"\7C\2\2\u00b9\u00ba\7L\2\2\u00ba\u00bb\7T\2\2\u00bb\u00bc\7K\2\2\u00bc"+
		"\u00bd\7C\2\2\u00bd\u00be\7F\2\2\u00be\u00bf\7Q\2\2\u00bf\u00c0\7M\2\2"+
		"\u00c0\34\3\2\2\2\u00c1\u00c2\7X\2\2\u00c2\u00c3\7[\2\2\u00c3\u00c4\7"+
		"R\2\2\u00c4\u00c5\7K\2\2\u00c5\u00c6\7U\2\2\u00c6\u00c7\7E\2\2\u00c7\u00c8"+
		"\7K\2\2\u00c8\u00c9\7U\2\2\u00c9\u00ca\7N\2\2\u00ca\u00cb\7Q\2\2\u00cb"+
		"\36\3\2\2\2\u00cc\u00cd\7X\2\2\u00cd\u00ce\7[\2\2\u00ce\u00cf\7R\2\2\u00cf"+
		"\u00d0\7K\2\2\u00d0\u00d1\7U\2\2\u00d1\u00d2\7E\2\2\u00d2\u00d3\7K\2\2"+
		"\u00d3\u00d4\7U\2\2\u00d4\u00d5\7N\2\2\u00d5\u00d6\7Q\2\2\u00d6\u00d7"+
		"\7N\2\2\u00d7\u00d8\7P\2\2\u00d8 \3\2\2\2\u00d9\u00da\7X\2\2\u00da\u00db"+
		"\7[\2\2\u00db\u00dc\7R\2\2\u00dc\u00dd\7K\2\2\u00dd\u00de\7U\2\2\u00de"+
		"\u00df\7\\\2\2\u00df\u00e0\7P\2\2\u00e0\u00e1\7C\2\2\u00e1\u00e2\7M\2"+
		"\2\u00e2\u00e3\7[\2\2\u00e3\"\3\2\2\2\u00e4\u00e5\7X\2\2\u00e5\u00e6\7"+
		"[\2\2\u00e6\u00e7\7R\2\2\u00e7\u00e8\7K\2\2\u00e8\u00e9\7U\2\2\u00e9\u00ea"+
		"\7\\\2\2\u00ea\u00eb\7P\2\2\u00eb\u00ec\7C\2\2\u00ec\u00ed\7M\2\2\u00ed"+
		"\u00ee\7[\2\2\u00ee\u00ef\7N\2\2\u00ef\u00f0\7P\2\2\u00f0$\3\2\2\2\u00f1"+
		"\u00f2\7E\2\2\u00f2\u00f3\7K\2\2\u00f3\u00f4\7U\2\2\u00f4\u00f5\7N\2\2"+
		"\u00f5\u00f6\7Q\2\2\u00f6&\3\2\2\2\u00f7\u00f8\7\\\2\2\u00f8\u00f9\7P"+
		"\2\2\u00f9\u00fa\7C\2\2\u00fa\u00fb\7M\2\2\u00fb(\3\2\2\2\u00fc\u00fd"+
		"\7D\2\2\u00fd\u00fe\7Q\2\2\u00fe\u00ff\7Q\2\2\u00ff\u0100\7N\2\2\u0100"+
		"*\3\2\2\2\u0101\u0102\7X\2\2\u0102\u0103\7Q\2\2\u0103\u0104\7K\2\2\u0104"+
		"\u0105\7F\2\2\u0105,\3\2\2\2\u0106\u0107\7?\2\2\u0107\u0108\7?\2\2\u0108"+
		".\3\2\2\2\u0109\u010a\7>\2\2\u010a\60\3\2\2\2\u010b\u010c\7@\2\2\u010c"+
		"\62\3\2\2\2\u010d\u010e\7>\2\2\u010e\u010f\7?\2\2\u010f\64\3\2\2\2\u0110"+
		"\u0111\7@\2\2\u0111\u0112\7?\2\2\u0112\66\3\2\2\2\u0113\u0114\7#\2\2\u0114"+
		"\u0115\7?\2\2\u01158\3\2\2\2\u0116\u0117\7P\2\2\u0117\u0118\7Q\2\2\u0118"+
		"\u0119\7V\2\2\u0119:\3\2\2\2\u011a\u011b\7C\2\2\u011b\u011c\7P\2\2\u011c"+
		"\u011d\7F\2\2\u011d<\3\2\2\2\u011e\u011f\7Q\2\2\u011f\u0120\7T\2\2\u0120"+
		">\3\2\2\2\u0121\u0122\7-\2\2\u0122@\3\2\2\2\u0123\u0124\7/\2\2\u0124B"+
		"\3\2\2\2\u0125\u0126\7\61\2\2\u0126D\3\2\2\2\u0127\u0128\7\'\2\2\u0128"+
		"F\3\2\2\2\u0129\u012a\7,\2\2\u012aH\3\2\2\2\u012b\u012c\7?\2\2\u012cJ"+
		"\3\2\2\2\u012d\u012e\7V\2\2\u012e\u012f\7T\2\2\u012f\u0130\7W\2\2\u0130"+
		"\u0131\7G\2\2\u0131L\3\2\2\2\u0132\u0133\7H\2\2\u0133\u0134\7C\2\2\u0134"+
		"\u0135\7N\2\2\u0135\u0136\7U\2\2\u0136\u0137\7G\2\2\u0137N\3\2\2\2\u0138"+
		"\u013a\5Q)\2\u0139\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0139\3\2\2"+
		"\2\u013b\u013c\3\2\2\2\u013cP\3\2\2\2\u013d\u013e\t\2\2\2\u013eR\3\2\2"+
		"\2\u013f\u0140\t\3\2\2\u0140T\3\2\2\2\u0141\u0142\7a\2\2\u0142V\3\2\2"+
		"\2\u0143\u0147\7$\2\2\u0144\u0146\n\4\2\2\u0145\u0144\3\2\2\2\u0146\u0149"+
		"\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149"+
		"\u0147\3\2\2\2\u014a\u014b\7$\2\2\u014bX\3\2\2\2\u014c\u014d\7\17\2\2"+
		"\u014d\u0150\7\f\2\2\u014e\u0150\t\5\2\2\u014f\u014c\3\2\2\2\u014f\u014e"+
		"\3\2\2\2\u0150Z\3\2\2\2\u0151\u0152\7*\2\2\u0152\\\3\2\2\2\u0153\u0154"+
		"\7+\2\2\u0154^\3\2\2\2\u0155\u0156\7]\2\2\u0156`\3\2\2\2\u0157\u0158\7"+
		"_\2\2\u0158b\3\2\2\2\u0159\u015a\7.\2\2\u015ad\3\2\2\2\u015b\u015e\5S"+
		"*\2\u015c\u015e\5U+\2\u015d\u015b\3\2\2\2\u015d\u015c\3\2\2\2\u015e\u0164"+
		"\3\2\2\2\u015f\u0163\5S*\2\u0160\u0163\5Q)\2\u0161\u0163\5U+\2\u0162\u015f"+
		"\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0163\u0166\3\2\2\2\u0164"+
		"\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165f\3\2\2\2\u0166\u0164\3\2\2\2"+
		"\u0167\u016b\7%\2\2\u0168\u016a\n\5\2\2\u0169\u0168\3\2\2\2\u016a\u016d"+
		"\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016e\3\2\2\2\u016d"+
		"\u016b\3\2\2\2\u016e\u016f\b\64\2\2\u016fh\3\2\2\2\u0170\u0171\t\6\2\2"+
		"\u0171\u0172\3\2\2\2\u0172\u0173\b\65\2\2\u0173j\3\2\2\2\n\2\u013b\u0147"+
		"\u014f\u015d\u0162\u0164\u016b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}