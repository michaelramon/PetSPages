package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.data.CustomersData;

public class EditAddressPage extends BasePage {

	// creates a instance of a wait
	WebDriverWait wait = (new WebDriverWait(driver, 5));
	// creates an instance of CustomersData
	CustomersData customer = new CustomersData();
	// Creates an instance of the Address book Page
	AddressBookPage addressBookPage = new AddressBookPage(driver);
	// creates an instance of the select class
	Select selectBox;
	// create an instance of the action class
	Actions act = new Actions(driver);

	public EditAddressPage(WebDriver driver) {
		super(driver);
	}

	public void addNewAddress(CustomersData customer) {

		addressBookPage.clickAddNewAddress();
		// wait.until(ExpectedConditions.elementToBeClickable(By
		// .cssSelector(".ws-button ws-cancel ws-account-address-add-address-form-cancel-button")));
		setCountry(customer.getCountry());
		setFirstName(customer.getFirstName());
		setLastName(customer.getLastName());
		setShipAddress(customer.getShipAddress1());
		setShipZipcode(customer.getShipZipcode());
		setShipCity(customer.getShipCity());
		setState(customer.setState());
		setTelephone(customer.setTelephone());
		clickSaveChanges();
	}

	public void addPerferredShipping(CustomersData customer) {
		addressBookPage.clickEditShipAddress();

		clickPrefShip();
		clickUpdateChanges();

	}

	public void addPerferredBilling() {
		addressBookPage.clickEditBillAddress();
		clickPrefBill();
		clickUpdateChanges();

	}

	public void addBillingAddress(CustomersData customer) {
		addressBookPage.clickAddNewBilling();
		act.moveToElement(findByCSSselector("div.pet-footer-legal > p"))
				.click();
		setCountry(customer.getCountry());
		setFirstName(customer.getFirstName());
		setBillingZipcode(customer.getBillZipcode());
		setBillAddress(customer.getBillAddress1());
		setBillingCity(customer.getBillCity());
		setState(customer.setState());
		setTelephone(customer.setTelephone());
		setLastName(customer.getLastName());
		clickSaveChanges();

	}

	// get location of country field
	public WebElement getCountry() {
		return findByID("AddressForm_CountryCode");

	}

	// set country
	public void setCountry(String customer1) {
		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector("button[name='createAddress']")));
		customer1 = customer.getCountry();
		selectBox = new Select(driver.findElement(By
				.id("AddressForm_CountryCode")));
		selectBox.selectByValue(customer1);
	}

	// get telephone location
	public WebElement getTelephone() {
		return findByID("AddressForm_Phone");
	}

	public void setTelephone(String customer1) {
		getTelephone().sendKeys(customer1);
	}

	// Address 1 Billing
	public WebElement getBillAddress() {
		return findByID("AddressForm_Address1");
	}

	public void setBillAddress(String customer1) {

		getBillAddress().clear();
		customer1 = customer.getBillAddress1();
		getBillAddress().sendKeys(customer1);
	}

	// Address1 zip
	public WebElement getBillingZipcode() {
		return findByID("AddressForm_PostalCode");
	}

	public void setBillingZipcode(String customer1) {
		getBillingZipcode().clear();
		customer1 = customer.getBillZipcode();
		getBillingZipcode().sendKeys(customer1);
	}

	// Address1 City
	public WebElement getBillingCity() {
		return findByID("AddressForm_City");
	}

	public void setBillingCity(String customer1) {
		getBillingCity().clear();
		customer1 = customer.getBillCity();
		getBillingCity().sendKeys(customer1);
	}

	// Address 1 first name
	public WebElement getFirstName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("#AddressForm_FirstName")));
		return findByCSSselector("#AddressForm_FirstName");
	}

	public void setFirstName(String customer1) {
		customer1 = customer.getFirstName();
		getFirstName().sendKeys(customer1);
	}

	// Address 1 last name
	public WebElement getLastName() {
		return findByID("AddressForm_LastName");
	}

	public void setLastName(String customer1) {
		WebElement lastNameDropBox = getLastName();
		if (lastNameDropBox.getAttribute("value") == "PoppingFresh") {
			getLastName().clear();
			customer1 = customer.getLastName();
			getLastName().sendKeys(customer1);
		} else {
			customer1 = customer.getLastName();
			getLastName().sendKeys(customer1);
		}
	}

	// get location of State field
	public WebElement getState() {
		return findByID("AddressForm_State");

	}

	// sends user data to state dropbox
	public void setState(String customer1) {
		customer1 = customer.getState();
		selectBox = new Select(driver.findElement(By.id("AddressForm_State")));
		selectBox.selectByValue(customer1);
	}

	// Address 1 Ship
	public WebElement getShipAddress() {
		return findByID("AddressForm_Address1");
	}

	public void setShipAddress(String customer1) {
		customer1 = customer.getShipAddress1();
		getShipAddress().clear();
		getShipAddress().sendKeys(customer1);
	}

	// Address1 city ship
	public WebElement getShipCity() {
		return findByID("AddressForm_City");
	}

	public void setShipCity(String customer1) {
		getShipCity().clear();
		customer1 = customer.getShipCity();
		getShipCity().sendKeys(customer1);
	}

	// Address 1 ship zip
	public WebElement getShipZipcode() {
		return findByID("AddressForm_PostalCode");
	}

	public void setShipZipcode(String customer1) {
		getShipZipcode().clear();
		customer1 = customer.getShipZipcode();
		getShipZipcode().sendKeys(customer1);
	}

	public WebElement getPrefShip() {
		return findByXPath("//input[@name='PreferredShipping']");
	}

	public void clickPrefShip() {
		wait.until(ExpectedConditions.elementToBeClickable(By
				.linkText("Cancel")));
		getPrefShip().click();

	}

	public WebElement getPrefBill() {
		return findByXPath("//input[@name='PreferredBilling']");
	}

	public void clickPrefBill() {
		wait.until(ExpectedConditions.elementToBeClickable(By
				.linkText("Cancel")));
		getPrefBill().click();

	}

	public WebElement getSaveChanges() {
		return findByCSSselector("button[name='createAddress']");
	}

	public void clickUpdateChanges() {
		getUpdateChanges().click();
	}

	public WebElement getUpdateChanges() {
		return findByCSSselector("button[name='updateAddress']");
	}

	public void clickSaveChanges() {
		getSaveChanges().click();
	}

	public WebElement getBillDelete(CustomersData customer) {
		return findByXPath("//tr[.//div[contains(., " + "'" + customer.getBillAddress1()+ "'"+")]]/following-sibling::tr//td//input[@name='deleteAddress']");
/* $x("//tr[.//div[contains(.,'Durham')]]/following-sibling::tr//td//input[@name='deleteAddress']");
$x("//tr[.//div[contains(.,'Durham')]]/following-sibling::input[@name='deleteAddress']")
*/
		
	}
	
	public WebElement getShipDelete(CustomersData customer) {
		return findByXPath("//tr[.//div[contains(., " + "'" + customer.getShipAddress1()+ "'"+")]]/following-sibling::tr//td//a[2]");

	}
	
	public WebElement getPreferredShipping(){
		return findByXPath("//td[2]/p[contains(., 'preferred Shipping')]");
	}
	
	public WebElement getPreferredBilling(){
		return findByXPath("//tr[5]/td[2]/p[contains(., 'preferred Billing')]");
	}
	
	public WebElement getDeleteButton(){
		return findByCSSselector("button[name='deleteAddress']");
	}
	
	public void deleteAddress() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("input[name='deleteAddress']")));
		getShipDelete(customer).click();
		getDeleteButton().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("input[name='deleteAddress']")));
		getBillDelete(customer).click();
		getDeleteButton().click();
	}
}
