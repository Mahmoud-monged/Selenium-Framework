package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase
{
	String friendsEmail = "friend1@test.com";
	String presonalMsg = "This Item is recomended for you";

	// 1- User Registration
	HomePage homePageObject;
	UserRegistrationPage RegistrationPageObject;

	@Test (priority = 1)
	public void userRegisterSuccessfully() 
	{
		homePageObject = new HomePage(driver);
		homePageObject.openRegistrationPage();

		RegistrationPageObject = new UserRegistrationPage(driver);
		RegistrationPageObject.userRegistration("Mahmoud", "Monged", "mm.test22@mail.com", "Mon", "123123");
		Assert.assertTrue(RegistrationPageObject.successfulRegisterMsg.getText().contains("Your registration completed"));
	}

	// 2- Search For a product
	String productTxt = "Mac";
	SearchPage searchPageObject;
	ProductDetailsPage detailsPageObject;

	@Test(priority = 2)
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

	// 3- Email A Friend
	EmailFriendPage emailFriendPageObj;
	@Test(priority = 3)
	public void EmailFriendSuccessfully() 
	{
		emailFriendPageObj = new EmailFriendPage(driver);

		detailsPageObject.openEmailFriendPage();
		emailFriendPageObj.sendEmailFriend(friendsEmail, presonalMsg);
		Assert.assertTrue(emailFriendPageObj.successMsg.getText().contains("Your message has been sent"));

	}
	
	// 4- User Logout
	@Test (priority = 4)
	public void registeredUserCanLogoutSuccessfully()
	{
		RegistrationPageObject = new UserRegistrationPage(driver);
		RegistrationPageObject.userLogout();
	}

}
