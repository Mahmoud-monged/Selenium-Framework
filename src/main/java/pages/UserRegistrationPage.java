package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	
	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "gender-male")
	WebElement maleGenderRadioBtn;
	
	@FindBy(id = "gender-female")
	WebElement femaleGenderRadioBtn;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTxtBtn;
	
	@FindBy(id = "LastName")
	WebElement lastNameTxtBtn;
	
	@FindBy(name = "DateOfBirthDay")
	WebElement dayOfBirth;
	
	@FindBy(name = "DateOfBirthMonth")
	WebElement monthOfBirth;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement yearOfBirth;
	
	@FindBy(id = "Email")
	WebElement emailTxtBtn;
	
	@FindBy(id = "Company")
	WebElement companyNameTxtBtn;
	
	@FindBy(id = "Newsletter")
	WebElement newsletterCheckBox;
	
	@FindBy(id = "Password")
	WebElement passwordTxtBtn;
	
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPasswordTxtBtn;
	
	@FindBy(id = "register-button")
	WebElement registerbtn;
	
	@FindBy(css = "div.result")
	public WebElement successfulRegisterMsg;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	public void userRegistration(String firstName, String lastName, String email, String companyName, String password) 
	{
		clickButton(maleGenderRadioBtn);
		setTxtElementTxt(firstNameTxtBtn, firstName);
		setTxtElementTxt(lastNameTxtBtn, lastName);
		setTxtElementTxt(emailTxtBtn, email);
		setTxtElementTxt(companyNameTxtBtn, companyName);
		setTxtElementTxt(passwordTxtBtn, password);
		setTxtElementTxt(ConfirmPasswordTxtBtn, password);
		clickButton(registerbtn);
		
	}
	
	public void userLogout() 
	{
		clickButton(logoutLink);
	}

}
