package pageObjectNopcommerceUser;



import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserNotebooksPageUIs;

public class UserNotebooksPageObject extends BasePage {
	private WebDriver driver;
	public UserNotebooksPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void sendKeyToReviewTextTextbox(WebDriver driver,String inputValue) {
		waitForElementVisible(driver, UserNotebooksPageUIs.REVIEW_TEXT_BOX);
		sendkeyToElement(driver, UserNotebooksPageUIs.REVIEW_TEXT_BOX, inputValue);
	}
	public boolean isproductsDisplayed(WebDriver driver,int inputNumberProducts){
		waitForAllElementVisible(driver, UserNotebooksPageUIs.NUMBER_PRODUCTS);
		int numberProducts = getElementSize(driver, UserNotebooksPageUIs.NUMBER_PRODUCTS);
		System.out.println("so sp la : " + numberProducts);
	if (numberProducts<=inputNumberProducts) {
		return true;
	}else 
		return false;
	
	}
	/** Click to wishlist button by text
	 * @param driver
	 * @param inputValue
	 */
	public void clickAddToWishlistButton(WebDriver driver,String inputValue) {
		waitForElementVisible(driver, UserNotebooksPageUIs.ADD_TO_WISHLIST_BUTTON, inputValue);
		clickToElement(driver, UserNotebooksPageUIs.ADD_TO_WISHLIST_BUTTON, inputValue);
	}
	public void clickAddToCartButton(WebDriver driver) {
		waitForElementVisible(driver, UserNotebooksPageUIs.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserNotebooksPageUIs.ADD_TO_CART_BUTTON);
	}
}
