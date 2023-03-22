package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserRegisterPageUIs;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	/** Verify error message is diplayed by text
	 * @param driver
	 * @param inputId
	 * @return 
	 */
	public boolean verifyErrorMessageDisplayed(WebDriver driver, String inputId) {
		waitForElementVisible(driver, UserRegisterPageUIs.ERROR_MESSAGE_DISPLAYED, inputId);
		return isElementDisplay(driver, UserRegisterPageUIs.ERROR_MESSAGE_DISPLAYED, inputId);
	}
	
}
