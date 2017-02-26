

public abstract class Lexer {
	public static final char EOF = (char)-1;	//represent end of file char
	public static final int EOF_TYPE = 1;		//represent EOF token type
	protected String input;		// input string
	protected int p = 0;		// index into input of current character
	protected char c;			// current character
	
	public Lexer(String input) {
		this.input = input;
		c = input.charAt(p);
	}
	/**
	 * Concrete lexer needs to implement this method to return the current token.
	 */
	public abstract Token nextToken();
	
	/**
	 * Return the string representation of the given token type.
	 */
	public abstract String getTokenName(int tokenType);
}
