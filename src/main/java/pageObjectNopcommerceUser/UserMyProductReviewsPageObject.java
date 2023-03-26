package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserMyProductReviewPageUIs;

public class UserMyProductReviewsPageObject extends BasePage {
	private WebDriver driver;
	public UserMyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	/** Get current day by text
	 * @param driver
	 * @param locatorType
	 * @return
	 */
	public String getCurrentDay(WebDriver driver,String locatorType) {
		waitForElementVisible(driver, UserMyProductReviewPageUIs.CURRENT_DAY, locatorType);
		return getElementText(driver, UserMyProductReviewPageUIs.CURRENT_DAY, locatorType);
	}
}
