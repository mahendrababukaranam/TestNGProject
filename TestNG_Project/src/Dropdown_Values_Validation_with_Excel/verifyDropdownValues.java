package Dropdown_Values_Validation_with_Excel;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class verifyDropdownValues {

	WebDriver driver;// instance variable

	@Test
	public void verifyDropdownValues() throws InterruptedException, IOException {

		// Navigate the Application Url

		driver.get("http://www.tizag.com/htmlT/htmlselect.php");

		// wait 3sec

		Thread.sleep(3000);

		// Identify dropdown

		WebElement dropdown = driver.findElement(By.name("selectionField"));

		// Identify dropdown values and store into dropdownCount variable

		List<WebElement> dropdownCount = dropdown.findElements(By.tagName("option"));
 

		// Print dropdown size.

		System.out.println("Dropdown size : " + dropdownCount.size());// 3

		/*
		 * FileInputStream – A FileInputStream is an inputstream for reading
		 * data from a Excel File.
		 * 
		 * FileOutputStream – A FileOutputStream is an outputstream for writing
		 * data into a Excel File.
		 */

		// Now access the Excel file into eclipse

		FileInputStream fis = new FileInputStream(
				"F:\\Selenium Software Dump Files\\SeleniumMaterial\\Login_With_xlsxFile.xlsx");

		// Get the workbook from Excel

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Get the sheet from Workbook

		XSSFSheet sheet = workbook.getSheetAt(2);

		// Get total rows from excel sheet

		int total_Rows = sheet.getLastRowNum() + 1;

		System.out.println("Excel size : " + total_Rows);// 3

		// Create ArrayList object for that excel values

		ArrayList<String> xlvalues = new ArrayList<String>();

		/*
		 * 
		 * As you know,some times we need to perform same action with multiple
		 * times at that time we need to follow - forloop
		 * 
		 */

		// Using for loop, we can iterate till the i value is true

		for (int i = 0; i < total_Rows; i++) {

			// Read the data from excel sheet

			xlvalues.add(sheet.getRow(i).getCell(0).getStringCellValue());
		}

 
		// Create ArrayList object for that drop down values

		ArrayList<String> ddvalues = new ArrayList<String>();

		// Using for loop, we can iterate till the j value is true

		for (int j = 0; j < dropdownCount.size(); j++) {

			ddvalues.add(dropdownCount.get(j).getText());
		}
 

		// Check for the required elements by Text and display matched elements
		
		if (total_Rows == dropdownCount.size()) {

			// To Read the excel values

			for (int k = 0; k < total_Rows; k++)// here we have to give excel
												// size
			{

				// To Read the dropdown values
				for (int l = 0; l < dropdownCount.size(); l++)// here we have to
																                                                                                                          // give dropdown
																                                                                                                      // size
				{

					if (xlvalues.get(k).equals(ddvalues.get(l))) {

						System.out.println(xlvalues.get(k) + "   is Matching with   " + ddvalues.get(l));

						break;

					}

				}

			}

		} else {
			System.out.println("Size Not matched");

		}

	}
 
	@BeforeClass
	public void OpenBrowser() {

		// Launch Firefox browser

		driver = new FirefoxDriver();

	}

	@AfterClass
	public void CloseBrowser() {
		// close the browser

		driver.close();
	}

}
