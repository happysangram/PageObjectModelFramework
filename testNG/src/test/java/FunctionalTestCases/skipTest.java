package FunctionalTestCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class skipTest {
	
	@Test
	public void testField() {
		
		throw new SkipException("Skip Test Case");
	}
}
