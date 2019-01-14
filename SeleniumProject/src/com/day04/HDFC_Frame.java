package com.day04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HDFC_Frame {

	static WebDriver driver;
	static String sURL = "https://netbanking.hdfcbank.com/netbanking/";
	static String custid = "54439139";
	
	public static void main(String[] args) throws Throwable {

		launchhdfc();
		hdfcframes();

	}

	public static void launchhdfc() {
		
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	 static void hdfcframes() throws Throwable {
		
		driver.switchTo().frame("login_page");
		driver.findElement(By.name("fldLoginUserId")).sendKeys(custid);
		driver.findElement(By.xpath("//img[@alt='continue']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("footer");
		driver.findElement(By.linkText("Terms and Conditions")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'GENERAL')]")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
	}
}
