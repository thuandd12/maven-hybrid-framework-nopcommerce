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
	/** Verify success message register is displayed
	 * @param driver
	 * @return
	 */
	public boolean verifySuccessMessageRegisterDisplayed(WebDriver driver) {
		waitForElementVisible(driver, UserRegisterPageUIs.SUCCESS_MESSAGE_REGISTER);
		return isElementDisplay(driver, UserRegisterPageUIs.SUCCESS_MESSAGE_REGISTER);
	}
	/** Verify massage email already exist
	 * @param driver
	 * @return
	 */
	public boolean verifyMessageEmailAlreadyExistDisplayed(WebDriver driver) {
		waitForElementVisible(driver, UserRegisterPageUIs.EMAIL_MESSAGE_ALREADY_EXIST);
		return isElementDisplay(driver, UserRegisterPageUIs.EMAIL_MESSAGE_ALREADY_EXIST);
	}
	/** Get text at message warning
	 * @param driver
	 * @param inputValue
	 * @return 
	 */
	public String getTextAtMessageWarning(WebDriver driver, String inputValue) {
		waitForElementVisible(driver, UserRegisterPageUIs.ERROR_MESSAGE_DISPLAYED, inputValue);
		return getElementText(driver, UserRegisterPageUIs.ERROR_MESSAGE_DISPLAYED, inputValue);
	}

}
