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

public class SubmitMYPApplicationForIndividual extends DriverTestCase
{	
	@Test
	public void testMYPApplicationForIndividual() throws Exception
	{			
		//Initialize objects
		myphelpers = new MYPApplicationHelper(getWebDriver());
		sfdchelper = new SFDCHelper(getWebDriver());
		cbchelpers = new CBCApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(MYP_app_url_Indvaccnt);
			
			//select country of stay
			myphelpers.SelectCountry("India");
			
			//Select Yes/No for CBC completed for applicant
			myphelpers.CBCStatus("Yes");
			
			//select mental/physical health 
			myphelpers.SelectHealthStatus("Good");
			
			//Select country of stay
			myphelpers.SelectCountryOfStay("Afghanistan");
			
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
			//myphelpers.SelectConsent("Yes");
			
			//Wait for a second
			myphelpers.waitForWorkAroundTime(3000);
			
			//Click Submit form
			myphelpers.SubmitApplication();
			
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
			sfdchelper.waitForWorkAroundTime(6000);
			
			//Now got to SFDC
			sfdchelper.LoginIntoSFDC(sfdc_url, username, password);
			
			//Wait For Home page load
			sfdchelper.waitForWorkAroundTime(6000);
			
			//Select iFrame
			sfdchelper.SelectiFrame("MJYUnbilledApplications");
			
			//Click on Newly Added Account name
			sfdchelper.clickOn("link=Amam New Khan657w937");
			
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
