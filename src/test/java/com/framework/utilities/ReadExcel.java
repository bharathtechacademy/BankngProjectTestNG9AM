package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	//will have common method to read data from excel files

	public static String[][] readData(String workbookName, String sheetName) {
		String[][] data = null;

		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + workbookName); //read excel file
			XSSFWorkbook wb = new XSSFWorkbook(fis); // pass file to workbook class
			XSSFSheet sh = wb.getSheet(sheetName); // read specific sheet from the workbook
			int totalRows = sh.getPhysicalNumberOfRows(); //get total rows having data 
			int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();//get total columns in each row (row 1)
			data = new String[totalRows - 1][totalColumns]; // initiating the array with size as total rows - 1 because 1 row having column names
			for (int r = 1; r < totalRows; r++) {
				for (int c = 0; c < totalColumns; c++) {
					data[r - 1][c] = sh.getRow(r).getCell(c).getStringCellValue(); //get the  data from specific sheet, specific row, specific column and convert it as string
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

}
