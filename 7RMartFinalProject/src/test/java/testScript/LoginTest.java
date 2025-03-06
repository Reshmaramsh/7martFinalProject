package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(priority = 1, description = "verification of user login with valid credentials",retryAnalyzer=retry.Retry.class,groups= {"smoke'"})

	public void verifyUserLoginWithValidUsernameAndValidPassword() throws IOException {

		String username = ExcelUtility.readStringdata(1, 0, "LoginPage");
		String password = ExcelUtility.readStringdata(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButtonField();
	}

	@Test(priority = 3, description = "verification of user login with invalidusername and correct password")
	public void verifyUserLoginWithIncorrectUsernameAndCorrectPassword() throws IOException {
		String username = ExcelUtility.readStringdata(2, 0, "LoginPage");
		String password = ExcelUtility.readStringdata(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButtonField();
	}

	@Test(priority = 2, description = "verification of user login with valid username and invalid password")
	public void verifyUserLoginWithCorrectUsernameAndIncorrectPassword() throws IOException {
		String username = ExcelUtility.readStringdata(3, 0, "LoginPage");
		String password = ExcelUtility.readStringdata(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButtonField();
	}

	@Test(priority = 4, description = "verification of user login with both username and password invalid",dataProvider="loginProvider")
	public void verifyUserLoginWithIncorrectUsernameAndIncorrectPassword(String username,String password) throws IOException {
		//String username = ExcelUtility.readStringdata(4, 0, "LoginPage");
		//String password = ExcelUtility.readStringdata(4, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSignInButtonField();
	}
	@DataProvider(name="loginProvider")//data providing annotation rather than excel
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"admin1234","admin1234"},
			new Object[] {"123","123"},
			//new Object[] {ExcelUtility.readStringdata(3, 0,"Login"),ExcelUtility.readStringdata(3,1 ,"Login")}
		};
	}
	}
//we should give a name
//to apply in a test case 
