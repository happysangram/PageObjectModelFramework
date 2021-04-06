package com.accruent.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.accruent.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException, IOException {
		
		TestBase.verifyEquals("abc","xyz");
		
		log.debug("Test begins");
		//driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[1]/div[2]/button")).click();
		
		click("bmlBtn");
		//driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
		Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addCustBtn"))),"Login not successful.");
		log.debug("Test executed successfully");	
		//Assert.fail();
	}
	
}
