package com.mya.scripts;


import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.util.DriverTestCase;
import com.mya.util.ExecutionLog;

public class SubmitCBCApplicationWithBlankFields extends DriverTestCase
{	
	@Test
	public void testCBCApplicationWithBlankFields() throws Exception
	{			
		//Initialize objects
		cbchelpers = new CBCApplicationHelper(getWebDriver());
		sfdchelper = new SFDCHelper(getWebDriver());
		adcbchelper = new ADCBCApplicationHelper(getWebDriver());

		//variables
		//String lastname = "Khan" +getRandomInteger(1, 9999);

		ExecutionLog.LogAddClass(this.getClass().getName() + " and Test method " +Thread.currentThread().getStackTrace()[1].getMethodName());
		try
		{
			//Open application
			System.out.println("Testing Application URL:");
			getWebDriver().navigate().to(CBC_app_url);
			
			//Select Applicant type
			cbchelpers.SelectApplicant("Myself");
			
			//Click Submit button to move on step 2
			cbchelpers.ClickItem("SubmitAndProceedToStep2");
			
			//Wait for step 2 page to load 
			cbchelpers.waitForWorkAroundTime(3000);
			
			//Verify validation message pop up
			cbchelpers.VerifyValidationMessage("Your application has not yet been saved because some corrections are needed.\n"+"Please look below for a note in red text under any field that needs attention.");
			
			//Close validation message pop up
			cbchelpers.ClickItem("OK");
			cbchelpers.waitForWorkAroundTime(2000);
			
			//Verify field validation message
			cbchelpers.VerifyFieldValidation("Error: You must enter a value.");
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
