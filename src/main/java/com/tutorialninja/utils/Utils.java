package com.tutorialninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {
	
	
	
	public static String generateEmail() {
		
		Date dt = new Date();
		
		String email =	dt.toString().replace(" ", "_").replace(":", "_");
		 return "pandeyashu" +email+ "@gmail.com";
		
		
	}
	
	public static Object[][] getTestData(String sheetname) {
		File fl = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\testdata\\TutorialsNinjaTestData.xlsx");
		XSSFWorkbook wb= null;
		try {
			FileInputStream fis = new FileInputStream(fl);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	    XSSFSheet sheet =	wb.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		Object [][] data = new Object[rows][cols];
		
		
		
		
		for(int i=0; i < rows; i++) {
		
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0; j< cols; j++) {
				DataFormatter df = new DataFormatter();

				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		
	}
	
	return data;

}
	
	public static String captureSS(WebDriver driver, String testname) {
		
		File srcSS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationpath = System.getProperty("user.dir")+ "\\Screenshot\\"+ testname +".png";
		File destpath = new File(destinationpath);
		try {
			FileUtils.copyFile(srcSS, destpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationpath;
	}
	
}
