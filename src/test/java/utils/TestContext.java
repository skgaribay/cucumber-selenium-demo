package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContext {
	public WebDriver driver;
	public TestSetup testSetup;
	public BaseUtils baseUtils;
	public PageObjectManager pageObjectManager;
	
	public String baseEnv;
	public String baseURL;
	public String baseUser;
	public String basePassword;
	
	public TestContext() throws IOException
	{
		testSetup = new TestSetup();
		pageObjectManager = new PageObjectManager(testSetup.WebDriverManager());
		baseUtils = new BaseUtils(testSetup.WebDriverManager());
		
		this.baseEnv = testSetup.getBaseEnv();
		this.baseURL = testSetup.getBaseURL();
		this.baseUser = testSetup.getBaseUser();
		this.basePassword = testSetup.getBasePassword();
	}
}
