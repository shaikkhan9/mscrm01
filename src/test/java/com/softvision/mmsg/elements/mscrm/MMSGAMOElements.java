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

public class MMSGAMOElements extends BaseClass {
	
	private static int PC=1;
	
	@FindBy(xpath = "//li[@title='Aftermarket']")
	private WebElement Btn_AMOTab;
	
	public void navigatetoAMO() throws InterruptedException{
		Btn_AMOTab.click();
		wait(8);
	}

	@FindBy(xpath = "//div[@data-id='cell-0-2']/a")
	private WebElement lbl_OpenAMO;
	
	
	public void openAMOrecord() throws InterruptedException {
		javascriptexecutor(lbl_OpenAMO);
		wait(10);
		txt_NAT.click();
		txt_NAT.sendKeys(Keys.CONTROL + "a");
		txt_NAT.sendKeys(Keys.DELETE);
		wait(2);
		RequestedDate(txt_NAT);
		wait(2);
		javascriptexecutor(Btn_Save);
		wait(5);
	}

	@FindBy(xpath = "(//span[.='New After Market Order Line'])[2]")
	private WebElement lbl_NewAMOLineItems;
	@FindBy(xpath = "(//input[contains(@data-id,'mms_product')])[1]")
	private WebElement txt_AMOLineProduct;
	@FindBy(xpath = "//span[@aria-label='Save & Close']")
	private WebElement Btn_SavenClose;
	
	public void addAMOLineItems() throws InterruptedException {
		lbl_NewAMOLineItems.click();
		wait(5);
		txt_AMOLineProduct.click();
		txt_AMOLineProduct.sendKeys(Keys.ENTER);
		wait(2);
		
		List<WebElement> elements = driver.findElements(By.xpath("//ul[contains(@id,'mms_productid')]//li"));
		if(PC>=elements.size()){
			PC=1;
		}
		WebElement lbl_AMOLineProduct = driver.findElement(By.xpath("//li["+PC+"]//label[1]"));
		PC++;
		wait(3);
		DoubleClickbyMouse(lbl_AMOLineProduct);
		wait(2);
		javascriptexecutor(Btn_SavenClose);
		wait(5);
		
	}

	@FindBy(xpath = "//span[@aria-label='Submit Order']")
	private WebElement Btn_SubmitOrder;
	@FindBy(xpath = "//input[@aria-label='Next Action Time']")
	private WebElement txt_NAT;
	@FindBy(xpath = "//span[@aria-label='Save']")
	private WebElement Btn_Save;
	@FindBy(xpath = "(//div[@class='a bd flexbox'])[1]/a")
	private WebElement lbl_Opps;
	
	
	public void clickonSubmitOrder() throws InterruptedException {
		/*txt_NAT.click();
		txt_NAT.sendKeys(Keys.CONTROL + "a");
		txt_NAT.sendKeys(Keys.DELETE);
		wait(2);
		RequestedDate(txt_NAT);*/
		wait(2);
		javascriptexecutor(Btn_Save);
		wait(3);
		javascriptexecutor(Btn_SubmitOrder);
		wait(40);
		javascriptexecutor(lbl_Opps);
		wait(5);
	}
 
	public MMSGAMOElements(WebDriver driver) {
		BaseClass.driver = driver;
	}
}