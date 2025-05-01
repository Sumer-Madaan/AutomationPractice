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

public class GreenKart_Homepage {

	WebDriver driver;
	List<List<String>> items;
	
	@Given("user is on Greenkart Homepage")
	public void user_is_on_Greenkart_Homepage()
	{
		System.setProperty("webdriver.driver.chrome", "C:\\Users\\sumer\\Softwares\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
	}

	@When("user search vegetable and select the quantity and click on ADD TO CART button")
	public void user_search_vegetable_and_select_the_quantity(List<List<String>> items) throws InterruptedException {

		this.items = items;
		for(List<String> item:items)
		{
			driver.findElement(By.className("search-keyword")).sendKeys(item.get(0));
			
			Thread.sleep(1000);
			for(int i=1;i<Integer.parseInt(item.get(1));i++)
			{				
				driver.findElement(By.className("increment")).click();
			}

			driver.findElement(By.className("search-keyword")).clear();

			driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
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
		
		driver.findElement(By.className("cart-icon")).click();
		
		List<WebElement> itemsInCart = driver.findElements(By.xpath("//div[@class ='cart-preview active']/div/div/ul/li"));
		
		for(int i=1;i<=itemsInCart.size();i++)
		{
			String itemName = driver.findElement(By.xpath("//div[@class ='cart-preview active']/div/div/ul/li[@class='cart-item'][" + i + "]/div/p[@class='product-name']")).getText();
			
			if(itemName.contains("-"))
			{
				vegetableName = itemName.split("-")[0].trim();
			}
			
			productPrice = Integer.parseInt(driver.findElement(By.xpath("//div[@class ='cart-preview active']/div/div/ul/li[@class='cart-item'][" + i + "]/div/p[@class='product-price']")).getText());

			quantity = Integer.parseInt(driver.findElement(By.xpath("//div[@class ='cart-preview active']/div/div/ul/li[@class='cart-item'][" + i + "]/div[2]/p[@class='quantity']")).getText().split(" ")[0].trim());
			amount = Integer.parseInt(driver.findElement(By.xpath("//div[@class ='cart-preview active']/div/div/ul/li[@class='cart-item'][" + i + "]/div[2]/p[@class='amount']")).getText().split(" ")[0].trim());
			assertEquals(vegetableName, items.get(i-1).get(0));
			assertEquals(amount, quantity*productPrice);
		}
	}
	
	@When("user click on PROCEED TO CHECKOUT button")
	public void user_click_on_PROCEED_TO_CHECKOUT_button()
	{
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	}
	
	@Then("user should navigate to checkout page")
	public void user_should_navigate_to_checkout_page()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
		
		assertEquals(driver.getCurrentUrl(), "https://rahulshettyacademy.com/seleniumPractise/#/cart");
	}
}
