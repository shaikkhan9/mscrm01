package com.softvision.mmsg.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.log.SysoCounter;
import com.softvision.mmsg.util.Xlsreader;

import cucumber.api.Scenario;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings("deprecation")
public class BaseClass {

    protected static WebDriver driver;
    protected static Xlsreader xlsreader = new Xlsreader("src/test/resources/data/data.xlsx");
    protected static String browser = null;
    protected static String instance = null;
    protected static int xlsRow = 0;
    protected static String Brand ="Maxxia";
    protected static String ContactSearch= null;
    protected static String EmployerSearch= null;
     protected static String URL ="https://mmsg-qa.crm6.dynamics.com/main.aspx?appid=d785f640-7e6c-44fd-971b-9136eb1bbf6f";
    
    static {
        // DEFAULT = QA
        if (System.getProperty("instance") == (null)) {
            instance = "QA";
        } else {
            instance = System.getProperty("instance");
        }

        System.out.println("****** STARTING TEST ON " + instance + " ******");

        if (instance.equals("QA")) {
            xlsRow = 2;
        } else if (instance.equals("Sandpit")) {
            xlsRow = 3;
        } else if (instance.equals("PROD")) {
            xlsRow = 4;
        } 

        xlsreader.setCellData("MMSG_Info", "lastRunStartDateTime", xlsRow, new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
        xlsreader.setCellData("MMSG_Info", "instance", xlsRow, instance);

        browser = xlsreader.getCellData("ConfigurationData", "Browser", xlsRow);
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        	DesiredCapabilities caps = DesiredCapabilities.chrome();
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.BROWSER, Level.SEVERE);
            logPrefs.enable(LogType.DRIVER, Level.SEVERE);
            caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            // This size works well on local machine
            //options.addArguments("window-size=1024,768");
            // This size works well for remote VDI session
            //options.addArguments("window-size=900,700");
            options.addArguments("start-maximized");
            caps.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(caps);
        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/internetexplorerdriver.exe");
            driver = new InternetExplorerDriver();
        }
        
      }

    public void analyzeLog(String type) {
        String logType;
        String logFile;
        if (type.equals("driver")) {
            logType = LogType.DRIVER;
            logFile = "target/MMSG_Reports/driver-logs.log";
        } else {
            logType = LogType.BROWSER;
            logFile = "target/MMSG_Reports/browser-console-logs.log";
        }
        LogEntries logEntries = driver.manage().logs().get(logType);
        try {
            //System.out.println("Writing " + logType + " console logs to: " + logFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            // For testing browser console output to console
            // BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            for (LogEntry entry : logEntries) {
                writer.write(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
                writer.newLine();
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitTillElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        //return wait.until(ExpectedConditions.visibilityOf(element));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(toByVal(element)));
    }

    public WebElement waitTillElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void javascriptexecutor(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    
    public void javascriptmovetoelement(WebElement element){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].checked = true;", element);
    }
    
    public void javascriptscrolltoview(WebElement element){
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public boolean isElementPresentByJavaScriptExecutor(WebElement element) {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        try {
            Object obj = js.executeScript("return typeof(arguments[0]) != 'undefined' && arguments[0] != null;", element);
            if (obj.toString().contains("true")) {
                System.out.println("isElementPresentCheckUsingJavaScriptExecutor: SUCCESS");
                return true;
            } else {
                System.out.println("isElementPresentCheckUsingJavaScriptExecutor: FAIL");
            }

        } catch (NoSuchElementException e) {
            System.out.println("isElementPresentCheckUsingJavaScriptExecutor: FAIL");
        }
        return false;
    }
    
    public boolean isElementPresent(WebElement element){
        try{
        	element.isDisplayed();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public void clickFrameElement(String Frame, WebElement element )
    {
    	driver.switchTo().frame(driver.findElement(By.id(Frame)));
    	if(isElementPresent(element)){
    		element.click();
    	}
		driver.switchTo().defaultContent();
    }
    
    
    
    public void AlertAccept()
    {
    	Alert alert = driver.switchTo().alert();
    	String alertMessage= driver.switchTo().alert().getText();		
        System.out.println(alertMessage);	
        alert.accept();
    }
    public boolean isAlertPresent() 
    { 
        try 
        { 
            driver.switchTo().alert(); 
            return true; 
        }   // try 
        catch (NoAlertPresentException Ex) 
        { 
        	return false;
        }   // catch 
    } 
    
    public void windowhandles() {
        String mnhdle = driver.getWindowHandle();
        for (String childhdl : driver.getWindowHandles()) {
            driver.switchTo().window(childhdl);
            
        }
        driver.switchTo().window(mnhdle);
    }
    
    public int iFramehandles() {
    	wait(5);
    	String Framename = null ;
    	List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		//System.out.println("Total Size of Frame is		:	"+elements.size());
		
		for(WebElement ele:elements){
			//System.out.println(ele.getAttribute("id"));
			
			if(elements.size()>=4){
				Framename = "ClientApiFrame_2";
			}else{
				Framename = "contentIFrame0";
			}
			
		}
		return elements.size();
	}
    
   /* public List iFramehandles() {
    	wait(5);
    	Framename = null ;
    	List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		System.out.println("Total Size of Frame is		:	"+elements.size());
		List<String> FrameNames = null;
		for(WebElement ele:elements){
			
			if(!ele.getAttribute("id").isEmpty()){
				System.out.println("FrameID is "+ele.getAttribute("id")+" FrameName is "+ele.getAttribute("name"));	
				FrameNames.add(ele.getAttribute("id"));
			}
			
			if(elements.size()>=4){
				Framename = "ClientApiFrame_2";
			}else{
				Framename = "contentIFrame0";
			}
			
		}
		return elements;
	}*/
    

    public void wait(int seconds) {
        try {
            synchronized (driver) {
                seconds = (seconds * 1000);
                driver.wait(seconds);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

       
    public static void selectByIndex(WebElement element, int index) {
        Select st = new Select(element);
        st.selectByIndex(index);
    }

    public static void selectByText(WebElement element, String val) {
    	Select dropdown = new Select(element);
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(val)) {
                option.click();
                break;
            }
        }
    }
    
    public static void EntervaluebyClick(WebElement lbl_element,WebElement txt_element, String Val ) {
    	lbl_element.click();
    	txt_element.sendKeys(Val);
    }
    
    public static void selectByMouseClick(WebElement element) {
    	Actions actions = new Actions(driver);
		actions.moveToElement(element).click();
		actions.build().perform();
    }

    public static void DoubleClickbyMouse(WebElement element) {
    	Actions actions = new Actions(driver);
		actions.moveToElement(element).doubleClick();
		actions.build().perform();
    }
    
    public void RequestedDate(WebElement Element) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 1);
        String newDate = sdf.format(c.getTime());
        System.out.println("New Requested Date: " + newDate);
        //wait(5);
        Element.sendKeys(newDate);
        wait(5);
        
    }
    public static WebElement findElement(final By by) {

        return (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver d) {
                return d.findElement(by);
            }
        });
        
    }
    
    public String getScreenshot() throws IOException {
    	String timestamp= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    	String screenshotFileName = "target/MMSG_Reports/Cucumber-Extent-Report/"+timestamp+".png";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(screenshotFileName));
        System.out.println("Image is saving in below path : "+new File(screenshotFileName).toString());
        return timestamp+".png";
    }
    
    public By toByVal(WebElement Element) {
        // By format = "[foundFrom] -> locator: term"
        // see RemoteWebElement toString() implementation
       // String[] data = Element.toString().split(" -> ")[1].replace("]", "").split(": ");
        
    	String[] data;
    	try{
        	data = Element.toString().split(" -> ")[1].split(": ");
        	//System.out.println(Element +"   in try  "+data);
        }catch(Exception e){
        	data = Element.toString().split(" -> ")[0].split(": ");
        	//System.out.println(Element +"  in Catch   "+data);
        }
        
    	String locator = data[0];
        String term = data[1];
        
        if(term.endsWith("]")){
        	term = term.replaceAll("]$", "");
        }
        
        //System.out.println("Locator Value : "+locator+" Term Values  "+term);
        switch (locator) {
        case "xpath":
            return By.xpath(term);
        case "css selector":
            return By.cssSelector(term);
        case "id":
            return By.id(term);
        case "tag name":
            return By.tagName(term);
        case "name":
            return By.name(term);
        case "link text":
            return By.linkText(term);
        case "class name":
            return By.className(term);
        }
        return (By) Element;
    }
    
    
    
	public static String POST(String URL, Map<String, String> Header, String Body) {

		RestAssured.baseURI = URL;
		RequestSpecification request = RestAssured.given();
		System.out.println("\n===========================\nRequest is:\n===========================" + " \n "
				+ toPrettyFormat(Body));

		request.body(Body);

		Response response = request.headers(Header).post();
		String res_Formate;
		System.out.println("\n===========================\nResponse is:\n===========================");
		res_Formate = response.prettyPrint();

		return res_Formate;

	}
    
	public static String GET(String URL, Map<String, String> Header) {

		String UN = "UserName";
		String PWD = "PassWord";

		RestAssured.baseURI = URL;
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName(UN);
		authScheme.setPassword(PWD);
		RestAssured.authentication = authScheme;

		RequestSpecification request = RestAssured.given();
		Response response = request.headers(Header).get();

		String res_Formate;

		System.out.println("\n===========================\nResponse is:\n===========================");
		res_Formate = response.prettyPrint();

		return res_Formate;

	}
	
	public static String PATCH(String URL, Map<String, String> Header, String Body) {

		RestAssured.baseURI = URL;
		RequestSpecification request = RestAssured.given();
		System.out.println("\n===========================\nRequest is:\n===========================" + " \n "
				+ toPrettyFormat(Body));

		request.body(Body);

		Response response = request.headers(Header).patch();
		String res_Formate;
		System.out.println("\n===========================\nResponse is:\n===========================");
		res_Formate = response.prettyPrint();

		return res_Formate;

	}

	public static String DELETE(String URL, Map<String, String> Header, String Body) {

		RestAssured.baseURI = URL;
		RequestSpecification request = RestAssured.given();
		System.out.println("\n===========================\n DIS Request is:\n===========================" + " \n "
				+ toPrettyFormat(Body));

		request.body(Body);

		Response response = request.headers(Header).delete();
		String res_Formate;
		System.out.println("\n===========================\n DIS Response is:\n===========================");
		res_Formate = response.prettyPrint();

		return res_Formate;

	}
    
	public static String toPrettyFormat(String jsonString) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(jsonString).getAsJsonObject();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = gson.toJson(json);

		return prettyJson;
	}
    
}