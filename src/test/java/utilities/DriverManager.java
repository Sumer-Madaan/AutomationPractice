package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		if(driver == null)
		{
			System.setProperty("webdriver.driver.chrome", "C:\\Users\\sumer\\Softwares\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		}
		
		return driver;
	}
	
	public static void quitDriver()
	{
		if(driver!=null)
		{
			driver.quit();
			driver = null;
		}
	}
	
	

}
