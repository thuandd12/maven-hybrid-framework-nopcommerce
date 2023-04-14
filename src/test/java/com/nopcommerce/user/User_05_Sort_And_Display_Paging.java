package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import dataNopcommerce.User.DataCommons.DataNotebooks;
import pageObjectNopcommerceUser.PageGeneratorManager;
import pageObjectNopcommerceUser.UserComputersPageObject;
import pageObjectNopcommerceUser.UserHomePageObject;
import pageObjectNopcommerceUser.UserNotebooksPageObject;

public class User_05_Sort_And_Display_Paging extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Navigate to 'Home Page'");
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-Condition - Step 02: Click to 'Computers' link");
		userHomePage.clickToComputersLink(driver);
		userComputersPage = PageGeneratorManager.getComputersPage(driver);
		
		log.info("Pre-Condition - Step 03: Click to 'Notebooks' link");
		userComputersPage.clickToLinkTypeComputers(driver, "Notebooks ");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
	}

	@Test
	public void Case_01_Sort_With_Name_A_To_Z() {
		log.info("Case_01_Sort - Step 01: Click to 'Position' dropdown list and choose '"+ DataNotebooks.SORT_NAME_A_TO_Z +"'");
		userNotebooksPage.selectInDropDownList(driver, DataNotebooks.SORT_NAME_A_TO_Z, "products-orderby");
		
		log.info("Case_01_Sort - Step 02: Verify product names displayed in the correct order");
		verifyTrue(userNotebooksPage.isProducNameSortByAscending(driver));
	}

	@Test
	public void Case_02_Sort_With_Name_Z_To_A() {
		log.info("Case_02_Sort - Step 01: Refresh page");
		userNotebooksPage.refreshCurrentPage(driver);
		
		log.info("Case_02_Sort - Step 02: Click to 'Position' dropdown list and choose '"+ DataNotebooks.SORT_NAME_Z_TO_A +"'");
		userNotebooksPage.selectInDropDownList(driver, DataNotebooks.SORT_NAME_Z_TO_A, "products-orderby");
		
		log.info("Case_02_Sort - Step 03: Verify product names displayed in the correct order");
		verifyTrue(userNotebooksPage.isProducNameSortByDescending(driver));
		userNotebooksPage.sleepInsecond(4);
		
		
	}

	@Test
	public void Case_03_Display_With_3_Products() {
		log.info("Case_03_Display - Step 01: Refresh page");
		userComputersPage.clickToLinkTypeComputers(driver, "Notebooks ");
		
		log.info("Case_03_Display - Step 02: Click to '3' in products pagesie dropdown");
		userNotebooksPage.selectInDropDownList(driver, "3", "products-pagesize");
		
		log.info("Case_03_Display - Step 03: Verify 3 or less than 3 products is displayed in page");
		verifyTrue(userNotebooksPage.isproductsDisplayed(driver, 3));
	}
	@Test
	public void Case_04_Display_With_6_Products() {
		log.info("Case_04_Display - Step 01: Refresh page");
		userComputersPage.clickToLinkTypeComputers(driver, "Notebooks ");
		
		log.info("Case_04_Display - Step 02: Click to '6' in products pagesie dropdown");
		userNotebooksPage.selectInDropDownList(driver, "6", "products-pagesize");
		
		log.info("Case_04_Display - Step 03: Verify 6 or less than 6 products is displayed in page");
		verifyTrue(userNotebooksPage.isproductsDisplayed(driver, 6));
		
		
	}
	@Test
	public void Case_05_Display_With_9_Products() {
		log.info("Case_05_Display - Step 01: Refresh page");
		userComputersPage.clickToLinkTypeComputers(driver, "Notebooks ");
		
		log.info("Case_05_Display - Step 02: Click to '9' in products pagesie dropdown");
		userNotebooksPage.selectInDropDownList(driver, "9", "products-pagesize");
		
		log.info("Case_05_Display - Step 03: Verify 9 or less than 9 products is displayed in page");
		verifyTrue(userNotebooksPage.isproductsDisplayed(driver, 9));
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserComputersPageObject userComputersPage;
	private UserNotebooksPageObject userNotebooksPage;
	
}
