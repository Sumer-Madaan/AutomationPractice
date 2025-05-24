package pageObjects;

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

}
