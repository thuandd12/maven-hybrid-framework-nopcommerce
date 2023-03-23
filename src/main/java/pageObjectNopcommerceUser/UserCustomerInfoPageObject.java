package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserCustomerInfoPageUIs;

public class UserCustomerInfoPageObject extends BasePage {
	private WebDriver driver;
	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
	/** Click to radio button by id
	 * @param driver
	 * @param inputValue
	 */
	public void clickToRadioButton(WebDriver driver, String inputValue) {
		waitForElementClickable(driver, UserCustomerInfoPageUIs.BUTTON_RADIO_BUTTON, inputValue);
		checkToDefaultCheckBoxRadio(driver, UserCustomerInfoPageUIs.BUTTON_RADIO_BUTTON, inputValue);
	}

	/** Get text updated success message
	 * @param driver
	 * @return
	 */
	public String getTextUpdatedSuccessMessage(WebDriver driver) {
		waitForElementVisible(driver, UserCustomerInfoPageUIs.UPDATED_SUCCESS_MESSAGE);
		return getElementText(driver, UserCustomerInfoPageUIs.UPDATED_SUCCESS_MESSAGE);
	}
	
}
