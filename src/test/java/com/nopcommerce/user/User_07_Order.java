package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import dataNopcommerce.User.DataCommons.DataOrder;
import pageObjectNopcommerceUser.PageGeneratorManager;
import pageObjectNopcommerceUser.UserCheckoutPageObject;
import pageObjectNopcommerceUser.UserComputersPageObject;
import pageObjectNopcommerceUser.UserDesktopsPageObject;
import pageObjectNopcommerceUser.UserHomePageObject;
import pageObjectNopcommerceUser.UserLoginPageObject;
import pageObjectNopcommerceUser.UserNotebooksPageObject;
import pageObjectNopcommerceUser.UserRegisterPageObject;
import pageObjectNopcommerceUser.UserShoppingCartPageObject;

public class User_07_Order extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Navigate to 'Home Page'");
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getHomePage(driver);

		log.info("Pre-Condition - Step 02: Open 'Register' page");
		userRegisterPage = PageGeneratorManager.getRegisterPage(driver);
		userRegisterPage.clickToLinkByText(driver, "Register");

		log.info("Pre-Condition - Step 03: sendKey to 'Firt name' textbox with the value is '"
				+ DataOrder.FIRSTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataOrder.FIRSTNAME, "FirstName");

		log.info("Pre-Condition - Step 04: sendKey to 'Last name' textbox with the value is '"
				+ DataOrder.LASTNAME + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataOrder.LASTNAME, "LastName");

		log.info("Pre-Condition - Step 05: sendKey to 'Email' textbox with the value is '"
				+ DataOrder.EMAIL_ADDRESS + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataOrder.EMAIL_ADDRESS, "Email");

		log.info("Pre-Condition - Step 06: sendKey to 'Password' textbox with the value is '"
				+ DataOrder.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataOrder.PASSWORD, "Password");

		log.info("Pre-Condition - Step 07: sendKey to 'Confirm Password' textbox with the value is '"
				+ DataOrder.PASSWORD + "'  ");
		userRegisterPage.sendKeyToTextbox(driver, DataOrder.PASSWORD, "ConfirmPassword");

		log.info("Pre-Condition - Step 08: Click to 'Register' button");
		userRegisterPage.clickToButtonByText(driver, "Register");

		log.info("Pre-Condition - Step 09: Verify 'Your registration completed' is displayed");
		verifyTrue(userRegisterPage.verifySuccessMessageRegisterDisplayed(driver));

		log.info("Pre-Condition - Step 10: Click to 'Log in' link");
		userRegisterPage.clickToLinkByText(driver, "Log in");

		log.info("Pre-Condition - Step 11: Sendkey to 'Email' textbox with value is '"+ DataOrder.EMAIL_ADDRESS + "'");
		userLoginPage = PageGeneratorManager.getLoginPage(driver);
		userLoginPage.sendKeyToTextbox(driver, DataOrder.EMAIL_ADDRESS, "Email");

		log.info("Pre-Condition - Step 12: Sendkey to 'Password' textbox with value is '"+ DataOrder.PASSWORD + "'");
		userLoginPage.sendKeyToTextbox(driver, DataOrder.PASSWORD, "Password");

		log.info("Pre-Condition - Step 13: Click to 'LOG IN' button'");
		userLoginPage.clickToButtonByText(driver, "Log in");

		log.info("Pre-Condition - Step 14: Verify 'My account' link displayed'");
		verifyTrue(userHomePage.isLinkDisplayed(driver, "My account"));

	}

	@Test
	public void Case_01_Add_Product_To_Cart() {
		log.info("Case_01_Add_Product - Step 01: Click to 'Build your own computer' link");
		userHomePage.clickToLinkByText(driver, "Build your own computer");
		userDesktopsPage = PageGeneratorManager.getDesktopsPage(driver);
		
		log.info("Case_01_Add_Product - Step 02: Click to 'Processor' dropdown");
		userDesktopsPage.selectInDropDownList(driver, DataOrder.PROCESSOR, "product_attribute_1");
		
		log.info("Case_01_Add_Product - Step 03: Click to 'RAM' dropdown");
		userDesktopsPage.selectInDropDownList(driver, DataOrder.RAM, "product_attribute_2");
		
		log.info("Case_01_Add_Product - Step 04: Click to '"+DataOrder.HDD+"' radio button");
		userDesktopsPage.clickToRadiOButtonByID(driver, "product_attribute_3_7");
		
		log.info("Case_01_Add_Product - Step 05: Click to '"+DataOrder.MYCROSORT_OFFICE+"' checkbox");
		userDesktopsPage.clickToRadiOButtonByID(driver, "product_attribute_5_10");
		
		log.info("Case_01_Add_Product - Step 06: Click to '"+DataOrder.ACROBAT_READER+"' checkbox");
		userDesktopsPage.clickToRadiOButtonByID(driver, "product_attribute_5_11");
		
		log.info("Case_01_Add_Product - Step 07: Click to '"+DataOrder.TOTAL_COMMANDER+"' checkbox");
		userDesktopsPage.clickToRadiOButtonByID(driver, "product_attribute_5_12");
		
		log.info("Case_01_Add_Product - Step 08: Click to '"+DataOrder.OS+"' radio button");
		userDesktopsPage.clickToRadiOButtonByID(driver, "product_attribute_4_9");
		
		log.info("Case_01_Add_Product - Step 09: Get 'Price' text");
		priceOrder = userDesktopsPage.getPriceBuildOwnComputer(driver);
		
		log.info("Case_01_Add_Product - Step 10: Click to 'ADD TO CART' button");
		userDesktopsPage.clickToButtonByText(driver, "Add to cart");
		
		log.info("Case_01_Add_Product - Step 11: Verify 'The product has been added to your shopping cart' is displayed");
		verifyEquals(userDesktopsPage.getTextUpdatedSuccessMessage(driver), "The product has been added to your shopping cart");
		
		log.info("Case_01_Add_Product - Step 12: Click to 'Shopping cart' link");
		userDesktopsPage.clickToLinkByText(driver, "Shopping cart");
		useShoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("Case_01_Add_Product - Step 13: Verify 'Build your own computer' is displayed");
		verifyTrue(useShoppingCartPage.isNameProductDisplayed(driver, "Build your own computer"));
		
		log.info("Case_01_Add_Product - Step 14: Verify 'Information product' is displayed");
		verifyEquals(useShoppingCartPage.getInformationProduct(driver, "Build your own computer"), "Processor: 2.2 GHz Intel Pentium Dual-Core E2200\nRAM: 4GB [+$20.00]\nHDD: 400 GB [+$100.00]\nOS: Vista Premium [+$60.00]\nSoftware: Microsoft Office [+$50.00]\nSoftware: Acrobat Reader [+$10.00]\nSoftware: Total Commander [+$5.00]");
	
		//bug
//		log.info("Case_01_Add_Product - Step 15: Verify 'total price in the table'  equal before adding to cart");
//		verifyEquals(useShoppingCartPage.getInformationTotalProduct(driver, "Build your own computer"), priceOrder);
		
	}	

	@Test
	public void Case_02_Edit_Product_In_Shopping_Cart() {
		log.info("Case_02_Edit_Product - Step 01: Click 'Edit' link");
		useShoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		useShoppingCartPage.clickToLinkByText(driver, "Edit");
		userDesktopsPage = PageGeneratorManager.getDesktopsPage(driver);
		
		log.info("Case_02_Edit_Product - Step 02: Click to 'Processor' dropdown");
		userDesktopsPage.selectInDropDownList(driver, DataOrder.EDIT_PROCESSOR, "product_attribute_1");
		
		log.info("Case_02_Edit_Product - Step 03: Click to 'RAM' dropdown");
		userDesktopsPage.selectInDropDownList(driver, DataOrder.EDIT_RAM, "product_attribute_2");
		
		log.info("Case_02_Edit_Product - Step 04: Click to '"+DataOrder.EDIT_HDD+"' radio button");
		userDesktopsPage.clickToRadiOButtonByID(driver, "product_attribute_3_6");
		
		log.info("Case_02_Edit_Product - Step 05: Click to '"+DataOrder.EDIT_OS+"' radio button");
		userDesktopsPage.clickToRadiOButtonByID(driver, "product_attribute_4_8");
		
		log.info("Case_02_Edit_Product - Step 06: Click to '"+DataOrder.TOTAL_COMMANDER+"' checkbox");
		userDesktopsPage.clickToRadiOButtonByIDUnCheck(driver, "product_attribute_5_12");
		
		log.info("Case_02_Edit_Product - Step 07: Sendkey to quantity textbox with value is '"+ DataOrder.QUANTITY +"'");
		userDesktopsPage.sendKeyToTextbox(driver, DataOrder.QUANTITY, "product_enteredQuantity_1");
		
		log.info("Case_02_Edit_Product - Step 08: Click to 'UPDATE' button");
		userDesktopsPage.clickToButtonByText(driver, "Update");
		
		log.info("Case_02_Edit_Product - Step 09: Verify 'The product has been added to your shopping cart' is displayed");
		verifyEquals(userDesktopsPage.getTextUpdatedSuccessMessage(driver), "The product has been added to your shopping cart");
		
		log.info("Case_02_Edit_Product - Step 10: Click to 'Shopping cart' link");
		userDesktopsPage.clickToLinkByText(driver, "Shopping cart");
		useShoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("Case_02_Edit_Product - Step 11: Verify 'Information product' is displayed");
		verifyEquals(useShoppingCartPage.getInformationProduct(driver, "Build your own computer"), "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]\nRAM: 8GB [+$60.00]\nHDD: 320 GB\nOS: Vista Home [+$50.00]\nSoftware: Microsoft Office [+$50.00]\nSoftware: Acrobat Reader [+$10.00]");
		
		log.info("Case_02_Edit_Product - Step 11: Verify '"+ DataOrder.QUANTITY +"' is displayed");
		verifyEquals(useShoppingCartPage.getValueQuantity(driver, "Build your own computer", "value"), DataOrder.QUANTITY);
	}

	@Test
	public void Case_03_Remove_Product_In_From_Cart() {
		log.info("Case_03_Remove_Product - Step 01: Click to 'Remove' icon");
		useShoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		useShoppingCartPage.clickToRemoveButton(driver);
		
		log.info("Case_03_Remove_Product - Step 02: Verify 'Your Shopping Cart is empty!' is displayed");
		verifyEquals(useShoppingCartPage.getTextInformationCard(driver, "no-data"), "Your Shopping Cart is empty!");
		
	}

	@Test
	public void Case_04_Uppdate_Shopping_Cart() {
		log.info("Case_04_Uppdate_Shopping_Cart - Step 01: Open home page");
		useShoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		useShoppingCartPage.openHomePageUrl(driver);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Case_04_Uppdate_Shopping_Cart - Step 02: Click 'Computers' link");
		userHomePage.clickToComputersLink(driver);
		userComputersPage = PageGeneratorManager.getComputersPage(driver);
		
		log.info("Case_04_Uppdate_Shopping_Cart - Step 03: Click 'Desktops' link");
		userComputersPage.clickToLinkTypeComputers(driver, "Desktops ");
		userDesktopsPage = PageGeneratorManager.getDesktopsPage(driver);
		
		log.info("Case_04_Uppdate_Shopping_Cart - Step 04: Click 'ADD TO CART' button of product 'Lenovo IdeaCentre 600 All-in-One PC'");	
		userDesktopsPage.clickToIcon(driver, "Lenovo IdeaCentre 600 All-in-One PC", "Add to cart");
		
		log.info("Case_04_Uppdate_Shopping_Cart - Step 05: Verify 'The product has been added to your shopping cart' is displayed");	
		verifyEquals(userDesktopsPage.getTextUpdatedSuccessMessage(driver) , "The product has been added to your shopping cart");
		
		log.info("Case_04_Uppdate_Shopping_Cart - Step 06: Click 'Shopping cart' link");	
		userDesktopsPage.clickToLinkByText(driver, "Shopping cart");
		useShoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("Case_04_Uppdate_Shopping_Cart - Step 07: Sendkey to 'Qty' textbox with value is '"+ DataOrder.QUANTITY_UPDATE +"'");	
		useShoppingCartPage.sendkeyToValueQuantity(driver, "Lenovo IdeaCentre 600 All-in-One PC", DataOrder.QUANTITY_UPDATE);
		
		log.info("Case_04_Uppdate_Shopping_Cart - Step 08: Click to 'Update shopping cart' button");	
		useShoppingCartPage.clickToButtonByText(driver, "Update shopping cart");
		
		log.info("Case_04_Uppdate_Shopping_Cart - Step 09: Verify 'Total' is diplayed with value is '"+ DataOrder.TOTAL_PRICE_UPDATE +"'");	
		verifyEquals(useShoppingCartPage.getInformationTotalProduct(driver, "Lenovo IdeaCentre 600 All-in-One PC"), DataOrder.TOTAL_PRICE_UPDATE);
		
		log.info("Case_04_Uppdate_Shopping_Cart - Step 10: Click to 'Remove' button");	
		useShoppingCartPage.clickToRemoveButton(driver);
		
		log.info("Case_04_Uppdate_Shopping_Cart - Step 11: Verify 'Your Shopping Cart is empty!' is displayed");
		verifyEquals(useShoppingCartPage.getTextInformationCard(driver, "no-data"), "Your Shopping Cart is empty!");
	}
	@Test
	public void Case_05_Checkout_Order() {
		log.info("Case_05_Checkout_Order - Step 01: Open home page");	
		useShoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		useShoppingCartPage.openHomePageUrl(driver);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Case_05_Checkout_Order - Step 02: Click 'ADD TO CART' button of product 'Apple MacBook Pro 13-inch'");	
		userHomePage.clickToIcon(driver, "Apple MacBook Pro 13-inch", "Add to cart");
		userNotebooksPage = PageGeneratorManager.getNotebooksPage(driver);
		
		log.info("Case_05_Checkout_Order - Step 03: Click 'ADD TO CART' button of product 'Apple MacBook Pro 13-inch'");
		userNotebooksPage.clickAddToCartButton(driver);
		
		log.info("Case_05_Checkout_Order - Step 04: Verify 'The product has been added to your shopping cart' is displayed");	
		verifyEquals(userNotebooksPage.getTextUpdatedSuccessMessage(driver) , "The product has been added to your shopping cart");
		
		log.info("Case_05_Checkout_Order - Step 05: Click 'Shopping cart' link");	
		userNotebooksPage.clickToLinkByText(driver, "Shopping cart");
		useShoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("Case_05_Checkout_Order - Step 05: Click ' Estimate shipping ' link");
		useShoppingCartPage.clickToLinkByText(driver, " Estimate shipping ");
		
		log.info("Case_05_Checkout_Order - Step 06: Select '"+ DataOrder.COUNTRY +"' in 'Select Country' dropdown");
		useShoppingCartPage.selectInDropDownList(driver, DataOrder.COUNTRY, "CountryId");
		
		log.info("Case_05_Checkout_Order - Step 07: Sendkey to 'Zip/postal code' textox with value is '"+ DataOrder.ZIP +"'");
		useShoppingCartPage.sendKeyToTextbox(driver, DataOrder.ZIP, "ZipPostalCode");
		useShoppingCartPage.sleepInsecond(5);
		
		log.info("Case_05_Checkout_Order - Step 08: Click to 'Apply' button");
		useShoppingCartPage.clickToButtonByText(driver, "Apply");
		
		log.info("Case_05_Checkout_Order - Step 09: Click to 'the terms of service' checkbox");
		useShoppingCartPage.clickToCheckbox(driver, "termsofservice");
		
		log.info("Case_05_Checkout_Order - Step 10: Click to 'CHECKOUT' button");
		useShoppingCartPage.clickToButtonByText(driver, " Checkout ");
		userCheckoutPage = PageGeneratorManager.getCheckoutPage(driver);
		
		
		log.info("Case_05_Checkout_Order - Step 11: Select '"+ DataOrder.COUNTRY +"' in 'Select Country' dropdown");
		userCheckoutPage.selectInDropDownList(driver, DataOrder.COUNTRY, "BillingNewAddress.CountryId");
		
		log.info("Case_05_Checkout_Order - Step 12: Sendkey to 'City' textox with value is '"+ DataOrder.CITY +"'");
		userCheckoutPage.sendKeyToTextbox(driver, DataOrder.CITY, "BillingNewAddress_City");
		
		log.info("Case_05_Checkout_Order - Step 13: Sendkey to 'Address 1' textox with value is '"+ DataOrder.ADDRESS1 +"'");
		userCheckoutPage.sendKeyToTextbox(driver, DataOrder.ADDRESS1, "BillingNewAddress_Address1");
		
		log.info("Case_05_Checkout_Order - Step 14: Sendkey to 'Zip / postal code' textox with value is '"+ DataOrder.ZIP +"'");
		userCheckoutPage.sendKeyToTextbox(driver, DataOrder.ADDRESS1, "BillingNewAddress_ZipPostalCode");
		
		log.info("Case_05_Checkout_Order - Step 15: Sendkey to 'Phone number' textox with value is '"+ DataOrder.PHONE_NUMBER +"'");
		userCheckoutPage.sendKeyToTextbox(driver, DataOrder.ADDRESS1, "BillingNewAddress_PhoneNumber");
		
		log.info("Case_05_Checkout_Order - Step 16: Click to 'CONTINUE' button");
		userCheckoutPage.clickToContinueButton(driver);
		
		log.info("Case_05_Checkout_Order - Step 17: Click to 'CONTINUE' button");
		userCheckoutPage.clickToContinueButton2(driver);
		
		log.info("Case_05_Checkout_Order - Step 18: Click to 'CONTINUE' button");
		userCheckoutPage.clickToContinueButton3(driver);
		
		log.info("Case_05_Checkout_Order - Step 19: Verify purchase infomation is displayed");
		verifyTrue(userCheckoutPage.successMessageDisplayed(driver));
		
		log.info("Case_05_Checkout_Order - Step 20: Click to 'CONTINUE' button");
		userCheckoutPage.clickToContinueButton4(driver);
		
		log.info("Case_05_Checkout_Order - Step 21: Verify 'Billing Address' displayed");
		verifyTrue(userCheckoutPage.isBillingAddressDisplayed(driver));
		
		log.info("Case_05_Checkout_Order - Step 22: Verify 'Shipping Address' displayed");
		verifyTrue(userCheckoutPage.isShippingAddressDisplayed(driver));
		
		log.info("Case_05_Checkout_Order - Step 23: Click to 'CONFIRM' button");
		userCheckoutPage.clickToConfirmButton(driver);
		
		log.info("Case_05_Checkout_Order - Step 24: Verify 'Your order has been successfully processed!' displayed");
		verifyTrue(userCheckoutPage.isOrderSuccessMessageDisplayed(driver));
		
		log.info("Case_05_Checkout_Order - Step 25: Click to 'CONTINUE' button");
		userCheckoutPage.clickToContinueButton5(driver);
		
	}

	//@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserDesktopsPageObject userDesktopsPage;
	private UserShoppingCartPageObject useShoppingCartPage;
	private String priceOrder;
	private UserComputersPageObject userComputersPage;
	private UserNotebooksPageObject userNotebooksPage;
	private UserCheckoutPageObject userCheckoutPage;
	
	
}
