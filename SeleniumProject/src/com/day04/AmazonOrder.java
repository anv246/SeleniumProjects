package com.day04;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AmazonOrder {
	
	static WebDriver driver;
	static String sURL = "https://www.amazon.in/";

	public static void main(String[] args) throws Throwable {

		amazonsite();
		amazonsignin();

	}

	public static void amazonsite() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(sURL);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
				
	}
	
	public static void amazonsignin() throws Throwable {
		
		WebElement otrg, osignin, ovalidate;
		
		Actions oaction = new Actions(driver);
		
		/*otrg = driver.findElement(By.xpath("(//span[text()='Your Orders'])[1]"));
		oaction.moveToElement(otrg).pause(5).build().perform();
		//Thread.sleep(2000);
		
		osignin = driver.findElement(By.xpath("//span[@class='nav-line-3']"));
		oaction.moveToElement(osignin).click().build().perform();*/
		
		osignin = driver.findElement(By.id("nav-link-yourAccount"));
		oaction.moveToElement(osignin).click().build().perform();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		logindetails();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		ovalidate = driver.findElement(By.xpath("//span[@class='nav-line-1' and contains(text(),'Vijay')]"));
		if(ovalidate.getText().contains("Vijay"))
		{
			System.out.println("Welcome to Amazon. Your login validation has been completed. You have logged into Amazon successfully ");
		}
		
		searchitem();	
	}
	
	public static void logindetails() {
		
		WebElement uname, pwd;
		
		uname = driver.findElement(By.name("email"));
		uname.sendKeys("anvraghav@gmail.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		pwd = driver.findElement(By.id("ap_password"));
		
		pwd.sendKeys("Raghavan@91");
		driver.findElement(By.id("signInSubmit")).submit();
				
	}
	
	public static void searchitem() {
		
		WebElement odrop, osearch, obtn;
		odrop = driver.findElement(By.id("searchDropdownBox"));
		Select oselect = new Select(odrop);
		oselect.selectByVisibleText("Electronics");
		
		osearch = driver.findElement(By.id("twotabsearchtextbox"));
		osearch.sendKeys("iphone");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		obtn = driver.findElement(By.xpath("//input[@type='submit' and @value='Go']"));
		obtn.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//results();
		
	}
	
	/*public static void results() {
		
		WebElement prodname;
		List<WebElement> olist = driver.findElements(By.xpath("(//ul[@class='s-result-list s-col-3 s-result-list-hgrid s-height-equalized s-grid-view s-text-condensed'])[1]/li"));
		prodname = 
		 
	}*/
}
