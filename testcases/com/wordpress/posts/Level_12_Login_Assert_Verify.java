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

public class Level_12_Login_Assert_Verify extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
	}

	@Test
	public void Login_01_Assert() {
		// false
		Assert.assertTrue(false);

		// Pass
		Assert.assertTrue(true);

		// false
		Assert.assertFalse(true);

		// pass
		Assert.assertFalse(false);

	}

	@Test
	public void Login_02_Verify() {
		// false
		verifyTrue(false);

		// Pass
		verifyTrue(true);

		// false
		verifyFalse(true);

		// pass
		verifyFalse(false);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
