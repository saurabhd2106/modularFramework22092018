package com.mercuryTravel.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mercuryTravel.pages.HomePage;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import utility.ConfigReader;
import utility.DateUtils;

public class BaseSetup {

	protected CommonDriver cmnDriver;
	protected HomePage homepage;
	protected WebDriver driver;

	protected Properties configProperty;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	ScreenshotControl camera;

	String testExecutionStartTime;
	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {

		testExecutionStartTime = DateUtils.getDate();
		
		String reportName = String.format("%s/reports/TestExecutionReport_%s.html",System.getProperty("user.dir"), testExecutionStartTime);
		htmlReporter = new ExtentHtmlReporter(reportName);
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		
		test = extent.createTest("Setting up the variables");
		
		
		configProperty = ConfigReader.readProperties(System.getProperty("user.dir") + "/config/config.properties");

		String browserType = configProperty.getProperty("browserType");
		
		test.log(Status.INFO, "Browser Type is : "+browserType);
		cmnDriver = new CommonDriver(browserType);

		int pageloadTimeout = Integer.parseInt(configProperty.getProperty("pageLoadTimeout"));
		cmnDriver.setPageLoadTimeout(pageloadTimeout);
		test.log(Status.INFO, "Page load timeout is : "+pageloadTimeout);
		
		int elementDetectionTimeout = Integer.parseInt(configProperty.getProperty("elementDetectionTimeout"));
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);

		test.log(Status.INFO, "Element Detection timeout : "+elementDetectionTimeout);
		cmnDriver.navigateToFirstUrl(configProperty.getProperty("baseUrl"));

		driver = cmnDriver.getDriver();
		homepage = new HomePage(driver);
		camera = new ScreenshotControl(driver);
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod(ITestResult result) throws Exception{
		
		if(result.getStatus() == ITestResult.FAILURE){
			
			test.fail("Test case failed : "+ result.getName());
			
			String screenshotFilename = String.format("%s/screenshots/%s_%s.png", System.getProperty("user.dir"),result.getName(), testExecutionStartTime);
			String filename = camera.captureAndSaveScreenshot(screenshotFilename);
			
			test.addScreenCaptureFromPath(filename);
		} else if(result.getStatus() == ITestResult.SUCCESS){
			test.pass("Test case is passed : "+ result.getName());
		} else {
			test.skip("Test case skipped : "+ result.getName());
		}
		
	}
	

	@AfterClass(alwaysRun = true)
	public void cleanUp() throws Exception {
		cmnDriver.closeAllBrowsers();
		extent.flush();
	}

}
