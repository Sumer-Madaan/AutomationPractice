package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

	private static WebDriver driver;

	public static WebDriver getDriver()
	{
		try {
			if(driver == null)
			{
				FileInputStream fis = new FileInputStream("C:\\Users\\sumer\\eclipse-workspace\\JavaUIAutomation\\src\\test\\resources\\global.properties");
				Properties prop = new Properties();
				prop.load(fis);
				String browser = prop.getProperty("browser");
				if(browser.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\sumer\\Softwares\\ChromeDriver\\chromedriver.exe");
					driver = new ChromeDriver();

				}
				else if(browser.equalsIgnoreCase("edge"))
				{
					System.setProperty("webdriver.edge.driver", "C:\\Users\\sumer\\Softwares\\EdgeDriver\\edgedriver_win64\\msedgedriver.exe");
					driver = new EdgeDriver();
				}

				driver.manage().window().maximize();
				driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			}
	}catch (IOException e) {

		e.printStackTrace();
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
