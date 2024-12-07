package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="Datadriven") // getting dataProvider from different
																				// class
	public void verify_LoginDDT(String email, String pwd, String exp) {
		logger.info("*** Started TC003_LoginDDT ***");

		try {
			// home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link");
			hp.clickLogin();

			// login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// My Account

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();
			
			//below logic for positive and negative result

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetpage == true) {
					macc.clicklogout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}

			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetpage == true) {
					macc.clicklogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC003_LoginDDT ***");

	}
}
