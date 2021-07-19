package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.SiteMapPageUI;

public class SiteMapPageObject extends BasePage {
	WebDriver driver;
	
		public SiteMapPageObject (WebDriver driver) {
		this.driver = driver;
		
	}

		public NewsPageObject openNewsPage(WebDriver driver) {
			waitForElementClickable(driver, SiteMapPageUI.NEWS_PAGE_LINK);
			clickToElement(driver, SiteMapPageUI.NEWS_PAGE_LINK);
			return PageGeneratorManager.getNewsPage(driver);
		}

	

}
