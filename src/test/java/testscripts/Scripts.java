package testscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilites.Baseclass;

public class Scripts  {

	
	 WebDriver driver ;

		@Test(priority=0)
		//public static void main(String[] args) {

		public void setup() {
			
			// TODO Auto-generated method stub

			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "");
			driver=new ChromeDriver();
			driver.get("https://artoftesting.com/samplesiteforselenium");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		}
		//@Test(priority=1)
		public void gettext() throws InterruptedException  {
			Thread.sleep(2000);
			String titletext=driver.findElement(By.xpath("//b[text()='This is sample text!']")).getText();
			System.out.println(titletext);
			Thread.sleep(2000);

	}
		@Test(priority=2)
		public void entersendkeys() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("usha");
		
			Thread.sleep(2000);

	}
		@Test(priority=3)
		public void clickmethod() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='idOfButton']")).click();
		
		

	}
		@Test(priority=4)
		
		public void doubleclick() throws InterruptedException {
			Thread.sleep(2000);
			Actions act=new Actions(driver);
			act.doubleClick(driver.findElement(By.xpath("//button[@id='dblClkBtn']"))).build().perform();
		act.release();
		Alert alt=driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		
		

	}
		@Test(priority=5)
		public void radiobutton() throws InterruptedException {
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@id='female']")).click();
			
		boolean 	radiobutton=driver.findElement(By.xpath("//input[@id='female']")).isSelected();
		
		System.out.println(radiobutton);
		Thread.sleep(2000);

	}
		@Test(priority=6,groups="sainty")
		public void checkbox() throws InterruptedException {
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
			
		boolean 	checkbox=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected();
		
		System.out.println(checkbox);
		Thread.sleep(2000);

	}
		@Test(priority=7,groups="smoke")
		public void dropdown() throws InterruptedException {
			Thread.sleep(2000);
			WebElement singleselect=driver.findElement(By.id("testingDropdown"));		
			Select oSel = new Select(singleselect);

					if(oSel.isMultiple()){
						
						//Selecting multiple values by index
						oSel.selectByIndex(0);
						

						//Or selecting by values
						
						oSel.selectByValue("Performance");

						//Or selecting by visible text
						
						oSel.selectByVisibleText("Manual Testing");
						List<WebElement> a=oSel.getOptions();
						int e=a.size();
						for(int  i=0;i<e;i++) {
							WebElement  s=a.get(i);
							String te=s.getText();
							System.out.println(te);
							Thread.sleep(2000);
						}
						
					}

	}
		@Test(priority=8,groups="regression")
		public void generatedalertbox() throws InterruptedException {
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("(//button[contains(text(),'Generate ')])[position()=1]")).click();
			
			Alert alt=driver.switchTo().alert();
			alt.accept();
			driver.findElement(By.xpath("(//button[contains(text(),'Generate ')])[position()=2]")).click();
			alt.dismiss();
		
			Thread.sleep(2000);

	}
		@Test(priority=9,enabled=false)
		public void drapanddropimage() throws InterruptedException {
			Thread.sleep(2000);
			WebElement source=driver.findElement(By.id("targetDiv"));
			WebElement destination=driver.findElement(By.id("myImage"));
			Actions act=new Actions(driver);
			act.dragAndDrop(source, destination);
			act.release();
			System.out.println("yes");
			
			Thread.sleep(2000);
			
		}
		
		
		
	}
	
	
	
	

