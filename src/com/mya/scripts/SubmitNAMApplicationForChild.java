package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.NAMApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitNAMApplicationForChild extends DriverTestCase
{	
	@Test
	public void testNAMApplicationForChild() throws Exception
	{			
		//Initialize objects
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		sfdchelper = new SFDCHelper(getWebDriver());
		adcbchelper = new ADCBCApplicationHelper(getWebDriver());
		namhelper =new NAMApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(NAM_app_url);
			
			//Select Applicant type
			namhelper.SelectApplicant("A Newborn Child");
			
			//Enter Title
			namhelper.FillinData("YoPersInfo.Title", "Mr.");
			
			//Enter First name and Last name
			namhelper.FillinData("YoPersInfo.FName", "Aman");
			namhelper.FillinData("YoPersInfo.LName", lastname);
			
			//Enter Birth Date
			namhelper.SelectListItem("YoPersInfo.PBirthDay", "7");
			namhelper.SelectListItem("YoPersInfo.PBirthMonth", "June");
			namhelper.FillinData("YoPersInfo.PBirthYear", "1989");
			
			//Select Country
			namhelper.SelectCountryOfStay("India");
			
			//Enter contact's email address
			namhelper.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			namhelper.EnterContactPhone("8860544110");
			
			//Fill in child last name
			namhelper.FillinData("ChildBirthLoc.LChild", "Child Tester QA");
			
			//Fill in Applicant Gender
			namhelper.SelectListItem("ChildBirthLoc.ChildGen", "Male");
			
			//Fill in birth location Country 
			namhelper.SelectListItem("ChildBirthLoc.Country", "India");
			namhelper.waitForWorkAroundTime(4000);
			
			//Fill in birth location State
			namhelper.FillinData("ChildBirthLoc.ChildBirthState", "UP");
			
			//Fill in birth location City
			namhelper.FillinData("ChildBirthLoc.ChildBirthCity", "Noida");
			
			//Select Child birth day
			namhelper.ApplicantBDay("1");
			
			//Select Child Birth month
			namhelper.ApplicantBMonth("July");
			
			//Select Child birth year
			namhelper.ApplicantBYear("1988");
			
			//Select B'hour
			namhelper.SelectListItem("ChildBirthDateAndTime.ChildBirthTimeHour", "11");
			
			//Select B'min
			namhelper.SelectListItem("ChildBirthDateAndTime.ChildBirthTimeMinutes", "15");
			
			//Select B'sec
			namhelper.SelectListItem("ChildBirthDateAndTime.ChildBirthTimeSeconds", "25");
			
			//Select if yes/no/Unsure for Day light saving 
			namhelper.SelectListItem("ChildBirthDateAndTime.DaylightSavingsTime", "No");
			
			//Select B'Time source 
			namhelper.SelectListItem("ChildBirthDateAndTime.BirthTimeSource", "From Birth Certificate");
			
			//Select Accuracy of the source 
			namhelper.SelectListItem("ChildBirthDateAndTime.BirthTimeZone", "(GMT+00:00) Greenwich Mean Time (Europe/Dublin)");
			
			//Select response for Do you agree 
			namhelper.SelectListItem("DoYouAgree", "Yes, I agree to the conditions");
			
			//Click Submit button to move on step 2
			namhelper.ClickItem("SubmitForm");
			
			//Wait for step 2 page to load 
			namhelper.waitForWorkAroundTime(3000);
			
			//Click on Update button
			namhelper.ClickItem("Update");
			namhelper.waitForWorkAroundTime(3000);
			
			//Validate Billing information page
			adcbchelper.ValidateBillingPage();
			
			//fill in Billing Phone 
			namhelper.FillinData("BillingInfo.BillingPhone", "5676546766");
			
			//Fill in Billing Street
			namhelper.FillinData("BillingInfo.BillingStreet", "Test");
			
			//Fill in Billing city 
			namhelper.FillinData("BillingInfo.BillingCity", "Noida");
			
			//Fill in postal code
			namhelper.FillinData("BillingInfo.Postalcode", "201301");
			
			//Select privacy policy check box
			namhelper.ClickItem("BillingInfo.PrivacyPolicy");
			
			//Pay by other options
			namhelper.ClickItem("BillingInfo.PayByOther");
			
			//Wait for workaround time
			namhelper.waitForWorkAroundTime(7000);
			
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
