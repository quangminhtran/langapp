
public class Test {

	public static void main(String[] args) {
		ListLexer lexer = new ListLexer(args[0]);
		ListParser parser = new ListParser(lexer);
		parser.list();	// Start parsing a list
		ParseTree root = parser.getRootParseTree();
		System.out.println("Parse tree: " + root.toStringRep());
	}

}
