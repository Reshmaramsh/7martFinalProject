package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='nav-link'])[10]")WebElement adminuser;
	@FindBy(xpath = "//p[text()='Manage Users']")WebElement manageuser;
	@FindBy(xpath = "//*[text()=' New']")WebElement newuser;
	@FindBy(id = "username")WebElement username;
	@FindBy(id = "password")WebElement password;
	@FindBy(id = "user_type")WebElement dropdownsearch;
	@FindBy(name = "Create")WebElement savebutton;
	@FindBy(xpath="//*[text()=' Search']") WebElement buttonSearchUser;
	@FindBy(xpath="//input[@class='form-control'][@id='un']") WebElement textofusersearch;
	@FindBy(xpath="//select[@id='ut']")  WebElement drpdwnusertypesearch;
	@FindBy(xpath="//button[@name='Search']") WebElement buttonsearch;
	@FindBy(xpath="//*[text()=' Reset']") WebElement buttonmainReset;
	@FindBy(xpath="//*[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	public HomePage clickOnAdminUser() {
		adminuser.click();
		return new HomePage(driver);
	}
	public AdminUserPage clickNew() {
		newuser.click();
		return this;
	}
	public boolean isAlertVisible() {
		return alert.isDisplayed();
	}

	public AdminUserPage enterUsernameField(String username1) {

		username.sendKeys(username1);
		return this;
	}
	public AdminUserPage enterPasswordField(String password1) {
		password.sendKeys(password1);
		return this;
	}

	public AdminUserPage drpdwnSearch() {
		Select select = new Select(dropdownsearch);
		select.selectByVisibleText("Staff");
		return this;
	}

	public AdminUserPage clickSaveBtn() {
		savebutton.click();
		return this;
	}
	
}

//assertion is a statement to verify test case.
