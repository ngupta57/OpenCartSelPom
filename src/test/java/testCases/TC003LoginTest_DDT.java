package testCases;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003LoginTest_DDT extends BaseTest {   
	
	@Test(dataProvider ="LoginData",dataProviderClass = DataProviders.class)	 
	public void test_loginDDT(String email, String password, String exp){	
		
		
		logger.info("********-Starting-TC003LoginTest_DDT---***" );
		try
		{		
		HomePage hp = new HomePage(driver); 
		hp.clickMyAccount();
		hp.clickLogin();		
		LoginPage lp = new LoginPage(driver);		
		logger.info("********-providing data in to login page from data provider---***" );
		lp.setUserName(email);
		lp.setPassword(password);
		lp.Login();
		MyAccountPage map =new MyAccountPage(driver);
		boolean result=map.checkMyAccountPage();
	
		if (exp.equals("Valid")){
			if (result==true) {
				map.clickLogout();
				Assert.assertTrue(true);
			}else {
				logger.info("********- login failed ---***" );
				Assert.assertTrue(false);
			}	     
		}
		if (exp.equals("Invalid"))
		  {if (result==true)
		  {
			map.clickLogout();
			Assert.assertTrue(false);
			}
		  else 
		  {
			  Assert.assertTrue(true);
		  }	
				
			}
		} catch (Exception e)
		{
			Assert.fail();
		}
			
		logger.info("********-Finished RUNNING -TC003LoginTest_DDT ---***" );
		
		}	
	}
	
		
	   
   


