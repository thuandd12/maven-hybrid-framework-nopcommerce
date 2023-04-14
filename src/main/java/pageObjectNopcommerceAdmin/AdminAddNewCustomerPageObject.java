package pageObjectNopcommerceAdmin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.Admin.AdminAddNewCustomerPageUIs;

public class AdminAddNewCustomerPageObject extends BasePage {
	private WebDriver driver;
	public AdminAddNewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void deleteAttributeInCustomerRoles(WebDriver driver) {
		waitForElementClickable(driver, AdminAddNewCustomerPageUIs.DELETE_ATTRIBUTE_IN_CUSTOMER_ROLES);
		clickToElement(driver, AdminAddNewCustomerPageUIs.DELETE_ATTRIBUTE_IN_CUSTOMER_ROLES);
	}
	public void sendkeyToAdminCommentTextbox(WebDriver driver, String inputValue) {
		waitForElementVisible(driver, AdminAddNewCustomerPageUIs.ADMIN_COMMENT_TEXTBOX, inputValue);
		sendkeyToElement(driver, AdminAddNewCustomerPageUIs.ADMIN_COMMENT_TEXTBOX, inputValue);
	}
	public void selectToAttributeInCustomerRoles(WebDriver driver, String inputValue) {
		waitForElementClickable(driver, AdminAddNewCustomerPageUIs.ATTRIBUTE_IN_CUSTOMER_ROLES, inputValue);
		clickToElement(driver, AdminAddNewCustomerPageUIs.ATTRIBUTE_IN_CUSTOMER_ROLES, inputValue);
	}
	public void clickToSaveAndContinueEditButton(WebDriver driver) {
		waitForElementClickable(driver, AdminAddNewCustomerPageUIs.SAVE_AND_CONTINUE_EDIT_BUTTON);
		clickToElement(driver, AdminAddNewCustomerPageUIs.SAVE_AND_CONTINUE_EDIT_BUTTON);
	}


}
