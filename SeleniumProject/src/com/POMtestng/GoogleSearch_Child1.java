package com.POMtestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class GoogleSearch_Child1 extends Driver_Instance {
	
  @Test(priority=1)
  public void navigateURL() {
	  
	  logger.startTest("Navigate URL", "Navigating to google.com");
	  driver.get("https://www.google.com");
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  logger.log(LogStatus.INFO, "Maximizing the browser window");
	  driver.manage().window().maximize();
	  Assert.assertTrue(true);
  }
  
  @Test(priority=2)
  public void seleniumhq() {
	  
	  WebElement otext, osearch;
	  logger.startTest("seleniumhq search");
	  otext = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
	  otext.sendKeys("selenium hq");
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  osearch = driver.findElement(By.name("btnK"));
	  if (osearch.isDisplayed()) {
		  osearch.click();}
	  else
	  {
		  osearch.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();
	  
	  }
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[text()='Selenium - Web Browser Automation']")).click();
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  Assert.assertTrue(true);
	  
  }
  
  public WebDriver getDriver() {
	  return driver;
	  
  }
}
