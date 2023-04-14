package pageUIs.Nopcommerce.User;

public class UserCompareProductListPageUIs {
	public static final String PRODUCT_NAME = "xpath=//tr[@class='product-name']//a[text()='%s']";
	public static final String PRICE_PRODUCT = "xpath=//a[text()='%s']//parent::td//parent::tr//following-sibling::tr[@class='product-price']//td[text()='%s']";
	public static final String NOTIFICATION_MESSAGE = "xpath=//div[@class='no-data']";
}
