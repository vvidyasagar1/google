package google;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.GoogleHomePage;
import library.Screenshots;
import library.TestBase;

public class TestCase extends TestBase{

	static String chromepath="./drivers/chromedriver.exe";
	String searchName ="Adaptavist";
	String url="https://www.google.com/";
	static WebDriver driver;
	List<WebElement> links;
	GoogleHomePage homePage;

	@Test
	public void scenario1() throws InterruptedException, AWTException, IOException{
		homePage=new GoogleHomePage();
		driver.get(url);
		log.info("Opened Chrome Browser");
		log.info("Navigate to Google Search Page");
		homePage.getTxtSearch().sendKeys(searchName);
	
		
		Thread.sleep(3000);
		WebElement Googlesearchbox =driver.findElement(By.xpath("//INPUT[@value='Google Search']/self::INPUT"));
		Googlesearchbox.click();

		Screenshots.takeScreenshot(driver, "Adaptavist");

		links =driver.findElements(By.partialLinkText("Adaptavist"));
		int linkCount=links.size();


		String[] linktexts=new String[linkCount];
		int i=0;
		for (WebElement ele:links){
			linktexts[i]=ele.getText();//extract text from link and put in Array

			System.out.println(ele.getAttribute("href"));
			i++;          
			System.out.println("\"" + i + "\""+ " is working.");
		}

		for (String clicks:linktexts) {
			driver.findElement(By.linkText(clicks)).click();
			Thread.sleep(1000);
			Screenshots.takeScreenshot(driver, "s2");
			driver.navigate().back();;
		}
		driver.quit(); 
	}
}

