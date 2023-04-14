package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserCheckoutPageUIs;

public class UserCheckoutPageObject extends BasePage {
	private WebDriver driver;
	public UserCheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToContinueButton(WebDriver driver) {
		waitForElementClickable(driver, UserCheckoutPageUIs.CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUIs.CONTINUE_BUTTON);
	}
	public void clickToContinueButton1(WebDriver driver) {
		waitForElementClickable(driver, UserCheckoutPageUIs.CONTINUE_BUTTON1);
		clickToElement(driver, UserCheckoutPageUIs.CONTINUE_BUTTON1);
	}
	public boolean successMessageDisplayed(WebDriver driver) {
		waitForElementVisible(driver, UserCheckoutPageUIs.SUCCESS_MESSGAGE);
		String information = getElementText(driver, UserCheckoutPageUIs.SUCCESS_MESSGAGE);
		if (information.contains("Mail Personal or Business Check, Cashier's Check or money order to:")) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isBillingAddressDisplayed(WebDriver driver) {
		waitForElementVisible(driver, UserCheckoutPageUIs.BILLING_ADDRESS);
		return isElementDisplay(driver, UserCheckoutPageUIs.BILLING_ADDRESS);
	}
	public boolean isShippingAddressDisplayed(WebDriver driver) {
		waitForElementVisible(driver, UserCheckoutPageUIs.SHIPPING_ADDRESS);
		return isElementDisplay(driver, UserCheckoutPageUIs.SHIPPING_ADDRESS);
	}
	public void clickToConfirmButton(WebDriver driver) {
		waitForElementClickable(driver, UserCheckoutPageUIs.CONFIRM_BUTTON);
		clickToElement(driver, UserCheckoutPageUIs.CONFIRM_BUTTON);
	}
	public boolean isOrderSuccessMessageDisplayed(WebDriver driver) {
		waitForElementVisible(driver, UserCheckoutPageUIs.ORDER_SUCCESS_MESSAGE);
		return isElementDisplay(driver, UserCheckoutPageUIs.ORDER_SUCCESS_MESSAGE);
	}
	public void clickToContinueButton2(WebDriver driver) {
		waitForElementClickable(driver, UserCheckoutPageUIs.CONTINUE_BUTTON2);
		clickToElement(driver, UserCheckoutPageUIs.CONTINUE_BUTTON2);
	}
	public void clickToContinueButton3(WebDriver driver) {
		waitForElementClickable(driver, UserCheckoutPageUIs.CONTINUE_BUTTON3);
		clickToElement(driver, UserCheckoutPageUIs.CONTINUE_BUTTON3);
	}
	public void clickToContinueButton4(WebDriver driver) {
		waitForElementClickable(driver, UserCheckoutPageUIs.CONTINUE_BUTTON4);
		clickToElement(driver, UserCheckoutPageUIs.CONTINUE_BUTTON4);
	}
	public void clickToContinueButton5(WebDriver driver) {
		waitForElementClickable(driver, UserCheckoutPageUIs.CONTINUE_BUTTON5);
		clickToElement(driver, UserCheckoutPageUIs.CONTINUE_BUTTON5);
	}
	
}
