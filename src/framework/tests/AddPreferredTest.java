package framework.tests;




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.data.CustomersData;
import framework.pages.*;
import framework.utilities.Utilities;

public class AddPreferredTest{
	static WebDriver driver;
	Utilities frontPage;
	MyAccountPage myAccountPage;
	WelcomePage welcomePage;
	AddressBookPage addressBookPage;
	EditAddressPage editAddressPage;
	ChangeAddressPage changeAddressPage;
	CustomersData customers;

	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		frontPage = new Utilities(driver);
		myAccountPage = new MyAccountPage(driver);
		welcomePage = new WelcomePage(driver);
		addressBookPage = new AddressBookPage(driver);
		editAddressPage = new EditAddressPage(driver);
		changeAddressPage = new ChangeAddressPage(driver);
		customers = new CustomersData();
		

	}

	@Test
	public void test() {

		// Start the web Driver and navigate to petsmart
		driver.get("http://www.pesmart.com");
		
		// Sign in
		frontPage.signInInitial();

		//Click the link to the MY Account Link
		welcomePage.getMyAccountLink().click();
		
		// assert the my account link is present on page
		Assert.assertTrue(welcomePage.getMyAccountLink().isDisplayed());

		// Click the address book link in left column
		myAccountPage.clickAddressLink();

		// adds the new address
		editAddressPage.addNewAddress(customers);
		
		// adds the billing address
		editAddressPage.addBillingAddress(customers);
		
		// update the customer shipping address
		editAddressPage.addPerferredShipping(customers);
		

		
				// update the customer shipping address
		editAddressPage.addPerferredBilling();
		//add a method to assert the shipping is preferred
//		assert1.billAssert(customers);
//
//		assert1.shipAssert(customers);
		//add a method to assert the billing is preferred

	}

	@AfterClass
	public void close() {
		
		//  click the delete address button to reset test case		
		// Start the web Driver and navigate to petsmart
		driver.get("http://www.petsmart.com/");
		

		//Click the link to the MY Account Link
		welcomePage.clickMyAccountLink();
		
		// assert the my account link is present on page
		Assert.assertTrue(welcomePage.getMyAccountLink().isDisplayed());

		// Click the address book link in left column
		myAccountPage.clickAddressLink();
//		delete the address stored to reset user data
		driver.navigate().refresh();
		editAddressPage.deleteAddress();
//		close the driver
		driver.close();	

	
	}

}