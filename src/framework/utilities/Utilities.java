package framework.utilities;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import framework.tests.TestBase;


public class Utilities extends TestBase {
	

	public Utilities(WebDriver driver) {
		this.driver = driver;
	}

	// initial sign in action
	public void signInInitial()  {
		
		// click Sign in button and navigate to my account page
		pageFactory.headerPage().getSignIn().click();
//		add a wait for element
		Assert.assertTrue(pageFactory.myAccountPage().getForgotPassword().isDisplayed());
		// input customer email into form field
		pageFactory.myAccountPage().enterDatainEmail(dataFactory.customersData().setEmail());
		// input customer password into form field
		pageFactory.myAccountPage().enterDataInPassword(dataFactory.customersData().setPassword());
		// Click the sign in button at bottom of login credentials
		pageFactory.myAccountPage().clickSignIn();

	}


	
	

}