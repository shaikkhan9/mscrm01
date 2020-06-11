package com.softvision.mmsg.elements.mscrm;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.softvision.mmsg.base.BaseClass;

public class MMSGFinAppElements extends BaseClass {
	
	private static String Agent_ID;
	
	@FindBy(xpath = "(//li[@title='Fin App'])[2]")
	private WebElement Btn_FinAppTab;
	
	public void navigatetoFinApp() throws InterruptedException{
		Btn_FinAppTab.click();
		wait(5);
		
	}
	
	@FindBy(xpath = "(//span[.='New Finance Application'])[2]")
	private WebElement lbl_NewFinApp;
	
	public void clickonNewFinApp() throws InterruptedException{
		lbl_NewFinApp.click();
		wait(5);
		
	}
	
	@FindBy(xpath = "//input[contains(@data-id,'mms_novatedleasequote')]")
	private WebElement txt_NLQ;
	@FindBy(xpath = "//li[contains(@aria-label,'NLQ')][1]//label[1]")
	private WebElement lbl_NLQ;
	@FindBy(xpath = "//input[@aria-label='Financier Reference']")
	private WebElement txt_FinancierRef;
	
	public void enterdetailsinFinAppform() throws InterruptedException{
		txt_NLQ.click();
		txt_NLQ.sendKeys(Keys.ENTER);
		wait(2);
		DoubleClickbyMouse(lbl_NLQ);
		wait(2);
		EntervaluebyClick(txt_FinancierRef, txt_FinancierRef, "Financier Reference");
	}
	
	@FindBy(xpath = "//button[@aria-label='More Header Fields']")
	private WebElement drp_moreheaderfields;
	@FindBy(xpath = "//select[contains(@data-id,'mms_statusreason')]")
	private WebElement drp_statusreasoncode;
	@FindBy(xpath = "//span[@aria-label='Send Email - Financier']")
	private WebElement lbl_SendEmailFinanciers;
	
	@FindBy(xpath = "//input[contains(@data-id,'to')]")
	private WebElement txt_EmailTo;
	//@FindBy(xpath = "(//div[.='introducer@macquarie.com'])[2]")
	@FindBy(xpath = "(//div[contains(@data-id,'to')])[12]")
	private WebElement lbl_EmailToList;
	@FindBy(xpath = "//input[@aria-label='Lookup']")
	private WebElement txt_EmailtoList;
	@FindBy(xpath = "//span[@aria-label='Send']")
	private WebElement lbl_Send;
	@FindBy(xpath = "//span[@aria-label='Save']")
	private WebElement Btn_Save;
	@FindBy(xpath = "//span[.='Add']")
	private WebElement Btn_Add;
	@FindBy(xpath = "//span[@aria-label='Refresh']")
	private WebElement Btn_Refresh;
	@FindBy(xpath = "(//div[@class='a bd flexbox'])[1]/a")
	private WebElement lbl_Opps;
	
	
	
	public void completeFinApp() throws InterruptedException{
		wait(5);
		drp_moreheaderfields.click();
		wait(2);
		drp_statusreasoncode.click();
		selectByText(drp_statusreasoncode, "Completed by Customer");
		wait(2);
		javascriptexecutor(Btn_Save);
		wait(10);
		javascriptexecutor(lbl_SendEmailFinanciers);
		wait(10);
		
		ArrayList<String> al = new ArrayList<String>(driver.getWindowHandles());
		if (al.size() > 1) {
			driver.switchTo().window(al.get(1));
			wait(2);
			driver.manage().window().maximize();
			wait(2);
			txt_EmailTo.clear();
			
			/*String EmailSearch = "Shaik Fyjullah Ahmed";
			EntervaluebyClick(txt_EmailTo, txt_EmailTo, EmailSearch);
			txt_EmailTo.sendKeys(Keys.ENTER);
			WebElement lbl_Employer =  driver.findElement(By.xpath("//li[contains(@aria-label,'" + EmailSearch + "')][1]//label[1]"));
			DoubleClickbyMouse(lbl_Employer);*/
			
			
			String EmailSearch = "Shaik Fyjullah Ahmed";
			lbl_EmailToList.click();
			wait(2);
			txt_EmailtoList.sendKeys(Keys.CONTROL + "a");
			txt_EmailtoList.sendKeys(Keys.DELETE);
			wait(2);
			EntervaluebyClick(txt_EmailtoList, txt_EmailtoList, EmailSearch);
			txt_EmailtoList.sendKeys(Keys.ENTER);
			wait(2);
			WebElement lbl_Employer =  driver.findElement(By.xpath("//li[contains(@aria-label,'" + EmailSearch + "')][1]//label[1]"));
			DoubleClickbyMouse(lbl_Employer);
			Btn_Add.click();
			
			wait(2);
			javascriptexecutor(lbl_Send);
			wait(2);
			driver.switchTo().window(al.get(0));
			wait(20);
			javascriptexecutor(Btn_Refresh);
			wait(5);
			
			drp_moreheaderfields.click();
			wait(2);
			drp_statusreasoncode.click();
			selectByText(drp_statusreasoncode, "Approved");
			wait(2);
			javascriptexecutor(Btn_Save);
			wait(5);
			javascriptexecutor(lbl_Opps);
			wait(5);
			
		}
			
		
		
		
	}
	
	
	
	public MMSGFinAppElements(WebDriver driver) {
		BaseClass.driver = driver;
	}
}