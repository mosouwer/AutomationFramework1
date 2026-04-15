package store.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import store.pageObjects.CartPage;
import store.pageObjects.CheckoutPage;
import store.pageObjects.ConfirmationPage;
import store.pageObjects.OrderPage;
import store.pageObjects.ProductCateloge;
import store.testComponents.BaseTest;

public class StandAloneTest extends BaseTest {
	
	String productname="ZARA COAT 3";
	
	@Test
	public void storeOrder() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		ProductCateloge cateloge =landingpage.loginPage("macguy@gmail.com", "Unlock@001"); //obj creation handled here	
		cateloge.getProductList(productname);
		
				
		CartPage cartpage = cateloge.addToCart();  // --> Explicit wait is being handled here
		boolean match=cartpage.verifyCartProducts(productname);
		Assert.assertTrue(match);
		
		
		CheckoutPage checkoutpage = cartpage.checkout();
		checkoutpage.selectCountry("ind");
		checkoutpage.checkout();
		
		ConfirmationPage confirm= checkoutpage.checkout();
		String msg=confirm.confirmMsg();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		

	}
	
	//@Test(dependsOnMethods= {"storeOrder"})
	
	@Test(dependsOnMethods= {"storeOrder"})
	public void OrderHistory() throws InterruptedException {
		ProductCateloge cateloge =landingpage.loginPage("macguy@gmail.com", "Unlock@001");
		OrderPage orderpage=cateloge.goToOrdePage();
		Boolean match=orderpage.verifyCartProducts(productname);
		
		Assert.assertTrue(match);
		
	}

}
