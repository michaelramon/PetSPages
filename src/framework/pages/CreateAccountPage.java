package framework.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage extends BasePage{


	public CreateAccountPage(WebDriver driver)  {
		super(driver);
	
	}
	
	// creates an account 
	public void createAccount(String email, String password, String confirm){
		getNewEmail().sendKeys(email);
		getNewPassword().sendKeys(password);
		getConfirmNewPassword().sendKeys(confirm);
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
