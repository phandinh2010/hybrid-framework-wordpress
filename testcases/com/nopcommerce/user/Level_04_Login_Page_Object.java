package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.RegisterPageObject;

public class Level_04_Login_Page_Object {
	WebDriver driver;
	String emailAddress;
	String projectLocation = System.getProperty("user.dir");
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
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
			
		Assert.assertTrue(registerPage.isSuccessMsgDisplay("Your registration completed"));
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
