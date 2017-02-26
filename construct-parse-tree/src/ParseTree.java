
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;

public abstract class ParseTree {
	protected List<ParseTree> children;	// normalized child list
	
	public RuleNode addChild(String rule) {
		RuleNode ruleNode = new RuleNode(rule);
		addChild(ruleNode);
		return ruleNode;
	}
	
	public TokenNode addChild(Token token) {
		TokenNode tokenNode = new TokenNode(token);
		addChild(tokenNode);
		return tokenNode;
	}
	
	public void addChild(ParseTree t) {
		if (children == null) 
			children = new ArrayList<ParseTree>();
		children.add(t);
	}
	
	public String toStringRep() {
		if (children == null || children.isEmpty()) return toString();
		else {
			Joiner joiner = Joiner.on(",").skipNulls();
			return "(" + toString() + "," + joiner.join(children.stream().map(child -> child.toStringRep()).iterator()) +  ")";
		}
	}
	
}
