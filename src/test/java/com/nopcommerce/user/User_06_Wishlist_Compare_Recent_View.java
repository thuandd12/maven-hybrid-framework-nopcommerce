package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import dataNopcommerce.User.DataCommons.DataWishlistCompareRecentView;
import pageObjectNopcommerceUser.PageGeneratorManager;
import pageObjectNopcommerceUser.UserCompareProductListPageObject;
import pageObjectNopcommerceUser.UserComputersPageObject;
import pageObjectNopcommerceUser.UserHomePageObject;
import pageObjectNopcommerceUser.UserLoginPageObject;
import pageObjectNopcommerceUser.UserNotebooksPageObject;
import pageObjectNopcommerceUser.UserRecentlyViewedProductsPageObject;
import pageObjectNopcommerceUser.UserRegisterPageObject;
import pageObjectNopcommerceUser.UserShoppingCartPageObject;
import pageObjectNopcommerceUser.UserWishlistPageObject;
import pageUIs.Nopcommerce.User.UserComputersPageUIs;

public class User_06_Wishlist_Compare_Recent_View extends BaseTest {
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
				+ DataWishlistCompareRecentView.FIRSTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataWishlistCompareRecentView.FIRSTNAME, "FirstName");

		log.info("Pre-Condition - Step 04: sendKey to 'Last name' textbox with the value is '"
				+ DataWishlistCompareRecentView.LASTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataWishlistCompareRecentView.LASTNAME, "LastName");

		log.info("Pre-Condition - Step 05: sendKey to 'Email' textbox with the value is '"
				+ DataWishlistCompareRecentView.EMAIL_ADDRESS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataWishlistCompareRecentView.EMAIL_ADDRESS, "Email");

		log.info("Pre-Condition - Step 06: sendKey to 'Password' textbox with the value is '"
				+ DataWishlistCompareRecentView.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataWishlistCompareRecentView.PASSWORD, "Password");

		log.info("Pre-Condition - Step 07: sendKey to 'Confirm Password' textbox with the value is '"
				+ DataWishlistCompareRecentView.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataWishlistCompareRecentView.PASSWORD, "ConfirmPassword");

		log.info("Pre-Condition - Step 08: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");

		log.info("Pre-Condition - Step 09: Verify 'Your registration completed' is displayed");
		verifyTrue(userRegisterPage.verifySuccessMessageRegisterDisplayed(driver));

		log.info("Pre-Condition - Step 10: Click to 'Log in' link");
		userRegisterPage.clickToLinkByText(driver, "Log in");

		log.info("Pre-Condition - Step 11: Sendkey to 'Email' textbox with value is '"+ DataWishlistCompareRecentView.EMAIL_ADDRESS + "'");
		userLoginPage = PageGeneratorManager.getLoginPage(driver);
		userLoginPage.sendKeyToTextbox(driver, DataWishlistCompareRecentView.EMAIL_ADDRESS, "Email");

		log.info("Pre-Condition - Step 12: Sendkey to 'Password' textbox with value is '"+ DataWishlistCompareRecentView.PASSWORD + "'");
		userLoginPage.sendKeyToTextbox(driver, DataWishlistCompareRecentView.PASSWORD, "Password");

		log.info("Pre-Condition - Step 13: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");

		log.info("Pre-Condition - Step 14: Verify 'My account' link displayed'");
		verifyTrue(userHomePage.isLinkDisplayed(driver, "My account"));

	}

	@Test
	public void Case_01_Add_To_Wishlist() {
		log.info("Case_01_Add_To_Wishlist - Step 01: Click to 'Apple MacBook Pro 13-inch' link");
		userHomePage.clickToLinkByText(driver, "Apple MacBook Pro 13-inch");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
		log.info("Case_01_Add_To_Wishlist - Step 02: Click to 'Add to wishlist' button");
		userNotebooksPage.clickAddToWishlistButton(driver,"Apple MacBook Pro 13-inch");
		userWishlistPage = PageGeneratorManager.getWishlistPage(driver);
		
		log.info("Case_01_Add_To_Wishlist - Step 03: Verify 'The product has been added to your' is displayed");
		verifyEquals(userWishlistPage.getTextUpdatedSuccessMessage(driver), "The product has been added to your wishlist");
		
		log.info("Case_01_Add_To_Wishlist - Step 04: Click to 'Wishlist' link");
		userWishlistPage.clickToLinkByText(driver, "Wishlist");
		
		log.info("Case_01_Add_To_Wishlist - Step 05: Verify 'Apple MacBook Pro 13-inch' is displayed");
		verifyTrue(userWishlistPage.isNameProductDisplayed(driver, "Apple MacBook Pro 13-inch"));
		
		log.info("Case_01_Add_To_Wishlist - Step 06: Click to 'Your wishlist URL for sharing' link");
		userWishlistPage.clickToShareLink(driver);
		
		log.info("Case_01_Add_To_Wishlist - Step 07: Verify 'Wishlist of '"+ DataWishlistCompareRecentView.FIRSTNAME + " " + DataWishlistCompareRecentView.LASTNAME +"'' is displayed");
		verifyEquals(userWishlistPage.getTextWishListOfName(driver), "Wishlist of " + DataWishlistCompareRecentView.FIRSTNAME + " " + DataWishlistCompareRecentView.LASTNAME );
	}

	@Test
	public void Case_02_Add_Product_To_Cart_From_Wishlist_Page() {
		log.info("Case_02_Add_Product - Step 01: Click to 'Wishlist' link");
		userWishlistPage = PageGeneratorManager.getWishlistPage(driver);
		userWishlistPage.clickToLinkByText(driver, "Wishlist");
		
		log.info("Case_02_Add_Product - Step 02: Click to 'Add to cart' checkbox");
		userWishlistPage.clickAddToCartCheckbox(driver, "Apple MacBook Pro 13-inch");
		
		log.info("Case_02_Add_Product - Step 03: Click to 'Add to cart' button");
		userWishlistPage.clickToButtonByText(driver, "Add to cart");
		
		log.info("Case_02_Add_Product - Step 04: Click to 'Shopping cart' link");
		userWishlistPage.clickToLinkByText(driver, "Shopping cart");
		userShoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("Case_02_Add_Product - Step 05: Verify 'Apple MacBook Pro 13-inch' is displayed");
		verifyTrue(userShoppingCartPage.isNameProductDisplayed(driver, "Apple MacBook Pro 13-inch"));
		
	}

	@Test
	public void Case_03_Remove_Product_In_Wishlist_Page() {
		log.info("Case_03_Remove_Product - Step 01: Open 'Home Page'");
		userWishlistPage = PageGeneratorManager.getWishlistPage(driver);
		userWishlistPage.openHomePageUrl(driver);
		
		log.info("Case_03_Remove_Product - Step 02: Click to 'Apple MacBook Pro 13-inch' link");
		userHomePage.clickToProductNameByJS(driver, "Apple MacBook Pro 13-inch");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
		log.info("Case_03_Remove_Produc - Step 03: Click to 'Add to wishlist' button");
		userNotebooksPage.clickAddToWishlistButton(driver,"Apple MacBook Pro 13-inch");
		userWishlistPage = PageGeneratorManager.getWishlistPage(driver);
		
		log.info("Case_03_Remove_Produc - Step 04: Verify 'The product has been added to your wishlist' is displayed");
		verifyEquals(userWishlistPage.getTextUpdatedSuccessMessage(driver), "The product has been added to your wishlist");
		
		log.info("Case_03_Remove_Produc - Step 05: Click to 'Wishlist' link");
		userWishlistPage.clickToLinkByText(driver, "Wishlist");
		
		log.info("Case_03_Remove_Produc - Step 06: Verify 'Apple MacBook Pro 13-inch' is displayed");
		verifyTrue(userWishlistPage.isNameProductDisplayed(driver, "Apple MacBook Pro 13-inch"));
		
		log.info("Case_03_Remove_Produc - Step 07: Click to 'Remove' button");
		userWishlistPage.clickRemoveButton(driver, "Apple MacBook Pro 13-inch");
		
		
		log.info("Case_03_Remove_Produc - Step 08: Verify 'The wishlist is empty!' is displayed");
		verifyEquals(userWishlistPage.getTextWishlistEmpty(driver), "The wishlist is empty!");
	}

	@Test
	public void Case_04_Add_Product_To_Compare() {
		log.info("Case_04_Add_Product - Step 01: Open 'Home Page'");
		userWishlistPage = PageGeneratorManager.getWishlistPage(driver);
		userWishlistPage.openHomePageUrl(driver);
		
		log.info("Case_04_Add_Product - Step 02: Click to 'Add to compare' of 'Apple MacBook Pro 13-inch' product");
		userHomePage = PageGeneratorManager.getHomePage(driver);
		userHomePage.clickToIcon(driver, "Apple MacBook Pro 13-inch", "Add to compare list");
		userCompareProductList.sleepInsecond(3);
		
		log.info("Case_04_Add_Product - Step 03: Click to 'Add to compare' of 'Build your own computer' product");
		userHomePage = PageGeneratorManager.getHomePage(driver);
		userHomePage.clickToIcon(driver, "Build your own computer", "Add to compare list");
		userCompareProductList.sleepInsecond(3);
		
		log.info("Case_04_Add_Product - Step 04: Click to 'Compare products list' link");
		userHomePage.clickToLinkByText(driver, "Compare products list");
		userCompareProductList = PageGeneratorManager.getCompareProductListPage(driver);
		userCompareProductList.sleepInsecond(3);
		
		log.info("Case_04_Add_Product - Step 05: Verify 'Apple MacBook Pro 13-inch' is displayed");
		verifyTrue(userCompareProductList.isProductNameDisplayed(driver, "Apple MacBook Pro 13-inch"));
		
		log.info("Case_04_Add_Product - Step 06: Verify '$1,800.00' price is displayed");
		verifyTrue(userCompareProductList.isPriceProductDisplayed(driver, "Apple MacBook Pro 13-inch", "$1,800.00"));
		
		log.info("Case_04_Add_Product - Step 07: Verify 'Build your own computer' is displayed");
		verifyTrue(userCompareProductList.isProductNameDisplayed(driver, "Build your own computer"));
		
		log.info("Case_04_Add_Product - Step 08: Verify '$1,200.00' price is displayed");
		verifyTrue(userCompareProductList.isPriceProductDisplayed(driver, "Build your own computer", "$1,200.00"));
		
		log.info("Case_04_Add_Product - Step 09: Click 'CLEAR LIST' button");
		userCompareProductList.clickToLinkByText(driver, "Clear list");
		
		log.info("Case_04_Add_Product - Step 10: Verify 'You have no items to compare.' is displayed");
		verifyEquals(userCompareProductList.getTexNotificationMassage(driver), "You have no items to compare.");
	}
	@Test
	public void Case_05_Recently_Viewed_Products() {
		log.info("Case_05_Recently_Viewed - Step 01: Navigate to 'Home Page'");
		userCompareProductList = PageGeneratorManager.getCompareProductListPage(driver);
		userCompareProductList.openHomePageUrl(driver);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Case_05_Recently_Viewed - Step 02: Click to 'Computers' link");
		userHomePage.clickToComputersLink(driver);
		userComputersPage = PageGeneratorManager.getComputersPage(driver);
		
		log.info("Case_05_Recently_Viewed - Step 03: Click to 'Notebooks' link");
		userComputersPage.clickToLinkTypeComputers(driver, "Notebooks ");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		userNotebooksPage.sleepInsecond(3);
		
		log.info("Case_05_Recently_Viewed - Step 04: Click to 'Apple MacBook Pro 13-inch' link");
		userNotebooksPage.clickToLinkByText(driver, "Apple MacBook Pro 13-inch");
		userNotebooksPage.backToPage(driver);
		
		log.info("Case_05_Recently_Viewed - Step 05: Click to 'Asus N551JK-XO076H Laptop' link");
		userNotebooksPage.clickToLinkByText(driver, "Asus N551JK-XO076H Laptop");
		userNotebooksPage.backToPage(driver);
		
		
		log.info("Case_05_Recently_Viewed - Step 06: Click to 'HP Envy 6-1180ca 15.6-Inch Sleekbook' link");
		userNotebooksPage.clickToLinkByText(driver, "HP Envy 6-1180ca 15.6-Inch Sleekbook");
		userNotebooksPage.backToPage(driver);
		
		
		log.info("Case_05_Recently_Viewed - Step 07: Click to 'HP Spectre XT Pro UltraBook");
		userNotebooksPage.clickToLinkByText(driver, "HP Spectre XT Pro UltraBook");
		userNotebooksPage.backToPage(driver);
		
		
		log.info("Case_05_Recently_Viewed - Step 08: Click to 'Lenovo Thinkpad X1 Carbon Laptop' link");
		userNotebooksPage.clickToLinkByText(driver, "Lenovo Thinkpad X1 Carbon Laptop");
		
		log.info("Case_05_Recently_Viewed - Step 09: Click to 'Recently viewed products' link");
		userNotebooksPage.clickToLinkByText(driver, "Recently viewed products");
		userRecentlyViewedProductsPage = PageGeneratorManager.getRecentlyViewedProductsPage(driver);
		
		log.info("Case_05_Recently_Viewed - Step 10: Verify 'Lenovo Thinkpad X1 Carbon Laptop' is displayed");
		verifyTrue(userRecentlyViewedProductsPage.isNameProductsDisplayed(driver, "Lenovo Thinkpad X1 Carbon Laptop"));
		
		log.info("Case_05_Recently_Viewed - Step 11: Verify 'HP Spectre XT Pro UltraBook' is displayed");
		verifyTrue(userRecentlyViewedProductsPage.isNameProductsDisplayed(driver, "HP Spectre XT Pro UltraBook"));
		
		log.info("Case_05_Recently_Viewed - Step 12: Verify 'HP Envy 6-1180ca 15.6-Inch Sleekbook' is displayed");
		verifyTrue(userRecentlyViewedProductsPage.isNameProductsDisplayed(driver, "HP Envy 6-1180ca 15.6-Inch Sleekbook"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserNotebooksPageObject userNotebooksPage;
	private UserWishlistPageObject userWishlistPage;
	private UserShoppingCartPageObject userShoppingCartPage;
	private UserCompareProductListPageObject userCompareProductList;
	private UserComputersPageObject userComputersPage;
	private UserRecentlyViewedProductsPageObject userRecentlyViewedProductsPage;


}
