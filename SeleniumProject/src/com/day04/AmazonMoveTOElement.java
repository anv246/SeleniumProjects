package com.day04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonMoveTOElement {
	
	static WebDriver driver;
	static String sURL = "https://www.amazon.in/";

	public static void main(String[] args) throws Throwable {

		amazonmovetoelement();

	}

	public static void amazonmovetoelement() throws Throwable   {
		
		WebElement cat, subcat, item;
		
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		
		cat = driver.findElement(By.xpath("(//span[@class='nav-icon nav-arrow'])[5]"));
		subcat = driver.findElement(By.xpath("//span[@aria-label='Mobiles, Computers']"));
		item = driver.findElement(By.xpath("//span[text()='Power Banks']"));
		
		Actions oaction = new Actions(driver);
		Thread.sleep(5000);
		oaction.moveToElement(cat).pause(6).moveToElement(subcat).pause(6).build().perform();
		Thread.sleep(2000);
		oaction.moveToElement(item).click().build().perform();
	
		//oaction.moveToElement(subcat).pause(5).build().perform();
		
		
	}
}
