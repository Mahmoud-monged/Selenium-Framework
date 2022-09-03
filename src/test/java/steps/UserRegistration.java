package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase  {
	
	HomePage homePageObj;
	UserRegistrationPage registerPagObj;
	
	@Given("The user in the home page")
	public void the_user_in_the_home_page() {
		homePageObj = new HomePage(driver);
	    homePageObj.openRegistrationPage();
		
	}
	@When("The user click on the register link")
	public void the_user_click_on_the_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	
	@When("The user entered {string}, {string}, {string}, {string}, {string}")
	public void the_user_entered(String firstName, String lastName, String email, String companyName, String password) {
		registerPagObj = new UserRegistrationPage(driver);
	    registerPagObj.userRegistration(firstName, lastName, email, companyName, password);
	}
	
	
	@Then("The registraion page displayed successfully")
	public void the_registraion_page_displayed_successfullys() {
		registerPagObj = new UserRegistrationPage(driver);
		registerPagObj.userLogout();
	    
		
	}

}
