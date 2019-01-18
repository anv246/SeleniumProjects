package com.POMtestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class SeleniumHQ_Child2 extends GoogleSearch_Child1 {
	
	public void setDriver() {
		driver = getDriver();
	}
	
  @Test(priority=3)
  public void seleniumpage() {
	  
	  logger.startTest("SeleniumHQpage testing");
	  driver.findElement(By.linkText("Projects")).click();
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  logger.log(LogStatus.INFO, "Clicked on Projects");
	  Assert.assertTrue(true);
	  
  }
}
