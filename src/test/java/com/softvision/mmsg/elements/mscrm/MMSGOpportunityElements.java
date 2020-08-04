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

public class MMSGOpportunityElements extends BaseClass {
	
	private static String Agent_ID;
	private static String timestamp;
	
	@FindBy(xpath = "(//span[text()='Sales'])[1]")
	private WebElement lbl_Sales;
	@FindBy(xpath = "//span[text()='Sales']/..//../span[text()='Opportunities']")
	private WebElement lbl_Opportunities;
	@FindBy(xpath = "//span[text()='New']")
	private WebElement lnk_New;
	
	public void navigatetoOpportunity() throws InterruptedException {
		//waitTillElementVisible(lbl_Opportunities);
		wait(10);
		javascriptscrolltoview(lbl_Opportunities);
		javascriptexecutor(lbl_Opportunities);
		wait(5);
	}
	
	public void clickNewbutton() throws InterruptedException {
		//waitTillElementVisible(lnk_New);
		wait(5);
		javascriptexecutor(lnk_New);
		wait(10);
	}
	
	@FindBy(xpath = "//input[contains(@data-id,'parentcontactid')]")
	private WebElement txt_Contact;
	@FindBy(xpath = "//input[contains(@data-id,'parentaccountid')]")
	private WebElement txt_Account;
	@FindBy(xpath = "//select[contains(@data-id,'mms_payfrequency')]")
	private WebElement drp_PayFrequency;
	@FindBy(xpath = "//input[contains(@data-id,'mms_grossannualsalary')]")
	private WebElement txt_AnnualSalary;
	@FindBy(xpath = "//li[@title='Details']")
	private WebElement btn_DetailsTab;
	@FindBy(xpath = "//input[contains(@data-id,'mms_payrollid')]")
	private WebElement txt_PayrollID;
	@FindBy(xpath = "//select[contains(@data-id,'mms_currentsalarypackager')]")
	private WebElement drp_CurrentSalaryPackage;
	@FindBy(xpath = "(//span[.='OK'])[1]")
	private WebElement btn_Ok1;
	@FindBy(xpath = "//div[@id='modalDialogView_4']//../..//div[@id='buttonView']//button")
	private WebElement btn_Ok;
	
	
	
	
	public void enterMandatorydetailsinOpps() throws InterruptedException {
		System.out.println("ContactSearch  "+ContactSearch);
		
		
		try{
			if(Brand.equals("Maxxia")){
	        	EmployerSearch =  "Nikki Test";
	        	/*if(!ContactSearch.contains("2020")){
	        		ContactSearch  =  "Shaik Maxxia";
	        	}*/
	        	
	        }else if(Brand.equals("Remserv")){
	        	EmployerSearch ="Health - Queensland Health";
	        	/*if(!ContactSearch.contains("2020")){
	        		ContactSearch  = "Shaik Remserv";
	        	}*/
	        	
	        }
			
			
			//String EmployerSearch = "Nikki Test";
			EntervaluebyClick(txt_Account, txt_Account, EmployerSearch);
			txt_Account.sendKeys(Keys.ENTER);
			//WebElement lbl_Employer =  driver.findElement(By.xpath("//li[contains(@aria-label,'" + EmployerSearch + "')][1]//label[2]"));
			
			WebElement lbl_Employer =  driver.findElement(By.xpath("//span[.='" + EmployerSearch + "']"));
			
			DoubleClickbyMouse(lbl_Employer);
			
			wait(2);
			drp_PayFrequency.click();
			selectByText(drp_PayFrequency, "Fortnightly");
			wait(2);
			EntervaluebyClick(txt_AnnualSalary, txt_AnnualSalary, "1000000");
			
			
			//String ContactSearch = "Shaik Maxxia";
			EntervaluebyClick(txt_Contact, txt_Contact, ContactSearch);
			txt_Contact.sendKeys(Keys.ENTER);
			wait(2);
			WebElement lbl_Contact = driver.findElement(By.xpath("//span[contains(text(),'" + ContactSearch + "')]"));
			////li[@aria-label='Shaik Remserv']
			//(//li[contains(@aria-label,'" + ContactSearch + "')])[1]//span[2]   //this is for Shaik Maxxia or Shaik Remserv
			//((//li[contains(@aria-label,'" + ContactSearch + "')])[1]//span)[1]
			wait(2);
			DoubleClickbyMouse(lbl_Contact);
			
			
			btn_DetailsTab.click();
			wait(2);
			timestamp= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			EntervaluebyClick(txt_PayrollID, txt_PayrollID, "111"+timestamp);
			
			drp_CurrentSalaryPackage.click();
			
			if(Brand.equals("Maxxia")){
				selectByText(drp_CurrentSalaryPackage, "Maxxia");
			}else if(Brand.equals("Remserv")){
				selectByText(drp_CurrentSalaryPackage, "Remserv");
			}
			
			
		}catch(Exception e){
			System.out.println("I am inside Catch");
			System.out.println(e);
			
		}
		
		
		
		
	/*	
		lbl_State.click();
		selectByText(txt_State, "Illinois");
		
		EntervaluebyClick(lbl_LegalName, txt_LegalName, Agentname);*/
		
		//driver.switchTo().defaultContent();
	}
	
	
	@FindBy(xpath = "//span[@aria-label='Save']")
	private WebElement Btn_Save;
	
	public void clickSave() throws InterruptedException {
		//waitTillElementVisible(Btn_Save);
		javascriptexecutor(Btn_Save);
		if(isElementPresent(Btn_DDCancel)){
			Btn_DDCancel.click();
		}
		//wait(20);
		wait(3);
	}
	
	@FindBy(xpath = "//span[@aria-label='Save & Close']")
	private WebElement Btn_SavenClose;
	
	public void clickSavenClose() throws InterruptedException {
		javascriptexecutor(Btn_SavenClose);
		wait(5);
	}
	
	@FindBy(xpath = "//li[@title='Profiling']")
	private WebElement btn_ProfileTab;
	@FindBy(xpath = "//span[.='Proceed']")
	private WebElement Btn_DDProceed;
	@FindBy(xpath = "//span[.='Cancel']")
	private WebElement Btn_DDCancel;
	
	public void navigatetoprofile() throws InterruptedException {
		wait(15);
		btn_ProfileTab.click();
		wait(5);
	}
	
	@FindBy(xpath = "//select[contains(@data-id,'mms_buycyclecode')]")
	private WebElement drp_BuyCycle;
	
	public void enterbuycycle() throws InterruptedException {
		drp_BuyCycle.click();
		selectByText(drp_BuyCycle, "Shopping");
		wait(5);
	}
	
	
	@FindBy(xpath = "//span[@aria-label='Refresh']")
	private WebElement Btn_Refresh;
	
	public void clickRefresh() throws InterruptedException {
		//waitTillElementVisible(Btn_Refresh);
		wait(5);
		javascriptexecutor(Btn_Refresh);
		wait(5);
	}
	
	public MMSGOpportunityElements(WebDriver driver) {
		BaseClass.driver = driver;
	}
}