package pageObjectNopcommerceUser;



import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserShoppingCartPageUIs;

public class UserShoppingCartPageObject extends BasePage {
	private WebDriver driver;
	public UserShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isNameProductDisplayed(WebDriver driver,String inputValue) {
		waitForElementVisible(driver, UserShoppingCartPageUIs.NAME_PRODUCT, inputValue);
		return isElementDisplay(driver, UserShoppingCartPageUIs.NAME_PRODUCT, inputValue);
	}
	public String getInformationProduct(WebDriver driver, String inputValue) {
		waitForElementVisible(driver, UserShoppingCartPageUIs.INFORMATION_PRODUCT, inputValue);
		return getElementText(driver, UserShoppingCartPageUIs.INFORMATION_PRODUCT, inputValue);
	}
	public String getInformationTotalProduct(WebDriver driver, String inputValue) {
		waitForElementVisible(driver, UserShoppingCartPageUIs.PRICE_TOTAL, inputValue);
		return getElementText(driver, UserShoppingCartPageUIs.PRICE_TOTAL, inputValue);
	}
	public String getValueQuantity(WebDriver driver, String inputValue, String value) {
		waitForElementVisible(driver, UserShoppingCartPageUIs.QUANTITY_TEXTBOX, inputValue);
		return getElementAttribute(driver, UserShoppingCartPageUIs.QUANTITY_TEXTBOX, value, inputValue);
	}
	public void clickToRemoveButton(WebDriver driver) {
		waitForElementClickable(driver, UserShoppingCartPageUIs.REMOVE_BUTTON);
		clickToElement(driver, UserShoppingCartPageUIs.REMOVE_BUTTON);
	}
	public void sendkeyToValueQuantity(WebDriver driver, String inputValue, String value) {
		waitForElementVisible(driver, UserShoppingCartPageUIs.QUANTITY_TEXTBOX, inputValue);
		sendkeyToElement(driver, UserShoppingCartPageUIs.QUANTITY_TEXTBOX, value, inputValue);
	}
	
}
