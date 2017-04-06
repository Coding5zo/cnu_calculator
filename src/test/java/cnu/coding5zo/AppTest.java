package cnu.coding5zo;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public void testCalculatorAdd () {
        AppController appController = new AppController();
        String[] args = {"((32*(23+32)-53)/232+511*23)", };
        appController.run(args);
    }
}
