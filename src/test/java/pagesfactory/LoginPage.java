package pagesfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import testbase.BaseClass;

public class LoginPage extends BaseClass {
	
	private static final Logger logger = (Logger) LogManager.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement user;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement pass;
	
	@FindBy(css="button[type='submit']")
	private WebElement btn;
	
	@FindBy(css="[class$='orangehrm-login-forgot-header']")
	private WebElement forgotPass;
	
	@FindBy(css="p[class$='alert-content-text']")
	private WebElement error;
	
	public void clickOnForgotPassword()
	{
		forgotPass.click();
	}
	public void login(String username, String password) {
		user.sendKeys(username);
		pass.sendKeys(password);
		btn.click();
		//ClickOnElementsByActions(btn);
	}
	public boolean isErrorDisplayed()
	{
		logger.info("Check for error while login");
		boolean b=false;
		try {
			b = error.isDisplayed();
		}catch(Exception e)
		{
			logger.info(e);
		}
		logger.info("Value-->"+b);
		return b;
	}
	
	public boolean isLogoutSuccessfull()
	{logger.info("Check for logout success");
	boolean b=false;
	try {
		b = btn.isDisplayed();
	}catch(Exception e)
	{
		logger.info(e);
	}
	logger.info("Value-->"+b);
	return b;
		
	}
	
	public boolean isLoginPageDisplayed()
	{
		logger.info("Check for Login Page Display");
	boolean b=false;
	try {
		b = btn.isDisplayed();
	}catch(Exception e)
	{
		logger.info(e);
	}
	logger.info("Value-->"+b);
	return b;
		
	}
}
