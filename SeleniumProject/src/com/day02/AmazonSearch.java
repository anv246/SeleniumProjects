package com.day02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonSearch {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		amazonsearch("Electronics","iphone");
		results();

	}

	public static void amazonsearch(String cat, String prod)
	{
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		WebElement odrop, osearch, obtn;
		
		odrop = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		
		Select oselect = new Select(odrop);
		oselect.selectByVisibleText(cat);
		
		osearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		osearch.sendKeys(prod);
		
		obtn = driver.findElement(By.xpath("//input[@type='submit' and @value='Go']"));
		obtn.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	public static void results()
	{
		WebElement ores;
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		ores = driver.findElement(By.xpath("//span[contains(text(),'result')]"));
		String result = ores.getText();
		//System.out.println("result is: "+result);
		String a[] = result.split(" ");
		String b[] = a[0].split("-");
		System.out.println("There are totally "+b[1]+" results for your search in the current page");
		
		//int fresult = Integer.parseInt(b[1]);
		
		// if(fresult > 0)
			
		 
			
		
	}
}
