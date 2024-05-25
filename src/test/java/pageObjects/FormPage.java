package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(how = How.CSS, using = "#name")
    private WebElement nameField;

    @FindBy(how = How.CSS, using = "#email")
    private WebElement emailField;

    @FindBy(how = How.CSS, using = "#phone")
    private WebElement phoneField;

    @FindBy(how = How.CSS, using = "#subject")
    private WebElement subjectField;

    @FindBy(how = How.CSS, using = "#description")
    private WebElement messageField;

    @FindBy(how = How.CSS, using = "#submitContact")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "(//p[normalize-space()=\"We'll get back to you about\"])[1]")
    private WebElement confirmMessage;

    public FormPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
    public void goToLanding(){
        driver.get("https://automationintesting.online/");
    }

    public void enterName(String name){
        nameField.sendKeys(name);
    }
    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterPhone(String phone){
        phoneField.sendKeys(phone);
    }

    public void enterSubject(String subject){
        subjectField.sendKeys(subject);
    }

    public void enterMessage(String message){
        messageField.sendKeys(message);
    }

    public void submitForm() {
        submitButton.click();
    }

    public String getConfirmation() {
        return confirmMessage.getText();
    }
}
