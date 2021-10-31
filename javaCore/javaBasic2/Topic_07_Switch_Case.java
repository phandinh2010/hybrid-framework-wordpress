package javaBasic2;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	public Scanner sc = new Scanner(System.in);
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@Test
	// switch chỉ nhận tham số là int, string, enum
	//không dùng được với toán tử trong case: = < > != ==
	public void TC_01_Example(String browserName) {

		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.firefox.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.firefox.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			new RuntimeException("Please input the browser name!");
			break;
		}

		System.out.println(browserName);
		System.out.println(driver.toString());

		driver.quit();

	}

	@Test
	public void TC_02_Example() {
		int month = sc.nextInt();

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 10:
		case 12:
			System.out.println("Tháng này có 31 ngày");
			break;
		case 2:
			System.out.println("Tháng này có 28 ngày");
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng này có 30 ngày");
			break;
		default:
			System.out.println("Không có tháng này");
			break;
		}
	}
	
	@Test
	public void TC_03_Example() {
		int a = sc.nextInt();
		switch (a) {
		case 1:
			System.out.println("One");
		case 2:
			System.out.println("Two");
		case 3:
			System.out.println("Three");
		}
	}
	
	@Test
	public void TC_04_Example() {
		String operator = sc.nextLine();
		int a = sc.nextInt();
		int b = sc.nextInt();		
		
		switch (operator) {
		case "+":
			System.out.println("a + b =" + (a + b));
			break;
		case "-":
			System.out.println("a - b =" + (a - b));
		case "/":
			System.out.println("a / b =" + (a / b));
		}
	}
}
