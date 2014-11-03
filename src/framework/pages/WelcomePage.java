package framework.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WelcomePage extends BasePage{
// creates an instance of a wait class
	WebDriverWait wait = (new WebDriverWait(driver, 5));

	
	public WelcomePage(WebDriver driver)  {
//		instantiate the firefox driver passed from Base Page
		super(driver);
		
	}
// returns location of the my account link
	public WebElement getMyAccountLink(){
//		waits for element to be present and then returns location
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='My Account']")));
		return findByCSSselector("[title='My Account']");
	}
	
//	clicks on the account link
	public void clickMyAccountLink(){
		getMyAccountLink().click();
		
	}
}
