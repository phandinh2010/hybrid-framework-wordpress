package pageObject.jQuery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject  extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		
		this.driver = driver;
	}

	public void openpageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.HOME_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.HOME_PAGE_BY_NUMBER, pageNumber);
		
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public void inputToHearderTextboxByLabel(String labelName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, labelName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, value, labelName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL_NAME, Keys.ENTER, labelName);
	}

	public boolean areRowRecordDisplayed(String valueFemales, String valueCountry, String valueMales, String valueTotal) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_ALL_FIELD, valueFemales, valueCountry, valueMales, valueTotal );
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_ALL_FIELD, valueFemales, valueCountry, valueMales, valueTotal);
	}

	public void clickToIconByCountryName(String countryName, String actionName) {
		waitForElementClickable(driver, HomePageUI.ACTION_ICON_BY_NAME, countryName, actionName);
		clickToElement(driver, HomePageUI.ACTION_ICON_BY_NAME, countryName, actionName);
		
	}

	public void inputToTextboxByColumnNameAtRowNumber(String columnName, String rowIndex, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_NAME_PRECEDING, columnName );
		int columnIndex = getElementNumber(driver, HomePageUI.HEADER_NAME_PRECEDING, columnName) + 1;
		sendkeyToElement(driver, HomePageUI.TEXTBOX_AT_COLUMN_AND_ROw_INDEX, value, rowIndex, String.valueOf(columnIndex));
				
	}

	
	public boolean areFilenameLoadedSuccess(String[] fileNames) {
		boolean status = false;
		for (String fileName : fileNames) {
			if (isElementDisplayed(driver, HomePageUI.LOADED_FILE_NAME, fileName)) {
				status = true;
			} else {
				return status;
			}
			
		}
		return status;
	}

	public void clickToStartUploadButton() {
		//int uploadButtonSize = getElementNumber(driver, HomePageUI.START_UPLOAD_BUTTON);

		List<WebElement> uploadButtons = getListWebElement(driver, HomePageUI.START_UPLOAD_BUTTON);
		for (WebElement uploadButton : uploadButtons) {
			uploadButton.click();
			sleepInSecond(2);
		}
		
	}

	public boolean areFileUploadedSuccess(String[] fileNames) {
	boolean status = false;
	for (String fileName : fileNames) {
		if (isElementDisplayed(driver, HomePageUI.UPLOADED_FILE_NAME, fileName)) {
			status = true;
		} else {
			return status;
		}
		
	}
	return status;
	}
	
}
