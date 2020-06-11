package com.softvision.mmsg.stepdefinition.mscrm;

import org.openqa.selenium.support.PageFactory;

import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGNLQElements;

import cucumber.api.java.en.Then;

public class MMSGNLQStepDefinition extends BaseClass {

	MMSGNLQElements mnlqe = PageFactory.initElements(driver, MMSGNLQElements.class);

	@Then("^Navigate to NLQ in Opportunity$")
	public void navigate_to_NLQ_in_Opportunity() throws Throwable {
		mnlqe.navigatetoNLQ();
	}

	@Then("^Click New NLQ button$")
	public void click_New_NLQ_button() throws Throwable {
		mnlqe.clickonNewNLQ();
	    
	}

	@Then("^Enter mandatory details in NLQ form$")
	public void enter_mandatory_details_in_NLQ_form() throws Throwable {
	    
		mnlqe.enterdetailsinNLQform();
	}
	
	@Then("^Click on Digital Estimate on NLQ$")
	public void click_on_digital_estimate_on_NLQ() throws Throwable {
		mnlqe.clickonDigitalEstimate();
	}
	
	@Then("^Open NLQ record in NLQ Tab$")
	public void open_NLQ_record_from_NLQ_Tab() throws Throwable {
		mnlqe.openNLQrecord();
	}
	
}