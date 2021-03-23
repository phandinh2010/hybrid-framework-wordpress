package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObject extends BasePage{
	WebDriver driver;
	
	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


@FindBy(id="Email")
@CacheLookup
private WebElement emailTextbox;

@FindBy(id="Password")
private WebElement passwordTextbox;

@FindBy(css=".button-1 login-button")
private WebElement loginButton;	

public void enterToEmailTextbox(String emailAddress) {
	waitForElementVisible(driver, emailTextbox);
	sendkeyToElement(driver, emailTextbox, emailAddress);	
	
}

public void enterToPasswordTextbox(String password) {
	waitForElementVisible(driver, passwordTextbox);
	sendkeyToElement(driver, passwordTextbox, password);
	
}

public void clickToLoginBtn() {
	waitForElementClickable(driver, loginButton);
	clickToElement(driver, loginButton);	
	}
}
