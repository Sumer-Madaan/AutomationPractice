package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverManager;

public class Hooks {
	
	@Before
    public void setUp() {
        DriverManager.getDriver();
    }

   @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
   
   @AfterStep
   public void checkStep(Scenario scenario)
   {
	   if(scenario.isFailed())
	   {
		   System.out.println("Code for screenshot");
	   }
   }

}
