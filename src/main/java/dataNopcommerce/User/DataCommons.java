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
	public static class DataMyAccount {
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

}
