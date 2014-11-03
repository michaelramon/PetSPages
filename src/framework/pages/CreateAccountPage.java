package framework.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.data.CustomersData;

public class CreateAccountPage extends BasePage{
	// create the instance of the customer
	CustomersData customer = new CustomersData();

	public CreateAccountPage(WebDriver driver)  {
		super(driver);
	
	}
	
	// creates an account 
	public void createAccount(){
		getNewEmail().sendKeys(customer.setEmail());
		getNewPassword().sendKeys(customer.setPassword());
		getConfirmNewPassword().sendKeys(customer.setPassword());
		getCreateAccountLink().click();
	}
	
	// gets the location of the new email field
	private WebElement getNewEmail(){
		return findByID("RegisterUserFullEmail_Login");
				
	}
	// gets the location of the new password field
	private WebElement getNewPassword(){
		return findByID("RegisterUserFullEmail_Password");
	}
	//gets the location of the confirm password field
	private WebElement getConfirmNewPassword(){
		return findByID("RegisterUserFullEmail_PasswordConfirmation");
	}
	//gets the location of the create account link
	private WebElement getCreateAccountLink(){
		return findByCSSselector("button[name='CreateAccount']");
		
	}
	
	
	
}
