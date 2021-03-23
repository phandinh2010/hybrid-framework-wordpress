package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_04_Download_Driver {
	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().driverVersion("86.0.4240.22").setup();

		driver = new ChromeDriver();
		
		driver.get("https://facebook.com");
		
		driver.quit();
	}

}
