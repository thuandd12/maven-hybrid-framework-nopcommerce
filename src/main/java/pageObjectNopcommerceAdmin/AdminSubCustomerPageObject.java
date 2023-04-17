package pageObjectNopcommerceAdmin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.Admin.AdminSubCustomerPageUIs;

public class AdminSubCustomerPageObject extends BasePage {
	private WebDriver driver;
	public AdminSubCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void deleteAttributeInCustomerRoles(WebDriver driver) {
		waitForElementClickable(driver, AdminSubCustomerPageUIs.DELETE_ATTRIBUTE_IN_CUSTOMER_ROLES);
		clickToElement(driver, AdminSubCustomerPageUIs.DELETE_ATTRIBUTE_IN_CUSTOMER_ROLES);
	}
	public void selectToAttributeInCustomerRoles(WebDriver driver, String inputValue) {
		waitForElementClickable(driver, AdminSubCustomerPageUIs.CUSTOMER_ROLES_DROPDOWN);
		clickToElement(driver, AdminSubCustomerPageUIs.CUSTOMER_ROLES_DROPDOWN);
		waitForElementClickable(driver, AdminSubCustomerPageUIs.ATTRIBUTE_IN_CUSTOMER_ROLES, inputValue);
		clickToElement(driver, AdminSubCustomerPageUIs.ATTRIBUTE_IN_CUSTOMER_ROLES, inputValue);
	}
	public boolean isTextInformationDisplayed(WebDriver driver, String inputValue) {
		waitForElementVisible(driver, AdminSubCustomerPageUIs.TEXT_INFORMATION, inputValue);
		return isElementDisplay(driver, AdminSubCustomerPageUIs.TEXT_INFORMATION, inputValue);
	}
	public boolean isMessageAddedSuccess(WebDriver driver) {
		waitForElementVisible(driver, AdminSubCustomerPageUIs.MESSAGE_ADDED_SUCESS);
		return isElementDisplay(driver, AdminSubCustomerPageUIs.MESSAGE_ADDED_SUCESS);
	}
}
