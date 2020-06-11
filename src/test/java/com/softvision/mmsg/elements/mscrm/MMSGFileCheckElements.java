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

public class MMSGFileCheckElements extends BaseClass {
	
	private static String Agent_ID;
	
	@FindBy(xpath = "(//li[@title='File Check'])[2]")
	private WebElement Btn_FCTab;
	@FindBy(xpath = "//span[@aria-label='Save']")
	private WebElement Btn_Save;
	
	public void navigatetoFC() throws InterruptedException{
		Btn_FCTab.click();
		wait(10);
	}
	
	@FindBy(xpath = "//div[@data-id='cell-0-2']/a")
	private WebElement lbl_OpenFC;
	
	public void openFCrecord() throws InterruptedException {
		javascriptexecutor(lbl_OpenFC);
		wait(5);
	}

	@FindBy(xpath = "//input[@aria-label='Next Action Time']")
	private WebElement txt_NAT;
	@FindBy(xpath = "//div[@class='wj-cells']")
	private WebElement tbl_Checklists;
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
	
	public void completeFC() throws InterruptedException {
		
		//txt_NAT.click();
		wait(2);
		txt_NAT.sendKeys(Keys.CONTROL + "a");
		txt_NAT.sendKeys(Keys.DELETE);
		wait(2);
		RequestedDate(txt_NAT);
		wait(2);
		javascriptexecutor(Btn_Save);
		wait(3);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='wj-cells']/div"));
		System.out.println("Number of Rows in check list are :"+(elements.size()-1));
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
		javascriptexecutor(btn_UpdateSatus);
		wait(3);
		btn_Deactivate.click();
		wait(8);
		javascriptexecutor(Btn_Refresh);
		wait(5);
		javascriptexecutor(lbl_Opps);
		wait(5);
		
		
	}
	
	public MMSGFileCheckElements(WebDriver driver) {
		BaseClass.driver = driver;
	}
}