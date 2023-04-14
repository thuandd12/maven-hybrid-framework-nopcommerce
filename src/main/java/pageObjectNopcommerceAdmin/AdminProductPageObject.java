package pageObjectNopcommerceAdmin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.Admin.AdminProductPageUIs;

public class AdminProductPageObject extends BasePage {
	private WebDriver driver;
	public AdminProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isProductDisplayed(WebDriver driver, String inputValue) {
		waitForElementVisible(driver, AdminProductPageUIs.NAME_PRODUCT, inputValue);
		return isElementDisplay(driver, AdminProductPageUIs.NAME_PRODUCT, inputValue);
	}

}
