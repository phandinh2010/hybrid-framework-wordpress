package com.wordpress.posts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wordpress.common.Common_01_Register;

import allure.results.AllureTestListener;
import commons.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.PageGeneratorManager;

public class Level_15_Share_State extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	
	

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {		
		driver = getBrowserDriver(browserName, appURL);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void Login_01_Login() {		
		loginPage.inputToUsernameTextbox(Common_01_Register.email);
		loginPage.clickToContinueBtn();
		loginPage.sleepInSecond(2);
		
		loginPage.inputToPasswordBtn(Common_01_Register.password);
		loginPage.clickToLoginBtn();
		loginPage.sleepInSecond(2);
		
		dashboardPage =  PageGeneratorManager.getDashboardPage(driver);
	}			
	
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
