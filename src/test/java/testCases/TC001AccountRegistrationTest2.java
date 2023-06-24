package testCases;
import pageObject.HomePage;
import testBase.BaseTest;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;

public class TC001AccountRegistrationTest2  {   
	@Test	
	public void accountRegistrationTest()throws InterruptedException
	{	
	EdgeDriver a= new EdgeDriver();
	a.get("https://www.google.com");
	}
}
	
		
	   
   


