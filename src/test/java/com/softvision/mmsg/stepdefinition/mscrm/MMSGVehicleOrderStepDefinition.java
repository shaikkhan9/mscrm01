package com.softvision.mmsg.stepdefinition.mscrm;

import org.openqa.selenium.support.PageFactory;

import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGVehicleOrderElements;

import cucumber.api.java.en.Then;

public class MMSGVehicleOrderStepDefinition extends BaseClass {

	MMSGVehicleOrderElements mvoe = PageFactory.initElements(driver, MMSGVehicleOrderElements.class);

	@Then("^Navigate to Vehicle Order in Opportunity$")
	public void navigate_to_Vehicle_Order_in_Opportunity() throws Throwable {
		mvoe.navigatetoVO();
	}

	@Then("^Open Vehicle Order record in Vehicle Order Tab$")
	public void open_Vehicle_Order_record_in_Vehicle_Order_Tab() throws Throwable {
		mvoe.openVORecord();
	}

	@Then("^Complete Vehicle Order in Opportunity$")
	public void complete_Vehicle_Order_in_Opportunity() throws Throwable {
		mvoe.completeVO();
	}

	

}