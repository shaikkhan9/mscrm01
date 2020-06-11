package com.softvision.mmsg.stepdefinition.mscrm;

import org.openqa.selenium.support.PageFactory;

import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGSettlementElements;

import cucumber.api.java.en.Then;

public class MMSGSettlementStepDefinition extends BaseClass {

	MMSGSettlementElements mste = PageFactory.initElements(driver, MMSGSettlementElements.class);

	@Then("^Navigate to Settlement in Opportunity$")
	public void navigate_to_Settlement_in_Opportunity() throws Throwable {
		mste.navigatetoSettlement();
	}

	@Then("^Open Settlement record in Settlement Tab$")
	public void open_Settlement_record_in_Settlement_Tab() throws Throwable {
		mste.openSettlementRecord();
	}

	@Then("^Complete Settlement in Opportunity$")
	public void complete_Settlement_in_Opportunity() throws Throwable {
		mste.completeSettlement();
	}

}