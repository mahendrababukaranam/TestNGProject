package AnnotationsCycle;

import org.testng.annotations.*;

public class SuperClass {
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite Executed");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test Executed");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class Executed");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method Executed");
  }
  @Test
  public void testOne() {
	  System.out.println("TestOne Executed");
  }
  @Test
  public void testTwo() {
	  System.out.println("TestTwo Executed");
  }
  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite Executed");
  }
  @AfterTest
  public void afterTest() {
	  System.out.println("After Test Executed");
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("After Class Executed");
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method Executed");
  }
}
