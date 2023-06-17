package com.java.excel;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelWorkbookXlsx {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook wb=null;
		try
		{
			wb = (XSSFWorkbook) WorkbookFactory.create(new File("C:\\eclipse-workspace\\corejavaEx\\src\\corejavaEx\\Employee.xlsx"));
			//wb = (XSSFWorkbook) WorkbookFactory.create(new File("C:\\eclipse-workspace\\testfiles\\Employee.xlsx"));
			
			//XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(0);
			Iterator<Sheet> sheetIterator = wb.sheetIterator();
			
			XSSFRow row0 = sheet.getRow(0);
			XSSFRow row1 = sheet.getRow(1);			

            while(sheetIterator.hasNext()) {
            	
            sheet = (XSSFSheet) sheetIterator.next();	
            
            Iterator<Row> rowIterator = sheet.rowIterator();
            System.out.print("sheet.getLastRowNum():: "+sheet.getLastRowNum() + "\n");
      
            while(rowIterator.hasNext()) {	
            	Row row = rowIterator.next();
            	System.out.print("\n");
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    CellType cellType = cell.getCellType();                   
                   
                    if(cellType == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t");
                    } else if(cellType == CellType.NUMERIC) {
                    	
                    	if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.println("D "+cell.getDateCellValue());
                    	}else {
                            System.out.print(cell.getNumericCellValue() + "\t");
                    }
                        
                    }                      
                        
                        //Date date = HSSFDateUtil.getJavaDate(cell.getNumberValue()); 
                    }
                    
              }
          }
              
}catch(Exception ex) {	
}finally { 
			  if(wb != null);
			  wb.close();
		}
				
	}  
}
