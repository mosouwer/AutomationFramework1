package store.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import store.abstractComponent.AbstractComponent;

public class ProductCateloge extends AbstractComponent {
	
	WebDriver driver;
	WebElement cartproduct;



	public ProductCateloge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	
	@FindBy(css=".col-lg-4")
	List<WebElement> productslist;
	
	
	
	

	
	public void getProductList(String productname) {
		
		for(WebElement prod:productslist) {
			String ptext=prod.findElement(By.cssSelector("b")).getText();
			if(ptext.equals(productname)) {
				cartproduct=prod;
				break;
			
			}
		}
		
	}
	
	
	public CartPage addToCart() {
		//cartproduct.findElement(By.cssSelector("button:last-of-type")).click();
		
		WebElement addToCartBtn = cartproduct.findElement(By.cssSelector("button:last-of-type"));
		waitForClickable(addToCartBtn);
		addToCartBtn.click();
		waitForInvisibility(By.cssSelector("#toast-container"));
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	
	





	



	
	

}
	