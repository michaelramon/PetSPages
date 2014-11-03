package framework.factories;

import org.openqa.selenium.WebDriver;

import framework.pages.AddressBookPage;
import framework.pages.ChangeAddressPage;
import framework.pages.CreateAccountPage;
import framework.pages.EditAddressPage;
import framework.pages.HeaderPage;
import framework.pages.MyAccountPage;
import framework.pages.ProductFrontPage;
import framework.pages.ProductsPage;
import framework.pages.WelcomePage;
import framework.pages.WishListPage;
import framework.utilities.Utilities;

public class PageFactory {
	protected WebDriver driver;

	public PageFactory(WebDriver driver) {
		this.driver = driver;
	}

	public Utilities utilities() {
		return new Utilities(driver);
	}

	public MyAccountPage myAccountPage() {
		return new MyAccountPage(driver);
	}

	public WelcomePage welcomePage() {
		return new WelcomePage(driver);
	}

	public AddressBookPage addressBookPage() {
		return new AddressBookPage(driver);
	}

	public EditAddressPage editAddressPage() {
		return new EditAddressPage(driver);
	}

	public ChangeAddressPage ChangeAddressPage() {
		return new ChangeAddressPage(driver);
	}

	public WishListPage wishListPage() {
		return new WishListPage(driver);
	}

	public ProductsPage productsPage() {
		return new ProductsPage(driver);
	}

	public CreateAccountPage createAccountPage() {
		return new CreateAccountPage(driver);
	}

	public HeaderPage headerPage() {
		return new HeaderPage(driver);
	}

	public ProductFrontPage productFrontPage() {
		return new ProductFrontPage(driver);
	}

}
