package com.day03;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricBuzz {
	
	static WebDriver driver;
	
	public static void main (String args[])
	{
		cricbuz();
		
	}

	public static void cricbuz()
	{
		WebElement orank;
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		orank = driver.findElement(By.xpath("(//a[@class='text-white'])[5]"));
		orank.click();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		
		test();
	}
	
	
	public static void test()
	{
		WebElement otest, otable, orow, ocol;
		
		otest = driver.findElement(By.xpath("//a[@id='batsmen-tests-tab']"));
		otest.click();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		
		
	}
}
