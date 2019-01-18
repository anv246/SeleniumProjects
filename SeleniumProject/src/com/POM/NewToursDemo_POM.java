package com.POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewToursDemo_POM {
	
	Container ocon;
	private static WebDriver driver;
	
	public NewToursDemo_POM(WebDriver driver) {
		this.driver = driver;
	}

	public void test() {
		
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.newtours.demoaut.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		ocon = new Container(driver);
		ocon.Web_link("REGISTER").click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ocon.Web_text("firstName").sendKeys("Vijayaraghavan");
		ocon.Web_text("lastName").sendKeys("AN");
		ocon.Web_text("phone").sendKeys("8754406759");
		ocon.Web_dropdown("//select[@name='country']").selectByVisibleText("INDIA ");
		ocon.Web_submit("register").submit();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public static void main(String args[]) {
		NewToursDemo_POM opom = new NewToursDemo_POM(driver);
		opom.test();
	}
}
