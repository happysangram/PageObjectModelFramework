package com.accruent.pages;

import java.io.IOException;

import org.openqa.selenium.By;


import com.accruent.base.Page;

public class SignOffPage extends Page {
	
	
	public SignOffPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void goToSignOff()
	{
		click("userProfile_XPATH");
		click("signOffBtn_XPATH");
		
	}

}
