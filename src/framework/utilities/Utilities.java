package framework.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import framework.factories.DataFactory;
import framework.factories.PageFactory;

public class Utilities {
	PageFactory pageFactory;
	WebDriver driver;
	DataFactory dataFactory;
	WebDriverWait wait;

	public Utilities(WebDriver driver) {
		this.driver = driver;
		pageFactory = new PageFactory(driver);
		dataFactory = new DataFactory();
		wait = new WebDriverWait(driver, 10);
	}

	// initial sign in action
	public void signInInitial() {
		// click Sign in button and navigate to my account page
		pageFactory.headerPage().getSignIn().click();
		// add a wait for element
		Assert.assertTrue(pageFactory.myAccountPage().getForgotPassword()
				.isDisplayed());
		// input customer email into form field
		pageFactory.myAccountPage().enterDatainEmail(
				dataFactory.customersData().setEmail());
		// input customer password into form field
		pageFactory.myAccountPage().enterDataInPassword(
				dataFactory.customersData().setPassword());
		// Click the sign in button at bottom of login credentials
		pageFactory.myAccountPage().clickSignIn();
	}

	// Seaches for item and navigates to its product page
	public void searchForItem(String item) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchForm")));
		pageFactory.headerPage().getSearchBar().clear();
		pageFactory.headerPage().getSearchBar().sendKeys(item);
		pageFactory.headerPage().getSearchButton().click();
	}

	// asserts the correct item is on page and adds to wish list
	public void AddItemToWishList(String item) {
		Assert.assertEquals(
				pageFactory.productsPage().getProductTitle().getText(),
				dataFactory.productData().getItem(0),
				String.format("Expected product title to be %s", pageFactory
						.productsPage().getProductTitle().getText()));
		pageFactory.productsPage().addItemtoWishList();
	}

	// Adds the shipping address
	public void addShippingAddress() {

		pageFactory.addressBookPage().clickAddNewAddress();
		pageFactory.editAddressPage().setCountry(
				dataFactory.customersData().getCountry());
		pageFactory.editAddressPage().getFirstName()
				.sendKeys(dataFactory.customersData().getFirstName());
		;
		pageFactory.editAddressPage().getLastName()
				.sendKeys(dataFactory.customersData().getLastName());
		;
		pageFactory.editAddressPage().getShipAddress()
				.sendKeys(dataFactory.customersData().getShipAddress1());
		;
		pageFactory.editAddressPage().getShipZipcode()
				.sendKeys(dataFactory.customersData().getShipZipcode());
		;
		pageFactory.editAddressPage().getShipCity()
				.sendKeys(dataFactory.customersData().getShipCity());
		;
		pageFactory.editAddressPage().setState(
				dataFactory.customersData().getState());
		pageFactory.editAddressPage().getTelephone()
				.sendKeys(dataFactory.customersData().setTelephone());
		pageFactory.editAddressPage().clickSaveChanges();
	}

	// clicks the preferred shipping button
	public void addPreferredShipping() {
		pageFactory.addressBookPage().clickEditShipAddress(
				dataFactory.customersData().getShipAddress1());
		pageFactory.editAddressPage().clickPrefShip();
		pageFactory.editAddressPage().clickUpdateChanges();
	}

	// clicks the preferred billing button
	public void addPreferredBilling() {
		pageFactory
				.addressBookPage()
				.getEditBillAddress(
						dataFactory.customersData().getBillAddress1()).click();
		pageFactory.editAddressPage().clickPrefBill();
		pageFactory.editAddressPage().clickUpdateChanges();
	}

	// adds a new billing address
	public void addBillingAddress() {
		pageFactory.addressBookPage().clickAddNewBilling();
		pageFactory.editAddressPage().setCountry(
				dataFactory.customersData().getCountry());
		pageFactory.editAddressPage().getFirstName()
				.sendKeys(dataFactory.customersData().getFirstName());
		;
		pageFactory.editAddressPage().getLastName()
				.sendKeys(dataFactory.customersData().getLastName());
		;
		pageFactory.editAddressPage().getBillAddress()
				.sendKeys(dataFactory.customersData().getBillAddress1());
		;
		pageFactory.editAddressPage().getBillingZipcode()
				.sendKeys(dataFactory.customersData().getBillZipcode());
		;
		pageFactory.editAddressPage().getBillingCity()
				.sendKeys(dataFactory.customersData().getBillCity());
		;
		pageFactory.editAddressPage().setState(
				dataFactory.customersData().getState());
		pageFactory.editAddressPage().getTelephone()
				.sendKeys(dataFactory.customersData().setTelephone());
		pageFactory.editAddressPage().clickSaveChanges();

	}

}