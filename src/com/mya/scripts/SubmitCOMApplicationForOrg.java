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

public class SubmitCOMApplicationForOrg extends DriverTestCase
{	
	@Test
	public void testCOMApplication() throws Exception
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
			getWebDriver().navigate().to(COM_app_url);
			
			//Select Applicant type
			comhelper.SelectApplicant("An Organization");
			
			//Enter Title
			comhelper.FillinData("OrgInfo.ContactTitle","Mr.");
			
			//Enter First name and Last name
			comhelper.FillinData("OrgInfo.ContactFName", "Aman");
			comhelper.FillinData("OrgInfo.ContactLName", lastname);
			
			//Enter contact birth date
			comhelper.SelectListItem("OrgInfo.ContactBirthDay", "2");
			
			//Enter contact birth month
			comhelper.SelectListItem("OrgInfo.ContactBirthMonth", "April");
			
			//Enter contact birth month
			comhelper.FillinData("OrgInfo.ContactBirthYear", "1998");
			
			//Select Country
			comhelper.SelectListItem("OrgInfo.ContactCountryOfRes","India");
			
			//Enter contact's email address
			comhelper.FillinData("OrgInfo.ContactEmailAdd",lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			comhelper.EnterContactPhone("8860544110");
			
			//Fill in organization description
			comhelper.FillinData("OrgInfo.OrgName", "Aman Khan Organization qa");
			
			//Enter Establishment Country
			comhelper.SelectListItem("OrgInfo.LegalEstablish", "Andorra");
			comhelper.waitForWorkAroundTime(3000);
			
			//Enter Organization Foundation date
			comhelper.SelectListItem("OrgInfo.FDay", "5");
			comhelper.SelectListItem("OrgInfo.FMonth", "April");
			comhelper.FillinData("OrgInfo.FYear", "1994");
			
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
			comhelper.waitForWorkAroundTime(3000);
			
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
			sfdchelper.clickOn("link=Aman Khan Organization qa");
			
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
