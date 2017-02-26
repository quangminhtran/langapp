public class ListParser extends Parser {
	protected ParseTree root;
	protected ParseTree currentNode;

	public ListParser(Lexer lexer) {
		super(lexer);
	}
	
	@Override
	public Token match(int type) {
		// Construct parse tree
		TokenNode t = new TokenNode(lookahead);
		currentNode.addChild(t); // Add this token to the current node
		return super.match(type);
	}

	/** '[' elements ']' */
	public void list() {
		// Construct parse tree
		RuleNode r = new RuleNode("list");
		if (root == null) root = r;		// We are at the start rule
		else currentNode.addChild(r);	// Add this rule to the current node
		
		ParseTree save = currentNode;
		currentNode = r;	// "descend" into this rule
		match(ListLexer.LBRACK);
		elements();
		match(ListLexer.RBRACK);
		currentNode = save;	//Restore the current node
	}

	/** element (',' element)* */
	private void elements() {
		// Construct parse tree
		RuleNode r = new RuleNode("elements");
		currentNode.addChild(r);	// Add this rule to the current node
		
		ParseTree save = currentNode;
		currentNode = r;	// "descend" into this rule
		element();
		while (lookahead.type == ListLexer.COMMA) {
			match(ListLexer.COMMA);
			element();
		} 
		currentNode = save;
	}
	
	/** element: NAME | list */
	private void element() {
		// Construct parse tree
		ParseTree r = new RuleNode("element");
		currentNode.addChild(r);	// Add this rule to the current node
		
		ParseTree save = currentNode;
		currentNode = r;	// "descend" into this rule
		
		if (lookahead.type == ListLexer.NAME) {
			match(ListLexer.NAME);
		} else if (lookahead.type == ListLexer.LBRACK) {
			list();
		} else throw new Error("Expect either name or list " + " but  got " + lookahead);
		
		currentNode = save;
	}

	public ParseTree getRootParseTree() {
		return root;
	}
	
}
