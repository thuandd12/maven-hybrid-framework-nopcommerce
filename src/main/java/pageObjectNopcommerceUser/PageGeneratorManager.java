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

}
