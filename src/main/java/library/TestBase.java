package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static Properties prop;
	public static File file;
	public static FileInputStream ipfile;

	static {
		try {
			loadPropertiesFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public synchronized void launchBrowser() throws IOException {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome Browser started");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public synchronized void closeBrowser() throws IOException {
		if (driver!=null) {
//			driver.quit();
		}
	}

	public static void loadPropertiesFile() throws IOException {
		prop = new Properties();
		file = new File(System.getProperty("user.dir") + "/config/config.properties");
		ipfile = new FileInputStream(file);
		prop.load(ipfile);
		String log4jConfPath = System.getProperty("user.dir") + "/config/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
}
