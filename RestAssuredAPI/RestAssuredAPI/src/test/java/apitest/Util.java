package apitest;

import org.apache.commons.lang3.RandomStringUtils;

public class Util {
		
	public static String getFirstName() {
		String generateFirstName = RandomStringUtils.randomAlphabetic(2).toLowerCase();
		return ("Joh" + generateFirstName);
	}
	
	public static String getLastName() {
		String generateLastName = RandomStringUtils.randomAlphabetic(2).toLowerCase();
		return ("Matt" + generateLastName);
	}

	public static String getUserName() {
		String generateUserName = RandomStringUtils.randomAlphabetic(3).toLowerCase();
		return ("John." + generateUserName);
	}
	
	public static String getPassword() {
		String generatePassword = RandomStringUtils.randomAlphabetic(4).toLowerCase();
		return ("John" + generatePassword);
	}
	
	public static String getEmail() {
		String generateEmail = RandomStringUtils.randomAlphabetic(4).toLowerCase();
		return (generateEmail + "@fakemail.com");
	}
	
}
