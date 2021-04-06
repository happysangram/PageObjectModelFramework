package TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestParameter {
	
	@Parameters({"browser","env"})
	@Test
	public void login(String browser,String env) {
		
		System.out.println(browser+"-------------->"+env);
		                   
	}

}
