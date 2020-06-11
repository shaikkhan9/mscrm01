package com.softvision.mmsg.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlsreader {

    public String path;
    public FileInputStream fis = null;
    public FileOutputStream foup = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    public Xlsreader(String path) {
        this.path = path;
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            // sheet = workbook.getSheet(0);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount(String Sheetname) {
        int index = workbook.getSheetIndex(Sheetname);
        if (index == -1) {
            return 0;
        } else {
            sheet = workbook.getSheetAt(index);
            int rowcount = sheet.getLastRowNum() + 1;
            return rowcount;
        }
    }

    // returns the data from a cell
    public String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            if (rowNum <= 0)
                return "";

            int index = workbook.getSheetIndex(sheetName);

            if (index == -1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                return "";
            cell = row.getCell(colNum);
            if (cell == null || cell.getCellTypeEnum() == CellType.BLANK)
                return "";
            else if (cell.getCellTypeEnum() == CellType.STRING)
                return cell.getStringCellValue();
            else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
                return cell.getRawValue();

            } else
                return String.valueOf(cell.getBooleanCellValue());

        } catch (Exception e) {

            e.printStackTrace();
            return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
        }
    }

    public int GetRowNum(String sheetName, String colName, String colvalue) {

        for (int i = 2; i <= getRowCount(sheetName); i++) {

            String tcid = getCellData(sheetName, colName, i);
            if (tcid.equalsIgnoreCase(colvalue)) {
                return i;
            }
        }
        return -1;

    }

    // returns the data from a cell
    public String getCellData(String sheetName, String colName, int rowNum) {
        try {
            if (rowNum <= 0)
                return "";

            int index = workbook.getSheetIndex(sheetName);
            int col_Num = -1;
            if (index == -1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            int c = getColumnCount(sheetName);

            for (int i = 0; i < c; i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
            if (col_Num == -1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                return "";
            cell = row.getCell(col_Num);

            if (cell == null || cell.getCellTypeEnum() == CellType.BLANK)
                return "";
            else if (cell.getCellTypeEnum() == CellType.STRING)
                return cell.getStringCellValue();
            else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
                return cell.getRawValue();

            } else
                return String.valueOf(cell.getBooleanCellValue());

        } catch (Exception e) {

            e.printStackTrace();
            return "row " + rowNum + " or column " + colName + " does not exist in xls";
        }

    }

    // find whether sheets exists
    public boolean isSheetExist(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            index = workbook.getSheetIndex(sheetName.toUpperCase());
            if (index == -1)
                return false;
            else
                return true;
        } else
            return true;
    }

    // returns number of columns in a sheet
    public int getColumnCount(String sheetName) {
        // check if sheet exists
        if (!isSheetExist(sheetName))
            return -1;

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);

        if (row == null)
            return -1;

        return row.getLastCellNum();

    }

    public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if (rowNum <= 0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if (index == -1)
                return false;

            sheet = workbook.getSheetAt(index);

            row = sheet.getRow(0);
            int c = getColumnCount(sheetName);
            for (int i = 0; i < c; i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName))
                    colNum = i;
            }
            if (colNum == -1)

                return false;

            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                row = sheet.createRow(rowNum - 1);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);

            cell.setCellValue(data);

            foup = new FileOutputStream(path);

            workbook.write(foup);

            foup.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}