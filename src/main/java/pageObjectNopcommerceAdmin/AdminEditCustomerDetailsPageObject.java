package pageObjectNopcommerceAdmin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Nopcommerce.Admin.AdminEditCustomerDetailsPageUIs;

public class AdminEditCustomerDetailsPageObject extends BasePage {
	private WebDriver driver;
	public AdminEditCustomerDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isMessageAddedSuccess(WebDriver driver) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUIs.MESSAGE_ADDED_SUCESS);
		return isElementDisplay(driver, AdminEditCustomerDetailsPageUIs.MESSAGE_ADDED_SUCESS);
	}
	public boolean isValueInCustomerRolesDisplayed(WebDriver driver, String inputValue) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUIs.VALUE_IN_CUSTOMER_ROLES, inputValue);
		return isElementDisplay(driver, AdminEditCustomerDetailsPageUIs.VALUE_IN_CUSTOMER_ROLES, inputValue);
	}
	public String getTextInAdminComentTextbox(WebDriver driver) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUIs.ADMIN_COMMENT_TEXTBOX);
		return getElementText(driver, AdminEditCustomerDetailsPageUIs.ADMIN_COMMENT_TEXTBOX);
	}
	public String sendkeyToAdminCommentTextbox(WebDriver driver2, String adminComment) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUIs.ADMIN_COMMENT_TEXTBOX);
		return getElementText(driver, AdminEditCustomerDetailsPageUIs.ADMIN_COMMENT_TEXTBOX);
	}

}
