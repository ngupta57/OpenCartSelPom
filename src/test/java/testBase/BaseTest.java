package testBase;
import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest{	
	public WebDriver driver;
	
	public Logger logger;
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) throws InterruptedException
	{	
		logger = LogManager.getLogger(this.getClass());
	
				
		if(br.equals("chrome"))
		{
			  ChromeOptions chromeOptions = new ChromeOptions();
			  chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
			  WebDriverManager.chromedriver().setup();
			  driver =new ChromeDriver(chromeOptions);
		}
		else if (br.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}
		else
		{   
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		
		}
		 
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("http://localhost/opencart/upload/index.php");
		  Thread.sleep(3000);
		  System.out.println("Browser Launched & nnavigated to URL");
		  driver.manage().window().maximize();	  
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();		
	}
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);		
		return (st+"@"+num);
	}	

}
