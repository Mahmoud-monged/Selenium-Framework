package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	private WebElement friendsEmailTxtBox;
	
	@FindBy(id = "YourEmailAddress")
	private WebElement yourEmailTxtBox;
	
	@FindBy(id = "PersonalMessage")
	private WebElement personalMessageTxtBox;
	
	@FindBy(name = "send-email")
	private WebElement sendEmailBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	
	public void sendEmailFriend(String friendsEmail, String personalMessage)
	{
		setTxtElementTxt(friendsEmailTxtBox, friendsEmail);
		setTxtElementTxt(personalMessageTxtBox, personalMessage);
		clickButton(sendEmailBtn);
	}

}
