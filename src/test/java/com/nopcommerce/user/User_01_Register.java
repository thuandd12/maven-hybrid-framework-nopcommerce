package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import dataNopcommerce.User.DataCommons.DataRegister;
import pageObjectNopcommerceUser.PageGeneratorManager;
import pageObjectNopcommerceUser.UserHomePageObject;
import pageObjectNopcommerceUser.UserRegisterPageObject;

public class User_01_Register extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Navigate to 'Home Page'");
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = pageObjectNopcommerceUser.PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-Condition - Step 02: Click to 'Register' link ");
		userHomePage.clickToLinkByText(driver, "Register");
		userRegisterPage = PageGeneratorManager.getRegisterPage(driver);

	}

	@Test
	public void Case_01_Register_With_Empty_Data() {
		log.info("Case_01_Register - Step 01: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");
		
		log.info("Case_01_Register - Step 02: Verify 'First name is required.' is displayed");
		verifyTrue(userRegisterPage.verifyErrorMessageDisplayed(driver, "FirstName-error"));
		
		log.info("Case_01_Register - Step 03: Verify 'Last name is required.' is displayed");
		verifyTrue(userRegisterPage.verifyErrorMessageDisplayed(driver, "LastName-error"));
		
		log.info("Case_01_Register - Step 04: Verify 'Email is required.' is displayed");
		verifyTrue(userRegisterPage.verifyErrorMessageDisplayed(driver, "Email-error"));
		
		log.info("Case_01_Register - Step 05: Verify 'Password is required.' under 'Password' textbox is displayed");
		verifyTrue(userRegisterPage.verifyErrorMessageDisplayed(driver, "Password-error"));
		
		log.info("Case_01_Register - Step 06: Verify 'Password is required.' under 'Confirm Password' textbox is displayed");
		verifyTrue(userRegisterPage.verifyErrorMessageDisplayed(driver, "ConfirmPassword-error"));
	}

	@Test
	public void Case_02_Register_With_Invalid_Email() {
		log.info("Case_02_Register - Step 01: Open 'Register' page");
		userRegisterPage.refreshCurrentPage(driver);
		
		log.info("Case_02_Register - Step 02: sendKey to 'Firt name' textbox with the value is '" + DataRegister.FIRSTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.FIRSTNAME, "FirstName");
		
		log.info("Case_02_Register - Step 03: sendKey to 'Last name' textbox with the value is '" + DataRegister.LASTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.LASTNAME, "LastName");
		
		log.info("Case_02_Register - Step 04: sendKey to 'Email' textbox with the value is '" + DataRegister.ERROR_EMAIL + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.ERROR_EMAIL, "Email");
		
		log.info("Case_02_Register - Step 05: sendKey to 'Password' textbox with the value is '" + DataRegister.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.PASSWORD, "Password");
		
		log.info("Case_02_Register - Step 06: sendKey to 'Confirm Password' textbox with the value is '" + DataRegister.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.PASSWORD, "ConfirmPassword");
		
		log.info("Case_02_Register - Step 07: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");
		
		log.info("Case_02_Register - Step 08: Verify 'Wrong email' is displayed");
		verifyTrue(userRegisterPage.verifyErrorMessageDisplayed(driver, "Email-error"));
		
	}

	@Test
	public void Case_03_Register_With_Valid_Information() {
		log.info("Case_03_Register - Step 01: Open 'Register' page");
		userRegisterPage.refreshCurrentPage(driver);
		
		log.info("Case_03_Register - Step 02: sendKey to 'Firt name' textbox with the value is '" + DataRegister.FIRSTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.FIRSTNAME, "FirstName");
		
		log.info("Case_03_Register - Step 03: sendKey to 'Last name' textbox with the value is '" + DataRegister.LASTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.LASTNAME, "LastName");
		
		log.info("Case_03_Register - Step 04: sendKey to 'Email' textbox with the value is '" + DataRegister.EMAIL_ADDRESS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.EMAIL_ADDRESS, "Email");
		
		log.info("Case_03_Register - Step 05: sendKey to 'Password' textbox with the value is '" + DataRegister.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.PASSWORD, "Password");
		
		log.info("Case_03_Register - Step 06: sendKey to 'Confirm Password' textbox with the value is '" + DataRegister.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.PASSWORD, "ConfirmPassword");
		
		log.info("Case_03_Register - Step 07: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");
		
		log.info("Case_03_Register - Step 08: Verify 'Your registration completed' is displayed");
		verifyTrue(userRegisterPage.verifySuccessMessageRegisterDisplayed(driver));
		
	}
	
	@Test
	public void Case_04_Register_With_An_Existing_Email() {
		log.info("Case_04_Register - Step 01: Click to 'Register' link ");
		userRegisterPage.clickToLinkByText(driver, "Register");
		
		log.info("Case_04_Register - Step 02: sendKey to 'Firt name' textbox with the value is '" + DataRegister.FIRSTNAME + "'");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.FIRSTNAME, "FirstName");
		
		log.info("Case_04_Register - Step 03: sendKey to 'Last name' textbox with the value is '" + DataRegister.LASTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.LASTNAME, "LastName");
		
		log.info("Case_04_Register - Step 04: sendKey to 'Email' textbox with the value is '" + DataRegister.EMAIL_ADDRESS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.EMAIL_ADDRESS, "Email");
		
		log.info("Case_04_Register - Step 05: sendKey to 'Password' textbox with the value is '" + DataRegister.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.PASSWORD, "Password");
		
		log.info("Case_04_Register - Step 06: sendKey to 'Confirm Password' textbox with the value is '" + DataRegister.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.PASSWORD, "ConfirmPassword");
		
		log.info("Case_04_Register - Step 07: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");
		
		log.info("Case_04_Register - Step 08: Verify 'The specified email already exists' is displayed");
		verifyTrue(userRegisterPage.verifyMessageEmailAlreadyExistDisplayed(driver));
	}
	@Test
	public void Case_05_Register_With_A_Password_Less_Than_6_Characters() {
		log.info("Case_05_Register - Step 01: Click to 'Register' link ");
		userRegisterPage.clickToLinkByText(driver, "Register");
		
		log.info("Case_05_Register - Step 02: sendKey to 'Firt name' textbox with the value is '" + DataRegister.FIRSTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.FIRSTNAME, "FirstName");
		
		log.info("Case_05_Register - Step 03: sendKey to 'Last name' textbox with the value is '" + DataRegister.LASTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.LASTNAME, "LastName");
		
		log.info("Case_05_Register - Step 04: sendKey to 'Email' textbox with the value is '" + DataRegister.EMAIL_ADDRESS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.EMAIL_ADDRESS, "Email");
		
		log.info("Case_05_Register - Step 05: sendKey to 'Password' textbox with the value is '" + DataRegister.PASSWORD_LESS_THAN_6_CHARACTERS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.PASSWORD_LESS_THAN_6_CHARACTERS, "Password");
		
		log.info("Case_05_Register - Step 06: sendKey to 'Confirm Password' textbox with the value is '" + DataRegister.PASSWORD_LESS_THAN_6_CHARACTERS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.PASSWORD_LESS_THAN_6_CHARACTERS, "ConfirmPassword");
		
		log.info("Case_05_Register - Step 07: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");
		
		log.info("Case_05_Register - Step 08: Verify 'Password must meet the following rules:must have at least 6 characters' is displayed");
		verifyEquals(userRegisterPage.getTextAtMessageWarning(driver, "Password-error"), "Password must meet the following rules:\nmust have at least 6 characters");
		
	}
	
	@Test
	public void Case_06_Register_With_Confirm_Password_Different_Password() {
		log.info("Case_06_Register - Step 01: Click to 'Register' link ");
		userRegisterPage.clickToLinkByText(driver, "Register");
		
		log.info("Case_06_Register - Step 02: sendKey to 'Firt name' textbox with the value is '" + DataRegister.FIRSTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.FIRSTNAME, "FirstName");
		
		log.info("Case_06_Register - Step 03: sendKey to 'Last name' textbox with the value is '" + DataRegister.LASTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.LASTNAME, "LastName");
		
		log.info("Case_06_Register - Step 04: sendKey to 'Email' textbox with the value is '" + DataRegister.EMAIL_ADDRESS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.EMAIL_ADDRESS, "Email");
		
		log.info("Case_06_Register - Step 05: sendKey to 'Password' textbox with the value is '" + DataRegister.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.PASSWORD, "Password");
		
		log.info("Case_06_Register - Step 06: sendKey to 'Confirm Password' textbox with the value is '" + DataRegister.DIFFERENT_PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataRegister.DIFFERENT_PASSWORD, "ConfirmPassword");
		
		log.info("Case_06_Register - Step 07: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");
		
		log.info("Case_06_Register - Step 08: Verify 'The password and confirmation password do not match.' under 'Confirm Password' textbox is displayed");
		verifyTrue(userRegisterPage.verifyErrorMessageDisplayed(driver, "ConfirmPassword-error"));
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;

}
