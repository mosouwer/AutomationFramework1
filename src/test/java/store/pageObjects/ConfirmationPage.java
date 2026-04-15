package store.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmationPage {
	
	WebDriver driver;

	
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".hero-primary")
	WebElement msg;
	
	
	
	public String confirmMsg() {
		
		String confirmmsg=msg.getText();
		
		return confirmmsg;
		
	
	}
	
	
	
}
