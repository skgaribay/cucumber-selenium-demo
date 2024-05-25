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

public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(how = How.CSS, using = "#user-name")
    private WebElement email;

    @FindBy(how = How.CSS, using = "#password")
    private WebElement pword;

    @FindBy(how = How.CSS, using = "#login-button")
    private WebElement submit;

    @FindBy(how = How.CSS, using = ".login_logo")
    private WebElement logo;

    @FindBy(how = How.CSS, using = ".title")
    private WebElement title;

    @FindBy(how = How.CSS, using = "h3[data-test='error']")
    private WebElement loginErr;

    //constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void goToLanding(){
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUser(String user){
        email.sendKeys(user);
    }

    public void enterPass(String pass){
        pword.sendKeys(pass);
    }

    public void submit(){
        submit.click();
    }

    public String getTitle(){
        return title.getText();
    }

    public String getErr(){
        return loginErr.getText();
    }
}
