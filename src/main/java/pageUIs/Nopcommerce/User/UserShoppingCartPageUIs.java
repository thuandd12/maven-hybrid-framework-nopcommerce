package pageUIs.Nopcommerce.User;

public class UserShoppingCartPageUIs {
	public static final String NAME_PRODUCT = "xpath=//a[text()='%s' and @class='product-name']";
	public static final String INFORMATION_PRODUCT = "xpath=//a[text()='%s']//following-sibling::div[@class='attributes']";
	public static final String PRICE_TOTAL = "xpath=//a[text()='%s']//parent::td//following-sibling::td[@class='subtotal']//span";
	public static final String QUANTITY_TEXTBOX = "xpath=//a[text()='%s' and @class ='product-name']//parent::td//following-sibling::td[@class='quantity']//input";
	public static final String REMOVE_BUTTON = "xpath=//button[@class='remove-btn']";
}
