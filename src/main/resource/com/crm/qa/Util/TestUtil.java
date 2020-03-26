package com.crm.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{


	
	static String TESTDATA_SHEET_PATH="C:\\Users\\admin\\eclipse-workspace\\FreeCRMProject\\src\\main\\java\\com\\crm\\qa\\TestData\\DataFile.xlsx";
	public static long page_load_timeout=20;
	
	public static long implict_wait=20;
	
	//File src;
	static FileInputStream fis;
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	public static Object[][] getTestData(String sheetName) {
		try {
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
			try {
				book = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "--------" +
		sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				 System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	public static void screenShot(String Screenshot) throws IOException {
		
		TakesScreenshot screen=(TakesScreenshot) driver;
		File actualScreenshot=screen.getScreenshotAs(OutputType.FILE);
		File myFile=new File(Screenshot+System.currentTimeMillis()+".png");
		FileHandler.copy(actualScreenshot, myFile);
		System.out.println("done");
		}

	}
