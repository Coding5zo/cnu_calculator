public class AppController {
	private AppView _appView;
	private Calculate _calclulate;
	
	public AppController(){
		this._appView = new AppView();
		this._calclulate = new Calculate();
	}
	
	public void evalExpression(){
		double finalValue;
		if(this._calclulate.infixToPostfix()){
			finalValue = this._calclulate.evalPostfix();
			this._appView.outputResult(finalValue);
		}
		else
			this._appView.outputMessage(MessageID.Error_Input);
	}
	
	public void run(String[] args){
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		this._calclulate = new Calculate();
		
		this._calclulate.setInfix(args[0]);
		this.evalExpression();
		
		this._appView.outputMessage(MessageID.Notice_EndProgram);
	}
}
