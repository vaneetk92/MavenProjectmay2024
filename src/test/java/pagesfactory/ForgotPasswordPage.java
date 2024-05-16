package pagesfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.BaseClass;

public class ForgotPasswordPage extends BaseClass {
	private static final Logger logger = (Logger) LogManager.getLogger(ForgotPasswordPage.class);

	private WebDriver dr;
	public ForgotPasswordPage(WebDriver d)
	{
		this.dr=d;
		PageFactory.initElements(dr, this);
	}
	
	//locators
	@FindBy(css="[class$='forgot-password-button--cancel']")
	private WebElement cancel;
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(css="[class$='forgot-password-title']")
	private WebElement resetbtn;
	
	//business logic
	public void clickOnCancelButton()
	{
		cancel.click();
	}
	
	public void enterUsername(String user)
	{
		username.sendKeys(user);
	}
	public boolean isForgotPasswordPageDisplayed()
	{
		logger.info("Title displayed on Reset Password Page");
		boolean b=false;
		try {
			b = resetbtn.isDisplayed(); 
		}catch(Exception e) 
		{
			logger.info(e);
		}
		return b;
	}
}
