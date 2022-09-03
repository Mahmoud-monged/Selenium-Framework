package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase 
{
	
	HomePage homePageObject;
	UserRegistrationPage RegistrationPageObject;
	MyAccountPage myAccountObject;
	LoginPage LoginPageObject;
	
	String oldPassword = "123123";
	String newPassword = "123456";
	String firstName = "Mahmoud";
	String lastName = "Monged";
	String email = "mm.mo998@mail.com";
	String companyName = "mon";
	

	@Test (priority = 1)
	public void userRegisterSuccessfully() 
	{
		homePageObject = new HomePage(driver);
		homePageObject.openRegistrationPage();

		RegistrationPageObject = new UserRegistrationPage(driver);
		RegistrationPageObject.userRegistration(firstName, lastName, email, companyName, oldPassword);
		Assert.assertTrue(RegistrationPageObject.successfulRegisterMsg.getText().contains("Your registration completed"));
	}
	
	@Test (priority = 2)
	public void RegisteredUserCanChangePassword() {
		
		myAccountObject = new MyAccountPage(driver);
		homePageObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.changePassword(oldPassword, newPassword); 
		Assert.assertTrue(myAccountObject.resultB1.getText().contains("Password was changed"));
		myAccountObject.closeSpanaBar();
	}
	
	@Test (priority = 3)
	public void registeredUserCanLogoutSuccessfully()
	{
		RegistrationPageObject = new UserRegistrationPage(driver);
		RegistrationPageObject.userLogout();
	}
	
	
	@Test (priority = 4)
	public void userLoginSuccessfully() 
	{
		homePageObject = new HomePage(driver);
		homePageObject.openLoginPage();
		
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.userLogin(email, newPassword);
		
		Assert.assertTrue(RegistrationPageObject.logoutLink.isDisplayed());
	}
	
}
