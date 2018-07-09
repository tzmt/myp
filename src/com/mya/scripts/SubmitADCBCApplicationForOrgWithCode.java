package com.mya.scripts;


import java.sql.Driver;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Console;
import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;
import com.steadystate.css.util.Output;

public class SubmitADCBCApplicationForOrgWithCode extends DriverTestCase
{	
	@Test
	public void testADCBCApplicationForOrgWithCode() throws Exception
	{			
		//Initialize objects
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		sfdchelper = new SFDCHelper(getWebDriver());
		adcbchelper = new ADCBCApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);
		String lastname2 = "Relative" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(ADCBC_app_url);
			
			//Change the parameter when Payment is true.
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(ADCBC_app_url_Orgaccnt);
			
			
			//Enter Title
			cbchelpers.FillinData("OrgInfo.ContactTitle", "Mr.");
			
			//Enter First name and Last name
			cbchelpers.FillinData("OrgInfo.ContactFName", "Aman");
			cbchelpers.FillinData("OrgInfo.ContactLName", lastname2);
			
			//Select contact's birth day
            cbchelpers.SelectListItem("OrgInfo.ContactBirthDay", "19");
            
            //Select contact's birth month
			cbchelpers.SelectListItem("OrgInfo.ContactBirthMonth", "April");
			
			//Select contact's birth year
			cbchelpers.FillinData("OrgInfo.ContactBirthYear", "1994");
			
			//Select Country
			cbchelpers.Selectcontactcountry("India");
			
			//Enter contact's email address
			cbchelpers.EnterContactEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			cbchelpers.EnterContactPhone("8860544110");
			
			//Fill in organization description
			cbchelpers.Selectorgcountry("Canada");
			
			//fill in Relative Last name
			adcbchelper.FillinData("Relative1.FirstName", "Aman");
			
			//fill in Relative Last name
			adcbchelper.FillinData("Relative1.LastName", lastname);
			
			//Select response for Do you agree 
			cbchelpers.SelectListItem("DoYouAgree", "Yes, I agree to the conditions.");
			
			//Select Third party compliance
			cbchelpers.SelectListItem("Consent","Yes");
			
			//Submit the application now 
			cbchelpers.ClickItem("SubmitAndProceedToStep2");
			
			//Click on Update button
			cbchelpers.ClickItem("Update");
			
			//Wait for step 2 page to load 
			cbchelpers.waitForWorkAroundTime(6000);
			
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
			sfdchelper.clickOn("link=Aman Organization Khan9755");
			
			//Wait for element using xml node
			sfdchelper.WaitForItem("AccountDetails.AccountTitle", 40);
			
			//Verify Account Details page
			sfdchelper.VerifySFDCPageTitle("Account Detail");
			
			//Verify Individual account code
			sfdchelper.VerifyAccountCode("CBC-003529-IND");
			System.out.println("Account Code for organization is Verified");
		
		}

		catch (Error e) 
		{
			ExecutionLog.LogErrorMessage(e);			
			throw e;
		} 
		catch(Exception e)
		{
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
