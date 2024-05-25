package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestSetup {
	public WebDriver driver;
	public Properties prop = new Properties();
	private String url;
	
	public TestSetup() throws FileNotFoundException, IOException
	{
		this.prop.load(new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties"));
	}

	public WebDriver WebDriverManager()
	{
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser"); //cmd arg
		String browser = browser_maven!=null ? browser_maven : browser_properties; //ternary
		String env = prop.getProperty("environment");
		
		if(driver == null)
		{
			switch(browser.toLowerCase()) 
			{
				case "chrome":
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//drivers//chrome//chromedriver.exe");
					driver = new ChromeDriver();
					break;
					
				case "firefox":
					System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//test//resources//drivers//firefox//geckodriver.exe");
					driver = new FirefoxDriver();
					break;
					
				case "edge":
					System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//src//test//resources//drivers//edge//msedgedriver.exe");
					driver = new EdgeDriver();
					break;
				default:
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//drivers//chrome//chromedriver.exe");
					driver = new ChromeDriver();
					break;
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			//Get URL based on set environment in properties
			switch(env.toLowerCase())
			{
				case "dev":
					this.url = prop.getProperty("devURL");
					driver.get(this.url);
					break;
				case "stage":
					this.url = prop.getProperty("stgURL");
					driver.get(this.url);
					break;
				case "prod":
					this.url = prop.getProperty("prdURL");
					driver.get(this.url);
					break;
				default:
					this.url = prop.getProperty("devURL");
					driver.get(this.url);
					break;
			}
		}
		
		return driver;
		
	}
	
	public String getBaseEnv()
	{
		return prop.getProperty("environment");
	}
	
	public String getBaseURL()
	{
		return this.url;
	}
	
	public String getBaseUser()
	{
		return prop.getProperty("user");
	}
	
	public String getBasePassword()
	{
		return prop.getProperty("password");
	}
}
