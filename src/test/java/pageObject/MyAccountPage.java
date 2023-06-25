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
