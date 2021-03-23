package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;


public class Level_06_Login_Page_Factory extends BaseTest {
	WebDriver driver;
	String emailAddress;
	String projectLocation = System.getProperty("user.dir");
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		emailAddress = "testing" + getRandomNumber() + "@gmail.com";
		homePage = new HomePageObject(driver);
	}

	@Test
	public void User_01_Register_To_System() {
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("test");
		sleepInSecond(5);
		registerPage.enterToLastNameTextbox("automation");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterBtn();

		Assert.assertTrue(registerPage.isSuccessMsgDisplay());
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void User_02_Login_To_System() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginBtn();

		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
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
