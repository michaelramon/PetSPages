package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAddressPage extends BasePage {

	// creates a instance of a wait
	WebDriverWait wait = (new WebDriverWait(driver, 5));

	// creates an instance of the select class
	Select selectBox;

	public EditAddressPage(WebDriver driver) {
		super(driver);
	}

	// get location of country field
	public WebElement getCountry() {
		return findByID("AddressForm_CountryCode");

	}

	// set country
	public void setCountry(String value) {
		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector("button[name='createAddress']")));

		selectBox = new Select(driver.findElement(By
				.id("AddressForm_CountryCode")));
		selectBox.selectByValue(value);
	}

	// get telephone location
	public WebElement getTelephone() {
		return findByID("AddressForm_Phone");
	}

	// Address 1 Billing
	public WebElement getBillAddress() {
		return findByID("AddressForm_Address1");
	}

	// Address1 zip
	public WebElement getBillingZipcode() {
		return findByID("AddressForm_PostalCode");
	}

	// Address1 City
	public WebElement getBillingCity() {
		return findByID("AddressForm_City");
	}

	// Address 1 first name
	public WebElement getFirstName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("#AddressForm_FirstName")));
		return findByCSSselector("#AddressForm_FirstName");
	}

	// Address 1 last name
	public WebElement getLastName() {
		return findByID("AddressForm_LastName");
	}

	// get location of State field
	public WebElement getState() {
		return findByID("AddressForm_State");

	}

	// sends user data to state dropbox
	public void setState(String value) {
		selectBox = new Select(driver.findElement(By.id("AddressForm_State")));
		selectBox.selectByValue(value);
	}

	// Address 1 Ship
	public WebElement getShipAddress() {
		return findByID("AddressForm_Address1");
	}

	// Address1 city ship
	public WebElement getShipCity() {
		return findByID("AddressForm_City");
	}

	// Address 1 ship zip
	public WebElement getShipZipcode() {
		return findByID("AddressForm_PostalCode");
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


	public WebElement getDelete() {
		return findByLink("Delete");

	}

	public WebElement getPreferredShipping() {
		return findByXPath("//td[2]/p[contains(., 'preferred Shipping')]");
	}

	public WebElement getPreferredBilling() {
		return findByXPath("//tr[5]/td[2]/p[contains(., 'preferred Billing')]");
	}

	public WebElement getDeleteButton() {
		return findByCSSselector("button[name='deleteAddress']");
	}

	public void deleteAddress() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.linkText("Delete")));
		getDelete().click();
		getDeleteButton().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.linkText("Delete")));
		getDelete().click();
		getDeleteButton().click();
	}
}
