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
import pageObject.jQuery.UploadPageObject;
import pageUIs.jQuery.UploadPageUI;

public class Level_10_Upload_File extends BaseTest {
	WebDriver driver;
	UploadPageObject uploadPage;
		

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);			
		uploadPage = PageGeneratorManager.getUploadPageObject(driver);
	}
	
		
	@Test
	public void Upload_01_One_File_Per_Time() {
		String [] fileNames = {"onhousing.png"};
		
		uploadPage.uploadFiles(fileNames);
		Assert.assertTrue(uploadPage.areFilenameLoadedSuccess(fileNames));
		uploadPage.clickToStartUploadButton();		
		Assert.assertTrue(uploadPage.areFileUploadedSuccess(fileNames));
	}
	
	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		uploadPage.refreshPage(driver);
		String[] fileNames = {"onhousing.png", "pisces_rebrand_hero-vflpmmi4e.png", "User-Group-icon.png"};		
		uploadPage.uploadFiles(fileNames);
		Assert.assertTrue(uploadPage.areFilenameLoadedSuccess(fileNames));
		uploadPage.clickToStartUploadButton();
		
		Assert.assertTrue(uploadPage.areFileUploadedSuccess(fileNames));
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	} 
	
}
