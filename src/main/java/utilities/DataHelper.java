package utilities;

import java.util.Locale;
import java.util.Random;

import org.joda.time.DateTime;

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
	public String getLastName() {
		return faker.address().lastName();
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
	public int generateFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }
	public String getCurrentDate() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	public String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	public String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}

	public String getCurrentDay() {
		return getCurrentYear() + "/" + getCurrentMonth() + "/" + getCurrentDate();
	}

}
