package com.mercuryTravel.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mercuryTravel.pages.HomePage;

import commonLibs.implementation.CommonDriver;

public class BaseSetup {
	
	protected CommonDriver cmnDriver;
	protected HomePage homepage;
	protected WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {
		cmnDriver = new CommonDriver("chrome");

		cmnDriver.setPageLoadTimeout(20);
		cmnDriver.setElementDetectionTimeout(5);

		cmnDriver.navigateToFirstUrl("https://www.mercurytravels.co.in");
		
		driver = cmnDriver.getDriver();
		homepage = new HomePage(driver);

	}
	
	@AfterClass(alwaysRun = true)
	public void cleanUp() throws Exception {
		cmnDriver.closeAllBrowsers();
	}

}
