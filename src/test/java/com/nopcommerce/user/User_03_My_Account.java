package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import dataNopcommerce.User.DataCommons.CustomerInfor;
import dataNopcommerce.User.DataCommons.DataAddresses;
import dataNopcommerce.User.DataCommons.DataChangePassword;
import dataNopcommerce.User.DataCommons.DataMyProductReviews;
import pageObjectNopcommerceUser.PageGeneratorManager;
import pageObjectNopcommerceUser.UserAddressesPageObject;
import pageObjectNopcommerceUser.UserCustomerInfoPageObject;
import pageObjectNopcommerceUser.UserHomePageObject;
import pageObjectNopcommerceUser.UserLoginPageObject;
import pageObjectNopcommerceUser.UserMyProductReviewsPageObject;
import pageObjectNopcommerceUser.UserNotebooksPageObject;
import pageObjectNopcommerceUser.UserRegisterPageObject;
import pageUIs.commons.commonsPageUIs;

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
		
		log.info("Pre-Condition - Step 03: sendKey to 'Firt name' textbox with the value is '" + CustomerInfor.FIRSTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, CustomerInfor.FIRSTNAME, "FirstName");
		
		log.info("Pre-Condition - Step 04: sendKey to 'Last name' textbox with the value is '" + CustomerInfor.LASTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, CustomerInfor.LASTNAME, "LastName");
		
		log.info("Pre-Condition - Step 05: sendKey to 'Email' textbox with the value is '" + CustomerInfor.EMAIL_ADDRESS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, CustomerInfor.EMAIL_ADDRESS, "Email");
		
		log.info("Pre-Condition - Step 06: sendKey to 'Password' textbox with the value is '" + CustomerInfor.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, CustomerInfor.PASSWORD, "Password");
		
		log.info("Pre-Condition - Step 07: sendKey to 'Confirm Password' textbox with the value is '" + CustomerInfor.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, CustomerInfor.PASSWORD, "ConfirmPassword");
		
		log.info("Pre-Condition - Step 08: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");
		
		log.info("Pre-Condition - Step 09: Verify 'Your registration completed' is displayed");
		verifyTrue(userRegisterPage.verifySuccessMessageRegisterDisplayed(driver));
		
		log.info("Pre-Condition - Step 10: Click to 'Log in' link");
		userRegisterPage.clickToLinkByText(driver, "Log in");
		
		log.info("Pre-Condition - Step 11: Sendkey to 'Email' textbox with value is '" + CustomerInfor.EMAIL_ADDRESS + "'");
		userLoginPage = PageGeneratorManager.getLoginPage(driver);
		userLoginPage.sendKeyToTextbox(driver,CustomerInfor.EMAIL_ADDRESS ,"Email");
		
		log.info("Pre-Condition - Step 12: Sendkey to 'Password' textbox with value is '" + CustomerInfor.PASSWORD + "'");
		userLoginPage.sendKeyToTextbox(driver,CustomerInfor.PASSWORD ,"Password");
		
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
		
		log.info("Case_01_Customer_Info - Step 03: Sendkey to 'First name' textbox with value is ' " + CustomerInfor.FIRSTNAME_UPDATE + "'");
		userCustomerInfoPage.sendKeyToTextbox(driver, CustomerInfor.FIRSTNAME_UPDATE, "FirstName");
		
		log.info("Case_01_Customer_Info - Step 04: Sendkey to 'Last name' textbox with value is ' " + CustomerInfor.LASTNAME_UPDATE + "'");
		userCustomerInfoPage.sendKeyToTextbox(driver, CustomerInfor.LASTNAME_UPDATE, "LastName");
		
		log.info("Case_01_Customer_Info - Step 05: Select in 'Day' dropdown list with value is ' " + CustomerInfor.DAY + "'");
		userCustomerInfoPage.selectInDropDownList(driver, CustomerInfor.DAY, "DateOfBirthDay");
		
		log.info("Case_01_Customer_Info - Step 06: Select in 'Month' dropdown list with value is ' " + CustomerInfor.MONTH + "'");
		userCustomerInfoPage.selectInDropDownList(driver, CustomerInfor.MONTH, "DateOfBirthMonth");
		
		log.info("Case_01_Customer_Info - Step 07: Select in 'Day' dropdown list with value is ' " + CustomerInfor.YEAR + "'");
		userCustomerInfoPage.selectInDropDownList(driver, CustomerInfor.YEAR, "DateOfBirthYear");
		
		log.info("Case_01_Customer_Info - Step 08: Sendkey to 'Email' textbox with value is ' " + CustomerInfor.EMAIL_ADDRESS_UPDATE + "'");
		userCustomerInfoPage.sendKeyToTextbox(driver, CustomerInfor.EMAIL_ADDRESS_UPDATE, "Email");
		
		log.info("Case_01_Customer_Info - Step 09: Sendkey to 'Company Name' textbox with value is ' " + CustomerInfor.COMPANY_NAME + "'");
		userCustomerInfoPage.sendKeyToTextbox(driver, CustomerInfor.COMPANY_NAME, "Company");
		
		log.info("Case_01_Customer_Info - Step 10: Click to 'SAVE' button");
		userCustomerInfoPage.clickToButtonByText(driver, "Save");
		
		log.info("Case_01_Customer_Info - Step 11: Verify 'The customer info has been updated successfully.' is displayed");
		verifyEquals(userCustomerInfoPage.getTextUpdatedSuccessMessage(driver), "The customer info has been updated successfully.");
		
		log.info("Case_01_Customer_Info - Step 12: Verify 'Female' radio button is updated");
		userCustomerInfoPage.clickToRadioButton(driver, "gender-female");
		
		log.info("Case_01_Customer_Info - Step 13: Verify 'First name' textbox updated with value is '"+ CustomerInfor.FIRSTNAME_UPDATE +"' ");
		verifyEquals(userCustomerInfoPage.getValueTextbox(driver, "value", "FirstName"),CustomerInfor.FIRSTNAME_UPDATE);
		
		log.info("Case_01_Customer_Info - Step 14: Verify 'Last name' textbox updated with value is '"+ CustomerInfor.LASTNAME_UPDATE +"' ");
		verifyEquals(userCustomerInfoPage.getValueTextbox(driver, "value", "LastName"),CustomerInfor.LASTNAME_UPDATE);
		
		log.info("Case_01_Customer_Info - Step 15: Verify 'Email' textbox updated with value is '"+ CustomerInfor.EMAIL_ADDRESS_UPDATE +"' ");
		verifyEquals(userCustomerInfoPage.getValueTextbox(driver, "value", "Email"),CustomerInfor.EMAIL_ADDRESS_UPDATE);
		
		log.info("Case_01_Customer_Info - Step 16: Verify 'Company name' textbox updated with value is '"+ CustomerInfor.COMPANY_NAME +"' ");
		verifyEquals(userCustomerInfoPage.getValueTextbox(driver, "value", "Company"),CustomerInfor.COMPANY_NAME);
		
		log.info("Case_01_Customer_Info - Step 17: Verify 'Day' dropdown updated with value is '"+ CustomerInfor.DAY +"' ");
		verifyEquals(userCustomerInfoPage.getTextInDropdownListFirstSelected(driver, "DateOfBirthDay"), CustomerInfor.DAY);
		
		log.info("Case_01_Customer_Info - Step 18: Verify 'Month' dropdown updated with value is '"+ CustomerInfor.MONTH +"' ");
		verifyEquals(userCustomerInfoPage.getTextInDropdownListFirstSelected(driver, "DateOfBirthMonth"), CustomerInfor.MONTH);
		
		log.info("Case_01_Customer_Info - Step 19: Verify 'Year' dropdown updated with value is '"+ CustomerInfor.YEAR +"' ");
		verifyEquals(userCustomerInfoPage.getTextInDropdownListFirstSelected(driver, "DateOfBirthYear"), CustomerInfor.YEAR);
		
		
	}

	@Test
	public void Case_02_Address() {
		log.info("Case_02_Address - Step 01: Open 'Addresses' link ");
		userCustomerInfoPage.clickToLinkByText(driver, "Addresses");
		userAddressesPage = PageGeneratorManager.getAddressesPage(driver);
		
		log.info("Case_02_Address - Step 02: Click to 'ADD NEW' button ");
		userAddressesPage.clickToButtonByText(driver, "Add new");
		
		log.info("Case_02_Address - Step 03: Sendkey to 'First name' textbox with value is ' " + DataAddresses.FIRSTNAME + "'");
		userAddressesPage.sendKeyToTextbox(driver, DataAddresses.FIRSTNAME, "Address_FirstName");
		
		
		log.info("Case_02_Address - Step 04: Sendkey to 'Last name' textbox with value is ' " + DataAddresses.LASTNAME + "'");
		userAddressesPage.sendKeyToTextbox(driver, DataAddresses.LASTNAME, "Address_LastName");
		
		log.info("Case_02_Address - Step 05: Sendkey to 'Email' textbox with value is ' " + DataAddresses.EMAIL_ADDRESS + "'");
		userAddressesPage.sendKeyToTextbox(driver, DataAddresses.EMAIL_ADDRESS, "Address_Email");
		
		log.info("Case_02_Address - Step 06: Sendkey to 'Company Name' textbox with value is ' " + DataAddresses.COMPANY_NAME + "'");
		userCustomerInfoPage.sendKeyToTextbox(driver, DataAddresses.COMPANY_NAME, "Address_Company");
		
		
		log.info("Case_02_Address - Step 07: Select in 'Country' dropdown list with value is ' " + DataAddresses.CONTRY + "'");
		userAddressesPage.selectInDropDownList(driver, DataAddresses.CONTRY, "Address.CountryId");
		
		log.info("Case_02_Address - Step 08: Select in 'State / province' dropdown list with value is ' " + DataAddresses.STATE_PROVINCE + "'");
		userAddressesPage.selectInDropDownList(driver, DataAddresses.STATE_PROVINCE, "Address.StateProvinceId");
		

		log.info("Case_02_Address - Step 09: Sendkey to 'City' textbox with value is ' " + DataAddresses.CITY + "'");
		userAddressesPage.sendKeyToTextbox(driver, DataAddresses.CITY, "Address_City");
		
		log.info("Case_02_Address - Step 10: Sendkey to 'Address 1' textbox with value is ' " + DataAddresses.ADDRESS_1 + "'");
		userAddressesPage.sendKeyToTextbox(driver, DataAddresses.ADDRESS_1, "Address_Address1");
		
		log.info("Case_02_Address - Step 11: Sendkey to 'Address 2' textbox with value is ' " + DataAddresses.ADDRESS_2 + "'");
		userAddressesPage.sendKeyToTextbox(driver, DataAddresses.ADDRESS_2, "Address_Address2");
		
		log.info("Case_02_Address - Step 12: Sendkey to 'Zip / postal code' textbox with value is ' " + DataAddresses.ZIP_POSTAL_CODE + "'");
		userAddressesPage.sendKeyToTextbox(driver, DataAddresses.ZIP_POSTAL_CODE, "Address_ZipPostalCode");
		
		log.info("Case_02_Address - Step 13: Sendkey to 'Phone number' textbox with value is ' " + DataAddresses.PHONE_NUMBER + "'");
		userAddressesPage.sendKeyToTextbox(driver, DataAddresses.PHONE_NUMBER, "Address_PhoneNumber");
		
		log.info("Case_02_Address - Step 14: Sendkey to 'Fax number' textbox with value is ' " + DataAddresses.FAX_NUMBER + "'");
		userAddressesPage.sendKeyToTextbox(driver, DataAddresses.FAX_NUMBER, "Address_FaxNumber");
		
		log.info("Case_02_Address - Step 15: Click to 'SAVE' button ");
		userAddressesPage.clickToButtonByText(driver, "Save");
		
		log.info("Case_02_Address - Step 16: Verify 'The customer info has been updated successfully.' is displayed");
		verifyEquals(userAddressesPage.getTextUpdatedSuccessMessage(driver), "The new address has been added successfully.");
		
		log.info("Case_02_Address - Step 17: Verify '"+ DataAddresses.FIRSTNAME + " " + DataAddresses.LASTNAME +"' is displayed");
		verifyEquals(userAddressesPage.getTextOfNameInfomation(driver, "name"), DataAddresses.FIRSTNAME + " " + DataAddresses.LASTNAME);
		
		log.info("Case_02_Address - Step 18: Verify 'Email: "+ DataAddresses.EMAIL_ADDRESS +"' is displayed");
		verifyEquals(userAddressesPage.getTextOfNameInfomation(driver, "email"), "Email: " + DataAddresses.EMAIL_ADDRESS);
		
		log.info("Case_02_Address - Step 19: Verify 'Phone number: "+ DataAddresses.PHONE_NUMBER +"' is displayed");
		verifyEquals(userAddressesPage.getTextOfNameInfomation(driver, "phone"), "Phone number: " + DataAddresses.PHONE_NUMBER);
		
		log.info("Case_02_Address - Step 20: Verify 'Fax number: "+ DataAddresses.FAX_NUMBER +"' is displayed");
		verifyEquals(userAddressesPage.getTextOfNameInfomation(driver, "fax"), "Fax number: " + DataAddresses.FAX_NUMBER);
		
		log.info("Case_02_Address - Step 21: Verify '"+ DataAddresses.COMPANY_NAME +"' is displayed");
		verifyEquals(userAddressesPage.getTextOfNameInfomation(driver, "company"), DataAddresses.COMPANY_NAME);
		
		log.info("Case_02_Address - Step 22: Verify '"+ DataAddresses.ADDRESS_1 +"' is displayed");
		verifyEquals(userAddressesPage.getTextOfNameInfomation(driver, "address1"), DataAddresses.ADDRESS_1);
		
		log.info("Case_02_Address - Step 23: Verify '"+ DataAddresses.ADDRESS_2 +"' is displayed");
		verifyEquals(userAddressesPage.getTextOfNameInfomation(driver, "address2"), DataAddresses.ADDRESS_2);
		
		log.info("Case_02_Address - Step 24: Verify '"+ DataAddresses.CITY + ", " + DataAddresses.ZIP_POSTAL_CODE +"' is displayed");
		verifyEquals(userAddressesPage.getTextOfNameInfomation(driver, "city-state-zip"), DataAddresses.CITY + ", " + DataAddresses.ZIP_POSTAL_CODE );
		
		log.info("Case_02_Address - Step 25: Verify '"+ DataAddresses.CONTRY +"' is displayed");
		verifyEquals(userAddressesPage.getTextOfNameInfomation(driver, "country"), DataAddresses.CONTRY);
		
	}

	@Test
	public void Case_03_Change_Password() {
		log.info("Case_03_Change_Password - Step 01: Click to 'Change password' link");
		userAddressesPage.clickToLinkByText(driver, "Change password");
		userChangePasswordPage = PageGeneratorManager.getChangePasswordPage(driver);
		
		log.info("Case_03_Change_Password - Step 02: Sendkey to 'Old password' textbox with value is '"+ DataChangePassword.OLD_PASSWORD +"'");
		userChangePasswordPage.sendKeyToTextbox(driver, DataChangePassword.OLD_PASSWORD, "OldPassword");
		
		log.info("Case_03_Change_Password - Step 03: Sendkey to 'New password' textbox with value is '"+ DataChangePassword.NEW_PASSWORD +"'");
		userChangePasswordPage.sendKeyToTextbox(driver, DataChangePassword.NEW_PASSWORD, "NewPassword");
		
		log.info("Case_03_Change_Password - Step 04: Sendkey to 'Confirm password' textbox with value is '"+ DataChangePassword.NEW_PASSWORD +"'");
		userChangePasswordPage.sendKeyToTextbox(driver, DataChangePassword.NEW_PASSWORD, "ConfirmNewPassword");

		log.info("Case_03_Change_Password - Step 05: Click to 'CHANGE PASSWORD' button");
		userAddressesPage.clickToButtonByText(driver, "Change password");
		
		log.info("Case_03_Change_Password - Step 06: Verify 'Password was changed' is dislplayed");
		verifyEquals(userAddressesPage.getTextUpdatedSuccessMessage(driver), "Password was changed");
		
		log.info("Case_03_Change_Password - Step 07: Back to page");
		userAddressesPage.backToPage(driver);
		userLoginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Case_03_Change_Password - Step 08: Sendkey to 'Email' textbox with value is '"+ DataAddresses.EMAIL_ADDRESS +"'");
		userLoginPage.sendKeyToTextbox(driver, DataAddresses.EMAIL_ADDRESS, "Email");
		
		log.info("Case_03_Change_Password - Step 09: Sendkey to 'Password' textbox with value is '"+ DataChangePassword.OLD_PASSWORD +"'");
		userLoginPage.sendKeyToTextbox(driver, DataChangePassword.OLD_PASSWORD, "Password");
		
		log.info("Case_03_Change_Password - Step 10: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Case_03_Change_Password - Step 11: Verify 'Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect' displayed");
		verifyEquals(userLoginPage.getTextWarningMessageUnregisteredEmail(driver), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
		
		log.info("Case_03_Change_Password - Step 12: Click to 'Log in' link");
		userLoginPage.clickToLinkByText(driver, "Log in");
		
		log.info("Case_03_Change_Password - Step 13: Sendkey to 'Email' textbox with value is '" + CustomerInfor.EMAIL_ADDRESS_UPDATE + "'");
		userLoginPage.sendKeyToTextbox(driver,CustomerInfor.EMAIL_ADDRESS_UPDATE ,"Email");
		
		log.info("Case_03_Change_Password - Step 14: Sendkey to 'Password' textbox with value is '" + DataChangePassword.NEW_PASSWORD + "'");
		userLoginPage.sendKeyToTextbox(driver,DataChangePassword.NEW_PASSWORD ,"Password");
		
		log.info("Case_03_Change_Password - Step 15: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");
		
		log.info("Case_03_Change_Password - Step 16: Verify 'My account' link displayed'");
		verifyTrue(userHomePage.isLinkDisplayed(driver, "My account"));
	}

	@Test
	public void Case_04_My_Product_Reviews() {
		log.info("Case_04_My_Product_Reviews - Step 01: Open 'Home page'");
		userHomePage.openHomePageUrl(driver);
		
		log.info("Case_04_My_Product_Reviews - Step 02: Click to 'Apple MacBook Pro 13-inch' link");
		userHomePage.clickToLinkByText(driver, "Apple MacBook Pro 13-inch");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
		log.info("Case_04_My_Product_Reviews - Step 03: Click to 'Add your review' link");
		userNotebooksPage.clickToLinkByText(driver, "Add your review");
		
		log.info("Case_04_My_Product_Reviews - Step 04: Sendkey to 'Review title' textbox");
		userNotebooksPage.sendKeyToTextbox(driver, DataMyProductReviews.REVIEW_TITLE, "AddProductReview_Title");
		
		log.info("Case_04_My_Product_Reviews - Step 05: Sendkey to 'Review text' textbox");
		userNotebooksPage.sendKeyToReviewTextTextbox(driver,DataMyProductReviews.REVIEW_TEXT);
		
		log.info("Case_04_My_Product_Reviews - Step 06: Click to 'Good' radio button");
		userNotebooksPage.clickToRadiOButtonByAriaLabel(driver, "Good");
		
		log.info("Case_04_My_Product_Reviews - Step 07: Click to 'SUBMIT REVIEW' button");
		userNotebooksPage.clickToButtonByText(driver, "Submit review");
		
		log.info("Case_04_My_Product_Reviews - Step 08: Click to 'My account' link");
		userNotebooksPage.clickToLinkByText(driver, "My account");
		
		log.info("Case_04_My_Product_Reviews - Step 09: Click to 'My product reviews' link");
		userNotebooksPage.clickToLinkByText(driver, "My product reviews");
		userMyProductReview = PageGeneratorManager.getMyProductReviewPage(driver);
		
		log.info("Case_04_My_Product_Reviews - Step 10: Verify '"+ DataMyProductReviews.REVIEW_TITLE +"' is displayed");
		verifyEquals(userMyProductReview.getTextInformationCard(driver, "review-title"), DataMyProductReviews.REVIEW_TITLE);
		
		log.info("Case_04_My_Product_Reviews - Step 11: Verify '"+ DataMyProductReviews.REVIEW_TEXT +"' is displayed");
		verifyEquals(userMyProductReview.getTextInformationCard(driver, "review-text"), DataMyProductReviews.REVIEW_TEXT);
		
		log.info("Case_04_My_Product_Reviews - Step 12: Verify 'Apple MacBook Pro 13-inch' is displayed");
		verifyTrue(userMyProductReview.isNameProductDisplayed(driver, "Apple MacBook Pro 13-inch"));
		
		log.info("Case_04_My_Product_Reviews - Step 13: Verify '"+ DataMyProductReviews.CURRENT_DAY +"' is displayed");
		verifyTrue(userMyProductReview.getCurrentDay(driver, "Apple MacBook Pro 13-inch").contains(DataMyProductReviews.CURRENT_DAY));
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
	private UserAddressesPageObject userAddressesPage;
	private UserAddressesPageObject userChangePasswordPage;
	private UserNotebooksPageObject userNotebooksPage;
	private UserMyProductReviewsPageObject userMyProductReview;
	
	
}
