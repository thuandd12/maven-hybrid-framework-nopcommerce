package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserLoginPageUIs;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	/** Get text warning message unregistered email
	 * @param driver
	 * @return
	 */
	public String getTextWarningMessageUnregisteredEmail(WebDriver driver) {
		waitForElementVisible(driver, UserLoginPageUIs.WARNING_MESSAGE_EMAIL_UNREGISTERED);
		return getElementText(driver, UserLoginPageUIs.WARNING_MESSAGE_EMAIL_UNREGISTERED);
	}
}
