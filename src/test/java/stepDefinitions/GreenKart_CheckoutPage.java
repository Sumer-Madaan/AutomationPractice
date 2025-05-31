package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import utilities.TestContextSetup;

public class GreenKart_CheckoutPage {
	
	TestContextSetup testContextSetup;
	
	public GreenKart_CheckoutPage(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	@Given("User is on Greenkart Checkout page")
	public void user_is_on_Greenkart_Checkout_page()
	{
		Assert.assertEquals("GreenKart - veg and fruits kart", testContextSetup.driver.getTitle());
	}

}
