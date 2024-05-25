package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.TestContext;

public class PageObjectManager {
	public WebDriver driver;
	public LoginPage loginPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LoginPage getLoginPage()
	{
		loginPage = new LoginPage(driver);
		return loginPage;
	}
}
