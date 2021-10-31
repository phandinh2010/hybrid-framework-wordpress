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

public class Level_11_Element_Undisplay extends BaseTest {
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
		driver.get(appUrl);
		loginPage = new LoginPageObject(driver);
		loginPage.inputToUsernameTextbox("automationeditor");
		loginPage.clickToContinueBtn();
		loginPage.sleepInSecond(2);
		
		loginPage.inputToPasswordBtn("automationfc");
		loginPage.clickToLoginBtn();
		loginPage.sleepInSecond(2);
		
		dashboardPage = new DashboardPageObject(driver);
		//Assert.assertTrue(dashboardPage.isDashboardHeaderTextDisplayed());

	}

	

	@Test
	public void Login_01_Element_Displayed() {
		dashboardPage.clickToScreenOptionButton();
		loginPage.sleepInSecond(3);
		Assert.assertTrue(dashboardPage.isAcitvityCheckboxDisplayed());
		
		dashboardPage.clickToScreenOptionButton();
		loginPage.sleepInSecond(3);
		Assert.assertFalse(dashboardPage.isAcitvityCheckboxDisplayed());			
	}
	
	@Test
	public void Login_02_Element_UnDisplayed_In_DOM() {
		dashboardPage.clickToScreenOptionButton();
		loginPage.sleepInSecond(2);
		
		boolean activityStatus = dashboardPage.isAcitvityCheckboxUndisplayed();
		Assert.assertTrue(activityStatus);		
	}
	
	@Test
	public void Login_03_Element_UnDisplayed_Without_DOM() {
		boolean postSearch = dashboardPage.isPostSearchTextboxUndisplay();
		Assert.assertTrue(postSearch);
		
	}	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
