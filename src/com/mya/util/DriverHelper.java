package com.mya.util;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public abstract class DriverHelper {
	// Define objects
	protected WebDriver driver;
	//private Object a;

	// Declare objects
	public DriverHelper(WebDriver webdriver) {
		driver = webdriver;
	}

	// Return web driver object
	public WebDriver getWebDriver() {
		return driver;
	}


	// Print message on screen
	public void Log(String logMsg) {
		System.out.println(logMsg);
	}

	// Handle locator type
	public By ByLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else {
			result = By.id(locator.replace("id=", ""));
		}
		return result;
	}

	// Assert element present
	public Boolean isElementPresent(String locator) {
		Boolean result = false;
		try {
			getWebDriver().findElement(ByLocator(locator));
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}

	// Wait for element present
	public void WaitForElementPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Handle click action
	public void clickOn(String locator) {
		this.WaitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		el.click();
	}

	// Handle send keys action
	public void sendKeys(String locator, String text) {
		this.WaitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		el.clear();
		el.sendKeys(text);
	}

	// Store text from a locatorl
	public String getText(String locator) {
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		String text = getWebDriver().findElement(ByLocator(locator)).getText();
		return text;
	}

	// Assert check box selected
	public boolean isChecked(String locator) {
		boolean checkStatus = false;
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		checkStatus = el.isSelected();
		return checkStatus;
	}

	// Get attribute value
	public String getAttribute(String locator, String attribute) {
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		String text = getWebDriver().findElement(ByLocator(locator))
				.getAttribute(attribute);
		return text;
	}



	public void waitForWorkAroundTime(int timeout)
	{
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Select value from drop down
	public void selectDropDown(String locator, String targetValue) {
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		new Select(getWebDriver().findElement(ByLocator(locator)))
		.selectByVisibleText(targetValue);

	}
	
	//Select iFrame
	public void SelectiFrame(String value)
	{
		getWebDriver().switchTo().frame(getWebDriver().findElement(By.id(value)));
	}

}
