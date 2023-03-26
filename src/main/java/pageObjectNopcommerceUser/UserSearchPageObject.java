package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserSearchPageUIs;

public class UserSearchPageObject extends BasePage {
	private WebDriver driver;
	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToSearchAdvancedButton(WebDriver driver) {
		waitForElementClickable(driver, UserSearchPageUIs.SEARCH_ADVANCED_BUTTON);
		clickToElement(driver, UserSearchPageUIs.SEARCH_ADVANCED_BUTTON);
	}
}
