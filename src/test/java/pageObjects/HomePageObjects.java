package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	
	WebDriver driver;
	
	public HomePageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.className("search-keyword")).sendKeys(item.get(0));
	@FindBy(className = "search-keyword")
	WebElement searchItem;

	//driver.findElement(By.className("increment")).click();
	@FindBy(className = "increment")
	WebElement increaseButton;
	
	//driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	WebElement addToCartButton;
	
	//driver.findElement(By.className("cart-icon")).click();
	@FindBy(className = "cart-icon")
	WebElement cartIcon;
	
	//List<WebElement> itemsInCart = driver.findElements(By.xpath("//div[@class ='cart-preview active']/div/div/ul/li"));
	@FindBy(xpath = "//div[@class ='cart-preview active']/div/div/ul/li")
	List<WebElement> itemsInCart;
	
	//driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	WebElement checkOutButton;
	
	List<List<String>> items;
	
	public void getPageTitle()
	{
		String homePageTitle = "GreenKart - veg and fruits kart";
		assertEquals(driver.getTitle(), homePageTitle);
	}
	
	public void searchItem(String item)
	{
		searchItem.sendKeys(item);
	}
	
	public void addItemSearched()
	{
		increaseButton.click();
	}
	
	public void clearSearchBox()
	{
		searchItem.clear();
	}
	
	public void addToCart()
	{
		addToCartButton.click();
	}
	
	public void clickOnCartIcon()
	{
		cartIcon.click();
	}
	
	public void addItemsToCart(List<List<String>> items) throws InterruptedException
	{
		this.items = items;
		for(List<String> item:items)
		{
			searchItem(item.get(0));
			
			Thread.sleep(1000);
			for(int i=1;i<Integer.parseInt(item.get(1));i++)
			{
				addItemSearched();
			}

			clearSearchBox();

			addToCart();
			Thread.sleep(1000);
		}

	}
	
	public void verifyCartItems()
	{
		String vegetableName="";
		int productPrice = 0;
		int quantity = 0;
		int amount = 0;
		
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
	
	public void clickOncheckOutButton()
	{
		checkOutButton.click();
	}

}
