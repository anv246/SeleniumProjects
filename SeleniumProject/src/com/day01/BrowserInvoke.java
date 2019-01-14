package com.day01;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInvoke {
	
	public static String URL = "https://www.google.com";
	public static int btype;
	public static WebDriver driver;
	
	

	public static void main (String args[])
	{
		
		Scanner uinput = new Scanner(System.in);
		System.out.println("Enter the browser number to open (1-chrome; 2-firefox; 3-edge) and hit enter: ");
		btype = uinput.nextInt();
		uinput.close();
				
	//	System.out.println(btype);
		
		invokebrowser();
		browsersettings();
		navigateURL();
		browserinfo();
		closebrowser();
		
	}
	
	public static void invokebrowser()
	{
		 
		switch(btype)
		{
		case 1:
			System.out.println("you have selected "+btype+" as browser type. Hence, invoking chrome browser");
			System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case 2:
			System.out.println("you have selected "+btype+" as browser type. Hence, invoking firefox browser");
			System.setProperty("webdriver.gecko.driver", "./browserdrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		default:
		
			System.out.println("you have not selected any value. hence, openeing deffault browser chrome");
			System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
			
		
	}
	
	public static void browsersettings()
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
	public static void navigateURL()
	{
		//driver.get(URL);
		driver.navigate().to(URL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().refresh();
		
	}
	
	public static void browserinfo()
	{
		System.out.println("title of the browser is: "+driver.getTitle());
		System.out.println("current url of the browser is: "+driver.getCurrentUrl());
	}
	
	public static void closebrowser()
	{
		driver.close();
	}
}
