package TestCases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelFile;

public class excelValidation {
	
	

	@Test(dataProvider = "dp1")
	public void Login(String name,String ID,String ctc) {
		
		System.out.println(name);
		System.out.println(ID);
		System.out.println(ctc);
	}
	
	
	@DataProvider(name="dp1")
	public Object[][] getData(Method m) throws IOException{
		
		if(m.getName().equals("Login")) {
			System.out.println("Can achieve mulipile data provider in the this way");
		}
		
		ExcelFile ss=new ExcelFile("C:\\Java _Learning\\sample\\testNG\\src\\test\\resources\\Excel\\sample.xlsx");
		String fileName="sample.xlsx";
		String sheetName="Sheet1";
		int rows=ss.rowCount(sheetName);
		int cols=ss.columnCount(sheetName);
		
		Object[][] obj=new Object[rows-1][cols];
		ArrayList<Object> aa=new ArrayList<Object>();
		aa=ss.readExcel(fileName,sheetName);
		int index=cols;
		
		for(int rowNum=2;rowNum<=rows;rowNum++) {
			
			for(int colNum=0;colNum<cols;colNum++) {
				
				obj[rowNum-2][colNum]=aa.get(index).toString();
				if(colNum<cols)
					index++;
			}
		}
		return obj;
		
		
		
	}

}
