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
		this.oStack = new ArrayList<>();
		this.vStack = new ArrayList<>();
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
		char curToken;
		char poppedToken;
		char topToken;
		char tempToken = '\0';
		this.oStack = new ArrayList<>(this.infix.length);
		this.postfix = new String[this.infix.length];
		i = 0;
		p = 0;

		while (i < this.infix.length) {
			curToken = this.infix[i++];
			if (isdigit(curToken) && isdigit(tempToken)) {
				this.postfix[p - 1] = this.postfix[p - 1] + curToken;
				tempToken = curToken;
			} else if (isdigit(curToken) && !isdigit(tempToken)) {
				this.postfix[p++] = String.valueOf(curToken);
				tempToken = curToken;
			} else if (!isdigit(curToken) && curToken == ')' && this.oStack.isEmpty()) {
				return false;
			} else if (!isdigit(curToken) && curToken == ')' && !this.oStack.isEmpty()) {
				poppedToken = (char) this.oStack.pop();
				while (poppedToken != '(') {
					this.postfix[p++] = String.valueOf(poppedToken);
					if (this.oStack.isEmpty()) {
						return false;
					} else
						poppedToken = (char) this.oStack.pop();
				}
				tempToken = '\0';
			} else if (!isdigit(curToken) && curToken != ')' && !this.oStack.isEmpty()) {
				int inComingP = precedence(curToken, 'c');
				topToken = (char) oStack.peek();
				while (precedence(topToken, 's') >= inComingP) {
					poppedToken = (char) this.oStack.pop();
					this.postfix[p++] = String.valueOf(poppedToken);
					if (!this.oStack.isEmpty())
						topToken = (char) this.oStack.peek();
					else
						break;
				}
				this.oStack.push(curToken);
				tempToken = '\0';
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
		this.vStack = new ArrayList<>(this.infix.length);

		p = 0;

		while (p < this.postfix.length && this.postfix[p] != null) {
			curToken = this.postfix[p++];
			if (isdigit(curToken)) {
				this.vStack.push(Double.parseDouble(String.valueOf(curToken)));
			} else {
				double operand1;
				double operand2;
				double result;

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
		return aToken >= '0' && aToken <= '9';
	}

	private boolean isdigit(String aToken) {
		return !(aToken.length() == 1 && "()+-*/".indexOf(aToken) >= 0);
	}

	private int precedence(char aToken, char corS) {
		if (aToken == '+' || aToken == '-')
			return 12;
		else if (aToken == '(') {
			if (corS == 'c')
				return 20;
			return 0;
		} else if (aToken == ')') {
			return 19;
		} else if (aToken == '*' || aToken == '/')
			return 13;
		else
			return -1;
	}
}
