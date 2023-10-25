package testscripts;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilites.Baseclass;

public class Test1  extends Baseclass{

	@Test(priority=2)
	//@Test(priority=1)
			public void getText() throws InterruptedException  {
				
		Thread.sleep(2000);
	logg.info("get the text of box");
				String titletext=obj.gettext().getText();
				System.out.println(titletext);
				Thread.sleep(2000);

		}
			@Test(priority=3)
			public void Sendkey() throws InterruptedException {
				Thread.sleep(2000);
				obj.getenterSendkeys().sendKeys("usha");
			
				Thread.sleep(2000);

		}
			@Test(priority=3)
			public void clickmethod() throws InterruptedException {
				Thread.sleep(2000);
				obj.getclickbutton().click();
			
			

		}
			@Test(priority=4)
			
			public void doubleclick() throws InterruptedException {
				Thread.sleep(2000);
				Actions act=new Actions(driver);
				act.doubleClick(obj.getdoubleclick()).build().perform();
			act.release();
			Alert alt=driver.switchTo().alert();
			alt.accept();
			Thread.sleep(2000);
			
			

		}
			@Test(priority=5)
			public void radiobutton() throws InterruptedException {
				Thread.sleep(2000);
				
				obj.Getfemaleradiobutton().click();
				
			boolean 	radiobutton=obj.Getfemaleradiobutton().isSelected();
			
			System.out.println(radiobutton);
			Thread.sleep(2000);

		}
			@Test(priority=6,groups="sainty")
			public void checkbox() throws InterruptedException {
				Thread.sleep(2000);
				
				obj.Getcheckbox().click();
				
			boolean 	checkbox=obj.Getcheckbox().isSelected();
			
			System.out.println(checkbox);
			Thread.sleep(2000);

		}
			@Test(priority=7,groups="smoke")
			public void dropdown() throws InterruptedException {
				Thread.sleep(2000);
				WebElement singleselect=obj.getdropdown();		
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
				
				obj.getgeneratealertbox1().click();
				
				Alert alt=driver.switchTo().alert();
				alt.accept();
				obj.getgeneratealertbox2().click();
				alt.dismiss();
			
				Thread.sleep(2000);

		}
			@Test(priority=9,enabled=false)
			public void drapanddropimage() throws InterruptedException {
				Thread.sleep(2000);
				WebElement source=obj.getdragsource();
				WebElement destination=obj.getdragDestination();
				Actions act=new Actions(driver);
				act.dragAndDrop(source, destination);
				act.release();
				System.out.println("yes");
				
				Thread.sleep(2000);
				
			}
			
			
			
		}
		
		
		
		


