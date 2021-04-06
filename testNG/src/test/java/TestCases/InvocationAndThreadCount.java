package TestCases;

import org.testng.annotations.Test;

public class InvocationAndThreadCount {
	
	
	@Test(invocationCount = 100,threadPoolSize = 5)
	public void test() {
		System.out.println("Login browser");
	}

}
