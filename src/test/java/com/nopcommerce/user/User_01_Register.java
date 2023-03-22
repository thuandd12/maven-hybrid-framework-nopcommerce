package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
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
	public void Case_02_Register_With_Invalid_Data() {
		userRegisterPage.refreshCurrentPage(driver);
		
	}

	@Test
	public void Case_03_Register_With_Valid_Information() {
	}

	public void Case_04_Register_With_An_Existing_Email() {
	}

	public void Case_05_Register_With_A_Password_Less_Than_6_Characters() {
	}

	public void Case_06_Register_With_Confirm_Password_Different_Password() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;

}
