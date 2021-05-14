package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.DashboardPageUI;

public class DashboardPageObject extends BasePage {

	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardHeaderTextDisplayed() {
		waitForElementVisible(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
		return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
	}

	public void clickToScreenOptionButton() {
		waitForElementClickable(driver, DashboardPageUI.SCREEN_OPTION_BUTTON);
		clickToElement(driver, DashboardPageUI.SCREEN_OPTION_BUTTON);
	}

	public boolean isAcitvityCheckboxDisplayed() {
		return isElementDisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}

	public boolean isAcitvityCheckboxUndisplayed() {
		return isElementDisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}

	public boolean isPostSearchTextboxUndisplay() {
		waitForElementInvisible(driver, DashboardPageUI.POST_SEARCH_TEXTBOX);
		return isElementDisplayed(driver, DashboardPageUI.POST_SEARCH_TEXTBOX);
	}
}
