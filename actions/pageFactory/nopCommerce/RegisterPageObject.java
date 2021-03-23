package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePage {
WebDriver driver;
	
	public RegisterPageObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="FirstName")
	@CacheLookup
	private WebElement firstNameTextbox;

	@FindBy(id="LastName")
	private WebElement lastNameTextbox;	
	
	@FindBy(id="Email")
	private WebElement emailTextbox;
	
	@FindBy(id="Password")
	private WebElement passwordTextbox;

	@FindBy(id="ConfirmPassword")
	private WebElement confirmPassword;	
	
	@FindBy(id="register-button")
	private WebElement registerButton;
	
	@FindBy(xpath="//div[@class='result' and text()='Your registration completed']")
	private WebElement registerSuccessMsg;
	
	@FindBy(xpath="//a[@class='ico-logout']")
	private WebElement logoutLink;

	public void enterToFirstNameTextbox(String value) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, value);
	}

	public void enterToLastNameTextbox(String value) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, value);
	}

	public void enterToEmailTextbox(String value) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, value);
	}

	public void enterToPasswordTextbox(String value) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, value);
	}

	public void enterToConfirmPasswordTextbox(String value) {
		waitForElementVisible(driver, confirmPassword);
		sendkeyToElement(driver, confirmPassword, value);
	}

	public void clickToRegisterBtn() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
		
	}

	public boolean isSuccessMsgDisplay() {
		waitForElementVisible(driver, registerSuccessMsg);
		return isElementDisplayed(driver, registerSuccessMsg);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}
}
