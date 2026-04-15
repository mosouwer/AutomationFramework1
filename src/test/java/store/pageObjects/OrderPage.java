package store.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPage {
	
	WebDriver driver;
	boolean match;
	
	public OrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartbtn1;
	
	@FindBy(css=".subtotal ul li button")
	WebElement checkout;
	
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> cart_item;
	
	
	
	

	public boolean verifyCartProducts(String productname) {
		
		for(WebElement item:cart_item) {
			if(item.getText().equals(productname)) {
				System.out.println("Item Present in cart: "+productname);
				match=true;
				break;
			}
			
			else {
				match=false;}
		}
		
		return match;
	}
	
	

	
}
