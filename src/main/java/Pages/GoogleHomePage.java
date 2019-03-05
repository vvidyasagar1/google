package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.TestBase;

public class GoogleHomePage extends TestBase{

	public GoogleHomePage() throws IOException{
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//INPUT[@class='gLFyf gsfi']")
	WebElement txtSearch;	
	
	@FindBy(xpath="//INPUT[@value='Google Search']/self::INPUT")
	WebElement btnSearch;

	public WebElement getTxtSearch() {
		return txtSearch;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}	
	
	
}
