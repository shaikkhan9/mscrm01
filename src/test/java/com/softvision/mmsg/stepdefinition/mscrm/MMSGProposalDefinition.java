package com.softvision.mmsg.stepdefinition.mscrm;

import org.openqa.selenium.support.PageFactory;
import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.mscrm.MMSGProposalElements;

import cucumber.api.java.en.Then;

public class MMSGProposalDefinition extends BaseClass {

	MMSGProposalElements mpe = PageFactory.initElements(driver, MMSGProposalElements.class);

	
	@Then("^Click Create Proposal from NLQ Tab in Opporunity$")
	public void click_create_Proposal_from_NLQ_Tab_in_Opporunity() throws Throwable {
		mpe.createproposalfromNLQ();
	}
	
	@Then("^Open Proposal record from Proposal Tab$")
	public void open_Proposal_record_from_Proposal_Tab() throws Throwable {
		mpe.openProposalRecord();
	}

	@Then("^Complete Proposal in Opportunity$")
	public void complete_Proposal_in_Opportunity() throws Throwable {
		mpe.completeProposal();
	}
	
	
}