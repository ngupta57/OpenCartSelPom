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
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement bttn_Continue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Methods
	
	public void setFirstName(String fName) {
		txt_firstName.sendKeys(fName);
	}
	public void setlastName(String lName) {
		txt_lastName .sendKeys(lName);
	}
	public void seteMail(String eMail) {
		txt_email.sendKeys(eMail);
	}
	public void setTelPhone(String tNum) {
		txt_telephone.sendKeys(tNum);
	}
	public void setPassword(String Pass) {
		txt_password.sendKeys(Pass);		
	}
	public void confirmPass(String Pass) {
		txt_confirmPassword.sendKeys(Pass);		
	}
	public void checkPPolicy() {
		chkBox_privacyPolicy.click();
	}
	public void clickContinue() {
		bttn_Continue.click();
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();		
	
	}
	    public String getConfirmMessage() {
	    	try {
		return (msgConfirmation.getText());
	}catch (Exception e){
	    	return (e.getMessage());
	    	}
		
	

}}
