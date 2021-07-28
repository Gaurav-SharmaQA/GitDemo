package testrunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		monochrome = true,
		dryRun=false,
		features = {"src/test/resource/myStoreFeatures/MyStoreRegistration.feature"},
		glue = {"myStoreStepDefinitions", "hrmsHooks"},
		//tags = "@regression",
		
		plugin = {
				"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		
		)


public class MyStoreTestRunner extends AbstractTestNGCucumberTests {

}
 