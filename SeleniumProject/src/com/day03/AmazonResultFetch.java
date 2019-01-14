package com.day03;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonResultFetch {

	
		public static WebDriver driver;

		public static void main(String[] args) {
			
			amazonsearch("Electronics","iphone");
			results();
			dirresultxpath();

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
			WebElement ores, oelement;
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			ores = driver.findElement(By.xpath("//span[contains(text(),'result')]"));
			String result = ores.getText();
			//System.out.println("result is: "+result);
			String a[] = result.split(" ");
			String b[] = a[0].split("-");
			System.out.println("There are totally "+b[1]+" results for your search in the current page");
			
			int fresult = Integer.parseInt(b[1]);
			
			if(fresult > 0)
			 {
				 System.out.println("Results found");
				 List<WebElement> olist = driver.findElements(By.xpath("(//ul[@class='s-result-list s-col-3 s-result-list-hgrid s-height-equalized s-grid-view s-text-condensed'])[1]/li"));
				 
				 System.out.println("search result in the current page is : "+olist.size());
				 
				 for(int i=0;i<olist.size();i++)
				 {
					 oelement = olist.get(i);
					 System.out.println(oelement.findElement(By.xpath(".//a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']")).getText());
				 
				 }
				 
			 }
			
			else
			{
				System.out.println("no results found");
			}
			 
					
		
}
		public static void dirresultxpath()
		{
			WebElement oelement1;
			
			System.out.println("****************************results by locating direct xpath of each element*****************************");
			List<WebElement> olist = driver.findElements(By.xpath("(//ul[@class='s-result-list s-col-3 s-result-list-hgrid s-height-equalized s-grid-view s-text-condensed'])[1]/li"));
			for(int i=1;i<=olist.size();i++)
			{
				
				oelement1 = driver.findElement(By.xpath("((//ul[@class='s-result-list s-col-3 s-result-list-hgrid s-height-equalized s-grid-view s-text-condensed'])[1]/li//a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal'])["+i+"]"));
				System.out.println(oelement1.getText());
			}
			
		}

}