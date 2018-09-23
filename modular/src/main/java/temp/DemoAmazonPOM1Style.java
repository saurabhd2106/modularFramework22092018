package temp;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;
import designPattern.AmazonHomePagePOM1Style;

public class DemoAmazonPOM1Style {

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
			
			AmazonHomePagePOM1Style homepage = new AmazonHomePagePOM1Style(driver);
			
			ElementControl elementControl = new ElementControl();
			DropdownControl dropdownControl = new DropdownControl();
			
			//Search Product
			
			elementControl.setText(homepage.searchBox, "Apple watch");
			
			dropdownControl.selectViaVisibleText(homepage.searchDropdown, "Watches");
			
			elementControl.clickElement(homepage.searchButton);			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
