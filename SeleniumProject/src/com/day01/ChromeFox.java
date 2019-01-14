package com.day01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeFox {
	
	public static void main (String args[])
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		WebDriver driver1 = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver1.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver1.manage().deleteAllCookies();
		
		driver.get("https://www.google.com");
		driver1.get("https://www.facebook.com");
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver1.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		System.out.println("page title in chrome is: "+driver.getTitle());
		System.out.println("page title in firefox is: "+driver1.getTitle());
		
		System.out.println("page url in chrome is: "+driver.getCurrentUrl());
		System.out.println("page url in firefox is: "+driver1.getCurrentUrl());
		
		driver.close();
		driver1.close();
		
	}

}
