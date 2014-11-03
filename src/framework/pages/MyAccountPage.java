package framework.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import framework.data.CustomersData;


public class MyAccountPage extends BasePage {

	// Create an instance of the wait class
	WebDriverWait wait = (new WebDriverWait(driver, 10));
	// create string variables
	String email, password;
	// create an instance of the customer data
	CustomersData customer = new CustomersData();

	public MyAccountPage(WebDriver driver)  {
		// instantiate the firefox driver passed from Base Page
		super(driver);

	}

	// gets location of the email field
	WebElement getLoginEmail() {
//		adds another wait because wasnt really working
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginForm_Login")));
		return driver.findElement(By.id("LoginForm_Login"));
	}

	// gets location of the password field
	private WebElement getLoginPassword() {
		return driver.findElement(By.id("LoginForm_Password"));
	}

	// enters data into email field
	public void enterDatainEmail(String userData) {
		
//		create a wait for email field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginForm_Login")));
//		calls getloginemail because wait.sendKeys wasn't waiting
			getLoginEmail().sendKeys(userData);
	}

	// enters data into password field
	public void enterDataInPassword(String userData) {
		getLoginPassword().sendKeys(userData);
	}

	// clicks the sign in button
	public void clickSignIn() {
		findByName("login").click();

	}

	// gets location of the address link
	private WebElement getAddressLink() {
		return findByXPath("//a[contains(text(),'Address Book')]");
	}

	// clicks the address book link
	public void clickAddressLink() {
		// waits for the address book link to be visible and then clicks it
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By
//				.xpath("//a[contains(text(),'Address Book')]")));
		getAddressLink().click();
	}
	
	//get the location of the forgot your password link
	public WebElement getForgotPassword(){
		return findByCSSselector("a.ws-forgot.kor-open-as-dialog");
	}
	
	//gets the location of the create account link
	public WebElement getCreateAccount(){
		return findByCSSselector("a.buttonws-button.pet-create-account-button");
	}

}