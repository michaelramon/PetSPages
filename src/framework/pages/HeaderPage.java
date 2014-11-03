package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends BasePage {
	WebDriverWait wait;
	
	public HeaderPage(WebDriver driver) {
		super(driver);	
	}

	// return the location of sign in button
	public WebElement getSignIn() {
		// locate the sign in button on page
		return findByLink("Sign in");
	}

	// gets the wish list link
	public WebElement getWishList() {
		wait.until(ExpectedConditions.elementToBeClickable(By
				.cssSelector("a.pet-header-utility-link")));
		return findByCSSselector("a.pet-header-utility-link");

	}

	public WebElement getSearchBar() {
		return findByID("searchForm");
	}

	public void searchForItem(String userData) {
		getSearchBar().clear();
		getSearchBar().sendKeys(userData);
		getSearchButton().click();
	}

	public WebElement getSearchButton() {
		return findByCSSselector("button[type=submit]");
	}

	// gets the location of the sign outlink
	public WebElement getSignOut() {
		return findByCSSselector("a.pet-header-secondary-link.pet-header-secondary-link-logout");
	}

}
