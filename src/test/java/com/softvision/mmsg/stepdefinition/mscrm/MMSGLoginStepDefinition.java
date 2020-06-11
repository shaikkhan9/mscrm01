package com.softvision.mmsg.stepdefinition.mscrm;

import org.openqa.selenium.support.PageFactory;

import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGLoginElements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class MMSGLoginStepDefinition extends BaseClass {

	MMSGLoginElements sle = PageFactory.initElements(driver, MMSGLoginElements.class);

	@Given("^User opens MMSG CRM URL$")
	public void user_opens_MMSG_CRM_URL() throws Throwable {
		sle.openMMSGCRMURL();
	}

	@When("^I enter username and password$")
	public void i_enter_username_and_password() throws Throwable {
		sle.login1();
	}

	@When("^I Logged Out MMSG CRM$")
	public void i_Logged_Out_MMSG_CRM() throws Throwable {
		sle.Logout();

	}

	@Then("^Navigate to UCI Mode$")
	public void navigate_to_UCI_Mode() throws Throwable {
		sle.navigatetoUCImode();

	}

}