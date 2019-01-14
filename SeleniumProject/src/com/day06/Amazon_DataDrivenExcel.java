package com.day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon_DataDrivenExcel {

	static String excelfile = "./Data/Amazon_search.xlsx";
	static String ssheet = "Amazon";
	static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {

		Row orow;
		Cell ocell;
		String prod, cat;
		System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		try {
			
		FileInputStream ofile = new FileInputStream(excelfile);
		XSSFWorkbook oexcel = new XSSFWorkbook(ofile);
		XSSFSheet osheet = oexcel.getSheet(ssheet);
		int itotalrow = osheet.getLastRowNum();
		int icell1 = 1, icell2 = 2;
		for(int irow=1;irow<=itotalrow;irow++) {
			
			orow = osheet.getRow(irow);
			ocell = orow.getCell(icell1);
			prod = ocell.getStringCellValue();
			ocell = orow.getCell(icell2);
			cat = ocell.getStringCellValue();
			//System.out.println(prod+"  "+cat);
			Amazon_search(prod, cat, irow);
			
		}
		oexcel.close();
		ofile.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}
	
	public static void Amazon_search(String prod, String cat, int irow) throws Throwable {
		
		WebElement odrop, osearch, obtn, ores;
		Thread.sleep(3000);
		odrop = driver.findElement(By.id("searchDropdownBox"));
		Select oselect = new Select(odrop);
		oselect.selectByVisibleText(cat);
		
		osearch = driver.findElement(By.id("twotabsearchtextbox"));
		osearch.clear();
		osearch.sendKeys(prod);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		obtn = driver.findElement(By.xpath("//input[@value='Go']"));
		obtn.click();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		ores = driver.findElement(By.id("s-result-count"));
		String result = ores.getText();
		//System.out.println(result);
		
		result_write(result,excelfile,ssheet,irow);
		Thread.sleep(5000);
	}

	public static void result_write(String result, String efile, String esheet,int irow) {
		
		XSSFRow orow;
		XSSFCell ocell;
		
		try {
			
			FileInputStream ofile = new FileInputStream(efile);	
			XSSFWorkbook oexcel = new XSSFWorkbook(ofile);
			XSSFSheet osheet = oexcel.getSheet(esheet);
			//int itotalrow = osheet.getLastRowNum();
			int icell = 3;
			//for(int irow = 1;irow<=itotalrow; irow++) {
				
				orow = osheet.getRow(irow);
				ocell = orow.getCell(icell);
				//if(ocell==null) {
					//orow.createCell(icell);
					//ocell = orow.getCell(icell);
				//}
				ocell.setCellValue(result);
				
				FileOutputStream ofilewrite = new FileOutputStream(efile);
				oexcel.write(ofilewrite);
				ofilewrite.close();
			//}
			
			oexcel.close();
			ofile.close();
				
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}

