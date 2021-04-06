package com.accruent.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.accruent.base.BaseTest;
import com.accruent.pages.LoginPage;

public class LoginValidation extends BaseTest {
	
	
	@Test
	public void logInValidation() throws InterruptedException, IOException 
	{
		LoginPage  hh=new LoginPage();
		hh.goToSignIn().goToMyBookings().goToSignOff();

	}

}
