package pageObject;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

    public class BasePage {		
	WebDriver driver;	
	// create Constructor
	public BasePage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);		
	}

}
