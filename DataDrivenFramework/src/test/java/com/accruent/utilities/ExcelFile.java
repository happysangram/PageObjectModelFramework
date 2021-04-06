package com.accruent.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {
	
	public static int noOfColumns;
	public static int noOfRows;
	Workbook workbook = null;
	Sheet sheet=null;
	public  String path;
	public FileInputStream fis;

	public ExcelFile(String path) {
		
		this.path=path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			fis.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	public ArrayList readExcel(String fileName,String sheetName) throws IOException {
		
	    ArrayList<Object> data=new ArrayList<Object>();
	    //Read sheet inside the workbook by its name
	    sheet = workbook.getSheet(sheetName);
	    
	    Iterator itr=sheet.iterator();
	    while(itr.hasNext())
        {
	    	  Row r=(Row) itr.next();
	            Iterator cellitr=r.cellIterator();
	            while(cellitr.hasNext())
	            {
	            	Cell celldata=(Cell) cellitr.next();
	            	switch(celldata.getCellType()) {
	                case STRING :
	                    data.add(celldata.getStringCellValue());
	                    break;
	                case NUMERIC:
	                    data.add(celldata.getNumericCellValue());
	                    break;
	                case BOOLEAN:
	                    data.add(celldata.getBooleanCellValue());
	                    break;
	                case BLANK:
	                    data.add(celldata.getBooleanCellValue());
	                    break;
	            	}
	            }
        }
	    return data;  
	}
	
	public int columnCount(String sheetName) {
		
		  sheet = workbook.getSheet(sheetName);
		  noOfColumns = sheet.getRow(0).getLastCellNum();
		return noOfColumns;
	}
	
	public int rowCount(String sheetName) {
		 sheet = workbook.getSheet(sheetName);
		 noOfRows=sheet.getLastRowNum();
	    if ((noOfRows > 0) || (sheet.getPhysicalNumberOfRows() > 0))
	    {
	    	noOfRows++;
	    }
		return noOfRows;
	}
	
}
	    
