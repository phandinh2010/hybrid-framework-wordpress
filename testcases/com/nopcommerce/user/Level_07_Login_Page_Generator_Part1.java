package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.CustomerInforPageObject;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.RegisterPageObject;

public class Level_07_Login_Page_Generator_Part1 extends BaseTest {
	WebDriver driver;
	String emailAddress;
	String projectLocation = System.getProperty("user.dir");
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInforPageObject cutomerInfoPage;
	

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);		
		driver.get("https://demo.nopcommerce.com");
		
		emailAddress = "testing" + getRandomNumber() + "@gmail.com";
		
		homePage= new HomePageObject(driver);
	}
	
	@Test
	public void User_01_Register_To_System() {
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("test");
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

	public void User_03_Customer_Infor() {
		homePage.clickToMyAccountLink();
		cutomerInfoPage = new CustomerInforPageObject(driver);
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
