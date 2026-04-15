package store.abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import store.pageObjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement myorder;

	
    // Reusable wait methods
    protected void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    
    protected void waitForInvisibilityElement(WebElement welement) {
        wait.until(ExpectedConditions.invisibilityOf(welement));
    }
    
    protected void waitForVisibility(WebElement welement) {
        wait.until(ExpectedConditions.visibilityOf(welement));
    }
    
    protected void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
  
    
    public OrderPage goToOrdePage() {
    	myorder.click();
    	System.out.println(myorder.getText());
    	OrderPage orderpage = new OrderPage(driver);
    	return orderpage;
    }
    
    

}
