package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitADCBCApplicationForPMTH extends DriverTestCase
{	
	@Test
	public void testADCBCApplicationForOverride() throws Exception
	{			
		//Initialize objects
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		sfdchelper = new SFDCHelper(getWebDriver());
		adcbchelper = new ADCBCApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(ADCBC_app_url_pmth);
			
			//Select Applicant type
			//cbchelpers.SelectApplicant("Adding Relatives to My Birth Chart");
			
			//Enter Title
			cbchelpers.FillinData("YoPersInfo.Title", "Mr.");
			
			//Enter First name and Last name
			cbchelpers.FillinData("YoPersInfo.FName", "Aman");
			cbchelpers.FillinData("YoPersInfo.LName", lastname);
			
			//Select Country
			cbchelpers.SelectCountryOfStay("India");
			
			//Select Applicant's birth day
			cbchelpers.ApplicantBDay("1");
			
			//Select Applicant's Birth month
			cbchelpers.ApplicantBMonth("July");
			
			//Select Applican't birth year
			cbchelpers.ApplicantBYear("1988");
			
			//Enter contact's email address
			cbchelpers.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			cbchelpers.EnterContactPhone("8860544110");
			
			
		    //Fill in Relative First Name
			adcbchelper.FillinData("Relative1.FirstName", "Aman");
			
			//fill in Relative Last name
			adcbchelper.FillinData("Relative1.LastName", lastname);
			
			//fill in relative relationship
			adcbchelper.SelectListItem("Relative1.Relationship", "Father");
			
			//Select response for Do you agree 
			cbchelpers.SelectListItem("DoYouAgree", "Yes, I agree to the conditions.");
			
			//Select Third party compliance
			cbchelpers.SelectListItem("Consent","Yes");
			
			//Submit the application now 
			cbchelpers.ClickItem("SubmitAndProceedToStep2");
			
			//Click on Update button
			cbchelpers.ClickItem("Update");
			
			//Wait for step 2 page to load 
			cbchelpers.waitForWorkAroundTime(8000);
			
			//Login to to SFDC
			sfdchelper.sendKeys("//*[@id='username']","aman@bsyf.org.testing" );
			sfdchelper.sendKeys("//*[@id='password']", "2wsx@WSX1qaz%");
			sfdchelper.ClickItem("Submit");
			
			//Wait For Home page load
			sfdchelper.waitForWorkAroundTime(300);
			
			//Verify Payment detail
			sfdchelper.VerifyPaymenPage("Payment Detail");
			System.out.println("Redirected on Payment Page");
		
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
