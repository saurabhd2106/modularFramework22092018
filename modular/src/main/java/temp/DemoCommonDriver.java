package temp;

import org.openqa.selenium.WebDriver;

import implementation.CommonDriver;
import implementation.ScreenshotControl;

public class DemoCommonDriver {

	public static void main(String[] args) {
		
		CommonDriver cmnDriver;
		String url = "http://qatechhub.com ";
		WebDriver driver;
		try {
			cmnDriver = new CommonDriver("chrome");
			
			cmnDriver.setPageLoadTimeout(20);
			cmnDriver.setElementDetectionTimeout(5);
			
			cmnDriver.navigateToFirstUrl(url);
			
			System.out.println(cmnDriver.getTitle());
			
			driver = cmnDriver.getDriver();
			
			ScreenshotControl camera = new ScreenshotControl(driver);
			
			camera.captureAndSaveScreenshot(System.getProperty("user.dir")+"/screenshots/demo.png");
			
			cmnDriver.closeAllBrowsers();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
