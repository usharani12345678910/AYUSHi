package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.Baseclass;

public class Object1 {

	public Object1(WebDriver driver){
	
			
			PageFactory.initElements(driver,this);
		}

	@FindBy(xpath="//b[text()='This is sample text!']") 
	WebElement gettext ;
	@FindBy(xpath="//button[text()='Submit']")
			WebElement sumbitbutton ;
	@FindBy(xpath="//input[@id='fname']")
	WebElement  enterSendkeysIntheFirstbox;
	@FindBy(xpath="//button[@id='idOfButton']")
	WebElement Methodclick  ;


			
	@FindBy(xpath="//button[@id='dblClkBtn")
	WebElement doubleclick ;
	
@FindBy(xpath="//input[@id='female']")
WebElement FemaleradioButton ;
@FindBy(xpath="(//input[@type='checkbox'])[1]")
WebElement Checkbox ;
@FindBy(id="testingDropdown")
WebElement Dropdown ;
@FindBy(xpath="(//button[contains(text(),'Generate ')])[position()=1]")
WebElement GenerateAlertbox1 ;
@FindBy(xpath="(//button[contains(text(),'Generate ')])[position()=2]")
WebElement GenerateAlertbox2 ;
@FindBy(id="targetDiv")
WebElement Dragsource ;
@FindBy(id="myImage")
WebElement DragDestination ;

	
	 /*@FindBy(xpath="//div[@class='dropdownContainer addNewMenu']") 
	List<WebElement> listofalldropdown ;*/
	public WebElement gettext() {
		return gettext;
		
		}
	public WebElement  getsumbitbutton() {
		return  sumbitbutton;
		}
	public WebElement getenterSendkeys() {
		return enterSendkeysIntheFirstbox;
		
		
		}
	public WebElement getclickbutton() {
		return Methodclick;
		
		}
	public WebElement  getdoubleclick() {
		return doubleclick ;
		}
	public WebElement  Getfemaleradiobutton() {
		return FemaleradioButton ;
		}
	public WebElement  Getcheckbox() {
		return Checkbox ;
		}
	public WebElement  getdropdown() {
		return Dropdown ;
		}
	public WebElement  getgeneratealertbox1() {
		return   GenerateAlertbox1;
		}
	public WebElement  getgeneratealertbox2() {
		return  GenerateAlertbox2;
		}
	public WebElement  getdragsource() {
		return  Dragsource ;
		}
	public WebElement  getdragDestination() {
		return  DragDestination;
		}
	
	
/*	public List<WebElement> getListofalldropdown() {
		return listofalldropdown;
	}*/

	
	}
