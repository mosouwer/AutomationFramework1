package store.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import store.pageObjects.LadingPage;

public class BaseTest {
	
	protected WebDriver driver;
	public LadingPage landingpage;
	
	public WebDriver intializeDriver() throws IOException {
		
		
		
		//properties class
		
//		Properties prop = new Properties();
//
//		String path = System.getProperty("user.dir")
//		        + "/src/main/java/store/resources/GlobalData.properties";
//
//		System.out.println(path);
//
//		FileInputStream fis = new FileInputStream(path);
//		
//		prop.load(fis);
//		
//		
//		String browser=prop.getProperty("browser");
		
		
		String browser="chrome";
		
		if(browser.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();   //for passing chrome parameters
		//	options.addArguments("--headless=new");
		//	options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver();	

		}
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		return driver;
		
	}
	
	@BeforeMethod
	public LadingPage launchApplication() throws IOException {
		WebDriver driver=intializeDriver();
		landingpage = new LadingPage(driver);		
		landingpage.goToUrl(driver);
		return landingpage;
	}
	
	
	@AfterMethod
	public void closeApplication() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
	
	
	public String getScreenshot(String testname,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"/reports/"+testname+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"/reports/"+testname+".png";
		
	}

}
