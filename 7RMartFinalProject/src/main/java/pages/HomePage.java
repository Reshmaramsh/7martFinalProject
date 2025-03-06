package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Admin")
	WebElement admin;
	@FindBy(linkText = "Logout")
	WebElement logout;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement signinbuttonclick;

	public HomePage clickOnAdminButton() {
		admin.click();
		return this;
	}

	public LoginPage clickOnLogoutButton() {
		logout.click();
		return new LoginPage(driver);
	}
	@FindBy(xpath = "//p[text()='Manage Users']")
    WebElement manageuser;
	public AdminUserPage clickOnManageUserButton() {
		manageuser.click();
		return new AdminUserPage(driver) ;
	}
	 public boolean isSignInButtonDisplayed() { return
	  signinbuttonclick.isDisplayed(); }
	 

}