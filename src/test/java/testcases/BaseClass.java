package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	
	public XSSFWorkbook wbook;
	public XSSFSheet sheet;
	
	@BeforeMethod(alwaysRun=true)
	public void SetUpDriver() {
		
		String browser = System.getProperty("Browser");
		
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		driver.get("https://simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void TearDown() {
		
		driver.quit();
	}
	
	@BeforeTest(alwaysRun=true)
	public void SetUpExcel() throws IOException {
		
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");
		
	}
	
	@AfterTest(alwaysRun=true)
	public void CloseExcel() throws IOException {
		
		wbook.close();
		
	}

}
