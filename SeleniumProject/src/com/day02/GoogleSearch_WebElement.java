package com.day02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch_WebElement {

	public static void googlechrome(String s)
	{
		
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		WebElement otxt, obtn, olink;
				
		otxt = driver.findElement(By.xpath("//input[@title='Search']"));
		otxt.clear();
		otxt.sendKeys(s);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		obtn = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		obtn.click();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		olink = driver.findElement(By.xpath("//h3[text()='Standard Chartered Online Banking']"));
		olink.click();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				
		
	}
	
	
	public static void main(String[] args) {
		
		googlechrome("scb internet banking india");

	}

}
