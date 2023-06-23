package testCases;
import pageObject.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;

public class TC001AccountRegistrationTest extends BaseTest {   
	@Test	
	public void accountRegistrationTest()throws InterruptedException
	{	
		try 
		{
		HomePage hp = new HomePage(driver); 
		
		hp.clickMyAccount();
		hp.clickRegister();
		AccountRegistrationPage accountReg = new AccountRegistrationPage(driver);
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
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
}
	
		
	   
   


