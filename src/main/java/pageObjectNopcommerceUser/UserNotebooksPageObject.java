package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserCustomerInfoPageUIs;
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
}
