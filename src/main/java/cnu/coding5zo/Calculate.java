package cnu.coding5zo;

public class Calculate {
	private ArrayList<Character> oStack;
	private ArrayList<Double> vStack;
	private char[] infix;
	private String[] postfix;

	public Calculate() {
		this.infix = new char[100];
		this.postfix = new String[100];
		for (int i = 0; i < 100; i++) {
			this.postfix[i] = null;
		}
		this.oStack = new ArrayList<Character>();
		this.vStack = new ArrayList<Double>();
	}

	public void setInfix(String anInfix) {
		this.infix = anInfix.toCharArray();
	}

	public String infix() {
		return String.valueOf(this.infix);
	}

	public String postfix() {
		return String.valueOf(this.postfix);
	}

	public boolean infixToPostfix() {
		int i;
		int p;
		char curToken, poppedToken, topToken;
		char tempToken = '\0';
		this.oStack = new ArrayList<Character>(this.infix.length);
		this.postfix = new String[this.infix.length];
		i = 0;
		p = 0;

		while (i < this.infix.length) {
			curToken = this.infix[i++];
			if (isdigit(curToken)) {
				if (isdigit(tempToken)) {
					this.postfix[p - 1] = this.postfix[p - 1] + curToken;
				} else {
					this.postfix[p++] = String.valueOf(curToken);
				}
				tempToken = curToken;
			} else {
				if (curToken == ')') {
					if (!this.oStack.isEmpty()) {
						poppedToken = (char) this.oStack.pop();
					} else
						return false;

					while (poppedToken != '(') {
						this.postfix[p++] = String.valueOf(poppedToken);
						if (!this.oStack.isEmpty()) {
							poppedToken = (char) this.oStack.pop();
						} else
							return false;
					}
					tempToken = '\0';
				} else {
					int inComingP = Precedence(curToken, 'c');
					if (!this.oStack.isEmpty()) {
						topToken = (char) oStack.peek();
						while (Precedence(topToken, 's') >= inComingP) {
							poppedToken = (char) this.oStack.pop();
							this.postfix[p++] = String.valueOf(poppedToken);
							if (!this.oStack.isEmpty())
								topToken = (char) this.oStack.peek();
							else
								break;
						}
					}
					this.oStack.push(curToken);
					tempToken = '\0';
				}
			}
		}
		while (!this.oStack.isEmpty()) {
			this.postfix[p++] = String.valueOf(this.oStack.pop());
		}
		return true;
	}

	public double evalPostfix() {
		int p;
		String curToken;
		this.vStack = new ArrayList<Double>(this.infix.length);

		p = 0;

		while (p < this.postfix.length && this.postfix[p] != null) {
			curToken = this.postfix[p++];
			if (isdigit(curToken)) {
				this.vStack.push(Double.parseDouble(String.valueOf(curToken)));
			} else {
				double operand1, operand2, result;

				switch (curToken) {
				case "+":
					operand2 = this.vStack.pop();
					operand1 = this.vStack.pop();
					result = operand1 + operand2;
					break;
				case "-":
					operand2 = this.vStack.pop();
					operand1 = this.vStack.pop();
					result = operand1 - operand2;
					break;
				case "*":
					operand2 = this.vStack.pop();
					operand1 = this.vStack.pop();
					result = operand1 * operand2;
					break;
				case "/":
					operand2 = this.vStack.pop();
					operand1 = this.vStack.pop();
					result = operand1 / operand2;
					break;
				default:
					result = -1;
					break;
				}
				this.vStack.push(result);
			}
		}
		return this.vStack.pop();
	}

	private boolean isdigit(char aToken) {
		if (aToken >= '0' && aToken <= '9') {
			return true;
		} else {
			return false;
		}
	}

	private boolean isdigit(String aToken) {
		if (aToken.length() == 1 && "()+-*/".indexOf(aToken) >= 0)
			return false;
		else
			return true;

	}

	private int Precedence(char aToken, char CorS) {
		if (aToken == '+')
			return 12;
		else if (aToken == '-')
			return 12;
		else if (aToken == '(')
			if(CorS == 'c')
				return 20;
			if(CorS == 's')
				return 0;
		else if (aToken == ')') {
			return 19;
		} else if (aToken == '*')
			return 13;
		else if (aToken == '/')
			return 13;
		else
			return -1;
	}
}
