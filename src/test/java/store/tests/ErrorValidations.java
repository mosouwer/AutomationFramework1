package store.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import store.pageObjects.CartPage;
import store.pageObjects.CheckoutPage;
import store.pageObjects.ConfirmationPage;
import store.pageObjects.ProductCateloge;
import store.testComponents.BaseTest;
import store.testComponents.RetryTest;

public class ErrorValidations extends BaseTest {


	
	@Test(enabled=false)
	public void ProductErrorValidation() throws InterruptedException {
		String productname="ZARA COAT 3";
		
		ProductCateloge cateloge =landingpage.loginPage("macguy@gmail.com", "Unlock@001"); //obj creation handled here	
		cateloge.getProductList(productname);
		
				
		CartPage cartpage = cateloge.addToCart();  // --> Explicit wait is being handled here
		boolean match=cartpage.verifyCartProducts("randomProduct");
		Assert.assertFalse(match);
	}
	
//	@Test(dataProvider="getdata")
//	public void LoginErrorValidation(String email,String pass) throws IOException, InterruptedException {
//		// TODO Auto-generated method stub
//		
//	
//		String productname="ZARA COAT 3";
//	
//		landingpage.loginPage(email,pass); //obj creation handled here	
//		String msg=landingpage.getErrorMsg();
//		
//		System.out.println(msg);
//		
//		Assert.assertEquals(msg, "Incorrect email or password.");
//
//	}

	
//	@DataProvider
//	public Object[][] getdata() {
//		return new Object [][] {{"Abc@gmail.com","pass@123"},{"xyz@gmail.com","pass@123"}};
//	}
	
	
	
	@Test(dataProvider="getdata")
	public void LoginErrorValidation(HashMap<String,String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	
		String productname="ZARA COAT 3";
	
		landingpage.loginPage(input.get("email"),input.get("password")); //obj creation handled here	
		String msg=landingpage.getErrorMsg();
		
		System.out.println(msg);
		
		Assert.assertEquals(msg, "Incorrect email or password");

	}
	
	@DataProvider
	public Object[][] getdata() {
		
		HashMap<String,String> map= new HashMap<String,String>();
		map.put("email","Abc@gmail.com");
		map.put("password","pass@123");
		
		HashMap<String,String> map1= new HashMap<String,String>();
		map1.put("email","Xyz@gmail.com");
		map1.put("password","pass@876");
		
		return new Object [][] {{map},{map1}};
	}
}
