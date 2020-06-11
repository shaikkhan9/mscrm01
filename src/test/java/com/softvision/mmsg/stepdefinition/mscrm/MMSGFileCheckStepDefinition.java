package com.softvision.mmsg.stepdefinition.mscrm;

import org.openqa.selenium.support.PageFactory;

import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGFileCheckElements;

import cucumber.api.java.en.Then;

public class MMSGFileCheckStepDefinition extends BaseClass {

	MMSGFileCheckElements mfce = PageFactory.initElements(driver, MMSGFileCheckElements.class);

	@Then("^Navigate to FileCheck in Opportunity$")
	public void navigate_to_FileCheck_in_Opportunity() throws Throwable {
		mfce.navigatetoFC();
	}

	@Then("^Open FileCheck record in Filecheck Tab$")
	public void open_FileCheck_record_in_Filecheck_Tab() throws Throwable {
		mfce.openFCrecord();
	}

	@Then("^Complete FileCheck in Opportunity$")
	public void complete_FileCheck_in_Opportunity() throws Throwable {
		mfce.completeFC();
	}

}