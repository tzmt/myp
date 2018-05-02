package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ACBTApplicationHelper;
import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitACBTApplication extends DriverTestCase
{	
	@Test
	public void testACBTApplication() throws Exception
	{			
		//Initialize objects
		sfdchelper = new SFDCHelper(getWebDriver());
		acbthelper = new ACBTApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(ACBT_app_url);
			
			//Select Applicant type
			acbthelper.SelectApplicant("Myself");
			
			//Enter Title
			acbthelper.FillinData("YoPersInfo.Title", "Mr.");
			
			//Enter First name and Last name
			acbthelper.FillinData("YoPersInfo.FName", "Aman");
			acbthelper.FillinData("YoPersInfo.LName", lastname);
			
			//Select Country
			acbthelper.SelectCountryOfStay("India");
			
			//Enter contact's email address
			acbthelper.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			acbthelper.EnterContactPhone("8860544110");
			
			//Fill in birth location Country 
			acbthelper.SelectListItem("YourBirthLocation.Country", "India");
			acbthelper.waitForWorkAroundTime(3000);
			
			//Fill in birth location State
			acbthelper.FillinData("YourBirthLocation.ApplicantsBirthState", "UP");
			
			//Fill in birth location City
			acbthelper.FillinData("YourBirthLocation.ApplicantsBirthCity", "Noida");
			
			//Fill in Gender
			acbthelper.SelectListItem("YourBirthDetails.Gender", "Male");
			
			//Select Applicant's birth day
			acbthelper.ApplicantBDay("1");
			
			//Select Applicant's Birth month
			acbthelper.ApplicantBMonth("July");
			
			//Select Applican't birth year
			acbthelper.ApplicantBYear("1988");
			
			//Where were you born
			acbthelper.SelectListItem("YourBirthDetails.WhereBorn", "Home");
			
			//Select if yes/no/Unsure for Day light saving 
			acbthelper.SelectListItem("YourBirthDetails.DaylightSavingsTime", "No");
			
			//Fill in Health issue 1
			acbthelper.FillinData("HealthIssues.Issue", "Test health issue");
			
			//Fill in health issue from details
			acbthelper.SelectListItem("HealthIssues.FromDay", "1");
			acbthelper.SelectListItem("HealthIssues.FromMonth", "February");
			acbthelper.FillinData("HealthIssues.FromYear", "2007");
			
			//Fill in health issue To details
			acbthelper.SelectListItem("HealthIssues.ToDay", "5");
			acbthelper.SelectListItem("HealthIssues.ToMonth", "February");
			acbthelper.FillinData("HealthIssues.ToYear", "2016");
			
			//Fill in relatives details 
			acbthelper.FillinData("Relatives.Relationship", "Test Relationship");
			acbthelper.FillinData("Relatives.Cause", "Testing");
			acbthelper.SelectListItem("Relatives.Day", "24");
			acbthelper.SelectListItem("Relatives.Month", "February");
			acbthelper.FillinData("Relatives.Year", "2006");
			
			//Fill in Marriage details 
			acbthelper.FillinData("Marriage.Event", "Test Event");
			acbthelper.SelectListItem("Marriage.Day", "3");
			acbthelper.SelectListItem("Marriage.Month", "February");
			acbthelper.FillinData("Marriage.Year", "2001");
			
			//Fill in Divorce details
			acbthelper.FillinData("Divorce.Event", "Test Divorce Event");
			acbthelper.SelectListItem("Divorce.Day", "7");
			acbthelper.SelectListItem("Divorce.Month", "February");
			acbthelper.FillinData("Divorce.Year", "2015");
			
			//Fill in Child details
			acbthelper.SelectListItem("Child.Relationship", "Son");
			acbthelper.SelectListItem("Child.Day", "7");
			acbthelper.SelectListItem("Child.Month", "February");
			acbthelper.FillinData("Child.Year", "2011");
			
			//select ElderSiblings
			acbthelper.SelectListItem("ElderSiblings", "Brother");
			
			//select YoungerSiblings
			acbthelper.SelectListItem("YoungerSiblings", "Sister");
			acbthelper.FillinData("Marriage.Year", "2001");
			
			//select Body height unit and height 
			acbthelper.SelectListItem("BodyHeight.Unit", "Centimeters");
			acbthelper.waitForWorkAroundTime(3000);
			acbthelper.FillinData("BodyHeight.Height", "175");
			
			//select body weight unit and weight 
			acbthelper.SelectListItem("BodyWeight.Unit", "Kilograms");
			acbthelper.waitForWorkAroundTime(3000);
			acbthelper.FillinData("BodyWeight.Weight", "78");
			
			//Select type of decisions making
			acbthelper.SelectListItem("DecisionMakingPatterns", "I make quick decisions but also change them quickly");
			
			//select Inheritance 
			acbthelper.SelectListItem("Inheritance", "No");
			
			//select DoYouAgree
			acbthelper.SelectListItem("DoYouAgree", "Yes, I agree to the conditions.");
			
			//Click Submit button to move on step 2
			acbthelper.ClickItem("SubmitForm");
			
			//Wait for upload personal photo screen
			acbthelper.WaitForElementPresent("id=files", 30);
			
			//Upload personal photo
			acbthelper.UploadFile();
			
			//Wait for workaround time
			acbthelper.waitForWorkAroundTime(3000);
			
			//click Submit in order to proceed for payment 
			acbthelper.ClickItem("SaveImgAndPay");
			
			//validate billing page
			acbthelper.ValidateBillingPage();
			

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
