package Parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {
	
	
	
	@Test(dataProvider = "getData")
	public void Login(String name,int ID) {
		
		System.out.println(name);
		System.out.println(ID);
	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] obj=new Object[2][2];
		
		
		obj[0][0]="Sangram";
		obj[0][1]=123;
		obj[1][0]="Soumya";
		obj[1][1]=456;
		
		
		return obj;
		
	}
	

}
