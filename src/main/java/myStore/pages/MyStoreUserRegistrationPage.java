package myStore.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyStoreUserRegistrationPage {

	private WebDriver driver;

	// 1. By Locators: OR
	private By signInLink = By.xpath("//a[@class='login']");
	private By createAccountForm = By.xpath("//form[@id='create-account_form']");
	private By email_create = By.id("email_create");
	private By create_account_error = By.id("create_account_error");
	private By SubmitCreate = By.id("SubmitCreate");
	private By headerText = By.xpath("//h3[contains(text(),'Your personal information')]");
	private By titles = By.xpath("//label[@class='top']");
	private By id_gender1 = By.id("id_gender1");
	private By customer_firstname = By.id("customer_firstname");
	private By customer_lastname = By.id("customer_lastname");
	private By email = By.id("email");
	private By passwd = By.id("passwd");
	private By firstname = By.id("firstname");
	private By lastname = By.id("lastname");
	private By address1 = By.id("address1");
	private By city = By.id("city");
	private By id_state = By.id("id_state");
	private By postcode = By.id("postcode");
	private By id_country = By.id("id_country");
	private By phone_mobile = By.id("phone_mobile");
	private By submitAccount = By.id("submitAccount");
	private By alias = By.id("alias");
	private By account = By.xpath("//a[@class='account']");

	// 2. Constructor of the page class:
	public MyStoreUserRegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getMyStorePageTitle() {
		return driver.getTitle();
	}

	public WebElement clickSignInLink() {
		return driver.findElement(signInLink);
	}

	public WebElement createAccountForm() {
		return driver.findElement(createAccountForm);
	}

	public WebElement enterEmail() {
		return driver.findElement(email_create);
	}

	public WebElement enterEmailError() {
		return driver.findElement(create_account_error);
	}

	public WebElement SubmitCreate() {
		return driver.findElement(SubmitCreate);
	}

	public WebElement getHeaderText() {
		return driver.findElement(headerText);
	}

	public List<WebElement> selectTitle() {
		return driver.findElements(titles);
	}

	public WebElement selectMaleGender() {
		return driver.findElement(id_gender1);
	}

	public WebElement enterCustomerfirstname() {
		return driver.findElement(customer_firstname);
	}

	public WebElement enterCustomerlastname() {
		return driver.findElement(customer_lastname);
	}

	public WebElement enterUserEmail() {
		return driver.findElement(email);
	}

	public WebElement enterpasswd() {
		return driver.findElement(passwd);
	}

	public WebElement enterfirstname() {
		return driver.findElement(firstname);
	}

	public WebElement enterlastname() {
		return driver.findElement(lastname);
	}

	public WebElement enteraddress1() {
		return driver.findElement(address1);
	}

	public WebElement entercity() {
		return driver.findElement(city);
	}

	public WebElement enterstate() {
		return driver.findElement(id_state);
	}

	public WebElement enterpostcode() {
		return driver.findElement(postcode);
	}

	public WebElement entercountry() {
		return driver.findElement(id_country);
	}

	public WebElement enterphonemobile() {
		return driver.findElement(phone_mobile);
	}

	public WebElement entersubmitAccount() {
		return driver.findElement(submitAccount);
	}
	public WebElement getAlias() {
		return driver.findElement(alias);
	}
	public WebElement getaccount() {
		return driver.findElement(account);
	}
	
	public void test1() {
		System.out.println("This is Test method for the git checkin");
	}
}
