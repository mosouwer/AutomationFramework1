package store.stepDefination;

import java.io.IOException;

import io.cucumber.java.en.Given;
import store.pageObjects.LadingPage;
import store.pageObjects.ProductCateloge;
import store.testComponents.BaseTest;

public class StepDefinationImp extends BaseTest {
	LadingPage landingpage;

	@Given("I landed on Ecommerce Page")
	public void  landed_on_Ecommerce_Page() throws IOException {
		 landingpage=launchApplication();
	}
	
	
	@Given("^I logged with username (.+) and password (.+)$")   //regex for accepting any parameter value ^ and $ will be used
	public void logged_in_username_and_password(String username,String password) throws InterruptedException {
		ProductCateloge cateloge =landingpage.loginPage(username,password);
	}
	

}
