package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);
	public static DataHelper getData() {
		return new DataHelper();
	}
	public String getFirstName() {
		return faker.address().firstName();
	}
	public String getCompanyName() {
		return faker.company().name();
	}
	public String getFullName() {
		return faker.name().fullName();
	}
	public String getAddress() {
		return faker.address().streetAddress();
	}
	public String getEmail() {
		return faker.internet().emailAddress();
	}
	public String getNumberPhone() {
		return faker.phoneNumber().phoneNumber();
	}
	public String getCityName() {
		return faker.address().cityName();
	}

}
