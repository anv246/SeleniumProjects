package com.day04;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Point_Dim_mouseaction {
	
	static WebDriver driver;
	

	public static void main(String[] args) throws Throwable {

		browserlaunch();
		mouse_actions();
		
	}

	public static void browserlaunch() {
		
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
				
	}
	public static void mouse_actions() throws Throwable {
		
		WebElement source, target;
		
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		source = driver.findElement(By.id("draggable"));
		target = driver.findElement(By.id("droppable"));
		Actions oaction = new Actions(driver);
		//oaction.dragAndDrop(source, target).build().perform();;
		//oaction.clickAndHold(source).moveToElement(target).release().build().perform();
		
		Thread.sleep(2000);
		Point opoint = target.getLocation();
		int x = opoint.x;
		int y = opoint.y;
		
		System.out.println("x coordinate is: "+x+" and y-coordinate is: "+y);
		oaction.clickAndHold(source).moveByOffset(x, y).release().build().perform();
		
		Dimension odim = target.getSize();
		System.out.println("height of target element is: "+odim.height+" and width of target element is: "+odim.width);
		
	}
}
