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

public class SubmitACBTApplicationForOverride extends DriverTestCase
{	
	@Test
	public void testACBTApplicationForOverride() throws Exception
	{			
		//Initialize objects
		sfdchelper = new SFDCHelper(getWebDriver());
		acbthelper = new ACBTApplicationHelper(getWebDriver());
		cbchelpers = new CBCApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(ACBT_app_url_Override);
			
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
			
			//Select Applicant's birth day
			acbthelper.ApplicantBDay("1");
			
			//Select Applicant's Birth month
			acbthelper.ApplicantBMonth("July");
			
			//Select Applican't birth year
			acbthelper.ApplicantBYear("1988");
			
			//Select Birth time hour
			acbthelper.SelectListItem("YourBirthDetails.ApplicantBirthHour", "5");
			
			//Select Birth time minutes
			acbthelper.SelectListItem("YourBirthDetails.ApplicantBirthMin", "5");
			
			//Select Birth time seconds
			acbthelper.SelectListItem("YourBirthDetails.ApplicantBirthSeconds", "5");
			
			//Select if yes/no/Unsure for Day light saving 
			acbthelper.SelectListItem("YourBirthDetails.DaylightSavingsTime", "No");
			
			//Select Accuracy of the time
			acbthelper.SelectListItem("YourBirthDetails.Accuracy", "Within 1 second before or after the above time");
			
		   //Select location where born
			acbthelper.SelectListItem("YourBirthDetails.WhereBorn", "Home");
			acbthelper.waitForWorkAroundTime(4000);
			
			//Where were you born
			acbthelper.SelectListItem("YourBirthDetails.Gender", "Male");
			
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
			
			//Select TM Program
			acbthelper.SelectListItem("TMProgram", "Not Yet Practicing TM");
			
			//Enter Journey details
			acbthelper.FillinData("Journey.PlaceVisited", "Tester Qa");
			acbthelper.SelectListItem("Journey.DepartureDay","2");
			acbthelper.SelectListItem("Journey.DepartureMonth","April");
			acbthelper.FillinData("Journey.DepartureYear","2001");
			acbthelper.SelectListItem("Journey.ReturnDay","2");
			acbthelper.SelectListItem("Journey.ReturnMonth","April");
			acbthelper.FillinData("Journey.ReturnYear","2001");
			
			//Enter Major loss details
			acbthelper.FillinData("Loss.LEvent", "Loss Test");
			acbthelper.SelectListItem("Loss.LDay", "4");
			acbthelper.SelectListItem("Loss.LMonth","April");
			acbthelper.FillinData("Loss.LYear","2001");
			
			//Enter Major gains details
			acbthelper.FillinData("Gains.GEvent", "Gain Test");
			acbthelper.SelectListItem("Gains.GDay", "7");
			acbthelper.SelectListItem("Gains.GMonth","April");
			acbthelper.FillinData("Gains.GYear","2001");
			
			//Enter Education break details
			acbthelper.SelectListItem("EBreak.FDay","2");
			acbthelper.SelectListItem("EBreak.FMonth","April");
			acbthelper.FillinData("EBreak.FYear","2001");
			acbthelper.SelectListItem("EBreak.TDay","2");
			acbthelper.SelectListItem("EBreak.TMonth","April");
			acbthelper.FillinData("EBreak.TYear","2001");
			acbthelper.FillinData("EBreak.Description", "Tester Qa");
			
			//Enter Occupation details
			acbthelper.FillinData("Occupation.ODescription", "Occupation Qa");
			acbthelper.SelectListItem("Occupation.FDay","2");
			acbthelper.SelectListItem("Occupation.FMonth","April");
			acbthelper.FillinData("Occupation.FYear","2002");
			acbthelper.SelectListItem("Occupation.ToDay","2");
			acbthelper.SelectListItem("Occupation.ToMonth","April");
			acbthelper.FillinData("Occupation.ToYear","2003");
			
			//Select Inheritance
			acbthelper.SelectListItem("Inheritance", "No");
			
			//Fill in Marriage details 
			acbthelper.FillinData("Marriage.Event", "Test Event");
			acbthelper.SelectListItem("Marriage.Day", "3");
			acbthelper.SelectListItem("Marriage.Month", "February");
			acbthelper.FillinData("Marriage.Year", "2001");
			
			//Fill in Auspicious event details
			acbthelper.FillinData("AEvents.AEvent", "Test Event");
			acbthelper.SelectListItem("AEvents.ADay", "3");
			acbthelper.SelectListItem("AEvents.AMonth", "February");
			acbthelper.FillinData("AEvents.AYear", "2017");
			
			//Fill in Inauspicious event details
			acbthelper.FillinData("IEvents.IEvent", "Test Event");
			acbthelper.SelectListItem("IEvents.IDay", "6");
			acbthelper.SelectListItem("IEvents.IMonth", "May");
			acbthelper.FillinData("IEvents.IYear", "2017");
			
			//Fill in other event details
			acbthelper.FillinData("OEvents.OEvent", "Test Event");
			acbthelper.SelectListItem("OEvents.ODay", "6");
			acbthelper.SelectListItem("OEvents.OMonth", "May");
			acbthelper.FillinData("OEvents.OYear", "2017");
			
			//select Body height unit and height 
			acbthelper.SelectListItem("BodyHeight.Unit", "Centimeters");
			acbthelper.waitForWorkAroundTime(6000);
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
			
			//Click on Update button
			acbthelper.ClickItem("Update");
			
			//Wait for workaround time
			acbthelper.waitForWorkAroundTime(4000);
			
			//click Submit in order to proceed for payment 
			acbthelper.ClickItem("UploadImgLater");
			
			//Wait for step 2 page to load 
			acbthelper.waitForWorkAroundTime(5000);
			
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
			sfdchelper.waitForWorkAroundTime(4000);
			
			//Select iFrame
			sfdchelper.SelectiFrame("MJYUnbilledApplications");
			
			//Click on Newly Added Account name
			sfdchelper.clickOn("link=Aman "+lastname);
			
			//Verify Account Details page
			sfdchelper.VerifySFDCPageTitle("Account Detail");
			
			//Verify Canada Administrator check box is selected
			sfdchelper.isChecked("//*[@id='00No000000CcU4B_chkbox']");
			System.out.println("Check box is checked");
			

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
