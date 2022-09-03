package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewsPage extends PageBase 
{

	public ProductReviewsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	private WebElement productReviewTitleTxtBox;
	
	@FindBy(id = "AddProductReview_ReviewText")
	private WebElement ReviewTextBox;
	
	@FindBy(id = "addproductrating_5")
	private WebElement reatingExcelentRadiobtn;
	
	@FindBy(name = "add-review")
	private WebElement submitReviewBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;  
	
	public void addProductRivew(String reviewTitle, String reviewTxt) 
	{
		setTxtElementTxt(productReviewTitleTxtBox, reviewTxt);
		setTxtElementTxt(ReviewTextBox, reviewTxt);
		clickButton(reatingExcelentRadiobtn);
		clickButton(submitReviewBtn);
	}

}
