package com.softvision.mmsg.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGLoginElements;

public class BaseElements extends BaseClass {

	MMSGLoginElements mle = PageFactory.initElements(driver, MMSGLoginElements.class);
	
    public void closeBrowser() {
        wait(5);
        mle.Logout();
        try{
        	driver.close();
        }catch(Exception e){
        	
        }
        
    }

    public BaseElements(WebDriver driver) {
        BaseClass.driver = driver;
    }
}
