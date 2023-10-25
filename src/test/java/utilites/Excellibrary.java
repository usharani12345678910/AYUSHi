package utilites;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excellibrary {

	@Test(dataProvider="UserDetails")
		public void testRegister1(String Employeeid, String firstname,String lastname, String phonenumber,String address,String city, String state,String postercode, String country, String  username,String password ) throws InterruptedException{
			
			   
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRAVEENA\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
	  	// install the che driver
			 
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("--remote-allow-origins=*");
		WebDriver	driver = new ChromeDriver(options);		
					
			
			driver.get("https://demo.actitime.com/login.do");
			driver.findElement(By.id("username")).sendKeys(Employeeid);
			Thread.sleep(3000);
			driver.findElement(By.name("pwd")).sendKeys(firstname);
			Thread.sleep(3000);
			driver.findElement(By.id("username")).sendKeys(lastname);
			Thread.sleep(3000);
			driver.findElement(By.name("pwd")).sendKeys(phonenumber);
			Thread.sleep(3000);
			driver.findElement(By.id("username")).sendKeys(address);
			Thread.sleep(3000);
			driver.findElement(By.name("pwd")).sendKeys(password);
			Thread.sleep(3000);
			driver.findElement(By.id("username")).sendKeys(city);
			Thread.sleep(3000);
			driver.findElement(By.name("pwd")).sendKeys(state);
			Thread.sleep(3000);
			driver.findElement(By.id("username")).sendKeys(postercode);
			Thread.sleep(3000);
			driver.findElement(By.name("pwd")).sendKeys(username);
			Thread.sleep(3000);
			driver.findElement(By.name("pwd")).sendKeys(password);
			Thread.sleep(3000);
			
			
			
		System.out.println("yes");
			//driver.findElement(By.id("loginButton")).click();
//			Thread.sleep(5000);
			//driver.close();
			//Thread.sleep(2000);
			}	 		  
		

	@DataProvider (name="UserDetails")
	
	public Object[][] registerData() throws EncryptedDocumentException, IOException, InvalidFormatException     {
		
		
			FileInputStream fis=new FileInputStream("C:\\Users\\PRAVEENA\\OneDrive\\Desktop\\data.xlsx");
			Workbook	 wb=WorkbookFactory.create(fis);
				
			Sheet s=wb.getSheet("Sheet1");
	      int  rowcount=s.getLastRowNum();
	      System.out.println(rowcount);
	     int cellcount= s.getRow(0).getLastCellNum();
	     System.out.println(cellcount);
	     String input[][]=new String[rowcount][cellcount];
	    for(int i=1;i<rowcount;i++){
	    	
	    	 Row currentrow=s.getRow(i);
	    	 for( int j=0;j<cellcount;j++){
	    		 
	    		 Cell cell= currentrow.getCell(j);
	    		 if(cell != null) {
	    			 
	                	input[i-1][j] = cell.getStringCellValue();
	                }
	            }
	    }
		System.out.println("getting out from Data Provider registerData");
		return input;

	}

}
