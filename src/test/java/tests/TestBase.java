package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {

	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"Browser"})
	public void startDriver(@Optional("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("msEdge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}



		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void endDriver()
	{
		driver.quit();
	}
	
	// Take screenshot when test case fail and add it to screenshots folder.
	@AfterMethod
	public void takeScreenshotOnFaliure(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE) {
			
			System.out.println("Failed");
			System.out.println("Taking Screenshot ...");
			Helper.captureScreenShot(driver, result.getName());
		}
	}
}
