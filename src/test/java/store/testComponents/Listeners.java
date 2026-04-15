package store.testComponents;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import store.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

	    test.fail(result.getThrowable());

	    WebDriver driver = null;

	    try {
	        // ✅ Look in BaseTest (superclass) where driver is actually declared
	        Field field = result.getTestClass().getRealClass()
	                          .getSuperclass()
	                          .getDeclaredField("driver");
	        field.setAccessible(true);
	        driver = (WebDriver) field.get(result.getInstance());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    // ✅ Guard — only take screenshot if driver was fetched successfully
	    if (driver != null) {
	        try {
	            String screenshotPath = getScreenshot(result.getMethod().getMethodName(), driver);
	            test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Driver is null — screenshot skipped for: " 
	                           + result.getMethod().getMethodName());
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}
	
	

}
