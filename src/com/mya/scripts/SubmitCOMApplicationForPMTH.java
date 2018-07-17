package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ACBTApplicationHelper;
import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.COMApplicationHelper;
import com.mya.pagehelper.MUHApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitCOMApplicationForPMTH extends DriverTestCase
{	
	@Test
	public void testCOMApplicationForPMTH() throws Exception
	{			
		//Initialize objects
		sfdchelper = new SFDCHelper(getWebDriver());
		acbthelper = new ACBTApplicationHelper(getWebDriver());
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		comhelper = new COMApplicationHelper(getWebDriver());
		

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);
		String Plastname = "Partner A"+getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(COM_app_url_PMTH);
			
			//Select Applicant type
			comhelper.SelectApplicant("Myself");
			
			//Enter Title
			comhelper.FillinData("YoPersInfo.Title","Mr.");
			
			//Enter First name and Last name
			comhelper.FillinData("YoPersInfo.FName", "Aman");
			comhelper.FillinData("YoPersInfo.LName", lastname);
			
			//Select Applicant's birth day
			comhelper.ApplicantBDay("1");
			
			//Select Applicant's Birth month
			comhelper.ApplicantBMonth("July");
			
			//Select Applican't birth year
			comhelper.ApplicantBYear("1988");
			
			//Select Country
			comhelper.SelectCountryOfStay("India");
			
			//Enter contact's email address
			comhelper.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			comhelper.EnterContactPhone("8860544110");
			
			//Select TM Program
			comhelper.SelectListItem("ComService", "Marriage");
		
			//Enter partner A details
			comhelper.FillinData("PartnerA.PTitle", "Mr.");
			comhelper.FillinData("PartnerA.PFirstName", "Aman");
			comhelper.FillinData("PartnerA.PLastName", Plastname);
			comhelper.SelectListItem("PartnerA.PGender", "Male");
			comhelper.SelectListItem("PartnerA.ABirtDay", "19");
			comhelper.SelectListItem("PartnerA.ABirthMonth", "April");
			comhelper.FillinData("PartnerA.ABirthYear", "1994");
			comhelper.SelectListItem("PartnerA.PBirthChart", "Already Completed");
			
			//Enter partner B details
			comhelper.FillinData("PartnerB.PTitle", "Mr.");
			comhelper.FillinData("PartnerB.PFirstName", "Aman B");
			comhelper.FillinData("PartnerB.PLastName", Plastname);
			comhelper.SelectListItem("PartnerB.PGender", "Male");
			comhelper.SelectListItem("PartnerB.BBirtDay", "12");
			comhelper.SelectListItem("PartnerB.BBirthMonth", "May");
			comhelper.FillinData("PartnerB.BBirthYear", "1990");
			comhelper.SelectListItem("PartnerB.PBirthChart", "Already Completed");
			
			//select DoYouAgree
			comhelper.SelectListItem("DoYouAgree", "Yes, I agree to the conditions.");
			
			//Click Submit button to move on step 2
			comhelper.SelectListItem("Consent", "Yes");
			
			//Click Submit button
			comhelper.ClickItem("SubmitForm");
			
			//Click on Update button
			comhelper.ClickItem("Update");
			comhelper.waitForWorkAroundTime(7000);
					
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
