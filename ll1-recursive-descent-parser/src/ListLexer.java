public class ListLexer extends Lexer {
	public static int NAME = 2;
	public static int COMMA = 3;
	public static int LBRACK = 4;
	public static int RBRACK = 5;
	
	public static String[] tokenNames = 
		{"n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK"};
	
	public String getTokenName(int type) {
		return tokenNames[type];
	}
	
	public ListLexer(String input) {
		super(input);
	}
	
	private boolean isLETTER() {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
	
	private boolean isWS() {
		return (c == ' ') || (c == '\t') || (c == '\n') || (c == '\r');
	}
	
	@Override
	public Token nextToken() {
		while ( c != EOF ) {
			switch ( c ) {
				case ' ': case '\t': case '\n': case '\r': WS(); continue;
				case ',': consume(); return new Token(COMMA, ",");
				case '[': consume(); return new Token(LBRACK, "[");
				case ']': consume(); return new Token(RBRACK, "]");
				default:
					if ( isLETTER() ) return NAME();
					throw new Error("Invalid character: " +c);
			}
		}
		return new Token(EOF_TYPE, "<EOF>");
	}
	/** NAME: ('a'..'z' | 'A'..'Z')+ */
	private Token NAME() {
		StringBuffer buf = new StringBuffer(); 
		
		do {
			buf.append(c);
			consume();
		} while ( isLETTER() );
		
		return new Token(NAME, buf.toString());
	}
	
	/** WS: (' ' | '\t' | '\n' | 'r')* */
	private void WS() {
		while ( isWS() ) {
			consume();
		}
	}

	private void consume() {
		p++;
		if (p >= input.length()) c = EOF; // Detect end of input string
		else c = input.charAt(p);
	}
}
