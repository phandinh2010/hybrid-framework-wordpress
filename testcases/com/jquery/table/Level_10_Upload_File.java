package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;

public class Level_10_Upload_File extends BaseTest {
	WebDriver driver;
		

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);		
			
		homePage = PageGeneratorManager.getHomepage(driver);
	}
	
		
	@Test
	public void Upload_01_One_File_Per_Time() {
		String [] fileNames = {"onhousing.png"};
		
		homePage.uploadMultipleFiles(driver, fileNames);
		Assert.assertTrue(homePage.areFilenameLoadedSuccess(fileNames));
		homePage.clickToStartUploadButton();
		
		Assert.assertTrue(homePage.areFileUploadedSuccess(fileNames));
	}
	
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshPage(driver);
		String[] fileNames = {"onhousing.png", "pisces_rebrand_hero-vflpmmi4e.png", "User-Group-icon.png"};
		
		homePage.uploadMultipleFiles(driver, fileNames);
		Assert.assertTrue(homePage.areFilenameLoadedSuccess(fileNames));
		homePage.clickToStartUploadButton();
		
		Assert.assertTrue(homePage.areFileUploadedSuccess(fileNames));
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
 private HomePageObject homePage;
	
}
