package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadcrumb;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy(id = "price-value-4")
	public WebElement priceValue;
	
	@FindBy(linkText = "Add your review")
	WebElement addReviewBtn;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	@FindBy(css = "span.close")
	WebElement closeWishListMsg;
	
	@FindBy(css = "span.wishlist-label")
	WebElement wishElementLink;
	
	
	public void openEmailFriendPage() {
		clickButton(emailFriendBtn);
	}
	
	public void openAddReviewPage()
	{
		clickButton(addReviewBtn);
	}
	
	public void addProductToWishList()
	{
		clickButton(addToWishListBtn);
		clickButton(closeWishListMsg);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		clickButton(wishElementLink);
	}

}
