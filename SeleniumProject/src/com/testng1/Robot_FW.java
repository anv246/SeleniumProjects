package com.testng1;

//import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Robot_FW {
	
	static WebDriver driver;
	static String sURL = "https://www.google.com";
	
  @Test(priority=1)
  public void BrowserInvoke() throws Throwable {
	  
	  System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(sURL);
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//a[text()='Images']")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='S3Wjs']|//span[@id='qbi']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Upload an image']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='qbfile']")).click();
		Thread.sleep(5000);

	 }
  
  @Test(priority=2)
  public void robotactions() throws Throwable {
		Robot orobot = new Robot();
		
		orobot.keyPress(KeyEvent.VK_D);
		orobot.keyRelease(KeyEvent.VK_D);
		Thread.sleep(2000);
		orobot.keyPress(KeyEvent.VK_SHIFT);
		orobot.keyPress(KeyEvent.VK_SEMICOLON);
		orobot.keyRelease(KeyEvent.VK_SEMICOLON);
		orobot.keyRelease(KeyEvent.VK_SHIFT);
		Thread.sleep(2000);
		orobot.keyPress(KeyEvent.VK_BACK_SLASH);
		orobot.keyRelease(KeyEvent.VK_BACK_SLASH);
		Thread.sleep(2000);
		orobot.keyPress(KeyEvent.VK_SHIFT);
		orobot.keyPress(KeyEvent.VK_P);
		orobot.keyRelease(KeyEvent.VK_P);
		orobot.keyRelease(KeyEvent.VK_SHIFT);
		orobot.keyPress(KeyEvent.VK_I);
		orobot.keyRelease(KeyEvent.VK_I);
		orobot.keyPress(KeyEvent.VK_C);
		orobot.keyRelease(KeyEvent.VK_C);
		Thread.sleep(2000);
		orobot.keyPress(KeyEvent.VK_DOWN);
		orobot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		orobot.keyPress(KeyEvent.VK_ENTER);
		orobot.keyRelease(KeyEvent.VK_ENTER);
  }
}
