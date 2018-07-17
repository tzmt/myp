package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ACBTApplicationHelper;
import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.MUHApplicationHelper;
import com.mya.pagehelper.MYRCApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitMYRCApplicationAsComplimentary extends DriverTestCase
{	
	@Test
	public void testMYRCApplicationAsComplimentary() throws Exception
	{			
		//Initialize objects
		sfdchelper = new SFDCHelper(getWebDriver());
		acbthelper = new ACBTApplicationHelper(getWebDriver());
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		myrchelper = new MYRCApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(MYRC_app_url_CMP);
			
			//Select Applicant type
			myrchelper.SelectApplicant("Myself");
			
			//Select application status
			myrchelper.SelectListItem("AppStatus","No");
			
			//Enter Title
			myrchelper.FillinData("YoPersInfo.Title","Mr.");
			
			//Enter First name and Last name
			myrchelper.FillinData("YoPersInfo.FName", "Aman");
			myrchelper.FillinData("YoPersInfo.LName", lastname);
			
			//Select Applicant's birth day
			myrchelper.ApplicantBDay("1");
			
			//Select Applicant's Birth month
			myrchelper.ApplicantBMonth("July");
			
			//Select Applican't birth year
			myrchelper.ApplicantBYear("1988");
			
			//Select Country
			myrchelper.SelectCountryOfStay("India");
			
			//Enter contact's email address
			myrchelper.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			myrchelper.EnterContactPhone("8860544110");
			
			//Select Mental/Physical health
			myrchelper.SelectListItem("YoPersInfo.Health", "Good");
			
			//Select TM Program
			myrchelper.SelectListItem("TMProgram", "Not Yet Practicing");
			
			//Select Application is for
			myrchelper.SelectListItem("ApplictionIsFor", "New Recommendation");
			
			//select DoYouAgree
			myrchelper.SelectListItem("DoYouAgree", "Yes, I agree to the conditions");
			
			//Click Submit button to move on step 2
			myrchelper.ClickItem("SubmitForm");
			
			//Click on Update button
			myrchelper.ClickItem("Update");
			myrchelper.waitForWorkAroundTime(5000);
			
			//Now got to SFDC
			sfdchelper.LoginIntoSFDC(sfdc_url, username, password);
			
			//Wait For Home page load
			sfdchelper.waitForWorkAroundTime(6000);
			
			//Select iFrame on with classic theme
			sfdchelper.SelectiFrame("MJYUnbilledApplications");
			
			//Click on Newly Added Account name
			sfdchelper.clickOn("link=Aman "+lastname);
			
			//Wait for element using xml node
			sfdchelper.WaitForItem("AccountDetails.AccountTitle", 40);
			
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
