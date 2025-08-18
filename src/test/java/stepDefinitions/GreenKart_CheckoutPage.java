package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPageObjects;
import utilities.DriverManager;

public class GreenKart_CheckoutPage {
	
	WebDriver driver = DriverManager.getDriver();
	
	CheckoutPageObjects obj = new CheckoutPageObjects(driver);
	
	@Given("User is on Greenkart Checkout page")
	public void user_is_on_Greenkart_Checkout_page()
	{
		System.out.println(driver.findElement(By.xpath("//*[@id=\"productCartTables\"]/tbody/tr/td[2]/p")).getText());
	}
	
	@When("user clicks on {string} button")
	public void clickButton(String buttonName)
	{
		obj.clickButton(buttonName);
	}
	
	@When("user selects {string} country and terms and conditions checkbox")
	public void select_country_and_terms_and_conditions_checkbox(String country)
	{
		obj.selectCouuntry(country);
		
		obj.selectTnCCheckbox();
	}
	
	@Then("user should get confirmation message and click on Home link in that")
	public void user_should_get_confirmation_message()
	{
		driver.findElement(By.linkText("Home")).click();
	}
}
