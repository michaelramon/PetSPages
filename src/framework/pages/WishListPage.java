package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WishListPage extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public WishListPage(WebDriver driver) {
		super(driver);

	}

	// create a new wish list with info passes by customersData
	public void createPublicWishList(String wishName) {
		Assert.assertTrue(getCreateWishList().isDisplayed());
		// clicks the create a wish list link
		getCreateWishList().click();
		// sends the wish list name to field
		getWishListName().sendKeys(wishName);
		// clicks the public privacy setting radio button
		getPublicPrivacySetting().click();
		// clicks the create a wish list link
		createNewWishList().click();
		// refresh the page
		driver.navigate().refresh();

	}

	// enters first name, last name and click on the search wish list link
	public void searchWishLists(String fName, String lName) {
		getFirstName().sendKeys(fName);
		getLastName().sendKeys(lName);
		getSearchWishLists().click();
	}

	// clicks the delete wish list, asserts the next link is present, then
	// deletes the wish list
	public void deleteWishList() {
		getWishDelete().click();
		wait.until(ExpectedConditions
				.elementToBeClickable(getWishDeleteConfirm()));
		getWishDeleteConfirm().click();
	}

	// gets the Create a wish list link
	public WebElement getCreateWishList() {
		return findByLink("Create a wish list");
	}

	// gets the search wish list link
	public WebElement getSearchWishLists() {
		return findByID("fndwshlst");

	}

	// gets wish list name field
	public WebElement getWishListName() {
		return findByID("wshlstCreateName");
	}

	// gets the public privacy setting radio buttons
	private WebElement getPublicPrivacySetting() {
		return findByID("CreateWishlistForm_isPublic_true");
	}

	// get the create wish lish link
	private WebElement createNewWishList() {
		return findByName("createNewWishlist");

	}

	// get the location of the wish list first name
	public WebElement getFirstName() {
		return findByID("fnamewish");
	}

	// get the location of the wish list last name
	public WebElement getLastName() {
		return findByID("lnamewish");
	}

	// get the location of the wish list email address
	public WebElement getEmailAddress() {
		return findByID("emailaddwish");
	}

	// gets the location of the total items in wish list
	public WebElement getTotalItems() {
		return findByCSSselector("td.ws-showlist-wishlist-total-items");
	}

	// gets the location of the delete wish list link
	private WebElement getWishDelete() {
		return findByLink("Delete");
	}

	// gets the location of the wish leist delete confirmation link
	private WebElement getWishDeleteConfirm() {
		return findByCSSselector("button.ws-submit");
	}

}
