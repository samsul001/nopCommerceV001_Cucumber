package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomer;

public class BaseClass {
	
	WebDriver driver;
	LoginPage lp;
	AddCustPage addCust;
	SearchCustomer searchCust;
	
	//Created for generating random string for unique email
	public static String randomString() {
		String generateString = RandomStringUtils.randomAlphabetic(6);
		String email = generateString+"@gmail.com";
		return email;
	}

}
