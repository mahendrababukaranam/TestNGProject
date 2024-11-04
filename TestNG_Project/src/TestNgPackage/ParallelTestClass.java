package TestNgPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestClass {
	public WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	public void Browser(String browser) {
		switch (browser) {
		case "FFX":
			System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "CRM":
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", "D:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid Browser");
		}	
	}

	@Test
	public void title() {
		
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");

		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM - New Level of HR Management");
		System.out.println(title+" title is verified");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		System.out.println("Browser Closed");

	}
}
