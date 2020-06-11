package com.softvision.mmsg.stepdefinition.mscrm;

import org.openqa.selenium.support.PageFactory;
import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGAMOElements;

import cucumber.api.java.en.Then;

public class MMSGAMOStepDefinition extends BaseClass {

	MMSGAMOElements mamoe = PageFactory.initElements(driver, MMSGAMOElements.class);

	@Then("^Navigate to AMO in Opportunity$")
	public void navigate_to_AMO_in_Opportunity() throws Throwable {
		mamoe.navigatetoAMO();
	}

	@Then("^Open AMO record from AMO Tab$")
	public void open_AMO_record_from_AMO_Tab() throws Throwable {
		mamoe.openAMOrecord();
	}

	@Then("^Add AMO Line items in AMO form$")
	public void add_AMO_Line_items_in_AMO_form() throws Throwable {
		mamoe.addAMOLineItems();
	    
	}

	@Then("^Click on Submit Order in AMO$")
	public void click_on_Submit_Order_in_AMO() throws Throwable {
		mamoe.clickonSubmitOrder();
	}
	
}