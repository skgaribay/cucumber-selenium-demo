package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.TestContext;

public class PageObjectManager {
	public WebDriver driver;
	public FirstPage firstPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public FirstPage getFirstPage()
	{
		firstPage = new FirstPage(driver);
		return firstPage;
	}
}
