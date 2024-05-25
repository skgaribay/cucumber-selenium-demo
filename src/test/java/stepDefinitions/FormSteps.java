package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import org.testng.Reporter;
import pageObjects.LoginPage;
import utils.TestContext;

import pageObjects.FormPage;

import java.util.List;

public class FormSteps {
    TestContext testContext;
    FormPage formPage;

    public FormSteps(TestContext testContext){
        this.testContext = testContext;
        this.formPage = testContext.pageObjectManager.getFormPage();
    }

    @Given("User is on the form page")
    public void user_is_on_the_form_page() throws InterruptedException {
        formPage.goToLanding();
        Thread.sleep(testContext.testSpeed);
    }

    @When("User fillse up the form")
    public void user_fillse_up_the_form(DataTable dataTable) throws InterruptedException {
        List<String> data = dataTable.asList();
        formPage.enterName(data.get(0));
        Thread.sleep(testContext.testSpeed);
        formPage.enterEmail(data.get(1));
        Thread.sleep(testContext.testSpeed);
        formPage.enterPhone(data.get(2));
        Thread.sleep(testContext.testSpeed);
        formPage.enterSubject(data.get(3));
        Thread.sleep(testContext.testSpeed);
        formPage.enterMessage(data.get(4));
        Thread.sleep(testContext.testSpeed);

        formPage.submitForm();
        Thread.sleep(testContext.testSpeed);
    }
    @Then("The form is submitted")
    public void the_form_is_submitted() {
        Assert.assertEquals(formPage.getConfirmation(), "We'll get back to you about");
    }
}