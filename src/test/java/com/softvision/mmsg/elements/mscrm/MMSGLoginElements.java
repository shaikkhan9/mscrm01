package com.softvision.mmsg.elements.mscrm;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cucumber.listener.Reporter;
import com.softvision.mmsg.base.BaseClass;


public class MMSGLoginElements extends BaseClass {

	public void openMMSGCRMURL() {
		try {
			// System.out.println("Opening MMSG CRM");
			//URL = xlsreader.getCellData("ConfigurationData", "MMSGURL", xlsRow);
			driver.get(URL);
			Reporter.addScreenCaptureFromPath(getScreenshot());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception E) {
			E.printStackTrace();

		}
	}

	@FindBy(name = "loginfmt")
	private WebElement txt_uid;
	@FindBy(name = "passwd")
	private WebElement txt_pwd;
	@FindBy(name = "Password")
	private WebElement txt_pwd1;
	
	@FindBy(xpath = "//input[contains(@class,'btn-primary')]")
	private WebElement btn_next;
	@FindBy(xpath = "//input[contains(text(),Sign)]")
	private WebElement btn_Sign;

	@FindBy(xpath = "//div[contains(text(),'Stay signed in')]")
	private WebElement lbl_Stay_Signedin;
	@FindBy(xpath = "//input[@value='No']")
	private WebElement btn_no;
	@FindBy(xpath = "//td[contains(text(),'Pending email')]")
	private WebElement lbl_PendingEmail;
	// @FindBy(xpath = "//button[.='Close']")
	@FindBy(xpath = "//button[@id='butBegin']")
	private WebElement btn_Close;
	@FindBy(xpath = "//div[@id='otherTileText']")
	private WebElement btn_LoginAnotherAccount;
	@FindBy(xpath = "//iframe[starts-with(@src,'/Activities/')]")
	private WebElement btn_frameElement_Email;
	

	public void login1() {
		// System.out.println("Logging In To MMSG CRM");
		//openMMSGCRMURL();
		
		try {
			Reporter.addScreenCaptureFromPath(getScreenshot());
			if (iFramehandles() > 0) {
				WebElement frameElement_Email = driver
						.findElement(By.xpath("//iframe[starts-with(@src,'/Activities/')]")); 

				if (isElementPresent(btn_frameElement_Email)) {
					clickFrameElement("InlineDialog_Iframe", btn_Close);

				}
			}

		} catch (Exception e) {
		//System.out.println("Handling exception for emails notifications");	
		}
		
		if (isElementPresent(btn_Profilepic)) {
			btn_Profilepic.click();
			wait(1);
			btn_SignOut.click();
			wait(5);
		}
		
		if (isElementPresent(btn_Profilepic2)) {
			btn_Profilepic2.click();
			wait(1);
			btn_SignOut2.click();
			wait(5);
		}
		
		
		wait(2);
		if (isElementPresent(btn_LoginAnotherAccount)) {
			btn_LoginAnotherAccount.click();
		}
		txt_uid.sendKeys(xlsreader.getCellData("ConfigurationData", "MMSGUsername", xlsRow));
		wait(2);
		//btn_next.click();
		txt_uid.sendKeys(Keys.ENTER);
		wait(2);
		if (isElementPresent(txt_pwd)) {
			txt_pwd.sendKeys(xlsreader.getCellData("ConfigurationData", "MMSGPassword", xlsRow));
			wait(1);
			txt_pwd.sendKeys(Keys.ENTER);
		} else if (isElementPresent(txt_pwd1)) {
			txt_pwd1.sendKeys(xlsreader.getCellData("ConfigurationData", "MMSGPassword", xlsRow));
			wait(1);
			txt_pwd1.sendKeys(Keys.ENTER);
		}
		wait(1);
		//System.out.println(isElementPresent(lbl_Stay_Signedin));
		if (isElementPresent(lbl_Stay_Signedin)) {
			btn_no.click();

		}
		wait(1);
		try {
			if (iFramehandles() > 0) {
				WebElement frameElement_Email = driver
						.findElement(By.xpath("//iframe[starts-with(@src,'/Activities/')]")); 

				if (isElementPresent(btn_frameElement_Email)) {
					clickFrameElement("InlineDialog_Iframe", btn_Close);

				}
			}

		} catch (Exception e) {
		//System.out.println("Handling exception for emails notifications");	
		}
		

		wait(40);
	}

	

	public void login(String UN, String PWD) {
		// System.out.println("Logging In To Sigue CRM");
		//openMMSGCRMURL();
		
		if (isElementPresent(btn_Profilepic)){
			btn_Profilepic.click();
			wait(1);
			btn_SignOut.click();
		}
		
		if(isElementPresent(btn_LoginAnotherAccount)){
			btn_LoginAnotherAccount.click();
		}
		
		txt_uid.sendKeys(UN);
		btn_next.click();
		wait(2);
		if (isElementPresent(txt_pwd)) {
			txt_pwd.sendKeys(PWD);
			wait(1);
			txt_pwd.sendKeys(Keys.ENTER);
		}else if(isElementPresent(txt_pwd1)) {
			txt_pwd1.sendKeys(PWD);
			wait(1);
			txt_pwd1.sendKeys(Keys.ENTER);
		}
		
		wait(1);
		// System.out.println(isElementPresent(lbl_Stay_Signedin));
		if (isElementPresent(lbl_Stay_Signedin)) {
			btn_no.click();

		}
		wait(1);
		if (isElementPresent(btn_frameElement_Email)) {
			clickFrameElement("InlineDialog_Iframe", btn_Close);

		}
		wait(1);
	}
	
	@FindBy(xpath = "//span[.='Discard changes']")
	private WebElement lbl_DiscardChanges;
	@FindBy(xpath = "//span[@id='navTabButtonChangeProfileImageLink']/img")
	private WebElement btn_Profilepic;
	@FindBy(xpath = "//span[contains(@class,'symbolFont MembersIcon-symbol')]")
	private WebElement btn_Profilepic2;
	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	private WebElement btn_SignOut;
	@FindBy(xpath = "//span[contains(text(),'Sign out')]")
	private WebElement btn_SignOut2;

	public void Logout() {
		//System.out.println("Logging Out Of MMSG CRM");
		wait(5);
		
		if (isElementPresent(btn_Profilepic)) {
			btn_Profilepic.click();
			wait(2);
			btn_SignOut.click();
			wait(5);
		}
		
		if (isElementPresent(btn_Profilepic2)) {
			btn_Profilepic2.click();
			wait(2);
			btn_SignOut2.click();
			wait(5);
		}
		
		if (isElementPresent(lbl_DiscardChanges)) {
			lbl_DiscardChanges.click();
			wait(5);
		}
		
		
		
		
	}

	/*public void logoutSigueCRM() throws InterruptedException {
		SigueNowLoginElements snle = PageFactory.initElements(driver, SigueNowLoginElements.class);
		snle.logout();
	}*/
	
	
	@FindBy(xpath = "//span[@class='navTabButtonArrowDown']")
	private WebElement drp_ArrowDown1;
	@FindBy(xpath = "(//span[contains(@class,'symbolFont DropdownArrow-symbol')])[1]")
	private WebElement drp_ArrowDown2;
	
	
	@FindBy(xpath = "//span[.='MMSG Sales']")
	private WebElement lbl_MMSGSales;
	
	
	public void navigatetoUCImode() throws InterruptedException {
		wait(5);
		if(isElementPresent(drp_ArrowDown1)){
			drp_ArrowDown1.click();
		}else if(isElementPresent(drp_ArrowDown2)){
			drp_ArrowDown2.click();
		}
		wait(8);
		lbl_MMSGSales.click();
		wait(15);
		
	}
	
	

	public MMSGLoginElements(WebDriver driver) {
		BaseClass.driver = driver;
	}

}