package javaHN;

public class QuanHaiBaTrung {

	public static void main(String[] args) {
		
		// tạo mới 1 instance đại diện cho QuanHoanKiem
		QuanHoanKiem hoanKiem = new QuanHoanKiem();
		//System.out.println(bridge);
		System.out.println(hoanKiem.getBridge());
		
		hoanKiem.setBridge("");
		
		System.out.println(hoanKiem.getFood());
		hoanKiem.getFood();
		System.out.println(hoanKiem.getFood());
		
		hoanKiem.setFood("Nem cuốn");
		System.out.println(hoanKiem.getFood());
		
		//Biến static có thể truy cập trực tiệp từ tên class, k cần new instance
		System.out.println(QuanHoanKiem.milk);
	}

}
