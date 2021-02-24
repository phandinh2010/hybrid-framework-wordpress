package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitForElementVisiable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);		
	}

	public void clickToLoginLink() {
		waitForElementVisiable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);	
		
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisiable(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

}
