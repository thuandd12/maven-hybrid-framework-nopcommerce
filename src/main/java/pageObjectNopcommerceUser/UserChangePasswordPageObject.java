package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserCustomerInfoPageUIs;

public class UserChangePasswordPageObject extends BasePage {
	private WebDriver driver;
	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
