package utilites;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.Object1;



public class Baseclass {

	public Readconfig read=new Readconfig();
	public Object1 obj=new Object1( driver);
	public  static WebDriver driver;
	public static Logger logg;
	public static WebDriverWait wait=null;
	
	
	 
  	@BeforeClass
   
  	  public void setup() throws InterruptedException, FileNotFoundException, IOException {
  		
  		logg = Logger.getLogger("Selenium demo project");
  		PropertyConfigurator.configure("Log4j.properties");
  		
  	 
  	//cross browser testing
		
		
  			if(read.getdesiredbrowser().equals("chrome")) {
  				System.setProperty("webdriver.chrome.driver", read.getchropath());
  			  
  					 
  					 ChromeOptions options = new ChromeOptions();
  					 options.addArguments("--remote-allow-origins=*");
  					driver = new ChromeDriver(options);
  					
  			
  			}
  			else if(read.getdesiredbrowser().equals("firefox")) {
  				System.setProperty("webdriver.gecko.driver",read.getfirefoxpath());
  				 driver=new FirefoxDriver();	
  			}else if(read.getdesiredbrowser().equals("edge")) {
  				System.setProperty("webdriver.edge.driver",read.getiepath());
  				 driver=new EdgeDriver();
  				 
  			}
  
		
		driver.get(read.getapplicationurl());
		logg.info("url is login to website");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		logg.info("application url screen is maxmizied");
  	
  	}
		@BeforeMethod

		public void login() {

			
			
		  	  String expexctedtitle="This is sample text!";
		  	  // check the title of the appliation
		  	
		  	
		  	/*  String actualtitle=obj.gettext().getText();
		  	  System.out.println(actualtitle);
		  	 
		 Assert.assertEquals(actualtitle, expexctedtitle);
		 
			 logg.info("text title is verified");*/
			
			   } 
			
   
  
  	@Test(priority=1,groups= {"regression"})
	public void Sumbit() {
  		//test= extent.createTest(new Object(){}.getClass().getEnclosingMethod().getName())
			//	.assignAuthor("Murali Sukumar").assignCategory("Regression").assignDevice("Windows");
		obj.getsumbitbutton().click();
		//explicit wait
		 
		wait.until(ExpectedConditions.visibilityOf(obj.getsumbitbutton()));
		
	}
	

		
	@AfterMethod
	public void logout() throws InterruptedException{
		Thread.sleep(5000);
		
		
		
	}
		

	@AfterClass
	public void teardown() throws InterruptedException, IOException {
		Thread.sleep(5000);
		driver.close();
		


		
	}
	
  	 
  		  
  		  


	
	 
		


//screenshot method 
	public String getScreenhot() throws IOException {
		String timeStamp1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName1="scrrenshot"+timeStamp1+".png";
		String screenshotPath=  System.getProperty("user.dir")+"\\Screenshots\\"+ repName1;
		 TakesScreenshot src=(TakesScreenshot)driver;
	File	screenshot=src.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshot, new File(screenshotPath));
		return screenshotPath;
	}

	
}
