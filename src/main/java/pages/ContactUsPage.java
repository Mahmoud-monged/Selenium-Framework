package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
	private WebElement fullNameTxtBox;
	
	@FindBy(id = "Email")
	private WebElement emailTxtBox;
	
	@FindBy(id = "Enquiry")
	private WebElement enquiryTxtBox;
	
	@FindBy(name = "send-email")
	private WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	public void ContactUs(String fullName, String email, String enquiry) {
		setTxtElementTxt(fullNameTxtBox, fullName);
		setTxtElementTxt(emailTxtBox, email);
		setTxtElementTxt(enquiryTxtBox, enquiry);
		clickButton(submitBtn);
	}

}
