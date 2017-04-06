package cnu.coding5zo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
