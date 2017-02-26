

public class TokenNode extends ParseTree {
	private Token token;
	
	public TokenNode(Token token) {
		this.token = token;
	}
	
	public Token getToken() {
		return token;
	}

	@Override
	public String toString() {
		return token.toString();
	}
}
