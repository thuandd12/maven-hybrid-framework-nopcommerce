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
import pageObjectNopcommerceAdmin.AdminHomePageObject;
import pageObjectNopcommerceAdmin.AdminLoginPageObject;
import pageObjectNopcommerceAdmin.AdminSubCustomerPageObject;
import pageObjectNopcommerceAdmin.PageGeneratorManager;
import pageUIs.Nopcommerce.Admin.AdminAddNewCustomerPageUIs;

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
		adminAddNewCustomerPage.sleepInsecond(5);
		
		adminAddNewCustomerPage.selectToAttributeInCustomerRoles(driver, DataAdminCustomer.CUSTOMER_ROLES);
		adminAddNewCustomerPage.sleepInsecond(5);
		
		
		log.info("Case_01_Create - Step 10: Sendkey to 'Admin comment' textbox with value is '"+ DataAdminCustomer.ADMIN_COMMENT +"'");
		adminAddNewCustomerPage.sendkeyToAdminCommentTextbox(driver, DataAdminCustomer.ADMIN_COMMENT);
		
		log.info("Case_01_Create - Step 11: Click to 'Save and Continue Edit'");
		adminAddNewCustomerPage.clickToSaveAndContinueEditButton(driver);
		adminCustomerPage = PageGeneratorManager.getCustomerPage(driver);
		
		log.info("Case_01_Create - Step 11: Verify 'The new customer has been added successfully.' is displayed");
		adminCustomerPage.getTextInformationCard(driver, "alert alert-success alert-dismissable");
		verifyEquals(adminCustomerPage.getTextInformationCard(driver, "alert alert-success alert-dismissable"), "The new customer has been added successfully.");
	}

	@Test
	public void Case_02_Search_With_Product_Name_Parent_Catefory_Unchecked() {
		
	}

	@Test
	public void Case_03_Search_With_Product_Name_Parent_Catefory_Checked() {

	}

	@Test
	public void Case_04__Search_With_Product_Name_Child_Category() {
		
	}

	@Test
	public void Case_05_Search_With_Product_Name_Manufacturer() {
	}
	@Test
	public void Case_06_Go_Directly_To_Product_SKU() {
	}

	//@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private AdminHomePageObject adminHomePage;
	private AdminLoginPageObject adminLoginPage;
	private AdminCustomerPageObject adminCustomerPage;
	private AdminSubCustomerPageObject adminSubCustomer;
	private AdminAddNewCustomerPageObject adminAddNewCustomerPage;
	

}
