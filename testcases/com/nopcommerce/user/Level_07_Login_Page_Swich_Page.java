package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.CustomerInforPageObject;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;

public class Level_07_Login_Page_Swich_Page extends BaseTest {
	WebDriver driver;
	String emailAddress;
	String projectLocation = System.getProperty("user.dir");
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInforPageObject cutomerInfoPage;
	//PageGeneratorManager pageGenerator;
	

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);		
			
		emailAddress = "testing" + getRandomNumber() + "@gmail.com";
		
		homePage= PageGeneratorManager.getHomePage(driver);
	}
	
	@Test
	public void User_01_Register_To_System() {
		registerPage = homePage.clickToRegisterLink();		
		
		registerPage.enterToFirstNameTextbox("test");
		registerPage.enterToLastNameTextbox("automation");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterBtn();
			
		Assert.assertTrue(registerPage.isSuccessMsgDisplay());
		homePage = registerPage.clickToLogoutLink();
		
	}

	@Test
	public void User_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();
		
		//loginPage = new LoginPageObject(driver);
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");
		homePage = loginPage.clickToLoginBtn();	
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());		
	}

	public void User_03_Customer_Infor() {
		cutomerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertEquals(cutomerInfoPage.getFirstNameTextboxValue(), "test");
		Assert.assertEquals(cutomerInfoPage.getLastNameTextboxValue(), "automation");
		Assert.assertEquals(cutomerInfoPage.getEmailTextboxValue(), emailAddress);
		
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
