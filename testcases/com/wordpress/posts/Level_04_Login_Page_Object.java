package com.wordpress.posts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Level_04_Login_Page_Object {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void beforeMothod() {
		driver.get("https://automationfc.wordpress.com/wp-admin");
		loginPage = new LoginPageObject(driver);
		
		
	}

	@Test
	public void Login_01_Empty_Email() {
		loginPage.inputToUsernameTextbox("");
		loginPage.clickToContinueBtn();
		loginPage.sleepInSecond(2);
		Assert.assertTrue(loginPage.isEmptyEmailErrorMsgDisplayed());

	}

	@Test
	public void Login_02_Invalid_Email() {

		loginPage.inputToUsernameTextbox("sfdgGDGD");
		loginPage.clickToContinueBtn();
		loginPage.sleepInSecond(2);
		
		String userNotExistMsg = loginPage.getInvalidEmailErrorMsg();
		Assert.assertEquals(userNotExistMsg, "User does not exist. Would you like to create a new account?");
	}

	@Test
	public void Login_03_Username_Note_Exist() {
		loginPage.inputToUsernameTextbox("autotest" + getRandomNumber());
		loginPage.clickToContinueBtn();
		loginPage.sleepInSecond(2);
		
		String userNotExistMsg = loginPage.getInvalidEmailErrorMsg();
		Assert.assertEquals(userNotExistMsg, "User does not exist. Would you like to create a new account?");
	}

	@Test
	public void Login_04_Empty_Password() {

		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueBtn();
		loginPage.sleepInSecond(2);
		
		loginPage.inputToPasswordBtn("");
		loginPage.clickToLoginBtn();
		loginPage.sleepInSecond(2);

		Assert.assertTrue(loginPage.isEmptyPasswordErrorMsgDisplayed());
	}

	@Test
	public void Login_05_Invalid_Password() {

		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueBtn();
		loginPage.sleepInSecond(2);
		
		loginPage.inputToPasswordBtn("1235gghh");
		loginPage.clickToLoginBtn();
		loginPage.sleepInSecond(2);
		
		Assert.assertTrue(loginPage.isInvalidPasswordErrorMsgDisplayed());
	}

	@Test
	public void Login_06_Incorrect_password() {
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueBtn();
		loginPage.sleepInSecond(2);
		
		loginPage.inputToPasswordBtn("dffgfhfhg");
		loginPage.clickToLoginBtn();
		loginPage.sleepInSecond(2);

		Assert.assertTrue(loginPage.isInvalidPasswordErrorMsgDisplayed());
	}

	@Test
	public void Login_07_Valid_Email_P() {
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueBtn();
		loginPage.sleepInSecond(2);
		
		loginPage.inputToPasswordBtn("automationfc");
		loginPage.clickToLoginBtn();
		loginPage.sleepInSecond(2);

		dashboardPage = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardPage.isDashboardHeaderTextDisplayed());
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
