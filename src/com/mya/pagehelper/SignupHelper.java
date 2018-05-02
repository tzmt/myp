package com.mya.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mya.locators.LocatorReader;
import com.mya.util.DriverHelper;

public class SignupHelper extends DriverHelper 
{
	private LocatorReader signuplocator;	

	
	public SignupHelper(WebDriver driver) 
	{
		super(driver);
		signuplocator = new LocatorReader("Signup.xml");
	}


	public void type(String Field, String text) 
	{
		String locator = signuplocator.getLocator(Field);
		WaitForElementPresent(locator, 40);
		sendKeys(locator, text);
	}
	public void verifyHelp(String field)
	{
		String locator = signuplocator.getLocator(field);
		WaitForElementPresent(locator, 40);
		Assert.assertTrue(isElementPresent(locator));	
	}


	public void click(String button) 
	{
		String locator = signuplocator.getLocator(button);
		WaitForElementPresent(locator, 40);
		clickOn(locator);
	}


	public void verifyItem(String Field) 
	{
		String locator = signuplocator.getLocator(Field);
		WaitForElementPresent(locator, 40);
		Assert.assertTrue(isElementPresent(locator));
	} 
	
}
