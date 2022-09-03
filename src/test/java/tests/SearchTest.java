package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchTest extends TestBase 
{
	String productName = "Apple MacBook Pro 13-inch";
	
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsPageObject;
	 
	@Test
	public void UserCanSearchForProduct()
	{
		searchPageObject = new SearchPage(driver);
		productDetailsPageObject = new ProductDetailsPage(driver);
		
		searchPageObject.ProductSearch(productName);
		searchPageObject.openProductPage();
		Assert.assertTrue(productDetailsPageObject.productNameBreadcrumb
				.getText()
				.equalsIgnoreCase(productName));
		
		
	}
	

}
