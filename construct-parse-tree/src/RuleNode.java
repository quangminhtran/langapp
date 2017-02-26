
public class RuleNode extends ParseTree {
	private String rule;
	
	public RuleNode(String rule) {
		this.rule = rule;
	}
	
	public String getRule() {
		return rule;
	}

	@Override
	public String toString() {
		return rule;
	}	
}
