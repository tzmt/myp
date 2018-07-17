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

public class SubmitMJCApplicationForOrg extends DriverTestCase
{	
	@Test
	public void testMJCApplicationForOrg() throws Exception
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
			getWebDriver().navigate().to(MJC_app_url);
			
			//Select Applicant type
			mjchelper.SelectApplicant("An Organization");
			mjchelper.waitForWorkAroundTime(3000);
			
			//Select application status
			mjchelper.SelectListItem("AppStatus","Already Completed");
			
			//Enter Title
			mjchelper.FillinData("OrgInfo.ContactTitle","Mr.");
			
			//Enter First name and Last name
			mjchelper.FillinData("OrgInfo.ContactFName", "Aman");
			mjchelper.FillinData("OrgInfo.ContactLName", lastname);
			
			//Enter contact birth date
			mjchelper.SelectListItem("OrgInfo.ContactBirthDay", "2");
			
			//Enter contact birth month
			mjchelper.SelectListItem("OrgInfo.ContactBirthMonth", "April");
			
			//Enter contact birth month
			mjchelper.FillinData("OrgInfo.ContactBirthYear", "1998");
			
			//Select Country
			mjchelper.SelectListItem("OrgInfo.ContactCountryOfRes","India");
			
			//Enter contact's email address
			mjchelper.FillinData("OrgInfo.ContactEmailAdd",lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			mjchelper.EnterContactPhone("8860544110");
			
			//Fill in organization description
			mjchelper.FillinData("OrgInfo.OrgName", "Aman Khan Organization qa");
			
			//Enter Establishment Country
			mjchelper.SelectListItem("OrgInfo.LegalEstablish", "Andorra");
			mjchelper.waitForWorkAroundTime(4000);
			
			//Enter Organization Foundation date
			mjchelper.SelectListItem("OrgInfo.FDay", "5");
			mjchelper.SelectListItem("OrgInfo.FMonth", "April");
			mjchelper.FillinData("OrgInfo.FYear", "1994");
			
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
			mjchelper.waitForWorkAroundTime(3000);
			
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
