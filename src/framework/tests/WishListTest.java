package framework.tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class WishListTest extends TestBase {


	@Test
	public void verifyWishList() {
		// given: "A registered user is logged into account"
		pageFactory.utilities().signInInitial();
		// and: "The user clicks on the wish list"
		pageFactory.headerPage().getWishList().click();
		// and[: "A wish list is created"
		pageFactory.wishListPage().createPublicWishList();

		// when: "The user searches for three items"
		pageFactory.headerPage().searchForItem(
				dataFactory.productData().getItem(0));
		Assert.assertEquals(
				pageFactory.productsPage().getProductTitle().getText(),
				dataFactory.productData().getItem(0),
				String.format("Expected product title to be %s", pageFactory
						.productsPage().getProductTitle().getText()));
		// and: "Then adds them to wish list"
		pageFactory.productsPage().addItemtoWishList();
		// and: "Then search for item"
		pageFactory.headerPage().searchForItem(
				dataFactory.productData().getItem(1));
		// and: "Then adds them to wish list"
		pageFactory.productsPage().addItemtoWishList();
		// and: "Then search for item"
		pageFactory.headerPage().searchForItem(
				dataFactory.productData().getItem(2));
		// and: "Then adds them to wish list"
		pageFactory.productsPage().addItemtoWishList();
		// and: "The user signs out"
		pageFactory.headerPage().getSignOut().click();

		// when: "A guest user searches for wish list"
		pageFactory.headerPage().getWishList().click();
		// and: "The list is found"
		pageFactory.wishListPage().searchWishLists();
		// then: "The list contains the three items"
		Assert.assertEquals(pageFactory.wishListPage().getTotalItems()
				.getText(), (String.valueOf(dataFactory.productData().getSize())),
				String.format("Expected total item count to be %s", dataFactory
						.productData().getSize()));
	}

	@AfterClass
	public void teardown() {
		// when: "The user signs into account"
		pageFactory.utilities().signInInitial();
		// and: "The user clicks on the wish list link"
		pageFactory.headerPage().getWishList().click();
		// and: "The user deletes account"
		pageFactory.wishListPage().deleteWishList();

	}

}
