package com.softvision.mmsg.stepdefinition.mscrm;

import org.openqa.selenium.support.PageFactory;
import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGOpportunityElements;
import cucumber.api.java.en.Then;

public class MMSGOpportunityStepDefinition extends BaseClass {

	MMSGOpportunityElements moe = PageFactory.initElements(driver, MMSGOpportunityElements.class);

	@Then("^Navigate to Opportunity module$")
	public void navigate_to_Opportunity_module() throws Throwable {
		moe.navigatetoOpportunity();
	    
	}

	@Then("^Click New button on Opportunity$")
	public void click_New_button_on_Opportunity() throws Throwable {
		moe.clickNewbutton();
	    
	}

	@Then("^Enter mandatory details on Opportunity form$")
	public void enter_mandatory_details_on_Opportunity_form() throws Throwable {
		moe.enterMandatorydetailsinOpps();
	    
	}

	@Then("^Click on Save button$")
	public void click_on_Save_button() throws Throwable {
		moe.clickSave();
	}
	
	@Then("^Click on Save and Close button$")
	public void click_on_Save_and_Close_button() throws Throwable {
		moe.clickSavenClose();
	}
	
	@Then("^Navigate to Profile in Opportunity$")
	public void navigate_to_Profile_in_Opportunity() throws Throwable {
		moe.navigatetoprofile();
	    
	}
	
	
	@Then("^Enter buy cycle value in profile$")
	public void enter_buy_cycle_value_in_profile() throws Throwable {
		moe.enterbuycycle();
	    
	}
	
	@Then("^Click on Refresh button$")
	public void click_on_Refresh_button() throws Throwable {
		moe.clickRefresh();
	}
	
	
}