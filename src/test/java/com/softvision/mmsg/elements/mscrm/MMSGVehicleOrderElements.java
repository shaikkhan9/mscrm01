package com.softvision.mmsg.elements.mscrm;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.softvision.mmsg.base.BaseClass;

public class MMSGVehicleOrderElements extends BaseClass {
	
	private static String Agent_ID;
	
	@FindBy(xpath = "(//li[@title='Vehicle Order'])[2]")
	private WebElement Btn_VOTab;
	@FindBy(xpath = "//span[@aria-label='Save']")
	private WebElement Btn_Save;
	
	public void navigatetoVO() throws InterruptedException{
		Btn_VOTab	.click();
		wait(10);
	}
	
	@FindBy(xpath = "//div[@data-id='cell-0-2']/label")
	private WebElement lbl_OpenVO;
	
	public void openVORecord() throws InterruptedException {
		DoubleClickbyMouse(lbl_OpenVO);
		wait(5);
	}

	@FindBy(xpath = "//input[@aria-label='Next Action Time']")
	private WebElement txt_NAT;
	@FindBy(xpath = "//input[@aria-label='Estimated Delivery Date']")
	private WebElement txt_EDD;
	@FindBy(xpath = "//input[@aria-label='Delivery Date']")
	private WebElement txt_DD;
	@FindBy(xpath = "(//div[contains(@aria-describedby,'mms_dealerinvoicereceived')]//label)[1]")
	private WebElement drp_DIR;
	@FindBy(xpath = "//span[@aria-label='Update Status']")
	private WebElement btn_UpdateSatus;
	@FindBy(xpath = "//span[.='Deactivate']")
	private WebElement btn_Deactivate;
	@FindBy(xpath = "(//div[@class='a bd flexbox'])[1]/a")
	private WebElement lbl_Opps;
	
	public void completeVO() throws InterruptedException {
		
		if(!drp_DIR.getText().equals("Yes")){
			drp_DIR.click();
		}
		
		txt_NAT.sendKeys(Keys.CONTROL + "a");
		txt_NAT.sendKeys(Keys.DELETE);
		wait(2);
		RequestedDate(txt_NAT);
		wait(2);
		
		javascriptexecutor(Btn_Save);
		wait(5);
		
		
		//txt_EDD.click();
		wait(2);
		/*txt_EDD.sendKeys(Keys.CONTROL + "a");
		txt_EDD.sendKeys(Keys.DELETE);
		wait(2);*/
		RequestedDate(txt_EDD);
		wait(2);
		
		//txt_DD.click();
		wait(2);
		/*txt_DD.sendKeys(Keys.CONTROL + "a");
		txt_DD.sendKeys(Keys.DELETE);
		wait(2);*/
		RequestedDate(txt_DD);
		wait(2);
		
		
		javascriptexecutor(Btn_Save);
		wait(5);
		javascriptexecutor(btn_UpdateSatus);
		wait(3);
		btn_Deactivate.click();
		wait(8);
		javascriptexecutor(lbl_Opps);
		wait(5);
		
		
	}
	
	public MMSGVehicleOrderElements(WebDriver driver) {
		BaseClass.driver = driver;
	}
}