package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import utilities.DriverManager;

public class GreenKart_CheckoutPage {
	
	WebDriver driver = DriverManager.getDriver();
	
	@Given("User is on Greenkart Checkout page")
	public void user_is_on_Greenkart_Checkout_page()
	{
		System.out.println(driver.findElement(By.xpath("//*[@id=\"productCartTables\"]/tbody/tr/td[2]/p")).getText());
	}

}
