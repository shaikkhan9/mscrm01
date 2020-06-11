package com.softvision.mmsg.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;
import com.softvision.mmsg.base.BaseClass;
import com.softvision.mmsg.elements.BaseElements;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class BaseStepDefinition extends BaseClass {

    BaseElements be = PageFactory.initElements(driver, BaseElements.class);

    @Before
    public void beforeFTInitScenario(Scenario scenario) {
        // System.out.println("Running beforeFTInitScenario()");
        //System.out.println("Running Scenario (on " + instance + ")--> " + scenario.getName());

        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                analyzeLog("browser");
                analyzeLog("driver");
                /*System.out.println("Running beforeFTInitScenario shutdownHook(...)");
                System.out.println("Closing browser");*/
                be.closeBrowser();
                driver.quit();
            }
        });
    }

    @After
    public void afterFTInitScenario(Scenario scenario) throws IOException {
        // System.out.println("Running afterFTInitScenario()");
         System.out.println("Runned Scenario (on " + instance + ")--> " +scenario.getName()+" is  :  "+scenario.getStatus() );
        if (scenario.isFailed()) {
            try {
            	
                Reporter.addScreenCaptureFromPath(getScreenshot().toString());
                
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }

    @Then("^Wait for these seconds (\\d+)$")
    public void wait_for_these_seconds(int data) throws Throwable {
        be.wait(data);
    }
}