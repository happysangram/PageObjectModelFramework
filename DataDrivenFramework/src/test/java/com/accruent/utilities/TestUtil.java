package com.accruent.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import com.accruent.base.TestBase;

public class TestUtil extends TestBase {
	
	

	public static String screenshotName; 
	
	public static void captureScreenshot() throws IOException {
		
		File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		Date d=new Date();
		screenshotName=d.toString().replace(":", "_").replace(" ", "_");
		FileUtils.copyFile(screenshotFile, new File("C:\\Java _Learning\\sample\\DataDrivenFramework\\target\\surefire-reports\\html\\"+screenshotName));

	}
	
	public static boolean isTEstRunnable(String testName,ExcelRead excelfile) {
		
		String fileName="testdata.xlsx";
		int rows=excel.rowCount("test_suite");
		int cols=excel.columnCount("test_suite");
		for(int rowNum=2;rowNum<=rows;rowNum++) {
			
		}
		
		return true;
		
	}
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m) throws IOException {
		
				
		String sheetName=m.getName();
		String fileName="testdata.xlsx";
		int rows=excel.rowCount(sheetName);
		int cols=excel.columnCount(sheetName);
		
		ArrayList<Object> exceldata = new ArrayList<Object>();
		Object[][] data=new Object[rows-1][cols];
		
		exceldata=excel.readExcel(fileName,sheetName);
		int index=cols;
		
		for(int rowNum=2;rowNum<=rows;rowNum++) {
			
			for(int colNum=0;colNum<cols;colNum++) {
				
				data[rowNum-2][colNum]=exceldata.get(index).toString();
				if(colNum<cols)
					index++;
			}
		}
		return data;
	}
	

}
