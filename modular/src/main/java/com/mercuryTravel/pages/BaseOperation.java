package com.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.AlertControl;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;
import commonLibs.implementation.MouseControl;

public class BaseOperation {

	protected ElementControl elementControl;
	protected DropdownControl dropdownControl;
	protected MouseControl mouseControl;
	protected AlertControl alertControl;

	public BaseOperation(WebDriver driver) {
		elementControl = new ElementControl();
		mouseControl = new MouseControl(driver);
		dropdownControl = new DropdownControl();
		alertControl = new AlertControl(driver);
	}

}
