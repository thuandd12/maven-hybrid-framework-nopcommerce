package pageObjectNopcommerceAdmin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.Admin.AdminEditProductDetailsPageUIs;

public class AdminEditProductDetailsPageObject extends BasePage {
	private WebDriver driver;
	public AdminEditProductDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isEditProductDetailsPageDisplayed(WebDriver driver) {
		waitForElementVisible(driver, AdminEditProductDetailsPageUIs.CONTENT_EDIT_PRODUCT_DETAILS);
		return isElementDisplay(driver, AdminEditProductDetailsPageUIs.CONTENT_EDIT_PRODUCT_DETAILS);
	}
	public boolean isNameProductDisplayed(WebDriver driver, String inputValue) {
		waitForElementVisible(driver, AdminEditProductDetailsPageUIs.NAME_PRODUCT, inputValue);
		return isElementDisplay(driver, AdminEditProductDetailsPageUIs.NAME_PRODUCT, inputValue);
	}

}
