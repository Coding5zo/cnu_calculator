package cnu.coding5zo;

public class TestMain {
	private TestMain(){
	throw new IllegalAccessError("Utility class");
	}
	public static void main(String[] args) throws Exception{
		AppController appController = new AppController();
		appController.run(args);
	}
}
