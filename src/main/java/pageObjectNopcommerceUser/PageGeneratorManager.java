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

}
