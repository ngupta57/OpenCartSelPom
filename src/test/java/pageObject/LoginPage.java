package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Webelement on Home page 
	
	@FindBy(name ="email")
	WebElement txt_userName;
	
	@FindBy(id ="input-password")
	WebElement txt_password;	
	//methods
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_Login;
	
	public void setUserName(String email) {
		txt_userName.sendKeys(email);
	}
	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void Login() {
		btn_Login.click();
	}
}
