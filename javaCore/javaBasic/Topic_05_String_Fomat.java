package javaBasic;



public class Topic_05_String_Fomat {
	
		
	public static void main(String[] args) {
		String fullName = "Xin mời anh chị: %s";
		
		String[] khachMoi = {"Nguyễn Văn A", "Nguyễn B", "Nguyễn C"};
		
		for (String khach : khachMoi) {
		System.out.println(String.format(fullName, khach));
			
		}
		
	}

	
}
