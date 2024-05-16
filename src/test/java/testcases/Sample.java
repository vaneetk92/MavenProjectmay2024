package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pagesfactory.LoginPage;
import testbase.CrossBrowser;


public class Sample {
	
	private static final Logger logger = (Logger) LogManager.getLogger(Sample.class);
	
	public static void main(String[] args) throws IOException {
		logger.info("Login Page Opened");
		CrossBrowser cb = new CrossBrowser();
		WebDriver driver = cb.getInstance();
		LoginPage lp = new LoginPage(driver);
		
		lp.login("Admin", "admin123");
	

	}

}
