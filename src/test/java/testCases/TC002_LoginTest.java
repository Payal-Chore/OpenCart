package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	@Test(groups={"sanity","Master"})
	public void verifylogin() 
	{
	   	logger.info("*** Started TC002_LoginTest ***");
	   	
	   	try {
	   	   //home page
	   	   HomePage hp = new HomePage(driver);
		   hp.clickMyAccount();
		   logger.info("Clicked on My Account link");
		   hp.clickLogin();
		   
		   //login
		   LoginPage lp = new LoginPage(driver);
		   lp.setEmail(p.getProperty("email"));
		   lp.setPassword(p.getProperty("password"));
		   lp.clickLogin();
		   
		   //My Account
		   
		   MyAccountPage macc = new MyAccountPage(driver);
		  boolean targetpage =macc.isMyAccountPageExists();
		  Assert.assertTrue(targetpage);
	   	}
	   	catch(Exception e)
	   	{
	   		Assert.fail();
	   	}
		  logger.info("*** Finished TC002_LoginTest ***");
	}

}
