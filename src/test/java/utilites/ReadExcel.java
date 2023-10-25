package utilites;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

 public class	ReadExcel {
	    public String unicode;
	    public double[][] readExcel() throws IOException {
	        XSSFWorkbook excelObject = new XSSFWorkbook("C:\\Users\\PRAVEENA\\OneDrive\\Desktop\\data.xlsx");
	        XSSFSheet excelSheet = excelObject.getSheet("Sheet1");
	        
	        int rows = excelSheet.getLastRowNum();
	        int columns = excelSheet.getRow(0).getLastCellNum();
	        
	        double[][] data = new double [rows][columns];

	        for (int i = 1; i <= rows; i++) {
	            XSSFRow row = excelSheet.getRow(i);
	            for (int j = 0; j < columns; j++) {
	                XSSFCell cell = row.getCell(j);
	            /*    DataFormatter formatter = new DataFormatter();
	                

String empno = formatter.formatCellValue(cell);
	                data[i-1][j] = empno;*/
	                double cellValue = cell.getNumericCellValue();
	                data[i-1][j] = cellValue;
	            }
	        }
	    return data;
	    }
	    @DataProvider (name = "fetchData")
	    public String[][] getData() throws IOException {
	        ReadExcel excel = new ReadExcel();
	        return excel.readExcel();   
	    }
	    @Test(dataProvider = "fetchData")
	    public void signUpWithUnicode(String unicode) throws InterruptedException {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRAVEENA\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
			  	// install the che driver
					 
					 ChromeOptions options = new ChromeOptions();
					 options.addArguments("--remote-allow-origins=*");
				WebDriver 	driver = new ChromeDriver(options);
				driver.get("https://artoftesting.com/samplesiteforselenium");
	       
				driver.findElement(By.id("fname")).sendKeys(unicode);
	    }
	}