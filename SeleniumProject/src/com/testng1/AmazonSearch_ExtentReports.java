package com.testng1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

//@Listeners(com.testng1.ITestListener_Listener.class)
public class AmazonSearch_ExtentReports {
  
	static WebDriver driver;
	String prod = "iphone";
	String cat = "Electronics";
	String sURL = "https://www.amazon.in/";
	ExtentReports logger;	
	

  @Test(priority=1)
  public void browserproperty() {
	  
	  logger.startTest("browserproperties", "Modifying browser properties");
	  driver.manage().window().maximize();
	  logger.log(LogStatus.INFO, "Browser window maximized");
	  driver.manage().deleteAllCookies();
	  logger.log(LogStatus.INFO, "deleted all cookies");
	  logger.endTest();
  }
  @Test(priority=2)
  public void navigateURL() {
	 
	  logger.startTest("navigateURL", "Navigating to requested URL");
	  	driver.get(sURL);
	  logger.log(LogStatus.INFO, "launched Amazon site's homepage using the URL: "+sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  logger.endTest();
  }
  
  @Test(priority=3)
  public void getPageInfo() throws Throwable {
	  
	  logger.startTest("PageInfo");
	  	System.out.println("current URL of the page is: "+driver.getCurrentUrl());
	    System.out.println("current title of the page is: "+driver.getTitle());
	    String title = driver.getTitle();
	    logger.log(LogStatus.INFO, "Page title is: "+title);
	    System.out.println("Page title is being validated");
	    if(title.equals("Amazon"))
	    { logger.log(LogStatus.PASS, "you have landed in correct page");
	    }
	    else {
	    	logger.log(LogStatus.FAIL, "you have landed in an incorrect page");
	    	getScreenshot("TitleFailed");
	    	Thread.sleep(3000);
	    	logger.attachScreenshot("D:\\Selenium\\Screenshots\\TitleFailed.png", "Title validation failed");
	    }
	    
	    logger.endTest();
  }
  
  /*@DataProvider(name="amazonsearch")
  public static Object[][] searchvalues(){
	  
	  Object[][] obj = new Object[][] {{"iphone","Electronics"},{"table","Furniture"},{"bullet","Car & Motorbike"}};
	  return obj;
  }*/
  
  @Parameters({"Product","Category"})
  @Test(priority=4)
  
  public void amazonsearch(@Optional("iphone")String prod,@Optional("Electronics")String cat) throws Throwable {
	  
	  logger.startTest("AmazonSearch");
		WebElement odrop, osearch, obtn;
		Thread.sleep(2000);
		odrop = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select oselect = new Select(odrop);
		oselect.selectByVisibleText(cat);
		
		osearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		osearch.clear();
		Thread.sleep(2000);
		osearch.sendKeys(prod);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		obtn = driver.findElement(By.xpath("//input[@type='submit' and @value='Go']"));
		obtn.click();
		logger.log(LogStatus.INFO, "Selected search product is :"+prod+" and selected category is :"+cat);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		logger.endTest();
		Thread.sleep(6000);
		//results();
  }
  
  @Test(priority=5)
  public void results() throws Throwable {
	  
	  logger.startTest("Product Result fetching");
	    Thread.sleep(3000);
		WebElement ores, oelement;
		ores = driver.findElement(By.xpath("//span[contains(text(),'result')]"));
		String result = ores.getText();
		//System.out.println("result is: "+result);
		String a[] = result.split(" ");
		String b[] = a[0].split("-");
		logger.log(LogStatus.INFO, "There are totally "+b[1]+" results for your search in the current page");
		getScreenshot("result_snap");
		Thread.sleep(3000);
		logger.attachScreenshot("D:\\Selenium\\Screenshots\\result_snap.png", "snapshot of the results for reference");
		int fresult = Integer.parseInt(b[1]);
		//Assert.assertEquals(fresult, 100);
				
		if(fresult > 0)
		 {
			 System.out.println("Results found");
			 List<WebElement> olist = driver.findElements(By.xpath("(//ul[@class='s-result-list s-col-3 s-result-list-hgrid s-height-equalized s-grid-view s-text-condensed'])[1]/li"));
			 
			 logger.log(LogStatus.INFO, "Number of exact webelement search results in the current page is : "+olist.size());
			 
			 for(int i=0;i<olist.size();i++)
			 {
				 oelement = olist.get(i);
				 System.out.println(oelement.findElement(By.xpath(".//a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']")).getText());
				 logger.log(LogStatus.INFO, oelement.findElement(By.xpath(".//a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']")).getText());
				 int x = oelement.getLocation().x;
				 int y = oelement.getLocation().y;
				 scrolltomethod(x,y);
				 
			 }
			 
			 scrolltomethod(0,0);
			 logger.log(LogStatus.PASS, "Amazon results fetching is passed");
			 Thread.sleep(5000);
		 }
		
		else
		{
			System.out.println("no results found");
		}
		
		logger.endTest();
	 }
  
  public void scrolltomethod(int x, int y) {
	  String cmd;
	  JavascriptExecutor oexe = (JavascriptExecutor) driver;
	  cmd = String.format("window.scrollTo(%d,%d)", x,y);
	  oexe.executeScript(cmd);
	  
  }
  
  public static void getScreenshot(String sname) throws Throwable {
	  
	  TakesScreenshot sshot = (TakesScreenshot)driver;
	  File sfile = sshot.getScreenshotAs(OutputType.FILE);
	  File dfile = new File("D:\\Selenium\\Screenshots\\"+sname+".png");
	  FileUtils.copyFile(sfile, dfile);
	  
	  /*File sfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(sfile, new File("D:\\Selenium\\Screenshots\\"+sname+".png");*/
  }
  @BeforeClass
public void browserInvoke() {
	  
	  logger = new ExtentReports();
	  logger.init("D:\\Selenium\\Reports\\Amazon_Search.html", true);
	  logger.startTest("BrowserInvoke", "User invokes the browser now");
	  System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		
	  logger.log(LogStatus.INFO, "Chrome browser has been invoked by the user");
	  logger.endTest();
					  
  }

  @AfterClass
  public void closebrowser() {
	  
	  driver.close();
  }


}
