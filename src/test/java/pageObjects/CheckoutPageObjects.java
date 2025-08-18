package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPageObjects {
	
	WebDriver driver;
	
	public CheckoutPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select")
	WebElement countryList;
	
	@FindBy(css="input.chkAgree")
	WebElement TnC;
	
	public void clickButton(String buttonName)
	{
		driver.findElement(By.xpath("//button[text()='"+buttonName+"']")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectCouuntry(String country)
	{
		Select sel = new Select(countryList);
		sel.selectByValue(country);
	}

	public void selectTnCCheckbox()
	{
		TnC.click();
	}
}
