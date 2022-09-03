package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {
	
	HomePage homePageObject;
	UserRegistrationPage RegistrationPageObject;
	SearchPage searchPageObject;
	ProductDetailsPage detailsPageObject;
	ProductReviewsPage reviewPageObj;
	
	
	String productTxt = "Mac";
	String reviewTitle = "Excelent Product";
	String reivewText = "This product is very intersting";
	
	
	
	// 1- User Register
	@Test (priority = 1)
	public void userRegisterSuccessfully() 
	{
		homePageObject = new HomePage(driver);
		homePageObject.openRegistrationPage();

		RegistrationPageObject = new UserRegistrationPage(driver);
		RegistrationPageObject.userRegistration("Mahmoud", "Monged", "mmpot72@mail.com", "Mon", "123123");
		Assert.assertTrue(RegistrationPageObject.successfulRegisterMsg.getText().contains("Your registration completed"));
	}
	
	
	// 2- Search for a specific product
	@Test (priority = 2)
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
	
	
	// 3- Add review
	@Test (priority = 3)
	public void UserCanAddProductReview() 
	{
		detailsPageObject = new ProductDetailsPage(driver);
		reviewPageObj = new ProductReviewsPage(driver);
		
		detailsPageObject.openAddReviewPage();
		reviewPageObj.addProductRivew(reviewTitle, reivewText);
		Assert.assertTrue(reviewPageObj.successMsg.getText().contains("Product review is successfully added"));
	}
	
	
	// 4- User Logged out
	@Test (priority = 4)
	public void registeredUserCanLogoutSuccessfully()
	{
		RegistrationPageObject = new UserRegistrationPage(driver);
		RegistrationPageObject.userLogout();
	}

}
