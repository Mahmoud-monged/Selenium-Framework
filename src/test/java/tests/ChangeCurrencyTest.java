package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase 
{
	HomePage homePageObj;
	ProductDetailsPage productDetailsObj;
	SearchPage searchPageObject;
	
	String productTxt = "Mac";
	
	
	@Test(priority = 1)
	public void userCanchangeCurrency() {
		homePageObj = new HomePage(driver);
		productDetailsObj = new ProductDetailsPage(driver);
		
		homePageObj.changeCurrencyToEuro();
		
	}
	
	
	@Test(priority = 2)
	public void SearchForProductUsingAutoSuggest()
	{
		try {
			searchPageObject  = new SearchPage(driver);
			searchPageObject.searchUsingAutoSuggest(productTxt);
			productDetailsObj = new ProductDetailsPage(driver);
			Assert.assertTrue(productDetailsObj.productNameBreadcrumb.getText().contains(productTxt));
			
			Assert.assertTrue(productDetailsObj.priceValue.getText().contains("€"));
			System.out.println(productDetailsObj.priceValue.getText());
		} catch (Exception e) {
			System.out.println("Error Occurred  " + e.getMessage());
		}
	}
	

}
