package com.softvision.mmsg.stepdefinition.mscrm;

import org.openqa.selenium.support.PageFactory;
import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGContactElements;
import cucumber.api.java.en.Then;

public class MMSGContactStepDefinition extends BaseClass {

	MMSGContactElements mce = PageFactory.initElements(driver, MMSGContactElements.class);

	@Then("^Navigate to contact module$")
	public void navigate_to_contact_module() throws Throwable {
		mce.navigatetoContact();
	    
	}

	@Then("^Click New button on Contact module$")
	public void click_New_button_on_Contact_module() throws Throwable {
	    mce.clickNewbutton();
	}

	@Then("^Enter mandatory details on contact form$")
	public void enter_mandatory_details_on_contact_form() throws Throwable {
	    mce.enterMandatorydetailsinContact();
	    
	}
	
	/*@Then("^Click on Save button$")
	public void click_on_Save_button() throws Throwable {
		mce.clickSave();
	}*/
	
}