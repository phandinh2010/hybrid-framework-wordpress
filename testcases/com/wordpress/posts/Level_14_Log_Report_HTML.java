package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import allure.results.AllureTestListener;
import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.PageGeneratorManager;

public class Level_14_Log_Report_HTML extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	
	//@Listeners({ AllureTestListener.class })
	@Epic("Regression Tests")
	@Feature("Login Tests")

	

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {		
		driver = getBrowserDriver(browserName, appURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueBtn();
		loginPage.sleepInSecond(2);
		
		loginPage.inputToPasswordBtn("automationfc");
		loginPage.clickToLoginBtn();
		loginPage.sleepInSecond(2);
		
		dashboardPage =  PageGeneratorManager.getDashboardPage(driver);
	}

	@Test
	public void Login_01_Element_Displayed() {
		log.info("Login - Step 01: Click to 'Screen option' button");
		dashboardPage.clickToScreenOptionButton();	
		loginPage.sleepInSecond(3);
		
		log.info("Login - Step 02: Verify Activity Checkbox displayed");
		verifyTrue(dashboardPage.isAcitvityCheckboxDisplayed());
		
		log.info("Login - Step 03: Click to 'Screen option' button");
		dashboardPage.clickToScreenOptionButton();
		
		loginPage.sleepInSecond(3);
		verifyFalse(dashboardPage.isAcitvityCheckboxDisplayed());			
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
