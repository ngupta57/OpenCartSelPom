package testBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;
import java.util.ResourceBundle;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest{	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb ;// for reading values from config file
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) throws InterruptedException
	{	
		logger = LogManager.getLogger(this.getClass());
		rb = ResourceBundle.getBundle("config");
	
				
		if(br.equals("chrome"))
		{
			  ChromeOptions chromeOptions = new ChromeOptions();
			  chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
			  WebDriverManager.chromedriver().setup();
			  driver =new ChromeDriver(chromeOptions);
		}
		else if (br.equals("firefox"))
		{	WebDriverManager.firefoxdriver().setup();	
			driver = new FirefoxDriver();
		}
		else
		{   
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();		
		}		 
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get(rb.getString("appURL"));
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
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
