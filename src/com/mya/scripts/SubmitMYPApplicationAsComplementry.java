package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.MYPApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.pagehelper.SignupHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitMYPApplicationAsComplementry extends DriverTestCase
{	
	@Test
	public void testMYPApplicationAsComplementry() throws Exception
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
			getWebDriver().navigate().to(MYP_app_url_cmp);
			
			//Select Applicant type
			myphelpers.SelectApplicant("Individual");
			
			//Enter Title
			myphelpers.sendKeys("//*[@id='pg:form:applicantTitle']", "Mr.");
			
			//Enter First name and Last name
			myphelpers.sendKeys("//*[@id='pg:form:AFNameId']", "Aman");
			myphelpers.sendKeys("//*[@id='pg:form:ALNameId']", lastname);
			
			//Select Country
			myphelpers.SelectCountry("India");
			
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
			//myphelpers.DonationMode("In A Single Donation");
			
			//confirm agreement with the terms
			myphelpers.ConfirmTerms("Yes, I agree to the conditions");
			
			//Confirm third party consent
			//myphelpers.SelectConsent("Yes");
			
			//Wait for a second
			myphelpers.waitForWorkAroundTime(3000);
			
			//Click Submit form
			myphelpers.SubmitApplication();
			
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
