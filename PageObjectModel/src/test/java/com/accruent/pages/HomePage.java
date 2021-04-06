package com.accruent.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.accruent.base.Page;

public class HomePage extends Page{
	
	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void goToSiteHome()
	{
		click("siteHome_XPATH");
	}
	
	public void goToMyHome()
	{
		click("myHome_XPATH");
	}
	
	public SignOffPage goToMyBookings() throws IOException
	{
		click("myBookings_XPATH");
		return new SignOffPage();
	}
}
