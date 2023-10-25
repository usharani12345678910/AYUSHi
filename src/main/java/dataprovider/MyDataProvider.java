package dataprovider;
 import org.testng.annotations.DataProvider;

import util.ExcelReader;

public class MyDataProvider{
	ExcelReader excelReader = new ExcelReader();

	@DataProvider(name = "createAccountByusingDataProvider")
	public Object[][] createAccountDataProvider() {
		
		// Totals rows count
		int rows = excelReader.getRowCount("Sheet2");
		// Total Columns
		int column = excelReader.getColumnCount("Sheet2");
		int actRows = rows - 1;
		// Created an object of array to store data
		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = excelReader.getCellData("Sheet2", j, i + 2);
			}
		}
		return data;
	}
}
