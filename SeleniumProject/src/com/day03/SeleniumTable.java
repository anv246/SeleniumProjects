package com.day03;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTable {

	static WebDriver driver;
	
	public static void main(String[] args) {

		seleniumwebsite();
		directxpath();

	}
	
	public static void seleniumwebsite()
	{
		WebElement otable, orow, ocol;
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumhq.org/download/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		otable = driver.findElement(By.xpath("(//div[@id='mainContent']/table)[2]/tbody"));
		
		List<WebElement> orowlist = otable.findElements(By.tagName("tr"));
		System.out.println("no of rows in the table :"+orowlist.size());
		
		for(int i=0;i<orowlist.size();i++) {
			//System.out.println(orowlist.get(i).getText());
			orow = orowlist.get(i);
			List<WebElement> ocollist = orow.findElements(By.tagName("td"));
			
			for(int j=0;j<ocollist.size();j++) {
				ocol = ocollist.get(j);
				System.out.print(ocol.getText()+"  ");
			}
			
			System.out.println();
		}
		

	}

	public static void directxpath() {
		
		WebElement ovalue;
		ovalue = driver.findElement(By.xpath("(((//div[@id='mainContent']/table)[2]/tbody/tr)[5]/td)[5]"));
		System.out.println();
		System.out.println("************************************************************************");
		System.out.println("Value of the element located by it's xpath directly is: "+ovalue.getText());
		
		
	}
}
