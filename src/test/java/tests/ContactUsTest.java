package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase 
{
	String fullName = "Mamm Mon Saas";
	String email = "mm.oo2@mail.com";
	String enquiry = "This is my enquiry text";
	
	HomePage homePageObject;
	ContactUsPage contactUspageObject;
	
	@Test
	public void contactUsTest() {
		
		homePageObject = new HomePage(driver);
		contactUspageObject = new ContactUsPage(driver);
		
		homePageObject.scrollToButton();
		homePageObject.openContactUsPage();
		
		contactUspageObject.ContactUs(fullName, email, enquiry);
		Assert.assertTrue(contactUspageObject.successMsg
				.getText()
				.contains("Your enquiry has been successfully sent to the store owner"));
	}
	

}
