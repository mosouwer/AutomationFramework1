package store.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage {
	
	WebDriver driver;

	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[placeholder]")
	WebElement countryname;
	
	@FindBy(css=".ta-item:nth-child(3)")
	WebElement selectcountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	
	
	
	
	
	
	public void selectCountry(String country) {
		countryname.sendKeys(country);
		selectcountry.click();
	
	}
	
	
	public ConfirmationPage checkout() {
		submit.click();
		ConfirmationPage confirm= new ConfirmationPage(driver);
		return confirm;
		
	}
	
}
