package hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginHRMSPage {

	private WebDriver driver;

	// 1. By Locators: OR
	private By username = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By signInButton = By.id("btnLogin");
	private By welcome = By.id("welcome");

	// 2. Constructor of the page class:
	public LoginHRMSPage(WebDriver driver) {
			this.driver = driver;
		}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void clearUserName() {
		driver.findElement(username);
	}
	
	public void enterUserName(String Username) {
		driver.findElement(username).sendKeys(Username);
	}
	
	public void clearPassword() {
		driver.findElement(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		driver.findElement(signInButton).click();
	}
	
	public WebElement getWelcomeMsg() {
		return driver.findElement(welcome);
	}

}
