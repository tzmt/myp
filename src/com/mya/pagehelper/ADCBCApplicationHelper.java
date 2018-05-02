package com.mya.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mya.locators.LocatorReader;
import com.mya.util.DriverHelper;

public class ADCBCApplicationHelper extends DriverHelper {

	private LocatorReader adcbclocator;

	public ADCBCApplicationHelper(WebDriver webdriver) {
		super(webdriver);
		adcbclocator = new LocatorReader("ADCBCLocators.xml");
	}

	//Select Applicant Type 
	public void SelectApplicant(String value)
	{
		String applicant_type = adcbclocator.getLocator("AppIsFor");
		selectDropDown(applicant_type, value);
		waitForWorkAroundTime(300);
	}

	public void FillinData(String xmlnode, String value)
	{
		String locator = adcbclocator.getLocator(xmlnode);
		sendKeys(locator, value);
	}

	//Select Applicant Type 
	public void CountryOfRes(String value)
	{
		String country = adcbclocator.getLocator("CountryOfRes");
		selectDropDown(country, value);
		waitForWorkAroundTime(300);
	}


	//Enter contact's email address
	public void EnterContactEmail(String email)
	{
		String locator = adcbclocator.getLocator("YoPersInfo.EmailAdd");
		sendKeys(locator, email);
	}

	//Fill in contact's phone number
	public void EnterContactPhone(String phone)
	{
		String locator = adcbclocator.getLocator("YoPersInfo.TeleNum");
		sendKeys(locator, phone);
	}

	//Select Applicant's birth day
	public void ApplicantBDay(String BDay)
	{
		String locator = adcbclocator.getLocator("YourBirthDateAndTime.ApplicantsBirthDay");
		selectDropDown(locator, BDay);
		waitForWorkAroundTime(300);
	}

	//Select Applicant's Birth month
	public void ApplicantBMonth(String BMonth)
	{
		String locator = adcbclocator.getLocator("YourBirthDateAndTime.ApplicantsBirthMonth");
		selectDropDown(locator, BMonth);
		waitForWorkAroundTime(300);
	}

	//Select Applican't birth year
	public void ApplicantBYear(String year)
	{
		String locator = adcbclocator.getLocator("YourBirthDateAndTime.ApplicantsBirthYear");
		sendKeys(locator, year);
	}


	//select country of stay
	public void SelectCountryOfStay(String value)
	{
		String country = adcbclocator.getLocator("YoPersInfo.CountryOfRes");
		selectDropDown(country, value);
		waitForWorkAroundTime(300);
	}


	//Enter location of applicant during performance
	public void EnterApplicantLocation(String location)
	{
		String locator = adcbclocator.getLocator("ApplicantLocation");
		sendKeys(locator, location);
	}

	//Enter Yagya number
	public void EnterYagyaNumber(String number)
	{
		String locator = adcbclocator.getLocator("EnterYagyaNumber");
		sendKeys(locator, number);
	}

	//Select yagya category
	public void SelectYagyaCategory(String targetValue)
	{
		String locator = adcbclocator.getLocator("SelectYagyaCategory");
		selectDropDown(locator, targetValue);
	}

	//Enter donation amount
	public void DonationAmount(String amount)
	{
		String locator = adcbclocator.getLocator("DonationAmount");
		sendKeys(locator, amount);
	}

	//Select Donation will be made
	public void DonationMode(String value)
	{
		String locator = adcbclocator.getLocator("DonationMode");
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//confirm agreement with the terms
	public void ConfirmTerms(String value)
	{
		String locator = adcbclocator.getLocator("DoYouAgree");
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//Submit the application
	public void SubmitApplication()
	{
		String locator = adcbclocator.getLocator("SubmitApplication");
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
		String locator = adcbclocator.getLocator("BillingPhone");
		sendKeys(locator, phone);
	}

	//Enter Billing Street
	public void EnterBillingStreet(String value)
	{
		String locator = adcbclocator.getLocator("BillingStreet");
		sendKeys(locator, value);
	}

	//Enter Billing Street
	public void BillingCityName(String value)
	{
		String locator = adcbclocator.getLocator("BillingCityName");
		sendKeys(locator, value);
	}


	public void EnterBillingPostalCode(String value)
	{
		String locator = adcbclocator.getLocator("BillingPostalCode");
		sendKeys(locator, value);
	}


	//Fill in Contact B'day details
	public void ContactBDayDetails(String xmlnode, String value)
	{
		String locator = adcbclocator.getLocator(xmlnode);
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//Select member status when country is Japan
	public void SelectMemberStatus(String value)
	{
		String locator = adcbclocator.getLocator("JapanMemberStatus");
		selectDropDown(locator, value);
		waitForWorkAroundTime(3000);
	}

	//Select state when country is US
	public void SelectState(String value)
	{
		String locator = adcbclocator.getLocator("State");
		selectDropDown(locator, value);
		waitForWorkAroundTime(3000);
	}

	//Select by xml node and text
	public void SelectListItem(String xmlnode, String value)
	{
		String locator = adcbclocator.getLocator(xmlnode);
		selectDropDown(locator, value);
		waitForWorkAroundTime(3000);
	}

	//click Xml node
	public void ClickItem(String xmlnode)
	{
		String locator = adcbclocator.getLocator(xmlnode);
		clickOn(locator);
	}
	
	public void ValidateBillingPage()
	{
		String locator = "//*[@id='pg:SiteTemplate:frm:billingPostalCode']";
		Assert.assertTrue(isElementPresent(locator));
	}

}
