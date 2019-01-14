package com.day05;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven_ExcelRead {

	public static void main(String[] args) {

		String sfile = "./Data/data_source.xlsx";
		String ssheet = "details";
		
	//	String cellvalue = read_from_excel_file(sfile,ssheet,0,0);
		//System.out.println(cellvalue);
		
		electronic_products_from_excel(sfile,ssheet);

	}
	
	public static String read_from_excel_file(String sfile, String ssheet,int irow, int icell) {
		
		XSSFWorkbook oexcel;
		XSSFSheet osheet;
		Row orow;
		Cell ocell;
		FileInputStream ofile;
		String value = null;
		
		try {
			
			ofile = new FileInputStream(sfile);
			oexcel = new XSSFWorkbook(ofile);
			osheet = oexcel.getSheet(ssheet);
			orow = osheet.getRow(irow);
			ocell = orow.getCell(icell);
			value = ocell.getStringCellValue();
			oexcel.close();
			ofile.close();
			
			//return value;
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return value;
		
	}
	
	@SuppressWarnings("deprecation")
	public static void electronic_products_from_excel(String sfile, String ssheet) {
		FileInputStream ofile;
		XSSFWorkbook oexcel;
		XSSFSheet osheet;
		XSSFRow orow;
		Cell ocell;
		int irow, icell, itotalrow, itotalcell;
		int icelltype;
		try {
			
			ofile = new FileInputStream(sfile);
			oexcel = new XSSFWorkbook(ofile);
			osheet = oexcel.getSheet(ssheet);
			
			itotalrow = osheet.getLastRowNum();
			
			for(irow=0;irow<=itotalrow;irow++) {
				
				orow = osheet.getRow(irow);
				
				itotalcell = orow.getLastCellNum();
				
				for(icell=0;icell<itotalcell;icell++) {
					
					ocell = orow.getCell(icell);
					icelltype = ocell.getCellType().getCode();
					//icelltype = ocell.getCellType().toString();
					
					//System.out.println("cell type : " + icelltype);
					switch(icelltype) {
					
					case 0:
						System.out.print(ocell.getNumericCellValue()+"  ");
						break;
						
					case 1:
						System.out.print(ocell.getStringCellValue()+"  ");
						break;
						
					case 4:
						System.out.print(ocell.getBooleanCellValue()+"  ");
						break;
						
					default:
						System.out.print("---------");
						
						
					}
				}
				
				System.out.println();
			}
			
			oexcel.close();
			ofile.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
