package com.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Container {
	
	private WebDriver driver;
	private WebElement olink, otext, osubmit;

	public Container(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement Web_link(String sLink) {
		
		return olink = driver.findElement(By.linkText(sLink));
	}
	
	public WebElement Web_text(String sText) {
		return otext = driver.findElement(By.name(sText));
	}
	
	public Select Web_dropdown(String xpath) {
		
		Select oselect = new Select(driver.findElement(By.xpath(xpath)));
		return oselect;
	}
	
	public WebElement Web_submit(String sName) {
		
		return osubmit = driver.findElement(By.name(sName));	
	}
}
