package store.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import store.abstractComponent.AbstractComponent;
import store.testComponents.BaseTest;

public class LadingPage extends AbstractComponent {
	
	WebDriver driver;



	public LadingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//PageFactory method
	@FindBy(id="userEmail")
	WebElement emailid;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormsg;
	
	
	

	
	public ProductCateloge loginPage(String email,String pass) throws InterruptedException {
		
		emailid.sendKeys(email);
		password.sendKeys(pass);
		Thread.sleep(2000);
		waitForClickable(submit);
		submit.click();
		
		ProductCateloge cateloge = new ProductCateloge(driver);	
		return cateloge;
		
	}
	
	
	public void goToUrl(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMsg() {
		waitForVisibility(errormsg);
		String msg=errormsg.getText();
		return msg;
	}



	
	

}
	