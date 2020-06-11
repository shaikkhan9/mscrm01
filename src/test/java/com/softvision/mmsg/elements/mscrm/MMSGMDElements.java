package com.softvision.mmsg.elements.mscrm;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.softvision.mmsg.base.BaseClass;

public class MMSGMDElements extends BaseClass {
	
	private static String Agent_ID;
	
	@FindBy(xpath = "(//li[@title='Manage Docs'])[2]")
	private WebElement Btn_MDTab;
	@FindBy(xpath = "//span[contains(@class,'symbolFont More-symbol')]")
	private WebElement lbl_MoreTabs;
	
	@FindBy(xpath = "//span[@aria-label='Save']")
	private WebElement Btn_Save;
	
	public void navigatetoMD() throws InterruptedException{
		if(!isElementPresent(Btn_MDTab)){
			lbl_MoreTabs.click();
			wait(2);
			Btn_MDTab.click();
		}else{
			Btn_MDTab.click();
		}
		wait(10);
	}
	
	@FindBy(xpath = "//div[@data-id='cell-0-2']/a")
	private WebElement lbl_OpenMD;
	
	public void openMDRecord() throws InterruptedException {
		javascriptexecutor(lbl_OpenMD);
		wait(5);
	}

	@FindBy(xpath = "//input[@aria-label='Next Action Time']")
	private WebElement txt_NAT;
	@FindBy(xpath = "//input[@aria-label='Target Date']")
	private WebElement txt_TD;
	
	@FindBy(xpath = "(//div[@class='wj-form-control'])[2]")
	private WebElement lbl_YesOrNO;
	@FindBy(xpath = "//div[@wj-part='dropdown']/div[2]")
	private WebElement drp_Yes;
	@FindBy(xpath = "//span[@aria-label='Update Status']")
	private WebElement btn_UpdateSatus;
	@FindBy(xpath = "//span[.='Deactivate']")
	private WebElement btn_Deactivate;
	@FindBy(xpath = "(//div[@class='a bd flexbox'])[1]/a")
	private WebElement lbl_Opps;
	@FindBy(xpath = "//span[@aria-label='Refresh']")
	private WebElement Btn_Refresh;
	@FindBy(xpath = "//button[@data-id='OverflowButton']")
	private WebElement btn_extradropdown;
	
	
	
	
	public void completeMD() throws InterruptedException {
		
		txt_NAT.sendKeys(Keys.CONTROL + "a");
		txt_NAT.sendKeys(Keys.DELETE);
		wait(1);
		RequestedDate(txt_NAT);
		wait(1);
		RequestedDate(txt_TD);
		wait(1);
		javascriptexecutor(Btn_Save);
		wait(3);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='wj-cells']/div"));
		
		for(int i=0;i<(elements.size()-1);i++){
			WebElement lbl_Checklist = driver.findElement(By.xpath("//div[@data-id='cell-" + i + "-3']//label"));
			lbl_Checklist.click();
			wait(1);
			lbl_YesOrNO.click();
			wait(1);
			drp_Yes.click();
			wait(3);
		}
		javascriptexecutor(Btn_Save);
		wait(3);
		if(!isElementPresent(btn_UpdateSatus)){
			javascriptexecutor(btn_extradropdown);
			wait(2);
			javascriptexecutor(btn_UpdateSatus);
			wait(3);
			
		}else{
			javascriptexecutor(btn_UpdateSatus);
			wait(3);
		}
		
		btn_Deactivate.click();
		wait(8);
		javascriptexecutor(Btn_Refresh);
		wait(5);
		javascriptexecutor(lbl_Opps);
		wait(5);
		
		
	}
	
	public MMSGMDElements(WebDriver driver) {
		BaseClass.driver = driver;
	}
}