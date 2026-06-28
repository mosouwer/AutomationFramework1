package store.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		String product="ZARA COAT 3";
		Boolean match=false;
		
		
		driver.findElement(By.id("userEmail")).sendKeys("macguy@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Unlock@001");
		driver.findElement(By.id("login")).click();
		
		
		List<WebElement> products=driver.findElements(By.cssSelector(".col-lg-4"));
		
		for(WebElement prod:products) {
			String ptext=prod.findElement(By.cssSelector("b")).getText();
			if(ptext.equals(product)) {
				prod.findElement(By.cssSelector("button:last-of-type")).click();
				break;
			
			}
		}
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//waiting for the toast element to be invisible

		

		//explicit wait of element to be clickable can also be applied here in case of failing when clicking 
		//cart instantly after animation till that time cart button may not be enabled
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		
//		WebElement cartbtn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[routerlink*='cart']")));		
//		cartbtn.click();
		
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		

		List<WebElement> cart_item=driver.findElements(By.cssSelector(".infoWrap div h3"));
		
		for(WebElement item:cart_item) {
			if(item.getText().equals(product)) {
				System.out.println("Item Present in cart: "+product);
				match=true;
				Assert.assertTrue(match);
			}
		}
		
		
		driver.findElement(By.cssSelector(".subtotal ul li button")).click();
		
		
		driver.findElement(By.cssSelector("[placeholder]")).sendKeys("ind");
		
		driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
		
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		
		String msg= driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		
	
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();

	}

}
