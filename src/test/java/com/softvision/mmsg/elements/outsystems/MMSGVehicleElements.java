package com.softvision.mmsg.elements.outsystems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.itextpdf.awt.geom.misc.RenderingHints.Key;
import com.itextpdf.text.log.SysoCounter;
import com.softvision.mmsg.base.BaseClass;

public class MMSGVehicleElements extends BaseClass {
	
	private static String Price;
	private static ArrayList<String> tabs;
	private static int model =1;
	
	@FindBy(xpath = "//li[@title='Vehicles']")
	private WebElement btn_VehicleTab;
	
	public void navigatetovehicle() throws InterruptedException {
		btn_VehicleTab.click();
		wait(3);
	}
	
	@FindBy(xpath = "//span[@aria-label='Create New Vehicle']")
	private WebElement btn_NewVehicle;
	
	public void clickonNewVehicle() throws InterruptedException {
		btn_NewVehicle.click();
		wait(35);
	}
	
	public void navigatetoOutsystems() throws InterruptedException {
		tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	   
	    
	    /*driver.close();
	    driver.switchTo().window(tabs.get(0));*/
	    
	}
	@FindBy(xpath = "(//div[.='Edit'])[8]")
	private WebElement lbl_Edit;
	@FindBy(xpath = "//select[contains(@name,'Vehicle_VehicleType')]")
	private WebElement drp_VehicleType;
	@FindBy(xpath = "//input[@name='UxMMSG_Theme_wt160$block$wtMainContent$WebPatterns_wt110$block$wtColumn2$wtPRVehicle_ColorExterior']")
	//@FindBy(xpath = "(//select[contains(@name,'PRVehicle_ColorExterior')])[1]")
	private WebElement txt_VehicleExteriorColor;
	@FindBy(xpath = "//input[@name='UxMMSG_Theme_wt160$block$wtMainContent$WebPatterns_wt83$block$wtColumn2$wtPRVehicle_ColorInterior']")
	//@FindBy(xpath = "(//select[contains(@name,'PRVehicle_ColorInterior')])[1]")
	private WebElement txt_VehicleInteriorColor;
	@FindBy(xpath = "(//img[@class='input-icon'])[1]")
	private WebElement btn_VehicleModel;
	@FindBy(xpath = "(//select[contains(@name,'Column1$wtcmbYear')])[1]")
	private WebElement drp_VehicleYear;
	@FindBy(xpath = "(//select[contains(@name,'Column2$wtcmbMakes')])[1]")
	private WebElement drp_VehicleMake;
	@FindBy(xpath = "(//select[contains(@name,'Column3$wtcmbModels')])[1]")
	private WebElement drp_VehicleModel;
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement rd_Vehicle;
	@FindBy(xpath = "(//td[9])[1]//span")
	private WebElement txt_VehiclePrice;
	@FindBy(xpath = "(//input[@value='SAVE'])[2]")
	private WebElement btn_VehicleSave;
	
	@FindBy(xpath = "(//input[contains(@name,'PRVehicle_ColorExterior3')])[1]")
	private WebElement txt_VehicleRN;
	@FindBy(xpath = "(//input[contains(@name,'PRVehicle_VIN')])[1]")
	private WebElement txt_VehicleVIN;
	@FindBy(xpath = "(//input[contains(@name,'PRVehicle_ColorExterior4')])[1]")
	private WebElement txt_VehicleEN;
	@FindBy(xpath = "//input[contains(@id,'Vehicle_vehicleAgeInMonth')]")
	private WebElement txt_VehicleAge;
	@FindBy(xpath = "//input[contains(@id,'PRVehicle_Odometer')]")
	private WebElement txt_VehicleOdometer;
	@FindBy(xpath = "//input[contains(@id,'CurrentLeaseEndDate')]")
	private WebElement txt_VehicleCLED;
	@FindBy(xpath = "(//input[@value='SAVE'])[1]")
	private WebElement btn_VehicleSave1;
	
	
	public void entervehicledetatils(String VehicleType) throws InterruptedException {
		lbl_Edit.click();
		wait(1);
		if(VehicleType.equals("New")){
			selectByText(drp_VehicleType, "New");
			wait(2);
		}else if(VehicleType.equals("Used")){
			selectByText(drp_VehicleType, "Used");
			wait(2);
		}else if(VehicleType.equals("PS")){
			selectByText(drp_VehicleType, "Private Sale");
			wait(2);
		}else if(VehicleType.equals("SL")){
			selectByText(drp_VehicleType, "Sale & Lease Back");
			wait(2);
		}else if(VehicleType.equals("RR")){
			selectByText(drp_VehicleType, "Residual Release");
			wait(2);
		}
		
		btn_VehicleModel.click();
		wait(5);
		selectByText(drp_VehicleYear, "2018");
		wait(10);
		selectByText(drp_VehicleMake, "HONDA");
		wait(10);
		//selectByText(drp_VehicleModel, "CITY");
		
		
		List<WebElement> elements = driver.findElements(By.xpath("(//select[contains(@name,'Column3$wtcmbModels')])[1]//option"));
		if(model>=elements.size()){
			model=1;
		}
		selectByIndex(drp_VehicleModel, model);
		model++;
		
		wait(10);
		rd_Vehicle.click();
		wait(5);
		Price = txt_VehiclePrice.getText();
		Price =Price.replaceAll("[$,]", "");
		Price=Price.replaceAll(".00", "");
		Price=Price.replaceAll(",", "").trim();
		System.out.println("Vehicle Price value  : "+Price);
		btn_VehicleSave.click();
		wait(10);
		txt_VehicleExteriorColor.sendKeys("White");
		txt_VehicleInteriorColor.sendKeys("Black");
		txt_VehicleRN.sendKeys("TPA642");
		txt_VehicleVIN.sendKeys("1GYEE63AX60219596");
		txt_VehicleEN.sendKeys("JKHG75JBJHGJ765");
		
		if(VehicleType.equals("Used") || VehicleType.equals("PS") || VehicleType.equals("SL") ){
			txt_VehicleAge.sendKeys("12");
			txt_VehicleOdometer.sendKeys("2500");
		}else if (VehicleType.equals("RR")){
			txt_VehicleAge.sendKeys("12");
			txt_VehicleOdometer.sendKeys("2500");
			RequestedDate(txt_VehicleCLED);
		}
		
		
		
		btn_VehicleSave1.click();
		wait(20);
	}
	
	@FindBy(xpath = "//span[.='Create New Quote Request']")
	private WebElement lbl_CreateDealerQuote;
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	private WebElement chk_Dealer1;
	@FindBy(xpath = "(//input[@type='checkbox'])[3]")
	private WebElement chk_Dealer2;
	@FindBy(xpath = "(//input[@value='SEND'])[1]")
	private WebElement btn_Send1;
	@FindBy(xpath = "(//input[contains(@name,'ProcurementFee')])[2]")
	private WebElement txt_ProcurementFee;
	@FindBy(xpath = "(//input[contains(@name,'ProcurementFee')])[1]")
	private WebElement txt_ProcurementFee1;
	@FindBy(xpath = "(//input[@value='SEND'])[2]")
	private WebElement btn_Send2;
	@FindBy(xpath = "//img[@title='Create Quote']")
	private WebElement btn_CreateQuote;
	@FindBy(xpath = "(//select[contains(@name,'QuoteRequest_RoadsideAssitance')])[1]")
	private WebElement drp_years;
	@FindBy(xpath = "(//select[contains(@name,'Column2$wtEDD2Timeframe')])[1]")
	private WebElement drp_DeliveryTF;
	@FindBy(xpath = "(//input[contains(@name,'VehicleListPrice_ciw')])[1]")
	private WebElement txt_Vlistprice;
	@FindBy(xpath = "(//input[contains(@name,'Column2_wttxtLessFleetDiscount_ciw')])[1]")
	private WebElement txt_VLessfleetDiscount;
	@FindBy(xpath = "(//input[contains(@name,'Column2_wttxtDeliveryCharges_ciw')])[1]")
	private WebElement txt_VDeliveryCharges;
	@FindBy(xpath = "(//input[contains(@name,'RegistrationFee_ciw')])[1]")
	private WebElement txt_VRegistrationFee;
	@FindBy(xpath = "(//input[contains(@name,'txtCTP_ciw')])[1]")
	private WebElement txt_VCTP;
	@FindBy(xpath = "(//input[contains(@name,'StampDuty_ciw')])[1]")
	private WebElement txt_StampDuty;
	@FindBy(xpath = "(//input[@value='SUBMIT'])[1]")
	private WebElement btn_Submit;
	@FindBy(xpath = "//img[@title='Shortlist']")
	private WebElement lbl_Shortlist;
	@FindBy(xpath = "//img[@title='Accepted by Customer']")
	private WebElement lbl_AcceptedbyCustomer;
	
	
	
	
	
	public void enterdealerquotedetatils(String PFee, String PortalAccess) throws InterruptedException {
		lbl_CreateDealerQuote.click();
		wait(2);
		if(chk_Dealer1.isSelected()){
			chk_Dealer1.click();
		}
		if(chk_Dealer2.isSelected()){
			chk_Dealer2.click();
		}
		
		selectDealer(PortalAccess);
		
		wait(5);
		btn_Send1.click();
		wait(2);
		String PFValue = txt_ProcurementFee.getAttribute("value");
		System.out.println("txt_ProcurementFee  :"+PFValue);
		
		
			if(PFee.equals("Yes")){
					txt_ProcurementFee1.clear();
					txt_ProcurementFee1.sendKeys("200");
			}else if(PFee.equals("No")){
				txt_ProcurementFee1.clear();
			}
			
		
			
		
		wait(2);
		btn_Send2.click();
		wait(5);
		btn_CreateQuote.click();
		wait(10);
		selectByText(drp_years, "5");
		selectByText(drp_DeliveryTF, "Deliver within 10 days");
		int x = Integer.parseInt(Price)-2000;
		txt_Vlistprice.sendKeys(Integer.toString(x));
		txt_VLessfleetDiscount.sendKeys("100");
		txt_VDeliveryCharges.sendKeys("100");
		txt_VRegistrationFee.sendKeys("100");
		txt_VCTP.sendKeys("100");
		txt_StampDuty.sendKeys("100");
		txt_StampDuty.sendKeys(Keys.TAB);
		wait(15);
		btn_Submit.click();
		wait(15);
		lbl_Shortlist.click();
		wait(25);
		lbl_AcceptedbyCustomer.click();
		wait(15);
		btn_VehicleSave1.click();
		wait(5);
		
		driver.close();
	    driver.switchTo().window(tabs.get(0));
	}
	
	
	public void selectDealer(String Bol){
		List<WebElement> dealercount = driver.findElements(By.xpath("//tr//td[6]//div"));
		List<WebElement> Tier1count;
		List<WebElement> Tier2count;
		try {
			Tier1count = driver.findElements(By.xpath("//img[@alt='Preferred Dealer Tier1']"));
		} catch (Exception e) {
			Tier1count = Collections.emptyList();
		}
		try {
			Tier2count = driver.findElements(By.xpath("//img[@alt='Preferred Dealer Tier2']"));
		} catch (Exception e) {
			Tier2count = Collections.emptyList();
		}
		
	/*	System.out.println("Tier1count.size() "+Tier1count.size());
		System.out.println("Tier2count.size() "+Tier2count.size());
		outerloop:
		for (int j = 1; j < Tier1count.size(); j++) {
			WebElement lbl_Tier1 = driver.findElement(By.xpath("(//img[@alt='Preferred Dealer Tier1'])[" + j + "]"));
			WebElement lbl_Tier1_Last = driver.findElement(By.xpath("(//img[@alt='Preferred Dealer Tier1'])[" + (Tier1count.size()-1) + "]"));
			String row = lbl_Tier1.getAttribute("data-row-index");
			String row1 = lbl_Tier1_Last.getAttribute("data-row-index");
			
			System.out.println("Row number of Tier1_Start : "+row);
			System.out.println("Row number of  Tier1_Last : "+row1);
			for (int i = Integer.parseInt(row); i < Integer.parseInt(row1); i++) {
				WebElement chk_Dealer = driver.findElement(By.xpath("//tr[" + i + "]//td[1]//input"));
				WebElement txt_PortalAccess = driver.findElement(By.xpath("//tr[" + i + "]//td[6]/div"));
				if (txt_PortalAccess.getText().equals(Bol)) {
					chk_Dealer.click();
					System.out.println("Check Box Details :   //tr[" + i + "]//td[1]//input");
					break outerloop;
				}
			}

		}
		
			outerloop1:
			for (int j = 1; j < Tier2count.size(); j++) {
				WebElement lbl_Tier1 = driver.findElement(By.xpath("(//img[@alt='Preferred Dealer Tier2'])[" + j + "]"));
				WebElement lbl_Tier1_Last = driver.findElement(By.xpath("(//img[@alt='Preferred Dealer Tier2'])[" + (Tier1count.size()-1) + "]"));
				String row = lbl_Tier1.getAttribute("data-row-index");
				String row1 = lbl_Tier1_Last.getAttribute("data-row-index");
				
				System.out.println("Row number of Tier2_Start : "+row);
				System.out.println("Row number of  Tier2_Last : "+row1);
				for (int i = Integer.parseInt(row); i < Integer.parseInt(row1); i++) {
					WebElement chk_Dealer = driver.findElement(By.xpath("//tr[" + i + "]//td[1]//input"));
					WebElement txt_PortalAccess = driver.findElement(By.xpath("//tr[" + i + "]//td[6]/div"));
					if (txt_PortalAccess.getText().equals(Bol)) {
						chk_Dealer.click();
						System.out.println("Check Box Details :   //tr[" + i + "]//td[1]//input");
						break outerloop1;
					}
				}

			}
		
		
		
		*/
		
		
		
		
		
		String Flag = "False";
		for (int i = 1; i < dealercount.size(); i++) {
			WebElement chk_Dealer = driver.findElement(By.xpath("//tr[" + i + "]//td[1]//input"));
			WebElement txt_PortalAccess = driver.findElement(By.xpath("//tr[" + i + "]//td[6]/div"));

			if (txt_PortalAccess.getText().equals(Bol)) {

				WebElement lbl_Tiers = driver.findElement(By.xpath("//tr[" + i + "]//td[4]//img"));
				String TName = lbl_Tiers.getAttribute("title");
				if (Tier1count.size() != 0) {
					if (TName.contains("Tier1")) {
						chk_Dealer.click();
						Flag = "True";
						System.out.println("Tier1 Check Box Details :   //tr[" + i + "]//td[1]//input");
						break;
					}
				}
				if (Tier1count.size() == 0) {
					if (TName.contains("Tier2")) {
						chk_Dealer.click();
						Flag = "True";
						System.out.println("Tier2 Check Box Details :   //tr[" + i + "]//td[1]//input");
						break;
					}
				}
			}
		}

		if (Flag.equals("False")) {
			for (int i = 1; i < dealercount.size(); i++) {
				WebElement chk_Dealer = driver.findElement(By.xpath("//tr[" + i + "]//td[1]//input"));
				WebElement txt_PortalAccess = driver.findElement(By.xpath("//tr[" + i + "]//td[6]/div"));

				if (txt_PortalAccess.getText().equals(Bol)) {

					WebElement lbl_Tiers = driver.findElement(By.xpath("//tr[" + i + "]//td[4]//img"));
					String TName = lbl_Tiers.getAttribute("title");
					if (Tier2count.size() != 0) {
						if (TName.contains("Tier2")) {
							chk_Dealer.click();
							Flag = "True";
							System.out.println("Tier2 Check Box Details :   //tr[" + i + "]//td[1]//input");
							break;
						}
					}

				}

			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		outerloop:
		for(int i=1;i<dealercount.size();i++){
			WebElement chk_Dealer = driver.findElement(By.xpath("//tr["+i+"]//td[1]//input"));
			WebElement txt_PortalAccess = driver.findElement(By.xpath("//tr["+i+"]//td[6]/div"));
			
			if(txt_PortalAccess.getText().equals(Bol)){
				for(int j=1;j<Tier1count.size();j++){
					//WebElement lbl_Tier1 = driver.findElement(By.xpath("(//img[@alt='Preferred Dealer Tier1'])["+j+"]"));
					chk_Dealer.click();
					System.out.println("Check Box Details :   //tr["+i+"]//td[1]//input");
					break outerloop;
				}
				for(int j=1;j<Tier2count.size();j++){
					//WebElement lbl_Tier2 = driver.findElement(By.xpath("(//img[@alt='Preferred Dealer Tier2'])["+j+"]"));
					chk_Dealer.click();
					System.out.println("Check Box Details :   //tr["+i+"]//td[1]//input");
					break outerloop;
				}
				
			}
			
		}
		*/
	}
	
	
	@FindBy(xpath = "//a[.='Capture vehicle cost details']")
	private WebElement lnk_CVCD;
	@FindBy(xpath = "//input[contains(@id,'ModalContent_wtTextVehicleExtGST_ciw')]")
	private WebElement txt_VEGST;
	@FindBy(xpath = "//input[contains(@id,'ModalContent_wtTextVehicleGST_ciw')]")
	private WebElement txt_VGST;
	@FindBy(xpath = "//input[contains(@id,'ModalContent_wtTextStampDutyDisbursement_ciw')]")
	private WebElement txt_SDD;
	@FindBy(xpath = "//input[contains(@id,'ModalContent_wtTextFBTValue_ciw')]")
	private WebElement txt_FBT;
	
	public void entercapturevehiclecost() throws InterruptedException {
		lnk_CVCD.click();
		wait(5);
		
		int x = Integer.parseInt(Price)-2000;
		txt_VEGST.sendKeys(Integer.toString(x));
		txt_VGST.sendKeys("200");
		txt_SDD.sendKeys("100");
		txt_FBT.sendKeys("100");
		wait(2);
		btn_VehicleSave.click();
		wait(10);
		lbl_Shortlist.click();
		wait(25);
		lbl_AcceptedbyCustomer.click();
		wait(15);
		btn_VehicleSave1.click();
		wait(5);
		driver.close();
	    driver.switchTo().window(tabs.get(0));
		
		
	}
	
	
	
	@FindBy(xpath = "//span[@aria-label='Open Calculator']")
	private WebElement btn_OpenCalculator;
	@FindBy(xpath = "(//select[contains(@name,'CmbVehicleTypeMaintenanceCost')])[1]")
	private WebElement drp_VMP;
	@FindBy(xpath = "(//select[contains(@name,'CmbFinancier')])[1]")
	private WebElement drp_Financier;
	@FindBy(xpath = "(//input[@value='Calculate'])[2]")
	private WebElement btn_Calculate;
	@FindBy(xpath = "(//input[@value='Save'])[1]")
	private WebElement btn_Save3;
	
	public void navigatetoOutsystemsforNLQCalculations() throws InterruptedException {
		
		javascriptexecutor(btn_OpenCalculator);
		wait(30);
		tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	   if(!drp_VMP.isSelected()){
		   selectByText(drp_VMP, "Medium");
	   }
	    
	   if(!drp_Financier.isSelected()){
		   selectByText(drp_Financier, "MacQuarie");
		    wait(5);
	   }
	    
	    btn_Calculate.click();
	    wait(5);
	    btn_Save3.click();
	    wait(5);
	    //driver.close();
	    driver.switchTo().window(tabs.get(0));
	    wait(2);
	    
	}
	
	
	public MMSGVehicleElements(WebDriver driver) {
		BaseClass.driver = driver;
	}
}