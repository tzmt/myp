package com.mya.pagehelper;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mya.locators.LocatorReader;
import com.mya.util.DriverHelper;

public class COMApplicationHelper extends DriverHelper {

	private LocatorReader comlocator;

	public COMApplicationHelper(WebDriver webdriver) {
		super(webdriver);
		comlocator = new LocatorReader("COMLocators.xml");
	}

	//Select Applicant Type 
	public void SelectApplicant(String value)
	{
		String applicant_type = comlocator.getLocator("AppIsFor");
		selectDropDown(applicant_type, value);
		waitForWorkAroundTime(300);
	}

	public void FillinData(String xmlnode, String value)
	{
		String locator = comlocator.getLocator(xmlnode);
		sendKeys(locator, value);
	}

	//Select Applicant Type 
	public void CountryOfRes(String value)
	{
		String country = comlocator.getLocator("CountryOfRes");
		selectDropDown(country, value);
		waitForWorkAroundTime(300);
	}


	//Enter contact's email address
	public void EnterContactEmail(String email)
	{
		String locator = comlocator.getLocator("YoPersInfo.EmailAdd");
		sendKeys(locator, email);	
	}
		
		//Enter your's email address
		public void EnterYourtEmail(String email)
		{
			String locator = comlocator.getLocator("OrgInfo.ContactEmailAdd");
			sendKeys(locator, email);
	}

	//Fill in contact's phone number
	public void EnterContactPhone(String phone)
	{
		String locator = comlocator.getLocator("YoPersInfo.TeleNum");
		sendKeys(locator, phone);
	}
	
	//Fill in your's phone number
		public void EnterYourPhone(String phone)
		{
			String locator = comlocator.getLocator("OrgInfo.ContactTeleNum");
			sendKeys(locator, phone);
		}

	//Select Applicant's birth day
	public void ApplicantBDay(String BDay)
	{
		String locator = comlocator.getLocator("YourBirthDateAndTime.ApplicantsBirthDay");
		selectDropDown(locator, BDay);
		waitForWorkAroundTime(100);
	}

	//Select Applicant's Birth month
	public void ApplicantBMonth(String BMonth)
	{
		String locator = comlocator.getLocator("YourBirthDateAndTime.ApplicantsBirthMonth");
		selectDropDown(locator, BMonth);
		waitForWorkAroundTime(100);
	}

	//Select Applican't birth year
	public void ApplicantBYear(String year)
	{
		String locator = comlocator.getLocator("YourBirthDateAndTime.ApplicantsBirthYear");
		sendKeys(locator, year);
	}
	
	//Select Expiration date Month
		public void ExpirationMonth(String EMonth)
		{
			String locator = comlocator.getLocator("CheckOut.ExpirationDateMonth");
			selectDropDown(locator, EMonth);
			waitForWorkAroundTime(100);
		}
		
	//Select Expiration date Month
			public void ExpirationYear(String EYear)
			{
				String locator = comlocator.getLocator("CheckOut.ExpirationDateYear");
				selectDropDown(locator, EYear);
				waitForWorkAroundTime(100);
				}


	//select country of stay
	public void SelectCountryOfStay(String value)
	{
		String country = comlocator.getLocator("YoPersInfo.CountryOfRes");
		selectDropDown(country, value);
		waitForWorkAroundTime(300);
	}

	//select contact country of Residence
		public void Selectcontactcountry(String value)
		{
			String country = comlocator.getLocator("OrgInfo.ContactCountryOfRes");
			selectDropDown(country, value);
			waitForWorkAroundTime(400);
		}
	
	// Select country of legal establishment 
		public void Selectorgcountry(String value)
		{
			String country = comlocator.getLocator("OrgInfo.LegalEstablish");
			selectDropDown(country, value);
			waitForWorkAroundTime(200);
		}
		

	//Enter location of applicant during performance
	public void EnterApplicantLocation(String location)
	{
		String locator = comlocator.getLocator("ApplicantLocation");
		sendKeys(locator, location);
	}

	//Enter Yagya number
	public void EnterYagyaNumber(String number)
	{
		String locator = comlocator.getLocator("EnterYagyaNumber");
		sendKeys(locator, number);
	}

	//Select yagya category
	public void SelectYagyaCategory(String targetValue)
	{
		String locator = comlocator.getLocator("SelectYagyaCategory");
		selectDropDown(locator, targetValue);
	}

	//Enter donation amount
	public void DonationAmount(String amount)
	{
		String locator = comlocator.getLocator("DonationAmount");
		sendKeys(locator, amount);
	}

	//Select Donation will be made
	public void DonationMode(String value)
	{
		String locator = comlocator.getLocator("DonationMode");
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//confirm agreement with the terms
	public void ConfirmTerms(String value)
	{
		String locator = comlocator.getLocator("DoYouAgree");
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//Submit the application
	public void SubmitApplication()
	{
		String locator = comlocator.getLocator("SubmitApplication");
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
		String locator = comlocator.getLocator("BillingPhone");
		sendKeys(locator, phone);
	}

	//Enter Billing Street
	public void EnterBillingStreet(String value)
	{
		String locator = comlocator.getLocator("BillingStreet");
		sendKeys(locator, value);
	}

	//Enter Billing Street
	public void BillingCityName(String value)
	{
		String locator = comlocator.getLocator("BillingCityName");
		sendKeys(locator, value);
	}


	public void EnterBillingPostalCode(String value)
	{
		String locator = comlocator.getLocator("BillingPostalCode");
		sendKeys(locator, value);
	}


	//Fill in Contact B'day details
	public void ContactBDayDetails(String xmlnode, String value)
	{
		String locator = comlocator.getLocator(xmlnode);
		selectDropDown(locator, value);
		waitForWorkAroundTime(300);
	}

	//Select member status when country is Japan
	public void SelectMemberStatus(String value)
	{
		String locator = comlocator.getLocator("JapanMemberStatus");
		selectDropDown(locator, value);
		waitForWorkAroundTime(3000);
	}

	//Select state when country is US
	public void SelectState(String value)
	{
		String locator = comlocator.getLocator("State");
		selectDropDown(locator, value);
		waitForWorkAroundTime(3000);
	}

	//Select by xml node and text
	public void SelectListItem(String xmlnode, String value)
	{
		String locator = comlocator.getLocator(xmlnode);
		selectDropDown(locator, value);
		waitForWorkAroundTime(100);
	}

	//click Xml node
	public void ClickItem(String xmlnode)
	{
		String locator = comlocator.getLocator(xmlnode);
		clickOn(locator);
	}

}
