package com.amazon.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.amazon.qa.base.TestBase;

public class TestUtils extends TestBase { 
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	
	//Path where Test Data resides
		public static String TESTDATA_SHEET_PATH = "C:\\Users\\akkip\\eclipse-workspace\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\testdata\\TestData.xlsx";
	
		static Workbook book;
		static Sheet sheet;
		
//	//switches to objects inside a frame
//		public void switchToFrame(){
//
//		}
		
		
		public static Object[][] getTestData(String sheetName){
				FileInputStream file = null;
				
				//try the file if is is available or not
				try {
					file = new FileInputStream(TESTDATA_SHEET_PATH);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				//try to check if the appropriate format of the file is created on not
				try {
					book = WorkbookFactory.create(file);
				}catch (InvalidFormatException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				//get the name of the sheet and store in sheet variable
				sheet = book.getSheet(sheetName);
				//will create a two diamentional array and get last row number and last cell number of the row
				Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				//iterate the row numbers of the sheet
				for(int i=0; i< sheet.getLastRowNum();i++) {
				//iterate the cell number of the row from the given sheet
					for(int j=0; j< sheet.getRow(0).getLastCellNum();j++) {
				//To convert the value of i and j to string.
						data[i][j] = sheet.getRow(i+1).getCell(j).toString();
						//Print i and j
						System.out.println(data[i][j]);
					}
				}
				return data;
		}

		public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		}
		
		
}
