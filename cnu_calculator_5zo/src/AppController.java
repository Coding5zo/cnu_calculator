public class AppController {
	private AppView _appView;
	private Calculate _calclulate;
	
	public AppController(){
		this._appView = new AppView();
		this._calclulate = new Calculate();
	}
}
