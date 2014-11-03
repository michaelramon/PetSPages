package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



 
public class ChangeAddressPage extends BasePage{

//	creates an instance of the wait class
	WebDriverWait wait = (new WebDriverWait(driver, 5));

	public ChangeAddressPage(WebDriver driver)  {
		// instantiate the firefox driver passed from Base Page
		super(driver);
	}
	
//	returns location of the submit button
	public WebElement getSubmit(){
//		waits until submit button is present before returning location of submit button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[name='continue']")));
		return findByCSSselector("button[name='continue']");
	}
	
//	clicks the submit button
	public void clickSubmit(){
		getSubmit().click();
	
	}
}
