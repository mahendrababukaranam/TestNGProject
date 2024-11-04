package Handling_WebTable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTable2 {
	
	WebDriver driver;

  @BeforeClass
  public void openWebSite() {
	  
	  //Launch the Browser
	  driver = new FirefoxDriver();
	  
	  //Open the Application
	  driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
  }
  @Test
  public void webTable() throws IOException {
	  //-----------------------Web Table Rows Size---------------------------
	  
	  // Calculate the number of rows in a table
	  int allRowsWeb = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr")).size();
	  
	  //Print number of rows in a table
	  System.out.println("Number of Rows in a Table : "+allRowsWeb);
	  
	  //-----------------------Web Table Rows Size End----------------------- 
	  
	  
	  //-----------------------Web Table Columns Size------------------------
	  
	  // Calculate the number of columns in a table
	  int allColumnsWeb = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td")).size();
	  
	  //Print number of columns in a table
	  System.out.println("Number of Columns in a Table : "+allColumnsWeb);
	  
	  //-----------------------Web Table Columns Size End--------------------
	
	  
	  //-----------------------Handling Excel Sheet--------------------------
	  
	  //Accessing Excel file in to Eclipse
	  FileInputStream fis = new FileInputStream("D:\\Excel_Handling\\Excel\\WebTable-xls.xls");
	  
	  //Get the Work Book from the Excel File
	  HSSFWorkbook workbook = new HSSFWorkbook(fis);
	  
	  //Get the Sheet from the Work Book
	  HSSFSheet sheet = workbook.getSheet("WebTable");
	  
	  //Count the number of Rows in Excel Sheet
	  int totalRowsExcel = sheet.getLastRowNum() + 1;
	  
	  //Print the number of Rows from Excel
	  System.out.println("Number of Rows in a Table : "+totalRowsExcel);
	  
	  //Count the number of Columns in Excel Sheet
	  int totalColumnsExcel = sheet.getRow(0).getLastCellNum();
	  
	  //Print the number of Columns from Excel
	  System.out.println("Number of Columns in a Table : "+totalColumnsExcel);
	  
	  
	  //-----------------------Handling Excel Sheet End-------------------------
	  
	  
	  //-----------------------Storing Excel data into ArrayList----------------
	  
	  //Create an ArrayList Object to Store excel Data into ArrayList
	  ArrayList<String> storesExcelValues = new ArrayList<String>();
	  
	  //To Store all excel data into ArrayList we are using for loop
	  for(int i = 0; i<sheet.getLastRowNum()+1; i++) { //Rows
		  for(int j = 0; j<sheet.getRow(i).getLastCellNum(); j++) { //Columns
			  
			  //Print the Data
			  System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			  
			  //Add the data into ArrayList
			  storesExcelValues.add(sheet.getRow(i).getCell(j).getStringCellValue());
			  
			  //Print the added ArrayList Data
			  System.out.println("Added Excel : "+sheet.getRow(i).getCell(j).getStringCellValue()+" data into an ArrayList");
		  }
	  }
	  
	  
	  //-----------------------Storing Excel data into ArrayList End------------
	  
	  
	  
	  //-----------------------Storing WebTable data into ArrayList-------------
	  
	  //Create an ArrayList Object to Store WebTable Data into ArrayList
	  ArrayList<String> storesWebTableValues = new ArrayList<String>();
	  
	  //To Store all excel data into ArrayList we are using for loop
	  for(int k = 1; k<=allRowsWeb; k++) { //Rows
		  
		  for(int l = 1; l<=allColumnsWeb; l++) { //Columns
			  //Identify Rows, Columns and Store WebTable data into a Variable
			  //String dataWebApp = driver.findElement(By.xpath("/html/body/table/tbody/tr[" + k + "]/td[" + l + "]")).getText();
			  String dataWebApp = driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[" + k + "]/td[" + l + "]")).getText();
			  //Print WebTable Data using Variable
			  System.out.print(dataWebApp);
			  
			  //Adding WebTable data into an ArrayList
			  storesWebTableValues.add(dataWebApp);
			  
		  }
		  System.out.println();
	  }
	  
	  
	  //-----------------------Storing WebTable data into ArrayList End---------
	  
	  //-----------------------Verify WebTable Data comparing with Excel data---	  
	  //Count total rows and columns of Excel
	  int total_Rows_Columns = totalRowsExcel * totalColumnsExcel;
	  
	  //Print total rows and columns of Excel
	  System.out.println("Total Rows and Columns of Excel Sheet : "+total_Rows_Columns);
	  
	  //Verify Excel and WebTable data using for loop iteration
	  for(int m = 0; m<total_Rows_Columns; m++) {
		  
		  //Verify Excel and WebTable Data
		  if(storesExcelValues.get(m).equals(storesWebTableValues.get(m))) {
			  System.out.println(m+" Index Value "+storesExcelValues.get(m)+ " is matching with "+ m+" Index Value "+storesWebTableValues.get(m));
		  }
		  else {
			  System.out.println(m+" Index Value "+storesExcelValues.get(m)+ " is not matching with "+ m+" Index Value "+storesWebTableValues.get(m));
		  }
		  
	  }
	  
	  //-----------------------Verify WebTable Data comparing with Excel data End-----------------------
	  

  }		
  @AfterClass
  public void tearDown() {
	  
	  //Close the active tab/window from current browser
	  driver.quit();
  }
  
}
