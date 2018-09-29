package com.mercuryTravel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class HomePageTests extends BaseSetup {

	@Test(priority = 0)
	public void verifyTitleOfHomepage() throws Exception {
		
		test = extent.createTest("Verify Title of the page");
		String expectedTitle = "Mercury Travels: Holiday Packages, Flight Booking, Hotels, Forex, Visa & Travel Insurance";
		String actualTitle = cmnDriver.getTitle();

		test.log(Status.INFO, "Expected Title is : "+ expectedTitle);
		test.log(Status.INFO, "Actual Title is : "+ actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Test(priority = 100)
	public void verifyUserLogin() throws Exception {

		test = extent.createTest("Verify Login to the mercury travel page");
		String userEmailId = "saurabh.d2106@gmail.com";
		String userPassword = "Pro@1234";

		homepage.userLogin(userEmailId, userPassword);

		String expectedWelcomeText = "Welcome, Saurabh";

		String actualWelcomeText = homepage.getWelcomeText();

		Assert.assertEquals(expectedWelcomeText, actualWelcomeText);

	}

}
