package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	public static UserCustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}
	public static UserAddressesPageObject getAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	public static UserAddressesPageObject getChangePasswordPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	public static UserNotebooksPageObject getNotebooksPage(WebDriver driver) {
		return new UserNotebooksPageObject(driver);
	}
	public static UserMyProductReviewsPageObject getMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewsPageObject(driver);
	}
	public static UserSearchPageObject getSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}
	public static UserComputersPageObject getComputersPage(WebDriver driver) {
		return new UserComputersPageObject(driver);
	}
	public static UserWishlistPageObject getWishlistPage(WebDriver driver) {
		return new UserWishlistPageObject(driver);
	}
	public static UserShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
		return new UserShoppingCartPageObject(driver);
	}
	public static UserCompareProductListPageObject getCompareProductListPage(WebDriver driver) {
		return new UserCompareProductListPageObject(driver);
	}
	public static UserRecentlyViewedProductsPageObject getRecentlyViewedProductsPage(WebDriver driver) {
		return new UserRecentlyViewedProductsPageObject(driver);
	}
	public static UserDesktopsPageObject getDesktopsPage(WebDriver driver) {
		return new UserDesktopsPageObject(driver);
	}
	public static UserCheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new UserCheckoutPageObject(driver);
	}


}
