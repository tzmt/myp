package com.mya.scripts;


import java.util.Random;

import org.openqa.selenium.remote.server.handler.GetElementText;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;
import com.sun.mail.handlers.text_xml;

import junit.framework.Assert;

public class SubmitADCBCApplicationAsOrgAccntCode extends DriverTestCase
{	
	@Test
	public void testADCBCApplicationAsOrgAccntCode() throws Exception
	{			
		//Initialize objects
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		sfdchelper = new SFDCHelper(getWebDriver());
		adcbchelper = new ADCBCApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);
		String lastname2 = "Org" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(ADCBC_app_url_Orgaccnt);
			
			//Enter Title
			cbchelpers.FillinData("OrgInfo.ContactTitle", "Mr.");
			
			//Enter First name and Last name
			cbchelpers.FillinData("OrgInfo.ContactFName", "Aman");
			cbchelpers.FillinData("OrgInfo.ContactLName", lastname);
			
			//Select Contact's birth day
			cbchelpers.SelectListItem("OrgInfo.ContactBirthDay", "19");
			
			//Select Contact's Birth month
			cbchelpers.SelectListItem("OrgInfo.ContactBirthMonth", "April");
			
			//Select Contact's birth year
			cbchelpers.FillinData("OrgInfo.ContactBirthYear", "1994");
			
			//Select Contact Country
			cbchelpers.Selectcontactcountry("India");
			
			//Enter contact's email address
			cbchelpers.EnterYourtEmail(lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			cbchelpers.EnterYourPhone("8860544110");
			
			
			//Fill in Organization description
			cbchelpers.FillinData("OrgInfo.OrgDescription", "Test Description");
			
			//Select Country of Legal Establishment
			cbchelpers.Selectorgcountry("India");
			cbchelpers.waitForWorkAroundTime(3000);
			
			//Fill in birth location Country 
			cbchelpers.SelectListItem("YourBirthLocation.Country", "India");
			cbchelpers.waitForWorkAroundTime(3000);
			
			//Fill in birth location State
			cbchelpers.FillinData("YourBirthLocation.ApplicantsBirthState", "UP");
			
			//Fill in birth location City
			cbchelpers.FillinData("YourBirthLocation.ApplicantsBirthCity", "Noida");
			
			//Fill in Relative First Name
			adcbchelper.FillinData("Relative1.FirstName", "Aslam");
			
			//fill in Relative Last name
			adcbchelper.FillinData("Relative1.LastName", lastname);
			
			//fill in relative relationship
			adcbchelper.SelectListItem("Relative1.Relationship", "Father");
			
			//Select response for Do you agree 
			cbchelpers.SelectListItem("DoYouAgree", "Yes, I agree to the conditions.");
			
			//Click Submit button to move on step 2
			cbchelpers.ClickItem("SubmitAndProceedToStep2");
			
			//Wait for step 2 page to load 
			cbchelpers.waitForWorkAroundTime(600);
			
			//Validate Billing information page
			adcbchelper.ValidateBillingPage();
			
			//fill in Title
			cbchelpers.FillinData("BillingInfo.BillingTitle", "Mr");
			
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
			sfdchelper.SelectiFrame("066o0000002HNjw");
			
			//Click on Newly Added Account name
			sfdchelper.clickOn("link=Aman Organization Khan9755 ");
			
		   
			

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
