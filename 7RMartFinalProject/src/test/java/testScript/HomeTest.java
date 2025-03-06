package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test(description="To check verifier able to click logout ")

	public void homeAdminAndLogout() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringdata(1, 0,"LoginPage");
		String password = ExcelUtility.readStringdata(1, 1,"LoginPage");
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButtonField();
		HomePage home = new HomePage(driver);
		home.clickOnAdminButton().clickOnLogoutButton();
		
		boolean isSignInButtonDisplayed=home.isSignInButtonDisplayed();
		Assert.assertTrue(isSignInButtonDisplayed,Messages.LOGOUTFAILED);

	}

}
