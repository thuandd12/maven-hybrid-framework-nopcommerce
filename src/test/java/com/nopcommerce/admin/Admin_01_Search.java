package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import dataNopcommerce.User.DataCommons.DataAdminSearch;
import pageObjectNopcommerceAdmin.AdminEditProductDetailsPageObject;
import pageObjectNopcommerceAdmin.AdminHomePageObject;
import pageObjectNopcommerceAdmin.AdminLoginPageObject;
import pageObjectNopcommerceAdmin.AdminProductPageObject;
import pageObjectNopcommerceAdmin.PageGeneratorManager;

public class Admin_01_Search extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Navigate to 'Home Page'");
		driver = getBrowserDriver(browserName, appUrl);
		adminLoginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-Condition - Step 02: Click to 'LOG IN' button");
		adminLoginPage.clickToButtonByText(driver, "Log in");
		adminHomePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-Condition - Step 03: Click to 'Catalog' icon");
		adminHomePage.clickToIconInAdminPage(driver, "nav-icon fas fa-book");
		
		log.info("Pre-Condition - Step 04: Click to 'Products' link");
		adminHomePage.clickToMenuInAdminPage(driver, " Products");
		adminProductPage = PageGeneratorManager.getProductPage(driver);
		
		

	}

	@Test
	public void Case_01_Search_With_Product_Name() {
		log.info("Case_01_Search - Step 01: Sendkey to 'Productname' text box with value is '"+ DataAdminSearch.PRODUCT_NAME +"'");
		adminProductPage.sendKeyToTextbox(driver, DataAdminSearch.PRODUCT_NAME, "SearchProductName");
		
		log.info("Case_01_Search - Step 02: Click to 'Search' button");
		adminProductPage.clickToButtonInAdminPage(driver, "search-products");
		
		log.info("Case_01_Search - Step 03: Verify there is a product 'Lenovo IdeaCentre 600 All-in-One PC' displayed");
		verifyTrue(adminProductPage.isProductDisplayed(driver, "Lenovo IdeaCentre 600 All-in-One PC"));
		
	}

	@Test
	public void Case_02_Search_With_Product_Name_Parent_Catefory_Unchecked() {
		log.info("Case_02_Search - Step 01: Refresh page");
		adminProductPage.refreshCurrentPage(driver);
		
		log.info("Case_02_Search - Step 02: Sendkey to 'Productname' text box with value is '"+ DataAdminSearch.PRODUCT_NAME +"'");
		adminProductPage.sendKeyToTextbox(driver, DataAdminSearch.PRODUCT_NAME, "SearchProductName");
		
		log.info("Case_02_Search - Step 03: Select to 'Category' dropdown list with value is '"+ DataAdminSearch.CATEGORY +"'");
		adminProductPage.selectInDropDownList(driver, DataAdminSearch.CATEGORY, "SearchCategoryId");
		
		log.info("Case_02_Search - Step 04: Click to 'Search' button");
		adminProductPage.clickToButtonInAdminPage(driver, "search-products");
		
		log.info("Case_02_Search - Step 05: Verify 'No data available in table' displayed");
		verifyTrue(adminProductPage.isProductDisplayed(driver, "No data available in table"));
		
		
	}

	@Test
	public void Case_03_Search_With_Product_Name_Parent_Catefory_Checked() {
		log.info("Case_03_Search - Step 01: Refresh page");
		adminProductPage.refreshCurrentPage(driver);
		
		log.info("Case_03_Search - Step 02: Sendkey to 'Productname' text box with value is '"+ DataAdminSearch.PRODUCT_NAME +"'");
		adminProductPage.sendKeyToTextbox(driver, DataAdminSearch.PRODUCT_NAME, "SearchProductName");
		
		log.info("Case_03_Search - Step 03: Select to 'Category' dropdown list with value is '"+ DataAdminSearch.CATEGORY +"'");
		adminProductPage.selectInDropDownList(driver, DataAdminSearch.CATEGORY, "SearchCategoryId");
		
		log.info("Case_03_Search - Step 04: Click to 'Search subcategories' checkbox");
		adminProductPage.clickToCheckbox(driver, "SearchIncludeSubCategories");
		
		log.info("Case_03_Search - Step 05: Click to 'Search' button");
		adminProductPage.clickToButtonInAdminPage(driver, "search-products");
		
		log.info("Case_03_Search - Step 06: Verify there is a product 'Lenovo IdeaCentre 600 All-in-One PC' displayed");
		verifyTrue(adminProductPage.isProductDisplayed(driver, "Lenovo IdeaCentre 600 All-in-One PC"));

	}

	@Test
	public void Case_04__Search_With_Product_Name_Child_Category() {
		log.info("Case_04_Search - Step 01: Refresh page");
		adminProductPage.refreshCurrentPage(driver);
		
		log.info("Case_04_Search - Step 02: Sendkey to 'Productname' text box with value is '"+ DataAdminSearch.PRODUCT_NAME +"'");
		adminProductPage.sendKeyToTextbox(driver, DataAdminSearch.PRODUCT_NAME, "SearchProductName");
		
		log.info("Case_04_Search - Step 03: Select to 'Category' dropdown list with value is '"+ DataAdminSearch.CATEGORY1 +"'");
		adminProductPage.selectInDropDownList(driver, DataAdminSearch.CATEGORY1, "SearchCategoryId");
		
		log.info("Case_04_Search - Step 04: Click to 'Search' button");
		adminProductPage.clickToButtonInAdminPage(driver, "search-products");
		
		log.info("Case_04_Search - Step 05: Verify there is a product 'Lenovo IdeaCentre 600 All-in-One PC' displayed");
		verifyTrue(adminProductPage.isProductDisplayed(driver, "Lenovo IdeaCentre 600 All-in-One PC"));
		
	}

	@Test
	public void Case_05_Search_With_Product_Name_Manufacturer() {
		log.info("Case_05_Search - Step 01: Refresh page");
		adminProductPage.refreshCurrentPage(driver);
		
		log.info("Case_05_Search - Step 02: Sendkey to 'Productname' text box with value is '"+ DataAdminSearch.PRODUCT_NAME +"'");
		adminProductPage.sendKeyToTextbox(driver, DataAdminSearch.PRODUCT_NAME, "SearchProductName");
		
		log.info("Case_05_Search - Step 03: Select to 'Category' dropdown list with value is '"+ DataAdminSearch.CATEGORY2 +"'");
		adminProductPage.selectInDropDownList(driver, DataAdminSearch.CATEGORY2, "SearchCategoryId");
		
		log.info("Case_05_Search - Step 04: Select to 'Manufacturer' dropdown list with value is '"+ DataAdminSearch.MANUFACTURER +"'");
		adminProductPage.selectInDropDownList(driver, DataAdminSearch.MANUFACTURER, "SearchManufacturerId");
		
		log.info("Case_05_Search - Step 05: Click to 'Search' button");
		adminProductPage.clickToButtonInAdminPage(driver, "search-products");
		
		log.info("Case_05_Search - Step 06: Verify 'No data available in table' displayed");
		verifyTrue(adminProductPage.isProductDisplayed(driver, "No data available in table"));
	}
	@Test
	public void Case_06_Go_Directly_To_Product_SKU() {
		log.info("Case_06_Go_Directly - Step 01: Refresh page");
		adminProductPage.refreshCurrentPage(driver);
		
		log.info("Case_06_Go_Directly - Step 02: Sendkey to 'Go directly to product SKU' textbox with value is '"+ DataAdminSearch.SKU +"'");
		adminProductPage.sendKeyToTextbox(driver, DataAdminSearch.SKU, "GoDirectlyToSku");
		
		log.info("Case_06_Go_Directly - Step 03: Click to 'Go' button");
		adminProductPage.clickToButtonInAdminPage(driver, "go-to-product-by-sku");
		adminEditProductDetailsPage = PageGeneratorManager.getEditProductDetailsPage(driver);
		
		log.info("Case_06_Go_Directly - Step 04: Verify 'Edit product details - Lenovo IdeaCentre 600 All-in-One PC' is displayed ");
		verifyTrue(adminEditProductDetailsPage.isEditProductDetailsPageDisplayed(driver));
		
		log.info("Case_06_Go_Directly - Step 05: Verify 'Edit product details - Lenovo IdeaCentre 600 All-in-One PC' is displayed ");
		verifyTrue(adminEditProductDetailsPage.isEditProductDetailsPageDisplayed(driver));
		
		log.info("Case_06_Go_Directly - Step 06: Verify 'Lenovo IdeaCentre 600 All-in-One PC' is displayed ");
		verifyTrue(adminEditProductDetailsPage.isNameProductDisplayed(driver, "Lenovo IdeaCentre 600 All-in-One PC"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private AdminHomePageObject adminHomePage;
	private AdminProductPageObject adminProductPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminEditProductDetailsPageObject adminEditProductDetailsPage;

}
