package com.softvision.mmsg.elements.mscrm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.softvision.mmsg.base.BaseClass;

import cucumber.api.java.en.Then;

public class MMSGContactElements extends BaseClass {
	
	private static String Agent_ID;
	private static String timestamp;
	private static char i= 'A';
	private static int count=0;
	
	@FindBy(xpath = "//span[text()='Customers']/..//../span[text()='Contacts']")
	private WebElement lbl_Contacts;
	@FindBy(xpath = "//span[text()='New']")
	private WebElement lnk_New;
	
	public void navigatetoContact() throws InterruptedException {
		//waitTillElementVisible(lbl_Opportunities);
		wait(5);
		javascriptscrolltoview(lbl_Contacts);
		javascriptexecutor(lbl_Contacts);
		wait(5);
	}
	
	public void clickNewbutton() throws InterruptedException {
		//waitTillElementVisible(lnk_New);
		wait(5);
		javascriptexecutor(lnk_New);
		wait(5);
	}
	
	@FindBy(xpath = "//select[contains(@data-id,'mms_title')]")
	private WebElement drp_Title;
	@FindBy(xpath = "(//input[contains(@data-id,'firstname')])[1]")
	private WebElement txt_FirstName;
	@FindBy(xpath = "//input[contains(@data-id,'lastname')]")
	private WebElement txt_LastName;
	@FindBy(xpath = "//input[contains(@data-id,'mobilephone')]")
	private WebElement txt_Mobile;
	@FindBy(xpath = "//input[contains(@data-id,'emailaddress1')]")
	private WebElement txt_Email;
	@FindBy(xpath = "//input[contains(@data-id,'emailaddress3')]")
	private WebElement txt_AlternateEmail;
	@FindBy(xpath = "//input[contains(@data-id,'emailaddress2')]")
	private WebElement txt_PersonalEmail;
	@FindBy(xpath = "//input[contains(@data-id,'address1_line1')]")
	private WebElement txt_Street1;
	@FindBy(xpath = "//input[contains(@data-id,'address1_line2')]")
	private WebElement txt_Street2;
	@FindBy(xpath = "//input[contains(@data-id,'address1_line3')]")
	private WebElement txt_Street3;
	@FindBy(xpath = "//input[contains(@data-id,'address1_city')]")
	private WebElement txt_Subrub;
	@FindBy(xpath = "//input[contains(@data-id,'address1_postalcode')]")
	private WebElement txt_Postalcode;
	@FindBy(xpath = "//input[contains(@data-id,'mms_stateid')]")
	private WebElement drp_State;
	
	
	public void enterMandatorydetailsinContact() throws InterruptedException {
		
		//String TimeStamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
		String FirstName = "Shaik ";
		String TimeStamp = "AhmedMaxxiaThirteen";
		
		 
			//TimeStamp = TimeStamp +i;
        
		
		ContactSearch = FirstName + TimeStamp;
		System.out.println("ContactSearch  "+ContactSearch);
		wait(2);
		drp_Title.click();
		selectByText(drp_Title, "Mr");
		
		
		EntervaluebyClick(txt_FirstName, txt_FirstName, FirstName);
		wait(1);
		EntervaluebyClick(txt_LastName, txt_LastName, TimeStamp);
		wait(1);
		EntervaluebyClick(txt_Mobile, txt_Mobile, "0498765423");
		wait(1);
		wait(1);
		txt_Mobile.sendKeys(Keys.TAB);
		javascriptscrolltoview(txt_AlternateEmail);
		wait(1);
		EntervaluebyClick(txt_Email, txt_Email, "Shaik.Fyjullah@mmsg.com.au");
		wait(1);
		EntervaluebyClick(txt_AlternateEmail, txt_AlternateEmail, "Shaik.Fyjullah@mmsg.com.au");
		wait(1);
		EntervaluebyClick(txt_PersonalEmail, txt_PersonalEmail, "Shaik.Fyjullah@mmsg.com.au");
		wait(1);
		txt_PersonalEmail.sendKeys(Keys.TAB);
		wait(1);
		
		javascriptscrolltoview(txt_Street2);
		wait(1);
		EntervaluebyClick(txt_Street2, txt_Street2, "Opp to National Dairy Development Board");
		wait(1);
		EntervaluebyClick(txt_Street1, txt_Street1, "72-86 Nathan Rd");
		wait(1);
		EntervaluebyClick(txt_Street3, txt_Street3, "Behind JNTU");
		wait(1);
		EntervaluebyClick(txt_Subrub, txt_Subrub, "Victoria");
		wait(1);
		EntervaluebyClick(txt_Postalcode, txt_Postalcode, "3175");
		wait(1);
		
		String State = "VIC";
		EntervaluebyClick(drp_State, drp_State, State);
		drp_State.sendKeys(Keys.ENTER);
		
		WebElement lbl_State =  driver.findElement(By.xpath("//span[.='" + State + "']"));
		DoubleClickbyMouse(lbl_State);
	
	}
	
	
	@FindBy(xpath = "//span[@aria-label='Save']")
	private WebElement Btn_Save;
	
	public void clickSave() throws InterruptedException {
		//waitTillElementVisible(Btn_Save);
		javascriptexecutor(Btn_Save);
		wait(3);
		clickSavenClose();
	}
	
	@FindBy(xpath = "//span[@aria-label='Save & Close']")
	private WebElement Btn_SavenClose;
	
	public void clickSavenClose() throws InterruptedException {
		javascriptexecutor(Btn_SavenClose);
		wait(5);
	}
	
	
	public MMSGContactElements(WebDriver driver) {
		BaseClass.driver = driver;
	}
}