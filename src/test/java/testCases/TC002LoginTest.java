package testCases;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;

public class TC002LoginTest extends BaseTest {   
	
	@Test	
	public void LoginTest()throws InterruptedException
	{	
		logger.info("********-Starting-execution for --TC002LOGINTest---***" );
		try 
		{
		HomePage hp = new HomePage(driver); 
		hp.clickMyAccount();
		hp.clickLogin();
		logger.info("********-Arrived at Login page --TC002LOGINTest---***" );
		LoginPage lp = new LoginPage(driver);		
		logger.info("********-providing data in to login page from config.property file---***" );
		lp.setUserName(rb.getString("userName"));
		lp.setPassword(rb.getString("password"));
		lp.Login();
		MyAccountPage map =new MyAccountPage(driver);
		boolean result=map.checkMyAccountPage();
		logger.info("********-validating my account page for header text ---***" );
		Assert.assertEquals(result, true);
		}catch (Exception e)
		{
		Assert.fail();
		}
		logger.info("********-Finished RUNNING tC002-lOGIN tEST ---***" );
	}
	
	}
	
		
	   
   


