package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserCompareProductListPageUIs;

public class UserCompareProductListPageObject extends BasePage {
	private WebDriver driver;
	public UserCompareProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isProductNameDisplayed(WebDriver driver, String productName) {
		waitForAllElementVisible(driver, UserCompareProductListPageUIs.PRODUCT_NAME, productName);
		return isElementDisplay(driver, UserCompareProductListPageUIs.PRODUCT_NAME, productName);
	}
	public boolean isPriceProductDisplayed(WebDriver driver, String productName, String price) {
		waitForAllElementVisible(driver, UserCompareProductListPageUIs.PRICE_PRODUCT, productName, price);
		return isElementDisplay(driver, UserCompareProductListPageUIs.PRICE_PRODUCT, productName, price);
	}
	public String getTexNotificationMassage(WebDriver driver) {
		waitForAllElementVisible(driver, UserCompareProductListPageUIs.NOTIFICATION_MESSAGE);
		return getElementText(driver, UserCompareProductListPageUIs.NOTIFICATION_MESSAGE);
	}
	
}
