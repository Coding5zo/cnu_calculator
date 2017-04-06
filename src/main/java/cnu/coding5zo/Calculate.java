package cnu.coding5zo;
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
		int p;
		String curToken;
		this._vStack = new ArrayList<Double>(this._infix.length);

		p = 0;

		while (p < this._postfix.length && this._postfix[p] !=null) {
			curToken = this._postfix[p++];
			if (isdigit(curToken)) {
				this._vStack.push(Double.parseDouble(String.valueOf(curToken)));
			} else {
				double operand1, operand2, result;

				switch (curToken) {
				case "+":
					operand2 = this._vStack.pop();
					operand1 = this._vStack.pop();
					result = operand1 + operand2;
					break;
				case "-":
					operand2 = this._vStack.pop();
					operand1 = this._vStack.pop();
					result = operand1 - operand2;
					break;
				case "*":
					operand2 = this._vStack.pop();
					operand1 = this._vStack.pop();
					result = operand1 * operand2;
					break;
				case "/":
					operand2 = this._vStack.pop();
					operand1 = this._vStack.pop();
					result = operand1 / operand2;
					break;
				default:
					result = -1;
					break;
				}
				this._vStack.push(result);
			}	
		}
		return this._vStack.pop();
	}

	


	private boolean isdigit(char aToken) {
		if (aToken >= '0' && aToken <= '9') {
			return true;
		} else {
			return false;
		}
	}
	private boolean isdigit(String aToken) {
		if(aToken.length() ==1 && "()+-*/".indexOf(aToken)>=0)
			return false;
		else 
			return true;
		
	}
	private int inComingPrecedence(char aToken) {
		if (aToken == '+')
			return 12;
		else if (aToken == '-')
			return 12;
		else if (aToken == '(')
			return 20;
		else if (aToken == ')')
			return 19;
		else if (aToken == '*')
			return 13;
		else if (aToken == '/')
			return 13;
		else
			return -1;
	}

	private int inStackPrecedence(char aToken) {
		if (aToken == '+')
			return 12;
		else if (aToken == '-')
			return 12;
		else if (aToken == '(')
			return 0;
		else if (aToken == ')')
			return 19;
		else if (aToken == '*')
			return 13;
		else if (aToken == '/')
			return 13;
		else
			return -1;
	}
}
