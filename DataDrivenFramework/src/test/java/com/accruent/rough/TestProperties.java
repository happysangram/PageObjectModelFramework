package com.accruent.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.accruent.base.TestBase;
import com.accruent.utilities.TestUtil;
public class TestProperties {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		String dir=System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\msedgedriver.exe";     
		
		String dir1="C:\\Windows\\System32\\MicrosoftWebDriver.exe";
		System.out.println(dir);
    	System.setProperty("webdriver.edge.driver",  dir);
    	
//		EdgeOptions options = new EdgeOptions();
//		options.setCapability("useAutomationExtension", false);
//		URL hubUrl = new URL("http://wiqaseleniumhub.fmr.com:4444/wd/hub");
    	
    	//EdgeDriverService edgeService = EdgeDriverService.createDefaultService();
    	//edgeService.UseVerboseLogging = true;

    	//EdgeOptions edgeOptions = new EdgeOptions(); 
		EdgeDriver driver=new EdgeDriver();
        driver.get("https://www.facebook.com");
Thread.sleep(1000);
		

		

	}

}
