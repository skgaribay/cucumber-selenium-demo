package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.Reporter;
import utils.TestContext;

import pageObjects.LoginPage;

public class LoginSteps {
    TestContext testContext;
    LoginPage loginPage;

    public LoginSteps(TestContext testContext){
        this.testContext = testContext;
        this.loginPage = testContext.pageObjectManager.getLoginPage();
    }

    @Given("User is on the landing page")
    public void user_is_on_the_landing_page() throws InterruptedException {
        loginPage.goToLanding();
    }

    @When("User logs in with {string} and {string}")
    public void user_logs_in_with_and(String user, String pass) throws InterruptedException {
        loginPage.enterUser(user);
        Thread.sleep(testContext.testSpeed);
        loginPage.enterPass(pass);
        Thread.sleep(testContext.testSpeed);
        loginPage.submit();
        Thread.sleep(testContext.testSpeed);
    }
    @Then("User is Logged In")
    public void user_is_logged_in() throws InterruptedException {
        Assert.assertEquals(loginPage.getTitle(), "Products");
        Thread.sleep(testContext.testSpeed);
    }
}
