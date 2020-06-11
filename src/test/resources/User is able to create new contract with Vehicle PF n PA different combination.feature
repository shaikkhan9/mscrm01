@OPPDEPNOVehiclePEnPA
Feature: User is able to create new contract with different combination of Vehicle Procurement fee and Portal access in CRM
  
 		@VehiclePF_PA_YES 
    Scenario: Create Opportunity with Non DEP and Vehicle Procurement fee, Portal access as yes Still Contract as Won
    Given User opens MMSG CRM URL
    When I enter username and password
    Then Navigate to UCI Mode
    Then Navigate to Opportunity module
    Then Click New button on Opportunity
    Then Enter mandatory details on Opportunity form
    Then Click on Save button
    
    Then Navigate to Profile in Opportunity
    Then Enter buy cycle value in profile
    Then Click on Save button
    Then Click on Refresh button
    
    Then Navigate to Vehicle in Opportunity
    Then Click New Vehicle button
    Then Navigate to Outsystems for vehicle creation
    Then Enter Vehicle Details
    Then Enter Dealer Quote for Vehicle with procurment and dealer portal access
    
    Then Click on Refresh button
    Then Navigate to NLQ in Opportunity
    Then Click New NLQ button
    Then Enter mandatory details in NLQ form
    Then Click on Save button
    Then Navigate to Outsystems for NLQ Calculation
    Then Click on Refresh button
    Then Click on Save and Close button
    
    Then Navigate to FinApp module
    Then Click on New Fin App
    Then Enter manadatory details on FinApp form
    Then Click on Save button
    Then Complete FinApp in Opportunity
    
    Then Navigate to NLQ in Opportunity
    Then Click Create Proposal from NLQ Tab in Opporunity
    Then Open Proposal record from Proposal Tab
    Then Complete Proposal in Opportunity
    Then Click on Save and Close button
    
    Then Navigate to AMO in Opportunity
    Then Open AMO record from AMO Tab
    Then Add AMO Line items in AMO form
    Then Click on Submit Order in AMO
    
    Then Navigate to NLQ in Opportunity
    Then Open NLQ record in NLQ Tab
    Then Navigate to Outsystems for NLQ Calculation
    Then Click on Refresh button
    Then Click on Save and Close button
    
    Then Click Create Proposal from NLQ Tab in Opporunity
    Then Open Proposal record from Proposal Tab
    Then Complete Proposal in Opportunity
    Then Click on Save and Close button
    
		
		Then Navigate to FileCheck in Opportunity
    Then Open FileCheck record in Filecheck Tab
    Then Complete FileCheck in Opportunity
   
    Then Navigate to Vehicle Order in Opportunity
    Then Open Vehicle Order record in Vehicle Order Tab
    Then Complete Vehicle Order in Opportunity
   
    Then Navigate to MD in Opportunity
    Then Open MD record in MD Tab
    Then Complete MD in Opportunity
   
    Then Navigate to Settlement in Opportunity
    Then Open Settlement record in Settlement Tab
    Then Complete Settlement in Opportunity
    And I Logged Out MMSG CRM



		@VehiclePF_No_PA_Yes
    Scenario: Create Opportunity with Non DEP and Vehicle Procurement fee as No, Portal access as yes Still Contract as Won
    Given User opens MMSG CRM URL
    When I enter username and password
    Then Navigate to UCI Mode
    Then Navigate to Opportunity module
    Then Click New button on Opportunity
    Then Enter mandatory details on Opportunity form
    Then Click on Save button
    
    Then Navigate to Profile in Opportunity
    Then Enter buy cycle value in profile
    Then Click on Save button
    Then Click on Refresh button
    
    Then Navigate to Vehicle in Opportunity
    Then Click New Vehicle button
    Then Navigate to Outsystems for vehicle creation
    Then Enter Vehicle Details
    Then Enter Dealer Quote for Vehicle with out procurment and with dealer portal access
    
    Then Click on Refresh button
    Then Navigate to NLQ in Opportunity
    Then Click New NLQ button
    Then Enter mandatory details in NLQ form
    Then Click on Save button
    Then Navigate to Outsystems for NLQ Calculation
    Then Click on Refresh button
    Then Click on Save and Close button
    
    Then Navigate to FinApp module
    Then Click on New Fin App
    Then Enter manadatory details on FinApp form
    Then Click on Save button
    Then Complete FinApp in Opportunity
    
    Then Navigate to NLQ in Opportunity
    Then Click Create Proposal from NLQ Tab in Opporunity
    Then Open Proposal record from Proposal Tab
    Then Complete Proposal in Opportunity
    Then Click on Save and Close button
    
    Then Navigate to AMO in Opportunity
    Then Open AMO record from AMO Tab
    Then Add AMO Line items in AMO form
    Then Click on Submit Order in AMO
    
    Then Navigate to NLQ in Opportunity
    Then Open NLQ record in NLQ Tab
    Then Navigate to Outsystems for NLQ Calculation
    Then Click on Refresh button
    Then Click on Save and Close button
    
    Then Click Create Proposal from NLQ Tab in Opporunity
    Then Open Proposal record from Proposal Tab
    Then Complete Proposal in Opportunity
    Then Click on Save and Close button
    
		
		Then Navigate to FileCheck in Opportunity
    Then Open FileCheck record in Filecheck Tab
    Then Complete FileCheck in Opportunity
   
    Then Navigate to Vehicle Order in Opportunity
    Then Open Vehicle Order record in Vehicle Order Tab
    Then Complete Vehicle Order in Opportunity
   
    Then Navigate to MD in Opportunity
    Then Open MD record in MD Tab
    Then Complete MD in Opportunity
   
    Then Navigate to Settlement in Opportunity
    Then Open Settlement record in Settlement Tab
    Then Complete Settlement in Opportunity
    And I Logged Out MMSG CRM




		@VehiclePF_Yes_PA_No
    Scenario: Create Opportunity with Non DEP and Vehicle Procurement fee as yes, Portal access as No Still Contract as Won
    Given User opens MMSG CRM URL
    When I enter username and password
    Then Navigate to UCI Mode
    Then Navigate to Opportunity module
    Then Click New button on Opportunity
    Then Enter mandatory details on Opportunity form
    Then Click on Save button
    
    Then Navigate to Profile in Opportunity
    Then Enter buy cycle value in profile
    Then Click on Save button
    Then Click on Refresh button
    
    Then Navigate to Vehicle in Opportunity
    Then Click New Vehicle button
    Then Navigate to Outsystems for vehicle creation
    Then Enter Vehicle Details
    Then Enter Dealer Quote for Vehicle with procurment and without dealer portal access
    
    Then Click on Refresh button
    Then Navigate to NLQ in Opportunity
    Then Click New NLQ button
    Then Enter mandatory details in NLQ form
    Then Click on Save button
    Then Navigate to Outsystems for NLQ Calculation
    Then Click on Refresh button
    Then Click on Save and Close button
    
    Then Navigate to FinApp module
    Then Click on New Fin App
    Then Enter manadatory details on FinApp form
    Then Click on Save button
    Then Complete FinApp in Opportunity
    
    Then Navigate to NLQ in Opportunity
    Then Click Create Proposal from NLQ Tab in Opporunity
    Then Open Proposal record from Proposal Tab
    Then Complete Proposal in Opportunity
    Then Click on Save and Close button
    
    Then Navigate to AMO in Opportunity
    Then Open AMO record from AMO Tab
    Then Add AMO Line items in AMO form
    Then Click on Submit Order in AMO
    
    Then Navigate to NLQ in Opportunity
    Then Open NLQ record in NLQ Tab
    Then Navigate to Outsystems for NLQ Calculation
    Then Click on Refresh button
    Then Click on Save and Close button
    
    Then Click Create Proposal from NLQ Tab in Opporunity
    Then Open Proposal record from Proposal Tab
    Then Complete Proposal in Opportunity
    Then Click on Save and Close button
    
		
		Then Navigate to FileCheck in Opportunity
    Then Open FileCheck record in Filecheck Tab
    Then Complete FileCheck in Opportunity
   
    Then Navigate to Vehicle Order in Opportunity
    Then Open Vehicle Order record in Vehicle Order Tab
    Then Complete Vehicle Order in Opportunity
   
    Then Navigate to MD in Opportunity
    Then Open MD record in MD Tab
    Then Complete MD in Opportunity
   
    Then Navigate to Settlement in Opportunity
    Then Open Settlement record in Settlement Tab
    Then Complete Settlement in Opportunity
    And I Logged Out MMSG CRM



		@VehiclePF_PA_No
    Scenario: Create Opportunity with Non DEP and Vehicle Procurement fee, Portal access as No Still Contract as Won
    Given User opens MMSG CRM URL
    When I enter username and password
    Then Navigate to UCI Mode
    Then Navigate to Opportunity module
    Then Click New button on Opportunity
    Then Enter mandatory details on Opportunity form
    Then Click on Save button
    
    Then Navigate to Profile in Opportunity
    Then Enter buy cycle value in profile
    Then Click on Save button
    Then Click on Refresh button
    
    Then Navigate to Vehicle in Opportunity
    Then Click New Vehicle button
    Then Navigate to Outsystems for vehicle creation
    Then Enter Vehicle Details
    Then Enter Dealer Quote for Vehicle with out procurment and dealer portal access
    
    Then Click on Refresh button
    Then Navigate to NLQ in Opportunity
    Then Click New NLQ button
    Then Enter mandatory details in NLQ form
    Then Click on Save button
    Then Navigate to Outsystems for NLQ Calculation
    Then Click on Refresh button
    Then Click on Save and Close button
    
    Then Navigate to FinApp module
    Then Click on New Fin App
    Then Enter manadatory details on FinApp form
    Then Click on Save button
    Then Complete FinApp in Opportunity
    
    Then Navigate to NLQ in Opportunity
    Then Click Create Proposal from NLQ Tab in Opporunity
    Then Open Proposal record from Proposal Tab
    Then Complete Proposal in Opportunity
    Then Click on Save and Close button
    
    Then Navigate to AMO in Opportunity
    Then Open AMO record from AMO Tab
    Then Add AMO Line items in AMO form
    Then Click on Submit Order in AMO
    
    Then Navigate to NLQ in Opportunity
    Then Open NLQ record in NLQ Tab
    Then Navigate to Outsystems for NLQ Calculation
    Then Click on Refresh button
    Then Click on Save and Close button
    
    Then Click Create Proposal from NLQ Tab in Opporunity
    Then Open Proposal record from Proposal Tab
    Then Complete Proposal in Opportunity
    Then Click on Save and Close button
    
		
		Then Navigate to FileCheck in Opportunity
    Then Open FileCheck record in Filecheck Tab
    Then Complete FileCheck in Opportunity
   
    Then Navigate to Vehicle Order in Opportunity
    Then Open Vehicle Order record in Vehicle Order Tab
    Then Complete Vehicle Order in Opportunity
   
    Then Navigate to MD in Opportunity
    Then Open MD record in MD Tab
    Then Complete MD in Opportunity
   
    Then Navigate to Settlement in Opportunity
    Then Open Settlement record in Settlement Tab
    Then Complete Settlement in Opportunity
    And I Logged Out MMSG CRM
    

    
    
