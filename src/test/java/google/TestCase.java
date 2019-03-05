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

	String searchName1 ="Adaptavist";
	String searchName2 ="Atlassian";
	String url="https://www.google.com/";
	List<WebElement> links;
	GoogleHomePage homePage;

	@Test
	public void scenario1() throws InterruptedException, AWTException, IOException{
		driver.get(url);
		Thread.sleep(3000);
		homePage=new GoogleHomePage();		
		log.info("Opened Chrome Browser");
		log.info("Navigate to Google Search Page");
		homePage.getTxtSearch().sendKeys(searchName1);
		Thread.sleep(2000);
		homePage.getBtnSearch().click();
		log.info("Clicked on search button");
		Screenshots.takeScreenshot(driver, "Adaptavist");
		log.info("Screenshot taken after searching text: Adaptavist");
		links =driver.findElements(By.partialLinkText("Adaptavist"));
		int linkCount=links.size();
		log.info("Links matched: "+linkCount);

		String[] linktexts=new String[linkCount];
		int i=0;
		for (WebElement ele:links){
			linktexts[i]=ele.getText();//extract text from link and put in Array
			i++;          
		}

		for (String clicks:linktexts) {
			driver.findElement(By.linkText(clicks)).click();
			log.info("Clicked on searched link");
			Thread.sleep(1000);
			Screenshots.takeScreenshot(driver, "AdaptavistLandingPage");
			log.info("Screenshot taken for landing page when clicked on searched link");
			driver.navigate().back();;
		}
		driver.quit(); 
	}
	
	@Test
	public void scenario2() throws InterruptedException, AWTException, IOException{
		driver.get(url);
		Thread.sleep(3000);
		homePage=new GoogleHomePage();		
		log.info("Opened Chrome Browser");
		log.info("Navigate to Google Search Page");
		homePage.getTxtSearch().sendKeys(searchName2);
		Thread.sleep(2000);
		homePage.getBtnSearch().click();
		log.info("Clicked on search button");

		log.info("Screenshot taken after searching text: Atlassian");
		Screenshots.takeScreenshot(driver, "Atlassian");
		links =driver.findElements(By.partialLinkText("Adaptavist"));
		int linkCount=links.size();
		if(linkCount==0){
			log.info("None of the links contain reference to 'Adaptavist'");
		}
		else
		{
			log.info("Links contain reference to 'Adaptavist': "+linkCount);
		}

		driver.quit(); 
	}
}


