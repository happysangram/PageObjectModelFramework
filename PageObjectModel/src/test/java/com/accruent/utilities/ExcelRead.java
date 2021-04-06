package com.accruent.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import com.accruent.base.Page;



public class ExcelRead extends Page {
	
	public ExcelRead() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\excel";
		String fileName="testdata.xls";
		String sheetName="AddCustomer";
		
		ExcelRead excel=new ExcelRead();
		excel.readExcel(filePath,fileName,sheetName);
		
	}
		
	public void readExcel(String filePath,String fileName,String sheetName) throws IOException {
		
		
	    //Create an object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);
	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);
	    HSSFWorkbook workbook = null;
	    
	    if(fileName.contains("xls") ) {
	    		workbook=new HSSFWorkbook(inputStream);
	    }
	    //Read sheet inside the workbook by its name
	    //Sheet sheet = workbook.getSheet(sheetName);
	    HSSFSheet sheet = workbook.getSheetAt(0);      //Retrieve the sheet only at 0th index.
	    
	    Iterator rows = sheet.rowIterator();
	    while (rows.hasNext()) {
	    	
	        HSSFRow row = (HSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            
            while (cells.hasNext()) {
            	  HSSFCell cell = (HSSFCell) cells.next();
            	  CellType type = cell.getCellType();
            	  if (type == CellType.STRING) {
            		  System.out.println("[" + cell.getRowIndex() + ", " + cell.getColumnIndex() + "] = STRING; Value = " + cell.getRichStringCellValue().toString());
            	  }
            	  else if (type == CellType.NUMERIC) {
            		   System.out.println("[" + cell.getRowIndex() + ", "+ cell.getColumnIndex() + "] = NUMERIC; Value = "+ cell.getNumericCellValue());			
            	  }
            	  else if (type == CellType.BOOLEAN) {
                      System.out.println("[" + cell.getRowIndex() + ", " + cell.getColumnIndex() + "] = BOOLEAN; Value = "+ cell.getBooleanCellValue());
            	  }
            	  else if (type == CellType.BLANK) {
                      System.out.println("[" + cell.getRowIndex() + ", " + cell.getColumnIndex() + "] = BLANK CELL");
                  }
            }
	    }
	}
}
