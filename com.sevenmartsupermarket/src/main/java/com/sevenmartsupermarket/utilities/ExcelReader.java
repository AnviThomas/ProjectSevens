package com.sevenmartsupermarket.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sevenmartsupermarket.constants.Constants;

public class ExcelReader {

	XSSFSheet sheet;
	XSSFWorkbook workbook;
	
	XSSFRow row;
	XSSFCell cell;
	
	public void setExcelFile(String WorkBookName , String SheetName)
	{
		try {
			String path=Constants.EXCEL_FILE_PATH+WorkBookName+".xlsx";
			File src = new File(path);
			FileInputStream fi = new FileInputStream(src);
workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(SheetName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public String getCellData(int rownum , int colnum)
	{
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		switch (cell.getCellType()) {
		case STRING: {
			String data;
			data = cell.getStringCellValue();
			return data;
		}
		case NUMERIC: {
			long d = (long) cell.getNumericCellValue();
			return String.valueOf(d);
		}

		default:
			return null;

		}
	}
}
