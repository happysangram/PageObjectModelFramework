package com.accruent.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.accruent.utilities.MonitoringMail;
import com.accruent.utilities.TestConfig;

public class GetHostAddress {
	
	public static void main(String[] args) throws UnknownHostException, AddressException, MessagingException {
		
		MonitoringMail mail =new MonitoringMail();
		String messagebody= "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/DataDrivenLive%20Project/Extent_20Report/";
		System.out.println(messagebody);
		mail.sendMail(TestConfig.server,TestConfig.from, TestConfig.to, TestConfig.subject, messagebody);
		Assert.assertEquals(false, false);
		SoftAssert aa=new SoftAssert();
		aa.assertEquals(false, false);
		aa.assertAll();

	}
	
	

}
