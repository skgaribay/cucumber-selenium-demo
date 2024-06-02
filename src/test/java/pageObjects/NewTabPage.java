package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTabPage {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(how = How.CSS, using = "#open")
    public WebElement openBtn;

    @FindBy(how = How.CSS, using = "#wrapper")
    public WebElement newTabText;

    public NewTabPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void goToLanding()
    {
        driver.get("https://qaplayground.dev/apps/new-tab/");
    }

    public void clickOpenBtn()
    {
        openBtn.click();
    }

    public String getMainWindowhandle()
    {
        return driver.getWindowHandle();
    }

    public void switchToChildWindow(String mainTab)
    {

        for (String windowHandle : driver.getWindowHandles())
        {
            if(!mainTab.contentEquals(windowHandle))
            {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void closeTabReturnToMain(String mainTab)
    {
        driver.close();
        driver.switchTo().window(mainTab);
    }

    public String getNewTabText()
    {
        return newTabText.getText();
    }

    public String getBtnText()
    {
        return openBtn.getText();
    }
}
