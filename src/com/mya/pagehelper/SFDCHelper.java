package com.mya.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mya.locators.LocatorReader;
import com.mya.util.DriverHelper;

public class SFDCHelper extends DriverHelper {

	private LocatorReader sfdclocator;

	public SFDCHelper(WebDriver webdriver) {
		super(webdriver);
		sfdclocator = new LocatorReader("SDFCLocators.xml");
	}


	//Login into the testing Sandbox
	public void LoginIntoSFDC(String sfdc_url, String username, String password)
	{
		driver.navigate().to(sfdc_url);
		String locator_uname = sfdclocator.getLocator("Login");
		String locator_pass = sfdclocator.getLocator("Password");
		String locator_Submit = sfdclocator.getLocator("Submit");
		sendKeys(locator_uname, username);
		sendKeys(locator_pass, password);
		clickOn(locator_Submit);
	}

	//Verify Page text
	public void VerifySFDCPageTitle(String value)
	{
		String locator =  "//*[contains(@class, 'entityNameTitle')]";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	public void WaitForItem(String xml_node, int wait)
	{
		String locator = sfdclocator.getLocator(xml_node);
		WaitForElementPresent(locator, wait);
	}
	

}
