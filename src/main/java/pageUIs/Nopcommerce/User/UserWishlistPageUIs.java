package pageUIs.Nopcommerce.User;

public class UserWishlistPageUIs {
	public static final String SHARE_LINK = "xpath=//a[@class='share-link']";
	public static final String WISHLIST_OF_NAME = "xpath=//div[@class='page-title']//h1";
	public static final String ADD_TO_CART_TEXTBOX = "xpath=//a[text()='%s']//parent::td//preceding-sibling::td[@class='add-to-cart']//input";
	public static final String WISHLIST_EMPTY = "xpath=//div[@class='no-data']";
	public static final String REMOVE_BUTTON = "xpath=//a[text()='%s']//parent::td//following-sibling::td[@class='remove-from-cart']//button";
	public static final String NAME_PRODUCT = "xpath=//a[text()='%s' and @class='product-name']";

}
