package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import dataNopcommerce.User.DataCommons.DataLogin;
import pageObjectNopcommerceUser.PageGeneratorManager;
import pageObjectNopcommerceUser.UserHomePageObject;
import pageObjectNopcommerceUser.UserLoginPageObject;
import pageObjectNopcommerceUser.UserRegisterPageObject;

public class User_02_Login extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Navigate to 'Home Page'");
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-Condition - Step 02: Click to 'Log in' link");
		userHomePage.clickToLinkByText(driver, "Log in");
		userLoginPage = PageGeneratorManager.getLoginPage(driver);
		
	}

	@Test
	public void Case_01_Login_With_Empty_Data() {
		log.info("Case_01_Login - Step 01: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Case_01_Login - Step 02: Verify 'Please enter your email' displayed");
		verifyEquals(userLoginPage.getTextWarningMassage(driver, "Email-error"), "Please enter your email");
	}

	@Test
	public void Case_02_Login_With_Invalid_Email() {
		log.info("Case_02_Login - Step 01: Click to 'Log in' link");
		userLoginPage.clickToLinkByText(driver, "Log in");
		
		log.info("Case_02_Login - Step 02: Sendkey to 'Email' textbox with value is '" + DataLogin.ERROR_EMAIL + "'");
		userLoginPage.sendKeyToTextbox(driver,DataLogin.ERROR_EMAIL ,"Email");
		
		log.info("Case_02_Login - Step 03: Sendkey to 'Password' textbox with value is '" + DataLogin.PASSWORD + "'");
		userLoginPage.sendKeyToTextbox(driver,DataLogin.PASSWORD ,"Password");
		
		log.info("Case_02_Login - Step 04: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Case_02_Login - Step 05: Verify 'Wrong email' displayed");
		verifyEquals(userLoginPage.getTextWarningMassage(driver, "Email-error"), "Wrong email");
	}

	@Test
	public void Case_03_Login_With_Unregistered_Email() {
		log.info("Case_03_Login - Step 01: Click to 'Log in' link");
		userLoginPage.clickToLinkByText(driver, "Log in");
		
		log.info("Case_03_Login - Step 02: Sendkey to 'Email' textbox with value is '" + DataLogin.EMAIL_ADDRESS + "'");
		userLoginPage.sendKeyToTextbox(driver,DataLogin.EMAIL_ADDRESS ,"Email");
		
		log.info("Case_03_Login - Step 03: Sendkey to 'Password' textbox with value is '" + DataLogin.PASSWORD + "'");
		userLoginPage.sendKeyToTextbox(driver,DataLogin.PASSWORD ,"Password");
		
		log.info("Case_03_Login - Step 04: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Case_03_Login - Step 05: Verify 'Login was unsuccessful. Please correct the errors and try again.No customer account found' displayed");
		verifyEquals(userLoginPage.getTextWarningMessageUnregisteredEmail(driver), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Case_04_Login_With_Registered_Email_And_Do_Not_Enter_Password() {
		log.info("Pre-Condition - Step 01: Open 'Register' page");
		userRegisterPage = PageGeneratorManager.getRegisterPage(driver);
		userRegisterPage.clickToLinkByText(driver, "Register");
		
		log.info("Pre-Condition - Step 02: sendKey to 'Firt name' textbox with the value is '" + DataLogin.FIRSTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataLogin.FIRSTNAME, "FirstName");
		
		log.info("Pre-Condition - Step 03: sendKey to 'Last name' textbox with the value is '" + DataLogin.LASTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataLogin.LASTNAME, "LastName");
		
		log.info("Pre-Condition - Step 04: sendKey to 'Email' textbox with the value is '" + DataLogin.EMAIL_ADDRESS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataLogin.EMAIL_ADDRESS, "Email");
		
		log.info("Pre-Condition - Step 05: sendKey to 'Password' textbox with the value is '" + DataLogin.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataLogin.PASSWORD, "Password");
		
		log.info("Pre-Condition - Step 06: sendKey to 'Confirm Password' textbox with the value is '" + DataLogin.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataLogin.PASSWORD, "ConfirmPassword");
		
		log.info("Pre-Condition - Step 07: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");
		
		log.info("Pre-Condition - Step 08: Verify 'Your registration completed' is displayed");
		verifyTrue(userRegisterPage.verifySuccessMessageRegisterDisplayed(driver));
		
		log.info("Case_04_Login - Step 01: Click to 'Log in' link");
		userLoginPage.clickToLinkByText(driver, "Log in");
		
		log.info("Case_04_Login - Step 02: Sendkey to 'Email' textbox with value is '" + DataLogin.EMAIL_ADDRESS + "'");
		userLoginPage.sendKeyToTextbox(driver,DataLogin.EMAIL_ADDRESS ,"Email");
		
		log.info("Case_04_Login - Step 03: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Case_04_Login - Step 04: Verify 'Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect' displayed");
		verifyEquals(userLoginPage.getTextWarningMessageUnregisteredEmail(driver), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Case_05_Login_With_Registered_Email_And_Enter_Wrong_Password() {
		log.info("Case_05_Login - Step 01: Click to 'Log in' link");
		userLoginPage.clickToLinkByText(driver, "Log in");
		
		log.info("Case_05_Login - Step 02: Sendkey to 'Email' textbox with value is '" + DataLogin.EMAIL_ADDRESS + "'");
		userLoginPage.sendKeyToTextbox(driver,DataLogin.EMAIL_ADDRESS ,"Email");
		
		log.info("Case_05_Login - Step 03: Sendkey to 'Password' textbox with value is '" + DataLogin.WRONG_PASSWORD + "'");
		userLoginPage.sendKeyToTextbox(driver,DataLogin.WRONG_PASSWORD ,"Password");
		
		log.info("Case_05_Login - Step 04: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Case_05_Login - Step 05: Verify 'Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect' displayed");
		verifyEquals(userLoginPage.getTextWarningMessageUnregisteredEmail(driver), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		

	}

	@Test
	public void Case_06_Login_With_Registered_Email_And_Enter_True_Password() {
		log.info("Case_06_Login - Step 01: Click to 'Log in' link");
		userLoginPage.clickToLinkByText(driver, "Log in");
		
		log.info("Case_06_Login - Step 02: Sendkey to 'Email' textbox with value is '" + DataLogin.EMAIL_ADDRESS + "'");
		userLoginPage.sendKeyToTextbox(driver,DataLogin.EMAIL_ADDRESS ,"Email");
		
		log.info("Case_06_Login - Step 03: Sendkey to 'Password' textbox with value is '" + DataLogin.PASSWORD + "'");
		userLoginPage.sendKeyToTextbox(driver,DataLogin.PASSWORD ,"Password");
		
		log.info("Case_06_Login - Step 04: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Case_06_Login - Step 05: Verify 'My account' link displayed'");
		verifyTrue(userHomePage.isLinkDisplayed(driver, "My account"));
		
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	

}