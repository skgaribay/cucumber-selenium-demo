package testOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features", 
glue="stepDefinitions", monochrome=true, tags="not @tutorial", plugin= {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed_scenarios.txt"}, dryRun=false)
/*
 * features=src"path" | point to the feature files package path
 * glue="packageName | name the package containing your step definitions java files
 * cucumber options parameters
 * tags="@tagName" | multiple tags work with logical operators i.e. "@tagName and @otherTag", "@tagName or @otherTag", "not otherTag"
 * plugins | "pretty" (colored status), "html:path/filename.html" (generate report as html), "json:path/filename.json" (generate report as json file), 
 * 			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" (generate report as extentreports),"rerun: path/filename.txt" (failed scenarios)
 * dryRun=true/false | if true, test will not execute but will raise warnings (i.e. step definition not defined)

*/

public class TestNGRunner extends AbstractTestNGCucumberTests{
/*For parallel executions
 * @Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
 */
}
