package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	private WebElement oldPasswordTxtBox;
	
	@FindBy(id = "NewPassword")
	private WebElement newPasswordTxtBox;
	
	@FindBy(id = "ConfirmNewPassword")
	private WebElement confirmNewPasswordTxtBox;
	
	@FindBy(css = "button.button-1.change-password-button")
	private WebElement changePasswordBtn;
	
	@FindBy(css = "p.content")
	public WebElement resultB1;
	
	@FindBy(css = "span.close")
	public WebElement closeSpan;
	
	
	
	public void openChangePasswordPage() 
	{
		clickButton(changePasswordLink);
	}
	
	public void changePassword(String oldPassword, String newPassword)
	{
		setTxtElementTxt(oldPasswordTxtBox, oldPassword);
		setTxtElementTxt(newPasswordTxtBox, newPassword);
		setTxtElementTxt(confirmNewPasswordTxtBox, newPassword);
		clickButton(changePasswordBtn);		
	}
	
	public void closeSpanaBar() {
		clickButton(closeSpan);
		
	}
}
