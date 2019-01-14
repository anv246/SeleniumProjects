package com.testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class phptravels {
	
	static WebDriver driver;
	static String URL = "https://phptravels.com/demo/";
	
  @Test(priority=1)
  public static void getCredentials() throws Throwable {
	  
	  WebElement admin, uname, popup, alert;
	  Thread.sleep(10000);
	  popup = driver.findElement(By.id("onesignal-popover-cancel-button"));
	  popup.click();
	  Thread.sleep(3000);
	  alert = driver.findElement(By.xpath("//div[@data-action='close-mc-modal']"));
	  alert.click();
	  Thread.sleep(3000);
	  uname = driver.findElement(By.xpath("(//div[@class='row'])[10]"));
	  //System.out.println(uname.getText());
	  String cred[] = uname.getText().split(" ");
	  String email = cred[1].replace("Password", "").trim();
	  admin = driver.findElement(By.xpath("(//a[@class='btn btn-primary btn-lg btn-block'])[2]"));
	  admin.click();
	  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	  driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
	  adminlogin(email,cred[2]);
	  
  }
  
 public static void adminlogin(String email, String password) throws Throwable {
	  
	  WebElement uname, pword, obtn;
	  Thread.sleep(5000);
	  uname = driver.findElement(By.xpath("//input[@type='text' and @name='email']"));
	  pword = driver.findElement(By.xpath("//input[@type='password']"));
	  uname.sendKeys(email);
	  pword.sendKeys(password);
	  obtn = driver.findElement(By.xpath("//button[@type='submit']"));
	  obtn.click();
	  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	  
  }
 
 @Test(priority=2)
 public static void dashboard() throws Throwable {
	 
	 WebElement book1, book2, acc, admin;
	 Thread.sleep(5000);
	 book1 = driver.findElement(By.xpath("(//div[@class='tempStatBox'])[1]"));
	 book2 = driver.findElement(By.xpath("(//div[@class='tempStatBox'])[2]"));
	 System.out.println(book1.getText());
	 System.out.println(book2.getText());
	 
	 acc = driver.findElement(By.xpath("(//a[@data-parent='#social-sidebar-menu'])[2]"));
	 acc.click();
	 
	 admin = driver.findElement(By.xpath("//a[text()='Admins']"));
	 admin.click();
	 driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	 
 }
 
 @Test(priority=3)
 public static void Registerform() throws Throwable {
	 
	 WebElement oadd, odel, odrop, otxt;
	// oadd = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
	 odel = driver.findElement(By.xpath("//a[@class='delete_button btn btn-danger btn-xs']"));
	 otxt = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
	// String addtext = oadd.getText();
	 String deltext = odel.getText();
	 boolean ores = otxt.isDisplayed();
	 Assert.assertEquals(ores, true);
	 Assert.assertEquals(deltext,"DELETE SELECTED");
	 System.out.println("Add and delete button validation passed");
	// oadd.click();
	 otxt.click();
	 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Vijayaraghavan");
	 driver.findElement(By.xpath("//input[@placeholder='Last name']")).sendKeys("AN");
	 driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys("abc@gmail.com");
	 driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
	 odrop = driver.findElement(By.xpath("//select[@name='country']"));
	 Select oselect = new Select(odrop);
	 oselect.selectByVisibleText("India");
	 driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	 Thread.sleep(3000);
	 String fname = driver.findElement(By.xpath("//td[text()='Vijayaraghavan']")).getText();
	 Assert.assertEquals(fname, "Vijayaraghavan");
	 System.out.println("data entry validation is passed");
	 Thread.sleep(15000);
	 driver.findElement(By.xpath("//ins[@class='iCheck-helper']")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//a[@class='delete_button btn btn-danger btn-xs']/i")).click();
	 Thread.sleep(3000);
	 driver.switchTo().alert().accept();
	 Thread.sleep(5000);
	 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	 
 }
 
  @BeforeClass
  public static void browseURL() {
	  
	  System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	  
  }

@AfterClass
 public static void closebrowser() throws Throwable {
	 driver.close();
	 Thread.sleep(3000);
	 driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	 Thread.sleep(2000);
	 System.out.println(driver.getTitle());
	 System.out.println("End of Afterclass method execution");
 }
}
