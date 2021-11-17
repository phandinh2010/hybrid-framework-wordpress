package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.CustomerInforPageUI;

public class CustomerInforPageObject extends BasePage {
	WebDriver driver;
	
	public CustomerInforPageObject (WebDriver driver) {
		this.driver = driver;
	}

	
	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInforPageUI.FIRSTNAME_TEXTBOX);
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInforPageUI.LASTNAME_TEXTBOX);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAttributeValue(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
	}


	

public boolean isCustomerInforPageDisplay() {
	waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	return isElementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
}		

}
