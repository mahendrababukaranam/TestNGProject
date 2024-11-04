package Handling_Excel_Sheets;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestExcel {
	WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		//Open the fire fox browser
			
				driver=new FirefoxDriver();//here driver is a object reference variable
				
				//Navigate the app URL
				
				driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");

	  }
	
  @Test
  public void f() throws IOException {
	  FileInputStream fis = new FileInputStream("D:\\Excel_Handling\\Excel\\Login.xls");
	  
      HSSFWorkbook workbook = new HSSFWorkbook(fis);
      
      HSSFSheet sheet = workbook.getSheet("Credentials");
      String username=sheet.getRow(1).getCell(0).getStringCellValue();
      String password=sheet.getRow(1).getCell(1).getStringCellValue();
      driver.findElement(By.name("txtUserName")).sendKeys(username);
      driver.findElement(By.name("txtPassword")).sendKeys(password);
      driver.findElement(By.name("Submit")).click();
      String text=driver.findElement(By.xpath("/html/body/div[3]/ul/li[1]")).getText();
      System.out.println(text);
      if(text.equals("Welcome selenium"))
      {
    	  System.out.println("Welcome page verified successfully");
      }
      else
      {
    	  System.out.println("Welcome page not verified successfully");
	  }
      driver.findElement(By.xpath("/html/body/div[3]/ul/li[3]/a")).click();

}

  
  @AfterClass
  public void afterClass() {
	//Close the fire fox browser.
			driver.close();

  }

}
