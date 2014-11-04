package framework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class AddPreferredTest extends TestBase {

	@Test
	public void test() {
		// given: "A registered user is logged into account"
		utilities.signInInitial();

		// when: "The user navigates to their account link"
		pageFactory.welcomePage().getMyAccountLink().click();
		// and: "The user asserts the my account link is present on page"
		Assert.assertTrue(pageFactory.welcomePage().getMyAccountLink()
				.isDisplayed());

		// when: "The user clicks on the address link"
		pageFactory.myAccountPage().clickAddressLink();
		// and: "The user adds the new shipping address"
		utilities.addShippingAddress();
		// and: "The user adds the new billing address"
		utilities.addBillingAddress();
		// and: "The user adds a preferred shipping option"
		utilities.addPreferredShipping();
		// and: "The user adds a preferred billing option"
		utilities.addPreferredBilling();
		// then: "The user asserts the perferred shipping is enabled"
		Assert.assertTrue(pageFactory.editAddressPage().getPreferredShipping()
				.isDisplayed());
		// then: "The user asserts the perferred billing is enabled"
		Assert.assertTrue(pageFactory.editAddressPage().getPreferredBilling()
				.isDisplayed());

	}

	@AfterClass
	public void close() {

		// when: "Thse user navigates to the account link"
		pageFactory.welcomePage().clickMyAccountLink();
		// and: "The user assert the my account link is present on page"
		Assert.assertTrue(pageFactory.myAccountPage().getAddressLink()
				.isDisplayed());
		// and: "The user click the address book link in left column"
		pageFactory.myAccountPage().clickAddressLink();
		// and: "The user refreshes the page to enable the delete link"
		driver.navigate().refresh();
		// and: "The user deletes the address stored to reset user data"
		pageFactory.editAddressPage().deleteAddress();

	}

}