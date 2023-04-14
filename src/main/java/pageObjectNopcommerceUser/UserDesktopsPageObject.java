package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserDesktopsPageUIs;

public class UserDesktopsPageObject extends BasePage {
	private WebDriver driver;
	public UserDesktopsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getPriceBuildOwnComputer(WebDriver driver) {
		waitForElementVisible(driver, UserDesktopsPageUIs.PRICE_BUILD_YOUR_OWN_COMPUTER);
		return getElementText(driver, UserDesktopsPageUIs.PRICE_BUILD_YOUR_OWN_COMPUTER);
	}
	
	
}
