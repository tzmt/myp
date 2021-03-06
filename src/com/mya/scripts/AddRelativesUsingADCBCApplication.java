package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.MYPApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class AddRelativesUsingADCBCApplication extends DriverTestCase
{	
	@Test
	public void testCBCApplication() throws Exception
	{			
		//Initialize objects
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		sfdchelper = new SFDCHelper(getWebDriver());
		adcbchelper = new ADCBCApplicationHelper(getWebDriver());
		myphelpers = new MYPApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(CBC_app_url);
			
			//Select Applicant type
			cbchelpers.SelectApplicant("Myself");
			
			//Enter Title
			cbchelpers.FillinData("YoPersInfo.Title", "Mr.");
			
			//Enter First name and Last name
			cbchelpers.FillinData("YoPersInfo.FName", "Aman");
			cbchelpers.FillinData("YoPersInfo.LName", lastname);
			
			//Select Country
			cbchelpers.SelectCountryOfStay("India");
			
			//Enter contact's email address
			cbchelpers.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			cbchelpers.EnterContactPhone("8860544110");
			
			//Fill in Applicant Gender
			cbchelpers.SelectListItem("YoPersInfo.ApplicantsGen", "Male");
			
			//Fill in MMartial status
			cbchelpers.SelectListItem("YoPersInfo.MarStatus", "Single");
			
			//Fill in profession
			cbchelpers.FillinData("YoPersInfo.Profession", "QA");
			
			//Fill in birth location Country 
			cbchelpers.SelectListItem("YourBirthLocation.Country", "India");
			
			//Fill in birth location State
			cbchelpers.FillinData("YourBirthLocation.ApplicantsBirthState", "UP");
			
			//Fill in birth location City
			cbchelpers.FillinData("YourBirthLocation.ApplicantsBirthCity", "Noida");
			
			//Select Applicant's birth day
			cbchelpers.ApplicantBDay("1");
			
			//Select Applicant's Birth month
			cbchelpers.ApplicantBMonth("July");
			
			//Select Applican't birth year
			cbchelpers.ApplicantBYear("1988");
			
			//Select B'hour
			cbchelpers.SelectListItem("YourBirthDateAndTime.ApplicantsBirthTimeHour", "11");
			
			//Select B'min
			cbchelpers.SelectListItem("YourBirthDateAndTime.ApplicantsBirthTimeMinutes", "15");
			
			//Select B'sec
			cbchelpers.SelectListItem("YourBirthDateAndTime.ApplicantsBirthTimeSeconds", "25");
			
			//Select if yes/no/Unsure for Day light saving 
			cbchelpers.SelectListItem("YourBirthDateAndTime.DaylightSavingsTime", "No");
			
			//Select B'Time source 
			cbchelpers.SelectListItem("YourBirthDateAndTime.BirthTimeSource", "From Birth Certificate");
			
			//Select Accuracy of the source 
			cbchelpers.SelectListItem("YourBirthDateAndTime.BirthTimeAccuracy", "Confirmed to +/- 1 second");
			
			//Select TM program participation 
			cbchelpers.SelectListItem("TMProgram.TMProgPart", "Not Yet Practicing TM");
			
			//Select response for Do you agree 
			cbchelpers.SelectListItem("DoYouAgree", "Yes, I agree to the conditions.");
			
			//Click Submit button to move on step 2
			cbchelpers.ClickItem("SubmitAndProceedToStep2");
			
			//Wait for step 2 page to load 
			cbchelpers.waitForWorkAroundTime(5000);
			
			//Submit the application now 
			cbchelpers.ClickItem("SubmitAndProceedToStep2");
			
			//Wait for step 2 page to load 
			cbchelpers.waitForWorkAroundTime(6000);
			
			//Click on Update button
			cbchelpers.ClickItem("Update");
			
			//Wait for step 2 page to load 
			cbchelpers.waitForWorkAroundTime(3000);
			
			//Validate Billing information page
			adcbchelper.ValidateBillingPage();
			
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
			
			//Verify Account Details page
			sfdchelper.VerifySFDCPageTitle("Account Detail");
			
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(ADCBC_app_url);
			
			//Select Applicant type
			cbchelpers.SelectApplicant("Adding Relatives to My Birth Chart");
			
			//Enter Title
			cbchelpers.FillinData("YoPersInfo.Title", "Mr.");
			
			//Enter First name and Last name
			cbchelpers.FillinData("YoPersInfo.FName", "Aman");
			cbchelpers.FillinData("YoPersInfo.LName", lastname);
			
			//Select Country
			cbchelpers.SelectCountryOfStay("India");
			
			//Enter contact's email address
			cbchelpers.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			cbchelpers.EnterContactPhone("8860544110");
			
			//Select Applicant's birth day
			cbchelpers.ApplicantBDay("1");
			
			//Select Applicant's Birth month
			cbchelpers.ApplicantBMonth("July");
			
			//Select Applican't birth year
			cbchelpers.ApplicantBYear("1988");
			
			//Fill in MMartial status
			cbchelpers.SelectListItem("YoPersInfo.MarStatus", "Single");
			
		    //Fill in Relative First Name
			adcbchelper.FillinData("Relative1.FirstName", "Aslam");
			
			//fill in Relative Last name
			adcbchelper.FillinData("Relative1.LastName", lastname);
			
			//fill in relative relationship
			adcbchelper.SelectListItem("Relative1.Relationship", "Father");
			
			//Select response for Do you agree 
			cbchelpers.SelectListItem("DoYouAgree", "Yes, I agree to the conditions.");
			
			//Submit the application now 
			cbchelpers.ClickItem("SubmitAndProceedToStep2");
			
			//Wait for step 2 page to load 
			cbchelpers.waitForWorkAroundTime(12000);
			
			//Validate Page 
			adcbchelper.ValidateBillingPage();
			
			//fill in Billing Phone 
			cbchelpers.FillinData("BillingInfo.BillingPhone", "5676546766");
			
			//Fill in Billing Street
			cbchelpers.FillinData("BillingInfo.BillingStreet", "Test");
			
			//Fill in Billing city 
			cbchelpers.FillinData("BillingInfo.BillingCity", "Noida");
			
			//Fill in postal code
			cbchelpers.FillinData("BillingInfo.Postalcode", "201301");
			
			//Pay by other options
			cbchelpers.ClickItem("BillingInfo.PayByOther");
			
			//Wait for workaround time
			cbchelpers.waitForWorkAroundTime(4000);
			
			//Now got to SFDC
			sfdchelper.LoginIntoSFDC(sfdc_url, username, password);
			
			//Wait For Home page load
			sfdchelper.waitForWorkAroundTime(5000);
			
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
