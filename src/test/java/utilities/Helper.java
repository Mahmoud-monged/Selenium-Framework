package utilities;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {

	// Method to take screenshot when the test case fail.
	public static void captureScreenShot(WebDriver driver, String screenshotName)
	{
		Path destination = Paths.get("./Screenshots", screenshotName + ".png");

		try 
		{
			Files.createDirectories(destination.getParent());
			FileOutputStream out = new FileOutputStream(destination.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		}
		
		catch (Exception e) 
		{
			System.out.println("Exception while taking screen shot" + e.getMessage());
		}
	}
}
