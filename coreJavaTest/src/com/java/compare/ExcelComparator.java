package com.java.compare;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelComparator {
    public static void main(String[] args) {
        //String file1Path = "path/to/file1.xlsx";
        //String file2Path = "path/to/file2.xlsx";
        
        String file1Path = "C:\\eclipse-workspace\\excel\\file1.xlsx"; 
        String file2Path = "C:\\eclipse-workspace\\excel\\file2.xlsx";


        try (FileInputStream file1 = new FileInputStream(file1Path);
             FileInputStream file2 = new FileInputStream(file2Path);
             Workbook workbook1 = new XSSFWorkbook(file1);
             Workbook workbook2 = new XSSFWorkbook(file2)) {

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
        int maxRows = Math.max(sheet1.getLastRowNum(), sheet2.getLastRowNum());
        int maxColumns = Math.max(getLastNonEmptyColumn(sheet1), getLastNonEmptyColumn(sheet2));

        for (int rowIdx = 0; rowIdx <= maxRows; rowIdx++) {
            Row row1 = sheet1.getRow(rowIdx);
            Row row2 = sheet2.getRow(rowIdx);

            if (!areRowsEqual(row1, row2, maxColumns)) {
                return false;
            }
        }

        return true;
    }

    private static boolean areRowsEqual(Row row1, Row row2, int maxColumns) {
        if (row1 == null && row2 == null) {
            return true; // Both rows are empty
        }

        if (row1 == null || row2 == null) {
            return false; // One row is empty, the other is not
        }

        for (int colIdx = 0; colIdx <= maxColumns; colIdx++) {
            Cell cell1 = row1.getCell(colIdx);
            Cell cell2 = row2.getCell(colIdx);

            if (!areCellsEqual(cell1, cell2)) {
                return false;
            }
        }

        return true;
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

    private static int getLastNonEmptyColumn(Sheet sheet) {
        int lastColumn = 0;
        for (Row row : sheet) {
            int lastCell = row.getLastCellNum();
            if (lastCell > lastColumn) {
                lastColumn = lastCell;
            }
        }
        return lastColumn;
    }
}