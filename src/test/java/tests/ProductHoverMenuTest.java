package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase 
{
	HomePage homePageObj;
	
	@Test
	public void UserCanSelectSubCategoryFromMenu()
	{
		homePageObj = new HomePage(driver);
		homePageObj.openNotebooksPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
