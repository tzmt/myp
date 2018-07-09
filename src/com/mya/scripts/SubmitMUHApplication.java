package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ACBTApplicationHelper;
import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.MUHApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitMUHApplication extends DriverTestCase
{	
	@Test
	public void testMUHApplication() throws Exception
	{			
		//Initialize objects
		sfdchelper = new SFDCHelper(getWebDriver());
		acbthelper = new ACBTApplicationHelper(getWebDriver());
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		muhhelper = new MUHApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(MUH_app_url);
			
			//Select Applicant type
			muhhelper.SelectApplicant("Myself");
			
			//Select application status
			muhhelper.SelectListItem("AppStatus","Already Completed");
			
			//Enter Title
			muhhelper.FillinData("YoPersInfo.Title","Mr.");
			
			//Enter First name and Last name
			muhhelper.FillinData("YoPersInfo.FName", "Aman");
			muhhelper.FillinData("YoPersInfo.LName", lastname);
			
			//Select Country
			muhhelper.SelectCountryOfStay("India");
			
			//Select Applicant's birth day
			muhhelper.ApplicantBDay("1");
			
			//Select Applicant's Birth month
			muhhelper.ApplicantBMonth("July");
			
			//Select Applican't birth year
			muhhelper.ApplicantBYear("1988");
			
			//Enter contact's email address
			muhhelper.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			muhhelper.EnterContactPhone("8860544110");
			
			//Select TM Program
			muhhelper.SelectListItem("TMProgram", "Not Yet Practicing");
			
			//Select Purpose of Muhurat
			muhhelper.SelectListItem("MuhPurpose", "Applying for Job");
			
			//Enter start Date of first choice
			muhhelper.SelectListItem("FirstChoice.StartDay", "4");
			muhhelper.SelectListItem("FirstChoice.StartMonth", "April");
			muhhelper.FillinData("FirstChoice.StartYear", "2017");
			
			//Select End date of first choice
			muhhelper.SelectListItem("FirstChoice.EndDay", "4");
			muhhelper.SelectListItem("FirstChoice.EndMonth", "May");
			muhhelper.FillinData("FirstChoice.EndYear", "2017");
			
			//Select Location of event
			muhhelper.SelectListItem("EventLocation.ECountry", "India");
			muhhelper.waitForWorkAroundTime(3000);
			muhhelper.FillinData("EventLocation.State", "Noida");
			muhhelper.FillinData("EventLocation.City", "UP");
			
			//select DoYouAgree
			muhhelper.SelectListItem("DoYouAgree", "Yes, I agree to the conditions.");
			
			//Click Submit button to move on step 2
			muhhelper.ClickItem("SubmitForm");
			
			//Click on Update button
			muhhelper.ClickItem("Update");
			muhhelper.waitForWorkAroundTime(3000);
			
			//validate billing page
			acbthelper.ValidateBillingPage();
			
			//fill in Billing Phone 
			cbchelpers.FillinData("BillingInfo.BillingPhone", "5676546766");
			
			//Fill in Billing Street
			cbchelpers.FillinData("BillingInfo.BillingStreet", "Test");
			
			//Fill in Billing city 
			cbchelpers.FillinData("BillingInfo.BillingCity", "Noida");
			
			//Fill in postal code
			cbchelpers.FillinData("BillingInfo.Postalcode", "201301");
			
			//Select privacy policy check box
			cbchelpers.ClickItem("BillingInfo.PrivacyPolicy");
			
			//Pay by other options
			cbchelpers.ClickItem("BillingInfo.PayByOther");
			
			//Wait for workaround time
			cbchelpers.waitForWorkAroundTime(4000);
			
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
