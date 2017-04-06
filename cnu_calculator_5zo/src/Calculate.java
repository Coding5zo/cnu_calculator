public class Calculate {
	private ArrayList<Character> _oStack;
	private ArrayList<Double> _vStack;
	private char[] _infix;
	private String[] _postfix;

	public Calculate() {
		this._infix = new char[100];
		this._postfix = new String[100];
		for (int i = 0; i < 100; i++) {
			this._postfix[i] = null;
		}
		this._oStack = new ArrayList<Character>();
		this._vStack = new ArrayList<Double>();
	}
	public void setInfix(String anInfix) {
		
	}

	public String infix() {
		
	}

	public String postfix() {
		
	}

	public boolean infixToPostfix() {
		
	}

	public double evalPostfix() {
		
	}

	


	private boolean isdigit(char aToken) {
		

	}
	private boolean isdigit(String aToken) {
		
	}
	private int inComingPrecedence(char aToken) {
		
	}

	private int inStackPrecedence(char aToken) {

	}
}
