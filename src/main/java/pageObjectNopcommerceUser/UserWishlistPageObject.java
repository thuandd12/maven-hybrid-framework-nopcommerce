package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserShoppingCartPageUIs;
import pageUIs.Nopcommerce.User.UserWishlistPageUIs;

public class UserWishlistPageObject extends BasePage {
	private WebDriver driver;
	public UserWishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToShareLink(WebDriver driver) {
		waitForElementVisible(driver, UserWishlistPageUIs.SHARE_LINK);
		clickToElement(driver, UserWishlistPageUIs.SHARE_LINK);
	}
	public String getTextWishListOfName(WebDriver driver) {
		waitForElementVisible(driver, UserWishlistPageUIs.WISHLIST_OF_NAME);
		return getElementText(driver, UserWishlistPageUIs.WISHLIST_OF_NAME);
	}
	public void clickAddToCartCheckbox(WebDriver driver,String inputValue) {
		waitForElementVisible(driver, UserWishlistPageUIs.ADD_TO_CART_TEXTBOX, inputValue);
		checkToDefaultCheckBoxRadio(driver, UserWishlistPageUIs.ADD_TO_CART_TEXTBOX, inputValue);
	}
	public String getTextWishlistEmpty(WebDriver driver) {
		waitForElementVisible(driver, UserWishlistPageUIs.WISHLIST_EMPTY);
		return getElementText(driver, UserWishlistPageUIs.WISHLIST_EMPTY);
	}
	public void clickRemoveButton(WebDriver driver,String inputValue) {
		waitForElementClickable(driver, UserWishlistPageUIs.REMOVE_BUTTON, inputValue);
		clickToElement(driver, UserWishlistPageUIs.REMOVE_BUTTON, inputValue);
	}
	public boolean isNameProductDisplayed(WebDriver driver,String inputValue) {
		waitForElementVisible(driver, UserShoppingCartPageUIs.NAME_PRODUCT, inputValue);
		return isElementDisplay(driver, UserShoppingCartPageUIs.NAME_PRODUCT, inputValue);
	}
}
