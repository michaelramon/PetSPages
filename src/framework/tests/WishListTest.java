package framework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class WishListTest extends TestBase {
	@Test
	public void verifyWishList() {
		// given: "A registered user is logged into account"
		utilities.signInInitial();
		// and: "The user clicks on the wish list"
		pageFactory.headerPage().getWishList().click();
		// and[: "A wish list is created"
		pageFactory.wishListPage().createPublicWishList(
				dataFactory.customersData().getWishListName());
		
		// when: "The user searches for an item and navigates to its product page"
		utilities.searchForItem(dataFactory.productData().getItem(0));
		// and: "the user asserts item is correct and adds it to wish list"
		pageFactory.productsPage().addItemtoWishList();
		
		// when: "The user searches for an item and navigates to its product page"
		utilities.searchForItem(dataFactory.productData().getItem(1));
		// and: "the user asserts item is correct and adds it to wish list"
		pageFactory.productsPage().addItemtoWishList();
		
		// when: "The user searches for an item and navigates to its product page"
		utilities.searchForItem(dataFactory.productData().getItem(2));
		// and: "the user asserts item is correct and adds it to wish list"
		pageFactory.productsPage().addItemtoWishList();
		// and: "The user signs out"
		pageFactory.headerPage().getSignOut().click();

		// when: "A guest user searches for wish list"
		pageFactory.headerPage().getWishList().click();
		// and: "The list is found"
		pageFactory.wishListPage().searchWishLists(
				dataFactory.customersData().getFirstName(),
				dataFactory.customersData().getLastName());
		// then: "The list contains the three items"
		Assert.assertEquals(pageFactory.wishListPage().getTotalItems()
				.getText(), (String
				.valueOf(dataFactory.productData().getSize())), String.format(
				"Expected total item count to be %s", dataFactory.productData()
						.getSize()));
	}

	@AfterClass
	public void teardown() {
		// when: "The user signs into account"
		utilities.signInInitial();
		// and: "The user clicks on the wish list link"
		pageFactory.headerPage().getWishList().click();
		// and: "The user deletes account"
		pageFactory.wishListPage().deleteWishList();

	}

}
