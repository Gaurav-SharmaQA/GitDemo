package hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HRMSAdminDashboardPage {

	
	private WebDriver driver;

	// 1. By Locators: OR
	private By welcome = By.id("welcome");

	// 2. Constructor of the page class:
	public HRMSAdminDashboardPage(WebDriver driver) {
			this.driver = driver;
		}

	// 3. page actions: features(behavior) of the page the form of methods:

	public WebElement getWelcomeMsg() {
		return driver.findElement(welcome);
	}
	
}
