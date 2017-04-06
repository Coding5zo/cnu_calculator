package cnu.coding5zo;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public void testCalculatorAdd () {
        AppController appController = new AppController();
        String[] args = {"1+1", };
        appController.run(args);
    }
}
