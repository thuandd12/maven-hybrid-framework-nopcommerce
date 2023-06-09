package dataNopcommerce.User;

import utilities.DataHelper;

public class DataCommons {
	private static DataHelper data = DataHelper.getData();

	public static class DataRegister {

		public static final String FIRSTNAME = data.getFirstName();
		public static final String LASTNAME = data.getLastName();
		public static final String ERROR_EMAIL = "abcd";
		public static final String EMAIL_ADDRESS = data.getEmail();
		public static final String PASSWORD = "123123";
		public static final String PASSWORD_LESS_THAN_6_CHARACTERS = "123";
		public static final String DIFFERENT_PASSWORD = "123456";
	}

	public static class DataLogin {
		public static final String FIRSTNAME = data.getFirstName();
		public static final String LASTNAME = data.getLastName();
		public static final String EMAIL_ADDRESS = data.getEmail();
		public static final String ERROR_EMAIL = "abcd";
		public static final String PASSWORD = "123123";
		public static final String DIFFERENT_PASSWORD = "123456";
		public static final String WRONG_PASSWORD = "123456";

	}
	public static class CustomerInfor {
		public static final String FIRSTNAME = data.getFirstName();
		public static final String LASTNAME = data.getLastName();
		public static final String EMAIL_ADDRESS = data.getEmail();
		public static final String PASSWORD = "123123";
		public static final String FIRSTNAME_UPDATE = "Automation";
		public static final String LASTNAME_UPDATE = "FC";
		public static final String DAY = "9";
		public static final String MONTH = "April";
		public static final String YEAR = "1997";
		public static final String EMAIL_ADDRESS_UPDATE = "Automation" + data.generateFakeNumber() + "@gmail.com";
		public static final String COMPANY_NAME = data.getCompanyName();

	}
	public static class DataAddresses {
		public static final String FIRSTNAME = data.getFirstName();
		public static final String LASTNAME = data.getLastName();
		public static final String EMAIL_ADDRESS = data.getEmail();
		public static final String COMPANY_NAME = data.getCompanyName();
		public static final String STATE_PROVINCE = "Other";
		public static final String CONTRY = "Viet Nam";
		public static final String CITY = "Ha Noi";
		public static final String ADDRESS_1 = "123 Giai Phong";
		public static final String ADDRESS_2 = "234 Nguyen Trai";
		public static final String ZIP_POSTAL_CODE = "Ha Noi";
		public static final String PHONE_NUMBER = data.getNumberPhone();
		public static final String FAX_NUMBER = "0987654321";

	}
	public static class DataChangePassword {
		public static final String OLD_PASSWORD = "123123";
		public static final String NEW_PASSWORD = "123456";
	}
	public static class DataMyProductReviews {
		public static final String REVIEW_TITLE = "Nice MacBook";
		public static final String REVIEW_TEXT = "Good quality";
		public static final String CURRENT_DAY = data.getCurrentDay();
		
	}
	public static class DataSearchAdvancedSearch {
		public static final String FIRSTNAME = data.getFirstName();
		public static final String LASTNAME = data.getLastName();
		public static final String EMAIL_ADDRESS = data.getEmail();
		public static final String PASSWORD = "123123";
		public static final String DATA_NOT_EXIST = "Macbook Pro 2060";
		public static final String DATA_RELATIVE = "Lenovo";
		public static final String DATA_ABSOLUTO = "ThinkPad X1 Carbon";
		public static final String SEARCH_KYEWORD = " Apple MacBook Pro 13-inch";
		public static final String CATEGORY = "Computers";
		public static final String INCORRECT_MANUFATURER = "HP";
		public static final String CORRECT_MANUFATURER = "Apple";
	}
	public static class DataNotebooks {
		public static final String SORT_NAME_A_TO_Z = "Name: A to Z";
		public static final String SORT_NAME_Z_TO_A = "Name: Z to A";
		public static final String SORT_PRICE_LOW_TO_HIGH = "Price: Low to High";
		public static final String SORT_PRICE_HIGH_TO_LOW = "Price: High to Low";
		
	}
	
	public static class DataWishlistCompareRecentView {
		public static final String FIRSTNAME = data.getFirstName();
		public static final String LASTNAME = data.getLastName();
		public static final String EMAIL_ADDRESS = data.getEmail();
		public static final String PASSWORD = "123123";
	}
	public static class DataOrder {
		public static final String FIRSTNAME = data.getFirstName();
		public static final String LASTNAME = data.getLastName();
		public static final String EMAIL_ADDRESS = data.getEmail();
		public static final String PASSWORD = "123123";
		public static final String PROCESSOR = "2.2 GHz Intel Pentium Dual-Core E2200";
		public static final String RAM = "4GB [+$20.00]";
		public static final String OS = "Vista Premium [+$60.00]";
		public static final String MYCROSORT_OFFICE = "Microsoft Office [+$50.00]";
		public static final String ACROBAT_READER = "Acrobat Reader [+$10.00]";
		public static final String TOTAL_COMMANDER = "Total Commander [+$5.00]";
		public static final String HDD = "400 GB [+$100.00]";
		public static final String EDIT_PROCESSOR = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		public static final String EDIT_RAM = "8GB [+$60.00]";
		public static final String EDIT_OS = "Vista Home [+$50.00]";
		public static final String EDIT_HDD = "320 GB";
		public static final String QUANTITY = "2";
		public static final String QUANTITY_UPDATE = "5";
		public static final String TOTAL_PRICE_UPDATE = "$2,500.00";
		public static final String COUNTRY = "Viet Nam";
		public static final String CITY = "Ha Noi";
		public static final String ADDRESS1 = "123 Giai Phong";
		public static final String PHONE_NUMBER = "0123456789";
		public static final String ZIP = "550000";
	}
	public static class DataAdminSearch {
		public static final String PRODUCT_NAME = "Lenovo IdeaCentre 600 All-in-One PC";
		public static final String CATEGORY = "Computers";
		public static final String CATEGORY1 = "Computers >> Desktops";
		public static final String CATEGORY2 = "All";
		public static final String MANUFACTURER = "Apple";
		public static final String SKU = "LE_IC_600";
	}
	public static class DataAdminCustomer {
		public static final String FIRSTNAME = data.getFirstName();
		public static final String LASTNAME = data.getLastName();
		public static final String EMAIL_ADDRESS = data.getEmail();
		public static final String PASSWORD = "123123";
		public static final String COMPANY_NAME = data.getCompanyName();
		public static final String ADMIN_COMMENT = "Add new customer (guest)";
		public static final String DATE_OF_BIRTH = "9/1/1999";
		public static final String CUSTOMER_ROLES = "Guests";
		public static final String EDIT_FIRSTNAME ="Edit " + data.getFirstName();
		public static final String EDIT_LASTNAME ="Edit " + data.getLastName();
		public static final String EDIT_EMAIL_ADDRESS ="edit" + data.getEmail();
		public static final String EDIT_COMPANY_NAME = "Edit " + data.getCompanyName();
		public static final String EDIT_ADMIN_COMMENT ="Edit " + "Add new customer (guest)";
		public static final String EDIT_DATE_OF_BIRTH = "1/9/1999";
	}
	

}
