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

public class Level_14_Log_Report_HTML extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {		
		driver = getBrowserDriver(browserName, appURL);
	}

	@Test
	public void Login_01_Element_Displayed() {
		log.info("Login - Step 01: Click to 'Screen option' button");
		dashboardPage.clickToScreenOptionButton();		
		
		log.info("Login - Step 02: Verify Activity Checkbox displayed");
		Assert.assertTrue(dashboardPage.isAcitvityCheckboxDisplayed());
		
		log.info("Login - Step 02: Click to 'Screen option' button");
		dashboardPage.clickToScreenOptionButton();
		
		loginPage.sleepInSecond(3);
		Assert.assertFalse(dashboardPage.isAcitvityCheckboxDisplayed());			
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
