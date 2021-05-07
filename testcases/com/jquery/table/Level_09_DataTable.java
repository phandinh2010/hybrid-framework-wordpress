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

public class Level_09_DataTable extends BaseTest {
	WebDriver driver;
		

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);		
			
		homePage = PageGeneratorManager.getHomepage(driver);
	}
	
	//@Test
	public void User_01_Paging() {
		homePage.openpageByNumber("15");	
		Assert.assertTrue(homePage.isPageActiveByNumber("15"));
		homePage.sleepInSecond(3);
		
		homePage.openpageByNumber("5");	
		Assert.assertTrue(homePage.isPageActiveByNumber("5"));
		
		homePage.openpageByNumber("7");
		Assert.assertTrue(homePage.isPageActiveByNumber("7"));
	}
	
	//@Test
	public void Table_02_Search() {
		//search by female
		homePage.inputToHearderTextboxByLabel("Females", "276880");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.areRowRecordDisplayed("276880", "Angola", "276472", "553353"));
		homePage.refreshPage(driver);
		
		//search by Country
		homePage.inputToHearderTextboxByLabel("Country", "Angola");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.areRowRecordDisplayed("276880", "Angola", "276472", "553353"));
		homePage.refreshPage(driver);
		
		//search by Males
		homePage.inputToHearderTextboxByLabel("Males", "276472");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.areRowRecordDisplayed("276880", "Angola", "276472", "553353"));
		homePage.refreshPage(driver);
		
		//Search by Total
		homePage.inputToHearderTextboxByLabel("Total", "553353");
		homePage.sleepInSecond(3);
		Assert.assertTrue(homePage.areRowRecordDisplayed("276880", "Angola", "276472", "553353"));
		homePage.refreshPage(driver);
	}
	
	//@Test
	public void Table_03_Edit_Delete() {
		
		//Delete
		homePage.clickToIconByCountryName("Afghanistan", "remove");
		homePage.sleepInSecond(3);
		
		//Delete
		homePage.clickToIconByCountryName("Angola", "remove");
		homePage.sleepInSecond(3);
		
		homePage.refreshPage(driver);
		
		//Edit
		homePage.clickToIconByCountryName("Argentina", "edit");
		homePage.sleepInSecond(3);
	}
	
		
	@Test
	public void Table_04_Edit_Delete() {
		
		homePage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.inputToTextboxByColumnNameAtRowNumber("Contact Person", "2", "Dinh testing");
		homePage.sleepInSecond(3);
		
		homePage.inputToTextboxByColumnNameAtRowNumber("Contact Person", "3", "Dinh testing");
		homePage.sleepInSecond(3);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
 private HomePageObject homePage;
	
}
