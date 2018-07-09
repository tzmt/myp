package com.mya.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mya.locators.LocatorReader;
import com.mya.util.DriverHelper;

public class MYPApplicationHelper extends DriverHelper {

	private LocatorReader myplocator;

	public MYPApplicationHelper(WebDriver webdriver) {
		super(webdriver);
		myplocator = new LocatorReader("MYPLocators.xml");
	}

	//Select Applicant Type 
	public void SelectApplicant(String value)
	{
		String applicant_type = myplocator.getLocator("ApplicantType");
		selectDropDown(applicant_type, value);
		waitForWorkAroundTime(300);
	}

	public void FillinData(String xmlnode, String value)
	{
		String locator = myplocator.getLocator(xmlnode);
		sendKeys(locator, value);
	}

	//Select Applicant Type 
	public void SelectCountry(String value)
	{
		String country = myplocator.getLocator("Country");
		selectDropDown(country, value);
		waitForWorkAroundTime(300);
	}
	
	//Select Departed country of residence  
	public void SelectDepartedCountry(String value)
	{
		String country = myplocator.getLocator("DepartedResidence");
		selectDropDown(country, value);
		waitForWorkAroundTime(300);
	}


	//Enter contact's email address
	public void EnterContactEmail(String email)
	{
		String locator = myplocator.getLocator("EnterContactEmail");
		sendKeys(locator, email);
	}

	//Fill in contact's phone number
	public void EnterContactPhone(String phone)
	{
		String locator = myplocator.getLocator("EnterContactPhone");
		sendKeys(locator, phone);
	}
	
	//Enter contact departed phone number
	public void EnterContactDPhone(String phone)
	{
		String locator = myplocator.getLocator("EnterContactDepartedPhone");
		sendKeys(locator, phone);
	}
	
	//Enter contact departed email address
	public void EnterContactDEmail(String email)
	{
		String locator = myplocator.getLocator("EnterContactDepartedEmail");
		sendKeys(locator, email);
	}

	//Select Applicant's birth day
	public void ApplicantBDay(String BDay)
	{
		String locator = myplocator.getLocator("ApplicantBDay");
		selectDropDown(locator, BDay);
		waitForWorkAroundTime(300);
	}

	//Select Applicant's Birth month
	public void ApplicantBMonth(String BMonth)
	{
		String locator = myplocator.getLocator("ApplicantBMonth");
		selectDropDown(locator, BMonth);
		waitForWorkAroundTime(300);
	}

	//Select Applican't birth year
	public void ApplicantBYear(String year)
	{
		String locator = myplocator.getLocator("ApplicantBYear");
		sendKeys(locator, year);
	}
	
	//Select Departed birth day
	public void DepartedtBDay(String BDay)
	{
		String locator = myplocator.getLocator("ApplicantBDay");
		selectDropDown(locator, BDay);
		waitForWorkAroundTime(300);
	}

	//Select Yes/No for CBC completed for applicant
	public void CBCStatus(String CBCStatus)
	{
		String locator = myplocator.getLocator("CBCStatus");
		selectDropDown(locator, CBCStatus);
		waitForWorkAroundTime(300);
	}

	//select mental/physical health 
	public void SelectHealthStatus(String healthStatus)
	{
		String locator = myplocator.getLocator("SelectHealthStatus");
		selectDropDown(locator, healthStatus);
		waitForWorkAroundTime(300);
	}

	//select country of stay
	public void SelectCountryOfStay(String value)
	{
		String country = myplocator.getLocator("CountryOfStay");
		selectDropDown(country, value);
		waitForWorkAroundTime(300);
	}
	
	//select Contact country of residence
	public void SelectConCountryOfResidence(String value)
	{
		String country = myplocator.getLocator("ConCountryResidence");
		selectDropDown(country, value);
		waitForWorkAroundTime(300);
	}


	//Enter location of applicant during performance
	public void EnterApplicantLocation(String location)
	{
		String locator = myplocator.getLocator("ApplicantLocation");
		sendKeys(locator, location);
	}

	//Enter Yagya number
	public void EnterYagyaNumber(String number)
	{
		String locator = myplocator.getLocator("EnterYagyaNumber");
		sendKeys(locator, number);
	}

	//Select yagya category
	public void SelectYagyaCategory(String targetValue)
	{
		String locator = myplocator.getLocator("SelectYagyaCategory");
		selectDropDown(locator, targetValue);
	}

	//Enter donation amount
	public void DonationAmount(String amount)
	{
		String locator = myplocator.getLocator("DonationAmount");
		sendKeys(locator, amount);
	}

	//Select Donation will be made
	public void DonationMode(String value)
	{
		String locator = myplocator.getLocator("DonationMode");
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//confirm agreement with the terms
	public void ConfirmTerms(String value)
	{
		String locator = myplocator.getLocator("DoYouAgree");
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}
	
	//Third party consent
	public void SelectConsent(String value)
	{
		String locator = myplocator.getLocator("Consent");
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//Submit the application
	public void SubmitApplication()
	{
		String locator = myplocator.getLocator("SubmitApplication");
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
		String locator = myplocator.getLocator("BillingPhone");
		sendKeys(locator, phone);
	}

	//Enter Billing Street
	public void EnterBillingStreet(String value)
	{
		String locator = myplocator.getLocator("BillingStreet");
		sendKeys(locator, value);
	}

	//Enter Billing Street
	public void BillingCityName(String value)
	{
		String locator = myplocator.getLocator("BillingCityName");
		sendKeys(locator, value);
	}


	public void EnterBillingPostalCode(String value)
	{
		String locator = myplocator.getLocator("BillingPostalCode");
		sendKeys(locator, value);
	}

	public void ClickDonateByOtherMean()
	{
		String locator = myplocator.getLocator("DonateByOtherMean");
		clickOn(locator);
		waitForWorkAroundTime(6000);
	}

	//Fill in Contact B'day details
	public void ContactBDayDetails(String xmlnode, String value)
	{
		String locator = myplocator.getLocator(xmlnode);
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//Select member status when country is Japan
	public void SelectMemberStatus(String value)
	{
		String locator = myplocator.getLocator("JapanMemberStatus");
		selectDropDown(locator, value);
		waitForWorkAroundTime(3000);
	}

	//Select state when country is US
	public void SelectState(String value)
	{
		String locator = myplocator.getLocator("State");
		selectDropDown(locator, value);
		waitForWorkAroundTime(3000);
	}
	
	//click Xml node
	public void ClickItem(String xmlnode)
	{
		String locator = myplocator.getLocator(xmlnode);
		clickOn(locator);
	}

}
