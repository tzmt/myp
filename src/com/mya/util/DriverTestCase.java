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
import com.mya.pagehelper.COMApplicationHelper;
import com.mya.pagehelper.DONApplicationHelper;
import com.mya.pagehelper.MJCApplicationHelper;
import com.mya.pagehelper.MUHApplicationHelper;
import com.mya.pagehelper.MYPApplicationHelper;
import com.mya.pagehelper.MYRCApplicationHelper;
import com.mya.pagehelper.MYRDApplicationHelper;
import com.mya.pagehelper.NAMApplicationHelper;
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
	protected MUHApplicationHelper muhhelper;
	protected NAMApplicationHelper namhelper;
	protected COMApplicationHelper comhelper;
	protected DONApplicationHelper donhelper;
	protected MJCApplicationHelper mjchelper;
	protected MYRCApplicationHelper myrchelper;
	protected MYRDApplicationHelper myrdhelper;

	//Initialize objects
	protected PropertyReader propertyReader = new PropertyReader();

	//Define variables
	protected String MYP_app_url = propertyReader.readApplicationFile("URL");
	protected String MYP_app_url_cmp= propertyReader.readApplicationFile("MYP_URL_CMP");
	protected String MYP_app_url_Indvaccnt= propertyReader.readApplicationFile("MYP_URL_Indvaccnt");
	protected String MYP_app_url_Orgaccnt= propertyReader.readApplicationFile("MYP_URL_Orgaccnt");
	protected String MYAD_app_url = propertyReader.readApplicationFile("MYAD_URL");
	protected String CBC_app_url = propertyReader.readApplicationFile("CBC_URL");
	protected String CBC_app_url_Indvaccnt = propertyReader.readApplicationFile("CBC_URL_Indvaccnt");
	protected String CBC_app_url_Orgaccnt = propertyReader.readApplicationFile("CBC_URL_Orgaccnt");
	protected String CBC_app_url_CMP = propertyReader.readApplicationFile("CBC_URL_CMP");
	protected String CBC_app_url_CMPOverride = propertyReader.readApplicationFile("CBC_URL_Cmpoverride");
	protected String CBC_app_url_Indvaccntoverride=propertyReader.readApplicationFile("CBC_URL_Indvaccntoverride");
	protected String CBC_app_url_Orgaccntoverride=propertyReader.readApplicationFile("CBC_URL_Orgaccntoverride");
	protected String CBC_app_url_PMTHAndOverride=propertyReader.readApplicationFile("CBC_URL_PMTHAndOverride");
	protected String CBC_app_url_PMTH = propertyReader.readApplicationFile("CBC_URL_PMTH");
	protected String CBC_app_url_Override = propertyReader.readApplicationFile("CBC_URL_Override");
	protected String CBC_app_url_Upgrade = propertyReader.readApplicationFile("CBC_URL_Upgrade");
	protected String CBC_app_url_DepartedC= propertyReader.readApplicationFile("CBC_URL_DepartedC");
	protected String ADCBC_app_url_Orgaccnt = propertyReader.readApplicationFile("ADCBC_URL_Orgaccnt");
	protected String ADCBC_app_url_Indvaccnt = propertyReader.readApplicationFile("ADCBC_URL_Individualaccnt");
	protected String ADCBC_app_url = propertyReader.readApplicationFile("ADCBC_URL");
	protected String ADCBC_app_url_cmp = propertyReader.readApplicationFile("ADCBC_URL_CMP");
	protected String ADCBC_app_url_override = propertyReader.readApplicationFile("ADCBC_URL_Override");
	protected String ADCBC_app_url_pmth = propertyReader.readApplicationFile("ADCBC_URL_PMTH");
	protected String ACBT_app_url = propertyReader.readApplicationFile("ACBT_URL");
	protected String ACBT_app_url_CMP = propertyReader.readApplicationFile("ACBT_URL_CMP");
	protected String ACBT_app_url_Override = propertyReader.readApplicationFile("ACBT_URL_Override");
	protected String ACBT_app_url_Indvaccnt = propertyReader.readApplicationFile("ACBT_URL_Individualaccnt");
	protected String ACBT_app_url_PMTH = propertyReader.readApplicationFile("ACBT_URL_PMTH");
	protected String MUH_app_url = propertyReader.readApplicationFile("MUH_URL");
	protected String MUH_app_url_CMP = propertyReader.readApplicationFile("MUH_URL_CMP");
	protected String MUH_app_url_Override = propertyReader.readApplicationFile("MUH_URL_Override");
	protected String MUH_app_url_PMTH = propertyReader.readApplicationFile("MUH_URL_PMTH");
	protected String MUH_app_url_Indvaccnt = propertyReader.readApplicationFile("MUH_URL_Individualaccnt");
	protected String MUH_app_url_Orgaccnt = propertyReader.readApplicationFile("MUH_URL_Orgaccnt");
	protected String NAM_app_url= propertyReader.readApplicationFile("NAM_URL");
	protected String NAM_app_url_CMP=propertyReader.readApplicationFile("NAM_URL_CMP");
	protected String NAM_app_url_Override=propertyReader.readApplicationFile("NAM_URL_Override");
	protected String NAM_app_url_PMTH=propertyReader.readApplicationFile("NAM_URL_PMTH");
	protected String NAM_app_url_Childaccnt=propertyReader.readApplicationFile("NAM_URL_Childaccnt");
	protected String COM_app_url=propertyReader.readApplicationFile("COM_URL");
	protected String COM_app_url_CMP=propertyReader.readApplicationFile("COM_URL_CMP");
	protected String COM_app_url_Override=propertyReader.readApplicationFile("COM_URL_Override");
	protected String COM_app_url_PMTH=propertyReader.readApplicationFile("COM_URL_PMTH");
	protected String COM_app_url_Indvaccnt=propertyReader.readApplicationFile("COM_URL_Indvaccnt");
	protected String COM_app_url_Orgaccnt=propertyReader.readApplicationFile("COM_URL_Orgaccnt");
	protected String DON_app_url=propertyReader.readApplicationFile("DON_URL");
	protected String DON_app_url_CMP=propertyReader.readApplicationFile("DON_URL_CMP");
	protected String DON_app_url_PMTH=propertyReader.readApplicationFile("DON_URL_PMTH");
	protected String DON_app_url_Override=propertyReader.readApplicationFile("DON_URL_Override");
	protected String DON_app_url_Indvaccnt=propertyReader.readApplicationFile("DON_URL_Indvaccnt");
	protected String DON_app_url_Orgaccnt=propertyReader.readApplicationFile("DON_URL_Orgaccnt");
	protected String MJC_app_url=propertyReader.readApplicationFile("MJC_URL");
	protected String MJC_app_url_Indvaccnt=propertyReader.readApplicationFile("MJC_URL_Indvaccnt");
	protected String MJC_app_url_Orgaccnt=propertyReader.readApplicationFile("MJC_URL_Orgaccnt");
	protected String MJC_app_url_CMP=propertyReader.readApplicationFile("MJC_URL_CMP");
	protected String MJC_app_url_PMTH=propertyReader.readApplicationFile("MJC_URL_PMTH");
	protected String MJC_app_url_Override=propertyReader.readApplicationFile("MJC_URL_Override");
	protected String MYRC_app_url=propertyReader.readApplicationFile("MYRC_URL");
	protected String MYRC_app_url_Indvaccnt=propertyReader.readApplicationFile("MYRC_URL_Indvaccnt");
	protected String MYRC_app_url_Orgaccnt=propertyReader.readApplicationFile("MYRC_URL_Orgaccnt");
	protected String MYRC_app_url_CMP=propertyReader.readApplicationFile("MYRC_URL_CMP");
	protected String MYRC_app_url_Override=propertyReader.readApplicationFile("MYRC_URL_Override");
	protected String MYRC_app_url_PMTH=propertyReader.readApplicationFile("MYRC_URL_PMTH");
	protected String MYRD_app_url=propertyReader.readApplicationFile("MYRD_URL");
	protected String MYRD_app_url_Indvaccnt=propertyReader.readApplicationFile("MYRD_URL_Indvaccnt");
	protected String MYRD_app_url_Override=propertyReader.readApplicationFile("MYRD_URL_Override");
	protected String MYRD_app_url_PMTH=propertyReader.readApplicationFile("MYRD_URL_PMTH");
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
		driver.quit();
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



