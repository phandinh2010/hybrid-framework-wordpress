package javaBasic2;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	//Primitive type/value type: Nguyên thủy
	
	byte bNumber;
	short sNumber;
	int iNumber;
	long lNumber;
	float fNumber = 16.4f;
	double dNumber = 16.4d;
	
	char cChar = 'a';
	
	boolean bStatus = false;
	
	//Reference type: Tham chiếu gồm:
	
	//String
	String address = "HCM";
	
	//Array: là tập hợp các phần tử cùng kiểu dữ liệu
	String[] studentAddress = {address, "HN", "DN"};
	Integer[] studenNumber = {10, 13, 15};
	
	// Class
	Topic_02_Data_Type topic;	
	
	// Interface
	WebDriver driver;
	
	
	// Object
	Object aObject;
	
	//Collection: List, Set, Queue, Map
	
	List<WebElement> homePageLink = driver.findElements(By.className(""));
	Set<String> allWindows = driver.getWindowHandles();
	
	List<String> productName = new ArrayList<String>();
	
	public void clickToElement() {
		address.charAt(2);
	}
	
	public static void main(String[] args)	{
		
	}

}
