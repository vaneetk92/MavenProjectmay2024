package testcases;

import org.testng.annotations.Test;

import pagesfactory.AdminPage;
import pagesfactory.DashboardPage;
import pagesfactory.LoginPage;
import pagesfactory.MyInfoPage;
import testbase.BaseClass;
import testbase.CrossBrowser;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class AdminTest{
	private static final Logger logger = (Logger) LogManager.getLogger(AdminTest.class);

	private BaseClass bc;
	private CrossBrowser cb;
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private AdminPage ap;
  @Test(description="Search User and Role", enabled=true)
  public void Verify_The_Admin_User_And_Role_In_table_TC007() throws IOException, InterruptedException {
	  boolean act = ap.verifyTheUser("chandra.rippin", "Admin");
	  Assert.assertEquals(act, true);
	  cb.attachScreenshot();
  }
  
	/*
	 * @Test(description="Search User and Role", enabled=true, timeOut=3000) public
	 * void Verify_Timout() throws IOException, InterruptedException {
	 * 
	 * Thread.sleep(5000); }
	 */
  @BeforeMethod
  public void beforeMethod() throws IOException {
	    bc = new BaseClass();
	    cb= new CrossBrowser();
		lp = new LoginPage(dr);
		dp = new DashboardPage(dr);
		ap = new AdminPage(dr);
		dr = cb.getInstance();
		bc.attachScreenshot();
		logger.info("Login to application");
		lp.login("Admin", "admin123");
		Assert.assertEquals(dp.isUsernameDisplayed(), true);
		bc.attachScreenshot();
		logger.info("Dashboard Displayed");
		dp.clickOnAdmin();
		Assert.assertEquals(ap.isAdminPageDisplayed(), true);
		logger.info("Admin page displayed");
		bc.attachScreenshot();
  }

  @AfterMethod
  public void afterMethod() {
	  dp.logout();
	  dr.quit();
  }

  @BeforeTest(alwaysRun=true)
  public void beforeTest()
  {
	logger.info("Before Test"); 
	Reporter.log("Before Test"); 
	System.out.println("Before Test"); 
  }
  
  @BeforeTest(alwaysRun=true)
  public void afterTest()
  {
	  logger.info("After Test");
	  Reporter.log("After Test"); 
	  System.out.println("After Test"); 
  }
}
