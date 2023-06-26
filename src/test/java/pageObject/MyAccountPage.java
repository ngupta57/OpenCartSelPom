package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Webelement on Home page 
	
	@FindBy(xpath ="//*[@id=\"content\"]/h2[1]")
	WebElement msgAccountHeader;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnk_logout;
	
	public void clickLogout() {
		lnk_logout.click();
	}
	
	public boolean checkMyAccountPage() {
		try {
		return (msgAccountHeader.isDisplayed());
		} catch (Exception e)
		{
			e.getMessage();
			return(false);
			
		}
	}
	
	
}
