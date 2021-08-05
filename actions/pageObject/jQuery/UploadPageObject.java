package pageObject.jQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.UploadPageUI;

public class UploadPageObject  extends BasePage{
	WebDriver driver;

	public UploadPageObject(WebDriver driver) {		
		this.driver = driver;
	}
	
	public void uploadFiles(String... fileNames) {
		uploadMultipleFiles(driver, UploadPageUI.UPLOAD_FILE_TYPE, fileNames);
	}
	public boolean areFilenameLoadedSuccess(String[] fileNames) {
		boolean status = false;
		for (String fileName : fileNames) {
			if (isElementDisplayed(driver, UploadPageUI.LOADED_FILE_NAME, fileName)) {
				status = true;
			} else {
				return status;
			}			
		}
		return status;
	}

	public void clickToStartUploadButton() {
		//int uploadButtonSize = getElementNumber(driver, HomePageUI.START_UPLOAD_BUTTON);

		List<WebElement> uploadButtons = getListWebElement(driver, UploadPageUI.START_UPLOAD_BUTTON);
		for (WebElement uploadButton : uploadButtons) {
			uploadButton.click();
			sleepInSecond(2);
		}		
	}

	public boolean areFileUploadedSuccess(String[] fileNames) {
	boolean status = false;
	for (String fileName : fileNames) {
		if (isElementDisplayed(driver, UploadPageUI.UPLOADED_FILE_NAME, fileName)) {
			status = true;
		} else {
			return status;
		}		
	}
	return status;
	}
	
}
