package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase
{
	String productTxt = "Mac";
	
	
	SearchPage searchPageObject;
	ProductDetailsPage detailsPageObject;
	WishListPage wishListObj;
	
	
	
	
	// 1- Search for a product
	@Test (priority = 1)
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
	
	// 2- Add product to wishList and go to wish list page
	@Test (priority = 2)
	public void addProductToWishList() {
		detailsPageObject = new ProductDetailsPage(driver);
		detailsPageObject.addProductToWishList();
	}
	
	
	// 3- verify that product added to the wishList and remove it.
	@Test (priority = 3)
	public void veriftThatProductAddedToWishListThenRemoveIt() 
	{
		wishListObj = new WishListPage(driver);
		
		wishListObj.removeProductFromWishList();
		Assert.assertTrue(wishListObj.emptyCartLbl.getText().contains("The wishlist is empty!"));
	
	}
	

}
