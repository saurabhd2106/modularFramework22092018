package designPattern;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;
import commonLibs.implementation.JavascriptControl;
import commonLibs.implementation.MouseControl;

public class AmazonPageFactoryStyle {

	@CacheLookup
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@CacheLookup
	@FindBy(id = "searchDropdownBox")
	private WebElement searchDropdown;

	@FindBy(xpath = "//input[@value='Go']")
	private WebElement searchButton;

	@FindBy(id = "s-result-count")
	private WebElement result;

	@FindBy(xpath = "//div[@id='atfResults']/ul[@id='s-results-list-atf']/li")
	private List<WebElement> allProducts;

	private ElementControl elementControl;
	private DropdownControl dropdownControl;
	private MouseControl mouseControl;
	private JavascriptControl jsControl;

	public AmazonPageFactoryStyle(WebDriver driver) {

		PageFactory.initElements(driver, this);
		elementControl = new ElementControl();
		dropdownControl = new DropdownControl();
		mouseControl = new MouseControl(driver);
		jsControl = new JavascriptControl(driver);
	}

	public void searchItem(String product, String category) throws Exception {

		elementControl.setText(searchBox, product);
		dropdownControl.selectViaVisibleText(searchDropdown, "Watches");
		elementControl.clickElement(searchButton);

		System.out.println(elementControl.getText(result));
	}

	public void printAllProductsViaScrollDown() throws Exception {

		for (WebElement product : allProducts) {
			mouseControl.moveToElement(product);

			System.out.println(elementControl.getText(product));

			System.out.println("-----------------------------------");
		}
	}

	public void printAllProductsViaScrollDownUsingJS() throws Exception {

		int x, y;
		for (WebElement product : allProducts) {
			
			x = product.getLocation().x;
			y = product.getLocation().y;
			
			jsControl.scrollDown(x, y);

			System.out.println(elementControl.getText(product));

			System.out.println("-----------------------------------");
		}
	}

}
