package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	
	public static PageGeneratorManager getPageGererator() {
		return new PageGeneratorManager();
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	

	
}
