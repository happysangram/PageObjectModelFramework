package com.accruent.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.accruent.base.TestBase;
import com.accruent.utilities.MonitoringMail;
import com.accruent.utilities.TestConfig;
import com.accruent.utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListners extends TestBase implements ITestListener,ISuiteListener {

	public void onTestStart(ITestResult result) {
	test=rep.startTest(result.getName().toUpperCase());
	//Checking RunMode
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output", "false");//Added for image link for ReportNg
		Reporter.log("CAPTURING SCREENSHOT");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("<a target=\"_blank\"href="+TestUtil.screenshotName+">Screenshot</a>");//add image link
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href="+TestUtil.screenshotName+" height=200 width=200></a>");//add image link
		
		TestBase.test.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");//Added for image link for ReportNg
		Reporter.log("CAPTURING SCREENSHOT");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("<a target=\"_blank\"href="+TestUtil.screenshotName+">Screenshot</a>");//add image link
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href="+TestUtil.screenshotName+" height=200 width=200></a>");//add image link
		
		
		//Extent Report
		TestBase.test.log(LogStatus.FAIL, result.getName().toUpperCase()+"FAIL");
		TestBase.test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		rep.endTest(test);
		rep.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
		MonitoringMail mail =new MonitoringMail();
		String messagebody = null;
		try {
			messagebody = "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/DataDrivenLive%20Project/Extent_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(messagebody);
		try {
			mail.sendMail(TestConfig.server,TestConfig.from, TestConfig.to, TestConfig.subject, messagebody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
