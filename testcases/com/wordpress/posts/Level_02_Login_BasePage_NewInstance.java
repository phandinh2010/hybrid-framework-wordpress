package com.wordpress.posts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Login_BasePage_NewInstance {
	WebDriver driver;
	BasePage basePage;
	String projectLocation = System.getProperty("user.dir");
	By usernameTb = By.id("usernameOrEmail");
	By passTb = By.id("password");
	By continueBtn = By.xpath("//button[text()='Continue']");
	By loginBtn = By.xpath("//button[text()='Log In']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		basePage = new BasePage();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// https://stackoverflow.com/questions/50820314/j
	}

	@BeforeMethod
	public void beforeMothod() {
		// driver.get("https://automationfc.wordpress.com/wp-admin");
		basePage.openUrl(driver, "https://automationfc.wordpress.com/wp-admin");
	}

	@Test
	public void Login_01_Empty_Email() {
		// By emptyEmailErrorMsg = By.xpath("//span[text()='Please enter a username or email address.']");
//		driver.findElement(usernameTb).sendKeys("");
//		driver.findElement(continueBtn).click();

		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "");
		basePage.clickToElement(driver, "//button[text()='Continue']");
		Assert.assertTrue(basePage.isElementDisplayed(driver, "//span[text()='Please enter a username or email address.']"));

	}

	@Test
	public void Login_02_Invalid_Email() {
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "234@#$#%#^");
		basePage.clickToElement(driver, "//button[text()='Continue']");
		basePage.sleepInSecond(2);
		String userNotExistMsg = basePage.getElementText(driver, "//div[@class='form-input-validation is-error']");
		Assert.assertEquals(userNotExistMsg, "User does not exist. Would you like to create a new account?");	

	}

	@Test
	public void Login_03_Username_Note_Exist() {
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "autotest" + getRandomNumber());
		basePage.clickToElement(driver, "//button[text()='Continue']");
		basePage.sleepInSecond(2);

		String userNotExistMsg = basePage.getElementText(driver, "//div[@class='form-input-validation is-error']");
		Assert.assertEquals(userNotExistMsg, "User does not exist. Would you like to create a new account?");
	}

	@Test
	public void Login_04_Empty_Password() {
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		basePage.clickToElement(driver, "//button[text()='Continue']");		
		basePage.sleepInSecond(2);
		
		basePage.sendkeyToElement(driver, "//input[@id='password']", "");
		basePage.sleepInSecond(2);
		basePage.clickToElement(driver, "//button[text()='Log In']");
		basePage.sleepInSecond(2);
		
		Assert.assertTrue(basePage.isElementDisplayed(driver, "//span[text()=\"Don't forget to enter your password.\"]"));
		
	}

	@Test
	public void Login_05_Invalid_Password() {
		
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		basePage.clickToElement(driver, "//button[text()='Continue']");		
		basePage.sleepInSecond(2);		

		
		basePage.sendkeyToElement(driver, "//input[@id='password']", "1111");
		basePage.clickToElement(driver, "//button[text()='Log In']");		
		basePage.sleepInSecond(2);			
		
		Assert.assertTrue(basePage.isElementDisplayed(driver, "//span[text()=\"Oops, that's not the right password. Please try again!\"]"));

	}

	@Test
	public void Login_06_Incorrect_password() {
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		basePage.clickToElement(driver, "//button[text()='Continue']");		
		basePage.sleepInSecond(2);		

		
		basePage.sendkeyToElement(driver, "//input[@id='password']", "124356789");
		basePage.clickToElement(driver, "//button[text()='Log In']");		
		basePage.sleepInSecond(2);

		Assert.assertTrue(basePage.isElementDisplayed(driver, "//span[text()=\"Oops, that's not the right password. Please try again!\"]"));
	}

	@Test
	public void Login_07_Valid_Email_P() {
		basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
		basePage.clickToElement(driver, "//button[text()='Continue']");		
		basePage.sleepInSecond(2);		

		
		basePage.sendkeyToElement(driver, "//input[@id='password']", "automationfc");
		basePage.clickToElement(driver, "//button[text()='Log In']");		
		basePage.sleepInSecond(2);
		Assert.assertTrue(basePage.isElementDisplayed(driver, "//h1[text()='Dashboard']"));
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
