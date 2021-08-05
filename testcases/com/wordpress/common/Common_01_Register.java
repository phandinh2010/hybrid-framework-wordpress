package com.wordpress.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.PageGeneratorManager;

public class Common_01_Register extends BaseTest {
	private WebDriver driver;
	public static String email, password;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;

	

	@Parameters({"browser","url"})
	@BeforeTest //chạy trước tất cả các class
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "commonRegister" + getRandomNumber() + "@vietnam.com";
		password = "123456";
		// thực hiện tiếp các step để register với email và password bên trên
		
		
		
//		loginPage.inputToUsernameTextbox("automationeditor");
//		loginPage.clickToContinueBtn();
//		loginPage.sleepInSecond(2);
//		
//		loginPage.inputToPasswordBtn("automationfc");
//		loginPage.clickToLoginBtn();
//		loginPage.sleepInSecond(2);		

		driver.quit();
	}	


}
