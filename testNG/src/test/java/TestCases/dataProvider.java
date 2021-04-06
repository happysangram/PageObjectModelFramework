package TestCases;

import org.testng.annotations.Test;

public class dataProvider {
	

	@Test(dataProviderClass = excelValidation.class,dataProvider = "dp1")
	public void Loginvalue(String name,String ID,String ctc) {
		
		System.out.println(name);
		System.out.println(ID);
		System.out.println(ctc);
	}

}
