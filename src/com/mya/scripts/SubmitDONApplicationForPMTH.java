package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ACBTApplicationHelper;
import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.COMApplicationHelper;
import com.mya.pagehelper.DONApplicationHelper;
import com.mya.pagehelper.MUHApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitDONApplicationForPMTH extends DriverTestCase
{	
	@Test
	public void testDONApplicationAsComplimentary() throws Exception
	{			
		//Initialize objects
		sfdchelper = new SFDCHelper(getWebDriver());
		acbthelper = new ACBTApplicationHelper(getWebDriver());
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		donhelper = new DONApplicationHelper(getWebDriver());
		

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);
		String recipientlastname = "Khan Yagya" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(DON_app_url_PMTH);
			
			//Select Applicant type
			donhelper.SelectApplicant("Individual");
			donhelper.waitForWorkAroundTime(3000);
			
			//Select Country
			donhelper.SelectCountryOfStay("India");
			donhelper.waitForWorkAroundTime(2000);
			
			//Enter Title
			donhelper.FillinData("YoPersInfo.Title","Mr.");
			
			//Enter First name and Last name
			donhelper.FillinData("YoPersInfo.FName", "Aman");
			donhelper.FillinData("YoPersInfo.LName", lastname);
			
			//Select Applicant's birth day
			donhelper.ApplicantBDay("1");
			
			//Select Applicant's Birth month
			donhelper.ApplicantBMonth("July");
			
			//Select Applican't birth year
			donhelper.ApplicantBYear("1988");
			
			//Enter contact's email address
			donhelper.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			donhelper.EnterContactPhone("8860544110");
			
			//Fill First name and Last name of yagya recipient
			donhelper.FillinData("YagyaRecipient.FNameRecipient", "Aman");
			donhelper.FillinData("YagyaRecipient.LNameRecipient", recipientlastname);
			
			//Fill in donation amount
		    donhelper.FillinData("YagyaRecipient.Donationamount", "456");
			
			//select DoYouAgree
			donhelper.SelectListItem("DoYouAgree", "Yes, I agree to the conditions.");
			
			//Click Submit button
			donhelper.ClickItem("SubmitForm");
			
			//Wait for workaround time
			cbchelpers.waitForWorkAroundTime(7000);
			
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
