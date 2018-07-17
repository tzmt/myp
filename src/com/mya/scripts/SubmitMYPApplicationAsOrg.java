package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.MYPApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.pagehelper.SignupHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitMYPApplicationAsOrg extends DriverTestCase
{	
	@Test
	public void testMYPApplication() throws Exception
	{			
		//Initialize objects
		myphelpers = new MYPApplicationHelper(getWebDriver());
		sfdchelper = new SFDCHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(MYP_app_url);
			
			//Select Applicant type
			myphelpers.SelectApplicant("Organization");
			
			//Enter Org name
			myphelpers.FillinData("Orgname", "Testing Org");
			
			//Select Country
			myphelpers.SelectCountry("India");
			
			//Enter Contact Title
			myphelpers.FillinData("ContactTitle", "Mr.");
			
		    //Enter Contact First Name
			myphelpers.FillinData("ContactFName", "Aman");
			
			//Enter Contact Last name
			myphelpers.FillinData("ContactLname", lastname);
			
			//Select Contact Birth Date
			myphelpers.ContactBDayDetails("ContactBDay", "1");
			myphelpers.ContactBDayDetails("ContactBMonth", "July");
			myphelpers.FillinData("contactByear", "1988");
			
			//Enter contact's email address
			myphelpers.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			myphelpers.EnterContactPhone("8860544110");
			
			//Select Applicant's birth day
			myphelpers.ApplicantBDay("1");
			
			//Select Applicant's Birth month
			myphelpers.ApplicantBMonth("July");
			
			//Select Applican't birth year
			myphelpers.ApplicantBYear("1988");
			
			//Select Yes/No for CBC completed for applicant
			myphelpers.CBCStatus("Yes");
			
			//select mental/physical health 
			myphelpers.SelectHealthStatus("Good");
			
			//select country of stay
			myphelpers.SelectCountryOfStay("India");
			
			//Enter location of applicant during performance
			myphelpers.EnterApplicantLocation("Noida");
			
			//Enter Yagya number
			myphelpers.EnterYagyaNumber("301");
			
			//Select Yagya Category 
			myphelpers.SelectYagyaCategory("A");
			
			//Enter donation amount
			myphelpers.DonationAmount("1000");
			
			//Select Donation will be made
			myphelpers.DonationMode("In A Single Donation");
			
			//confirm agreement with the terms
			myphelpers.ConfirmTerms("Yes, I agree to the conditions");
			
			//Confirm third party consent
			myphelpers.SelectConsent("Yes");
			
			//Wait for a second
			myphelpers.waitForWorkAroundTime(3000);
			
			//Click Submit form
			myphelpers.SubmitApplication();
			
			//validate Billing information page displayed.
			myphelpers.VerifyBillingInfoPage();
			
			//Fill in Billing title
			myphelpers.FillinData("BillingTitle", "Mr.");
			
			//Enter billing phone number
			myphelpers.EnterBillingPhone("8860544110");
			
			//Enter Billing street
			myphelpers.EnterBillingStreet("Test Street name");
			
			//Enter Billing City name
			myphelpers.BillingCityName("Noida");
			
			//Enter Billing postal code
			myphelpers.EnterBillingPostalCode("201301");
			
			//Select Donate by other mean option
			myphelpers.ClickDonateByOtherMean();
			
			//Wait For page load
			sfdchelper.waitForWorkAroundTime(3000);
			
			//Now got to SFDC
			sfdchelper.LoginIntoSFDC(sfdc_url, username, password);
			
			//Wait For Home page load
			sfdchelper.waitForWorkAroundTime(6000);
			
			//Select iFrame
			sfdchelper.SelectiFrame("MJYUnbilledApplications");
			
			//Click on Newly Added Account name
			sfdchelper.clickOn("link=Aman "+lastname);
			
			//Verify Account Details page
			sfdchelper.VerifySFDCPageTitle("Account Detail");

		}

		catch (Error e) 
		{
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e) {
			ExecutionLog.LogExceptionMessage(e);			
			throw e;
		}		
	}
	@AfterMethod
	public void endMethods() throws Exception
	{		
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
