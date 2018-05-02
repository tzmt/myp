package com.mya.util;

import java.io.File;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mya.pagehelper.ACBTApplicationHelper;
import com.mya.pagehelper.ADCBCApplicationHelper;
import com.mya.pagehelper.CBCApplicationHelper;
import com.mya.pagehelper.MYPApplicationHelper;
import com.mya.pagehelper.SFDCHelper;
import com.mya.pagehelper.SignupHelper;

public abstract class DriverTestCase 
{

	enum DriverType 
	{ Firefox, IE, Chrome }

	//Define objects
	private WebDriver driver;
	protected MYPApplicationHelper myphelpers;
	protected CBCApplicationHelper cbchelpers;
	protected SFDCHelper sfdchelper;
	protected ADCBCApplicationHelper adcbchelper;
	protected ACBTApplicationHelper acbthelper;


	//Initialize objects
	protected PropertyReader propertyReader = new PropertyReader();

	//Define variables
	protected String MYP_app_url = propertyReader.readApplicationFile("URL");
	protected String CBC_app_url = propertyReader.readApplicationFile("CBC_URL");
	protected String ADCBC_app_url = propertyReader.readApplicationFile("ADCBC_URL");
	protected String ACBT_app_url = propertyReader.readApplicationFile("ACBT_URL");
	protected String sfdc_url = propertyReader.readApplicationFile("SFDC_Testing_URL");
	protected String username = propertyReader.readApplicationFile("username");
	protected String password = propertyReader.readApplicationFile("pswd");

	@BeforeSuite
	public void setUp() 
	{  
		String driverType = propertyReader.readApplicationFile("BROWSER");  

		if (DriverType.Firefox.toString().equals(driverType)) 
		{ 
			driver = new FirefoxDriver();   
		}   

		else if (DriverType.IE.toString().equals(driverType)) 
		{ 
			String path1 = getPath();
			File file = new File(path1+"//IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);   
			driver = new InternetExplorerDriver(capabilities); 
			//driver = new InternetExplorerDriver();
		}
		else if (DriverType.Chrome.toString().equals(driverType)) 
		{ 
			String path1 = getPath();
			String chromeDriverPath= path1+"\\chromedriver.exe";

			//Set the required properties to instantiate Chrome driver. Place any latest Chromedriver.exe files under Drivers folder
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");

			driver = new ChromeDriver(options); } 
		else 
		{ driver = new ChromeDriver(); }   

		//Maximize window
		driver.manage().window().maximize();

		//Delete cookies
		driver.manage().deleteAllCookies();   

	} 

	@AfterSuite
	public void afterMainMethod() 
	{  
		//driver.quit();
	}

	public WebDriver getWebDriver()
	{
		return driver;
	}


	//Get random integer
	public int getRandomInteger(int aStart, int aEnd){
		Random aRandom = new  Random();
		if ( aStart > aEnd ) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		//get the range, casting to long to avoid overflow problems
		long range = (long)aEnd - (long)aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long)(range * aRandom.nextDouble());
		int randomNumber =  (int)(fraction + aStart);    
		return randomNumber;
	}



	//Get absolute path
	public String getPath()
	{
		String path ="";		
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");		
		return path;
	}





}



