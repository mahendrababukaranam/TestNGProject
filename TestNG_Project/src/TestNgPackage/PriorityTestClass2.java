package TestNgPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTestClass2 {
	@Test(groups ="Smoke",priority=0)
	  public void successLogin1() {
		  System.out.println("Login Success2");
	  }
	  @Test(groups ="Sanity",priority=1)
	  public void welcomePage1() {
		  Assert.assertEquals("ahendraBabu", "MahendraBabu");
		  System.out.println("Opened Welcome Page2");
	  }
	  @Test(groups ="Smoke",priority=2)
	  public void addToCart1() {
		  System.out.println("Product Added to the Cart2");
	  }
}
