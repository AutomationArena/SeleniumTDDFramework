package com.demoproject.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;   
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.demoproject.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static int PAGE_LOAD_TIME = 15;
	public static int IMPLICIT_WAIT_TIME = 10;
	public static String TESTDATA_SHEET_PATH ="/home/globallogic/eclipse-workspace/SeleniumTDDFramework/src/main/java/com/demoproject/qa/testdata/DemoProjectTestData.xlsx";
	
	static Workbook workbook;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	public static int screenshot_count = 1;

	public static void takeScreenShot(WebDriver driver,String filePath) throws Exception{
        File src_screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File DestFile=new File(filePath);
        FileUtils.copyFile(src_screenshot, DestFile);
        screenshot_count+=1;
    	// call using :takeScreenShot(driver, "/home/globallogic/eclipse-workspace/SeleniumTDDFramework/Screenshots/test_"+screenshot_count+".png") ;
   }
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][8];
		 System.out.println(sheet.getLastRowNum() + "--------" +
		 sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < 8; k++) {
				if(sheet.getRow(0).getCell(k).toString() != null) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();	
				}
				
			
				 System.out.println("I == "+ i + " k == "+ k +data[i][k]);
				 
			}
		}
		System.out.println("data is" +data);
		return data;
	}
 	
}
