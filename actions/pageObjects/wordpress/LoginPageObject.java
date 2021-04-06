package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.LoginPageUI;

public class LoginPageObject extends BasePage {
	
	//Là 1 biến trung gian chỉ class này mới sử dụng, nhiệm vụ hứng lấy driver map từ class testcase qua
	WebDriver driver;	
		
	//Hàm khởi tạo (Contructor): trùng tên với class, không có kiểu trả về
	//Sẽ được gọi để chạy đầu tiên khi khởi tạo class
	//Nếu không viết rõ hàm khởi tạo thì trong quá trình chạy JVM sẽ tự tạo ra 1 hàm khởi tạo không có tham số
	//Trong 1 class có thể có 1 hoặc nhiều hàm khởi tạo nhưng: 
	//- Phải khác số lượng tham số
	//- Nếu cùng số lượng tham số thì phải khác kiểu dữ liệu của tham số
	//- Nếu cùng kiểu dự liệu tham số thì phải khác số lượng tham số
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public void inputToUsernameTextbox(String usernameOrEmail) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_EMAIL_TEXTBOX, usernameOrEmail);		
	}
	

	public void clickToContinueBtn() {
		waitForElementClickable(driver, LoginPageUI.CONTINUE_BUTTON);
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
		
	}

	public boolean isEmptyEmailErrorMsgDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
	}

	public String getInvalidEmailErrorMsg() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
	}

	public void inputToPasswordBtn(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void clickToLoginBtn() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public boolean isEmptyPasswordErrorMsgDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
	}

	public boolean isInvalidPasswordErrorMsgDisplayed() {
		
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
		return isElementDisplayed(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
	}
}
