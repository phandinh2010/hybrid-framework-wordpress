package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Level_05_Login_Multiple_Browser extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
	}

	@Parameters("url")
	@BeforeMethod
	public void beforeMothod(String appUrl) {
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


}
