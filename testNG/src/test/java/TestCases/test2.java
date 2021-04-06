package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test2 {
	
	@BeforeTest
	public void BrowerOpen() {
		System.out.println("Before Test test2");
	}
	
	@BeforeMethod
	public void StartLog() {
		System.out.println("Start Logger test2");
	}
	
	@AfterMethod
	public void StopLog() {
		System.out.println("Stop Logger test2");
	}
	
	@Test(priority = 2)
	
	public void Login() {
		System.out.println("2nd Test test2");
	}
	
	@Test(priority = 3)
	public void ValidateUser() {
		System.out.println("3rd Test test2");
	}
    
	@Test
	public void LogOff() {
		System.out.println("1st Test test2");
	}
	
	@AfterTest
	public void BrowerClose() {
		System.out.println("After Test test2");
	}

}
