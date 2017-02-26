

public class Token {
	public int type;
	public String text;
	
	public Token(int type, String text) {
		this.type = type;
		this.text = text;
	}
	
	public Token(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	public String getText() {
		return text;
	}
	
	public String toString() {
		String tname = ListLexer.tokenNames[type];
		return "<'" + text + "'," + tname + ">";
	}
}
