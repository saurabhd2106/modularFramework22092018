package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePagePOM1Style {

	public WebElement searchBox;

	public WebElement searchDropdown;

	public WebElement searchButton;

	public AmazonHomePagePOM1Style(WebDriver driver) {

		searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		searchDropdown = driver.findElement(By.id("searchDropdownBox"));

		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));

	}

}
