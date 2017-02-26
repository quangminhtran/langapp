
public class Test {

	public static void main(String[] args) {
		ListLexer lexer = new ListLexer(args[0]);
		Token t = lexer.nextToken();
		while (t.getType() != Lexer.EOF_TYPE) {
			System.out.println(t);
			t = lexer.nextToken();
		}
		System.out.println(t);	// print EOF
	}

}
