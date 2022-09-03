package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchForProductUsingAutoSuggestTest extends TestBase {

	String productTxt = "Mac";
	SearchPage searchPageObject;
	ProductDetailsPage detailsPageObject;

	@Test
	public void SearchForProductUsingAutoSuggest()
	{
		try {
			searchPageObject  = new SearchPage(driver);
			searchPageObject.searchUsingAutoSuggest(productTxt);
			detailsPageObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsPageObject.productNameBreadcrumb.getText().contains(productTxt));
		} catch (Exception e) {
			System.out.println("Error Occurred  " + e.getMessage());
		}
	}

}
