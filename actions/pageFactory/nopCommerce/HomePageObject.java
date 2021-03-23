package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".ico-register")
	//@CacheLookup
	private WebElement registerLink;
	
	@FindBy(css=".ico-login")
	private WebElement loginLink;
	
	@FindBy(css=".ico-account")
	private WebElement myAccountLink;	
	
	
	public void clickToRegisterLink(){
		waitForElementVisible(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink(){
		waitForElementVisible(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
	}
}
