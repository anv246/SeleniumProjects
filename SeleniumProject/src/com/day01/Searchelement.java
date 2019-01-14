package com.day01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Searchelement {
	
	public static String surl = "http://www.newtours.demoaut.com/";

	public static void main(String args[]) {
		
		chromeinvoke();
		
	}
	
		public static void chromeinvoke()
	{
		//String odrop;
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(surl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Vijay");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("raghavan");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("anvraghav@gmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("nanaganallur");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("chennai");
		WebElement odrop;
		odrop = driver.findElement(By.xpath("//select[@name='country']"));
		Select oselect = new Select(odrop);
		oselect.selectByVisibleText("INDIA");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("vuser");
		driver.findElement(By.xpath("//input[@name='register']")).submit();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
}
