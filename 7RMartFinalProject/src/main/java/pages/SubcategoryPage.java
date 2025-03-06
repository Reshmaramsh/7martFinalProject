package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import utilities.PageUtility;

public class SubcategoryPage {
	PageUtility utility= new PageUtility();
	public WebDriver driver;

	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//p[text()='Sub Category'])[1]") WebElement subcategoryclick;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newbutton;
	@FindBy(id = "cat_id") WebElement category;
	@FindBy(id = "subcategory") WebElement textsubcategory;
	@FindBy(id = "main_img") WebElement choosefile;
	@FindBy(xpath = "//button[@name='create']") WebElement savebutton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement subcategorysearch;
	@FindBy(id = "un") WebElement searchcategory;
	@FindBy(name = "ut") WebElement textsearchsubcategory;
	@FindBy(name = "Search") WebElement searchbuttonclick;
	@FindBy(xpath="//*[text()=' Reset']") WebElement buttonReset;
	@FindBy(xpath="//*[text()=' Alert!']") WebElement alertSubCategory;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td") WebElement resultTable;
	@FindBy(xpath="(//div[@class='row'])[2]") WebElement Assertionofreset;
	
	public SubcategoryPage selectSubCategory() {
		subcategoryclick.click();
		return this;

	}

	public SubcategoryPage clickOnNewBtnOnTheSubCategoryPage() {
		newbutton.click();
		return this;
	}

	public SubcategoryPage selectCategoryFromDropdown() {
		utility.SelectValueWithVisibleText(category, "burger");
		return this;
		
	}

	public SubcategoryPage enterSubCategoryName(String subcategory) {
		textsubcategory.sendKeys(subcategory);
		return this;
	}

	public SubcategoryPage uploadImage() {
		choosefile.sendKeys(Constants.IMAGEFILE);
		return this;
	}

	public SubcategoryPage clickOnSaveBtnInTheSubCategoryPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(savebutton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", savebutton);
		return this;
		
	}
	public  boolean isAlertDisplayedForSubCategoryPageCreation()
	{
		return alertSubCategory.isDisplayed();
	}

	public SubcategoryPage  clickOnSearchBtnInTheSubCategoryPage() {
		subcategorysearch.click();
		return this;
	}

	public SubcategoryPage selectSubCategoryFromTheDropdown() {
		utility.SelectValueWithVisibleText(searchcategory, "Accessories");
		return this;
	}

	public SubcategoryPage enterTheSubCategoryName(String subcategorysearch) {
		textsearchsubcategory.sendKeys(subcategorysearch);
		return this;
	}

	public SubcategoryPage clickSearchBtnAfterFillingTheDetails() {
		searchbuttonclick.click();
		return this;
	}
	public boolean isTableDisplayed()
	{
		return resultTable.isDisplayed();
	}
	
	public SubcategoryPage clickOnTheResetButton()
	{
		buttonReset.click();
		return this;
	}
	public boolean searchIfRestWorking()
	{
		return Assertionofreset.isDisplayed();
	}

}

