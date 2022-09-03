package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class userRegistrationWithDDTAndDataProviderTest extends TestBase
{
	@DataProvider (name = "testData")
	public static Object [] [] userData() 
	{
		return new Object [] [] {
			{"Mahmoud", "Monged", "mm.mno72@mail.com", "KFC", "123456"},
			{"Ahmed", "Mod", "mm.Lc76@mail.com", "MAC", "12345678"}

		};
	}

	HomePage homePageObject;
	UserRegistrationPage RegistrationPageObject;
	LoginPage LoginPageObject;


	@Test (priority = 1, dataProvider = "testData")
	public void userRegisterSuccessfully(String firstName, String lastName, String email, String companyName, String Pass) 
	{
		homePageObject = new HomePage(driver);
		homePageObject.openRegistrationPage();

		RegistrationPageObject = new UserRegistrationPage(driver);
		RegistrationPageObject.userRegistration(firstName, lastName, email, companyName, Pass);
		Assert.assertTrue(RegistrationPageObject.successfulRegisterMsg.getText().contains("Your registration completed"));
		RegistrationPageObject.userLogout();
		homePageObject.openLoginPage();
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.userLogin(email, Pass);
		Assert.assertTrue(RegistrationPageObject.logoutLink.isDisplayed());
		RegistrationPageObject.userLogout();
	}
}

