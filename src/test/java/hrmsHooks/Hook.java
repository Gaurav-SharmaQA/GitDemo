package hrmsHooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import hrms.factory.DriverFactory;
import hrms.utils.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	

	private DriverFactory driverFactory;
	private WebDriver driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	
	@Before
    public void launchBrowser() {
        System.out.println("This will run before the Scenario");
        String browserName = configFileReader.getBrowser();// Invoke browser from config file
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
    }
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		//driver.quit();
	}

}
