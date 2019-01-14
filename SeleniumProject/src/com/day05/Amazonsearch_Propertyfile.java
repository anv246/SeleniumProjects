package com.day05;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazonsearch_Propertyfile {

	static WebDriver driver;
	
	public static void main(String[] args) {

		amazonsearchproperty();

	}

	public static void amazonsearchproperty() {
		
		String pfile = "./Data/datadriven_property.properties";
		
		//File ofile = new File(pfile);
		FileInputStream file = null;
		
		try { 
			file = new FileInputStream(pfile);
					
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
		Properties oprop = new Properties();
		try {
			WebElement odrop, osearch, obtn;
			oprop.load(file);
			String sURL = oprop.getProperty("AmazonURL");
			//System.out.println(sURL);
			String cat = oprop.getProperty("category");
			String prod = oprop.getProperty("product");
			System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(sURL);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			odrop = driver.findElement(By.id("searchDropdownBox"));
			Select oselect = new Select(odrop);
			oselect.selectByVisibleText(cat);
			
			osearch = driver.findElement(By.id("twotabsearchtextbox"));
			osearch.sendKeys(prod);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			obtn = driver.findElement(By.xpath("//input[@value='Go']"));
			obtn.click();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		
		
	}
}
