package javaBasic;

import commons.BasePage;

public class Topic_04_Dynamic_Locator extends BasePage {
	
	//1 - Click vào từng đường link ứng với mỗi locator
	public static final String ABOUT_US="//a[text()='About us']";
	public static final String PRODUCT_LINK="//a[text()='New product']";
	
	//2 - chỉ cần định nghĩa 1 locator động
	public static final String DYNAMIC_FOOTER_LINK="//a[text()='%s']";
	
	//3 - 1 locator có 2 tham số dynamic
	public static final String DYNAMIC_LINK="//a[text()='%s']";
	
	// 4 - Có 3 tham số dynamic
	
	
	
	public static void main(String[] args) {
		clickToElement(DYNAMIC_FOOTER_LINK, "About us");
		clickToElement(DYNAMIC_FOOTER_LINK, "New product");		
		
		clickToElement(DYNAMIC_LINK, "heard", "Register" );
		clickToElement(DYNAMIC_LINK, "heard", "Login" );
		
		clickToElement(DYNAMIC_LINK, "footer", "About us" );
		
	}
		
	// 1- 1 tham số động
	
	public static void clickToElement(String locator, String pageName) {		
		System.out.println(locator);
	}
	
	//2 tham số động
	public static void clickToElement(String locator, String panel, String pageName) {		
		System.out.println(locator);
	}
	
	//n tham số động
	// Tham số này phải đứng ở cuối cùng
	//Phải cùng kiểu dữ liệu khi truyền vào sử dụng
	public static void clickToElement(String locator, String... values) {		
		System.out.println(String.format(locator, (Object[]) values));
	}
}
