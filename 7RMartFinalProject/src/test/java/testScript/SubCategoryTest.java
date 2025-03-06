package testScript;




import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import pages.SubcategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	
	@Test(priority= 1, description="Is Subcategory filed able to upload image and other credentials")
	public void subCategoryfile() throws IOException {
		String username = ExcelUtility.readStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.readStringdata(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButtonField();
		
		SubcategoryPage subcategorypage = new SubcategoryPage(driver);
		subcategorypage.selectSubCategory();
		subcategorypage.clickOnNewBtnOnTheSubCategoryPage();
		subcategorypage.selectCategoryFromDropdown();
		String subcategory = ExcelUtility.readStringdata(1, 0, "SubCategoryPage");
		subcategorypage.enterSubCategoryName(subcategory);
		subcategorypage.uploadImage();
		subcategorypage.clickOnSaveBtnInTheSubCategoryPage();
		boolean isAlertDisplayedForSubcategoryCreation=subcategorypage.isAlertDisplayedForSubCategoryPageCreation();
		Assert.assertTrue(isAlertDisplayedForSubcategoryCreation,Messages.SUBCATEGORYCREATIONFAILED);
	}
	@Test(priority=2, description="To check Subcatory field could able to search")
	public void verifyUserAbleToSearchSubcategory() throws IOException
	{
		String username = ExcelUtility.readStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.readStringdata(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButtonField();
		SubcategoryPage subcategorypage = new SubcategoryPage(driver);
		subcategorypage.selectSubCategory();
		subcategorypage.clickOnSearchBtnInTheSubCategoryPage();
		subcategorypage.selectSubCategoryFromTheDropdown();
		String subcategorysearch=ExcelUtility.readStringdata(1, 1, "SubCategoryPage");
		subcategorypage.enterTheSubCategoryName(subcategorysearch);
		subcategorypage.clickSearchBtnAfterFillingTheDetails();
		boolean isSearchTableIsDisplayed=subcategorypage.isTableDisplayed();
		Assert.assertTrue(isSearchTableIsDisplayed, Messages.TABLENOTDISPLAYED);
	}
	@Test(priority=3,description="To check the Reset button is functioning well")
	
	public void verifyRestButtonFunctionality() throws IOException
	{
		String username = ExcelUtility.readStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.readStringdata(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButtonField();
		SubcategoryPage subcategorypage = new SubcategoryPage(driver);
		subcategorypage.selectSubCategory();
		subcategorypage.clickOnSearchBtnInTheSubCategoryPage();
		subcategorypage.selectSubCategoryFromTheDropdown();
		String subcategorysearch=ExcelUtility.readStringdata(1, 1, "SubCategoryPage");
		subcategorypage.enterTheSubCategoryName(subcategorysearch);
		subcategorypage.clickSearchBtnAfterFillingTheDetails();
		subcategorypage.clickOnTheResetButton();
		boolean Assertionofreset=subcategorypage.searchIfRestWorking();
		Assert.assertFalse(Assertionofreset, Messages.RESETFAILED);
	}
}