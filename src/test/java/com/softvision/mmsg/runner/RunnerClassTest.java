package com.softvision.mmsg.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.RetryAcceptance;
import cucumber.api.CucumberOptions;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/MMSG_Reports/cucumber.json",
						 retryCount =0,
                         detailedReport = true,
                         toPDF = true,
                         outputFolder = "target/MMSG_Reports/Extent-Report"
)
@CucumberOptions(plugin = { "html:target/MMSG_Reports/cucumber-html-report",
                 "json:target/MMSG_Reports/cucumber.json",
                 "pretty:target/MMSG_Reports/cucumber-pretty.txt",
                 "usage:target/MMSG_Reports/cucumber-usage.json",
                 "junit:target/MMSG_Reports/cucumber-results.xml",
                 "com.cucumber.listener.ExtentCucumberFormatter:target/MMSG_Reports/Cucumber-Extent-Report/mmsg-html-report.html" },
                 dryRun = false, 
                 features = {"src/test/resources"},
                 glue = {"com.softvision.mmsg.stepdefinition"},
                 tags = {"@OPPSDEPNO"},
                 monochrome = true
)

public class RunnerClassTest {
	
	public static int retries =0;
    public RunnerClassTest(){}
	@RetryAcceptance
	public static boolean retryCheck(Throwable e){
		// no re-run if error message contains "Configuration failed" phrase
		return !e.getMessage().contains("Configuration failed");
	}
	
	 @AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src/test/resources/configfiles/extent-config.xml"));

		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		
	}

}