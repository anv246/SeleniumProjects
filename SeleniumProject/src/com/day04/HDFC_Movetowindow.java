package com.day04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HDFC_Movetowindow {
	
	static WebDriver driver;

	public static void main(String[] args) throws Throwable {

		browserlaunch();
		hdfcmovetowindow();

	}

	
public static void browserlaunch() {
		
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
				
	}

public static void hdfcmovetowindow() throws Throwable {
	
	WebElement pension, mutual;
	WebDriverWait owait = new WebDriverWait(driver, 20);
	pension = driver.findElement(By.xpath("//a[text()='HDFC Pension']"));
	owait.until(ExpectedConditions.elementToBeClickable(pension));
	System.out.println("current windows tab name: "+driver.getWindowHandle());
	System.out.println("total no of tabs before clicking hdfc pension: "+driver.getWindowHandles().size());
	pension.click();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	System.out.println("total no of tabls after clicking hdfc pension: "+driver.getWindowHandles().size());
	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
	Thread.sleep(2000);
	mutual = driver.findElement(By.xpath("//a[text()='HDFC Mutual Fund']"));
	mutual.click();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	System.out.println("total no of tabs after clicking hdfc mutual fund: "+driver.getWindowHandles().size());
	driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
	System.out.println("name of this current window/tab: "+driver.getWindowHandle());
	//System.out.println(driver.getWindowHandles());
	Thread.sleep(3000);
	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	driver.close();
	System.out.println("total no of tabs after closing hhometab: "+driver.getWindowHandles().size());
	Thread.sleep(3000);
	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
	driver.close();
	
}
}
