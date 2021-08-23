package javaBasic2;

import org.testng.annotations.Test;

public class Topic_06_Condition_If_Else {
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
		System.out.println("Hello " + str );
	}
	
	@Test
	public void TC_02() {
		float height = 7.5f;
		float width = 3.8f;
		System.out.println("Area= " + (height * width));
	}
	
}
