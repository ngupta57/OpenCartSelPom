package testCases;
import pageObject.HomePage;
import testBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;

public class TC001AccountRegistrationTest extends BaseTest {   
	@Test(groups={"Sanity","Master"})	
	public void accountRegistrationTest()throws InterruptedException
	{	
		logger.info("********-Starting-execution for --TC001AccountRegistrationTest---***" );
		try 
		{
		HomePage hp = new HomePage(driver); 
		logger.info("********- Navigating to registraion page--TC001AccountRegistrationTest---***" );
		hp.clickMyAccount();
		hp.clickRegister();
		AccountRegistrationPage accountReg = new AccountRegistrationPage(driver);
		logger.info("********-providing data in to registration form for --TC001AccountRegistrationTest---***" );
		accountReg.setFirstName(randomeString().toUpperCase());
		accountReg.setlastName(randomeString().toUpperCase());
		accountReg.seteMail(randomeString()+"@gmail.com");// randomly generated the email
		accountReg.setTelPhone(randomeNumber());
		String password=randomAlphaNumeric();
		accountReg.setPassword(password);	
		accountReg.confirmPass(password);
		accountReg.checkPPolicy(); 
		accountReg.clickContinue();	
        String confmsg=accountReg.getConfirmMessage();
        logger.info("********-validating registraion success message --TC001AccountRegistrationTest---***" );
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.info("********-TC001AccountRegistrationTest failed---***" );
			Assert.fail();
		}
	}
}
	
		
	   
   


