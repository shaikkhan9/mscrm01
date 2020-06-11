package com.softvision.mmsg.elements.mscrm;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.itextpdf.text.log.SysoCounter;
import com.softvision.mmsg.base.BaseClass;

public class MMSGNLQElements extends BaseClass {
	
	private static int vc =1;
	
	@FindBy(xpath = "//li[@title='NL Quotes']")
	private WebElement Btn_NLQTab;
	
	public void navigatetoNLQ() throws InterruptedException{
		Btn_NLQTab.click();
		wait(10);
	}
	
	@FindBy(xpath = "(//span[.='Add New Novated Lease Quote'])[2]")
	private WebElement lbl_NewNLQ;
	
	public void clickonNewNLQ() throws InterruptedException{
		lbl_NewNLQ.click();
		wait(5);
	}
	
	@FindBy(xpath = "//input[contains(@data-id,'mms_productid')]")
	private WebElement txt_Product;
	@FindBy(xpath = "//li[contains(@aria-label,'Fully Maintained Novated Lease')][1]//label[1]")
	private WebElement lbl_Product;
	@FindBy(xpath = "(//input[contains(@data-id,'mms_vehicle')])[1]")
	private WebElement txt_Vehicle;
	
	public void enterdetailsinNLQform() throws InterruptedException{
		txt_Product.click();
		txt_Product.sendKeys(Keys.ENTER);
		wait(2);
		DoubleClickbyMouse(lbl_Product);
		
		wait(2);
		
		txt_Vehicle.click();
		txt_Vehicle.sendKeys(Keys.ENTER);
		wait(2);
		List<WebElement> elements = driver.findElements(By.xpath("//li[contains(@aria-label,'VAN')]//label[1]"));
		if(vc>elements.size()){
			vc=1;
		}
		WebElement lbl_Vehicle = driver.findElement(By.xpath("//li[contains(@aria-label,'VAN')][" + vc + "]//label[1]"));
		vc++;
		wait(3);
		DoubleClickbyMouse(lbl_Vehicle);
		wait(5);
	}
	
	@FindBy(xpath = "//span[@aria-label='Publish Estimate']")
	private WebElement Btn_PE;
	@FindBy(xpath = "//span[.='Ok']")
	private WebElement Btn_OK;
	
	public void clickonDigitalEstimate() throws InterruptedException{
		javascriptexecutor(Btn_PE);
		wait(5);
		Btn_OK.click();
	}
	
	@FindBy(xpath = "//div[@data-id='cell-0-3']/label")
	private WebElement lbl_OpenNLQ;
	
	public void openNLQrecord() throws InterruptedException {
		wait(5);
		DoubleClickbyMouse(lbl_OpenNLQ);
		//javascriptexecutor(lbl_OpenNLQ);
		wait(8);
	}
	
	
	public MMSGNLQElements(WebDriver driver) {
		BaseClass.driver = driver;
	}
}