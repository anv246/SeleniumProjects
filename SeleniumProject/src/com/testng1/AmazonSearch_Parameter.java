package com.testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AmazonSearch_Parameter {
	
	static WebDriver driver;
	String sURL = "https://www.amazon.in/";
	
  @Test(priority=1)
  public void getURLdetails() {
	 
	    System.out.println("current URL of the page is: "+driver.getCurrentUrl());
	    System.out.println("current title of the page is: "+driver.getTitle());
	    String title = driver.getTitle();
	    System.out.println("page title is being validated");
	    Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	    System.out.println("title validation successful");
  }
  @Parameters({"Product","Category"})
  @Test(priority=2)
  
  public void amazonsearch(@Optional("iphone")String prod,@Optional("Electronics")String cat) {
	  
		WebElement odrop, osearch, obtn;
		
		odrop = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		
		Select oselect = new Select(odrop);
		oselect.selectByVisibleText(cat);
		
		osearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		osearch.sendKeys(prod);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		obtn = driver.findElement(By.xpath("//input[@type='submit' and @value='Go']"));
		obtn.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }
  
  @Test(priority=3)
  public void results() throws Throwable {
	  
	    Thread.sleep(5000);
		WebElement ores, oelement;
		ores = driver.findElement(By.xpath("//span[contains(text(),'result')]"));
		String result = ores.getText();
		//System.out.println("result is: "+result);
		String a[] = result.split(" ");
		String b[] = a[0].split("-");
		System.out.println("There are totally "+b[1]+" results for your search in the current page");
		
		int fresult = Integer.parseInt(b[1]);
		
		if(fresult > 0)
		 {
			 System.out.println("Results found");
			 List<WebElement> olist = driver.findElements(By.xpath("(//ul[@class='s-result-list s-col-3 s-result-list-hgrid s-height-equalized s-grid-view s-text-condensed'])[1]/li"));
			 
			 System.out.println("search result in the current page is : "+olist.size());
			 
			 for(int i=0;i<olist.size();i++)
			 {
				 oelement = olist.get(i);
				 System.out.println(oelement.findElement(By.xpath(".//a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']")).getText());
				 int x = oelement.getLocation().x;
				 int y = oelement.getLocation().y;
				 scrolltomethod(x,y);
				 
			 }
			 
			 scrolltomethod(0,0);
			 Thread.sleep(5000);
		 }
		
		else
		{
			System.out.println("no results found");
		}
	  
  }
  
  public void scrolltomethod(int x, int y) {
	  String cmd;
	  JavascriptExecutor oexe = (JavascriptExecutor) driver;
	  cmd = String.format("window.scrollTo(%d,%d)", x,y);
	  oexe.executeScript(cmd);
	  
  }
  @BeforeClass
public void browseURL() {
	  
	  System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			  
  }

  @AfterClass
  public void closebrowser() {
	  
	  driver.close();
  }

}
