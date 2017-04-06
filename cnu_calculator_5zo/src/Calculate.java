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
		this._infix = anInfix.toCharArray();
	}

	public String infix() {
		return String.valueOf(this._infix);
	}

	public String postfix() {
		return String.valueOf(this._postfix);
	}

	public boolean infixToPostfix() {
		int i;
		int p;
		char curToken, poppedToken, topToken;
		char tempToken = '\0';
		this._oStack = new ArrayList<Character>(this._infix.length);
		this._postfix = new String[this._infix.length];
		i = 0;
		p = 0;

		while (i < this._infix.length) {
			curToken = this._infix[i++];
			if (isdigit(curToken)) {
				if(isdigit(tempToken)){
					this._postfix[p - 1] = this._postfix[p - 1] + curToken;
				} else {
					this._postfix[p++] = String.valueOf(curToken);
				}
				tempToken = curToken;
			} else {
				if (curToken == ')') { 
					if (!this._oStack.isEmpty()) {
						poppedToken = (char) this._oStack.pop();
					} else
						return false; 

					while (poppedToken != '(') {
						this._postfix[p++] = String.valueOf(poppedToken);
						if (!this._oStack.isEmpty()) {
							poppedToken = (char) this._oStack.pop();
						} else
							return false; 
					}
					tempToken = '\0';
				} else { 
					int inComingP = inComingPrecedence(curToken);
					if (!this._oStack.isEmpty()) {
						topToken = (char) _oStack.peek();
						while (inStackPrecedence(topToken) >= inComingP) {
							poppedToken = (char) this._oStack.pop();
							this._postfix[p++] = String.valueOf(poppedToken);
							if (!this._oStack.isEmpty())
								topToken = (char) this._oStack.peek();
							else
								break;
						}
					}
					this._oStack.push(curToken);
					tempToken = '\0';
				}
			}
		} 
		while (!this._oStack.isEmpty()) {
			this._postfix[p++] = String.valueOf(this._oStack.pop());
		}
		return true;
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
