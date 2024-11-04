package TestNgPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterisedClass {
	@Parameters({ "browser" })
	@Test
	public void browser(String browser) {
		System.out.println(browser+" Browser Opened");
	}
	
}
