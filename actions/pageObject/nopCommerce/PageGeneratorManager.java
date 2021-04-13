package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static PageGeneratorManager getPageGererator() {
		return new PageGeneratorManager();
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static CustomerInforPageObject getCustomerInforPage(WebDriver driver) {
		return new CustomerInforPageObject(driver);
	}
	
	public static AboutUsPageObject getAboutUsPage(WebDriver driver) {
		return new AboutUsPageObject(driver);
	}
	public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
	public static SiteMapPageObject getSiteMapPage(WebDriver driver) {
		return new SiteMapPageObject(driver);
	}
	public static NewsPageObject getNewsPage(WebDriver driver) {
		return new NewsPageObject(driver);
	}
	

	
}
