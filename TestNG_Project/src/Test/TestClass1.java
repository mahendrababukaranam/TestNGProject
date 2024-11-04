package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestClass1 {
	
	WebDriver driver;
	
  @BeforeClass
  public void openBrowserandApplication() {
	  driver = new FirefoxDriver();
	  driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
  }
  @Test
  public void verifyTitle() {
	  ////Get the title
	  String title = driver.getTitle();
	  
	  //Print the title
	  System.out.println(title);
	  
	  //Verify title
	  Assert.assertEquals(title, "OrangeHRM - New Level of HR Management");
  }

  @AfterClass
  public void closeBrowser() {
	  //Close the browser
	  driver.quit();
  }

}
