package com.day03;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Newtours {

	static WebDriver driver;
	public static void main(String[] args) {
		printcountries();
		//countindia();
		getoption();
		
	}

	public static void printcountries() {
		WebElement odropdown;
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.newtours.demoaut.com/mercuryregister.php");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		odropdown = driver.findElement(By.xpath("//select[@name='country']"));
		List<WebElement> ocountry = odropdown.findElements(By.tagName("option"));
		System.out.println("Total number of countries in the dropdown is: "+ocountry.size());
		System.out.println("Printing all the countries in the dropdown");
		System.out.println("***************************************************************************");
	
		for(int i=0;i<ocountry.size();i++) {
			System.out.println(ocountry.get(i).getText());
		}
	}
	
	public static void countindia() {
		
		WebElement odropdown;
		
		odropdown = driver.findElement(By.xpath("//select[@name='country']"));
		List<WebElement> ocountry = odropdown.findElements(By.tagName("option"));
		System.out.println("Total number of countries in the dropdown is: "+ocountry.size());
		System.out.println("***************************************************************************");
		int count = 0;
		for(int i=0;i<ocountry.size();i++) {
			
			if(ocountry.get(i).getText().equals("INDIA "))
			{
				count = i+1;
				
			}
			
		}
		
		System.out.println("Total no of countries until INDIA is reached is : "+count);
		
		}
	
	public static void getoption() {
		
		WebElement odropdown;
		odropdown = driver.findElement(By.xpath("//select[@name='country']"));
		
		Select oselect = new Select(odropdown);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Total number of countries in the dropdown is: "+oselect.getOptions().size());
		int count = 1;
		for(int i=0;i<oselect.getOptions().size();i++) {
			
			if(oselect.getOptions().get(i).getText().equalsIgnoreCase("INDIA ")) {
				count = count + i;
			}
		}
		
		System.out.println("Total no of countries until India is reachd is: "+count);
		
	}
}
