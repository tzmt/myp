package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ACBTApplicationHelper;
import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.MUHApplicationHelper;
import com.mya.pagehelper.MYRCApplicationHelper;
import com.mya.pagehelper.MYRDApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitMYRDApplication extends DriverTestCase
{	
	@Test
	public void testMYRDApplication() throws Exception
	{			
		//Initialize objects
		sfdchelper = new SFDCHelper(getWebDriver());
		acbthelper = new ACBTApplicationHelper(getWebDriver());
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		myrdhelper= new MYRDApplicationHelper(getWebDriver());

		//variables
		String lastname = "Khan" +getRandomInteger(1, 9999);
		String lastname2= "Deaprted" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(MYRD_app_url);
			
			//Enter Title
			myrdhelper.FillinData("ContactInfo.ContactTitle","Mr.");
			
			//Enter First name and Last name
			myrdhelper.FillinData("ContactInfo.ContactFName", "Aman");
			myrdhelper.FillinData("ContactInfo.ContactLName", lastname);
			
			//Enter contact birth date
			myrdhelper.SelectListItem("ContactInfo.ContactBirthDay", "2");
			
			//Enter contact birth month
			myrdhelper.SelectListItem("ContactInfo.ContactBirthMonth", "April");
			
			//Enter contact birth month
			myrdhelper.FillinData("ContactInfo.ContactBirthYear", "1998");
			
			//Select Contact birth chart
			myrdhelper.SelectListItem("ContactInfo.BirthChart", "Yes");
			
			//Select Country
			myrdhelper.SelectListItem("ContactInfo.ContactCountryOfRes","India");
			
			//Enter contact's email address
			myrdhelper.FillinData("ContactInfo.ContactEmailAdd",lastname+"@yopmail.com");
			
			//Fill in contact's phone number
			myrdhelper.EnterContactPhone("8860544110");
			
			//Enter departedTitle
			myrdhelper.FillinData("ContactDepartedInfo.ContactDepartedTitle", "Mr.");
			
		    //Enter departed First Name
			myrdhelper.FillinData("ContactDepartedInfo.ContactDepartedFName", "Aman");
			
			//Enter departed Last name
			myrdhelper.FillinData("ContactDepartedInfo.ContactDepartedLName", lastname2);
			
			//Select departed Birth Date
			myrdhelper.ContactBDayDetails("ContactDepartedInfo.ContactDepartedBDay", "1");
			myrdhelper.ContactBDayDetails("ContactDepartedInfo.ContactDepartedBMonth", "July");
			myrdhelper.FillinData("ContactDepartedInfo.ContactDepartedByear", "1988");
			
			//Select Contact birth chart
			myrdhelper.SelectListItem("ContactDepartedInfo.BirthChart", "Yes");
			
			//Select departed country of residence
			myrdhelper.SelectListItem("ContactDepartedInfo.CountryOfRes", "India");;
			
			//select DoYouAgree
			myrdhelper.SelectListItem("DoYouAgree", "Yes, I agree to the conditions");
			
			//Click Submit button to move on step 2
			myrdhelper.ClickItem("SubmitForm");
			myrdhelper.waitForWorkAroundTime(3000);
			
			//Click on Update button
			myrdhelper.ClickItem("Update");
			myrdhelper.waitForWorkAroundTime(5000);
			
			//Now got to SFDC
			sfdchelper.LoginIntoSFDC(sfdc_url, username, password);
			
			//Wait For Home page load
			sfdchelper.waitForWorkAroundTime(6000);
			
			//Select iFrame on with classic theme
			sfdchelper.SelectiFrame("MJYUnbilledApplications");
			
			//Click on Newly Added Account name
			sfdchelper.clickOn("link=Aman " +lastname2+" (D)");
			
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
