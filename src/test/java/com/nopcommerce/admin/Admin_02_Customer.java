package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import dataNopcommerce.User.DataCommons.DataAdminCustomer;
import pageObjectNopcommerceAdmin.AdminAddNewCustomerPageObject;
import pageObjectNopcommerceAdmin.AdminCustomerPageObject;
import pageObjectNopcommerceAdmin.AdminEditCustomerDetailsPageObject;
import pageObjectNopcommerceAdmin.AdminHomePageObject;
import pageObjectNopcommerceAdmin.AdminLoginPageObject;
import pageObjectNopcommerceAdmin.AdminSubCustomerPageObject;
import pageObjectNopcommerceAdmin.PageGeneratorManager;
import pageUIs.Nopcommerce.Admin.AdminEditCustomerDetailsPageUIs;

public class Admin_02_Customer extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Navigate to 'Home Page'");
		driver = getBrowserDriver(browserName, appUrl);
		adminLoginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Click to 'LOG IN' button");
		adminLoginPage.clickToButtonByText(driver, "Log in");
		adminHomePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-Condition - Step 03: Click to 'Catomer' icon");
		adminHomePage.clickToIconInAdminPage(driver, "nav-icon far fa-user");
		adminCustomerPage = PageGeneratorManager.getCustomerPage(driver);
		
		log.info("Pre-Condition - Step 04: Click to 'Customers' link");
		adminCustomerPage.clickToMenuInAdminPage(driver, " Customers");
		adminSubCustomer = PageGeneratorManager.getSubCustomerPage(driver);
		
		
		

	}

	@Test
	public void Case_01_Create_New_Customer() {
		log.info("Case_01_Create - Step 01: Click to 'Add new' button");
		adminSubCustomer.clickToButtonInAdminPageByClass(driver, "btn btn-primary");
		adminAddNewCustomerPage = PageGeneratorManager.getAddNewCustomerPage(driver);
		
		log.info("Case_01_Create - Step 02: Sendkey to 'Email' textbox with value is '"+ DataAdminCustomer.EMAIL_ADDRESS +"'");
		adminAddNewCustomerPage.sendKeyToTextbox(driver, DataAdminCustomer.EMAIL_ADDRESS, "Email");
		
		log.info("Case_01_Create - Step 03: Sendkey to 'Password' textbox with value is '"+ DataAdminCustomer.PASSWORD +"'");
		adminAddNewCustomerPage.sendKeyToTextbox(driver, DataAdminCustomer.PASSWORD, "Password");
		
		log.info("Case_01_Create - Step 04: Sendkey to 'First name' textbox with value is '"+ DataAdminCustomer.FIRSTNAME +"'");
		adminAddNewCustomerPage.sendKeyToTextbox(driver, DataAdminCustomer.FIRSTNAME, "FirstName");
		
		log.info("Case_01_Create - Step 05: Sendkey to 'Last name' textbox with value is '"+ DataAdminCustomer.LASTNAME +"'");
		adminAddNewCustomerPage.sendKeyToTextbox(driver, DataAdminCustomer.LASTNAME, "LastName");
		
		log.info("Case_01_Create - Step 06: Click to 'Male' checkbox");
		adminAddNewCustomerPage.clickToCheckbox(driver, "Gender_Male");
		
		log.info("Case_01_Create - Step 07: Sendkey to 'Date of birth' textbox with value is '"+ DataAdminCustomer.DATE_OF_BIRTH +"'");
		adminAddNewCustomerPage.sendKeyToTextbox(driver, DataAdminCustomer.DATE_OF_BIRTH, "DateOfBirth");
		
		log.info("Case_01_Create - Step 08: Sendkey to 'Company name' textbox with value is '"+ DataAdminCustomer.COMPANY_NAME +"'");
		adminAddNewCustomerPage.sendKeyToTextbox(driver, DataAdminCustomer.COMPANY_NAME, "Company");
		
		log.info("Case_01_Create - Step 09: Select in 'Customer roles' dropdown lis with value is '"+ DataAdminCustomer.CUSTOMER_ROLES +"'");
		adminAddNewCustomerPage.deleteAttributeInCustomerRoles(driver);
		adminAddNewCustomerPage.selectToAttributeInCustomerRoles(driver, DataAdminCustomer.CUSTOMER_ROLES);
		
		log.info("Case_01_Create - Step 10: Sendkey to 'Admin comment' textbox with value is '"+ DataAdminCustomer.ADMIN_COMMENT +"'");
		adminAddNewCustomerPage.sendkeyToAdminCommentTextbox(driver, DataAdminCustomer.ADMIN_COMMENT);
		
		log.info("Case_01_Create - Step 11: Click to 'Save and Continue Edit'");
		adminAddNewCustomerPage.clickToSaveAndContinueEditButton(driver);
		adminEditCustomerDetails = PageGeneratorManager.getEditCustomerDetailsPage(driver);
		
		log.info("Case_01_Create - Step 11: Verify 'The new customer has been added successfully.' is displayed");
		verifyTrue(adminEditCustomerDetails.isMessageAddedSuccess(driver));
		
		log.info("Case_01_Create - Step 12: Verify 'Email' textbox is displayed with value is '"+ DataAdminCustomer.EMAIL_ADDRESS +"'");
		verifyEquals(adminEditCustomerDetails.getValueInTextbox(driver, "Email"), DataAdminCustomer.EMAIL_ADDRESS);
		
		log.info("Case_01_Create - Step 13: Verify 'First name' textbox is displayed with value is '"+ DataAdminCustomer.FIRSTNAME +"'");
		verifyEquals(adminEditCustomerDetails.getValueInTextbox(driver, "FirstName"), DataAdminCustomer.FIRSTNAME);
		
		log.info("Case_01_Create - Step 14: Verify 'LastName' textbox is displayed with value is '"+ DataAdminCustomer.LASTNAME +"'");
		verifyEquals(adminEditCustomerDetails.getValueInTextbox(driver, "LastName"), DataAdminCustomer.LASTNAME); 
		
		log.info("Case_01_Create - Step 15: Verify 'Date of birth' textbox is displayed with value is '"+ DataAdminCustomer.DATE_OF_BIRTH +"'");
		verifyEquals(adminEditCustomerDetails.getValueInTextbox(driver, "DateOfBirth"), DataAdminCustomer.DATE_OF_BIRTH);
		
		log.info("Case_01_Create - Step 16: Verify 'Company name' textbox is displayed with value is '"+ DataAdminCustomer.COMPANY_NAME +"'");
		verifyEquals(adminEditCustomerDetails.getValueInTextbox(driver, "Company"), DataAdminCustomer.COMPANY_NAME);
		
		log.info("Case_01_Create - Step 17: Verify 'Customer roles' dropdown list is displayed with value is '"+ DataAdminCustomer.CUSTOMER_ROLES +"'");
		verifyTrue(adminEditCustomerDetails.isValueInCustomerRolesDisplayed(driver, DataAdminCustomer.CUSTOMER_ROLES));
		
		log.info("Case_01_Create - Step 18: Verify 'Active' checkbox is selected");
		adminEditCustomerDetails.checkToDefaultCheckBoxRadio(driver, AdminEditCustomerDetailsPageUIs.ACTIVE_CHECKBOX);
		
		log.info("Case_01_Create - Step 19: Verify 'Admin comment' textbox is displayed with value is '"+ DataAdminCustomer.ADMIN_COMMENT +"'");
		verifyEquals(adminEditCustomerDetails.getTextInAdminComentTextbox(driver), DataAdminCustomer.ADMIN_COMMENT);
		
		log.info("Case_01_Create - Step 20: Click to 'back to customer list' button ");
		adminEditCustomerDetails.clickToLinkByText(driver, "back to customer list");
		adminSubCustomer = PageGeneratorManager.getSubCustomerPage(driver);
		
		log.info("Case_01_Create - Step 21: Select in 'Customer roles' dropdown lis with value is '"+ DataAdminCustomer.CUSTOMER_ROLES +"'");
		adminSubCustomer.deleteAttributeInCustomerRoles(driver);
		adminSubCustomer.selectToAttributeInCustomerRoles(driver, DataAdminCustomer.CUSTOMER_ROLES);
		
		log.info("Case_01_Create - Step 22: Click to 'Search' button");
		adminSubCustomer.clickToButtonInAdminPage(driver, "search-customers");
		
		log.info("Case_01_Create - Step 23: Verify 'Name' is displayed with value is '"+ DataAdminCustomer.FIRSTNAME + DataAdminCustomer.LASTNAME +"'");
		verifyTrue(adminSubCustomer.isTextInformationDisplayed(driver, DataAdminCustomer.FIRSTNAME + " " + DataAdminCustomer.LASTNAME));
		
		log.info("Case_01_Create - Step 24: Verify 'Company name' is displayed with value is '"+DataAdminCustomer.COMPANY_NAME+"'");
		verifyTrue(adminSubCustomer.isTextInformationDisplayed(driver, DataAdminCustomer.COMPANY_NAME));
	}

	@Test
	public void Case_02_Search_Customer_With_Email() {
		log.info("Case_02_Search - Step 01: Refresh page");
		adminSubCustomer.refreshCurrentPage(driver);
		
		log.info("Case_02_Search - Step 02: Sendkey to 'Email' textbox with value is '"+ DataAdminCustomer.EMAIL_ADDRESS +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.EMAIL_ADDRESS, "SearchEmail");
		
		log.info("Case_02_Search - Step 03: Select in 'Customer roles' dropdown lis with value is '"+ DataAdminCustomer.CUSTOMER_ROLES +"'");
		adminSubCustomer.deleteAttributeInCustomerRoles(driver);
		adminSubCustomer.selectToAttributeInCustomerRoles(driver, DataAdminCustomer.CUSTOMER_ROLES);
		
		log.info("Case_02_Search - Step 04: Click to 'Search' button");
		adminSubCustomer.clickToButtonInAdminPage(driver, "search-customers");
		
		log.info("Case_02_Search - Step 05: Verify 'Name' is displayed with value is '"+ DataAdminCustomer.FIRSTNAME + DataAdminCustomer.LASTNAME +"'");
		verifyTrue(adminSubCustomer.isTextInformationDisplayed(driver, DataAdminCustomer.FIRSTNAME + " " + DataAdminCustomer.LASTNAME));
		
		log.info("Case_02_Search - Step 06: Verify 'Company name' is displayed with value is '"+DataAdminCustomer.COMPANY_NAME+"'");
		verifyTrue(adminSubCustomer.isTextInformationDisplayed(driver, DataAdminCustomer.COMPANY_NAME));
		
		log.info("Case_02_Search - Step 07: Verify '1-1 of 1 items' is displayed ");
		verifyEquals(adminSubCustomer.getTextInformationCard(driver, "dataTables_info"), "1-1 of 1 items");
		
	}

	@Test
	public void Case_03_Search_Customer_With_Fristname_And_Lastname() {
		log.info("Case_03_Search - Step 01: Refresh page");
		adminSubCustomer.refreshCurrentPage(driver);
		
		log.info("Case_03_Search - Step 02: Sendkey to 'First name' textbox with value is '"+ DataAdminCustomer.FIRSTNAME +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.FIRSTNAME, "SearchFirstName");
		
		log.info("Case_03_Search - Step 03: Sendkey to 'Last name' textbox with value is '"+ DataAdminCustomer.LASTNAME +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.LASTNAME, "SearchLastName");
		
		log.info("Case_03_Search - Step 04: Select in 'Customer roles' dropdown lis with value is '"+ DataAdminCustomer.CUSTOMER_ROLES +"'");
		adminSubCustomer.deleteAttributeInCustomerRoles(driver);
		adminSubCustomer.selectToAttributeInCustomerRoles(driver, DataAdminCustomer.CUSTOMER_ROLES);
		
		log.info("Case_03_Search - Step 05: Click to 'Search' button");
		adminSubCustomer.clickToButtonInAdminPage(driver, "search-customers");
		
		log.info("Case_03_Search - Step 06: Verify 'Name' is displayed with value is '"+ DataAdminCustomer.FIRSTNAME + DataAdminCustomer.LASTNAME +"'");
		verifyTrue(adminSubCustomer.isTextInformationDisplayed(driver, DataAdminCustomer.FIRSTNAME + " " + DataAdminCustomer.LASTNAME));
		
		log.info("Case_03_Search - Step 07: Verify 'Company name' is displayed with value is '"+DataAdminCustomer.COMPANY_NAME+"'");
		verifyTrue(adminSubCustomer.isTextInformationDisplayed(driver, DataAdminCustomer.COMPANY_NAME));
		
		log.info("Case_03_Search - Step 08: Verify '1-1 of 1 items' is displayed ");
		verifyEquals(adminSubCustomer.getTextInformationCard(driver, "dataTables_info"), "1-1 of 1 items");
	}

	@Test
	public void Case_04__Search_With_Customer_Vs_Full_Data() {
		log.info("Case_04_Search - Step 01: Refresh page");
		adminSubCustomer.refreshCurrentPage(driver);
		
		log.info("Case_04_Search - Step 02: Sendkey to 'Email' textbox with value is '"+ DataAdminCustomer.EMAIL_ADDRESS +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.EMAIL_ADDRESS, "SearchEmail");
		
		log.info("Case_04_Search - Step 03: Sendkey to 'First name' textbox with value is '"+ DataAdminCustomer.FIRSTNAME +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.FIRSTNAME, "SearchFirstName");
		
		log.info("Case_04_Search - Step 04: Sendkey to 'Last name' textbox with value is '"+ DataAdminCustomer.LASTNAME +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.LASTNAME, "SearchLastName");
		
		log.info("Case_04_Search - Step 05: Select '9' in 'Month' dropdown list");
		adminSubCustomer.selectInDropDownList(driver, "9", "SearchMonthOfBirth");
		
		log.info("Case_04_Search - Step 06: Select '1' in 'Day' dropdown list");
		adminSubCustomer.selectInDropDownList(driver, "1", "SearchDayOfBirth");
		
		log.info("Case_04_Search - Step 07: Sendkey to 'Company name' textbox with value is '"+ DataAdminCustomer.COMPANY_NAME +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.COMPANY_NAME, "SearchCompany");
		
		log.info("Case_04_Search - Step 08: Select in 'Customer roles' dropdown lis with value is '"+ DataAdminCustomer.CUSTOMER_ROLES +"'");
		adminSubCustomer.deleteAttributeInCustomerRoles(driver);
		adminSubCustomer.selectToAttributeInCustomerRoles(driver, DataAdminCustomer.CUSTOMER_ROLES);
		
		log.info("Case_04_Search - Step 09: Click to 'Search' button");
		adminSubCustomer.clickToButtonInAdminPage(driver, "search-customers");
		
		log.info("Case_04_Search - Step 10: Verify 'Name' is displayed with value is '"+ DataAdminCustomer.FIRSTNAME + DataAdminCustomer.LASTNAME +"'");
		verifyTrue(adminSubCustomer.isTextInformationDisplayed(driver, DataAdminCustomer.FIRSTNAME + " " + DataAdminCustomer.LASTNAME));
		
		log.info("Case_04_Search - Step 11: Verify 'Company name' is displayed with value is '"+DataAdminCustomer.COMPANY_NAME+"'");
		verifyTrue(adminSubCustomer.isTextInformationDisplayed(driver, DataAdminCustomer.COMPANY_NAME));
		
		log.info("Case_04_Search - Step 12: Verify '1-1 of 1 items' is displayed ");
		verifyEquals(adminSubCustomer.getTextInformationCard(driver, "dataTables_info"), "1-1 of 1 items");
	}

	@Test
	public void Case_05_Edit_Customer() {
		log.info("Case_05_Edit_Customer - Step 01: Refresh page");
		adminSubCustomer.refreshCurrentPage(driver);
		
		log.info("Case_05_Edit_Customer - Step 02: Sendkey to 'Email' textbox with value is '"+ DataAdminCustomer.EMAIL_ADDRESS +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.EMAIL_ADDRESS, "SearchEmail");
		
		log.info("Case_05_Edit_Customer - Step 03: Sendkey to 'First name' textbox with value is '"+ DataAdminCustomer.FIRSTNAME +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.FIRSTNAME, "SearchFirstName");
		
		log.info("Case_05_Edit_Customer - Step 04: Sendkey to 'Last name' textbox with value is '"+ DataAdminCustomer.LASTNAME +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.LASTNAME, "SearchLastName");
		
		log.info("Case_05_Edit_Customer - Step 05: Select '9' in 'Month' dropdown list");
		adminSubCustomer.selectInDropDownList(driver, "9", "SearchMonthOfBirth");
		
		log.info("Case_05_Edit_Customer - Step 06: Select '1' in 'Day' dropdown list");
		adminSubCustomer.selectInDropDownList(driver, "1", "SearchDayOfBirth");
		
		log.info("Case_05_Edit_Customer - Step 07: Sendkey to 'Company name' textbox with value is '"+ DataAdminCustomer.COMPANY_NAME +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.COMPANY_NAME, "SearchCompany");
		
		log.info("Case_05_Edit_Customer - Step 08: Select in 'Customer roles' dropdown lis with value is '"+ DataAdminCustomer.CUSTOMER_ROLES +"'");
		adminSubCustomer.deleteAttributeInCustomerRoles(driver);
		adminSubCustomer.selectToAttributeInCustomerRoles(driver, DataAdminCustomer.CUSTOMER_ROLES);
		
		log.info("Case_05_Edit_Customer - Step 09: Click to 'Search' button");
		adminSubCustomer.clickToButtonInAdminPage(driver, "search-customers");
		
		log.info("Case_05_Edit_Customer - Step 10: Click to 'Edit' button");
		adminSubCustomer.clickToIconInAdminPage(driver, "fas fa-pencil-alt");
		adminEditCustomerDetails = PageGeneratorManager.getEditCustomerDetailsPage(driver);
		
		log.info("Case_05_Edit_Customer - Step 11: Sendkey to 'Email' textbox with value is '"+ DataAdminCustomer.EDIT_EMAIL_ADDRESS +"'");
		adminEditCustomerDetails.sendKeyToTextbox(driver, DataAdminCustomer.EDIT_EMAIL_ADDRESS, "Email");
		
		log.info("Case_05_Edit_Customer - Step 12: Sendkey to 'First name' textbox with value is '"+ DataAdminCustomer.EDIT_FIRSTNAME +"'");
		adminEditCustomerDetails.sendKeyToTextbox(driver, DataAdminCustomer.EDIT_FIRSTNAME, "FirstName");
		
		log.info("Case_05_Edit_Customer - Step 13: Sendkey to 'Last name' textbox with value is '"+ DataAdminCustomer.EDIT_LASTNAME +"'");
		adminEditCustomerDetails.sendKeyToTextbox(driver, DataAdminCustomer.EDIT_LASTNAME, "LastName");

		log.info("Case_05_Edit_Customer - Step 14: Select in 'Date of birth' textbox is displayed with value is '"+ DataAdminCustomer.EDIT_DATE_OF_BIRTH +"'");
		adminEditCustomerDetails.sendKeyToTextbox(driver, DataAdminCustomer.EDIT_DATE_OF_BIRTH, "DateOfBirth");
		
		log.info("Case_05_Edit_Customer - Step 15: Sendkey 'Company name' textbox is displayed with value is '"+ DataAdminCustomer.EDIT_COMPANY_NAME +"'");
		adminEditCustomerDetails.sendKeyToTextbox(driver, DataAdminCustomer.EDIT_COMPANY_NAME, "Company");
		
		log.info("Case_05_Edit_Customer - Step 16: Sendkey to 'Admin comment' textbox with value is '"+ DataAdminCustomer.EDIT_ADMIN_COMMENT +"'");
		adminEditCustomerDetails.sendkeyToAdminCommentTextbox(driver, DataAdminCustomer.EDIT_ADMIN_COMMENT);
		
		log.info("Case_05_Edit_Customer - Step 17: Click to 'Save' button");
		adminEditCustomerDetails.clickToButtonInAdminPageByName(driver, "save");
		adminSubCustomer = PageGeneratorManager.getSubCustomerPage(driver);
		
		log.info("Case_05_Edit_Customer - Step 18: Verify 'The customer has been updated successfully.' is displayed");
		verifyTrue(adminSubCustomer.isMessageAddedSuccess(driver));
		
		log.info("Case_05_Edit_Customer - Step 19: Sendkey to 'Email' textbox with value is '"+ DataAdminCustomer.EDIT_EMAIL_ADDRESS +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.EDIT_EMAIL_ADDRESS, "SearchEmail");
		
		log.info("Case_05_Edit_Customer - Step 20: Sendkey to 'First name' textbox with value is '"+ DataAdminCustomer.EDIT_FIRSTNAME +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.EDIT_FIRSTNAME, "SearchFirstName");
		
		log.info("Case_05_Edit_Customer - Step 21: Sendkey to 'Last name' textbox with value is '"+ DataAdminCustomer.EDIT_LASTNAME +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.EDIT_LASTNAME, "SearchLastName");
		
		log.info("Case_05_Edit_Customer - Step 22: Select '1' in 'Month' dropdown list");
		adminSubCustomer.selectInDropDownList(driver, "9", "SearchMonthOfBirth");
		
		log.info("Case_05_Edit_Customer - Step 23: Select '9' in 'Day' dropdown list");
		adminSubCustomer.selectInDropDownList(driver, "1", "SearchDayOfBirth");
		
		log.info("Case_05_Edit_Customer - Step 24: Sendkey to 'Company name' textbox with value is '"+ DataAdminCustomer.EDIT_COMPANY_NAME +"'");
		adminSubCustomer.sendKeyToTextbox(driver, DataAdminCustomer.EDIT_COMPANY_NAME, "SearchCompany");
		
		log.info("Case_05_Edit_Customer - Step 25: Select in 'Customer roles' dropdown lis with value is '"+ DataAdminCustomer.CUSTOMER_ROLES +"'");
		adminSubCustomer.deleteAttributeInCustomerRoles(driver);
		adminSubCustomer.selectToAttributeInCustomerRoles(driver, DataAdminCustomer.CUSTOMER_ROLES);
		
		log.info("Case_05_Edit_Customer - Step 26: Click to 'Search' button");
		adminSubCustomer.clickToButtonInAdminPage(driver, "search-customers");
		
		log.info("Case_05_Edit_Customer - Step 27: Verify 'Name' is displayed with value is '"+ DataAdminCustomer.EDIT_FIRSTNAME + DataAdminCustomer.EDIT_LASTNAME +"'");
		verifyTrue(adminSubCustomer.isTextInformationDisplayed(driver, DataAdminCustomer.EDIT_FIRSTNAME + " " + DataAdminCustomer.EDIT_LASTNAME));
		
		log.info("Case_05_Edit_Customer - Step 28: Verify 'Company name' is displayed with value is '"+DataAdminCustomer.EDIT_COMPANY_NAME+"'");
		verifyTrue(adminSubCustomer.isTextInformationDisplayed(driver, DataAdminCustomer.EDIT_COMPANY_NAME));
		//bug not results displayed
	}
	@Test
	public void Case_06_Add_New_Address_In_Cutomer_Detail() {
		
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private AdminHomePageObject adminHomePage;
	private AdminLoginPageObject adminLoginPage;
	private AdminCustomerPageObject adminCustomerPage;
	private AdminSubCustomerPageObject adminSubCustomer;
	private AdminAddNewCustomerPageObject adminAddNewCustomerPage;
	private AdminEditCustomerDetailsPageObject adminEditCustomerDetails;

}
