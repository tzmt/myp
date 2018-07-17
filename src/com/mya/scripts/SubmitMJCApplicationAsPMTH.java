package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ACBTApplicationHelper;
import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.MJCApplicationHelper;
import com.mya.pagehelper.MUHApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitMJCApplicationAsPMTH extends DriverTestCase
{	
	@Test
	public void testMJCApplicationAsComplementary() throws Exception
	{			
		//Initialize objects
		sfdchelper = new SFDCHelper(getWebDriver());
		acbthelper = new ACBTApplicationHelper(getWebDriver());
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		mjchelper = new MJCApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(MJC_app_url_PMTH);
			
			//Select Applicant type
			mjchelper.SelectApplicant("Myself");
			
			//Select application status
			mjchelper.SelectListItem("AppStatus","Already Completed");
			
			//Enter Title
			mjchelper.FillinData("YoPersInfo.Title","Mr.");
			
			//Enter First name and Last name
			mjchelper.FillinData("YoPersInfo.FName", "Aman");
			mjchelper.FillinData("YoPersInfo.LName", lastname);
			
			//Select Country
			mjchelper.SelectCountryOfStay("India");
			
			//Select Applicant's birth day
			mjchelper.ApplicantBDay("1");
			
			//Select Applicant's Birth month
			mjchelper.ApplicantBMonth("July");
			
			//Select Applican't birth year
			mjchelper.ApplicantBYear("1988");
			
			//Enter contact's email address
			mjchelper.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			mjchelper.EnterContactPhone("8860544110");
			
			//Fill in profession 
			mjchelper.FillinData("YoPersInfo.Profession", "Testing");
			
			//Select TM Program
			mjchelper.SelectListItem("TMProgram", "Not Yet Practicing");
			
			//Select type of consultation
			mjchelper.SelectListItem("ConsultationType", "15 minutes - 1 year predictions");
			mjchelper.waitForWorkAroundTime(3000);
			
			//Select area of concern
			mjchelper.SelectListItem("AreaConcern", "Education");
			
			//select DoYouAgree
			mjchelper.SelectListItem("DoYouAgree", "Yes, I agree to the conditions");
			
			//Click Submit button to move on step 2
			mjchelper.ClickItem("SubmitForm");
			
			//Click on Update button
			mjchelper.ClickItem("Update");
			mjchelper.waitForWorkAroundTime(5000);
			
			//Login to to SFDC
			sfdchelper.sendKeys("//*[@id='username']","aman@bsyf.org.testing" );
			sfdchelper.sendKeys("//*[@id='password']", "2wsx@WSX1qaz%");
			sfdchelper.ClickItem("Submit");
			
			//Wait For Home page load
			sfdchelper.waitForWorkAroundTime(3000);
			
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
