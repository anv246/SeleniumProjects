package com.day04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames_Ex {

	static WebDriver driver;
	static String sURL = "https://seleniumhq.github.io/selenium/docs/api/java/index.html";
	
	public static void main (String args[]) throws Throwable {
		
		seleniumwebsite();
		frames();
		
	}


public static void seleniumwebsite()
{
	
	System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(sURL);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
}

	public static void frames() throws Throwable {
		
		WebElement oframe;
		
		oframe = driver.findElement(By.name("packageListFrame"));
		driver.switchTo().frame(oframe);
		driver.findElement(By.linkText("com.thoughtworks.selenium.webdriven")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("CompoundMutator")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("ScriptMutator")).click();;
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	
		
	}


}