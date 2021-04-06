package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class validation {
	
	@Test
	public void validationTest() {
		
		String actual="Hi";
		String expected=null;
	    //Assert.assertEquals(actual, expected);
	    //Assert.assertNotSame(actual, expected);
	    //Assert.assertSame(actual, expected);
		//Assert.fail();
		//Assert.assertNotNull(expected,"Not Null");
		
		SoftAssert aa=new SoftAssert();
		aa.assertNotNull(expected,"Not NULL");
		aa.assertAll();
	}

}
