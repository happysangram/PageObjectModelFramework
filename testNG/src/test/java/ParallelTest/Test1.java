package ParallelTest;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
	
	@Parameters({"browser"})
	@Test
	public void Login(String browser) throws InterruptedException {
	 Date a=new Date();
	 
		System.out.println(browser + " ------------->"+ a);
		Thread.sleep(2000);
	}

}
