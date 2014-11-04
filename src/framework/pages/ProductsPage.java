package framework.pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductsPage extends BasePage{

	public ProductsPage(WebDriver driver) {
		super(driver);	
		
	}
	public void addItemtoWishList(){
		clickOnAddWishList();
		Assert.assertTrue(getAddItemToWishList().isDisplayed());
		getAddItemToWishList().click();
	driver.navigate().refresh();
	}
	
	private WebElement getAddItemToWishList(){
		return findByCSSselector("button[name='addtoWishlist']");
	}

	private void clickOnAddWishList(){
		WebElement element = getAddToWishList();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	private WebElement getAddToWishList(){
		return findByCSSselector("a.ws-wshlst-add-to.kor-open-as-dialog");
		
	}
	public WebElement getProductTitle(){
		return findByCSSselector("h1.ws-product-title");
	}
	
}
