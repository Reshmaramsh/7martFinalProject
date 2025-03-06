package testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	ManageNewsPage news;


	@Test
	public void checkManageNews() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.readStringdata(1, 1, "LoginPage");
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButtonField();
		
		String news = ExcelUtility.readStringdata(1, 0, "ManageNews");
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.manageNewsClick().enterNewBtn().enterNews(news).saveClick();
	}
}
