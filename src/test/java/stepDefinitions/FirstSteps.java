package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FirstPage;
import utils.TestContext;

public class FirstSteps {
	public WebDriver driver;
	public TestContext testContext;
	public FirstPage firstPage;
	
	public FirstSteps(TestContext testContext)
	{
		this.testContext = testContext;
		this.firstPage = testContext.pageObjectManager.getFirstPage();
	}
	@Given("User is on the landing page")
	public void user_is_on_the_landing_page() {
	    System.out.println("User is in the landing page");
	}
	@When("User logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() {
	    System.out.println("User has logged in");
	}
	@Then("User is in the home page")
	public void user_is_in_the_home_page() {
	    System.out.println("User is in the home page");
	}
}
