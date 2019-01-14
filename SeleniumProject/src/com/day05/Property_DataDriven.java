package com.day05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property_DataDriven {

	public static void main(String[] args) {
		
		propertyReader();

	}

	public static void propertyReader() {
		
		String sfile = "./Data/datadriven_property.properties";
		File ofile = new File(sfile);
		
		FileInputStream file = null;
		try{
			file = new FileInputStream(ofile);
			
		} catch(FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties oprop = new Properties();
		try {
			 oprop.load(file);
			 System.out.println("site name is: "+oprop.getProperty("SiteName"));
			 System.out.println("URL is: "+oprop.getProperty("URL"));
			 
		}
		catch (IOException e) {
			e.printStackTrace();			
		}
	}
}
