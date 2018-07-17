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

public class SubmitMYRCApplicationForOrg extends DriverTestCase
{	
	@Test
	public void testMYRCApplicationForOrg() throws Exception
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
			getWebDriver().navigate().to(MYRC_app_url);
			
			//Select Applicant type
			myrchelper.SelectApplicant("An Organization");
			myrchelper.waitForWorkAroundTime(4000);
			
			//Select application status
			myrchelper.SelectListItem("AppStatus","No");
			
			//Enter Title
			myrchelper.FillinData("OrgInfo.ContactTitle","Mr.");
			
			//Enter First name and Last name
			myrchelper.FillinData("OrgInfo.ContactFName", "Aman");
			myrchelper.FillinData("OrgInfo.ContactLName", lastname);
			
			//Enter contact birth date
			myrchelper.SelectListItem("OrgInfo.ContactBirthDay", "2");
			
			//Enter contact birth month
			myrchelper.SelectListItem("OrgInfo.ContactBirthMonth", "April");
			
			//Enter contact birth month
			myrchelper.FillinData("OrgInfo.ContactBirthYear", "1998");
			
			//Select Country
			myrchelper.SelectListItem("OrgInfo.ContactCountryOfRes","India");
			
			//Enter contact's email address
			myrchelper.FillinData("OrgInfo.ContactEmailAdd",lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			myrchelper.EnterContactPhone("8860544110");
			
			//Fill in organization description
			myrchelper.FillinData("OrgInfo.OrgName", "Aman Khan MYRC Organization");
			
			//Enter Establishment Country
			myrchelper.SelectListItem("OrgInfo.LegalEstablish", "Andorra");
			myrchelper.waitForWorkAroundTime(3000);
			
			//Enter Organization Foundation date
			myrchelper.SelectListItem("OrgInfo.FDay", "5");
			myrchelper.SelectListItem("OrgInfo.FMonth", "April");
			myrchelper.FillinData("OrgInfo.FYear", "1994");
			
			//Select Application is for
			myrchelper.SelectListItem("ApplictionIsFor", "New Recommendation");
			
			//select DoYouAgree
			myrchelper.SelectListItem("DoYouAgree", "Yes, I agree to the conditions");
			
			//Click Submit button to move on step 2
			myrchelper.ClickItem("SubmitForm");
			myrchelper.waitForWorkAroundTime(3000);
			
			//Click on Update button
			myrchelper.ClickItem("Update");
			myrchelper.waitForWorkAroundTime(3000);
			
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
