package com.mya.pagehelper;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.testng.Assert;

import com.mya.locators.LocatorReader;
import com.mya.util.DriverHelper;
import com.mya.util.PropertyReader;
import com.mya.util.PropertyReader;

public class ACBTApplicationHelper extends DriverHelper {

	private LocatorReader acbtlocator;

	public ACBTApplicationHelper(WebDriver webdriver) {
		super(webdriver);
		acbtlocator = new LocatorReader("ACBTLocators.xml");
	}

	//Select Applicant Type 
	public void SelectApplicant(String value)
	{
		String applicant_type = acbtlocator.getLocator("AppIsFor");
		selectDropDown(applicant_type, value);
		waitForWorkAroundTime(300);
	}

	public void FillinData(String xmlnode, String value)
	{
		String locator = acbtlocator.getLocator(xmlnode);
		sendKeys(locator, value);
	}

	//Select Applicant Type 
	public void CountryOfRes(String value)
	{
		String country = acbtlocator.getLocator("CountryOfRes");
		selectDropDown(country, value);
		waitForWorkAroundTime(300);
	}

	//Select Applicant Birth Type 
		public void BirthCountry(String value)
		{
			String country = acbtlocator.getLocator("Country");
			selectDropDown(country, value);
			waitForWorkAroundTime(300);
		}

	//Enter contact's email address
	public void EnterContactEmail(String email)
	{
		String locator = acbtlocator.getLocator("YoPersInfo.EmailAdd");
		sendKeys(locator, email);
	}

	//Fill in contact's phone number
	public void EnterContactPhone(String phone)
	{
		String locator = acbtlocator.getLocator("YoPersInfo.TeleNum");
		sendKeys(locator, phone);
	}

	//Select Applicant's birth day
	public void ApplicantBDay(String BDay)
	{
		String locator = acbtlocator.getLocator("YourBirthDetails.ApplicantsBirthDay");
		selectDropDown(locator, BDay);
		waitForWorkAroundTime(300);
	}

	//Select Applicant's Birth month
	public void ApplicantBMonth(String BMonth)
	{
		String locator = acbtlocator.getLocator("YourBirthDetails.ApplicantsBirthMonth");
		selectDropDown(locator, BMonth);
		waitForWorkAroundTime(300);
	}

	//Select Applican't birth year
	public void ApplicantBYear(String year)
	{
		String locator = acbtlocator.getLocator("YourBirthDetails.ApplicantsBirthYear");
		sendKeys(locator, year);
	}


	//select country of stay
	public void SelectCountryOfStay(String value)
	{
		String country = acbtlocator.getLocator("YoPersInfo.CountryOfRes");
		selectDropDown(country, value);
		waitForWorkAroundTime(400);
	}


	//Enter location of applicant during performance
	public void EnterApplicantLocation(String location)
	{
		String locator = acbtlocator.getLocator("ApplicantLocation");
		sendKeys(locator, location);
	}

	//Enter Yagya number
	public void EnterYagyaNumber(String number)
	{
		String locator = acbtlocator.getLocator("EnterYagyaNumber");
		sendKeys(locator, number);
	}

	//Select yagya category
	public void SelectYagyaCategory(String targetValue)
	{
		String locator = acbtlocator.getLocator("SelectYagyaCategory");
		selectDropDown(locator, targetValue);
	}

	//Enter donation amount
	public void DonationAmount(String amount)
	{
		String locator = acbtlocator.getLocator("DonationAmount");
		sendKeys(locator, amount);
	}

	//Select Donation will be made
	public void DonationMode(String value)
	{
		String locator = acbtlocator.getLocator("DonationMode");
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//confirm agreement with the terms
	public void ConfirmTerms(String value)
	{
		String locator = acbtlocator.getLocator("DoYouAgree");
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//Submit the application
	public void SubmitApplication()
	{
		String locator = acbtlocator.getLocator("SubmitApplication");
		clickOn(locator);
	}

	//verify Billing information page displayed
	public void VerifyBillingInfoPage()
	{
		waitForWorkAroundTime(3000);
		Assert.assertTrue(driver.getPageSource().contains("BILLING INFORMATION"));
	}

	//Enter Billing Phone
	public void EnterBillingPhone(String phone)
	{
		String locator = acbtlocator.getLocator("BillingPhone");
		sendKeys(locator, phone);
	}

	//Enter Billing Street
	public void EnterBillingStreet(String value)
	{
		String locator = acbtlocator.getLocator("BillingStreet");
		sendKeys(locator, value);
	}

	//Enter Billing Street
	public void BillingCityName(String value)
	{
		String locator = acbtlocator.getLocator("BillingCityName");
		sendKeys(locator, value);
	}


	public void EnterBillingPostalCode(String value)
	{
		String locator = acbtlocator.getLocator("BillingPostalCode");
		sendKeys(locator, value);
	}


	//Fill in Contact B'day details
	public void ContactBDayDetails(String xmlnode, String value)
	{
		String locator = acbtlocator.getLocator(xmlnode);
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//Select member status when country is Japan
	public void SelectMemberStatus(String value)
	{
		String locator = acbtlocator.getLocator("JapanMemberStatus");
		selectDropDown(locator, value);
		waitForWorkAroundTime(3000);
	}

	//Select state when country is US
	public void SelectState(String value)
	{
		String locator = acbtlocator.getLocator("State");
		selectDropDown(locator, value);
		waitForWorkAroundTime(3000);
	}

	//Select by xml node and text
	public void SelectListItem(String xmlnode, String value)
	{
		String locator = acbtlocator.getLocator(xmlnode);
		selectDropDown(locator, value);
		waitForWorkAroundTime(100);
	}

	//click Xml node
	public void ClickItem(String xmlnode)
	{
		String locator = acbtlocator.getLocator(xmlnode);
		clickOn(locator);
	}
	
	//Remove given Section e.g. Relatives. Chile etc
	public void RemoveSection(String xml_node)
	{
		String locator = acbtlocator.getLocator(xml_node);
		clickOn(locator);
		waitForWorkAroundTime(6000);
		getWebDriver().findElement(ByLocator("//body")).sendKeys(Keys.ENTER);
	}
	
	public void UploadFile()
	{
		PropertyReader propObj = new PropertyReader();
		String localPath = propObj.getFilePath();
		localPath = localPath+"//TestData//Koala.jpg";	
		
		String locator = acbtlocator.getLocator("PersonalPhoto");
		sendKeys(locator, localPath);
	}

	public void ValidateBillingPage()
	{
		String locator = "//*[@id='pg:SiteTemplate:frm:billingPostalCode']";
		WaitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator));
	}
}
