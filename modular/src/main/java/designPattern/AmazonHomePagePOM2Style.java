package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;

public class AmazonHomePagePOM2Style {

	private WebElement searchBox;

	private WebElement searchDropdown;

	private WebElement searchButton;
	private WebElement result;
	
	private ElementControl elementControl;
	private DropdownControl dropdownControl;
	

	public AmazonHomePagePOM2Style(WebDriver driver) {

		searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		searchDropdown = driver.findElement(By.id("searchDropdownBox"));

		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
		
		result = driver.findElement(By.id("s-result-count"));
		elementControl = new ElementControl();
		dropdownControl = new DropdownControl();
	}
	
	public void searchItem(String product, String category) throws Exception{
		
		elementControl.setText(searchBox, product);
		dropdownControl.selectViaVisibleText(searchDropdown, "Watches");
		elementControl.clickElement(searchButton);
		
		System.out.println(elementControl.getText(result));
	}

}
