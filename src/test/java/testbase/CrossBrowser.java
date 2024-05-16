package testbase;
//testbase has crossbrowser function and load config properties

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class CrossBrowser extends BaseClass {
	
	private static final Logger logger = (Logger) LogManager.getLogger(CrossBrowser.class);
	public Properties prop;
	public String browser;
	
	public WebDriver getInstance() throws IOException
	{
		logger.info("read Config File");
		String conf = "./src/main/resources/config/config.properties";
		FileInputStream instream = new FileInputStream(conf); 
		prop = new Properties();
		prop.load(instream);
		browser = prop.getProperty("browser").toLowerCase();
		logger.info("Get the Browser Type" + browser);
		switch(browser)
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeagent"));
				driver = new ChromeDriver();
				
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxagent"));
				FirefoxOptions opt = new FirefoxOptions();
			//	opt.setBinary("C:\\Program Files\\Mozilla Firefox\firefox.exe");
				driver = new FirefoxDriver();
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", prop.getProperty("edgeagent"));
				driver = new EdgeDriver();
				break;
			default:
				logger.error("Browser Name not Provided or Missing");
				new Throwable().initCause(null);
			
		}
		driver.get(prop.getProperty("url"));
		logger.info("Url Opened:"+prop.getProperty("url") );
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logger.info("Implicit Wait"+ +15);
		return driver;
		
	} 
	public void closedriver()
	{
		driver.quit();
	}
	/*public static WebDriver getInstancestatic()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		sdriver = new ChromeDriver();
		sdriver.manage().window().maximize();
		//sdriver.manage().window().setSize(new Dimension(667,375));
		sdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return sdriver;
	}*/
}
