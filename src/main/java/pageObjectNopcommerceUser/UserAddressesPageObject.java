package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserCustomerInfoPageUIs;

public class UserAddressesPageObject extends BasePage {
	private WebDriver driver;
	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
