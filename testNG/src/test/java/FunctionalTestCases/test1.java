package FunctionalTestCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class test1 {
	
	//SoftAssert aa=new SoftAssert();
	
	@BeforeSuite
	public void DBOpen() {
		System.out.println("Before Suite test1");
	}
	
	@BeforeTest
	public void BrowerOpen() {
		System.out.println("Before Test test1");
	}
	
	@BeforeMethod
	public void StartLog() {
		
		System.out.println("Start Logger test1");
	}
	
	@AfterMethod
	public void StopLog() {
		System.out.println("Stop Logger test1");	
	}
	
	@Test
	public void LogOff() {
		System.out.println("1st Test test1");
   
	}
	
	@Test(priority = 2,dependsOnMethods = "LogOff",alwaysRun = true)
	public void Login() {
		System.out.println("2nd Test test1");
	}
	
	@Test(priority = 3)
	public void ValidateUser() {
		System.out.println("3rd Test test1");
	}
    
	@AfterTest
	public void BrowerClose() {
		System.out.println("After Test test1");

	}
	
	
	@AfterSuite
	public void DBClose() {
		System.out.println("After Suite test1");
	}
}
