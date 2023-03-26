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
}
