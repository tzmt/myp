package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitADCBCApplicationAsComplementry extends DriverTestCase
{	
	@Test
	public void testADCBCApplicationAsComplementry() throws Exception
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
			getWebDriver().navigate().to(ADCBC_app_url_cmp);
			
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
			
			//Navigate to CBC application page
			sfdchelper.ClickItem("AccountDetails.CBCMasterCode");
		    sfdchelper.waitForWorkAroundTime(3000);
			
			//Verify Payment Method
			sfdchelper.VerifyPaymenMethod("Complimentary");
			sfdchelper.waitForWorkAroundTime(2000);
			System.out.println("Payment method is set to Complementry");
		
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
