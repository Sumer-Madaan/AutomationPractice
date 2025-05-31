package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObjects;
import utilities.TestContextSetup;

public class GreenKart_Homepage {
	
	TestContextSetup testContextSetup;
	
	public GreenKart_Homepage(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}

	List<List<String>> items;
	
	@Given("user is on Greenkart Homepage page")
	public void user_is_on_Greenkart_Homepage()
	{
		System.setProperty("webdriver.driver.chrome", "C:\\Users\\sumer\\Softwares\\ChromeDriver\\chromedriver.exe");
		testContextSetup.driver = new ChromeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		testContextSetup.driver.manage().window().maximize();
	}
	
	@When("user search vegetable and select the quantity and click on ADD TO CART button")
	public void user_search_vegetable_and_select_the_quantity(List<List<String>> items) throws InterruptedException {

		this.items = items;
		for(List<String> item:items)
		{
			HomePageObjects obj = new HomePageObjects(testContextSetup.driver);
			obj.searchItem(item.get(0));
//			driver.findElement(By.className("search-keyword")).sendKeys(item.get(0));
			
			Thread.sleep(1000);
			for(int i=1;i<Integer.parseInt(item.get(1));i++)
			{				
//				driver.findElement(By.className("increment")).click();
				obj.addItemSearched();
			}

//			driver.findElement(By.className("search-keyword")).clear();
			obj.clearSearchBox();

//			driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
			obj.addToCart();
			Thread.sleep(1000);
		}
	}
	
	@Then("Items, quantity and amount should reflect in cart")
	public void Items_quantity_and_amount_should_reflect_in_cart()
	{
		String vegetableName="";
		int productPrice = 0;
		int quantity = 0;
		int amount = 0;
		
		testContextSetup.driver.findElement(By.className("cart-icon")).click();
		
		List<WebElement> itemsInCart = testContextSetup.driver.findElements(By.xpath("//div[@class ='cart-preview active']/div/div/ul/li"));
		
		for(int i=1;i<=itemsInCart.size();i++)
		{
			String itemName = testContextSetup.driver.findElement(By.xpath("//div[@class ='cart-preview active']/div/div/ul/li[@class='cart-item'][" + i + "]/div/p[@class='product-name']")).getText();
			
			if(itemName.contains("-"))
			{
				vegetableName = itemName.split("-")[0].trim();
			}
			
			productPrice = Integer.parseInt(testContextSetup.driver.findElement(By.xpath("//div[@class ='cart-preview active']/div/div/ul/li[@class='cart-item'][" + i + "]/div/p[@class='product-price']")).getText());

			quantity = Integer.parseInt(testContextSetup.driver.findElement(By.xpath("//div[@class ='cart-preview active']/div/div/ul/li[@class='cart-item'][" + i + "]/div[2]/p[@class='quantity']")).getText().split(" ")[0].trim());
			amount = Integer.parseInt(testContextSetup.driver.findElement(By.xpath("//div[@class ='cart-preview active']/div/div/ul/li[@class='cart-item'][" + i + "]/div[2]/p[@class='amount']")).getText().split(" ")[0].trim());
			assertEquals(vegetableName, items.get(i-1).get(0));
			assertEquals(amount, quantity*productPrice);
		}
	}
	
	@When("user click on PROCEED TO CHECKOUT button")
	public void user_click_on_PROCEED_TO_CHECKOUT_button()
	{
		testContextSetup.driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	}
	
	@Then("user should navigate to checkout page")
	public void user_should_navigate_to_checkout_page()
	{
		WebDriverWait wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
		
		assertEquals(testContextSetup.driver.getCurrentUrl(), "https://rahulshettyacademy.com/seleniumPractise/#/cart");
	}
}
