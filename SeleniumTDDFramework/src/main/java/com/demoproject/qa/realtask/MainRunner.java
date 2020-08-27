package com.demoproject.qa.realtask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;



public class MainRunner {
	
	public MainRunner() {
		
	}
	
	public static String  DATA_SHEET = "/home/globallogic/Downloads/Task1/endpoints.xls";
	
//	public static void main(String []args) throws IOException {
//		ArrayList links = extract_endpoints();
//		
//	}
	public static ArrayList extract_endpoints() throws IOException {
		FileInputStream fis=new FileInputStream(new File(DATA_SHEET));  
		//creating workbook instance that refers to .xls file  
		HSSFWorkbook wb=new HSSFWorkbook(fis);   
		//creating a Sheet object to retrieve the object  
		HSSFSheet sheet=wb.getSheetAt(0);  

		ArrayList links=new ArrayList();
		HSSFRow row ;
		HSSFCell cell;
		for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
		   row = sheet.getRow(rowIndex);
		   links.add(row.getCell(1));	   
		}
		
		for (int i = 0; i < links.size(); i++) {
		    System.out.println("Link "+ i + ":" +  links.get(i));
		}
		return links;
	}  
	

	

}
