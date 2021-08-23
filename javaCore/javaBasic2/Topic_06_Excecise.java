package javaBasic2;

import java.util.Scanner;

import org.testng.annotations.Test;

//@Test
public class Topic_06_Excecise {
	public Scanner sc = new Scanner(System.in);

	//@Test
	public void TC_01() {

		System.out.println("Nhập số:");

		int n = sc.nextInt();

		if (n % 2 == 0) {
			System.out.println("n là số chẵn");
		} else {
			System.out.println("n là số lẻ");
		}
	}

	//@Test
	public void TC_02() {
		System.out.println("Nhập số a:");

		int a = sc.nextInt();
		
		System.out.println("Nhập số b:");

		int b = sc.nextInt();

		if (a >= b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}

	}

	@Test
	public void TC_03() {
		String A = sc.nextLine();
		String B = sc.nextLine();
		
		if (A.equals(B)) {
			System.out.println("2 nguoi cung ten");
		} else {
			System.out.println("2 nguoi khac ten");
		}
	}
	
	//@Test
	public void TC_04() {		
		
		int v = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		
		if (v > m && v > t) {
			System.out.println(v + "la so lon nhat");			
		} else if (m > v && m > t) {
			System.out.println(m + "la so lon nhat");	
		} else {
			System.out.println(t);
		}	
		
	}
	
	@Test
	public void TC_05() {	
		int i = sc.nextInt();
		if (10 <= i && i <= 100) {
			System.out.println(i + "nam trong khoang 10-100");
		} else {
			System.out.println(i + "nam khong trong khoang 10-100");
		}
	}

}
