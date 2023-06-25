package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Webelement on Home page 
	
	@FindBy(xpath ="//span[normalize-space()='My Account']")
	WebElement lnk_myAccount;
	
	@FindBy(linkText ="Register")
	WebElement lnk_Register;	
	//methods
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnk_Login;
	
	public void clickMyAccount() {
		lnk_myAccount.click();
	}
	public void clickRegister() {
		lnk_Register.click();
	}
	public void clickLogin() {
		lnk_Login.click();
	}
	}
