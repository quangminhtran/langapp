public class ListParser extends Parser {

	public ListParser(Lexer lexer) {
		super(lexer);
	}
	
	@Override
	public Token match(int type) {
		return super.match(type);
	}

	/** '[' elements ']' */
	public void list() {
		// Construct parse tree
		match(ListLexer.LBRACK);
		elements();
		match(ListLexer.RBRACK);
	}

	/** element (',' element)* */
	private void elements() {
		element();
		while (lookahead.type == ListLexer.COMMA) {
			match(ListLexer.COMMA);
			element();
		}
	}
	
	/** element: NAME | list */
	private void element() {
		if (lookahead.type == ListLexer.NAME) {
			match(ListLexer.NAME);
		} else if (lookahead.type == ListLexer.LBRACK) {
			list();
		} else throw new Error("Expect either name or list " + " but  got " + lookahead);
	}	
	
}
