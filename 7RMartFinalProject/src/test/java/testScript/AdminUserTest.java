package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	AdminUserPage admin;

	@Test(groups = { "smoke" })

	public void adminUserAdding() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.readStringdata(1, 1, "LoginPage");
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButtonField();

		AdminUserPage page = new AdminUserPage(driver);
		page.clickOnAdminUser().clickOnManageUserButton().clickNew();
		FakerUtility faker = new FakerUtility();
		String username1 = faker.createUsername();
		String password1 = faker.createPassword();
		page.enterUsernameField(username1).enterPasswordField(password1).drpdwnSearch().clickSaveBtn();
		boolean isAlertDisplayed = page.isAlertVisible();
		Assert.assertTrue(isAlertDisplayed, Messages.NEWADMINFAILED);
	}
}
