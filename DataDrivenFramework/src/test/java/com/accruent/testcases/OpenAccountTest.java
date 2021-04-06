package com.accruent.testcases;


import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.accruent.base.TestBase;
import com.accruent.utilities.TestUtil;


@Test(dataProviderClass = TestUtil.class,dataProvider = "dp")
public class OpenAccountTest extends TestBase {
	
	public void openAccountTest(String customer,String currency) throws InterruptedException {

		click("openaccount");
		select("customer",customer);
		select("currency",currency);
		click("process");
	    Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
	}
}
