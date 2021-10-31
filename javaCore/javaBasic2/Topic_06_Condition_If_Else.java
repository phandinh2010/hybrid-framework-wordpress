package javaBasic2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_06_Condition_If_Else {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	public void TC_04_If_Else(String browserName) {
		
		if (browserName.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.firefox.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.firefox.driver", projectPath + "\\browserDrivers\\chrome.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("CHROME_HEADLESS")) {
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			chromeOpt.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(chromeOpt);
		} else {
			throw new RuntimeException("Please input the browser name!");
		}
		System.out.println(browserName);
		System.out.println(driver.toString());

		driver.quit();
	}

	@Test
	public void TC_01() {
		int a = 2;
		int b = 6;

		System.out.println("P1= " + (a + b));
		System.out.println("P2= " + (a - b));
		System.out.println("P3= " + (a * b));
		System.out.println("P4= " + (a / b));
	}

	@Test
	public void TC_03() {
		String str = "Automation Testing";
		System.out.println("Hello " + str);
	}

	@Test
	public void TC_02() {
		float height = 7.5f;
		float width = 3.8f;
		System.out.println("Area= " + (height * width));
	}

}
