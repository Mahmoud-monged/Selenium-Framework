package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class userRegistrationTest extends TestBase
{
	HomePage homePageObject;
	UserRegistrationPage RegistrationPageObject;
	LoginPage LoginPageObject;

	@Test (priority = 1, alwaysRun = true)
	public void userRegisterSuccessfully() 
	{
		homePageObject = new HomePage(driver);
		homePageObject.openRegistrationPage();

		RegistrationPageObject = new UserRegistrationPage(driver);
		RegistrationPageObject.userRegistration("Mahmoud", "Monged", "mm.mo1222@mail.com", "Mon", "123123");
		Assert.assertTrue(RegistrationPageObject.successfulRegisterMsg.getText().contains("Your registration completed"));
	}
	
	@Test (dependsOnMethods = {"userRegisterSuccessfully"})
	public void registeredUserCanLogoutSuccessfully()
	{
		RegistrationPageObject = new UserRegistrationPage(driver);
		RegistrationPageObject.userLogout();
	}
	
	
	@Test (dependsOnMethods = {"registeredUserCanLogoutSuccessfully"})
	public void userLoginSuccessfully() 
	{
		homePageObject = new HomePage(driver);
		homePageObject.openLoginPage();
		
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.userLogin("mm.mo1222@mail.com", "123123");
		
		Assert.assertTrue(RegistrationPageObject.logoutLink.isDisplayed());
	}
}