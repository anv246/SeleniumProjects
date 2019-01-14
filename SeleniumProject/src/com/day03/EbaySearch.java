package com.day03;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EbaySearch {

	public static WebDriver driver;
	public static String sURL = "https://www.ebay.com/";
	public static int iBroType = 1; //1 - Chrome,2 - FF,3 - IE,4 - Edge

	public static void main(String[] args) {
		browserInvoke();
		browserSettings();
		navigateURL();
		getPageInfo();
		ebaySearch("iPhone", "Cell Phones & Accessories");
		getResult();
		System.out.println("====================");
		getResultwithXPATH();
		//closeBrowser();
	}
	
	public static void browserInvoke() {
		
		switch (iBroType) {
		case 1:
			System.out.println("User Option is : "+iBroType+" ,So invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case 2:
			System.out.println("User Option is : "+iBroType+" ,So invoking FF Browser");
			System.setProperty("webdriver.gecko.driver", "./browserdrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("User Option is Wrong : "+iBroType+" ,So invoking Default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		
	}
	
	public static void browserSettings() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	public static void navigateURL() {
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void getPageInfo() {
		System.out.println("Page Title is : "+driver.getTitle());
		System.out.println("Page Current URL is : "+driver.getCurrentUrl());
	}
	
	public static void ebaySearch(String sSearch,String sCat) {
		WebElement oTxt,oBtn,oDrop;
		oTxt = driver.findElement(By.id("gh-ac"));
		oTxt.clear();
		oTxt.sendKeys(sSearch);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		oDrop = driver.findElement(By.xpath("//*[@id='gh-cat']"));
		Select oSelect = new Select(oDrop);
		oSelect.selectByVisibleText(sCat);
		
		oBtn = driver.findElement(By.xpath("//*[@id='gh-btn']"));
		oBtn.submit();
	}
	
	public static void getResult() {
		WebElement oResult,oElement;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		oResult = driver.findElement(By.xpath("//h1[contains(text(),'results')]"));
		String sResult= oResult.getText();
		System.out.println("Total Result is : "+sResult);
		sResult = sResult.replaceAll("[^0-9]", "");
		System.out.println("Total Result is : "+sResult);
		int iResult = Integer.parseInt(sResult);
		if(iResult>0) {
			System.out.println("Results Found");
			List<WebElement> oList = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']/li"));
			System.out.println("Search Result in one Page is : "+oList.size());
			for(int i=0;i<oList.size();i++) {
				oElement = oList.get(i);
				System.out.println(oElement.findElement(By.xpath(".//a[@class='s-item__link']")).getText());
			}
		}else {
			System.out.println("No Results Found");
		}
	}
	
	public static void getResultwithXPATH() {
		
		List<WebElement> oList = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']/li"));
		System.out.println("Search Result in one Page is : "+oList.size());
		for(int i=1;i<=oList.size();i++) {
		WebElement	oElement = driver.findElement(By.xpath("//ul[@class='srp-results srp-list clearfix']/li["+i+"]//a[@class='s-item__link']"));
		System.out.println(oElement.getText());
		}
		
	}
	
	
	
	public static void closeBrowser() {
		driver.close();
	}

}

