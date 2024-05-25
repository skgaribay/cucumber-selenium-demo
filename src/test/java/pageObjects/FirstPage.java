package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContext;

public class FirstPage {
	public WebDriver driver;
	
	public FirstPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
}
