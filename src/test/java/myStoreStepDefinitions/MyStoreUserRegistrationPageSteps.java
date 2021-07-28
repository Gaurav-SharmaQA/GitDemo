package myStoreStepDefinitions;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.github.javafaker.Faker;

import hrms.factory.DriverFactory;
import hrms.utils.ConfigFileReader;
import io.cucumber.java.en.*;
import myStore.pages.MyStoreUserRegistrationPage;

public class MyStoreUserRegistrationPageSteps {

	private MyStoreUserRegistrationPage userRegistration = new MyStoreUserRegistrationPage(DriverFactory.getDriver());
	private ConfigFileReader configFileReader = new ConfigFileReader();
	static Faker fakerData = new Faker();

	private static String ActualHeader;
	private static String ExpectedHeader = "Login - My Store";
	private static String enterWrongEmail = "ga@gmail.com";
	private static String enterEmail = fakerData.internet().safeEmailAddress();
	//private static String enterEmail = "automationtesting@hotmail.com";
	private static String eActualHeader;
	private static String eExpectedHeaderText = "YOUR PERSONAL INFORMATION";
	private static String enterFirstName = fakerData.address().firstName();
	private static String enterLastName = fakerData.address().lastName();
	private static String verifyEnteredEmail;
	private static String verifyenteredFirstName;
	private static String verifyenteredLastName;
	private static String enterPassword = "123456";
	private static String enterAddress = fakerData.address().streetName();
	private static String enterCity = "Mena"; 
	private static String selectState = "Arkansas";
	private static String enterZipCode = "71953";
	private static String enterNumber = "8923456789";

	@Given("Open my store Site")
	public void open_my_store_site() {
		try {
			DriverFactory.getDriver().get(configFileReader.getMyStoreApplicationUrl());
			Thread.sleep(5000);
			System.out.println("Page Title : " + userRegistration.getMyStorePageTitle());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("Click on Login")
	public void click_on_login() throws InterruptedException {
		userRegistration.clickSignInLink().click();
		Thread.sleep(5000);
	}

	@When("Verify the section")
	public void verify_the_section() {
		System.out.println("Page Title : " + userRegistration.getMyStorePageTitle());
		ActualHeader = userRegistration.getMyStorePageTitle();
		if (ActualHeader.equalsIgnoreCase(ExpectedHeader)) {
			System.out.println("Complete the User Registration.");
		} else {
			System.out.println("SomeThing went wrong!");
		}

		if (userRegistration.createAccountForm().isDisplayed()) {
			System.out.println("Create Account Form is Displaying.");
		} else {
			System.out.println("SomeThing went wrong!");
		}
	}

	@When("Enter Email Address and click on create an account button")
	public void enter_email_address_and_click_on_create_an_account_button() {
		try {
			userRegistration.enterEmail().clear();
			userRegistration.enterEmail().sendKeys(enterWrongEmail);
			userRegistration.SubmitCreate().click();
			Thread.sleep(5000);

			if (userRegistration.enterEmailError().isDisplayed()) {
				System.out.println("Error - " + userRegistration.enterEmailError().getText());
			}
			Thread.sleep(5000);
			userRegistration.enterEmail().clear();
			userRegistration.enterEmail().sendKeys(enterEmail);
			userRegistration.SubmitCreate().click();
			System.out.println("Clicked on Create an Account button!" );
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Fill the user Details")
	public void fill_the_user_details() {
		eActualHeader = userRegistration.getHeaderText().getText();
		System.out.println("Actual Header on the seaction : " + eActualHeader);
		if (eActualHeader.equals(eExpectedHeaderText)) {
			System.out.println("Complete the User Registration.");
			List<WebElement> a = userRegistration.selectTitle();
			System.out.println(a.size());
			for (int i = 0; i < a.size(); i++) {
				String checkTitleText = a.get(i).getText();
				System.out.println("Title value : " + checkTitleText + " \n");
				if (checkTitleText.equalsIgnoreCase("Mr.")) {
					a.get(i).click();
					System.out.println("Male Title is Selected!");
					break;
				} else {
					System.out.println("Not getting the radio button value,Something wrong!");
				}
			}

			userRegistration.enterCustomerfirstname().clear();
			userRegistration.enterCustomerfirstname().sendKeys(enterFirstName);
			userRegistration.enterCustomerlastname().clear();
			userRegistration.enterCustomerlastname().sendKeys(enterLastName);
			verifyEnteredEmail = userRegistration.enterUserEmail().getAttribute("value");
			System.out.println("email textbox value is :" + verifyEnteredEmail);
			Assert.assertTrue(enterEmail.equals(verifyEnteredEmail));
			Assert.assertEquals(enterEmail, verifyEnteredEmail);

			userRegistration.enterpasswd().clear();
			userRegistration.enterpasswd().sendKeys(enterPassword);
			verifyenteredFirstName = userRegistration.enterfirstname().getAttribute("value");
			System.out.println("FirstName textbox value is :" + verifyenteredFirstName);
			Assert.assertTrue(enterFirstName.equals(verifyenteredFirstName));
			Assert.assertEquals(enterFirstName, verifyenteredFirstName);

			verifyenteredLastName = userRegistration.enterlastname().getAttribute("value");
			System.out.println("LastName textbox value is :" + verifyenteredLastName);
			Assert.assertTrue(enterLastName.equals(verifyenteredLastName));
			Assert.assertEquals(enterLastName, verifyenteredLastName);

			userRegistration.enteraddress1().sendKeys(enterAddress);
			userRegistration.entercity().sendKeys(enterCity);
			userRegistration.enterstate().sendKeys(selectState);
			userRegistration.enterpostcode().sendKeys(enterZipCode);
			System.out.println("Country textbox value is :" + userRegistration.entercountry().getText());
			userRegistration.enterphonemobile().sendKeys(enterNumber);
			System.out.println("Assign an address alias for future reference textbox value is :"
					+ userRegistration.getAlias().getAttribute("value"));

		} else {
			System.out.println("SomeThing went wrong on Registration Form!");
		}
	}

	@Then("click on Register button")
	public void click_on_register_button() {
		try {
			userRegistration.entersubmitAccount().click();
			Thread.sleep(5000);
			if(userRegistration.getaccount().isDisplayed()) {
				System.out.println("User Registration Completed!");
				System.out.println("Registered User is: " + userRegistration.getaccount().getText());
			}else{
				 
			}			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
