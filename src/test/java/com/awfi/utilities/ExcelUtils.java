package com.awfi.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private String filePath;

	public ExcelUtils(String filePath) {
		this.filePath = filePath;
	}

	public String getCellValue(String sheetName, int rowNumber, int columnNumber) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(columnNumber);

		String cellValue = cell.getStringCellValue();

		fis.close();
		workbook.close();

		return cellValue;
	}

	public List<String> getRowData(String sheetName, int rowNumber) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);

		List<String> rowData = new ArrayList<>();
		for (Cell cell : row) {
			cell.setCellType(CellType.STRING);
			rowData.add(cell.getStringCellValue());
		}

		fis.close();
		workbook.close();

		return rowData;
	}
}
