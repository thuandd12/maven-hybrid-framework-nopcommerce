package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import dataNopcommerce.User.DataCommons.DataSearchAdvancedSearch;
import pageObjectNopcommerceUser.PageGeneratorManager;
import pageObjectNopcommerceUser.UserHomePageObject;
import pageObjectNopcommerceUser.UserLoginPageObject;
import pageObjectNopcommerceUser.UserRegisterPageObject;
import pageObjectNopcommerceUser.UserSearchPageObject;

public class User_04_Search_Advanced_Search extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Navigate to 'Home Page'");
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getHomePage(driver);

		log.info("Pre-Condition - Step 02: Open 'Register' page");
		userRegisterPage = PageGeneratorManager.getRegisterPage(driver);
		userRegisterPage.clickToLinkByText(driver, "Register");

		log.info("Pre-Condition - Step 03: sendKey to 'Firt name' textbox with the value is '"
				+ DataSearchAdvancedSearch.FIRSTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.FIRSTNAME, "FirstName");

		log.info("Pre-Condition - Step 04: sendKey to 'Last name' textbox with the value is '"
				+ DataSearchAdvancedSearch.LASTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.LASTNAME, "LastName");

		log.info("Pre-Condition - Step 05: sendKey to 'Email' textbox with the value is '"
				+ DataSearchAdvancedSearch.EMAIL_ADDRESS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.EMAIL_ADDRESS, "Email");

		log.info("Pre-Condition - Step 06: sendKey to 'Password' textbox with the value is '"
				+ DataSearchAdvancedSearch.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.PASSWORD, "Password");

		log.info("Pre-Condition - Step 07: sendKey to 'Confirm Password' textbox with the value is '"
				+ DataSearchAdvancedSearch.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.PASSWORD, "ConfirmPassword");

		log.info("Pre-Condition - Step 08: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");

		log.info("Pre-Condition - Step 09: Verify 'Your registration completed' is displayed");
		verifyTrue(userRegisterPage.verifySuccessMessageRegisterDisplayed(driver));

		log.info("Pre-Condition - Step 10: Click to 'Log in' link");
		userRegisterPage.clickToLinkByText(driver, "Log in");

		log.info("Pre-Condition - Step 11: Sendkey to 'Email' textbox with value is '"+ DataSearchAdvancedSearch.EMAIL_ADDRESS + "'");
		userLoginPage = PageGeneratorManager.getLoginPage(driver);
		userLoginPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.EMAIL_ADDRESS, "Email");

		log.info("Pre-Condition - Step 12: Sendkey to 'Password' textbox with value is '"+ DataSearchAdvancedSearch.PASSWORD + "'");
		userLoginPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.PASSWORD, "Password");

		log.info("Pre-Condition - Step 13: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");

		log.info("Pre-Condition - Step 14: Verify 'My account' link displayed'");
		verifyTrue(userHomePage.isLinkDisplayed(driver, "My account"));

		log.info("Pre-Condition - Step 15: Click to 'Search' link");
		userHomePage.clickToLinkByText(driver, "Search");
		userSearchPage = PageGeneratorManager.getSearchPage(driver);

	}

	@Test
	public void Case_01_Search_With_Empty_Data() {
		log.info("Case_01_Search - Step 01: Click to 'SEARCH' button");
		userSearchPage.clickToSearchAdvancedButton(driver);

		log.info("Case_01_Search - Step 02: verify 'Search term minimum length is 3 characters' is displayed");
		verifyEquals(userSearchPage.getTextInformationCard(driver, "warning"),"Search term minimum length is 3 characters");
		
	}

	@Test
	public void Case_02_Search_With_Data_Not_Exist() {
		log.info("Case_02_Search - Step 01: Refresh 'Search' page");
		userSearchPage.refreshCurrentPage(driver);

		log.info("Case_02_Search - Step 02: Sendkey to 'Search keyword' textbox with value is'"+ DataSearchAdvancedSearch.DATA_NOT_EXIST + "' ");
		userSearchPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.DATA_NOT_EXIST, "q");

		log.info("Case_02_Search - Step 03: Click to 'SEARCH' button");
		userSearchPage.clickToSearchAdvancedButton(driver);

		log.info("Case_02_Search - Step 03: verify 'No products were found that matched your criteria.' is displayed");
		verifyEquals(userSearchPage.getTextInformationCard(driver, "no-result"),"No products were found that matched your criteria.");
	}

	@Test
	public void Case_03_Search_With_Relative_Product_Name() {
		log.info("Case_03_Search - Step 01: Refresh 'Search' page");
		userSearchPage.refreshCurrentPage(driver);

		log.info("Case_03_Search - Step 02: Sendkey to 'Search keyword' textbox with value is'"+ DataSearchAdvancedSearch.DATA_RELATIVE + "' ");
		userSearchPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.DATA_RELATIVE, "q");

		log.info("Case_03_Search - Step 03: Click to 'SEARCH' button");
		userSearchPage.clickToSearchAdvancedButton(driver);

		log.info("Case_03_Search - Step 04: verify 'Lenovo IdeaCentre 600 All-in-One PC' is displayed");
		verifyTrue(userSearchPage.isNameProductDisplayed(driver, "Lenovo IdeaCentre 600 All-in-One PC"));

		log.info("Case_03_Search - Step 05: verify 'Lenovo Thinkpad X1 Carbon Laptop' is displayed");
		verifyTrue(userSearchPage.isNameProductDisplayed(driver, "Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@Test
	public void Case_04_Search_With_Absolute_Product_Name() {
		log.info("Case_04_Search - Step 01: Refresh 'Search' page");
		userSearchPage.refreshCurrentPage(driver);

		log.info("Case_04_Search - Step 02: Sendkey to 'Search keyword' textbox with value is '"+ DataSearchAdvancedSearch.DATA_ABSOLUTO + "' ");
		userSearchPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.DATA_ABSOLUTO, "q");

		log.info("Case_04_Search - Step 03: Click to 'SEARCH' button");
		userSearchPage.clickToSearchAdvancedButton(driver);

		log.info("Case_04_Search - Step 04: verify 'Lenovo Thinkpad X1 Carbon Laptop' is displayed");
		verifyTrue(userSearchPage.isNameProductDisplayed(driver, "Lenovo Thinkpad X1 Carbon Laptop"));
	}
	@Test
	public void Case_05_Search_With_Advenced_Search_And_Parent_Categories() {
		log.info("Case_05_Search - Step 01: Refresh 'Search' page");
		userSearchPage.refreshCurrentPage(driver);
		
		log.info("Case_05_Search - Step 02: Sendkey to 'Search keyword' textbox with value is '"+ DataSearchAdvancedSearch.SEARCH_KYEWORD + "' ");
		userSearchPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.SEARCH_KYEWORD, "q");
		
		log.info("Case_05_Search - Step 03: Click to 'Advanced search' checkbox");
		userSearchPage.clickToCheckbox(driver, "advs");
		
		log.info("Case_05_Search - Step 04: Click to 'Category' dropdown list");
		userSearchPage.selectInDropDownList(driver, DataSearchAdvancedSearch.CATEGORY, "cid");
		
		log.info("Case_05_Search - Step 05: Click to 'SEARCH' button");
		userSearchPage.clickToSearchAdvancedButton(driver);
		
		log.info("Case_05_Search - Step 06: verify 'No products were found that matched your criteria.' is displayed");
		verifyEquals(userSearchPage.getTextInformationCard(driver, "no-result"),"No products were found that matched your criteria.");
	}
	@Test
	public void Case_06_Search_With_Advenced_Search_And_Sub_Categories() {
		log.info("Case_06_Search - Step 01: Refresh 'Search' page");
		userSearchPage.refreshCurrentPage(driver);
		
		log.info("Case_06_Search - Step 02: Sendkey to 'Search keyword' textbox with value is '"+ DataSearchAdvancedSearch.SEARCH_KYEWORD + "' ");
		userSearchPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.SEARCH_KYEWORD, "q");
		
		log.info("Case_06_Search - Step 03: Click to 'Advanced search' checkbox");
		userSearchPage.clickToCheckbox(driver, "advs");
		
		log.info("Case_06_Search - Step 04: Click to 'Category' dropdown list");
		userSearchPage.selectInDropDownList(driver, DataSearchAdvancedSearch.CATEGORY, "cid");
		
		log.info("Case_06_Search - Step 05: Click to 'Automatically search sub categories' checkbox");
		userSearchPage.clickToCheckbox(driver, "isc");
		
		
		log.info("Case_06_Search - Step 06: Click to 'SEARCH' button");
		userSearchPage.clickToSearchAdvancedButton(driver);
		
		log.info("Case_06_Search - Step 07: verify 'Apple MacBook Pro 13-inch' is displayed");
		verifyTrue(userSearchPage.isNameProductDisplayed(driver, "Apple MacBook Pro 13-inch"));
	}
	@Test
	public void Case_07_Search_With_Advenced_Search_And_Incorrect_Manufacturer() {
		log.info("Case_07_Search - Step 01: Refresh 'Search' page");
		userSearchPage.refreshCurrentPage(driver);
	
		log.info("Case_07_Search - Step 02: Sendkey to 'Search keyword' textbox with value is '"+ DataSearchAdvancedSearch.SEARCH_KYEWORD + "' ");
		userSearchPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.SEARCH_KYEWORD, "q");
		
		log.info("Case_07_Search - Step 03: Click to 'Advanced search' checkbox");
		userSearchPage.clickToCheckbox(driver, "advs");
		
		log.info("Case_07_Search - Step 04: Click to 'Category' dropdown list");
		userSearchPage.selectInDropDownList(driver, DataSearchAdvancedSearch.CATEGORY, "cid");
		
		log.info("Case_07_Search - Step 05: Click to 'Automatically search sub categories' checkbox");
		userSearchPage.clickToCheckbox(driver, "isc");
		
		log.info("Case_07_Search - Step 06: Click to 'Manufacturer' dropdown list");
		userSearchPage.selectInDropDownList(driver, DataSearchAdvancedSearch.INCORRECT_MANUFATURER, "mid");
		
		log.info("Case_07_Search - Step 07: Click to 'SEARCH' button");
		userSearchPage.clickToSearchAdvancedButton(driver);
		
		log.info("Case_07_Search - Step 08: verify 'No products were found that matched your criteria.' is displayed");
		verifyEquals(userSearchPage.getTextInformationCard(driver, "no-result"),"No products were found that matched your criteria.");
	}
	@Test
	public void Case_08_Search_With_Absolute_Product_Name() {
		log.info("Case_08_Search - Step 01: Refresh 'Search' page");
		userSearchPage.refreshCurrentPage(driver);
	
		log.info("Case_08_Search - Step 02: Sendkey to 'Search keyword' textbox with value is '"+ DataSearchAdvancedSearch.SEARCH_KYEWORD + "' ");
		userSearchPage.sendKeyToTextbox(driver, DataSearchAdvancedSearch.SEARCH_KYEWORD, "q");
		
		log.info("Case_08_Search - Step 03: Click to 'Advanced search' checkbox");
		userSearchPage.clickToCheckbox(driver, "advs");
		
		log.info("Case_08_Search - Step 04: Click to 'Category' dropdown list");
		userSearchPage.selectInDropDownList(driver, DataSearchAdvancedSearch.CATEGORY, "cid");
		
		log.info("Case_08_Search - Step 05: Click to 'Automatically search sub categories' checkbox");
		userSearchPage.clickToCheckbox(driver, "isc");
		
		log.info("Case_08_Search - Step 06: Click to 'Manufacturer' dropdown list");
		userSearchPage.selectInDropDownList(driver, DataSearchAdvancedSearch.CORRECT_MANUFATURER, "mid");
		
		log.info("Case_08_Search - Step 07: Click to 'SEARCH' button");
		userSearchPage.clickToSearchAdvancedButton(driver);
		
		log.info("Case_08_Search - Step 08: verify 'Apple MacBook Pro 13-inch' is displayed");
		verifyTrue(userSearchPage.isNameProductDisplayed(driver, "Apple MacBook Pro 13-inch"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserSearchPageObject userSearchPage;

}
