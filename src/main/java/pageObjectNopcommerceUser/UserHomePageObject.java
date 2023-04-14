package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserHomePageUIs;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToProductNameByJS(WebDriver driver,String inputValue) {
		waitForElementVisible(driver, UserHomePageUIs.NAME_TEXT_LINK, inputValue);
		clickToElement(driver, UserHomePageUIs.NAME_TEXT_LINK, inputValue);
	}
	public void clickToComputersLink(WebDriver driver) {
		waitForElementVisible(driver, UserHomePageUIs.COMPUTERS_LINK);
		clickToElement(driver, UserHomePageUIs.COMPUTERS_LINK);
	}
	
	
}
