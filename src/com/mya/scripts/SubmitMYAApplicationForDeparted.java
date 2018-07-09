package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.MYPApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.pagehelper.SignupHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitMYAApplicationForDeparted extends DriverTestCase
{	
	@Test
	public void testMYPApplicationForDeparted() throws Exception
	{			
		//Initialize objects
		myphelpers = new MYPApplicationHelper(getWebDriver());
		sfdchelper = new SFDCHelper(getWebDriver());
		cbchelpers = new CBCApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);
		String lastname2 = "Khan Departed" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(MYAD_app_url);
			
			//Enter Contact Title
			myphelpers.FillinData("ContactDepartedTitle", "Mr.");
			
		    //Enter Contact First Name
			myphelpers.FillinData("ContactDepartedFName", "Aman");
			
			//Enter Contact departed Last name
			myphelpers.FillinData("ContactDepartedLName", lastname);
			
			//Select Contact departed Birth Date
			myphelpers.ContactBDayDetails("ContactDepartedBDay", "1");
			myphelpers.ContactBDayDetails("ContactDepartedBMonth", "July");
			myphelpers.FillinData("ContactDepartedByear", "1988");
			
			//Enter contact's email address
			myphelpers.EnterContactDEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			myphelpers.EnterContactDPhone("8860544110");
			
			//Enter departed relation
			myphelpers.FillinData("ContactRelation", "Father");
			
			//Enter departed Title
			myphelpers.FillinData("DepartedTitle", "Mr.");
			
		    //Enter departed First Name
			myphelpers.FillinData("DepartedFName", "Aman");
			
			//Enter departed Last name
			myphelpers.FillinData("DepartedLName", lastname2);
			
			//Select Departed Country
			myphelpers.SelectDepartedCountry("India");
			myphelpers.waitForWorkAroundTime(2000);
			
			//Select Departed birth day
			myphelpers.ApplicantBDay("1");
			
			//Select departed Birth month
			myphelpers.ApplicantBMonth("July");
			
			//Select departed birth year
			myphelpers.ApplicantBYear("1988");
			
			//Enter Country of stay
			myphelpers.SelectCountryOfStay("Algeria");
			myphelpers.waitForWorkAroundTime(2000);
			
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
			myphelpers.waitForWorkAroundTime(3000);
			
			//confirm agreement with the terms
			myphelpers.ConfirmTerms("Yes, I agree to the conditions");
			
			//Confirm third party consent
			myphelpers.SelectConsent("Yes");
			
			//Wait for a second
			myphelpers.waitForWorkAroundTime(2000);
			
			//Click Submit form
			myphelpers.SubmitApplication();
			
			myphelpers.waitForWorkAroundTime(4000);
			
			//validate Billing information page displayed.
			myphelpers.VerifyBillingInfoPage();
			
			//Enter billing phone number
			myphelpers.EnterBillingPhone("8860544110");
			
			//Enter Billing street
			myphelpers.EnterBillingStreet("Test Street name");
			
			//Enter Billing City name
			myphelpers.BillingCityName("Noida");
			
			//Enter Billing postal code
			myphelpers.EnterBillingPostalCode("201301");
			
			//Select privacy policy check box
			cbchelpers.ClickItem("BillingInfo.PrivacyPolicy");
			
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
			sfdchelper.clickOn("link=Aman "+lastname2+" (D)");
			
			//Wait for element using xml node
			sfdchelper.WaitForItem("AccountDetails.AccountTitle", 40);
			
			//Verify Account Details page
			sfdchelper.VerifySFDCPageTitle("Account Detail");
			
			//Verify Individual account code
			sfdchelper.VerifyAccountStatus("Departed");
			System.out.println("Account Status is Departed");
			
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
