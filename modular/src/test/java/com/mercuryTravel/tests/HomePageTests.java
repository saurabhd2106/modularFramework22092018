package com.mercuryTravel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseSetup {

	@Test(priority = 0)
	public void verifyTitleOfHomepage() throws Exception {
		String expectedTitle = "Mercury Travels: Holiday Packages, Flight Booking, Hotels, Forex, Visa & Travel Insurance";
		String actualTitle = cmnDriver.getTitle();

		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Test(priority = 100)
	public void verifyUserLogin() throws Exception {

		String userEmailId = "saurabh.d2106@gmail.com";
		String userPassword = "Pro@1234";

		homepage.userLogin(userEmailId, userPassword);

		String expectedWelcomeText = "Welcome, Saurabh";

		String actualWelcomeText = homepage.getWelcomeText();

		Assert.assertEquals(expectedWelcomeText, actualWelcomeText);

	}

}
