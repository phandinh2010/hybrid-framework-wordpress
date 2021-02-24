package pageUIs.wordpress;

public class LoginPageUI {

	public static final String USERNAME_EMAIL_TEXTBOX = "//input[@id='usernameOrEmail']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='password']";
	public static final String CONTINUE_BUTTON = "//button[text()='Continue']";
	public static final String LOGIN_BUTTON = "//button[text()='Log In']";
	public static final String EMPTY_EMAIL_ERROR_MSG = "//span[text()='Please enter a username or email address.']";
	public static final String EMPTY_PASSWORD_ERROR_MSG = "//span[text()=\"Don't forget to enter your password.\"]";
	public static final String INVALID_EMAIL_ERROR_MSG = "//div[@class='form-input-validation is-error']";
	public static final String INVALID_PASSWORD_ERROR_MSG = "//span[text()=\"Oops, that's not the right password. Please try again!\"]";
	
	//public: access modify
	//static final: biến tĩnh, truy cập trực tiếp không cần New instance, final là cho cho phép ghi đè. là Hằng số (constant)_quy ước: Viết hoa hết, phân cách bởi dấu gạch dưới
}
