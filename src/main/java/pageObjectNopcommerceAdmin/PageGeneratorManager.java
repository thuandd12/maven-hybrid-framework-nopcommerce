package pageObjectNopcommerceAdmin;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	public static AdminHomePageObject getHomePage(WebDriver driver) {
		return new AdminHomePageObject(driver);
	}
	public static AdminProductPageObject getProductPage(WebDriver driver) {
		return new AdminProductPageObject(driver);
	}
	public static AdminLoginPageObject getLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static AdminEditProductDetailsPageObject getEditProductDetailsPage(WebDriver driver) {
		return new AdminEditProductDetailsPageObject(driver);
	}
	public static AdminCustomerPageObject getCustomerPage(WebDriver driver) {
		return new AdminCustomerPageObject(driver);
	}
	public static AdminSubCustomerPageObject getSubCustomerPage(WebDriver driver) {
		return new AdminSubCustomerPageObject(driver);
	}
	public static AdminAddNewCustomerPageObject getAddNewCustomerPage(WebDriver driver) {
		return new AdminAddNewCustomerPageObject(driver);
	}

}
