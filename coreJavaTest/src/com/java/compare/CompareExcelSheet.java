package com.java.compare;

	
	import org.apache.poi.ss.usermodel.*;

	import java.io.FileInputStream;
	import java.io.IOException;

	public class CompareExcelSheet {
	    public static void main(String[] args) {
	        String file1Path = "C:\\eclipse-workspace\\excel\\file1.xlsx";
	        String file2Path = "C:\\eclipse-workspace\\excel\\file2.xlsx";

	        try (FileInputStream file1 = new FileInputStream(file1Path);
	             FileInputStream file2 = new FileInputStream(file2Path);
	             Workbook workbook1 = WorkbookFactory.create(file1);
	             Workbook workbook2 = WorkbookFactory.create(file2)) {

	            Sheet sheet1 = workbook1.getSheetAt(0); // Assuming you want to compare the first sheet
	            Sheet sheet2 = workbook2.getSheetAt(0);

	            boolean areEqual = compareSheets(sheet1, sheet2);
	            if (areEqual) {
	                System.out.println("Sheets are identical.");
	            } else {
	                System.out.println("Sheets are not identical.");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static boolean compareSheets(Sheet sheet1, Sheet sheet2) {
	        if (sheet1.getLastRowNum() != sheet2.getLastRowNum()) {
	            return false; // Number of rows is different
	        }

	        for (int i = sheet1.getFirstRowNum(); i <= sheet1.getLastRowNum(); i++) {
	            Row row1 = sheet1.getRow(i);
	            Row row2 = sheet2.getRow(i);

	            if (row1.getLastCellNum() != row2.getLastCellNum()) {
	                return false; // Number of cells in a row is different
	            }

	            for (int j = row1.getFirstCellNum(); j < row1.getLastCellNum(); j++) {
	                Cell cell1 = row1.getCell(j);
	                Cell cell2 = row2.getCell(j);

	                if (!areCellsEqual(cell1, cell2)) {
	                    return false; // Cell values are different
	                }
	            }
	        }

	        return true; // Sheets are identical
	    }

	    private static boolean areCellsEqual(Cell cell1, Cell cell2) {
	        if (cell1 == null && cell2 == null) {
	            return true; // Both cells are empty
	        }

	        if (cell1 == null || cell2 == null) {
	            return false; // One cell is empty, the other is not
	        }

	        CellType cellType1 = cell1.getCellType();
	        CellType cellType2 = cell2.getCellType();

	        if (cellType1 != cellType2) {
	            return false; // Cell types are different
	        }

	        if (cellType1 == CellType.NUMERIC) {
	            return cell1.getNumericCellValue() == cell2.getNumericCellValue();
	        } else if (cellType1 == CellType.STRING) {
	            return cell1.getStringCellValue().equals(cell2.getStringCellValue());
	        } else if (cellType1 == CellType.BOOLEAN) {
	            return cell1.getBooleanCellValue() == cell2.getBooleanCellValue();
	        } else if (cellType1 == CellType.FORMULA) {
	            return cell1.getCellFormula().equals(cell2.getCellFormula());
	        }

	        return true; // Cell values are equal for other types
	    }
	}


