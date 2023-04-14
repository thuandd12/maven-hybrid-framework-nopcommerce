package pageObjectNopcommerceUser;



import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserHomePageUIs;
import pageUIs.Nopcommerce.User.UserRecentlyViewedProductsPageUIs;
import pageUIs.Nopcommerce.User.UserShoppingCartPageUIs;

public class UserRecentlyViewedProductsPageObject extends BasePage {
	private WebDriver driver;
	public UserRecentlyViewedProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isNameProductsDisplayed(WebDriver driver,String inputValue) {
		waitForElementVisible(driver,UserRecentlyViewedProductsPageUIs.NAME_TEXT_LINK, inputValue);
		return isElementDisplay(driver, UserRecentlyViewedProductsPageUIs.NAME_TEXT_LINK, inputValue);
	}
}
