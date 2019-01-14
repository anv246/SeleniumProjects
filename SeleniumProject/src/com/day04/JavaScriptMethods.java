package com.day04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptMethods {
	
	static WebDriver driver;
	//String sURL = "http://newtours.demoaut.com/";
	static String propfile = "./Data/datadriven_property.properties";

	public static void main (String args[]) throws Throwable {
		browserinvoke();
		javascriptmethods();
		closebrowser();
	}
	
	public static void browserinvoke() {
		
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public static void javascriptmethods() throws Throwable {
		
		try {
			
			FileInputStream ofile = new FileInputStream(propfile);
			Properties oprop = new Properties();
			
			oprop.load(ofile);
			//String sURL = oprop.getProperty("URL");
			driver.navigate().to(oprop.getProperty("URL"));
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		JavascriptExecutor oexe = (JavascriptExecutor)driver;
		WebElement oreg, fname, city, submit;
		System.out.println(oexe.executeScript("return document.title;"));
		System.out.println("URL of the landed page is: "+oexe.executeScript("return document.URL;"));
		oreg = driver.findElement(By.linkText("REGISTER"));
		oexe.executeScript("arguments[0].click();", oreg);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		fname = driver.findElement(By.name("firstName"));
		oexe.executeScript("arguments[0].value='Vijay';", fname);
		
		city = driver.findElement(By.name("city"));
		
		oexe.executeScript("arguments[0].value='Chennai';", city);
		
		submit = driver.findElement(By.name("register"));
		int x = submit.getLocation().x;
		int y = submit.getLocation().y;
		Thread.sleep(2000);
		String cmd = String.format("window.scrollTo(%d,%d)",x,y);
		oexe.executeScript(cmd);
		oexe.executeScript("arguments[0].click();",submit);
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public static void closebrowser() throws Throwable {
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		System.out.println(driver.getWindowHandle());
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.close();
	}
}
