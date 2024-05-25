package testOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.txt", 
				glue="stepDefinitions", monochrome=true, plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, dryRun=false ) 

public class FailedTestRunner extends AbstractTestNGCucumberTests{

}
