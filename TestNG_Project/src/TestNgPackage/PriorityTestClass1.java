package TestNgPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTestClass1 {
  @Test(groups ="Smoke")
  public void successLogin() {
	  System.out.println("Login Success1");
  }
  
  @Test(groups ="Sanity",priority=1,enabled=false)
  public void welcomePage() {
	  Assert.assertEquals("ahendraBabu", "MahendraBabu");
	  System.out.println("Opened Welcome Page1");
  }
  
  @Test(groups ="Smoke",dependsOnMethods= {"successLogin"})
  public void addToCart() {
	  System.out.println("Product Added to the Cart1");
  }
}
