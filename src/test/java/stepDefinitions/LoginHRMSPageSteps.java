package stepDefinitions;

import hrms.factory.DriverFactory;
import hrms.pages.LoginHRMSPage;
import hrms.utils.ConfigFileReader;
import io.cucumber.java.en.Given;

public class LoginHRMSPageSteps {

	private LoginHRMSPage hrmsLoginPage = new LoginHRMSPage(DriverFactory.getDriver());
	private ConfigFileReader configFileReader = new ConfigFileReader();
	
	@Given("Open the application")
	public void open_the_application() throws InterruptedException {
		DriverFactory.getDriver().get(configFileReader.getApplicationUrl());
		Thread.sleep(5000);
		System.out.println("Page Title : " + hrmsLoginPage.getLoginPageTitle());
	}

	@Given("Login to the application and redirect to the Admin Home")
	public void login_to_the_application_and_redirect_to_the_admin_home() throws InterruptedException {
		hrmsLoginPage.clearUserName();
		hrmsLoginPage.enterUserName(configFileReader.getUserName());
		hrmsLoginPage.clearPassword();
		hrmsLoginPage.enterPassword(configFileReader.getPassword());
		hrmsLoginPage.clickLoginBtn();
		
		Thread.sleep(5000);
		
	}
}
