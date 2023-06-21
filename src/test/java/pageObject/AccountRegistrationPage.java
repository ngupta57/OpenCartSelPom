package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);	
		
	}
	//Elements on registration Page
	
	@FindBy(name="firstname")
	WebElement txt_firstName ;
	
	@FindBy(id="input-lastname")
 	WebElement txt_lastName ;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@name='telephone' and @ id='input-telephone']")
	WebElement txt_telephone;
	
	@FindBy(xpath="//input[@name='password' or @ id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@name='confirm' and @class='form-control']")
	WebElement txt_confirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='agree']")
	WebElement chkBox_privacyPolicy;
	
	@FindBy(xpath=" //input[@value='Continue' and @class='btn btn-primary']")
	WebElement bttn_Continue;

}
