package temp;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.CommonDriver;
import designPattern.AmazonHomePagePOM2Style;

public class DemoAmazonPOM2Style {

	public static void main(String[] args) {
		
		CommonDriver cmnDriver;
		String url = "http://amazon.in";
		WebDriver driver;
		try {
			cmnDriver = new CommonDriver("chrome");
			
			cmnDriver.setPageLoadTimeout(20);
			cmnDriver.setElementDetectionTimeout(5);
			
			cmnDriver.navigateToFirstUrl(url);
			
			System.out.println(cmnDriver.getTitle());
			
			driver = cmnDriver.getDriver();
			
			AmazonHomePagePOM2Style homepage = new AmazonHomePagePOM2Style(driver);
		
			//Search Product
			
			homepage.searchItem("Apple watch", "Watches");		
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
