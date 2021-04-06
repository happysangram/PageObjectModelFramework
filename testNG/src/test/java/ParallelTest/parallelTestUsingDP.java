package ParallelTest;

import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parallelTestUsingDP {
	
	
	@Test(dataProvider = "getData")
	public void login(String name) {
		
		Date dd =new Date();
		System.out.println("user name " + name  +  dd);
	}
	
	
	@DataProvider(parallel = true)
	public Object[][] getData(){
		
		Object[][] aa=new Object[2][1];
		aa[0][0]="abc";
		aa[1][0]="xyz";
		
		return aa;
		
	}

}
