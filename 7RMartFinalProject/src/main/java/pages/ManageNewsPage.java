package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement managenews;
	@FindBy(xpath = "//*[text()=' New']")
	WebElement newbtn;
	@FindBy(xpath = "//*[@id='news']")
	WebElement enternews;
	@FindBy(xpath = "//*[@name='create']")
	WebElement savebtn;

	public ManageNewsPage manageNewsClick() {
		managenews.click();
		return this;
	}

	public ManageNewsPage enterNewBtn() {
		newbtn.click();
		return this;
	}
	public ManageNewsPage enterNews(String newnews) {
		enternews.sendKeys("managenews");
		return this;
	}
	public ManageNewsPage saveClick() {
		savebtn.click();
		return this;
	}
	
}
