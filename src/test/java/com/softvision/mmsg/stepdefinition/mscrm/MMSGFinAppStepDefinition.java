package com.softvision.mmsg.stepdefinition.mscrm;

import org.openqa.selenium.support.PageFactory;
import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGFinAppElements;

import cucumber.api.java.en.Then;

public class MMSGFinAppStepDefinition extends BaseClass {

	MMSGFinAppElements mfae = PageFactory.initElements(driver, MMSGFinAppElements.class);

	@Then("^Navigate to FinApp module$")
	public void navigate_to_FinApp_module() throws Throwable {
		mfae.navigatetoFinApp();
	    
	}

	@Then("^Click on New Fin App$")
	public void click_on_New_Fin_App() throws Throwable {
		mfae.clickonNewFinApp();
	}

	@Then("^Enter manadatory details on FinApp form$")
	public void enter_manadatory_details_on_FinApp_form() throws Throwable {
		mfae.enterdetailsinFinAppform();
	}
	
	@Then("^Complete FinApp in Opportunity$")
	public void complete_finapp_in_Opportunity() throws Throwable {
		mfae.completeFinApp();
	}
	
	
	
}