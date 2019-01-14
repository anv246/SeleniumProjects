package com.day01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokeFireFox {

	public static void main (String args[])
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		System.out.println("title of the page is: "+driver.getTitle());
		System.out.println("current url of the page is: "+driver.getCurrentUrl());
		//System.out.println("page source is :"+driver.getPageSource());
		driver.close();
		
	}
}
