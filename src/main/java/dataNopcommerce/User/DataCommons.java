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
	

}
