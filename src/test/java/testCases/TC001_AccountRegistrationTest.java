package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"regression","Master"})
	public void verify_account_registration() 
	{
	   logger.info("*** Started TC001_AccountRegistrationTest ***");
		
	try 
	{	
	   HomePage hp = new HomePage(driver);
	   hp.clickMyAccount();
	   logger.info("Clicked on My Account link");
	   
	   hp.clickRegister();
	   logger.info("Clicked on Register link");
	   
	   AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
	   
	   logger.info("Provideing customer details");
	   regpage.setFirstName(randomString().toUpperCase());
	   regpage.setLastName(randomString().toUpperCase());
	   
	   regpage.setEmail(randomString()+"@gmail.com"); //randomly generated the email
	   regpage.settelephone(randomNumber());
	   
	   String password =randomAlphanumaric();
	   
	   regpage.SetPassword(password);
	   regpage.SetConfirmPassword(password);
	   
	   regpage.setPrivacyPolicy();
	   regpage.setContinuebtn();
	   
	   logger.info("Validate expected message..");
	   String confmsg=regpage.getConfirmationmsg();
	   if(confmsg.equals("Your Account Has Been Created!"))
	   {
	    Assert.assertTrue(true);
	   }
	   else
	   {
		   logger.error("Test failed..");
		   logger.debug("Debug logs..");
		   Assert.assertTrue(false);
	   }
	   
	}
	catch(Exception e)
	  {
		
		Assert.fail();
	  }  
	logger.info("*** Finished TC001_AccountRegistrationTest ***");
	}
	
}
