package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.AboutUsPageUI;
import pageUIs.nopCommerce.NewsPageUI;

public class AboutUsPageObject extends BasePage {
	WebDriver driver;
	
		public AboutUsPageObject (WebDriver driver) {
		this.driver = driver;
		
	}

		public HomePageObject openHomePage() {
			waitForElementClickable(driver, AboutUsPageUI.HOME_PAGE_LINK);
			clickToElement(driver, AboutUsPageUI.HOME_PAGE_LINK);
			return PageGeneratorManager.getHomePage(driver);
		}



	

}
