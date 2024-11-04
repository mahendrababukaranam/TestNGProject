package Screenshot;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class Screenshot {
	WebDriver driver;
  @Test
  public void screenshot() throws IOException {
	  
	  File copy_Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  File screenshot_location = new File("D:\\Screeshots\\image.jpg");
	  FileHandler.copy(copy_Screenshot, screenshot_location);
	  
  }
  @BeforeClass
  public void launchApp() {
	  driver = new FirefoxDriver();
	  driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
  }

  @AfterClass
  public void afterClass() {
	  //driver.close();
  }

}
