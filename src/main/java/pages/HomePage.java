package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		actions = new Actions(driver);
	}
	
	@FindBy(linkText = "Register")
	WebElement registrationLink;
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	@FindBy(linkText = "My account")
	WebElement myAccountLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencyDropList;
	
	@FindBy(linkText = "Computers")
	WebElement computersLink;
	
	@FindBy(linkText = "Notebooks")
	WebElement notebookLink;
	
	
	
	public void openRegistrationPage() 
	{
		clickButton(registrationLink);
	}
	
	public void openLoginPage()
	{
		clickButton(loginLink);
	}
	
	public void openMyAccountPage() {
		clickButton(myAccountLink);	
	}
	
	public void openContactUsPage()
	{
		scrollToButton();
		clickButton(contactUsLink);
	}
	
	public void changeCurrencyToEuro() {
		select = new Select(currencyDropList);
		select.selectByVisibleText("Euro");
	}
	
	public void openNotebooksPage()
	{
		actions
		.moveToElement(computersLink)
		.moveToElement(notebookLink)
		.click()
		.build()
		.perform();
	}

}
