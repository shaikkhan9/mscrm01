package com.softvision.mmsg.elements.mscrm;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.softvision.mmsg.base.BaseClass;

public class MMSGProposalElements extends BaseClass {
	
	private static String Agent_ID;
	
	@FindBy(xpath = "//div[@data-id='cell-0-1']")
	private WebElement tk_SelectNLQ;
	@FindBy(xpath = "(//span[.='Create Proposal'])[2]")
	private WebElement lbl_CreateProposal;
	
	public void createproposalfromNLQ() throws InterruptedException{
		wait(5);
		tk_SelectNLQ.click();
		wait(5);
		lbl_CreateProposal.click();
		wait(5);
	}
	
	@FindBy(xpath = "//div[@data-id='cell-0-2']/a")
	private WebElement lbl_OpenProposal;
	@FindBy(xpath = "//div[@data-id='cell-1-2']/a")
	private WebElement lbl_OpenProposal2;
	
	public void openProposalRecord() throws InterruptedException{
		if(isElementPresent(lbl_OpenProposal2)){
			javascriptexecutor(lbl_OpenProposal2);
		}else if(isElementPresent(lbl_OpenProposal)){
			javascriptexecutor(lbl_OpenProposal);
		}
		wait(5);
	}
	
	@FindBy(xpath = "//button[@aria-label='More Header Fields']")
	private WebElement drp_moreheaderfields;
	@FindBy(xpath = "//select[contains(@data-id,'mms_statusreason')]")
	private WebElement drp_statusreasoncode;
	@FindBy(xpath = "//span[@aria-label='Save']")
	private WebElement Btn_Save;
	@FindBy(xpath = "//span[@aria-label='Refresh']")
	private WebElement Btn_Refresh;
	
	public void completeProposal() throws InterruptedException{
		/*javascriptexecutor(Btn_Refresh);
		wait(10);*/
		drp_moreheaderfields.click();
		wait(2);
		drp_statusreasoncode.click();
		selectByText(drp_statusreasoncode, "Proposal Sent");
		wait(2);
		javascriptexecutor(Btn_Save);
		wait(8);
		javascriptexecutor(Btn_Refresh);
		wait(5);
		drp_moreheaderfields.click();
		wait(2);
		drp_statusreasoncode.click();
		selectByText(drp_statusreasoncode, "Accepted");
		wait(5);
		javascriptexecutor(Btn_Save);
		wait(8);
	}
	
	
	
	public MMSGProposalElements(WebDriver driver) {
		BaseClass.driver = driver;
	}
}