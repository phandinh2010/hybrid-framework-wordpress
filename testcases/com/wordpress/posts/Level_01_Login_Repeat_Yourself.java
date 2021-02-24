package com.wordpress.posts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Level_01_Login_Repeat_Yourself {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	By usernameTb = By.id("usernameOrEmail");
	By passTb = By.id("password");
	By continueBtn = By.xpath("//button[text()='Continue']");
	By loginBtn = By.xpath("//button[text()='Log In']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://automationfc.wordpress.com/wp-admin");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// https://stackoverflow.com/questions/50820314/j
	}

	@BeforeMethod
	public void beforeMothod() {
		driver.get("https://automationfc.wordpress.com/wp-admin");
	}

	@Test
	public void Login_01_Empty_Email() {
		By emptyEmailErrorMsg = By.xpath("//span[text()='Please enter a username or email address.']");
		driver.findElement(usernameTb).sendKeys("");
		driver.findElement(continueBtn).click();
		Assert.assertTrue(driver.findElement(emptyEmailErrorMsg).isDisplayed());

	}

	@Test
	public void Login_02_Invalid_Email() {
		driver.findElement(usernameTb).sendKeys("234@#$#%#^");
		driver.findElement(continueBtn).click();
		sleepInSecond(2);

		String userNotExistMsg = driver.findElement(By.xpath("//div[@class='form-input-validation is-error']"))
				.getText().trim();
		Assert.assertEquals(userNotExistMsg, "User does not exist. Would you like to create a new account?");

		// Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form-input-validation
		// is-error' and contains(string(),'User does not exist.create a new
		// account?')]")).isDisplayed());

	}

	@Test
	public void Login_03_Username_Note_Exist() {
		driver.findElement(usernameTb).sendKeys("autotest" + getRandomNumber());
		driver.findElement(continueBtn).click();
		sleepInSecond(2);

		String userNotExistMsg = driver.findElement(By.xpath("//div[@class='form-input-validation is-error']"))
				.getText().trim();
		Assert.assertEquals(userNotExistMsg, "User does not exist. Would you like to create a new account?");
	}

	@Test
	public void Login_04_Empty_Password() {
		driver.findElement(usernameTb).sendKeys("automationeditor");
		driver.findElement(continueBtn).click();
		sleepInSecond(2);
		driver.findElement(passTb).sendKeys("");
		sleepInSecond(2);
		driver.findElement(loginBtn).click();
		sleepInSecond(2);
		Assert.assertTrue(
				driver.findElement(By.xpath("//span[text()=\"Don't forget to enter your password.\"]")).isDisplayed());
	}

	@Test
	public void Login_05_Invalid_Password() {
		driver.findElement(usernameTb).sendKeys("automationeditor");
		driver.findElement(continueBtn).click();
		sleepInSecond(2);

		driver.findElement(passTb).sendKeys("12435");
		driver.findElement(loginBtn).click();
		sleepInSecond(2);

		Assert.assertTrue(driver
				.findElement(By.xpath("//span[text()=\"Oops, that's not the right password. Please try again!\"]"))
				.isDisplayed());

	}

	@Test
	public void Login_06_Incorrect_password() {
		driver.findElement(usernameTb).sendKeys("automationeditor");
		driver.findElement(continueBtn).click();
		sleepInSecond(2);

		driver.findElement(passTb).sendKeys("124356789");
		driver.findElement(loginBtn).click();
		sleepInSecond(2);

		Assert.assertTrue(driver
				.findElement(By.xpath("//span[text()=\"Oops, that's not the right password. Please try again!\"]"))
				.isDisplayed());
	}

	@Test
	public void Login_07_Valid_Email_P() {
		driver.findElement(usernameTb).sendKeys("automationeditor");
		driver.findElement(continueBtn).click();
		sleepInSecond(2);

		driver.findElement(passTb).sendKeys("automationfc");
		driver.findElement(loginBtn).click();
		sleepInSecond(2);

		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
