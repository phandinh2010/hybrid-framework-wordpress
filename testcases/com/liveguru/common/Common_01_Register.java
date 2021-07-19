package com.liveguru.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;

public class Common_01_Register extends BaseTest {
	WebDriver driver;
	
		
//precondition
	@Parameters({"browser", "url"})
	@BeforeTest//chạy trước tất cả các class 
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);		
			
		homePage = PageGeneratorManager.getHomepage(driver);
		
		driver.quit();
	}
	
		
	@Test
	public void Upload_01_One_File_Per_Time() {
	}
	
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
 private HomePageObject homePage;
	
}
