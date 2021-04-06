package com.accruent.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.accruent.utilities.ExcelFile;
import com.accruent.utilities.ExtentManager;
import com.accruent.utilities.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Page {
	

	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties or=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static ExcelFile excel=new ExcelFile(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	
	
	public Page() throws IOException {
		if(driver==null) {
			
		fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		log.debug("config file loaded");
		fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		or.load(fis);
		
		
		if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()) {
			
			browser=System.getenv("browser");
		}else {
			browser=config.getProperty("browser");
		}
		config.setProperty("browser", browser);
		
		if(config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver=new ChromeDriver();
			log.debug("Chrome driver Initialization is done.");
		}
		else if(config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(config.getProperty("browser").equals("ie")) {
			System.setProperty("webdriver.edge.driver",  System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		}
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		log.debug("Maximize the screen");
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 5);
	}
	
public void click(String locator) {
		

		if(locator.endsWith("_CSS"))
		{
		driver.findElement(By.cssSelector(or.getProperty(locator))).click();
		}
		else if(locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(or.getProperty(locator))).click();
		}
		else if(locator.endsWith("_ID"))
		{
			driver.findElement(By.id(or.getProperty(locator))).click();
		}
		test.log(LogStatus.INFO, "Clickig on :" +locator);
		
	}
	
	public void type(String locator,String value) {
		

		if(locator.endsWith("_CSS")) 
		{
		driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
		}
		else if(locator.endsWith("_XPATH")) 
		{
			driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
		}
		else if(locator.endsWith("_ID")) 
		{
			driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
		}
		
		test.log(LogStatus.INFO, "Typing value: " + value);	
	}
	
	static WebElement dropDown;
	public void select(String locator,String value) {

		if(locator.endsWith("_CSS")) 
		{
			dropDown=driver.findElement(By.cssSelector(or.getProperty(locator)));
		    Select select=new Select(dropDown);
		    select.selectByVisibleText(value);
			}
		else if(locator.endsWith("_XPATH")) 
			{
				dropDown=driver.findElement(By.xpath(or.getProperty(locator)));
			    Select select=new Select(dropDown);
			    select.selectByVisibleText(value);
			}
		else if(locator.endsWith("_ID"))
		{
			dropDown=driver.findElement(By.id(or.getProperty(locator)));
		    Select select=new Select(dropDown);
		    select.selectByVisibleText(value);
			}
	      
		//test.log(LogStatus.INFO, "Selecting from DropDown: " + value);
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
			
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			return false;
		}
	}
	
	//Soft Assertion
	public static void verifyEquals(String expected,String actual) throws IOException {
		
		try {
			Assert.assertEquals(actual, expected);
		}catch (Throwable e) {
			TestUtil.captureScreenshot();
			
			//ReportNG
			Reporter.log("<br>"+"VErification failure :"+ e.getMessage()+"<br>");
			Reporter.log("<a target=\"_blank\"href="+TestUtil.screenshotName+" height=200 width=200></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			
			//Extent Reports
			Page.test.log(LogStatus.FAIL, "Verification failed with exception :" + e.getMessage());
			Page.test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		}
		
	}
	
	
	public static void quit() {
		
		if(driver!=null) {
			driver.quit();
	
		}
		log.debug("Test execution completed!!!");
		
	}

}
