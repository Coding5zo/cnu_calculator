package cnu.coding5zo;
public class AppController {
	private AppView appView;
	private Calculate calclulate;
	
	//this constructor has no args so just create instances
	public AppController(){
		this.appView = new AppView();
	}
	
	public void evalExpression(){
		//finalValue is for result
		double finalValue;
		//1st. we use stack for calculator so convert to postfix
		if(this.calclulate.infixToPostfix()){
			//2nd. use evalPostfix implemented on Calculate
			finalValue = this.calclulate.evalPostfix();
			//3rd. print result of calculate by AppView
			this.appView.outputResult(finalValue);
		}
		else
			//Exception. if Input is not for calcaulate print error message
			this._appView.outputMessage(MessageID.ERRORINPUT);
	}
	
	public void run(String[] args){
		//print start the program
		this._appView.outputMessage(MessageID.NOTICESTARTPROGRAM);
		//create Calculate instance
		this.calclulate = new Calculate();
		//save args infix's order
		this.calclulate.setInfix(args[0]);
		//finish calculate and print result
		this.evalExpression();
		//print program is over
		this._appView.outputMessage(MessageID.NOTICEENDPROGRAM);
	}
}
