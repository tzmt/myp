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

public class SubmitCOMApplicationForIndividualwithcode extends DriverTestCase
{	
	@Test
	public void testCOMApplicationForIndividualwithcode() throws Exception
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
			getWebDriver().navigate().to(COM_app_url_Indvaccnt);
			
			//Select Country
			comhelper.SelectCountryOfStay("India");
			
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
			sfdchelper.clickOn("link=Amam New Khan657w937");
			
			//Wait for element using xml node
			sfdchelper.WaitForItem("AccountDetails.AccountTitle", 40);
					
			//Verify Account Details page
			sfdchelper.VerifySFDCPageTitle("Account Detail");
					
			//Verify Individual account code
			sfdchelper.VerifyAccountCode("CBC-003544-AZE");
			System.out.println("Account Code is Verified");
			

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
