package framework.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductFrontPage extends BasePage{

	public ProductFrontPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getProduct(){
		return findByCSSselector("img.kor-zoom-default.ws-product-image");
	}

}
