package com.softvision.mmsg.elements.outsystems;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.softvision.mmsg.base.BaseClass;

public class MMSGNLQCalculationElements extends BaseClass {
	
	@FindBy(xpath = "//span[text()=' Save ']")
	private WebElement Btn_Save;
	
	public void clickSave() throws InterruptedException{
		
	}
	
	public MMSGNLQCalculationElements(WebDriver driver) {
		BaseClass.driver = driver;
	}
}