package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.NewsPageUI;

public class NewsPageObject extends BasePage {
	WebDriver driver;
	
		public NewsPageObject (WebDriver driver) {
		this.driver = driver;
		
	}

		public ShoppingCartPageObject openShoppingCartPage(WebDriver driver) {
			waitForElementClickable(driver, NewsPageUI.SHOPPING_CART_LINK);
			clickToElement(driver, NewsPageUI.SHOPPING_CART_LINK);			
			return PageGeneratorManager.getShoppingCartPage(driver);
		}


	

}
