package library;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;


public class Screenshots extends TestBase {

	public Screenshots() throws IOException {
		super();

	}

	public static void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		Date date=new Date();
		long tim = date.getTime();

		TakesScreenshot src=(TakesScreenshot)driver;
		File screenFile=src.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenFile, new File("./Screenshot/"+screenshotName+tim+".png"));		
	}		
}

