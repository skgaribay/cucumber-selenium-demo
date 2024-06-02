package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import org.testng.Reporter;
import pageObjects.LoginPage;
import pageObjects.NewTabPage;
import utils.TestContext;

import pageObjects.FormPage;

public class NewTabSteps {
    TestContext testContext;
    NewTabPage newTabPage;

    public NewTabSteps(TestContext testContext){
        this.testContext = testContext;
        this.newTabPage = testContext.pageObjectManager.getNewTabPage();
    }

    @Given("User is on the Test New Tab page")
    public void user_is_on_the_test_new_tab_page() throws InterruptedException
    {
        newTabPage.goToLanding();
        Thread.sleep(testContext.testSpeed);
    }
    @When("User clicks on the Open New Tab button")
    public void user_clicks_on_the_open_new_tab_button() throws InterruptedException
    {
        testContext.setMainTab(newTabPage.getMainWindowhandle());
        newTabPage.clickOpenBtn();
        Thread.sleep(testContext.testSpeed);
        newTabPage.switchToChildWindow(testContext.getMainTab());
    }
    @Then("the user is in the new tab")
    public void the_user_is_in_the_new_tab() throws InterruptedException
    {
        Assert.assertEquals(newTabPage.getNewTabText(), "Welcome to the new page!");
        Thread.sleep(testContext.testSpeed);
    }

    @When("User closes current tab")
    public void user_closes_current_tab() throws InterruptedException
    {
        newTabPage.closeTabReturnToMain(testContext.getMainTab());
        Thread.sleep(testContext.testSpeed);
    }
    @Then("User is back on the main tab")
    public void user_is_back_on_the_main_tab() {
        Assert.assertEquals(newTabPage.getBtnText(), "OPEN NEW TAB");
    }
}
