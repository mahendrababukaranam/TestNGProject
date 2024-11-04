package Dropdown_Values_Validation_with_Excel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Dropdown_Values_Validation_with_Excel2 {
	
	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
	  
	  //Launch the fireFox Browser
	  driver = new FirefoxDriver();
	  
	  //Open the Application
	  driver.get("https://www.kosmiktechnologies.com/seleniumLiveProject/kosmik-hms/index.php?msg=Successfully%20Logged%20out");
		  
  }
	
  @Test
  public void dropdownValidationWithExcel() throws IOException {
	  //Identifying user name and password input fields/elements
	  driver.findElement(By.name("username")).sendKeys("kosmik");
	  driver.findElement(By.name("password")).sendKeys("kosmik");
	  
	  //Identifying login button and click on that button
	  driver.findElement(By.name("submit")).click();
	  
	  //Identify Registration link
	  driver.findElement(By.linkText("Registration")).click();
	  
	  //Identify the Drop down
	  WebElement dropdown = driver.findElement(By.name("PAT_IDENTITY"));
	  
	  //Identify the drop down Values
	  List<WebElement> dropdown_values_Count = dropdown.findElements(By.tagName("option"));
	  
	  //Print the size
	  System.out.println("Dropdown Size is "+dropdown_values_Count.size());
	  
	  //Access the Excel file into the Eclipse
	  FileInputStream fis = new FileInputStream("D:\\Excel_Handling\\Excel\\Dropdown-XLS.xls");
	  
	  //Get the workbook from the Excel
	  HSSFWorkbook workbook = new HSSFWorkbook(fis);
	  
	  //Get the sheet from the workbook
	  HSSFSheet sheet = workbook.getSheet("Sheet2");
	  
	  //Get the Count of the sheet data rows
	  int Total_Rows_Excel = sheet.getLastRowNum()+1;
	  System.out.println("Total Rows of Excel: "+ Total_Rows_Excel);
	  
	  // Create an ArrayList object for that excel file values
	  ArrayList<String> excel_values = new ArrayList<String>();
	  
	  //Read/Add the Excel Values into ArrayList
	  for(int i = 0; i<Total_Rows_Excel; i++) {
		  excel_values.add(sheet.getRow(i).getCell(0).getStringCellValue());
	  }
	  
	  // Create ArrayList object for that drop down values
	  ArrayList<String> dd_Values = new ArrayList<String>();
	  
	  //Read/Add the drop down Values into ArrayList
	  for(int j = 0; j<dropdown_values_Count.size(); j++) {
		  dd_Values.add(dropdown_values_Count.get(j).getText());
	  }
	  
	  //Verify drop down values with Excel data
	  if(Total_Rows_Excel == dd_Values.size()) 
	  {
		  //To read the excel values
		  for(int k = 0; k<Total_Rows_Excel; k++) {
			  
			  //To read the drop down values
			  for(int l = 0; l<dropdown_values_Count.size(); l++) {
				  
				  //Validation
				  if(excel_values.get(k).equals(dd_Values.get(l))) {
					  System.out.println("Excel Data :"+excel_values.get(k)+" is matching with the Dropdown Data :"+dd_Values.get(l));
					  break;
				  }
				  
			  }
		  }
		  
	  }
	  else 
	  {
		  System.out.println("Size is not matching");
	  } 
	  
  }

  @AfterClass
  public void afterClass() {
	  //Close the active tab in the current browser
	  driver.close();
  }

}
