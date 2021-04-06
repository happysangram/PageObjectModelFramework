package com.accruent.testcases;


import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.accruent.base.TestBase;
import com.accruent.utilities.TestUtil;


@Test(dataProviderClass = TestUtil.class,dataProvider = "dp")
public class AddCustomer extends TestBase {
	
	public void AddCustomer(String fName,String lName,String postCode,String alertTest ) throws InterruptedException {
		log.debug("Add customer test starts.");
		
		click("addCustBtn");
		type("firstName", fName);
		type("lastName", lName);
		type("postCode", postCode);
		click("addBtn");
		
		
//		
//		driver.findElement(By.cssSelector(or.getProperty("addCustBtn"))).click();
//		driver.findElement(By.cssSelector(or.getProperty("firstName"))).sendKeys(fName);
//		driver.findElement(By.cssSelector(or.getProperty("lastName"))).sendKeys(lName);
//		driver.findElement(By.cssSelector(or.getProperty("postCode"))).sendKeys(postCode);
//		driver.findElement(By.cssSelector(or.getProperty("addBtn"))).click();
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alertTest));
        alert.accept();
		
	}
	
//	@DataProvider
//	public Object[][] getData() throws IOException {
//		
//				
//		String sheetName="AddCustomer";
//		String fileName="testdata.xlsx";
//		int rows=excel.rowCount(sheetName);
//		int cols=excel.columnCount(sheetName);
//		
//		ArrayList<Object> exceldata = new ArrayList<Object>();
//		Object[][] data=new Object[rows-1][cols];
//		
//		exceldata=excel.readExcel(fileName,sheetName);
//		int index=cols;
//		
//		for(int rowNum=2;rowNum<=rows;rowNum++) {
//			
//			for(int colNum=0;colNum<cols;colNum++) {
//				
//				data[rowNum-2][colNum]=exceldata.get(index).toString();
//				if(colNum<cols)
//					index++;
//			}
//		}
//		return data;
//	}
	

}
