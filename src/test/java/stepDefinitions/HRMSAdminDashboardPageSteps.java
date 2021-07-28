package stepDefinitions;

import org.testng.Assert;

import hrms.factory.DriverFactory;
import hrms.pages.HRMSAdminDashboardPage;
import io.cucumber.java.en.*;

public class HRMSAdminDashboardPageSteps {
	
	private HRMSAdminDashboardPage hrmsAdminDashboardPage = new HRMSAdminDashboardPage(DriverFactory.getDriver());
	private static String ActualHeader;
	private static String ExpectedHeader="Welcome opensourcecms";
	
	
	@When("Verify the User Details")
	public void verify_the_user_details() {
		ActualHeader=hrmsAdminDashboardPage.getWelcomeMsg().getText();
		System.out.println("Admin User Name : " + ActualHeader);
		Assert.assertTrue(ActualHeader.contains(ExpectedHeader));
	}

}