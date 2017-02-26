public abstract class Parser {
	protected Lexer lexer;
	protected Token lookahead;
	
	public Parser(Lexer lexer) {
		this.lexer = lexer;
		lookahead = lexer.nextToken();
	}
	
	public Token match(int type) {
		if (lookahead.getType() == type) {
			Token retToken = lookahead;
			consume();
			return retToken;
		}	
		else throw new Error("Expect " + lexer.getTokenName(type) + " but got " + lexer.getTokenName(lookahead.getType()));
	}
	
	public void consume() {
		lookahead = lexer.nextToken();
	}

}
