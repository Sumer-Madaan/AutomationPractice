package hooks;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverManager;

public class Hooks {
	
	@Before
    public void setUp() {
  //      DriverManager.getDriver();
        DriverManager.initDriver();
    }

   @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
   
   @AfterStep
   public void checkStep(Scenario scenario) throws IOException
   {
	   if(scenario.isFailed())
	   {
	//	   File srcFile = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
	//	   FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshots\\screenshot.png"));
		   
		   byte[] screenshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
		   scenario.attach(screenshot, "image/png", scenario.getName());
	   }
   }

}
