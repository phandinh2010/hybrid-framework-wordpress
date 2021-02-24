package com.wordpress.posts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_03_Login_BasePage_ExtendsClass extends BasePage {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	By usernameTb = By.id("usernameOrEmail");
	By passTb = By.id("password");
	By continueBtn = By.xpath("//button[text()='Continue']");
	By loginBtn = By.xpath("//button[text()='Log In']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void beforeMothod() {
		// driver.get("https://automationfc.wordpress.com/wp-admin");
		openUrl(driver, "https://automationfc.wordpress.com/wp-admin");
	}

	@Test
	public void Login_01_Empty_Email() {
		// By emptyEmailErrorMsg = By.xpath("//span[text()='Please enter a username or email address.']");
//		driver.findElement(usernameTb).sendKeys("");
//		driver.findElement(continueBtn).click();

		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "");
		clickToElement(driver, "//button[text()='Continue']");
		Assert.assertTrue(isElementDisplayed(driver, "//span[text()='Please enter a username or email address.']"));
	}

	@Test
	public void Login_02_Invalid_Email() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "234@#$#%#^");
		clickToElement(driver, "//button[text()='Continue']");
		sleepInSecond(2);
		String userNotExistMsg = getElementText(driver, "//div[@class='form-input-validation is-error']");
		Assert.assertEquals(userNotExistMsg, "User does not exist. Would you like to create a new account?");
	}

	@Test
	public void Login_03_Username_Note_Exist() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "autotest" + getRandomNumber());
		clickToElement(driver, "//button[text()='Continue']");
		sleepInSecond(2);

		String userNotExistMsg = getElementText(driver, "//div[@class='form-input-validation is-error']");
		Assert.assertEquals(userNotExistMsg, "User does not exist. Would you like to create a new account?");
	}

	@Test
	public void Login_04_Empty_Password() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		clickToElement(driver, "//button[text()='Continue']");
		sleepInSecond(2);

		sendkeyToElement(driver, "//input[@id='password']", "");
		sleepInSecond(2);
		clickToElement(driver, "//button[text()='Log In']");
		sleepInSecond(2);

		Assert.assertTrue(isElementDisplayed(driver, "//span[text()=\"Don't forget to enter your password.\"]"));
	}

	@Test
	public void Login_05_Invalid_Password() {

		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		clickToElement(driver, "//button[text()='Continue']");
		sleepInSecond(2);

		sendkeyToElement(driver, "//input[@id='password']", "1111");
		clickToElement(driver, "//button[text()='Log In']");
		sleepInSecond(2);

		Assert.assertTrue(isElementDisplayed(driver, "//span[text()=\"Oops, that's not the right password. Please try again!\"]"));
	}

	@Test
	public void Login_06_Incorrect_password() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		clickToElement(driver, "//button[text()='Continue']");
		sleepInSecond(2);

		sendkeyToElement(driver, "//input[@id='password']", "124356789");
		clickToElement(driver, "//button[text()='Log In']");
		sleepInSecond(2);

		Assert.assertTrue(isElementDisplayed(driver, "//span[text()=\"Oops, that's not the right password. Please try again!\"]"));
	}

	@Test
	public void Login_07_Valid_Email_P() {
		sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		clickToElement(driver, "//button[text()='Continue']");
		sleepInSecond(2);

		sendkeyToElement(driver, "//input[@id='password']", "automationfc");
		clickToElement(driver, "//button[text()='Log In']");
		sleepInSecond(2);
		Assert.assertTrue(isElementDisplayed(driver, "//h1[text()='Dashboard']"));
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

}
