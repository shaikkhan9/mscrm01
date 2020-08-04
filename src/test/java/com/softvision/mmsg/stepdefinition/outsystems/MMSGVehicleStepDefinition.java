package com.softvision.mmsg.stepdefinition.outsystems;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.outsystems.MMSGVehicleElements;

import cucumber.api.java.en.Then;

public class MMSGVehicleStepDefinition extends BaseClass {

	MMSGVehicleElements mve = PageFactory.initElements(driver, MMSGVehicleElements.class);

	@Then("^Navigate to Vehicle in Opportunity$")
	public void navigate_to_Vehicle_in_Opportunity() throws Throwable {
		mve.navigatetovehicle();
	    
	}
	
	@Then("^Click New Vehicle button$")
	public void click_New_Vehicle_button() throws Throwable {
	    mve.clickonNewVehicle();
	}

	@Then("^Navigate to Outsystems for vehicle creation$")
	public void navigate_to_outsystems_for_vehicle_creation() throws Throwable {
	    mve.navigatetoOutsystems();
	}
	
	@Then("^Navigate to Outsystems for NLQ Calculation$")
	public void navigate_to_outsystems_for_NLQ_Calculation() throws Throwable {
		mve.navigatetoOutsystemsforNLQCalculations();
	}
	
	
	@Then("^Enter Vehicle Details$")
	public void enter_Vehicle_Details() throws Throwable {
	    mve.entervehicledetatils("PS");
	}
	
	@Then("^Enter Dealer Quote for Vehicle$")
	public void enter_dealer_quote_for_vehicle() throws Throwable {
	    mve.enterdealerquotedetatils("Yes","Yes");
	}
	
	@Then("^Enter New Vehicle Details$")
	public void enter_New_Vehicle_Details() throws Throwable {
		 mve.entervehicledetatils("New");
	}

	@Then("^Enter Dealer Quote for New Vehicle$")
	public void enter_Dealer_Quote_for_New_Vehicle() throws Throwable {
		mve.enterdealerquotedetatils("Yes","No");
	}

	@Then("^Enter Used Vehicle Details$")
	public void enter_Used_Vehicle_Details() throws Throwable {
		 mve.entervehicledetatils("Used");
	}

	@Then("^Enter Dealer Quote for Used Vehicle$")
	public void enter_Dealer_Quote_for_Used_Vehicle() throws Throwable {
		mve.enterdealerquotedetatils("Yes","No");
	}

	@Then("^Enter PS Vehicle Details$")
	public void enter_PS_Vehicle_Details() throws Throwable {
		 mve.entervehicledetatils("PS");
	}

	@Then("^Enter Dealer Quote for PS Vehicle$")
	public void enter_Dealer_Quote_for_PS_Vehicle() throws Throwable {
		mve.entercapturevehiclecost();
	}

	@Then("^Enter SL Vehicle Details$")
	public void enter_SL_Vehicle_Details() throws Throwable {
		 mve.entervehicledetatils("SL");
	}

	@Then("^Enter Dealer Quote for SL Vehicle$")
	public void enter_Dealer_Quote_for_SL_Vehicle() throws Throwable {
		mve.entercapturevehiclecost();
	}

	@Then("^Enter RR Vehicle Details$")
	public void enter_RR_Vehicle_Details() throws Throwable {
		 mve.entervehicledetatils("RR");
	}

	@Then("^Enter Dealer Quote for RR Vehicle$")
	public void enter_Dealer_Quote_for_RR_Vehicle() throws Throwable {
		mve.entercapturevehiclecost();
	}
	
	@Then("^Enter Dealer Quote for Vehicle with procurment and dealer portal access$")
	public void enter_Dealer_Quote_for_Vehicle_with_procurment_and_dealer_portal_access() throws Throwable {
		mve.enterdealerquotedetatils("Yes","Yes");
	}

	@Then("^Enter Dealer Quote for Vehicle with out procurment and dealer portal access$")
	public void enter_Dealer_Quote_for_Vehicle_with_out_procurment_and_dealer_portal_access() throws Throwable {
		mve.enterdealerquotedetatils("No","No");
	}

	@Then("^Enter Dealer Quote for Vehicle with procurment and without dealer portal access$")
	public void enter_Dealer_Quote_for_Vehicle_with_procurment_and_without_dealer_portal_access() throws Throwable {
		mve.enterdealerquotedetatils("Yes","No");
	}

	@Then("^Enter Dealer Quote for Vehicle with out procurment and with dealer portal access$")
	public void enter_Dealer_Quote_for_Vehicle_with_out_procurment_and_with_dealer_portal_access() throws Throwable {
		mve.enterdealerquotedetatils("No","Yes");
	}
	
	
	
}