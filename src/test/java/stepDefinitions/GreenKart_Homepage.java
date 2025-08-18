package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObjects;
import utilities.DriverManager;

public class GreenKart_Homepage {
	
	WebDriver driver = DriverManager.getDriver();
	
	HomePageObjects obj = new HomePageObjects(driver);
	
	@Given("user is on Greenkart Homepage page")
	public void user_is_on_Greenkart_Homepage()
	{
		obj.getPageTitle();
	}
	
	@When("user search vegetable and select the quantity and click on ADD TO CART button")
	public void user_search_vegetable_and_select_the_quantity(List<List<String>> items) throws InterruptedException
	{
		obj.addItemsToCart(items);
	}
	
	@Then("Items, quantity and amount should reflect in cart")
	public void Items_quantity_and_amount_should_reflect_in_cart()
	{
		obj.clickOnCartIcon();

		obj.verifyCartItems();
	}
	
	@When("user click on PROCEED TO CHECKOUT button")
	public void user_click_on_PROCEED_TO_CHECKOUT_button()
	{
		obj.clickOncheckOutButton();
	}
	
	@Then("user should navigate to checkout page")
	public void user_should_navigate_to_checkout_page() throws InterruptedException
	{
	/*	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
	*/	
		Thread.sleep(1500);
		assertEquals(driver.getCurrentUrl(), "https://rahulshettyacademy.com/seleniumPractise/#/cart");
	}
}
