package pageObjectNopcommerceUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.User.UserComputersPageUIs;
import pageUIs.Nopcommerce.User.UserCustomerInfoPageUIs;
import pageUIs.Nopcommerce.User.UserNotebooksPageUIs;

public class UserComputersPageObject extends BasePage {
	private WebDriver driver;
	public UserComputersPageObject(WebDriver driver) {
		this.driver = driver;
	}
	/** Click to link type computers by text
	 * @param driver
	 * @param inputValue
	 */
	public void clickToLinkTypeComputers(WebDriver driver,String inputValue){
		waitForElementVisible(driver, UserComputersPageUIs.NAME_TYPE_COMPUTERS, inputValue);
		clickToElement(driver, UserComputersPageUIs.NAME_TYPE_COMPUTERS, inputValue);
	}
}
