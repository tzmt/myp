package com.mya.pagehelper;

import org.apache.xpath.operations.Variable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		String locator =  "//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2";
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
	}
	
	 //Verify Account Code
		public void VerifyAccountCode(String value)
		{
			String locator =  "//div[@id='00No0000009sPfC_ileinner']";
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			this.WaitForElementPresent(locator, 20);
			Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
		}
		
		
		//Verify Account Status for departed
		public void VerifyAccountStatus(String value)
		{
			String locator =  "//div[@id='00No0000009sPfI_ileinner']";
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			this.WaitForElementPresent(locator, 20);
			Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
		}
		
		//Verify payment method
		public void VerifyPaymenMethod(String value)
		{
			String locator =  "//div[@id='00No0000009sPga_ileinner']";
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			this.WaitForElementPresent(locator, 20);
			Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
		}
		
		//Verify payment method
		public void VerifyProductOveride(String value)
		{
		    String locator =  "//div[@id='00No000000DswEK_ileinner']";
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			this.WaitForElementPresent(locator, 20);
			Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
		}
		
		//Verify Total payment amount
		public void VerifyPaymenAmount(String value)
		{
			String locator =  "//div[@id='00No0000009sPge_ileinner']";
			Assert.assertTrue(isElementPresent(locator), "Element Locator :"
					+ locator + " Not found");
			this.WaitForElementPresent(locator, 20);
			Assert.assertTrue(getText(locator).contains(value), "Expected Text :" + value + " but Found: "+getText(locator));
		}
		
		//Verify payment title page
		public void VerifyPaymenPage(String value)
		{
			String locator =  "//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2";
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
	
	public void FillinData(String xmlnode, String value)
	{
		String locator = sfdclocator.getLocator(xmlnode);
		sendKeys(locator, value);
	}
	
	//select application in link builder
	public void Selectapplication(String value)
	{
		String application = sfdclocator.getLocator("LinkBuilder.SelectApplication");
		selectDropDown(application, value);
		waitForWorkAroundTime(300);
	}
	
	//Select by xml node and text
	public void SelectListItem(String xmlnode, String value)
	{
		String locator = sfdclocator.getLocator(xmlnode);
		selectDropDown(locator, value);
		waitForWorkAroundTime(2000);
	}
	
	//click Xml node
		public void ClickItem(String xmlnode)
		{
			String locator = sfdclocator.getLocator(xmlnode);
			clickOn(locator);
		}
		
}
