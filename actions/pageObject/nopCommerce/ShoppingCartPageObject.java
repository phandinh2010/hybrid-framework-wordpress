package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {
	WebDriver driver;
	
		public ShoppingCartPageObject (WebDriver driver) {
		this.driver = driver;
		
	}

		public AboutUsPageObject openAboutUsPage() {
			waitForElementClickable(driver, ShoppingCartPageUI.ABOUT_US_LINK);
			clickToElement(driver, ShoppingCartPageUI.ABOUT_US_LINK);
			return PageGeneratorManager.getAboutUsPage(driver);
		}

	

}
