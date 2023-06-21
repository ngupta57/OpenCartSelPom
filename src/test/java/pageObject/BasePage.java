package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

    public class BasePage {		
	WebDriver driver;	
	// create Constructor
	public BasePage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);		
	}

}
