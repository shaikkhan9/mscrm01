package com.softvision.mmsg.stepdefinition.mscrm;

import org.openqa.selenium.support.PageFactory;

import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGMDElements;

import cucumber.api.java.en.Then;

public class MMSGMDStepDefinition extends BaseClass {

	MMSGMDElements mmde = PageFactory.initElements(driver, MMSGMDElements.class);

	@Then("^Navigate to MD in Opportunity$")
	public void navigate_to_MD_in_Opportunity() throws Throwable {
		mmde.navigatetoMD();
	}

	@Then("^Open MD record in MD Tab$")
	public void open_MD_record_in_MD_Tab() throws Throwable {
		mmde.openMDRecord();
	}

	@Then("^Complete MD in Opportunity$")
	public void complete_MD_in_Opportunity() throws Throwable {
		mmde.completeMD();
	}

}