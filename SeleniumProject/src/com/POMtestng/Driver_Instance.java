package com.POMtestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Driver_Instance {
	
	public WebDriver driver;
	public ExtentReports logger;
	
  @BeforeTest
  public void BrowserInvoke() throws Throwable {
	  logger = new ExtentReports();
	  logger.init("D:\\Selenium\\Reports\\driver_Instance.html", true);
	  logger.startTest("BrowserInvoke");
	  logger.log(LogStatus.INFO, "Invoking chrome browser driver from driver_instance class");
	  System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  logger.log(LogStatus.PASS, "Chrome Browser successfully launched");
	  logger.endTest();
	 	  	  
  } 
  
  @AfterMethod
  public void gettestresult(ITestResult result) {
	  
	  if(result.getStatus() == ITestResult.SUCCESS)
	  {
		  logger.log(LogStatus.PASS, "Test case "+result.getName()+" passed");
		  
	  }
	  else {
		  logger.log(LogStatus.FAIL, "Test case "+result.getName()+"failed due to: "+result.getThrowable());
	  }
	  logger.endTest();
  }
  
  @AfterTest
  public void closeBrowser() {
	  driver.close();
  }
}
