package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.data.CustomersData;

public class AddressBookPage extends BasePage {
	// create an instance of the action class
	Actions act = new Actions(driver);
	// create an instance of the wait class
	WebDriverWait wait = (new WebDriverWait(driver, 10));

	public AddressBookPage(WebDriver driver) {
		super(driver);
	}

	// gets location of add new address link
	public WebElement getAddNewAddress() {
		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector(".ws-add-address")));
		return findByCSSselector("a.ws-add-address");
	}

	// clicks the add new address link
	public void clickAddNewAddress() {
		getAddNewAddress().click();
	}

	// click the Edit this address button
	public WebElement getEditBillAddress() {
		return findByXPath("//tr[.//div[contains(., " + "'"
				+ dataFactory.customersData().getBillAddress1() + "'"
				+ ")]]/following-sibling::tr//td//a");
	}

	// click the Edit this address button
	public WebElement getEditShipAddress() {
		return findByXPath("//tr[.//div[contains(., " + "'"
				+ dataFactory.customersData().getShipAddress1() + "'"
				+ ")]]/following-sibling::tr//td//a");
	}

	public void clickEditBillAddress() {
		getEditBillAddress()
				.click();

	}

	public void clickEditShipAddress() {
		// create a wait
		WebElement element = getEditShipAddress();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// getEditShipAddress().click();
	}

	// return the add new billing address link
	public WebElement getAddNewBilling() {
		return findByCSSselector(".ws-add-address");
	}

	// clicks the add new billing address link
	public void clickAddNewBilling() {
		// shawn's method by javascript
		WebElement element = getAddNewBilling();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
}
