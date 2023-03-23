package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import dataNopcommerce.User.DataCommons.DataMyAccount;
import pageObjectNopcommerceUser.PageGeneratorManager;
import pageObjectNopcommerceUser.UserCustomerInfoPageObject;
import pageObjectNopcommerceUser.UserHomePageObject;
import pageObjectNopcommerceUser.UserLoginPageObject;
import pageObjectNopcommerceUser.UserRegisterPageObject;

public class User_03_My_Account extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Navigate to 'Home Page'");
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-Condition - Step 02: Open 'Register' page");
		userRegisterPage = PageGeneratorManager.getRegisterPage(driver);
		userRegisterPage.clickToLinkByText(driver, "Register");
		
		log.info("Pre-Condition - Step 03: sendKey to 'Firt name' textbox with the value is '" + DataMyAccount.FIRSTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataMyAccount.FIRSTNAME, "FirstName");
		
		log.info("Pre-Condition - Step 04: sendKey to 'Last name' textbox with the value is '" + DataMyAccount.LASTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataMyAccount.LASTNAME, "LastName");
		
		log.info("Pre-Condition - Step 05: sendKey to 'Email' textbox with the value is '" + DataMyAccount.EMAIL_ADDRESS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataMyAccount.EMAIL_ADDRESS, "Email");
		
		log.info("Pre-Condition - Step 06: sendKey to 'Password' textbox with the value is '" + DataMyAccount.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataMyAccount.PASSWORD, "Password");
		
		log.info("Pre-Condition - Step 07: sendKey to 'Confirm Password' textbox with the value is '" + DataMyAccount.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataMyAccount.PASSWORD, "ConfirmPassword");
		
		log.info("Pre-Condition - Step 08: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");
		
		log.info("Pre-Condition - Step 09: Verify 'Your registration completed' is displayed");
		verifyTrue(userRegisterPage.verifySuccessMessageRegisterDisplayed(driver));
		
		log.info("Pre-Condition - Step 10: Click to 'Log in' link");
		userRegisterPage.clickToLinkByText(driver, "Log in");
		
		log.info("Pre-Condition - Step 11: Sendkey to 'Email' textbox with value is '" + DataMyAccount.EMAIL_ADDRESS + "'");
		userLoginPage = PageGeneratorManager.getLoginPage(driver);
		userLoginPage.sendKeyToTextbox(driver,DataMyAccount.EMAIL_ADDRESS ,"Email");
		
		log.info("Pre-Condition - Step 12: Sendkey to 'Password' textbox with value is '" + DataMyAccount.PASSWORD + "'");
		userLoginPage.sendKeyToTextbox(driver,DataMyAccount.PASSWORD ,"Password");
		
		log.info("Pre-Condition - Step 13: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Pre-Condition - Step 14: Verify 'My account' link displayed'");
		verifyTrue(userHomePage.isLinkDisplayed(driver, "My account"));
		
	}

	@Test
	public void Case_01_Customer_Info() {
		log.info("Case_01_Customer_Info - Step 01: Click to 'My account' link");
		userHomePage.clickToLinkByText(driver, "My account");
		userCustomerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);
		
		log.info("Case_01_Customer_Info - Step 02: Click to 'Female' radio button");
		userCustomerInfoPage.clickToRadioButton(driver, "gender-female");
		
		log.info("Case_01_Customer_Info - Step 03: Sendkey to 'First name' textbox with value is ' " + DataMyAccount.FIRSTNAME_UPDATE + "'");
		userCustomerInfoPage.sendKeyToTextbox(driver, DataMyAccount.FIRSTNAME_UPDATE, "FirstName");
		
		
		log.info("Case_01_Customer_Info - Step 04: Sendkey to 'Last name' textbox with value is ' " + DataMyAccount.LASTNAME_UPDATE + "'");
		userCustomerInfoPage.sendKeyToTextbox(driver, DataMyAccount.LASTNAME_UPDATE, "LastName");
		
		log.info("Case_01_Customer_Info - Step 05: Select in 'Day' dropdown list with value is ' " + DataMyAccount.DAY + "'");
		userCustomerInfoPage.selectInDropDownList(driver, DataMyAccount.DAY, "DateOfBirthDay");
		
		log.info("Case_01_Customer_Info - Step 06: Select in 'Month' dropdown list with value is ' " + DataMyAccount.MONTH + "'");
		userCustomerInfoPage.selectInDropDownList(driver, DataMyAccount.MONTH, "DateOfBirthMonth");
		
		log.info("Case_01_Customer_Info - Step 07: Select in 'Day' dropdown list with value is ' " + DataMyAccount.YEAR + "'");
		userCustomerInfoPage.selectInDropDownList(driver, DataMyAccount.YEAR, "DateOfBirthYear");
		
		log.info("Case_01_Customer_Info - Step 08: Sendkey to 'Email' textbox with value is ' " + DataMyAccount.EMAIL_ADDRESS_UPDATE + "'");
		userCustomerInfoPage.sendKeyToTextbox(driver, DataMyAccount.EMAIL_ADDRESS_UPDATE, "Email");
		
		log.info("Case_01_Customer_Info - Step 09: Sendkey to 'Company Name' textbox with value is ' " + DataMyAccount.COMPANY_NAME + "'");
		userCustomerInfoPage.sendKeyToTextbox(driver, DataMyAccount.COMPANY_NAME, "Company");
		
		log.info("Case_01_Customer_Info - Step 10: Click to 'SAVE' button");
		userCustomerInfoPage.clickToButtonByText(driver, "Save");
		
		log.info("Case_01_Customer_Info - Step 11: Verify 'The customer info has been updated successfully.' is displayed");
		verifyEquals(userCustomerInfoPage.getTextUpdatedSuccessMessage(driver), "The customer info has been updated successfully.");
		
		log.info("Case_01_Customer_Info - Step 12: Verify 'Female' radio button is updated");
		userCustomerInfoPage.clickToRadioButton(driver, "gender-female");
		
		log.info("Case_01_Customer_Info - Step 13: Verify 'First name' textbox updated with value is '"+ DataMyAccount.FIRSTNAME_UPDATE +"' ");
		verifyEquals(userCustomerInfoPage.getValueTextbox(driver, "value", "FirstName"),DataMyAccount.FIRSTNAME_UPDATE);
		
		log.info("Case_01_Customer_Info - Step 14: Verify 'Last name' textbox updated with value is '"+ DataMyAccount.LASTNAME_UPDATE +"' ");
		verifyEquals(userCustomerInfoPage.getValueTextbox(driver, "value", "LastName"),DataMyAccount.LASTNAME_UPDATE);
		
		log.info("Case_01_Customer_Info - Step 15: Verify 'Email' textbox updated with value is '"+ DataMyAccount.EMAIL_ADDRESS_UPDATE +"' ");
		verifyEquals(userCustomerInfoPage.getValueTextbox(driver, "value", "Email"),DataMyAccount.EMAIL_ADDRESS_UPDATE);
		
		log.info("Case_01_Customer_Info - Step 16: Verify 'Company name' textbox updated with value is '"+ DataMyAccount.COMPANY_NAME +"' ");
		verifyEquals(userCustomerInfoPage.getValueTextbox(driver, "value", "Company"),DataMyAccount.COMPANY_NAME);
		
		log.info("Case_01_Customer_Info - Step 17: Verify 'Day' dropdown updated with value is '"+ DataMyAccount.DAY +"' ");
		verifyEquals(userCustomerInfoPage.getTextInDropdownListFirstSelected(driver, "DateOfBirthDay"), DataMyAccount.DAY);
		
		log.info("Case_01_Customer_Info - Step 18: Verify 'Month' dropdown updated with value is '"+ DataMyAccount.MONTH +"' ");
		verifyEquals(userCustomerInfoPage.getTextInDropdownListFirstSelected(driver, "DateOfBirthMonth"), DataMyAccount.MONTH);
		
		log.info("Case_01_Customer_Info - Step 19: Verify 'Year' dropdown updated with value is '"+ DataMyAccount.YEAR +"' ");
		verifyEquals(userCustomerInfoPage.getTextInDropdownListFirstSelected(driver, "DateOfBirthYear"), DataMyAccount.YEAR);
		
		
	}

	@Test
	public void Case_02_Address() {
	}

	@Test
	public void Case_03_Change_Password() {

	}

	@Test
	public void Case_04_My_Product_Reviews() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	
}
