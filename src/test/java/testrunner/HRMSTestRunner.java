package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		monochrome = true,
		dryRun=false,
		features = {"src/test/resource/hrmsFeatures/HRMSAdminDashboard.feature"},
		glue = {"stepDefinitions", "hrmsHooks"},
		//tags = "@regression",
		
		plugin = {
				"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		
		)


public class HRMSTestRunner extends AbstractTestNGCucumberTests  {

}


